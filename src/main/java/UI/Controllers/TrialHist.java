package UI.Controllers;

import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TrialHist implements Initializable {
    @FXML
    private TableView<TableModel> table;

    @FXML
    private TableColumn<TableModel, String> t_name;

    @FXML
    private TableColumn<TableModel, Integer> t_input;

    @FXML
    private TableColumn<TableModel, String> t_color;

    @FXML
    private TableColumn<TableModel, Float> t_score;

    ObservableList<TableModel> listview = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        t_name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        t_input.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getInput()).asObject());
        t_color.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getColor()));
        t_score.setCellValueFactory(cellData -> new SimpleFloatProperty(cellData.getValue().getScore()).asObject());


        try {
            DBConnect cn = new DBConnect();
            Connection cn1 = cn.getConnection();

            String sql = "SELECT * FROM grrrpisu";
            Statement s = cn1.createStatement();
            ResultSet r = s.executeQuery(sql);

            while(r.next()) {
                listview.add(new TableModel(
                    r.getString("name"),
                    r.getInt("input"),
                    r.getString("color"),
                    r.getFloat("score")
                ));
            }

            table.setItems(listview);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
