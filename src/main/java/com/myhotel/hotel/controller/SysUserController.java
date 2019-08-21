package com.myhotel.hotel.controller;

import com.myhotel.common.vo.JsonResult;
import com.myhotel.common.vo.PageObject;
import com.myhotel.common.vo.ServiceException;
import com.myhotel.hotel.mapper.SysUserMapper;
import com.myhotel.hotel.pojo.SysUserDeptResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.jar.JarEntry;

@Controller
@RequestMapping("/user/")
public class SysUserController {
    @Autowired
    private SysUserMapper sysUserMapper;
    @RequestMapping("doUserListUI.do")
    public String doUserListUI(){
        return "/pages/sys/user_list";
    }
    @RequestMapping("doFindPageObjects.do")
    @ResponseBody
    public JsonResult doFindPageObjects(String username,Integer pageCurrent)
    {
        if(pageCurrent==null||pageCurrent<=0)
            throw new ServiceException("参数不合法");
        int rowCount=sysUserMapper.getRowCount(username);
        if(rowCount==0)
            throw new ServiceException("记录不存在");
        int pageSize=10;
        int startIndex=(pageCurrent-1)*pageSize;
        List<SysUserDeptResult>  records=sysUserMapper.doFindPageObjects(username,startIndex,pageSize);
        PageObject<SysUserDeptResult> pageObject = new PageObject<>();
        pageObject.setPageCurrent(pageCurrent);
        pageObject.setRowCount(rowCount);
        pageObject.setPageSize(pageSize);
        pageObject.setRecords(records);

        return new JsonResult(pageObject);
    }
}
