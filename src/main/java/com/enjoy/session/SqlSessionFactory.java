package com.enjoy.session;

import com.enjoy.config.Configuration;
import com.enjoy.config.MapperStament;

import java.util.HashMap;
import java.util.Map;

//1 在初始化时加载配置信息封configuration
// 2 生成sqlserssion
public class SqlSessionFactory {

    private final Configuration conf = new Configuration();

    public SqlSessionFactory(){
        loadDbInfo(); //加载db信息
        loadMappersInfo();//加载多个xml文件

    }

    public static String MAPPER_LOCATION = "";
    public static String DB_CONFIG = "";
    private void loadDbInfo(){
        //读db
        conf.setJdbcDriver("com.mysql.cj.jdbc.Driver");
        conf.setJdbcUrl("jdbc:mysql://localhost:3309/test");
        conf.setPassword("root");
        conf.setUserName("123456");
    }
    private void loadMappersInfo(){
        //读xml文件
        //遍历文件夹，解析文件
        Map<String,MapperStament> map = new HashMap<String, MapperStament>();
        //这里我不读了，直接定个固定的sql语句在这里
        MapperStament ms = new MapperStament();
        ms.setNamespace("com.enjoy.mapper.TUserMapper");
        ms.setResultType("com.enjoy.mapper.TUser");
        ms.setSourceId("selectByKey");
        ms.setSql("select * from t_lock");
        map.put("com.enjoy.mapper.TUserMapper.selectByKey",ms);
        conf.setMap(map);


    }

    public  SqlSession openSqlSession(){
        return new DefaultSqlSession(conf);
    }


}
