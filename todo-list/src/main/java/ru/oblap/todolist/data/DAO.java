package ru.oblap.todolist.data;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;

public class DAO {
    private static final String HOST = "localhost";
    private static final String DATABASE = "task";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1997";
    private Connection connection;

    private DataSource getDataSource() {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setServerName(HOST);
        mysqlDataSource.setDatabaseName(DATABASE);
        mysqlDataSource.setUser(USERNAME);
        mysqlDataSource.setPassword(PASSWORD);
        return mysqlDataSource;
    }

    protected Connection openConnection() {
        if(connection == null) {
            try {
                connection = getDataSource().getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    protected boolean closeConnection() {
        boolean result = false;
        try {
            connection.close();
            result = true;
        } catch (SQLException e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }
}
