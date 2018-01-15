package com.github.xuejike.springboot.jkfaststart.controller.admin.view.role;

import com.bidanet.springmvc.demo.jkbuilder.annotation.JkColumn;
import com.bidanet.springmvc.demo.jkbuilder.annotation.JkTable;
import lombok.Data;

@Data
@JkTable
public class TableRole {
    @JkColumn(title = "角色名称")
    private String name;
    @JkColumn(title = "角色状态")
    private String status;


}
