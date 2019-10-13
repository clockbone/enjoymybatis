package com.enjoy.session;

import com.enjoy.config.Configuration;

import java.util.List;

/**
 * 1\对外提供数据访问的api
 * 2\对内请求转发给exector
 * 3\ 给一个接口，我返回一个实现类
 */
public interface SqlSession {

    <T> List<T> selectList(String statement, Object paramter);

    <T>T selectOne(String statement,Object paramter);

    <T> T getMapper(Class<T> type);




}
