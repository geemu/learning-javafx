package me.geemu.chapter5_UI.toggle;
/**
 * Author: 陈方明
 * Email: cfmmail@sina.com
 * Date: 2017/9/26 17:32
 * Description: 开关
 */

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ToggleChapter extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Toggle");
        primaryStage.setWidth(500);
        primaryStage.setHeight(200);
        primaryStage.setMaxWidth(500);
        primaryStage.setMaxHeight(200);

        HBox hbox = new HBox();
        VBox vbox = new VBox();

        Scene scene = new Scene(new Group(vbox));
        primaryStage.setScene(scene);
        scene.getStylesheets().add("/chapter5/toggle/ControlStyle.css");

        Rectangle rect = new Rectangle();
        rect.setHeight(50);
        rect.setFill(Color.WHITE);
        rect.setStroke(Color.DARKGRAY);
        rect.setStrokeWidth(2);
        rect.setArcHeight(10);
        rect.setArcWidth(10);

        final ToggleGroup group = new ToggleGroup();

        group.selectedToggleProperty().addListener(
                (ObservableValue<? extends Toggle> ov, Toggle toggle, Toggle new_toggle) -> {
                    if (new_toggle == null)
                        rect.setFill(Color.WHITE);
                    else
                        rect.setFill((Color) group.getSelectedToggle().getUserData());
                });

        // 默认按钮1选中
        ToggleButton tb1 = new ToggleButton("tb1");
        tb1.setPrefSize(100,36);
        tb1.setMaxSize(100,36);
        tb1.setToggleGroup(group);
        tb1.setUserData(Color.LIGHTGREEN);
        tb1.setSelected(true);
        tb1.getStyleClass().add("toggle-button1");

        ToggleButton tb2 = new ToggleButton("tb2");
        tb2.setPrefSize(100,36);
        tb2.setMaxSize(100,36);
        tb2.setToggleGroup(group);
        tb2.setUserData(Color.LIGHTBLUE);
        tb2.getStyleClass().add("toggle-button2");

        ToggleButton tb3 = new ToggleButton("tb3");
        tb3.setPrefSize(100,36);
        tb3.setMaxSize(100,36);
        tb3.setToggleGroup(group);
        tb3.setUserData(Color.SALMON);
        tb3.getStyleClass().add("toggle-button3");

        //一个带有文本和图标的Toggle Button
        Image image = new Image(getClass().getResourceAsStream("/chapter5/toggle/Ok.jpg"));
        ToggleButton tb4 = new ToggleButton ("Press me", new ImageView(image));
        tb4.setPrefSize(100,30);
        tb4.setMaxSize(100,30);
        tb4.setToggleGroup(group);
        tb4.setUserData(Color.YELLOW);
        tb4.getStyleClass().add("toggle-button4");

        // 横向添加三个按钮
        hbox.getChildren().addAll(tb1, tb2, tb3,tb4);

        // 纵向添加hbox和标签以及图形
        vbox.getChildren().add(new Label("Priority:"));
        vbox.getChildren().add(hbox);
        vbox.getChildren().add(rect);
        vbox.setPadding(new Insets(20, 10, 10, 20));

        primaryStage.show();
        rect.setWidth(hbox.getWidth());
    }
}
