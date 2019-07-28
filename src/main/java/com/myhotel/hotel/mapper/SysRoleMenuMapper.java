package com.myhotel.hotel.mapper;

import com.myhotel.common.vo.Node;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SysRoleMenuMapper {
    int deleteObjectsByRoleId(@Param("id") Integer id);

    int insertObject(
            @Param("roleId") Integer roleId,
            @Param("menuIds") Integer[] menuIds
    );



}
