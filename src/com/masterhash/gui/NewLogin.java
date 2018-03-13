package com.masterhash.gui;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
		
		Button generateButton = new Button("Generate");
		TextField shownPasswordField = new TextField();
		PasswordField hiddenPasswordField = new PasswordField();

	    shownPasswordField.setManaged(false);
	    shownPasswordField.setVisible(false);
	    
	    CheckBox checkBox = new CheckBox("Hide/Show");
	    shownPasswordField.managedProperty().bind(checkBox.selectedProperty());
	    shownPasswordField.visibleProperty().bind(checkBox.selectedProperty());

	    hiddenPasswordField.managedProperty().bind(checkBox.selectedProperty().not());
	    hiddenPasswordField.visibleProperty().bind(checkBox.selectedProperty().not());

	    shownPasswordField.textProperty().bindBidirectional(hiddenPasswordField.textProperty());

		HBox generatePasswordArea = new HBox();
		VBox showOrHideArea = new VBox();
		generatePasswordArea.getChildren().addAll(shownPasswordField,hiddenPasswordField, generateButton);
		showOrHideArea.getChildren().addAll(generatePasswordArea,checkBox);

		Button submitButton = new Button("Submit");

		VBox layout = new VBox(10);
		layout.setPadding(new Insets(0, 20, 0, 20));
		layout.setAlignment(Pos.CENTER_LEFT);
		layout.getChildren().addAll(headingLabel, nameTextField, userNameTextField, showOrHideArea, submitButton);

		Scene scene = new Scene(layout, 300, 400);
		window.setScene(scene);
		window.showAndWait();
	}
}
