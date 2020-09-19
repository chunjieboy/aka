package com.qf.wfx.merchant.controller;

import com.qf.wfx.merchant.Vo.ResultVO;
import com.qf.wfx.merchant.beans.Customer;
import com.qf.wfx.merchant.service.CustomerService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Resource
    private CustomerService customerService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ResultVO login(String loginName,String loginPwd){
        Customer customer = customerService.login(loginName, loginPwd);
        if (customer!=null){
            String token = Jwts.builder()
                    .setSubject(loginName)   //设置用户信息
                    .setId(customer.getCustomerId())            //设置用户ID
                    .setIssuedAt(new Date()) //设置token的创建时间
                    .setExpiration(new Date(System.currentTimeMillis() + 3000000))  //设置过期时间
                    .signWith(SignatureAlgorithm.HS256,"qf123")
                    .compact();

            return new ResultVO(0,token);
        }else {
            return new ResultVO(1,"失败");
        }
    }

}
