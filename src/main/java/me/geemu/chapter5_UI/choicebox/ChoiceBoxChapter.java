package me.geemu.chapter5_UI.choicebox;
/**
 * Author: 陈方明
 * Email: cfmmail@sina.com
 * Date: 2017/9/28 9:44
 * Description:
 */

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ChoiceBoxChapter extends Application {

    Rectangle rect = new Rectangle(150, 30);
    final Label label = new Label("Hello");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new Group());
        scene.setFill(Color.ALICEBLUE);
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setTitle("ChoiceBox");
        primaryStage.setWidth(300);
        primaryStage.setHeight(200);

        label.setFont(Font.font("Arial", 25));
        label.setLayoutX(40);

        // 右侧提示信息
        final String[] greetings = new String[]{"Hello", "Hola", "Привет", "你好", "","こんにちは"};
        // 使用 Separator 产生分割线
        final ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList("English", "Español", "Русский", "简体中文",new Separator(), "日本語"));
        cb.getSelectionModel().selectedIndexProperty().addListener(
                (ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
                    label.setText(greetings[new_val.intValue()]);
                });
        // 手形
        cb.setCursor(Cursor.HAND);
        cb.setTooltip(new Tooltip("选择语言"));
        cb.setValue("English");
        HBox hb = new HBox();
        hb.getChildren().addAll(cb, label);
        hb.setSpacing(30);
        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(10, 0, 0, 10));
        ((Group) scene.getRoot()).getChildren().add(hb);

    }
}
