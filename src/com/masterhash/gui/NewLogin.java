package GUI;

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
import javafx.stage.Stage;

/*
 * Sapayth Hossain
 */
public class NewLogin extends Application {

    Stage window;
    String heading;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Log In");  // title of the window
        heading = "New Login";

        // heading label
        Label lblHeading = new Label(heading);
        lblHeading.setFont(Font.font("Verdana", FontWeight.BOLD, 30));

        // name textfield
        TextField TFname = new TextField();
        TFname.setPromptText("Name");

        // username textfield
        TextField TFuserName = new TextField();
        TFuserName.setPromptText("Username");

        // password field and generate button
        PasswordField PFpassword = new PasswordField();
        PFpassword.setPromptText("Password");
        Button btnGenerate = new Button("Generate");    // Generate button

        // align password field and generate button
        HBox generatePasswordArea = new HBox();
        generatePasswordArea.getChildren().addAll(PFpassword, btnGenerate);

        // submit button
        Button btnSubmit = new Button("Submit");

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(0, 20, 0, 20));
        layout.setAlignment(Pos.CENTER_LEFT);
        layout.getChildren().addAll(
                lblHeading, TFname, TFuserName, generatePasswordArea, btnSubmit
        );

        Scene scene = new Scene(layout, 300, 400);
        window.setScene(scene);
        window.show();
    }
}
