package application;

import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DB.getConnection();
            statement = connection.prepareStatement(
                    "UPDATE seller "
                            + "SET BaseSalary = BaseSalary + ?"
                            + "WHERE "
                            + "(DepartmentId = ?)"
            );

            statement.setDouble(1, 200.0);
            statement.setInt(2, 2);

            int rowsAffected = statement.executeUpdate();

            System.out.println("Done! Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeConnection();
            DB.closeStatement(statement);
        }
    }
}

