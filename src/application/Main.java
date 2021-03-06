package application;
	
import application.control.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader=new FXMLLoader(getClass().getResource("view/Main.fxml"));
			BorderPane root = (BorderPane) loader.load();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("view/application.css").toExternalForm());
			
			@SuppressWarnings("unused")
			MainController controller=(MainController) loader.getController();
			MainController.injection(primaryStage);
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
