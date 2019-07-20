package Frame.DataLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * 连接到数据库
 */
public class MysqlConnect {
    Connection con;

    public Connection getConnection(String mysql_name) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("数据库加载成功");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try{
            con= DriverManager.getConnection("jdbc:mysql:"+"//127.0.0.1:3306/"+mysql_name+"?serverTimezone=UTC","root","root");
            System.out.println("数据库连接成功");
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return con;
    }
}
