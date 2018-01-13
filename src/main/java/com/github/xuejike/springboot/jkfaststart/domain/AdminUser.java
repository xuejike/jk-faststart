package com.github.xuejike.springboot.jkfaststart.domain;

import com.github.xuejike.springboot.jkfaststart.domain.type.Status;
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
    private Long id;
    /**
     * 用户名
     */
    @Column(unique = true)
    private String username;
    /**
     * 密码
     */
    private String pwd;
    /**
     * 昵称
     */
    private String nickName;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @Column(name = "role_id")
    private Long roleId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id",insertable = false,updatable = false)
    private AdminRole adminRole;
    /**
     * 软删除标记
     */
    @Column(name = "_delete")
    private Boolean delete;

    /**
     * 创建时间
     */
    @CreationTimestamp
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime  createTime;

    /**
     * 修改时间
     */
    @UpdateTimestamp
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime updateTime;
}
