package com.opencart.util;
import java.sql.*;

public class DatabaseUtils {

    private static final String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
    private static final String DB_USER = "hr";
    private static final String DB_PASSWORD = "admin";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }

    public static void closeStatement(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                System.out.println("Error closing statement: " + e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("Error closing result set: " + e.getMessage());
            }
        }
    }

    public static void executeUpdate(String sql) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } finally {
            closeStatement(stmt);
            closeConnection(conn);
        }
    }

    public static ResultSet executeQuery(String sql) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            closeResultSet(rs);
            closeStatement(stmt);
            closeConnection(conn);
            throw e;
        }
    }
}
