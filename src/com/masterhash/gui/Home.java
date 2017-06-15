package com.masterhash.gui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Home extends Application {

	Stage window;
	TableView<Table> table;
	TextField nameInput, usernameInput, passwordInput;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {

		window = primaryStage;
		window.setTitle("Home");
		Label titleLabel = new Label("Master Hash");

		titleLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
		titleLabel.setAlignment(Pos.CENTER);

		Button newLoginButton = new Button();
		newLoginButton.setText("New Login");

		TableColumn<Table, String> nameCol = new TableColumn<>("Name");
		nameCol.setMinWidth(200);
		nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

		TableColumn<Table, String> usernameCol = new TableColumn<>("Username");
		usernameCol.setMinWidth(200);
		usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));

		TableColumn<Table, String> passwordCol = new TableColumn<>("Password");
		passwordCol.setMinWidth(200);
		passwordCol.setCellValueFactory(new PropertyValueFactory<>("password"));

		nameInput = new TextField();
		nameInput.setPromptText("Name");
		nameInput.setPrefWidth(156);

		usernameInput = new TextField();
		usernameInput.setPromptText("Username");
		usernameInput.setPrefWidth(156);

		passwordInput = new TextField();
		passwordInput.setPromptText("Password");
		passwordInput.setPrefWidth(156);

		Button addbutton = new Button();
		addbutton.setText("Add");
		addbutton.setMinWidth(80);
		addbutton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				clickAddButton();
			}

		});

		BorderPane borderPane = new BorderPane();
		borderPane.setLeft(titleLabel);
		borderPane.setRight(newLoginButton);
		borderPane.setPadding(new Insets(20, 20, 10, 20));

		HBox hBox = new HBox();
		hBox.setPadding(new Insets(10, 10, 10, 10));
		hBox.setSpacing(10);
		hBox.getChildren().addAll(nameInput, usernameInput, passwordInput, addbutton);

		table = new TableView<>();
		table.setItems(getTable());
		table.getColumns().addAll(nameCol, usernameCol, passwordCol);

		VBox vBox = new VBox(10);
		vBox.getChildren().addAll(borderPane, table, hBox);

		Scene scene = new Scene(vBox, 600, 600);
		window.setScene(scene);
		window.show();
	}

	public void clickAddButton() {
		Table table1 = new Table();
		table1.setName(nameInput.getText());
		table1.setUsername(usernameInput.getText());
		table1.setPassword(passwordInput.getText());
		table.getItems().add(table1);
		nameInput.clear();
		usernameInput.clear();
		passwordInput.clear();
	}

	public ObservableList<Table> getTable() {

		ObservableList<Table> table = FXCollections.observableArrayList();

		return table;
	}

}
