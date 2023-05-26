package UI.Controllers;

import UI.SceneLoaders.PageLoader;
import UI.SceneLoaders.page_select;
import database.DBConnect;
import database.TableModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class CatFightController implements Initializable, IController{

    @FXML
    Button btnBack;

    @FXML
    private Label blue_score;

    @FXML
    private Label yellow_score;

    @FXML
    private Label winner;

    private float blue_sum;

    private float yellow_sum;

    private int blue_counter = 0;

    private int yellow_counter = 0;

    private float b_score;

    private float y_score;

    ObservableList<TableModel> listview = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            DBConnect cn = new DBConnect();
            Connection cn1 = cn.getConnection();

            String sql = "SELECT color, score FROM grrrpisu";
            Statement s = cn1.createStatement();
            ResultSet r = s.executeQuery(sql);

            while(r.next()) {
                float score = r.getFloat("score");
                String color = r.getString("color");

                if(color.equals("blue") || color.equals("albastru")) {
                    blue_sum += score;
                    blue_counter += 1;
                }
                else {
                    yellow_sum += score;
                    yellow_counter += 1;
                }
            }

            if(blue_counter == 0) {
                b_score = 0;
            }
            else {
                b_score = blue_sum/blue_counter;
            }

            if(yellow_counter == 0) {
                y_score = 0;
            }
            else {
                y_score = yellow_sum/yellow_counter;
            }

            System.out.println("Blue: " + blue_sum + " " + blue_counter + " " + b_score);
            System.out.println("Yellow: " + yellow_sum + " " + yellow_counter + " " + y_score);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

         btnBack.setOnAction(event -> {
            try {
                PageLoader.load(event, page_select.MENU);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void setBlueScore() throws IOException {
        blue_score.setText(String.valueOf(b_score));
    }

    public void setYellowScore() throws IOException {
        yellow_score.setText(String.valueOf(y_score));
    }

    public void setWinner() throws IOException {
        if(y_score < b_score) {
            winner.setText("Blue wins!");
        }
        else {
            winner.setText("Yellow wins!");
        }
    }
}