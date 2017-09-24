package me.geemu.chapter1;
/**
 * Author: geemu
 * Email: cfmmail@sina.com
 * Date: 2017/9/24 11:11
 * Description: helloWorld
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class HelloWorld extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    // 搭建主窗口
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("click and say hello world");
        // 匿名函数方式绑定事件
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World");
//            }
//        });
        // lambda方式绑定时间 推荐
        btn.setOnAction((e) -> {
            System.out.println("HelloWorld");
        });
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("你好");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
