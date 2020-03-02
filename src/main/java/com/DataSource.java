package com;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {
    public static ComboPooledDataSource dataSource = new ComboPooledDataSource();
    public static Connection connection;
    public static QueryRunner qr = new QueryRunner();

    static {
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
        }
    }

    public static void insert(String str) throws Exception{
        qr.update(connection,"insert into day.caihongpi (str) values (?)", str);
    }

    public static ComboPooledDataSource getComboPooledDataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        return dataSource;
    }
    public static Connection getConnection() throws Exception{
        return dataSource.getConnection();
    }
}
