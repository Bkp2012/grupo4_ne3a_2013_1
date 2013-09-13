/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

/**
 *
 * @author marko_000
 */
public class DatabaseConfig {
    public static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DATABASE_URL = "jdbc:mysql://localhost/Sigmav";
    public static final String DATABASE_USER = "root";
    public static final String DATABASE_PASSWORD = "";
    public static final String HIBERNATE_SHOW_SQL = "true";
    public static final String HIBERNATE_FORMAT_SQL = "true";
    public static final String HIBERNATE_CREATE_TABLES = "update";
}
