<<<<<<< HEAD
package com.example.vhr.entity; // 指定了类所在的包名
=======
package com.example.vhr.entity;
>>>>>>> f6b48fea10132fa4954775267be77fa85c0fbbca

import java.util.List; // 导入Java的List接口，用于处理对象集合

// 定义一个公共类Admin，表示一个管理员
public class Admin {
    private String accountNonExpired; // 账号是否未过期，通常使用boolean类型，使用String不常见
    private String accountNonLocked; // 账号是否未被锁定
    private String address; // 管理员的地址
    private boolean credentialsNonExpired; // 凭证（如密码）是否未过期
    private boolean enabled; // 账号是否启用
    private int id; // 管理员的唯一标识符
    private String name; // 管理员的名称
    private String password; // 管理员的密码（通常需要更安全的处理方式）
    private String phone; // 管理员的电话号码
    private String remark; // 关于管理员的额外备注或评论
    private List<Role> roles; // 与管理员相关联的角色列表，表示其权限
    private String userface; // 可能是表示用户的图像或头像的URL或路径
    private String username; // 管理员的用户名

    // 以下是属性的getter和setter方法
    public String getAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(String accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public String getAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(String accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getUserface() {
        return userface;
    }

    public void setUserface(String userface) {
        this.userface = userface;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
