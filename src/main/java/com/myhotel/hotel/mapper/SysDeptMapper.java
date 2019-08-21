package com.myhotel.hotel.mapper;

import com.myhotel.common.vo.Node;
import com.myhotel.hotel.pojo.SysDepts;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SysDeptMapper {
    SysDepts findById(Integer id);

    List<Node> doFindZTreeNodes();
}
