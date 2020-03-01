package com.spartajet.fxboot.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.spartajet.fxboot.demo.services.DealFileServices;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description
 * @create 2017-05-20 下午1:55
 * @email spartajet.guo@gmail.com
 */
@FXMLController
public class MainStageController implements Initializable {
    @FXML
    private Button select;

    @FXML
    private Button start;
    @FXML
    private Button cancel;
    @FXML
    private TextArea fileText;

    @Autowired
    private DealFileServices fileServices;

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void selectClick(ActionEvent actionEvent){
        System.out.println("select file");
        DirectoryChooser file=new DirectoryChooser();
        file.setTitle("Choose the local dirctionary for FTP");
        Stage stage = (Stage) select.getScene().getWindow();
        File newFolder = file.showDialog(stage);//这个file就是选择的文件夹了
        if (newFolder != null) {
            List<String> fileList = fileServices.travelDirectory(newFolder.getAbsolutePath() + "/");
            String fileObject = fileServices.checkFile(fileList);
            fileText.setText(fileObject);
            start.setDisable(false);
            cancel.setDisable(false);
        }
     }
    //
    @FXML
    public void startClick(ActionEvent actionEvent) {
        System.out.println("btn click");

    }

    @FXML
    public void cancelClick(ActionEvent event){
        System.out.println("cancel click");
        Boolean flag = fileServices.deleteJosnFile();
        if (flag){
            fileText.setText("");
        }else {
            fileText.setText("请重试");
        }
    }
}
