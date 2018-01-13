package com.github.xuejike.springboot.jkfaststart.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.xuejike.springboot.jkfaststart.domain.type.PermissionType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "sys_admin_permission")
@Data
@NoArgsConstructor
public class AdminPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    private Long pid;
    private String url;
    private String icon;
    private String method;
    @Enumerated(value = EnumType.STRING)
    private PermissionType type;
    private Integer sortIndex;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "pid")
    @JSONField(serialize = false)
    @JsonIgnore
    private List<AdminPermission> subMenu;

    public AdminPermission(Long id) {
        this.id = id;
    }
}
