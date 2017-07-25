package com.masterhash.gui;

import java.util.ArrayList;
import java.util.Random;

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
	static String heading;

	public static void display() {
		window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Log In");
		heading = "New Login";

		Label headingLabel = new Label(heading);
		headingLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 30));

		TextField nameTextField = new TextField();
		nameTextField.setPromptText("Name");

		TextField userNameTextField = new TextField();
		userNameTextField.setPromptText("Username");

		TextField passwordField = new TextField();
		passwordField.setPromptText("Password");
		Button generateButton = new Button("Generate");
		
		generateButton.setOnAction(e -> {
			passwordField.setText(GeneratePassword_LettersNums(10));
			// with special chars
			// passwordField.setText(GeneratePassword_AllChars(10);
			
		});

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
	
	
	//Return random string of length n including all chars
	//Containing at least one Cap, one number, and one special char
	private static String GeneratePassword_AllChars(int length) {
		
		 ArrayList<Character>AllChars = new ArrayList<Character>();
		 
			//ASCII 33- 47
			 for(char c = '!'; c<='/'; c++) {
				 AllChars.add(c);
			 }
			 // add digits 0–9, 
			  for (char c = '0'; c <= '9'; c++) {
			    AllChars.add(c);
			  }
			  //ASCII 58 - 64
			  for(char c = ':'; c<='@'; c++) {
				  AllChars.add(c);
			  }

			  // Uppercase A–Z ASCII 65 -  90, 31 - 66
			  for (char c = 'A'; c <= 'Z'; c++) {
			    AllChars.add(c);
			  }

			  // lowercase a–z, 97 -122, 67 - 92
			  for (char c = 'a'; c <= 'z'; c++) {
			    AllChars.add(c);
			  }
			  
			  //ASCII 91 - 96, 93 - 
			  for (char c = '['; c <= '`'; c++) {
				  AllChars.add(c);
			  }
			  //ASCII 123 - 126
			  for(char c = '{'; c <= '~'; c++) {
				  AllChars.add(c);
			  }
			  
			  Boolean addedCAP = false;
			  Boolean addedSpecial = false;
			  Boolean addedNum = false;
			 
			  StringBuilder temp = new StringBuilder();
			  Random rand = new Random();
			  
			  //add chars
			  for (int i = 0; i < length; i++) {
				  int j = rand.nextInt(93);
				  //At least one digit added
				if (j >= 15 && j <= 23) {
					addedNum = true;
				}
				//At least one CAP
				if(j >= 32 && j <= 57) {
					addedCAP  = true; 
				}
				//At least one Special
				if((j<= 14) || (j >= 24 && j <= 30) || (j>= 57 && j <=62) || (j>89)) {
					addedSpecial = true;
				}
				  temp.append(AllChars.get(j));
				//		 System.out.println(s.get(j));
				  }
			  
			 if(addedNum == false) {
				int j = rand.nextInt(9) + 15;
				temp.append(AllChars.get(j));
			 }
			 if(addedCAP == false) {
				 int j = rand.nextInt(25) + 32;
					temp.append(AllChars.get(j));

			 }
			 if(addedSpecial == false) {
				 int j = rand.nextInt(15);
					temp.append(AllChars.get(j));

			 }

			  
			 return temp.toString();
		
	}
	
	//Random String of only letters and at least one number of length n
	private static String GeneratePassword_LettersNums(int length) {
		
		 ArrayList<Character>AllChars = new ArrayList<Character>();
		 
			
			 // add digits 0–9, 
			  for (char c = '0'; c <= '9'; c++) {
			    AllChars.add(c);
			  }
			 

			  // Uppercase A–Z ASCII 65 -  90
			  for (char c = 'A'; c <= 'Z'; c++) {
			    AllChars.add(c);
			  }

			  // lowercase a–z, 97 -122
			  for (char c = 'a'; c <= 'z'; c++) {
			    AllChars.add(c);
			  }
			  
			  Boolean addedNum = false;
			 
			  StringBuilder temp = new StringBuilder();
			  Random rand = new Random();
			  
			  //add chars
			  for (int i = 0; i < length; i++) {
				  int j = rand.nextInt(61);
				  //At least one digit added
				if (j < 10) {
					addedNum = true;
				}
			
				  temp.append(AllChars.get(j));
				//		 System.out.println(s.get(j));
				  }
			  
			 if(addedNum == false) {
				int j = rand.nextInt(9);
				temp.append(AllChars.get(j));
			 }
			

			  
			 return temp.toString();
		
	}
}
