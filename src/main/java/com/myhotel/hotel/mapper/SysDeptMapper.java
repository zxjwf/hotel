package com.myhotel.hotel.mapper;

import com.myhotel.hotel.pojo.SysDepts;
import org.springframework.stereotype.Service;

@Service
public interface SysDeptMapper {
    SysDepts findById(Integer id);
}
