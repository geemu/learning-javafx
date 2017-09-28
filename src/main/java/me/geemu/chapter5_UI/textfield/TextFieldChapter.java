package me.geemu.chapter5_UI.textfield;
/**
 * Author: 陈方明
 * Email: cfmmail@sina.com
 * Date: 2017/9/28 10:15
 * Description:
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextFieldChapter extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 180, 150);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Text Field");
        primaryStage.show();

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
//        gridPane.setGridLinesVisible(true);

        scene.setRoot(gridPane);

        final TextField firstName = new TextField();
        firstName.setPromptText("请输入姓氏");
        GridPane.setConstraints(firstName, 0, 0);
        gridPane.getChildren().add(firstName);

        final TextField lastName = new TextField();
        lastName.setPromptText("请输入名字");
        GridPane.setConstraints(lastName, 0, 1);
        gridPane.getChildren().add(lastName);

        final TextField comment = new TextField();
        comment.setPromptText("请输入评论");
        GridPane.setConstraints(comment, 0, 2);
        gridPane.getChildren().add(comment);



//        HBox hbBtn = new HBox(10);
//        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
//        hbBtn.getChildren().add(loginBtn);
//        gridPane.add(hbBtn, 1, 3);


        final HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        Button submit = new Button("提交");
//        GridPane.setConstraints(submit, 0, 3);
        gridPane.getChildren().add(submit);
        hbox.getChildren().add(submit);

        Button clear = new Button("清除");
//        gridPane.setConstraints(clear, 1, 3);
        gridPane.getChildren().add(clear);
        hbox.getChildren().add(clear);

        gridPane.add(hbox, 0, 4);



        final Label label = new Label();
        GridPane.setConstraints(label, 0, 3);
        GridPane.setColumnSpan(label, 2);
        gridPane.getChildren().add(label);

        submit.setOnAction((ActionEvent e) -> {
            if ((comment.getText() != null && !comment.getText().isEmpty())) {
                label.setText(firstName.getText() + lastName.getText() + "感谢评论");
            } else {
                label.setText("您还没有输入评论内容");
            }
        });

        clear.setOnAction((ActionEvent e) -> {
            firstName.clear();
            lastName.clear();
            comment.clear();
            label.setText("");
        });
    }
}
