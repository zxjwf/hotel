package com.myhotel.hotel.controller;


import com.myhotel.common.vo.JsonResult;
import com.myhotel.hotel.mapper.SysDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private SysDeptMapper sysDeptMapper;
    @RequestMapping("/doDeptListUI.do")
    public String doDeptListUI(){
        return "/pages/sys/dept_list";
    }

    @RequestMapping("doFindZTreeNodes.do")
    @ResponseBody
    public JsonResult doFindZTreeNodes(){
        return new JsonResult(sysDeptMapper.doFindZTreeNodes());
    }
}
