package com.github.xuejike.springboot.jkfaststart.controller.admin.view.user;

import com.bidanet.springmvc.demo.jkbuilder.annotation.JkColumn;
import com.bidanet.springmvc.demo.jkbuilder.annotation.JkTable;
import com.github.xuejike.springboot.jkfaststart.domain.AdminRole;
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
 * @version $Id: AdminUs.java, v 0.1 2018-01-10 19:40:14 xuejike Exp $$
 */
@Data
@JkTable
public class AdminUserTable {

  
    private Long id;

    @JkColumn(title = "用户名")
    private String username;


    @JkColumn(title = "昵称")
    private String nickName;

    @JkColumn(title = "昵称")
    private Status status;

  
    private String role;


    private Boolean delete;

  
    private String createTime;

  
    private String updateTime;


}
