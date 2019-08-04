package com.project.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.config.AlipayConfig;
import com.project.bean.BookInforBean;
import com.project.util.RandomUtil;

@Controller
public class AliPay {

    @RequestMapping(value=("aliPay.do"),method=RequestMethod.POST)
    public void aliPay(String order,Double price,String carNum,String addr,HttpServletRequest request, HttpServletResponse response) throws IOException {
    	System.out.println(order);
    	System.out.println(price);
    	System.out.println(addr+carNum);
    	//获得初始化的AlipayClient
    	 AlipayClient alipayClient= AlipayConfig.getAlipayClient();
    	 //创建API对应的request
    	 AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
    	//在公共参数中设置回跳和通知地址
    	    alipayRequest.setReturnUrl(AlipayConfig.return_url);
    	    alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
    	    //填充业务参数
    	    alipayRequest.setBizContent("{" +
    	    //商户订单号，64个字符以内、可包含字母、数字、下划线(必填);
    	    "    \"out_trade_no\":\""+order+"\"," +		
    	    //销售产品码,目前仅支持FAST_INSTANT_TRADE_PAY（必填）
    	        "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
    	    //订单总额（必填）
    	        "    \"total_amount\":"+price+"," +
    	        //订单标题（必填）
    	        "    \"subject\":\""+carNum+"\"," +
    	        //订单描述（选填）
    	        "    \"body\":\""+addr+"\"," +
    	        //公用回传参数（选填）
    	        "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
    	       //业务扩展参数
    	        "    \"extend_params\":{" +
    	       //系统商编号，该参数作为系统商返佣数据提取的依据，请填写系统商签约协议的PID
    	        "    \"sys_service_provider_id\":\"2088102176558650\"" +
    	        "    }"+
    	        "  }");
    	    
    	    String form="";
    	    
    	    try {
    	    	//调用SDK生成表单
    	        form = alipayClient.pageExecute(alipayRequest).getBody(); 

    	        System.out.println(form);
    	    } catch (AlipayApiException e) {
    	        e.printStackTrace();
    	    }
    	    
    	    response.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
    	    
    	    //直接将完整的表单html输出到页面
    	    response.getWriter().write(form);
    	    response.getWriter().flush();
    	    response.getWriter().close();
    }
}
