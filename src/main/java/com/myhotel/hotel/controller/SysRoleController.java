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

import java.util.Map;

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
    @RequestMapping("doDeleteObject.do")
    @ResponseBody
    public JsonResult doDeleteObject(Integer id){
        sysRoleService.deleteObject(id);
        return  new JsonResult("delete Ok");
    }
    @RequestMapping("doRoleEditUI.do")
    public String doRoleEditUI(){
        return "pages/sys/role_edit";
    }


    @RequestMapping("doSaveObject.do")
    @ResponseBody
    public JsonResult doSaveObject(SysRole entity,Integer[] menuIds){

        sysRoleService.saveObject(entity,menuIds);
        return new JsonResult("save ok");

    }

    @RequestMapping("doFindObjectById.do")
    @ResponseBody
    public JsonResult doFindObjectById(Integer id){
        Map<String,Object> map=sysRoleService.doFindObjectById(id);
        return new JsonResult(map);
    }
    @RequestMapping("doUpdateObject.do")
    @ResponseBody
    public JsonResult doUpdateObject(
            SysRole entity,
            Integer[] menuIds){
        sysRoleService.updateObject(entity,menuIds);
        return  new JsonResult("update ok");
    }
}
