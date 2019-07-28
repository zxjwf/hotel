package com.myhotel.hotel.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface SysUserRoleMapper {

    int deleteObjectsByRoleId(@Param("id") Integer id);
}
