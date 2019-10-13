package com.enjoy.Executor;

import com.enjoy.config.Configuration;
import com.enjoy.config.MapperStament;
import com.sun.prism.shader.Mask_TextureSuper_AlphaTest_Loader;

import java.sql.*;
import java.util.List;

public class DefaultExecutor implements Executor {

    private Configuration configuration;

    public DefaultExecutor(Configuration configuration) {
        super();
        this.configuration = configuration;
    }

    public List query(MapperStament ms, Object paramter) {

         try {
             Class.forName(configuration.getJdbcDriver());
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(configuration.getJdbcUrl(), configuration.getUserName(), configuration.getPassword());
            statement = connection.prepareStatement(ms.getSql());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {

            }
            //handerResult
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

         }
        System.out.print(ms.getSql());
        System.out.print(ms.getResultType());
        return null;
    }
}
