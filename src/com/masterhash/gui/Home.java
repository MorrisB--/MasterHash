package com.masterhash.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Home {

	static Stage window;
	static TableView<Table> table;

	@SuppressWarnings("unchecked")
	public static void display() {

		window = new Stage();
		window.setTitle("Home");
		Label titleLabel = new Label("Master Hash");

		titleLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
		titleLabel.setAlignment(Pos.CENTER);

		Button newLoginButton = new Button();
		newLoginButton.setText("New Login");
		newLoginButton.setOnAction(e -> NewLogin.display());

		TableColumn<Table, String> nameCol = new TableColumn<>("Name");
		nameCol.setMinWidth(200);
		nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

		TableColumn<Table, String> usernameCol = new TableColumn<>("Username");
		usernameCol.setMinWidth(200);
		usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));

		TableColumn<Table, String> passwordCol = new TableColumn<>("Password");
		passwordCol.setMinWidth(200);
		passwordCol.setCellValueFactory(new PropertyValueFactory<>("password"));

		BorderPane borderPane = new BorderPane();
		borderPane.setLeft(titleLabel);
		borderPane.setRight(newLoginButton);
		borderPane.setPadding(new Insets(20, 20, 10, 20));

		table = new TableView<>();
		table.setItems(getTable());
		table.getColumns().addAll(nameCol, usernameCol, passwordCol);

		VBox vBox = new VBox(10);
		vBox.getChildren().addAll(borderPane, table);

		Scene scene = new Scene(vBox, 600, 600);
		window.setScene(scene);
		window.show();
	}

	public static ObservableList<Table> getTable() {

		ObservableList<Table> table = FXCollections.observableArrayList();

		return table;
	}

}
