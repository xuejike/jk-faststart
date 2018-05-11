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
    public Long id;
    @Column(name = "_key")
    public String key;
    @Type(type = "text")
    @Column(name = "_val")
    public String val;
    @Column(name = "_describe")
    public String describe;
    @CreationDateTime
    public DateTime createTime;
    @UpdateDateTime
    public DateTime updateTime;
}
