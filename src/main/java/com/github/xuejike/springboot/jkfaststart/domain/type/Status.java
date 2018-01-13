package com.github.xuejike.springboot.jkfaststart.domain.type;

public enum Status {
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
//        return super.toString();
    }
}
