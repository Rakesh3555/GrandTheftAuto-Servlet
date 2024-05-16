package gta.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import gta.registration.model.GtaPojo;

public class GtaDataBaseManager {
	
	public int GtaPreBooks(GtaPojo gp) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO pre_books (username,Date_of_birth,mail) VALUES(?, ?, ?)";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("name"+ Class.forName("com.mysql.jdbc.Driver"));
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/gta", "root", "root");

      
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1,gp.getUsername() );
            preparedStatement.setString(2, gp.getDate_of_birth());
            preparedStatement.setString(3, gp.getMail());
         

            System.out.println(preparedStatement);
            
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {

            printSQLException(e);
        }
        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
