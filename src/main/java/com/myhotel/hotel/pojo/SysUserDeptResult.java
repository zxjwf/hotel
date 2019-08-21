package com.myhotel.hotel.pojo;

import java.io.Serializable;
import java.util.Date;

public class SysUserDeptResult implements Serializable {
    private static final long serialVersionUID=5477389876913514596L;
    private Integer id;
    private String userName;
    private String password;
    private String salt;
    private String email;
    private String mobile;
    private Integer valid=1;
    private SysDepts sysDept;
    private Date createdTime;
    private Date modifiedTime;
    private String createdUseer;
    private String modifiedUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public SysDepts getSysDept() {
        return sysDept;
    }

    public void setSysDept(SysDepts sysDept) {
        this.sysDept = sysDept;
    }

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

    public String getCreatedUseer() {
        return createdUseer;
    }

    public void setCreatedUseer(String createdUseer) {
        this.createdUseer = createdUseer;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }
}
