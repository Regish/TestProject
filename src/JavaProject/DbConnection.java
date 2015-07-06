package JavaProject;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by sharvanih.s on 05/07/15.
 */
public class DbConnection {
    private Properties prop;
    public DbConnection() throws IOException {
        prop=new Properties();
        InputStream in=getClass().getResourceAsStream("../resources/dbConnection.properties");
        prop.load(in);
        in.close();
    }
    public Connection DbConnect() throws ClassNotFoundException, SQLException {
        Class.forName(prop.getProperty("DRIVER"));
        Connection conn= DriverManager.getConnection(prop.getProperty("URL"),prop.getProperty("USERNAME"),prop.getProperty("PASSWORD"));
        return conn;
    }
}
