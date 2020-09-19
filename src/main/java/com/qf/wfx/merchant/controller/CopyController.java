package com.qf.wfx.merchant.controller;

import com.qf.wfx.merchant.Vo.LayuiVO;
import com.qf.wfx.merchant.Vo.ResultVO;
import com.qf.wfx.merchant.beans.Copy;
import com.qf.wfx.merchant.service.CopyService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/copy")
@CrossOrigin
public class CopyController {
    @Resource
    private CopyService copyService;
    @ResponseBody
    @RequestMapping("/list")
    public LayuiVO lisCopy(int page, int limit){
        List<Copy> copies = copyService.listAllCopy();
        List<Copy> pageDate = copyService.listCopyByPage(page,limit);
        LayuiVO vo = new LayuiVO(0, "success", copies.size(), pageDate);
        return vo;
    }
    @ResponseBody
    @RequestMapping(value = "/selectAll",method = RequestMethod.POST)
    public ResultVO selectAll(@RequestHeader(required = true) String token){
        Jws<Claims> jws = Jwts.parser().setSigningKey("qf123").parseClaimsJws(token);
            List<Copy> copyList = copyService.listAllCopy();
        System.out.println(copyList);
            return new ResultVO(0,"",copyList);

    }
    @ResponseBody
    @RequestMapping("/delete")
    public ResultVO delete(String copyId){
        int i = copyService.delectCopy(copyId);
        if(i>0){
            return new ResultVO(0,"删除类别信息成功！",null );
        }else{
            return new ResultVO(1,"删除类别信息失败！",null );
        }
    }
    @ResponseBody
    @RequestMapping("/update")
    public ResultVO updateCopy(Copy copy){
        int i = copyService.updateCopy(copy);
        if(i>0){
            return new ResultVO(0,"修改类别信息成功！",copy );
        }else{
            return new ResultVO(1,"修改类别信息失败！",null );
        }
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResultVO registerCopy( Copy copy){
        int i = copyService.insertCopy(copy);
        System.out.println(i);
        if (i>0){
            return new ResultVO(0,"成功");
        }else{
            return new ResultVO(1,"失败");
        }

    }
}
