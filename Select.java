package net.sqlitetutorial;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Select {

    
    private Connection connect() {
        
        String url = "jdbc:sqlite:C://sqlite/db/movies.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void selectALL(){
        String sql = "SELECT id, movie name, actor, actress, year of release, director FROM interesting_movies";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("movie name") + "\t" +
				   rs.getString("actor") + "\t" +
				   rs.getString("actress") + "\t" +
				   rs.getint("year") + "\t" +
                                   rs.getString("director"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Select app = new Select();
        app.selectAll();
    }

}