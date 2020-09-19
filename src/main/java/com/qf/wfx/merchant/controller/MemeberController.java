package com.qf.wfx.merchant.controller;

import com.qf.wfx.merchant.Vo.ResultVO;
import com.qf.wfx.merchant.beans.Memeber;
import com.qf.wfx.merchant.service.MemeberService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/memeber")
@CrossOrigin
public class MemeberController {
    @Resource
    private MemeberService memeberService;
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ResultVO login(String account, String password){
        Memeber memeber = memeberService.login(account, password);
        if (memeber!=null){
            String token = Jwts.builder()
                    .setSubject(account)   //设置用户信息
                    .setId(memeber.getMemeberId())            //设置用户ID
                    .setIssuedAt(new Date()) //设置token的创建时间
                    .setExpiration(new Date(System.currentTimeMillis() + 3000000))  //设置过期时间
                    .signWith(SignatureAlgorithm.HS256,"qf123")
                    .compact();

            return new ResultVO(0,token);
        }else {
            return new ResultVO(1,"失败");
        }
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ResultVO registerMember( Memeber memeber){
        int i = memeberService.register(memeber);
        System.out.println(i);
        if (i>0){
            return new ResultVO(0,"成功");
        }else{
            return new ResultVO(1,"失败");
        }

    }
}
