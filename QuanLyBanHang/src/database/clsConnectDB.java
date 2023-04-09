/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Windows 10 Version 2
 */
public class clsConnectDB {

    private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=QUANLYBANHANGHASAKI;";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "123";
    private Connection conn;

    public clsConnectDB() {
        this.openConnectDb();
    }

    public boolean openConnectDb() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("connect successfully!");
            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println("Lỗi thiếu thư viện kết nối");
            return false;
        } catch (SQLException ex) {
            System.out.println("Lỗi kết nối CSDL!");
            return false;
        }
    }

    //Thực thi câu lệnh SELECT
    public ResultSet ExcuteQueryGetTable(String cauTruyVanSQL) {
        try {
            if (this.conn == null) {
                boolean result = this.openConnectDb();
                if (result == false) {
                    throw new RuntimeException("Lỗi kết nối CSDL!");
                }
            }

            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(cauTruyVanSQL);
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

        return null;
    }

    //Thực thi INSERT, DELETE, UPDATE
    public boolean ExcuteQueryUpdateDB(String cauTruyVanSQL) {
        try {
            if (this.conn == null) {
                boolean result = this.openConnectDb();
                if (result == false) {
                    throw new RuntimeException("Lỗi kết nối CSDL!");
                }
            }

            Statement stmt = this.conn.createStatement();
            stmt.executeUpdate(cauTruyVanSQL);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public Connection getConnection() {
        if (this.conn == null) {
            this.openConnectDb();
        }

        return conn;
    }

}
