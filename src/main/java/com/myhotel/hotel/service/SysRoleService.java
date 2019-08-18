package com.myhotel.hotel.service;

import com.myhotel.common.vo.PageObject;
import com.myhotel.hotel.pojo.SysRole;

import java.util.Map;

public interface SysRoleService {
    PageObject<SysRole> findPageObjects(String name,Integer pageCurrent);

    int deleteObject(Integer id);

    int saveObject(SysRole entity,Integer[] menuIds);

    Map<String,Object> doFindObjectById(Integer id);

    int updateObject(SysRole entity,Integer[] menuIds);
}
