package com.github.xuejike.springboot.jkfaststart.domain;

import lombok.Data;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
//@Entity(name = "sys_admin_role_permission_set")
public class AdminPermissionRole {

    private Long roleId;

    private Long permissionId;
}
