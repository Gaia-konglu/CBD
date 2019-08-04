package com.project.controller;

import com.project.bean.BackStageBean;
import com.project.bean.LoginLogBean;
import com.project.bean.RearLoginLogBean;
import com.project.service.ILoginLogService;
import com.project.service.impl.RearLogServiceImpl;
import com.project.util.UsernamePasswordByUserTypeToken;
import com.project.vo.BackStageVo;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: 周鑫
 * Date: 2018-10-16 10:12
 * Description: <描述>
 */
@Controller
public class BackStageController {

    @Autowired
    private ILoginLogService loginLogService;
    
    @Autowired
    private RearLogServiceImpl service;

    @RequestMapping("/backStage/login.do")
    public String login(BackStageVo backStageVo, Model model, @RequestHeader(name = "User-Agent") String browser, HttpSession httpsession){
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordByUserTypeToken token=new UsernamePasswordByUserTypeToken(backStageVo.getNum(),backStageVo.getPass(),"3");
        try {
            subject.login(token);
            BackStageBean backStageBean= (BackStageBean) subject.getPrincipal();
            //存入日志
            loginLogService.add(backStageBean,browser,subject.getSession().getHost());
                     
            
            //用户信息存入session
            System.out.println("后端登陆获取到的信息"+backStageBean);
            subject.getSession().setAttribute("backStageBean",backStageBean);

            
          //存入后台登录日志
            RearLoginLogBean rll = new RearLoginLogBean();
    		
            BackStageBean bean =  (BackStageBean) httpsession.getAttribute("backStageBean");
    	    String name = bean.getName();
    		rll.setName(name);
    		
    	    rll.setFlag(1);
    	    rll.setAddr("成都.武侯区");
    	   
    	    System.out.println("执行存后台登录日志");
    	    System.out.println("此时后台登录的用户名："+name);
            service.insertRegisterLog(rll);
            
            
            return "/jsp/index.jsp";
        }
        catch (UnknownAccountException e){
            model.addAttribute("loginError","账号不存在");
        }
        catch (IncorrectCredentialsException e){
            model.addAttribute("loginError","密码不正确");
        }
        catch (AuthenticationException e) {
            model.addAttribute("loginError","登陆失败");
        }
        return "/jsp/backendLogin.jsp";
    }
}
