package me.geemu.chapter4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Author: geemu
 * Email: cfmmail@sina.com
 * Date: 2017/9/24 16:36
 * Description:
 */
public class FxmlExample extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/chapter4/FxmlExample.fxml"));
        primaryStage.setTitle("FXML渲染窗口");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
