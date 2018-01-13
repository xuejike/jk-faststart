package com.github.xuejike.springboot.jkfaststart.domain.type;

import com.bidanet.springmvc.demo.jkbuilder.data.JkNameValueData;

public enum PermissionType implements JkNameValueData{
    /**
     * 菜单类型
     */
    menu,
    /**
     * 按钮类型
     */
    button;

    @Override
    public String getName() {
        switch (this){
            case menu:
                return "菜单";
            case button:
                return "按钮";
                default:
                    return "未知类型";
        }
//        return null;
    }

    @Override
    public String getValue() {
        return this.name();
    }
}
