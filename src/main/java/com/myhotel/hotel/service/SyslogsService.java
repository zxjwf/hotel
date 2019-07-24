package com.myhotel.hotel.service;

import com.myhotel.common.vo.PageObject;
import com.myhotel.hotel.pojo.SysLogs;

public interface SyslogsService {
    PageObject<SysLogs> findPageObject();//Integer pageCurrent

}
