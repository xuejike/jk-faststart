package com.github.xuejike.springboot.jkfaststart.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity(name = "sys_admin_role")
public class AdminRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String info;

    @Column(name = "_delete")
    private Boolean delete;

    @ManyToMany(fetch = FetchType.LAZY)
    public Set<AdminPermission> permissionSet;


}
