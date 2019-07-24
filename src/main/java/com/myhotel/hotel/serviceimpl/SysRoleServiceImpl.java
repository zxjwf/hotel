package com.myhotel.hotel.serviceimpl;

import com.myhotel.common.vo.PageObject;
import com.myhotel.common.vo.ServiceException;
import com.myhotel.hotel.mapper.SysRoleMapper;
import com.myhotel.hotel.pojo.SysRole;
import com.myhotel.hotel.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Override
    public PageObject<SysRole> findPageObjects(String name, Integer pageCurrent) {
        if(pageCurrent==null||pageCurrent<1)
            throw new IllegalArgumentException("当前页码不正确");
        int rowCount=sysRoleMapper.getRowCount(name);
        if(rowCount==0)
            throw new ServiceException("没有记录");
        int pageSize=2;
        int startIndex=(pageCurrent-1)*pageSize;
        List<SysRole> records=sysRoleMapper.findPageObjects(name,startIndex,pageSize);
        PageObject<SysRole> pageObject=new PageObject<>();
        pageObject.setPageSize(pageCurrent);
        pageObject.setPageSize(pageSize);
        pageObject.setRowCount(rowCount);
        pageObject.setRecords(records);
        return pageObject;
    }
}
