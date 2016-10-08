package application;
	

import consts.ViewFileConsts;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import utilities.ResourceUtil;


public class Main extends Application {
    
    private Stage primaryStage;
    private BorderPane rootLayout;

    
	@Override
	public void start(Stage primaryStage) {
	    this.primaryStage = primaryStage;
	    this.primaryStage.setTitle("To Do List Desktop");
	    
		try {;
		    Parent root = FXMLLoader.load(ResourceUtil.getResource(ViewFileConsts.TODAY_VIEW));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
