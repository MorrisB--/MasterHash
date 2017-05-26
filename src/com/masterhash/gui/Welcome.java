package com.masterhash.gui;

import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

public class Welcome extends Application implements EventHandler<ActionEvent> {
	Stage window;
	File file; // Creating class variable 
    
	// Defining event components
	private TextField userNameTextField = new TextField();
    private PasswordField passwordTextField = new PasswordField();
	private TextField fileLocationTextField = new TextField();
	private Button chooseFileButton = new Button("Choose File");
	private Button submitButton = new Button("Submit");
    private Button signUpButton = new Button("Sign Up");
    private FileChooser fc = new FileChooser();
	
    
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	    
	    // Setting up the stage
		window = primaryStage;
		window.setTitle("MasterHash");
		VBox vBox = new VBox(10);
		
		
		// Setting the main title
		Label masterHashTitle = new Label("Master Hash");
		    masterHashTitle.setPadding(new Insets(10));
		    masterHashTitle.setFont(Font.font(null, FontWeight.BOLD, 60));
		  
		    
		// Setting up the username fields 
		VBox usernameBox = new VBox();
    		Label username = new Label("Username:");
    	    userNameTextField.setMaxWidth(300);
		usernameBox.getChildren().addAll(username, userNameTextField);
		usernameBox.setAlignment(Pos.CENTER);
		
		
		// Setting up the password fields
		VBox passwordBox = new VBox();
		    Label password = new Label("Password:");
		    passwordTextField.setMaxWidth(300);
        passwordBox.getChildren().addAll(password, passwordTextField);
        passwordBox.setAlignment(Pos.CENTER);
        
        
        // Setting up the file chooser
		VBox fileBox = new VBox();
		    HBox chooseFileBox = new HBox(10);
        		Label fileLocation = new Label("File location:");
        		    fileLocationTextField.setPrefSize(210, 20);
        		    fileLocationTextField.setMinHeight(25);
        		    fileLocationTextField.setMaxWidth(210);		
        		    fileLocationTextField.setEditable(false);
        		    chooseFileButton.setPrefWidth(80);
        		    chooseFileButton.setMaxSize(100, 50);	  
            		chooseFileButton.setOnAction(this);
    		chooseFileBox.getChildren().addAll(fileLocationTextField, chooseFileButton);
    		chooseFileBox.setAlignment(Pos.TOP_CENTER);		
		fileBox.getChildren().addAll(fileLocation, chooseFileBox);
		fileBox.setAlignment(Pos.CENTER);
		
		
		// Setting up the submit and signup buttons
		HBox submitButtons = new HBox(10);
		submitButtons.getChildren().addAll(submitButton, signUpButton);
		submitButtons.setAlignment(Pos.CENTER);
		
		
		// Adding componenets to main layout box
		vBox.getChildren().addAll(masterHashTitle, usernameBox, passwordBox, fileBox, submitButtons);
		vBox.setAlignment(Pos.TOP_CENTER);
		
		
		// Setting the scene
		Scene scene = new Scene(vBox, 400, 400);
		window.setMinHeight(400);
		window.setMinWidth(400);
		window.setScene(scene);
		window.show();

	}
	
	public void handle(ActionEvent event){
	    Object source = event.getSource();
	  
	    // the chooseFileButton was pressed
	    if(source == chooseFileButton){
	        File chosenFile = fc.showOpenDialog(window);
	        if(chosenFile != null){
	            fileLocationTextField.setText(chosenFile.getPath());
	            file = chosenFile;
	        }
	        
	    }
	    
	    
	    // the submitButton was pressed
	    else if(source == submitButton){          
            // do stuff here           
        }
        
	    
        // the signUpButton was pressed
	    else if(source == signUpButton){            
            // do stuff here  
        }
	}
	
	
	
}