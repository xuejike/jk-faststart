package com.github.xuejike.springboot.jkfaststart.service;

import com.bidanet.springmvc.demo.jkbuilder.data.JkNameValueData;
import com.github.xuejike.springboot.jkfaststart.domain.AdminPermission;
import com.github.xuejike.springboot.jkfaststart.vo.Menu;

import java.util.List;

public interface AdminPermissionService extends BaseService<AdminPermission,Long> {
    List<Menu> getRootMenuTree(Long roleId);

    List<Menu> getSubMenu(Long pid, Long roleId);
    List<AdminPermission> listShow();
    List<JkNameValueData> getParentList();
    void delMenu(Long id);
}
