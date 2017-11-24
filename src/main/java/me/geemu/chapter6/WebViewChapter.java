package me.geemu.chapter6;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
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
        // 作为根节点，也就是root
        Group group = new Group();
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