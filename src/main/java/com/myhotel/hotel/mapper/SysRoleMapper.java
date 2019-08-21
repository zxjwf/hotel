package com.myhotel.hotel.mapper;

import com.myhotel.common.vo.CheckBox;
import com.myhotel.hotel.pojo.SysRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface SysRoleMapper {

    List<SysRole> findPageObjects(
            @Param("name") String name,
            @Param("startIndex") Integer startIndex,
            @Param("pageSize") Integer pageSize
    );

    int getRowCount(@Param("name") String name);

    int deleteObject(@Param("id") Integer id);

    int insertObject(SysRole entity);

    SysRole doFindObjectById(@Param("id") Integer id);

    int updateObject(SysRole entit);

    List<CheckBox> doFindObjects();

}
