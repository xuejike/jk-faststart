package com.github.xuejike.springboot.jkfaststart.service;

import com.github.xuejike.springboot.jkfaststart.domain.AdminPermission;
import com.github.xuejike.springboot.jkfaststart.service.impl.BaseServiceImpl;
import com.github.xuejike.springboot.jkfaststart.vo.Menu;

import java.util.List;

public interface AdminPermissionService extends BaseService<AdminPermission,Long> {
    List<Menu> getRootMenuTree();

    List<Menu> getSubMenu(Long pid);
}
