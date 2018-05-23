package com.github.xuejike.springboot.jkfaststart.domain;

import com.github.xuejike.springboot.jkfaststart.domain.type.Status;
import com.github.xuejike.springboot.jkfaststart.domain_ext.CreationDateTime;
import com.github.xuejike.springboot.jkfaststart.domain_ext.UpdateDateTime;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity(name = "sys_admin_user")
public class AdminUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    /**
     * 用户名
     */
    @Column(unique = true)
    public String username;
    /**
     * 密码
     */
    public String pwd;
    /**
     * 昵称
     */
    public String nickName;

    @Enumerated(value = EnumType.STRING)
    public Status status;

    @Column(name = "role_id")
    public Long roleId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id",insertable = false,updatable = false)
    public AdminRole adminRole;
    /**
     * 软删除标记
     */
    @Column(name = "_delete")
    public Boolean delete;

    /**
     * 创建时间
     */
    @CreationDateTime
    private DateTime  createTime;

    /**
     * 修改时间
     */
    @UpdateDateTime
    private DateTime updateTime;
}
