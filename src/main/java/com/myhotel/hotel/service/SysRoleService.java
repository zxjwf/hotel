package com.myhotel.hotel.service;

import com.myhotel.common.vo.PageObject;
import com.myhotel.hotel.pojo.SysRole;

public interface SysRoleService {
    PageObject<SysRole> findPageObjects(String name,Integer pageCurrent);
}