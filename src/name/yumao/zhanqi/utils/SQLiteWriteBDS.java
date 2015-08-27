package name.yumao.zhanqi.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class SQLiteWriteBDS{
    private static final int INITIAL = 1;
    private static final int MAX_ACTIVE = 1;
    private static final int MAX_IDLE = 1;
    private static final long MAX_WAIT = 1000;
    private static final String DRIVER_NAME = "org.sqlite.JDBC";
    private static BasicDataSource bds;
    static{
        if(bds == null){
            bds = new BasicDataSource();
        }
        bds.setDriverClassName(DRIVER_NAME);
        bds.setInitialSize(INITIAL);
        bds.setMaxActive(MAX_ACTIVE);
        bds.setMaxIdle(MAX_IDLE);
        bds.setMaxWait(MAX_WAIT);
    }
    
    public static void setSqliteUrl(String path){
    	bds.setUrl("jdbc:sqlite:" + path);
    }
    public static Connection getSqliteConnection() throws SQLException{
        return bds.getConnection();
    }
}