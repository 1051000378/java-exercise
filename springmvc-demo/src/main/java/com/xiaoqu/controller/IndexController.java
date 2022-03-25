package com.xiaoqu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @RequestMapping(value = "/index/login",method = RequestMethod.GET,params = "username")
    public String login(@RequestParam String username){
        return "login";
    }

    @RequestMapping(value = "/index/register")
    public String register(){
        return "register";
    }


}
