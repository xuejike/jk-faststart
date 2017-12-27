package com.github.xuejike.springboot.jkfaststart.domain;

import com.github.xuejike.springboot.jkfaststart.domain.type.PermissionType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    private String method;
    @Enumerated(value = EnumType.STRING)
    private PermissionType type;


    public AdminPermission(Long id) {
        this.id = id;
    }
}
