package com.masterhash.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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

		VBox layout = new VBox(10);
		layout.setPadding(new Insets(0, 20, 0, 20));
		layout.setAlignment(Pos.CENTER_LEFT);
		layout.getChildren().addAll(headingLabel, nameTextField, userNameTextField, generatePasswordArea, submitButton);

		Scene scene = new Scene(layout, 300, 400);
		window.setScene(scene);
		window.showAndWait();
	}
}
