package com.web.entity;

import java.util.Date;

public class UserInfo {
        private Integer id;
        private String name;
        private String userName;
        private String password;
        private String tel;
        private String address;
        private String idCard;
        private Date createTime;
        private Integer status;

    public UserInfo() {
    }

    public UserInfo(Integer id, String name, String userName, String password, String tel, String address, String idCard, Date createTime, Integer status) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.tel = tel;
        this.address = address;
        this.idCard = idCard;
        this.createTime = createTime;
        this.status = status;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置
     * @param tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取
     * @return idCard
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 设置
     * @param idCard
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * 获取
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    public String toString() {
        return "UserInfo{id = " + id + ", name = " + name + ", userName = " + userName + ", password = " + password + ", tel = " + tel + ", address = " + address + ", idCard = " + idCard + ", createTime = " + createTime + ", status = " + status + "}";
    }
}

