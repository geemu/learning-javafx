package me.geemu.chapter5_UI.radio;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Radio extends Application {

    private final ImageView icon = new ImageView();
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new Group());
        primaryStage.setTitle("Radio");
        primaryStage.setWidth(250);
        primaryStage.setHeight(200);

        final ToggleGroup group = new ToggleGroup();
        // home
        RadioButton home = new RadioButton("Home");
        home.setToggleGroup(group);
        home.setUserData("Home");

        // calendar
        RadioButton calendar = new RadioButton("Calendar");
        calendar.setToggleGroup(group);
        calendar.setUserData("Calendar");

        // contacts
        RadioButton contacts = new RadioButton("Contacts");
        contacts.setToggleGroup(group);
        contacts.setUserData("Contacts");

        // 创建一个带图像的Radio Button
        Image image = new Image(getClass().getResourceAsStream("/chapter5/radio/Ok.jpg"));
        RadioButton imageRadio = new RadioButton("Agree");
        imageRadio.setGraphic(new ImageView(image));
        imageRadio.setToggleGroup(group);
        imageRadio.setUserData("Ok");

        group.selectedToggleProperty().addListener(
            (ObservableValue<? extends Toggle> ov, Toggle old_toggle,Toggle new_toggle) -> {
                if (group.getSelectedToggle() != null) {
                    final Image iconImage = new Image(getClass().getResourceAsStream("/chapter5/radio/"+group.getSelectedToggle().getUserData().toString() + ".jpg"));
                icon.setImage(iconImage);
            }
        });
        // 默认home选中
        home.requestFocus();
        home.setSelected(true);
        HBox hbox = new HBox();
        VBox vbox = new VBox();

        vbox.getChildren().add(home);
        vbox.getChildren().add(calendar);
        vbox.getChildren().add(contacts);
        vbox.getChildren().add(imageRadio);
        vbox.setSpacing(10);

        hbox.getChildren().add(vbox);
        hbox.getChildren().add(icon);
        hbox.setSpacing(50);
        hbox.setPadding(new Insets(20, 10, 10, 20));

        ((Group) scene.getRoot()).getChildren().add(hbox);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}