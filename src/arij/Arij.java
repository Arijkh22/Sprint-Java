
package arij;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Arij extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("/edu/devapps/Interface/categorieview.fxml"));
                //Parent root = FXMLLoader.load(getClass().getResource("/edu/devapps/Interface/Chart.fxml"));
        primaryStage.setTitle("WastaNet+");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        
    }
      

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
