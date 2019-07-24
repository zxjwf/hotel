package com.myhotel.hotel.controller;


import com.myhotel.common.vo.JsonResult;
import com.myhotel.common.vo.PageObject;
import com.myhotel.hotel.pojo.SysRole;
import com.myhotel.hotel.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/role/")

public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping("doRoleListUI.do")
    public String doRoleListUI(){
        return "pages/sys/role_list";
    }
    @RequestMapping("doFindPageObjects.do")
    @ResponseBody
    public JsonResult doFindPageObjects(String name,Integer pageCurrent){

        PageObject<SysRole> pageObject=sysRoleService.findPageObjects(name,pageCurrent);
        return new JsonResult(pageObject);
    }

}
