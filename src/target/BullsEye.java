/*
 * {Westfield State University}:Program Design 2
 * Zachary Hadjah
 * 
 */
package target;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author zach
 */
public class BullsEye extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        
        Circle cir1 = new Circle(400, 250, 200);
        cir1.setFill(Color.RED);
        Circle cir2 = new Circle(315, 165, 115);
        cir2.setFill(Color.WHITE);
        Circle cir3 = new Circle(230, 80, 30);
        cir3.setFill(Color.RED);
        root.getChildren().addAll(cir1, cir2, cir3);
        
        
        
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
