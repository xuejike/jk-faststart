package com.github.xuejike.springboot.jkfaststart.controller.admin.view.user;

import com.bidanet.springmvc.demo.jkbuilder.annotation.JkDataSource;
import com.bidanet.springmvc.demo.jkbuilder.annotation.JkTitle;
import com.bidanet.springmvc.demo.jkbuilder.annotation.ext.JkSelectFormField;
import com.bidanet.springmvc.demo.jkbuilder.annotation.type.JkSourceType;
import com.github.xuejike.springboot.jkfaststart.domain.type.Status;
import lombok.Data;

@Data
public class UpdateAdminUser {

    @JkTitle("状态")
    @JkSelectFormField
    @JkDataSource(type = JkSourceType.enumType)
    private Status status;
}
