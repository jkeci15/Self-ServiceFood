package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * @desc A singleton database access class for MySQL
 * @author Ramindu
 */
public final class DbConnect {
    public Connection conn;
    private Statement statement;
    public static DbConnect db;

    private DbConnect() {
        //String url= "jdbc:mysql://130.226.142.46:3306/";
        String url = "jdbc:mysql://mysql.itu.dk:3306/";
        String dbName = "SelfService2000";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "mcjorgel";
        String password = "cookie";
        try {
            Class.forName(driver).newInstance();
            this.conn = (Connection) DriverManager.getConnection(url + dbName, userName, password);
        } catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }

    /**
     * @return MysqlConnect Database connection object
     */
    public static synchronized DbConnect getDbCon() {
        if (db == null) {
            db = new DbConnect();
        }
        return db;
    }


    //Data fetching methods
    public void testConn() {
        try
        {
            statement = db.conn.createStatement();
            int result = statement.executeUpdate("insert into users values ('something@something.com', 'mr test', 'abdc', 'pass', 1, 'apisdf');");
            System.out.println(result);
        }


        catch (SQLException ex){

        }
    }

    public static void main(String[] args){
        DbConnect db = DbConnect.getDbCon();
        db.testConn();
    }

}
