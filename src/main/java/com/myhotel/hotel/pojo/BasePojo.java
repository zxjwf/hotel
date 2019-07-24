package com.myhotel.hotel.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.util.Date;
//序列化? 远程传输,持续化(写磁盘)
public class BasePojo implements Serializable {
    private static final long seriaVersionUID=1L;
    @TableField(value = "createdTime",fill= FieldFill.INSERT)
    private Date createdTime;
    @TableField(value="modifiedTime",fill=FieldFill.UPDATE)
    private Date modifiedTime;
    @TableField(value="createdUser",fill=FieldFill.INSERT)
    private String createdUser;
    @TableField(value ="modifiedUser",fill=FieldFill.DEFAULT)
    private String  modifiedUser;

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }
}
