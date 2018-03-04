/*==============================================================================
 Zachary Hadjah                    February 9th 2018
 Junior Year                       Side Project
  
This program first displays a bullseye created by three different sized cirlces.
Once the animate me button is clicked, the function animation() will make the existing
circles shrink inwards untill the size of the cirlces are zero.
 =============================================================================*/
package target;

import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Target extends Application 
{
    Circle[] cir = new Circle[7];
    Button btn = new Button("Animate me!");
    StackPane root = new StackPane();
    
    public static void main(String[] args) 
    {
        launch(args);
    }
    
    /** 
     * start method will create the target and the start button first 
     * displayed on-screen to the user 
     */
    @Override
    public void start(Stage primaryStage) 
    {
        root.setStyle("-fx-border-color:black;");      
        
        cir[0] = new Circle(400, 250, 200);
        cir[0].setFill(Color.RED);
        cir[0].setStyle("-fx-border-color:black;");
   
        cir[1] = new Circle(315, 165, 115);
        cir[1].setFill(Color.WHITE);
        cir[1].setStyle("-fx-border-color:black;");
        
        cir[2] = new Circle(230, 80, 30);
        cir[2].setFill(Color.RED);
        cir[2].setStyle("-fx-border-color:black;");

        root.getChildren().addAll(cir[0], cir[1], cir[2]);      
        root.getChildren().add(btn);      
        
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        
        btn.setOnAction(e ->
        {
            animation();
            btn.setText("Press to Stop");
        });
    }
    
    public void animation()
    {
        ScaleTransition[] st = new ScaleTransition[7];
        boolean recycleCircles = false;
        
        
        st[0]= new ScaleTransition(Duration.seconds(7), cir[0]);
        st[0].setToX(0.0f);
        st[0].setToY(0.0f);
        st[0].play();
        
        st[1] = new ScaleTransition(Duration.seconds(5.5), cir[1]);
        st[1].setToX(0.0f);
        st[1].setToY(0.0f);
        st[1].play();
        
        st[2] = new ScaleTransition(Duration.seconds(4), cir[2]);
        st[2].setToX(0.0f);
        st[2].setToY(0.0f);
        st[2].play();
        
       // int delayInc = 1;
        int delay = 1;
              
        //will create circles (will rotate between white and red) and then add 
        //to scaleTransitions
        while(btn.isPressed() == false)
        {
            for(int i = 3; i<st.length; i++)
            {     
                if(recycleCircles == true)
                {
                    i = 0;
                    recycleCircles = false;
                }
                if(i % 2 == 1)
                {
                    cir[i] = new Circle(400,250,200);
                    cir[i].setFill(Color.WHITE);
                    cir[i].setStyle("-fx-border-color:black;");
                    root.getChildren().add(cir[i]);
                    cir[i].toBack();

                    st[i] = new ScaleTransition(Duration.seconds(7), cir[i]);
                    st[i].setDelay(Duration.seconds(delay));
                    delay++;
                    st[i].setToX(0.0f);
                    st[i].setToY(0.0f);
                    st[i].play();

                }

                else if(i%2==0)
                {
                    cir[i] = new Circle(400, 250, 200);
                    cir[i].setFill(Color.RED);
                    cir[i].setStyle("-fx-border-color:black;");
                    root.getChildren().add(cir[i]);
                    cir[i].toBack();

                    st[i] = new ScaleTransition(Duration.seconds(7), cir[i]);
                    st[i].setDelay(Duration.seconds(delay));
                    delay++;
                    st[i].setToX(0.0f);
                    st[i].setToY(0.0f);
                    st[i].play();
                }
                
                if(i == 6)
                    recycleCircles = true;
            }
        }
                       
        //btn.pressedProperty().addListener(listener);
        
        btn.setOnMousePressed(event ->
        {   
        });   
   
        btn.setOnMouseReleased(event -> 
        {
            for(int y = 0; y<st.length;y++)
            {       
            }
        });

        
    }  
}

    
    
