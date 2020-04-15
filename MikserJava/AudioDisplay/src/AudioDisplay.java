
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class AudioDisplay extends StackPane {

    VerticalBar volumeBar, bassBar;
    ArrayList<VerticalBar> bars;

    FlowPane flow;
    Pane separator;

    FlowPane labelFlow;
    FlowPane bassAndVolFlow;
    FlowPane scaleFlow;

    FrequencyGenerator generator;

    public AudioDisplay(){

        bassAndVolFlow = new FlowPane();
        volumeBar = new VerticalBar();
        bassBar = new VerticalBar();

        this.setAlignment(Pos.CENTER);

        generator = new FrequencyGenerator();


        bars = new ArrayList<>();
        for(int i = 0; i<10; ++i){
            bars.add(new VerticalBar());
        }

        setStyle("-fx-background-color: blue;");
        setPrefSize(600,400);
        setMinSize(600,300);
        flow = new FlowPane();
        scaleFlow = new FlowPane();

//        flow.setPadding(new Insets(0, 0, 5, 0));
        flow.setVgap(10);
        flow.setHgap(10);
        flow.setPrefWrapLength(600); // preferred width allows for two columns
        flow.setStyle("-fx-background-color: DAE6F3;");

        flow.getChildren().add(bassBar);
        flow.getChildren().add(volumeBar);
        separator = new Pane();
        separator.setPadding(new Insets(0,15,0,0));
        flow.getChildren().add(separator);
        for(int i=0;i<4;++i){
            flow.getChildren().add(bars.get(i));
        }
        this.setPadding(new Insets(0,0,0,0));
        flow.setAlignment(Pos.CENTER);

        labelFlow = new FlowPane();
        labelFlow.setHgap(46);
        labelFlow.setPadding(new Insets(0,0,20,155));
        labelFlow.setPrefWrapLength(600);
        labelFlow.getChildren().add(new Label("F1"));
        labelFlow.getChildren().add(new Label("F2"));
        labelFlow.getChildren().add(new Label("F3"));
        labelFlow.getChildren().add(new Label("F4"));

        scaleFlow.setOrientation(Orientation.VERTICAL);
        scaleFlow.setPadding(new Insets(0,450,0,0));
        scaleFlow.setVgap(75);
        scaleFlow.getChildren().add(new Label("+15dB"));
        scaleFlow.getChildren().add(new Label("0dB"));
        scaleFlow.getChildren().add(new Label("-15dB"));

        labelFlow.setAlignment(Pos.BOTTOM_CENTER);

        scaleFlow.setAlignment(Pos.CENTER);

        bassAndVolFlow = new FlowPane();

        bassAndVolFlow.getChildren().add(new Label("BASS"));
        bassAndVolFlow.getChildren().add(new Label("VOLUME"));
        bassAndVolFlow.setHgap(30);
        bassAndVolFlow.setPadding(new Insets(0,260,20,0));
        bassAndVolFlow.setAlignment(Pos.BOTTOM_CENTER);

        getChildren().addAll(flow, scaleFlow,bassAndVolFlow,labelFlow);
    }

    public void setBackground(int choice){

        switch (choice){
            case 0:
                flow.setStyle("-fx-background-color: #74b9ff;");
                break;

            case 1:
                flow.setStyle("-fx-background-color: #55efc4;");
                break;
        }
    }

    public void setNumberOfBars(int number){
        flow.getChildren().clear();
        flow.getChildren().add(bassBar);
        flow.getChildren().add(volumeBar);
        flow.getChildren().add(separator);
        for (int i=0; i<number; ++i){
            flow.getChildren().add(bars.get(i));
        }

        labelFlow.getChildren().clear();
        ArrayList<String> frequencyList;
        switch (number){
            case 4:
                frequencyList = generator.FrequencyFour();
                for(int i = 0; i<4; i++){
                    labelFlow.getChildren().add(new Label(frequencyList.get(i)));
                }
                scaleFlow.setPadding(new Insets(0,450,0,0));
                bassAndVolFlow.setPadding(new Insets(0,260,20,0));
                break;
            case 5:
                frequencyList = generator.FrequencyFive();
                for(int i = 0; i<5; i++){
                    labelFlow.getChildren().add(new Label(frequencyList.get(i)));
                }
                scaleFlow.setPadding(new Insets(0,500,0,0));
                bassAndVolFlow.setPadding(new Insets(0,320,20,0));
                break;
            case 6:
                frequencyList = generator.FrequencySix();
                for(int i = 0; i<6; i++){
                    labelFlow.getChildren().add(new Label(frequencyList.get(i)));
                }
                scaleFlow.setPadding(new Insets(0,550,0,0));
                bassAndVolFlow.setPadding(new Insets(0,380,20,0));
                break;
            case 7:
                frequencyList = generator.FrequencySeven();
                for(int i = 0; i<7; i++){
                    labelFlow.getChildren().add(new Label(frequencyList.get(i)));
                }
                scaleFlow.setPadding(new Insets(0,600,0,0));
                bassAndVolFlow.setPadding(new Insets(0,440,20,0));

                break;
            case 8:
                frequencyList = generator.FrequencyEight();
                for(int i = 0; i<8; i++){
                    labelFlow.getChildren().add(new Label(frequencyList.get(i)));
                }
                scaleFlow.setPadding(new Insets(0,650,0,0));
                bassAndVolFlow.setPadding(new Insets(0,500,20,0));

                break;
            case 9:
                frequencyList = generator.FrequencyNine();
                for(int i = 0; i<9; i++){
                    labelFlow.getChildren().add(new Label(frequencyList.get(i)));
                }
                scaleFlow.setPadding(new Insets(0,750,0,0));
                bassAndVolFlow.setPadding(new Insets(0,560,20,0));

                break;
            case 10:
                frequencyList = generator.FrequencyTen();
                for(int i = 0; i<10; i++){
                    labelFlow.getChildren().add(new Label(frequencyList.get(i)));
                }
                scaleFlow.setPadding(new Insets(0,800,0,0));
                bassAndVolFlow.setPadding(new Insets(0,620,20,0));

                break;
        }
    }

    public void setVolume(Number value){
        volumeBar.setProgressValue(value.intValue());
    }

    public void setBass(Number value){
        bassBar.setProgressValue(value.intValue());
    }

    public void setValueBar(int bar, Number value){

        bars.get(bar-2).setProgressValue((value.intValue()));
    }

    public void setBorderColor(int choice){
        switch (choice){
            case 0:
                flow.setBorder(new Border(new BorderStroke(Color.BLUE,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                break;
            case 1:
                flow.setBorder(new Border(new BorderStroke(Color.GREEN,
                        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                break;
        }
    }

    public void setBarColors(int choice){
        volumeBar.setBackground(choice);
        bassBar.setBackground(choice);
        for(int i=0; i<10; ++i){
            bars.get(i).setBackground(choice);
        }
    }
}
