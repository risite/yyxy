package com.risite.qg.entity;

import java.util.Date;
import org.springframework.data.annotation.Id;
public class BaseEntity {
    @Id
    protected String id;
    protected Date createDate;
    protected Date modifyDate;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Date getModifyDate() {
        return modifyDate;
    }
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}