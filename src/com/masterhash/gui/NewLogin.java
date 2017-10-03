package com.masterhash.gui;

import static com.masterhash.gui.Home.file;
import java.io.IOException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NewLogin {

	static Stage window;
	static String HEADING;

	public static void display() {
		window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Log In");
		HEADING = "New Login";

		Label headingLabel = new Label(HEADING);
		headingLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 30));

		TextField nameTextField = new TextField();
		nameTextField.setPromptText("Name");

		TextField userNameTextField = new TextField();
		userNameTextField.setPromptText("Username");

		PasswordField passwordField = new PasswordField();
		passwordField.setPromptText("Password");
		Button generateButton = new Button("Generate");

		HBox generatePasswordArea = new HBox();
		generatePasswordArea.getChildren().addAll(passwordField, generateButton);

		Button submitButton = new Button("Submit");
                
                submitButton.setOnAction(e -> {
                        Table t = new Table(nameTextField.getText(), 
                                userNameTextField.getText(), 
                                passwordField.getText());
                        try {
                            Home.addTable(t);
                        } catch (IOException ex) {
                            Alert x = new Alert(Alert.AlertType.ERROR);
                            x.setTitle("Write Error");
                            x.setContentText("Error while writing to " + file.getAbsolutePath());
                            x.showAndWait();
                        };  
		});

		VBox layout = new VBox(10);
		layout.setPadding(new Insets(0, 20, 0, 20));
		layout.setAlignment(Pos.CENTER_LEFT);
		layout.getChildren().addAll(headingLabel, nameTextField, userNameTextField, generatePasswordArea, submitButton);

		Scene scene = new Scene(layout, 300, 400);
		window.setScene(scene);
		window.showAndWait();
	}
}
