package application;
	

import consts.FilePathResource;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
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
		    loader.setLocation(ResourceUtil.getResourceURL(FilePathResource.SCREEN_LAYOUT_VIEW));
		    GridPane root = (GridPane) loader.load();
		    
		    
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(ResourceUtil.getResourceURL(FilePathResource.APPLICATION_STYLE).toExternalForm());
			primaryStage.setScene(scene);
			
            primaryStage.setMaximized(true);
            
			
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
