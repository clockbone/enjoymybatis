package com.enjoy.session;

import com.enjoy.Executor.DefaultExecutor;
import com.enjoy.Executor.Executor;
import com.enjoy.binding.MapperProxy;
import com.enjoy.config.Configuration;
import com.enjoy.config.MapperStament;

import java.lang.reflect.Proxy;
import java.util.List;

public class DefaultSqlSession implements SqlSession{

    private   Configuration configuration;

    private Executor executor;

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

   public DefaultSqlSession(Configuration configuration){
        super();
        this.configuration = configuration;
        this.executor = new DefaultExecutor(configuration);
   }

    public <T> List<T> selectList(String statement, Object paramter) {
        MapperStament ms = configuration.getMap().get(statement);
        return executor.query(ms,paramter);
    }

    public <T> T selectOne(String statement, Object paramter) {
        List<Object> selecgtList =  this.selectList(statement,paramter);
        if(selecgtList == null||selecgtList.size()==0){
            return null;
        }
        if(selecgtList.size() ==1){
            return (T)selecgtList.get(0);
        }else{
            throw new RuntimeException("too many resutl");

        }

    }

    public <T> T getMapper(Class<T> type) {
        //动态代理： 代理类，实现类
        //代理类： 生成一个实现类
        //实现类:处理逻辑
        //如个类加载器和type一个类加载器， 实现接口，实现类（由invacationHandler实现）
        MapperProxy mp = new MapperProxy(this);
        return (T)Proxy.newProxyInstance(type.getClassLoader(),new Class[]{type},mp);
    }
}
