package com.github.xuejike.springboot.jkfaststart.service;

import com.bidanet.springmvc.demo.jkbuilder.data.JkNameValueData;
import com.github.xuejike.springboot.jkfaststart.domain.AdminPermission;
import com.github.xuejike.springboot.jkfaststart.vo.Menu;

import java.util.List;

public interface AdminPermissionService extends BaseService<AdminPermission,Long> {
    final int ROOT_ADMIN_ROLE_ID=1;
    List<Menu> getRootMenuTree(Long roleId);

    List<Menu> getSubMenu(Long pid, Long roleId);
    List<AdminPermission> listShow();
    List<JkNameValueData> getParentList();
    void delMenu(Long id);

    /**
     * 判断登录用户的角色是否是超级管理员
     * @return
     */
    boolean checkRoleByAdmin();
}
