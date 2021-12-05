/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFx;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

/**
 *
 * @author Sadam
 */

public class Register extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        primaryStage.setTitle("TugasJavaFX");

        GridPane gridPane = FormRegistrasi();
        addUIControls(gridPane);
        Scene scene = new Scene(gridPane, 500, 500);	
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }

    private GridPane FormRegistrasi() {
        
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(40, 40, 40, 40));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        ColumnConstraints columnOneConstraints = new ColumnConstraints(150, 150, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.LEFT);
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(150,150, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    private void addUIControls(GridPane gridPane) {
        
        Label Judul = new Label("Register");
        Judul.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
        Judul.setBackground(new Background(new BackgroundFill(Color.DARKORANGE,null,null)));
        gridPane.add(Judul, 0,0,2,1);
        GridPane.setHalignment(Judul, HPos.CENTER);
        GridPane.setMargin(Judul, new Insets(0,0,20,0));

        Label NamaAwal = new Label("First Name ");
        gridPane.add(NamaAwal, 0,1);

        TextField BidangNamaAwal = new TextField();
        BidangNamaAwal.setPrefHeight(40);
        gridPane.add(BidangNamaAwal, 1,1);

        Label NamaAkhir = new Label("Last Name ");
        gridPane.add(NamaAkhir, 0, 2);

        TextField BidangNamaAkhir = new TextField();
        BidangNamaAkhir.setPrefHeight(40);
        gridPane.add(BidangNamaAkhir, 1, 2);

        Label Email = new Label("E-Mail Address ");
        gridPane.add(Email, 0, 3);

        TextField EmailAddress  = new TextField();
        EmailAddress.setPrefHeight(40);
        gridPane.add(EmailAddress , 1, 3);
        
        Label NomorTelp = new Label("Contact No ");
        gridPane.add(NomorTelp, 0, 4);
        
        TextField BidangNomorTelp  = new TextField();
        BidangNomorTelp.setPrefHeight(40);
        gridPane.add(BidangNomorTelp , 1, 4);
        
        Label Password = new Label("Password ");
        gridPane.add(Password, 0, 5);

        PasswordField BidangPassword = new PasswordField();
        BidangPassword.setPrefHeight(40);
        gridPane.add(BidangPassword, 1, 5);
        
        Label PasswordLabel = new Label("Confirm Password ");
        gridPane.add(PasswordLabel, 0, 6);
        
        PasswordField ConfirmPassword = new PasswordField();
        ConfirmPassword.setPrefHeight(40);
        gridPane.add(ConfirmPassword, 1, 6);

        Button TombolSubmit = new Button("Register");
        TombolSubmit.setPrefHeight(40);
        TombolSubmit.setDefaultButton(true);
        TombolSubmit.setPrefWidth(100);
        gridPane.add(TombolSubmit, 0, 7,2,1);
        GridPane.setHalignment(TombolSubmit, HPos.CENTER);
        GridPane.setMargin(TombolSubmit, new Insets(20, 20,20,20));

        TombolSubmit.setOnAction((ActionEvent event) -> {
            if(BidangNamaAwal.getText().isEmpty()) {
                showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your First name");
                return;
            }
            if(BidangNamaAkhir.getText().isEmpty()) {
                showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your Last name");
                return;
            }
            if(EmailAddress.getText().isEmpty()) {
                showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your Email");
                return;
            }
            if(BidangNomorTelp.getText().isEmpty()) {
                showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your Contact No");
                return;
            }
            if(BidangPassword.getText().isEmpty()) {
                showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a Password");
                return;
            }
            
            showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Registration Successful!", "Welcome " + BidangNamaAwal.getText());
        }
        );
        
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}