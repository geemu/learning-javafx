package me.geemu.chapter3;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Author: geemu
 * Email: cfmmail@sina.com
 * Date: 2017/9/24 11:56
 * Description: 表单设计
 */
public class FormDesign extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("表单设计,CSS渲染");
        // 行列网格布局 剧中显示
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
//        gridPane.setGridLinesVisible(true); // 设置网格可见
        // 设置行列边距
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25)); // 设置gridPane面板边缘周围的间隔
        // 给表单一个主题
        Text sceneTitle = new Text("Welcome");
        sceneTitle.setId("welcome-text");
        gridPane.add(sceneTitle, 0, 0, 2, 1);
        // 用户名标签 放在第0列第一行
        Label userNameLabel = new Label("UserName:");
        gridPane.add(userNameLabel, 0, 1);

        // 用户名输入框
        TextField userNameTextField = new TextField();
        gridPane.add(userNameTextField, 1, 1);

        // 密码标签
        Label passwordLabel = new Label("password");
        gridPane.add(passwordLabel, 0, 2);

        // 密码输入框
        PasswordField passwordTextField = new PasswordField();
        gridPane.add(passwordTextField, 1, 2);

        // 登陆按钮
        Button loginBtn = new Button("Sign in");


        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(loginBtn);
        gridPane.add(hbBtn, 1, 3);


        final Text loginBtnClick = new Text();
        gridPane.add(loginBtnClick, 0, 4);
        gridPane.setColumnSpan(loginBtnClick, 2);
        gridPane.setHalignment(loginBtnClick, HPos.RIGHT);
        loginBtnClick.setId("actiontarget");


        loginBtn.setOnAction((e) -> {
            loginBtnClick.setText("pressed");
        });


        Scene scene = new Scene(gridPane, 300, 200);
        scene.getStylesheets().add(FormDesign.class.getResource("Login.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
