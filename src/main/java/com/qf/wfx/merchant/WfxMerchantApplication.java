package com.qf.wfx.merchant;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@SpringBootApplication
@MapperScan(basePackages = "com.qf.wfx.merchant.dao")
public class WfxMerchantApplication {

	public static void main(String[] args) {
		SpringApplication.run(WfxMerchantApplication.class, args);
	}
	@Bean
	public ServerEndpointExporter serverEndpointExporter(){
		return new ServerEndpointExporter();
	}
}
