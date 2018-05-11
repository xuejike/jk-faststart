package com.github.xuejike.springboot.jkfaststart.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.xuejike.springboot.jkfaststart.domain.type.PermissionType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;

@Entity(name = "sys_admin_permission")
@NoArgsConstructor
public class AdminPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String name;
    private String description;

    private Long pid;
    private String url;
    private String icon;
    private String method;
    @Enumerated(value = EnumType.STRING)
    private PermissionType type;
    private Integer sortIndex;

    @OneToMany(fetch = LAZY,mappedBy = "pid")
    @JSONField(serialize = false)
    @JsonIgnore
    private List<AdminPermission> subMenu;

    public AdminPermission(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public PermissionType getType() {
        return type;
    }

    public void setType(PermissionType type) {
        this.type = type;
    }

    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }

    public List<AdminPermission> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(List<AdminPermission> subMenu) {
        this.subMenu = subMenu;
    }


}
