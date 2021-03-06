package com.project.controller;

import com.project.bean.CompanyBean;
import com.project.bean.LoginLogBean;
import com.project.bean.PersonBean;
import com.project.exception.AccountExistException;
import com.project.service.ILoginLogService;
import com.project.service.IPersonService;
import com.project.util.UsernamePasswordByUserTypeToken;
import com.project.vo.PersonVo;
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
 * Date: 2018-10-15 16:42
 * Description: <描述>
 */
@Controller
public class PersonController1 {

    @Autowired
    private IPersonService personService;

    @Autowired
    private ILoginLogService loginLogService;

    @RequestMapping("/person/register.do")
    public String register(PersonVo personVo,Model model){
        System.out.println(personVo);
        try {
            personService.add(personVo);
            model.addAttribute("registerMsg","注册成功");
            return "/jsp/frontLogin.jsp";
        } catch (AccountExistException e) {
            model.addAttribute("personVo",personVo);
            model.addAttribute("registerMsg","注册失败，"+e.getMessage());
            return "/jsp/register.jsp";
        }
    }

    @RequestMapping("/person/login.do")
    public String login(PersonVo personVo, Model model, @RequestHeader(name = "User-Agent") String browser){
        Subject subject= SecurityUtils.getSubject();
        if (personVo.getRoleId()==1){
            UsernamePasswordByUserTypeToken token=new UsernamePasswordByUserTypeToken(personVo.getName(),personVo.getPassword(),"1");
            try {
                subject.login(token);
                PersonBean personBean = (PersonBean) subject.getPrincipal();
                //存入日志
                loginLogService.add(personBean,browser,subject.getSession().getHost());
                System.out.println("包租婆/抢租客登陆获取到的信息"+personBean);
                //用户信息存入session
//                subject.getSession().setAttribute("personBean",personBean);
                int roleId=personBean.getRole().getId();

        		if(roleId == 1){
        			subject.getSession().setAttribute("person", personBean);
        			return "redirect:/jsp/landLady_front_index.jsp";
        		}
        		
        		if(roleId == 2){
        			subject.getSession().setAttribute("tenant", personBean);
        			return "redirect:/jsp/tenant_front_index2.jsp";
        		}
        		
        	
               
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
            return "/jsp/frontLogin.jsp";
        }
        else if (personVo.getRoleId()==2){
            UsernamePasswordByUserTypeToken token=new UsernamePasswordByUserTypeToken(personVo.getName(),personVo.getPassword(),"2");
            try {
                subject.login(token);
                CompanyBean companyBean = (CompanyBean) subject.getPrincipal();
                //存入日志
                loginLogService.add(companyBean,browser,subject.getSession().getHost());
                System.out.println("企业用户登陆获取到的信息"+companyBean);
                //用户信息存入session
                subject.getSession().setAttribute("companyBean",companyBean);
                return "redirect:/jsp/company_front_index.jsp";
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
            return "/jsp/frontLogin.jsp";
        }
        return "/jsp/frontLogin.jsp";
    }
}
