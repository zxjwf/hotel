package com.myhotel.hotel.service;

import com.myhotel.common.vo.Node;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SysMenuService {

    List<Node> findZtreeMenuNodes();
}
