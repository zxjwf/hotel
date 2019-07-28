package com.myhotel.hotel.mapper;

import com.myhotel.common.vo.Node;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface SysMenuMapper {
    List<Node> findZtreeMenuNodes();
}
