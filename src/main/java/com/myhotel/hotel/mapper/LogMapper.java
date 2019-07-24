package com.myhotel.hotel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myhotel.hotel.pojo.SysLogs;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
//@Service
public interface LogMapper extends BaseMapper<SysLogs> {
    @Select("select * from sys_logs order by createdTime ")//limit#{startIndex},#{pageSize}
    List<SysLogs> findPageObjects();//Integer startIndex,Integer pageSize

    @Select("select count(*) from sys_logs")
    int getRowCount();

}
