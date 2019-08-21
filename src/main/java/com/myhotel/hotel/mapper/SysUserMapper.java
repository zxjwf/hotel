package com.myhotel.hotel.mapper;

import com.myhotel.common.vo.CheckBox;
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
    int validById(@Param("id") Integer id,
                  @Param("valid") Integer valid,
                  @Param("modifiedUser") String modifiedUser);
    int getRowCount(@Param("username") String username);

    int insertObject(SysUser entity);

}
