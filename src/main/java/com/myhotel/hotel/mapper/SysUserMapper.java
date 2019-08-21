package com.myhotel.hotel.mapper;

import com.myhotel.hotel.pojo.SysUser;
import com.myhotel.hotel.pojo.SysUserDeptResult;
import org.apache.ibatis.annotations.Param;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SysUserMapper {
    List<SysUserDeptResult> doFindPageObjects(
            @Param("username") String username,
            @Param("startIndex") Integer startIndex,
            @Param("pageSize") Integer pageSize);

    int getRowCount(@Param("username") String username);
}
