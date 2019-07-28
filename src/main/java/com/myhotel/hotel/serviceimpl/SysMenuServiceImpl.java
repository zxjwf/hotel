package com.myhotel.hotel.serviceimpl;

import com.myhotel.common.vo.Node;
import com.myhotel.hotel.mapper.SysMenuMapper;
import com.myhotel.hotel.mapper.SysRoleMenuMapper;
import com.myhotel.hotel.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysMenuServiceImpl  implements SysMenuService {
    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Override
    public List<Node> findZtreeMenuNodes() {
        return sysMenuMapper.findZtreeMenuNodes();
    }
}
