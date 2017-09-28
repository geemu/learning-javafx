package me.geemu.chapter6;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * Author: 陈方明
 * Email: cfmmail@sina.com
 * Date: 2017/9/28 14:00
 * Description:
 */
public class WebViewChapter extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group group = new Group();//作为根节点，也就是root
        primaryStage.setWidth(600);
        primaryStage.setHeight(500);
        primaryStage.setScene(new Scene(group));

        WebView webView = new WebView();
        final WebEngine webEngine = webView.getEngine();
        webEngine.load(WebViewChapter.class.getResource("/chapter6/index.html").toExternalForm());


        webEngine.setOnAlert((WebEvent<String> wEvent) -> {
            System.out.println("Alert Event  -  Message:  " + wEvent.getData());
        });

        group.getChildren().add(webView);
        primaryStage.show();
    }

}