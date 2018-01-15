package com.github.xuejike.springboot.jkfaststart.domain;

import com.github.xuejike.springboot.jkfaststart.domain_ext.CreationDateTime;
import com.github.xuejike.springboot.jkfaststart.domain_ext.UpdateDateTime;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

@Data
@Entity(name = "sys_config")
public class SysConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "_key")
    private String key;
    @Type(type = "text")
    @Column(name = "_val")
    private String val;
    @Column(name = "_describe")
    private String describe;
    @CreationDateTime
    private DateTime createTime;
    @UpdateDateTime
    private DateTime updateTime;
}
