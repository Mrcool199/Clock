package com.example.clock;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a label to display the time
        Label timeLabel = new Label();
        timeLabel.setAlignment(Pos.CENTER);
        timeLabel.setStyle("-fx-font-size: 48px;");

        // Create a timeline to update the time every second
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            LocalTime now = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            timeLabel.setText(formatter.format(now));
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        // Create a layout for the label
        StackPane root = new StackPane();
        root.getChildren().add(timeLabel);

        // Create a scene and display it
        Scene scene = new Scene(root, 200, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Digital Clock");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}