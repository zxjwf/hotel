package com.myhotel.hotel.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SysUserRoleMapper {
    int insertObject(@Param("userId") Integer userId,
                     @Param("roleIds") Integer[] roleIds);

    int deleteObjectsByRoleId(@Param("id") Integer id);

    List<Integer> doFindRoleIdsByUserId(Integer userId);
}
