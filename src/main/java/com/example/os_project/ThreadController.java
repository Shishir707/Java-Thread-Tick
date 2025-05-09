package com.example.os_project;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ThreadController {

    @FXML
    private Label textLabel;

    @FXML
    private TextField inputTF;

    private final CounterModel model = new CounterModel(0, true, 100);

    @FXML
    public void initialize() {
        Thread incrementThread = new Thread(() -> {
            while (model.isRunning()) {
                model.setCounter(model.getCounter() + 1);
            }
        });
        incrementThread.setDaemon(true);
        incrementThread.start();

        Thread uiUpdateThread = new Thread(() -> {
            while (model.isRunning()) {
                try {
                    Thread.sleep(model.getUpdateInterval());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                Platform.runLater(() -> textLabel.setText(String.valueOf(model.getCounter())));
            }
        });
        uiUpdateThread.setDaemon(true);
        uiUpdateThread.start();
    }

    @FXML
    public void updateButton(ActionEvent actionEvent) {
        try {
            int interval = Integer.parseInt(inputTF.getText().trim());
            if (interval > 0) {
                model.setUpdateInterval(interval);
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }
}
