package com.github.xuejike.springboot.jkfaststart.controller.admin.view.user;

import com.bidanet.springmvc.demo.jkbuilder.annotation.JkColumn;
import com.bidanet.springmvc.demo.jkbuilder.annotation.JkTable;
import com.github.xuejike.springboot.jkfaststart.domain.AdminRole;
import com.github.xuejike.springboot.jkfaststart.domain.AdminUser;
import com.github.xuejike.springboot.jkfaststart.domain.type.Status;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author xuejike
 * @version $Id: AdminUserTableConverter.java, v 0.1 2018-01-10 19:48:09 xuejike Exp $$
 */
public class AdminUserTableConverter {

    /**
     * Convert AdminUser to AdminUserTable
     * @param adminUser
     * @return
     */
    public static AdminUserTable convertToAdminUserTable(AdminUser adminUser) {
        if (adminUser == null) {
            return null;
        }
        AdminUserTable adminUserTable = new AdminUserTable();

        adminUserTable.setId(adminUser.getId());
        adminUserTable.setNickName(adminUser.getNickName());
        adminUserTable.setUsername(adminUser.getUsername());
        adminUserTable.setRole(adminUser.getAdminRole().getName());
        adminUserTable.setStatus(adminUser.getStatus().toString());
        adminUserTable.setCreateTime(adminUser.getCreateTime().toString("yyyy-MM-dd"));
        adminUserTable.setUpdateTime(adminUser.getUpdateTime().toString("yyyy-MM-dd"));

        return adminUserTable;
    }

}
