package me.geemu.chapter5_UI.password;
/**
 * Author: 陈方明
 * Email: cfmmail@sina.com
 * Date: 2017/9/28 13:17
 * Description:
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PasswordChapter extends Application {

    final Label message = new Label("");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 260, 80);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Password");

        VBox vb = new VBox();
        vb.setPadding(new Insets(10, 0, 0, 10));
        vb.setSpacing(10);
        HBox hb = new HBox();
        hb.setSpacing(10);
        hb.setAlignment(Pos.CENTER_LEFT);

        Label label = new Label("Password");
        final PasswordField pb = new PasswordField();
        pb.setText("");

        pb.setOnAction((ActionEvent e) -> {
            if (!pb.getText().equals("password")) {
                message.setText("密码错误");
                message.setTextFill(Color.rgb(210, 39, 30));
            } else {
                message.setText("密码正确");
                message.setTextFill(Color.rgb(21, 117, 84));
            }
            pb.clear();
        });

        hb.getChildren().addAll(label, pb);
        vb.getChildren().addAll(hb, message);

        scene.setRoot(vb);
        primaryStage.show();
    }
}
