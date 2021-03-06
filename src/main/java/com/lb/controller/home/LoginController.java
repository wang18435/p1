package com.lb.controller.home;


import com.lb.entity.LbUser;
import com.lb.mapper.LbUserMapper;
import com.lb.vo.ActiveUser;
import com.lb.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author 蓝莲花
 * @version 1.0.0
 * @ClassName LoginController.java
 * @Description TODO
 * @createTime 2020年03月25日 17:48:00
 */
@Controller
@RequestMapping("/home/user")
public class LoginController {
    @Autowired
    private LbUserMapper lbUserMapper;

    /**
     * 登录页面
     */
    @RequestMapping("/login")
    public String loginRegisterPage() {
        return "home/login&register";
    }

    /**
     * 请求登录
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseResult login(@RequestBody LbUser user, HttpSession session) {
        return lbUserMapper.checkUser(user,session);
    }

    /**
     * 注册用户
     */
    @ResponseBody
    @RequestMapping("/register")
    public ResponseResult register(@RequestBody ActiveUser activeUser){
        return lbUserMapper.registUser(activeUser);
    }

    /**
     * 安全退出
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // 清除sessin
        session.invalidate();
        return "redirect:/home/user/login";
    }
}
