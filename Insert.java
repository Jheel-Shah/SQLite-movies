package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert{

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/movies.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void Insert(String name, String actor, String actress, int year, String director) {
        String sql = "INSERT INTO interesting_movies(name,actor,actress,year,director) VALUES(?,?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, actor);
	    pstmt.setString(3, actress);
	    pstmt.setint(4, year);
	    pstmt.setString(5, director);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        Insert app = new Insert();
        // insert three new rows
        app.insert("Zindagi Na Milegi Dobara","Hrithik Roshan","Katrina Kaif",2011,"Zoya Akhtar");
        app.insert("Yeh Jawani Hai Deewani","Ranbir Kapoor","Deepika Padukone",2013,"Ayan Mukherji");
        app.insert("Rock On","Farhan Akhtar","Prachi Desai",2008,"Abhishek Kapoor");
	app.insert("Finished Goods", 5000);
	app.insert("Finished Goods", 5000);
    }

}