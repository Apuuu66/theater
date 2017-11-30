package com.ttms.vo;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 * Date: 2017/11/16
 * Time: 15:08
 */
public class User implements Serializable{
    private String emp_no;
    private String emp_pass;
    private Integer role;
    private String  head_path;
    private Employee emp;

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public String getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(String emp_no) {
        this.emp_no = emp_no;
    }

    public String getEmp_pass() {
        return emp_pass;
    }

    public void setEmp_pass(String emp_pass) {
        this.emp_pass = emp_pass;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getHead_path() {
        return head_path;
    }

    public void setHead_path(String head_path) {
        this.head_path = head_path;
    }
}
