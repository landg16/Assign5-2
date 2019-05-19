package controller;

import java.sql.*;

public class DBConnect {
    private String sql_user = MyDBInfo.MYSQL_USERNAME;
    private String sql_server = MyDBInfo.MYSQL_DATABASE_SERVER;
    private String sql_password = MyDBInfo.MYSQL_PASSWORD;
    private String sql_db = MyDBInfo.MYSQL_DATABASE_NAME;

    public Connection ConnectBase () {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://" + sql_server+"/"+sql_db+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", sql_user, sql_password);
            return connection;
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
