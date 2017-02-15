package com.masterhash.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Welcome extends Application {
	Stage window;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		window = primaryStage;
		window.setTitle("MasterHash");

		VBox vBox = new VBox();
		Label masterHashTitle = new Label("Master Hash");
		masterHashTitle.setPadding(new Insets(10));
		Label username = new Label("Username:");
		TextField userNameTextField = new TextField();
		userNameTextField.setMaxWidth(300);
		Label password = new Label("Password:");
		TextField passwordTextField = new TextField();
		passwordTextField.setMaxWidth(300);
		Label fileLocation = new Label("File location:");
		TextField fileLocationTextField = new TextField();
		fileLocationTextField.setMaxWidth(300);
		Button submitButton = new Button("Submit");
		Button signUpButton = new Button("Sign Up");
		vBox.getChildren().addAll(masterHashTitle, username, userNameTextField, password, passwordTextField,
				fileLocation, fileLocationTextField, submitButton, signUpButton);
		vBox.setAlignment(Pos.TOP_CENTER);

		Scene scene = new Scene(vBox, 500, 500);
		window.setScene(scene);
		window.show();

	}

}