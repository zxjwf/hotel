package com.myhotel.hotel.serviceimpl;

import com.myhotel.common.vo.PageObject;
import com.myhotel.common.vo.ServiceException;
import com.myhotel.hotel.mapper.SysRoleMapper;
import com.myhotel.hotel.mapper.SysRoleMenuMapper;
import com.myhotel.hotel.mapper.SysUserRoleMapper;
import com.myhotel.hotel.pojo.SysRole;
import com.myhotel.hotel.service.SysRoleService;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static java.time.LocalDateTime.now;

@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Override
    public PageObject<SysRole> findPageObjects(String name, Integer pageCurrent) {
        if(pageCurrent==null||pageCurrent<1)
            throw new IllegalArgumentException("当前页码不正确");
        int rowCount=sysRoleMapper.getRowCount(name);
        if(rowCount==0)
            throw new ServiceException("没有记录");
        int pageSize=10;
        int startIndex=(pageCurrent-1)*pageSize;
        List<SysRole> records=sysRoleMapper.findPageObjects(name,startIndex,pageSize);
        PageObject<SysRole> pageObject=new PageObject<>();
        pageObject.setPageSize(pageCurrent);
        pageObject.setPageSize(pageSize);
        pageObject.setRowCount(rowCount);
        pageObject.setRecords(records);
        return pageObject;
    }

    @Override
    public int deleteObject(Integer id) {
        if(id==null||id<1)
            throw new ServiceException("id的值不正确,id="+id);
        int rows=sysRoleMapper.deleteObject(id);
        if(rows==0)
            throw new ServiceException("数据不存在");
        sysRoleMenuMapper.deleteObjectsByRoleId(id);
        sysUserRoleMapper.deleteObjectsByRoleId(id);
        return rows;
    }

    @Override
    public int saveObject(SysRole entity, Integer[] menuIds) {
        if(entity==null)
            throw new ServiceException("保存数据不能为空");
        if(StringUtils.isNullOrEmpty(entity.getName()))
            throw new ServiceException("角色名不能为空");
        if(menuIds==null||menuIds.length==0)
            throw new ServiceException("必须为角色赋予权限");
        entity.setCreatedTime(new Date());
        entity.setModifiedTime(new Date());
        entity.setCreatedUser("user");
        entity.setModifiedUser("user");
        int rows=sysRoleMapper.insertObject(entity);
        sysRoleMenuMapper.insertObject(entity.getId(),menuIds);
        return rows;
    }
}
