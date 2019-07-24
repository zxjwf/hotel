package com.myhotel.hotel.controller;


import com.myhotel.common.vo.JsonResult;
import com.myhotel.common.vo.PageObject;
import com.myhotel.hotel.pojo.SysLogs;
import com.myhotel.hotel.service.SyslogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/log")
public class SysLogController {
    @Autowired
    private SyslogsService syslogsService;
    @RequestMapping("/doLogListUI.do")
    public String doLogListUI(){
        return "/pages/sys/log_list";
    }

    @RequestMapping("/doFindPageObjects")
    public JsonResult doFindPageObjects(Integer pageCurrent){
        PageObject<SysLogs> pageObject=syslogsService.findPageObject();
        return new JsonResult(pageObject);
    }
}
