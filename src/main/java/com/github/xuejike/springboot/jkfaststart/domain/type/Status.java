package com.github.xuejike.springboot.jkfaststart.domain.type;

import com.bidanet.springmvc.demo.jkbuilder.data.JkNameValueData;

public enum Status implements JkNameValueData {
    open,close;

    @Override
    public String toString() {
        switch (this){
            case open:
                return "正常";
            case close:
                return "禁用";
                default:
                    return super.toString();
        }
    }

    @Override
    public String getName() {
        return toString();
    }

    @Override
    public String getValue() {
        return name();
    }
}
