package com.masterhash.gui;

import java.util.Random;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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

		TextField passtextfield = new TextField(); // Used for displaying password when Check box is checked
		passtextfield.setPromptText("Password");
		passtextfield.setManaged(false);
		passtextfield.setVisible(false);
		
		PasswordField passwordField = new PasswordField(); // Actual password field
		passwordField.setPromptText("Password");
	    CheckBox checkBox = new CheckBox("Show/Hide password");// To toggle
		Button generateButton = new Button("Generate"); 
		// Interchanging between Password Field when password is hidden and Text Field when its not
		passtextfield.managedProperty().bind(checkBox.selectedProperty());
	    passtextfield.visibleProperty().bind(checkBox.selectedProperty());
	    passwordField.managedProperty().bind(checkBox.selectedProperty().not());
	    passwordField.visibleProperty().bind(checkBox.selectedProperty().not());
	    passtextfield.textProperty().bindBidirectional(passwordField.textProperty());

		generateButton.setOnAction(e ->{
			
			passwordField.setText(GeneratePassword());
		
		});
		
		
		
		HBox generatePasswordArea = new HBox();
		generatePasswordArea.getChildren().addAll(passwordField,passtextfield, generateButton);

		Button submitButton = new Button("Submit");

		VBox layout = new VBox(10);
		layout.setPadding(new Insets(0, 20, 0, 20));
		layout.setAlignment(Pos.CENTER_LEFT);
		layout.getChildren().addAll(headingLabel, nameTextField, userNameTextField, generatePasswordArea,checkBox, submitButton);

		Scene scene = new Scene(layout, 300, 400);
		window.setScene(scene);
		window.showAndWait();
	}
	
	public static String GeneratePassword()
	{
		int len=10; //length of password hard coded
		
		String capital_letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String small_letters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*_=+-/.?<>)";

        String chars=capital_letters+small_letters+numbers+symbols;
        
        Random random = new Random();
 
        char[] password = new char[len];
        
        for (int i = 0; i < len; i++)
        {
            password[i] = chars.charAt(random.nextInt(chars.length()));
 
        }
        String pass=new String(password);
       
        return pass; 
	}
	
	
	
}
