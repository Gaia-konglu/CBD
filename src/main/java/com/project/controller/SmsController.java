package com.project.controller;

import com.project.bean.CompanyBean;
import com.project.bean.PersonBean;
import com.project.service.ICompanyService;
import com.project.service.IPersonService;
import com.project.util.HttpClientUtils;
import com.project.util.ResponseResult;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Author: 周鑫
 * Date: 2018-10-16 0:43
 * Description: <描述>
 */
@Controller
public class SmsController {

    @Autowired
    private IPersonService personService;

    @Autowired
    private ICompanyService companyService;

    private String url="http://v.juhe.cn/sms/send";

   
    private String key="7f6f72c156231938bfa82ff1d875455c";

   
    private String tplId="106388";

  
    private String tplValue="%23code%23%3d";

    @RequestMapping("/sms/sendVerificationCode.do")
    @ResponseBody
    public ResponseResult sendVerificationCode(String phone,Integer roleId, HttpSession session){
        PersonBean personBean=null;
        CompanyBean companyBean=null;
        if (roleId==1){
            personBean=personService.findByName(phone);
        }
        if (roleId==2){
            companyBean=companyService.findByName(phone);
        }
        if (personBean!=null||companyBean!=null){
            try {
                //生成随机六位数
                Random random = new Random();
                String randomVerificationCode="";
                for (int i=0;i<6;i++)
                {
                    randomVerificationCode+=random.nextInt(10);
                }
                System.out.println(randomVerificationCode);
                session.setAttribute("verificationCode",randomVerificationCode);
                //服务器端发送验证码
                Map<String,String> params=new HashMap<>();
                params.put("key",key);
                params.put("tpl_id",tplId);
                params.put("tpl_value",tplValue+randomVerificationCode);
                params.put("mobile",phone);
                System.out.println(url+" "+key+" "+tplId+" "+tplValue);
               String result= HttpClientUtils.doPost(url,params);
                System.out.println(result);
                return ResponseResult.success("验证码发送成功");
            }
            catch (Exception ex){
                return ResponseResult.success("验证码发送失败");
            }
        }
        return ResponseResult.fail("账号不存在，请注册");
    }

    @RequestMapping("sms/checkVerificationCode.do")
    @ResponseBody
    public Map<String,Object> checkVerificationCode(String verificationCode,HttpSession session){
        Map<String,Object> map=new HashMap<>();
        String realVerificationCode= (String) session.getAttribute("verificationCode");
        if (realVerificationCode.equals(verificationCode)){
            map.put("valid",true);
        }
        else {
            map.put("valid",false);
        }
        return map;
    }
    @RequestMapping("sessionColse.do")
    public String sessionclose(){
    	System.out.println("关闭session");
    	SecurityUtils.getSubject().logout();
		return "redirect:/jsp/frontLogin.jsp";
    }
    
}
