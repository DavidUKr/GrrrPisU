package database;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.sql.*;

public class DBUtils_local {
    public static void score(ActionEvent event, String name, int input, String color, float score) {
        Connection connection = null;
        PreparedStatement psInsert = null;
        try {
            String url = "jdbc:mysql://localhost:3306/co";
            String user = "root";
            String password = "";
            connection = DriverManager.getConnection(url, user, password);

            psInsert = connection.prepareStatement("INSERT INTO grrrpisu (name, input, color, score) VALUES (?, ?, ?, ?)");
            psInsert.setString(1, name);
            psInsert.setInt(2, input);
            psInsert.setString(3, color);
            psInsert.setFloat(4, score);
            psInsert.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            if (psInsert != null) {
                try {
                    psInsert.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
