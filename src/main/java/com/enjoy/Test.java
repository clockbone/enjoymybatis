package com.enjoy;

import com.enjoy.mapper.TUser;
import com.enjoy.mapper.TUserMapper;
import com.enjoy.session.SqlSession;
import com.enjoy.session.SqlSessionFactory;

public class Test {

    public static void main(String[] args){
        // 第一阶段
        // 1 实例化sqlSessionFactory 加载数据配置文件及xml文件
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactory();
        //2 获取session对象
        SqlSession session = sqlSessionFactory.openSqlSession();
        //3 通过动态代理生一个 TUserMapper的实现类，这个实现在是MapperProxy
        TUserMapper userMapper = session.getMapper(TUserMapper.class);
        //通过userMapper调用selectByKey 回调mapperProxy 的invoke方法，
        // invoke方法里面根据方法返回类型调用session.selectOne 或selectList
        //session 执行的方法实现交给executor去执行，executor去遵循jdbc规范链接数据库并执行sql并返回结查
        TUser tUser = userMapper.selectByKey(1);

    }
}
