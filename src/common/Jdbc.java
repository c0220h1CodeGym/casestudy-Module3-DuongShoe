package common;

public class Jdbc {

    //connection
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/duongshoe";
    public static final String USER = "root";
    public static final String PASSWORD = "admin123";

    //query
    public static final String SELECT_ADMIN_FROM_USER = "select username, password from user where role_id = 2;";
}