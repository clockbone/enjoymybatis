package com.enjoy.config;

import java.util.HashMap;
import java.util.Map;

public class Configuration {

    private String jdbcDriver;
    private String jdbcUrl;
    private String userName;
    private String password;

    //存sql语句信息// key: namespace+id value:sql语句
    private Map<String,MapperStament> map = new HashMap<String,MapperStament>();

    public String getJdbcDriver() {
        return jdbcDriver;
    }

    public void setJdbcDriver(String jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
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

    public Map<String, MapperStament> getMap() {
        return map;
    }

    public void setMap(Map<String, MapperStament> map) {
        this.map = map;
    }
}
