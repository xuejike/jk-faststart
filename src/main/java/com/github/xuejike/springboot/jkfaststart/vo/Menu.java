package com.github.xuejike.springboot.jkfaststart.vo;

import lombok.Data;

import java.util.List;
@Data
public class Menu {
    private String text;
    private String icon;
    private String href;
    private Long id;
    private Long pid;
    private boolean target;
    private List<Menu> subset;

}
