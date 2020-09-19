package com.qf.wfx.merchant.controller;

import com.qf.wfx.merchant.Vo.LayuiVO;
import com.qf.wfx.merchant.Vo.NumVo;
import com.qf.wfx.merchant.Vo.ResultVO;
import com.qf.wfx.merchant.beans.Good;
import com.qf.wfx.merchant.service.GoodService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/good")
@CrossOrigin
public class GoodController {
    @Resource
    private GoodService goodService;


    @RequestMapping(value = "/list")
    public LayuiVO listGoodByCustomerId(int page, int limit, @RequestHeader(required = true) String token) {

        // 验证token
        Jws<Claims> jws = Jwts.parser().setSigningKey("qf123").parseClaimsJws(token);
        // 获取解析的token中的用户名、id等
        String customerId = jws.getBody().getId();
        System.out.println("解析后的id："+customerId);
        List<Good> goods = goodService.listAllGoods(customerId);
        List<Good> pageDate = goodService.selectGoodListByCustomerId(customerId,page,limit);
        System.out.println(goods);
            return new LayuiVO(0,"查询成功",goods.size(),pageDate);

    }

    @RequestMapping(value = "/delete")
    public ResultVO delete(String goodId ){
//        Jws<Claims> jws = Jwts.parser().setSigningKey("qf123").parseClaimsJws(token);
        int i = goodService.delectGood(goodId);
        if(i>0){
            return new ResultVO(0,"删除成功！",null );
        }else{
            return new ResultVO(1,"删除失败！",null );
        }
    }

    @RequestMapping(value = "/update")
    public ResultVO updateGood(Good good){
        System.out.println(good);
        int i = goodService.updateGood(good);
        if(i>0){
            return new ResultVO(0,"修改类别信息成功！",good );
        }else{
            return new ResultVO(1,"修改类别信息失败！",null );
        }
    }
    @ResponseBody
    @RequestMapping("/add")
    public ResultVO goodAdd(@RequestHeader(required = false) String token,
                            @RequestParam String goodName,
                            @RequestParam String typeId,
                            @RequestParam String goodPic1,
                            @RequestParam String goodPic2,
                            @RequestParam String goodPic3,
                            @RequestParam String promoteDesc,
                            @RequestParam String copyId){

                JwtParser parser = Jwts.parser();
                parser.setSigningKey("qf123");
                Jws<Claims> jws = parser.parseClaimsJws(token);
                //获取的解析的token中的用户名
                String cid = jws.getBody().getId();
                System.out.println(cid);
                String gid = NumVo.getRandomCode(8)+"";
                System.out.println(gid);
                Good good = new Good(gid,goodName,cid,goodPic1,goodPic2,goodPic3,promoteDesc,typeId);
//                String s = String.valueOf(System.currentTimeMillis());
//                good.setGoodId(s);


                int i = goodService.insertGood(good);
                System.out.println(i);
                if (1>0){
                    return new ResultVO(0,"添加成功",null);
                }else{
                    return new ResultVO(1,"添加失败",null);
                }

    }
    @ResponseBody
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public ResultVO upload(MultipartFile file){
        String fileName = System.currentTimeMillis()+file.getOriginalFilename();
        try {
            FTPClient ftpClient = new FTPClient();
            ftpClient.connect("39.101.201.200",21);
            boolean state = ftpClient.login("root", "HLJ20000116.");
            int replyCode = ftpClient.getReplyCode();

            //如果响应码在200到299之间，表示与FTP站点的连接是成功的
            if(FTPReply.isPositiveCompletion(replyCode)){

                //设置编码UTF-8
                ftpClient.setControlEncoding("UTF-8");
                //设置被动模式（腾讯云必须添加，其他云待测试）
                ftpClient.enterLocalPassiveMode();

                //a.设置接收文件类型为二进制文件
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                //b.在服务器上创建images文件夹
                //ftpClient.makeDirectory("images");
                //c.切换进入到images文件夹
                ftpClient.changeWorkingDirectory("/usr/local/webserver/nginx/resource/imgs");
                //d.将文件上传到ftp服务器
                InputStream inputStream = file.getInputStream();
                boolean b = ftpClient.storeFile(fileName, inputStream);

                inputStream.close();
                //2.退出登录
                ftpClient.logout();
                return new  ResultVO(0,"http://39.101.201.200/imgs/"+fileName);
            }else{
                return  new ResultVO(1,"fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return  new ResultVO(1,"fail");
        }
    }
    @RequestMapping(value = "/mlist", method = RequestMethod.GET)
    public ResultVO listGoods(int page,int limit,@RequestHeader(required = true) String token) {

        int start = (page - 1) * limit;   // 从第几行开始查
        // 验证token
        Jws<Claims> jws = Jwts.parser().setSigningKey("qf123").parseClaimsJws(token);
        // 获取解析的token中的用户名、id等
        List<Good> goods = goodService.selectGoodList(start,limit);
        if (goods != null) {
            return new ResultVO(0,"查询成功",goods);
        } else {
            return new ResultVO(1,"查询失败",null);
        }
    }


    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResultVO searchGoods(String keyword,int page,int limit,@RequestHeader(required = true) String token) {

        int start = (page - 1) * limit;   // 从第几行开始查
        // 验证token
        Jws<Claims> jws = Jwts.parser().setSigningKey("qf123").parseClaimsJws(token);
        List<Good> goods = goodService.searchGoods(keyword,start,limit);
        if (goods != null) {
            return new ResultVO(0,"查询成功",goods);
        } else {
            return new ResultVO(1,"查询失败",null);
        }
    }
    @RequestMapping(value = "/getGood", method = RequestMethod.GET)
    public ResultVO getGoods(String goodId) {
        Good good = goodService.selectGoodById(goodId);
        if (good != null) {
            return new ResultVO(0,"查询成功",good);
        } else {
            return new ResultVO(1,"查询失败",null);
        }
    }
}
