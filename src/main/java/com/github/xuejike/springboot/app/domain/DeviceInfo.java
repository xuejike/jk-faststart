package com.github.xuejike.springboot.app.domain;

import com.github.xuejike.springboot.jkfaststart.domain_ext.CreationDateTime;
import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
public class DeviceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String info;
    private InfoType infoType;
    /**
     * 创建时间
     */
    @CreationDateTime
    private DateTime createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public DateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(DateTime createTime) {
        this.createTime = createTime;
    }

    public InfoType getInfoType() {
        return infoType;
    }

    public void setInfoType(InfoType infoType) {
        this.infoType = infoType;
    }
}
