package com.myhotel.hotel.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {

    @RequestMapping("doLoginUI.do")
    public  String doLoginUI(){
        return "login";
    }
    @RequestMapping("doIndexUI.do")
    public String doIndexUI(){
        return "starter";
    }
    @RequestMapping("doPageUI.do")
    public String doPageUI(){
        return "/pages/common/page";
    }
}
