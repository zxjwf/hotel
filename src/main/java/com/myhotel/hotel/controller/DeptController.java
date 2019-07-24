package com.myhotel.hotel.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dept")
public class DeptController {
    @RequestMapping("/doDeptListUI.do")
    public String doDeptListUI(){
        return "/pages/sys/dept_list";
    }
}
