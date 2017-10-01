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
import java.util.Random;

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

		TextField passwordField = new TextField();
		passwordField.setPromptText("Password");
		Button generateButton = new Button("Generate");
		generateButton.setOnAction(e -> {
				passwordField.setText(genPassword(10));
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

	private static char genChar(char start, char end, Random rand) {
		// determines range of possible characters
		int range = end - start + 1;

		// generates random character
		char randChar = (char) (start + rand.nextInt(range));

		return randChar;
	}

	private static String genPassword(int length) {
		Random rand = new Random();

		char[] newPassword = new char[length];

		// PART 1
		// satisfy requirements of at least one special char, digit, uppercase, lowercase
		char[] pairs = {'!','/','0','9','A','Z','a','z'};
		for (int i = 0; i < pairs.length/2; i++) {
			char start = pairs[i*2];
			char end = pairs[i*2+1];
			char randChar = genChar(start, end, rand);

			// randomly generate array index
			int index = rand.nextInt(newPassword.length);
			// check that this index contains null character
			while (newPassword[index] != '\u0000') {
				index = rand.nextInt(newPassword.length);
			}
			newPassword[index] = randChar;
		}

		// PART 2
		// fill in remaining array elements
		for (int i = 0; i < newPassword.length; i++) {
			// make sure current element is null
			if (newPassword[i] == '\u0000') {
				// range from '!' to '~' covers all legal characters
				char randChar = genChar('!', '~', rand);
				newPassword[i] = randChar;
			}
		}

		return new String(newPassword);
	}
}
