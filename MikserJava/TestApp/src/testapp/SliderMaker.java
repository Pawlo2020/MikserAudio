import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.StringConverter;

import java.util.ArrayList;

public class SliderMaker extends Pane {

    public Slider[] getSliders() {
        return sliders;
    }

    public Label[] getLabels() {
        return labels;
    }

    Slider[] sliders = new Slider[12];
    Label[] labels = new Label[10];

    FrequencyGenerator generator;
    GridPane panelik1 = new GridPane();

    public SliderMaker() {
        generator = new FrequencyGenerator();
        panelik1.setHgap(25);
        panelik1.setPadding(new Insets(0, 0, 0, 20));
        Slider bass = new Slider();
        Slider volume = new Slider();
        bass.setOrientation(Orientation.VERTICAL);
        volume.setOrientation(Orientation.VERTICAL);
        Label bassLabel = new Label("BASS");
        Label volumeLabel = new Label("VOLUME");
        bass.setMin(0);
        bass.setMax(100);
        bass.setMinorTickCount(1);
        bass.setSnapToTicks(true);
        bass.setMajorTickUnit(1);

        bass.setLabelFormatter(new StringConverter<Double>() {

            @Override
            public String toString(Double n) {

                if (n <1) return "-15 db";
                if (n<60 && n>45) return "+0 db";
                if (n <= 100 && n>98) return "+15 db";
                return "";
            }

            @Override
            public Double fromString(String s) {
                switch (s) {
                    case "-15 db":
                        return 0d;
                    case "+0 db":
                        return 50d;
                    case "+15 db":
                        return 100d;
                    default:
                        return 2d;
                }
            }
        });
        volume.setValue(50);
        volume.setMin(0);
        volume.setMax(100);

        volume.setSnapToTicks(true);
        volume.setMajorTickUnit(10);
        volume.setLabelFormatter(new StringConverter<Double>() {

            @Override
            public String toString(Double n) {

                if (n < 1.0) return "0";
                if (n < 11.0) return "10";
                if (n < 21.0) return "20";
                if (n < 31.0) return "30";
                if (n < 41.0) return "40";
                if (n < 51.0) return "50";
                if (n < 61.0) return "60";
                if (n < 71.0) return "70";
                if (n < 81.0) return "80";
                if (n < 91.0) return "90";
                if (n > +99.0) return "100";
                return "";
            }

            @Override

            public Double fromString(String s) {
                switch (s) {
                    case "0":
                        return 0d;
                    case "100":
                        return 1d;
                    default:
                        return 2d;
                }
            }
        });
        volume.setShowTickLabels(true);
        bass.setShowTickLabels(true);
        sliders[0] = new Slider();
        sliders[1] = new Slider();
        sliders[0] = bass;
        sliders[1] = volume;

        GridPane.setConstraints(bass, 0, 0);
        panelik1.getChildren().add(bass);
        GridPane.setConstraints(volume, 1, 0);
        panelik1.getChildren().add(volume);
        GridPane.setConstraints(bassLabel, 0, 1);
        panelik1.getChildren().add(bassLabel);
        GridPane.setConstraints(volumeLabel, 1, 1);
        panelik1.getChildren().add(volumeLabel);
        this.getChildren().add(panelik1);
    }

    public void iloscSuwaczkow(int x) {

        ArrayList<String> frequencies = new ArrayList<>();

        switch (x){
            case 4:
                frequencies = generator.FrequencyFour();
                break;
            case 5:
                frequencies = generator.FrequencyFive();
                break;
            case 6:
                frequencies = generator.FrequencySix();
                break;
            case 7:
                frequencies = generator.FrequencySeven();
                break;
            case 8:
                frequencies = generator.FrequencyEight();
                break;
            case 9:
                frequencies = generator.FrequencyNine();
                break;
            case 10:
                frequencies = generator.FrequencyTen();
                break;



        }



        panelik1.setHgap(10);
        for (int i = 0; i < x; i++) {

                Slider suwaczek1 = new Slider();
                suwaczek1.setOrientation(Orientation.VERTICAL);
                GridPane.setConstraints(suwaczek1, i + 2, 0);

                    Double a = (32 * Math.pow(2, i));
                    Integer xx = a.intValue();
                    Label label = new Label(frequencies.get(i));
                    labels[i] = label;
                    GridPane.setConstraints(label, i + 2, 1);
                    panelik1.getChildren().add(labels[i]);
                    sliders[i + 2] = new Slider();
                    sliders[i + 2] = suwaczek1;

                    panelik1.getChildren().add(sliders[i + 2]);
        }
    }


    public void clear(){
        for (int i = 0; i < 10; i++) {
            if(panelik1.getChildren().contains(sliders[i+2])){
                panelik1.getChildren().remove(sliders[i+2]);
            }
            if(panelik1.getChildren().contains(labels[i])){
                panelik1.getChildren().remove(labels[i]);
            }
            sliders[i+2] = null;
            labels[i] = null;
        }
    }
}
