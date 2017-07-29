package com.masterhash.gui;

import java.io.File;

import javafx.application.Application;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Welcome extends Application {
	static Stage window;
	static File file;
    
	// Defining event components
	private static TextField usernameTextField = new TextField();
	private static PasswordField passwordTextField = new PasswordField();
	private static TextField fileLocationTextField = new TextField();
	private static Button submitButton = new Button("Submit");
	private static Button signUpButton = new Button("Sign Up");
	private static FileChooser fileChooser = new FileChooser();
	
    
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	    
	    // Setting up the stage
		window = primaryStage;
		window.setTitle("MasterHash");
		VBox vBox = new VBox(10);
		
		// Setting up the components
		Label masterHashTitle = setupMasterHashTitle();
		VBox usernameAndPasswordBox = setupUsernameAndPasswordBox();
		VBox fileBox = setupFileBox();
		HBox signUpAndSubmitButtons = setupSignUpAndSubmitButtons();
		
		// Adding componenets to main layout box
		vBox.getChildren().addAll(masterHashTitle, usernameAndPasswordBox, fileBox, signUpAndSubmitButtons);
		vBox.setAlignment(Pos.TOP_CENTER);
		
		// Setting the scene
		Scene scene = new Scene(vBox, 400, 400);
		window.setMinHeight(400);
		window.setMinWidth(400);
		window.setScene(scene);
		window.show();

	}
	
	private static Label setupMasterHashTitle() {
		Label masterHashTitle = new Label("Master Hash");

		masterHashTitle.setPadding(new Insets(10));
		masterHashTitle.setFont(Font.font(null, FontWeight.BOLD, 60));

		return masterHashTitle;
	}
	
	private static VBox setupUsernameAndPasswordBox() {
		VBox usernameAndPasswordBox = new VBox();
		Label username = new Label("Username:");
		Label password = new Label("Password:");

		usernameTextField.setMaxWidth(300);
		passwordTextField.setMaxWidth(300);

		usernameAndPasswordBox.getChildren().addAll(username, usernameTextField, password, passwordTextField);
		usernameAndPasswordBox.setAlignment(Pos.CENTER);

		return usernameAndPasswordBox;
	}
	
	private static VBox setupFileBox() {
		VBox fileBox = new VBox();
		HBox chooseFileBox = new HBox(10);
		Label fileLocation = new Label("File location:");
		Button chooseFileButton = new Button("Choose File");

		fileLocationTextField.setPrefSize(210, 20);
		fileLocationTextField.setMinHeight(25);
		fileLocationTextField.setMaxWidth(210);
		fileLocationTextField.setEditable(false);
		
		chooseFileButton.setPrefWidth(80);
		chooseFileButton.setMaxSize(100, 50);
		chooseFileButton.setOnAction(e -> chooseFile());
		chooseFileBox.getChildren().addAll(fileLocationTextField, chooseFileButton);
		chooseFileBox.setAlignment(Pos.TOP_CENTER);
		
		fileBox.getChildren().addAll(fileLocation, chooseFileBox);
		fileBox.setAlignment(Pos.CENTER);
		
		return fileBox;
		
	}
	
	private static HBox setupSignUpAndSubmitButtons() {
		HBox signUpAndSubmitButtons = new HBox(10);
		
		submitButton.setOnAction(e -> {
			Home.display();
			window.close();
		});
		signUpButton.setOnAction(e -> {
			Home.display();
			window.close();
		});

		signUpAndSubmitButtons.getChildren().addAll(submitButton, signUpButton);
		signUpAndSubmitButtons.setAlignment(Pos.CENTER);

		return signUpAndSubmitButtons;
	}
	
	private static void chooseFile() {
		File chosenFile = fileChooser.showOpenDialog(window);
		if (chosenFile != null) {
			fileLocationTextField.setText(chosenFile.getPath());
			file = chosenFile;
		}
	}
	
	
	
}
