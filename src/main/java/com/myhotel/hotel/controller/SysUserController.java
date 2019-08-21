package com.myhotel.hotel.controller;

import com.myhotel.common.vo.JsonResult;
import com.myhotel.common.vo.PageObject;
import com.myhotel.common.vo.ServiceException;
import com.myhotel.hotel.mapper.SysUserMapper;
import com.myhotel.hotel.mapper.SysUserRoleMapper;
import com.myhotel.hotel.pojo.SysUser;
import com.myhotel.hotel.pojo.SysUserDeptResult;
import com.mysql.jdbc.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.SimpleTimeZone;
import java.util.UUID;
import java.util.jar.JarEntry;

@Controller
@RequestMapping("/user/")
public class SysUserController {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
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
    @RequestMapping("doValidById.do")
    @ResponseBody
    public JsonResult validById(Integer id,Integer valid,String modifiedUser){
        if(id==null||id<=0)
            throw new ServiceException("参数id不合法");
        if(valid!=1&&valid!=0)
            throw new ServiceException("参数valid不合法");
       /* if(StringUtils.isNullOrEmpty(modifiedUser))
            throw  new ServiceException("修改用户名不能为空");*/
        int rows=0;

            try{
                String modifiedUsers="sys";
                rows=sysUserMapper.validById(id,valid,modifiedUsers);
            }catch(Throwable e){
                e.printStackTrace();
        }
            if (rows==0)
                throw  new ServiceException("此记录可能不存在");

        return new JsonResult("update ok");
    }
    @RequestMapping("doUserEditUI.do")
    public String doUserEditUI(){
        return "pages/sys/user_edit";
    }

    @RequestMapping("doSaveObject.do")
    @ResponseBody
    public JsonResult doSaveObject(
                SysUser entity,
                Integer[] roleIds
    ){
        if (entity==null)
            throw new ServiceException("保存对象不能为空");
        if(StringUtils.isNullOrEmpty(entity.getUserName()))
            throw  new ServiceException("用户名不能为空");
        if (StringUtils.isNullOrEmpty(entity.getPassword()))
            throw new ServiceException("密码不能为空");
        if (roleIds==null||roleIds.length==0)
            throw new ServiceException("至少要为用户分配角色");
        String salt= UUID.randomUUID().toString();
        entity.setSalt(salt);
        SimpleHash sHash=new SimpleHash("MD5",entity.getPassword(),salt);
        entity.setPassword(sHash.toString());
        int row=sysUserMapper.insertObject(entity);
        sysUserRoleMapper.insertObject(entity.getId(),roleIds);
        return  new JsonResult("save ok");
    }
}
