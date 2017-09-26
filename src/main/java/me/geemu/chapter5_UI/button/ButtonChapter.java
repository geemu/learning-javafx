package me.geemu.chapter5_UI.button;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Author: 陈方明
 * Email: cfmmail@sina.com
 * Date: 2017/9/26 13:45
 * Description:
 */
public class ButtonChapter extends Application {

    private static final Color color = Color.web("#464646");

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 提示操作的标签
        Label label = new Label();
        label.setText("提示信息");
        Scene scene = new Scene(new Group());
        primaryStage.setTitle("Button");
        primaryStage.setWidth(280);
        primaryStage.setHeight(200);
        scene.getStylesheets().add("/chapter5/button/ControlStyle.css");

        label.setFont(Font.font("Times New Roman", 22));
        label.setTextFill(color);

        Image imageDecline = new Image(getClass().getResourceAsStream("/chapter5/button/not.png"));
        Image imageAccept = new Image(getClass().getResourceAsStream("/chapter5/button/ok.png"));
        // 最底层 其中添加了按钮1和hbox1 hbox2
        VBox vbox = new VBox();
        vbox.setLayoutX(20);
        vbox.setLayoutY(20);
        // 中间一行
        HBox hbox1 = new HBox();
        // 下面一行
        HBox hbox2 = new HBox();
        // 按钮1
        Button button1 = new Button("图片和文字", new ImageView(imageAccept));
        button1.getStyleClass().add("button1");
        button1.setOnAction((ActionEvent e) -> {
            label.setText("图片和文字");
        });

        // 按钮2
        Button button2 = new Button("文字");
        button2.setOnAction((ActionEvent e) -> {
            label.setText("文字");
        });

        // 按钮3  鼠标移入和移出
        Button button3 = new Button("文字取消");
        button3.setOnAction((ActionEvent e) -> {
            label.setText("文字取消");
        });
        DropShadow shadow = new DropShadow();
        button3.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            button3.setEffect(shadow);
        });

        button3.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            button3.setEffect(null);
        });

        hbox1.getChildren().add(button2);
        hbox1.getChildren().add(button3);
        hbox1.getChildren().add(label);
        hbox1.setSpacing(10);
        hbox1.setAlignment(Pos.BOTTOM_CENTER);

        // 按钮4
        Button button4 = new Button();
        button4.setGraphic(new ImageView(imageAccept));
        button4.setOnAction((ActionEvent e) -> {
            label.setText("图片接受");
        });

        // 按钮5
        Button button5 = new Button();
        button5.setGraphic(new ImageView(imageDecline));
        button5.setOnAction((ActionEvent e) -> {
            label.setText("图片取消");
        });

        hbox2.getChildren().add(button4);
        hbox2.getChildren().add(button5);
        hbox2.setSpacing(25);

        vbox.getChildren().add(button1);
        vbox.getChildren().add(hbox1);
        vbox.getChildren().add(hbox2);
        vbox.setSpacing(10);
        ((Group) scene.getRoot()).getChildren().add(vbox);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
