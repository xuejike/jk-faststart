package com.github.xuejike.springboot.jkfaststart.controller.admin.view.menu;

import com.bidanet.springmvc.demo.jkbuilder.annotation.ext.JkHiddenFormField;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateMenu {
    @JkHiddenFormField
    private Long id;

    public UpdateMenu(Long id) {
        this.id = id;
    }
}
