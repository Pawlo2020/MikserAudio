
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;

import java.awt.*;

public class VerticalBar extends StackPane {


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private int value;


    public Label getDescription() {
        return description;
    }

    public void setDescription(Label description) {
        this.description = description;
    }

    Label description;

    Pane progress;
    Rectangle rectangle;
    public VerticalBar(){
        description = new Label();
        setPrefSize(50,200);

        progress = new Pane();
        progress.setStyle("-fx-background-color: yellow;");
        progress.setPrefSize(200,200);

        rectangle = new Rectangle();
        rectangle.setFill(Color.AZURE);
        rectangle.setWidth(50);

        setProgressValue(78);
        rectangle.relocate(0,0);
        progress.getChildren().addAll(rectangle);

        getChildren().add(progress);

    }

    public void setBackground(int choice){
        switch (choice){
            case 0:
                progress.setStyle("-fx-background-color: #74b9ff;");
                break;
            case 1:
                progress.setStyle("-fx-background-color: #55efc4;");
                break;
        }
    }

    public void setProgressValue(int value){
        value = 100 - value;
        rectangle.setHeight((200*value)/100);

    }
}
