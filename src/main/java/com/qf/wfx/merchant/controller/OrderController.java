package com.qf.wfx.merchant.controller;

import com.github.wxpay.sdk.WXPay;
import com.qf.wfx.merchant.Vo.LayuiVO;
import com.qf.wfx.merchant.Vo.MyConfig;
import com.qf.wfx.merchant.Vo.NumVo;
import com.qf.wfx.merchant.Vo.ResultVO;
import com.qf.wfx.merchant.beans.Good;
import com.qf.wfx.merchant.beans.Order;
import com.qf.wfx.merchant.service.GoodService;
import com.qf.wfx.merchant.service.OrderService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
    @Resource
    private OrderService orderService;
    @Resource
    private GoodService goodService;
    @RequestMapping(value = "/list")
    public LayuiVO listOrderByCustomerId(int page, int limit, @RequestHeader(required = true) String token) {

        // 验证token
        Jws<Claims> jws = Jwts.parser().setSigningKey("qf123").parseClaimsJws(token);
        // 获取解析的token中的用户名、id等
        String customerId = jws.getBody().getId();
        List<Order> orders = orderService.listAllOrder(customerId);
        List<Order> pageDate = orderService.selectOrderByCustomerId(customerId,page,limit);

        System.out.println(orders);

        for (Order orders1:pageDate) {
            System.out.println(orders1);
        }
        return new LayuiVO(0,"查询成功",orders.size(),pageDate);
    }
    @RequestMapping(value = "/list1")
    public LayuiVO listOrderByType(int page, int limit, @RequestHeader(required = true) String token) {

        // 验证token
        Jws<Claims> jws = Jwts.parser().setSigningKey("qf123").parseClaimsJws(token);
        // 获取解析的token中的用户名、id等
        String customerId = jws.getBody().getId();
        List<Order> orders = orderService.listAllOrder(customerId);
        List<Order> pageDate = orderService.selectOrderByCustomerId(customerId,page,limit);

        System.out.println(orders);

        for (Order orders1:pageDate) {
            System.out.println(orders1);
        }
        return new LayuiVO(0,"查询成功",orders.size(),pageDate);
    }

    @ResponseBody
    @RequestMapping("/update")
    public ResultVO updateOrder(Order order){
        int i = orderService.updateOrder(order);
        if(i>0){
            return new ResultVO(0,"修改类别信息成功！",null );
        }else{
            return new ResultVO(1,"修改类别信息失败！",null );
        }
    }
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResultVO addOrder(Order order) throws Exception {
        String orderId = NumVo.getRandomCode(8)+"";
        order.setOrderId(orderId);
        System.out.println(order);
        int i = orderService.insertOrder(order);
        Good good = goodService.selectGoodById(order.getGoodId());
        WXPay wxPay = new WXPay(new MyConfig());
        Map<String, String> data = new HashMap<>();
        System.out.println(good.getGoodName());
        data.put("body", good.getGoodName());
        data.put("out_trade_no", orderId);
        data.put("device_info", "");
        data.put("fee_type", "CNY");
        data.put("total_fee", "1");
        data.put("spbill_create_ip", "123.12.12.123");
        data.put("notify_url", " http://yueliang.free.idcfengye.com/pay/callback");
        data.put("trade_type", "NATIVE");  // 此处指定为扫码支付
        data.put("product_id", "12");
        Map<String, String> resp = wxPay.unifiedOrder(data);
        String payUrl = resp.get("code_url");

        //3. 将支付短连接传递到前端
        return new ResultVO(0,payUrl,orderId);
    }
}
