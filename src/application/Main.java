package application;
	

import consts.FilePathResource;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
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
	    
		try {
		    FXMLLoader loader = new FXMLLoader();
		    loader.setLocation(ResourceUtil.getResourceURL(FilePathResource.TODAY_VIEW));
		    SplitPane root = (SplitPane) loader.load();
		    
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(ResourceUtil.getResourceURL(FilePathResource.APPLICATION_STYLE).toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			

			SideMenu menu = new SideMenu(root);
			menu.initialise();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
    
    
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
