package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create{

    public static void createNewTable() {
        String url = "jdbc:sqlite:C://sqlite/db/movies.db";
        
        String sql = "CREATE TABLE IF NOT EXISTS interesting_movies(\n"
                + "	id integer PRIMARY KEY,\n"
                + "	Movie Name text NOT NULL,\n"
                + "	Actor text\n"
		+ "	Actress text\n"
		+ "	Year of Release int\n"
		+ "	Director text\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

   
    public static void main(String[] args) {
        createNewTable();
    }

}
