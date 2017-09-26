package me.geemu.chapter5_UI.label;
/**
 * Author: 陈方明
 * Email: cfmmail@sina.com
 * Date: 2017/9/26 13:01
 * Description:
 */

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class LabelChapter extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new Group());
        primaryStage.setTitle("Label");
        primaryStage.setWidth(420);
        primaryStage.setHeight(180);


        HBox hbox = new HBox();
        Image image = new Image(getClass().getResourceAsStream("/chapter5/label.png"));

        Label label1 = new Label("标签1");
        // 指定图标
        label1.setGraphic(new ImageView(image));
        label1.setFont(new Font("Arial",30));
        label1.setTextFill(Color.web("#0076a3"));
        label1.setTextAlignment(TextAlignment.JUSTIFY);

        Label label2 = new Label("标签2");
        label2.setFont(Font.font("Cambria", 32));
        // 旋转270度
        label2.setRotate(270);
        // 垂直移动50
        label2.setTranslateY(50);

        Label label3 = new Label("标签3标签3标签3标签3标签3标签3标签3标签3标签3标签3标签3标签3");
        // 文本折叠换行
        label3.setWrapText(true);
        label3.setTranslateY(50);
        label3.setPrefWidth(100);
        label3.setTextOverrun(OverrunStyle.CENTER_WORD_ELLIPSIS);

        label3.setOnMouseEntered((MouseEvent e) -> {
            label3.setScaleX(1.5);
            label3.setScaleY(1.5);
        });

        label3.setOnMouseExited((MouseEvent e) -> {
            label3.setScaleX(1);
            label3.setScaleY(1);
        });

        hbox.setSpacing(10);
        hbox.getChildren().add((label1));
        hbox.getChildren().add(label2);
        hbox.getChildren().add(label3);
        ((Group) scene.getRoot()).getChildren().add(hbox);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
