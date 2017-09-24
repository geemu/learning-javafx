package me.geemu.chapter4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

/**
 * Author: geemu
 * Email: cfmmail@sina.com
 * Date: 2017/9/24 16:35
 * Description:
 */
public class FxmlExampleController {
    @FXML
    private Text actiontarget;

    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
        actiontarget.setText("Sign in button pressed");
    }
}
