package com.myhotel.hotel.serviceimpl;

import com.myhotel.common.vo.PageObject;
import com.myhotel.common.vo.ServiceException;
import com.myhotel.hotel.mapper.LogMapper;
import com.myhotel.hotel.pojo.SysLogs;
import com.myhotel.hotel.service.SyslogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysLogsServiceImpl implements SyslogsService {
    @Autowired
    private LogMapper sysLogMapper;

    @Override
    public PageObject<SysLogs> findPageObject() {
        List<SysLogs> records=sysLogMapper.findPageObjects();
        PageObject<SysLogs> pageObject=new PageObject<>();
        /*pageObject.setPageCurrent(pageCurrent);
        pageObject.setPageSize(pageSize);
        pageObject.setRowCount(rowCount);*/
        pageObject.setRecords(records);

        return pageObject;
    }

    /* @Override
    public PageObject<SysLogs> findPageObject( Integer pageCurrent) {
        if(pageCurrent==null||pageCurrent<1)throw new IllegalArgumentException("当前页码不存在");

        int rowCount=sysLogMapper.getRowCount();
        if(rowCount==0){
            throw new ServiceException("系统没有查到对应的记录");
        }
        int pageSize=2;
        int startIndex=(pageCurrent-1)*pageSize;
        List<SysLogs> records=sysLogMapper.findPageObjects(startIndex,pageSize);
        PageObject<SysLogs> pageObject=new PageObject<>();
        pageObject.setPageCurrent(pageCurrent);
        pageObject.setPageSize(pageSize);
        pageObject.setRowCount(rowCount);
        pageObject.setRecords(records);

        return pageObject;
    }*/
}
