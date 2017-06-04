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

public class Home extends Application implements EventHandler<ActionEvent>  {

	Stage window;
	TableView<Table> table;
	TextField Iname,Iusername,Ipassword;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
            launch(args);
	}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		window  = primaryStage;
		window.setTitle("Home");
		Label label1 = new Label("Master Hash");
		
		label1.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
		label1.setAlignment(Pos.CENTER);
		
		
		//Login button
		Button button2  = new Button();
		button2.setText("LOG IN");
	

        
       
        
		
		
		
		//table
		TableColumn<Table,String> nameCol  = new TableColumn<>("Name");
		nameCol.setMinWidth(200);
		nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
		

		TableColumn<Table,String> usernameCol  = new TableColumn<>("Userame");
		usernameCol.setMinWidth(200);
		usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
		

		TableColumn<Table,String> passwordCol  = new TableColumn<>("Password");
		passwordCol.setMinWidth(200);
		passwordCol.setCellValueFactory(new PropertyValueFactory<>("password"));
	
		Iname = new TextField();
		Iname.setPromptText("Name");
		Iname.setMinWidth(100);
		

		Iusername = new TextField();
		Iusername.setPromptText("Username");
		Iusername.setMinWidth(100);
		

		Ipassword = new TextField();
		Ipassword.setPromptText("Password");
		Ipassword.setMinWidth(100);
		
		
		Button addbutton = new Button("ADD");
		addbutton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event)
			{
				ClickAddButton();
			}

			
		});

//		HBox hbox1 = new HBox();
//		hbox1.setPadding(new Insets(10,10,10,10));
//		hbox1.setSpacing(10);
//        hbox1.getChildren().addAll(label1,button2);
        
        BorderPane bp = new BorderPane();
        bp.setLeft(label1);
        bp.setRight(button2);
        bp.setPadding(new Insets(10, 20, 10, 20));
		
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(10,10,10,10));
		hbox.setSpacing(10);
        hbox.getChildren().addAll(Iname,Iusername,Ipassword,addbutton);
        
        
        
		
		table = new TableView<>();
		table.setItems(getTable());
		table.getColumns().addAll(nameCol,usernameCol,passwordCol);
		
		
		VBox v = new VBox(20);
		v.getChildren().addAll(bp,table,hbox);
		
        
		//StackPane layout = new StackPane();
        //layout.getChildren().addAll(,table);
       

        

		
		Scene scene = new Scene(v,600,550);
		window.setScene(scene);
		window.show();
	}

	public void ClickAddButton(){
	   Table table1 = new Table();
	   table1.setName(Iname.getText());
	   table1.setUsername(Iusername.getText());
	   table1.setPassword(Ipassword.getText());
	   table.getItems().add(table1);
	   Iname.clear();
	   Iusername.clear();
	   Ipassword.clear();
	   }
	
	public ObservableList<Table> getTable() {
		
		ObservableList<Table> table2 = FXCollections.observableArrayList(); 
		//table2.add(new Table("MyName", "NAMEofUser", "passWORD"));

		return table2;
	}

}
