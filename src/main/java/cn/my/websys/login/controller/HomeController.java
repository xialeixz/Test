package cn.my.websys.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by jasonxxia on 2016/10/22.
 */
@Controller
public class HomeController {

    @RequestMapping("index")
    public ModelAndView index(){
        //创建模型跟视图，用于渲染页面。并且指定要返回的页面为home页面
        ModelAndView mav = new ModelAndView("home");
        return mav;
    }

    @RequestMapping(value="login",method= RequestMethod.POST)
    public ModelAndView login(String username,String password,HttpServletRequest request){
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        return new ModelAndView("succ");
    }
}