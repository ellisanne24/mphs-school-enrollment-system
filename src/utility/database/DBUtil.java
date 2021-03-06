package utility.database;

import view.lan.DBConnectionForm;
import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DBUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/enrollmentdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection(DBType dbType)throws SQLException {
        //         return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return DriverManager.getConnection(getURL(), getUserName(), getPassword());
    }

    public static void processException(SQLException ex) {
        System.err.println("Error message: " + ex.getMessage());
        System.err.println("Error code: " + ex.getErrorCode());
        System.err.println("SQL State: " + ex.getSQLState());
    }

    private static String getURL() {
        Properties dbConfiguration = new Properties();
        File f = new File(".\\src\\configuration\\dbConnection.cfg");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(f);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            dbConfiguration.load(fis);
        } catch (IOException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        String connectionURL = dbConfiguration.getProperty("ConnectionURL");
        return connectionURL;
    }

    private static String getUserName() {
        Properties dbConfiguration = new Properties();
        File f = new File(".\\src\\configuration\\dbConnection.cfg");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(f);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            dbConfiguration.load(fis);
        } catch (IOException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        String connectionUsername = dbConfiguration.getProperty("username");
        return connectionUsername;
    }

    private static String getPassword() {
        Properties dbConfiguration = new Properties();
        File dbConnectionConfigFile = new File(".\\src\\configuration\\dbConnection.cfg");
        FileInputStream dbConnectionFileInputStream = null;
        try {
            dbConnectionFileInputStream = new FileInputStream(dbConnectionConfigFile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            dbConfiguration.load(dbConnectionFileInputStream);
        } catch (IOException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        String connectionPassword = dbConfiguration.getProperty("password");
        return connectionPassword;
    }

    public static void verifySettings() {
        File file = new File(".\\src\\configuration\\dbConnection.cfg");
        if (file.exists() && !file.isDirectory()) {
            System.out.println( "Database connection configuration found. ");
        } else {
            System.out.println("No database connection configuration found. ");
            DBConnectionForm dbConnectionSettings = new DBConnectionForm(null, true);
            dbConnectionSettings.setSize(new Dimension(400, 220));
            dbConnectionSettings.setLocationRelativeTo(null);
            dbConnectionSettings.setVisible(true);
        }
    }

}
