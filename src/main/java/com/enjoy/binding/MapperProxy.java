package com.enjoy.binding;

import com.enjoy.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collection;

public class MapperProxy implements InvocationHandler {

    private SqlSession session;

    public MapperProxy(SqlSession session) {
        super();
        this.session = session;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //查到返回参数类型，根据返回类型调用selectOne 还是selectList
        Class<?> returnType = method.getReturnType();
        //返回类型是子类或就是colletion本身
        if(Collection.class.isAssignableFrom(returnType)){
            //包名+方法名 组成命令空间+ id
            return  session.selectList(method.getDeclaringClass().getName()+"."+method.getName(),args==null?null:args[0]);
        }else{
            return session.selectOne(method.getDeclaringClass().getName()+"."+method.getName(),args==null?null:args[0]);
        }
    }
}
