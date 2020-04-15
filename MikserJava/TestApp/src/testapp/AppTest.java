import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Collection;
import java.util.HashMap;

public class AppTest extends Application {

    AudioDisplay display;

    public static void main(String[] args) {
        launch(AppTest.class, args);
    }

    HashMap<String, String> hashMap = new HashMap<String, String>();

    public void start(Stage primaryStage) throws Exception {
        display = new AudioDisplay();
        backgroundColor();
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(800);

        BorderPane panelek = new BorderPane();
        Scene scena = new Scene(panelek);
        primaryStage.setScene(scena);
        primaryStage.show();
        BorderPane downPanel = new BorderPane();

        final ToggleGroup group = new ToggleGroup();
        final RadioButton backgroundColor = new RadioButton("Kolor tła");
        final RadioButton frameColor = new RadioButton("Kolor ramki");
        final RadioButton sliderColor = new RadioButton("Kolor słupków");
        backgroundColor.setToggleGroup(group);
        frameColor.setToggleGroup(group);
        sliderColor.setToggleGroup(group);

        final VBox componentUpper = new VBox();
        panelek.setTop(componentUpper);
        componentUpper.setPrefHeight(300);
        componentUpper.getChildren().add(display);

        VBox downPanelRight = new VBox();
        final ComboBox color = new ComboBox();
        color.setPrefWidth(150);
        backgroundColor.setPadding(new Insets(20, 80, 0, 0));
        frameColor.setPadding(new Insets(20, 62, 20, 0));
        sliderColor.setPadding(new Insets(0,50,20,0));

        downPanelRight.getChildren().add(color);
        downPanelRight.getChildren().add(backgroundColor);
        downPanelRight.getChildren().add(frameColor);
        downPanelRight.getChildren().add(sliderColor);

        Collection collection = hashMap.keySet();
        ObservableList observableList = FXCollections.observableArrayList(collection);
        color.setItems(observableList);
        downPanelRight.setAlignment(Pos.BOTTOM_RIGHT);

        VBox downPanelCenter = new VBox();
        final Spinner barAmount = new Spinner();
        downPanelCenter.getChildren().add(barAmount);
        panelek.setBottom(downPanel);
        SpinnerValueFactory value = new SpinnerValueFactory.IntegerSpinnerValueFactory(4, 10, 4);
        barAmount.setValueFactory(value);
        downPanelCenter.setAlignment(Pos.BOTTOM_CENTER);
        downPanelCenter.setPadding(new Insets(20, 0, 300, 0));
        downPanelRight.setPadding(new Insets(20, 20, 300, 0));
        downPanel.setCenter(downPanelCenter);
        downPanel.setRight(downPanelRight);

        final SliderMaker sliderMaker = new SliderMaker();

        downPanel.setLeft(sliderMaker);
        downPanel.setPadding(new Insets(50,0,0,0));

        final Button button = new Button("Pokaż");
        button.setAlignment(Pos.BOTTOM_CENTER);
        button.setPrefWidth(150);
        button.setOnAction(new EventHandler<ActionEvent>() {
                               public void handle(ActionEvent event) {

                                   if (backgroundColor.isSelected()) {
                                       //componentUpper.setStyle("-fx-background-color: #" + hashMap.get(color.getSelectionModel().getSelectedItem()) + ";");
                                       display.setBackground(color.getSelectionModel().getSelectedIndex());
                                   } else if (frameColor.isSelected()) {
                                       display.setBorderColor(color.getSelectionModel().getSelectedIndex());


                                   }else if(sliderColor.isSelected()){
                                        display.setBarColors(color.getSelectionModel().getSelectedIndex());
                                   }

                               }
                           }
        );

        downPanelRight.getChildren().add(button);

        final Button button1 = new Button("Ustaw");
        button1.setAlignment(Pos.TOP_CENTER);
        button1.setPrefWidth(150);
        sliderMaker.getSliders()[0].valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                display.setBass(newValue);
            }
        });

        sliderMaker.getSliders()[1].valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                display.setVolume(newValue);
            }
        });
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                button1.setPrefWidth(150);
                sliderMaker.clear();
                sliderMaker.iloscSuwaczkow((int) barAmount.getValue());

                for(int i=2; i<(int) barAmount.getValue() + 2; i++){
                    final int index = i;
                    sliderMaker.getSliders()[index].valueProperty().addListener(new ChangeListener<Number>() {
                        @Override
                        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                            display.setValueBar(index,newValue);
                        }
                    });
                }
                display.setNumberOfBars((int) barAmount.getValue());
            }
        });
        downPanelCenter.getChildren().add(button1);
    }

    public void backgroundColor() {
        hashMap.put("Niebieski", "74b9ff");
        hashMap.put("Zielony", "55efc4");
    }
}