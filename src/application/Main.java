package application;
	
import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
    
    private Stage primaryStage;
    private BorderPane rootLayout;

    
	@Override
	public void start(Stage primaryStage) {
	    this.primaryStage = primaryStage;
	    this.primaryStage.setTitle("To Do List Desktop");
	    
		try {
		    Parent root = FXMLLoader.load(getClass().getResource("/gui/TodayView.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/*public void initRootLayout() {
        try {
            // Load root layout from fxml file.
           /* FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("gui/TodayView.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            Parent root = FXMLLoader.load(getClass().getResource("TodayView.fxml"));
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(root);
            primaryStage.setTitle("To Do List Desktop");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
	
	public static void main(String[] args) {
		launch(args);
	}
}
