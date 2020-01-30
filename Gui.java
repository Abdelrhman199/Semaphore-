package com.company;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Scanner;

public class Gui extends Application {

    Stage window;
    Scene scene1;
    GridPane grid;
    TextArea devicesList;
    TextField wifi;
    TextField numOfDevices;
    TextArea outputArea;
    public static int numberOfWifiConnections;
    public static int numberOfDevicesToConnect;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{

        window=primaryStage;
        grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setHgap(5);
        grid.setVgap(5);
        //number of wifi connection label
        Label label1 = new Label("What is number of WI-FI Connections?");
        GridPane.setConstraints(label1,0,0);
        grid.getChildren().add(label1);
        //number of wifi connections field
        wifi  = new TextField();
        //wifi.setPromptText("Enter the number of WIFI connections");
        wifi.setPrefColumnCount(20);
        wifi.getText();
        GridPane.setConstraints(wifi,0,1);
        grid.getChildren().add(wifi);


        //number of devices want to coonect label
        Label label2 = new Label("What is number of devices Clients want to connect?");
        GridPane.setConstraints(label2,0,2);
        grid.getChildren().add(label2);

        //number of devices want to connect field

        numOfDevices = new TextField();
        //numOfDevices.setPromptText("Enter the number of devices want to connect");
        numOfDevices.setPrefColumnCount(30);
        numOfDevices.getText();
        GridPane.setConstraints(numOfDevices,0,3);
        grid.getChildren().add(numOfDevices);

        //devices text area

        devicesList = new TextArea();
        devicesList.setPrefColumnCount(30);
        devicesList.setPrefRowCount(40);
        devicesList.getText();
        GridPane.setConstraints(devicesList,0,5);
        grid.getChildren().add(devicesList);

        //devices label
        Label label3 = new Label("Enter each device's name and type");
        GridPane.setConstraints(label3,0,4);
        grid.getChildren().add(label3);

        //output label
        Label label4 = new Label("output");
        GridPane.setConstraints(label4,0,6);
        grid.getChildren().add(label4);

        //output text area
        outputArea = new TextArea();
        outputArea.setPrefColumnCount(30);
        outputArea.setPrefRowCount(50);
        outputArea.getText();
        GridPane.setConstraints(outputArea,0,7);
        grid.getChildren().add(outputArea);

        //submit button
        Button button = new Button("connect");
        button.setMaxWidth(200);
        button.setMaxHeight(50);
        button.setOnAction(e -> {organizeInput(devicesList.getText());
        });
        GridPane.setConstraints(button,2,7);
        grid.getChildren().add(button);

//        javafx.scene.image.Image image = new javafx.scene.image.Image(getClass().getResource("pp.jpeg").toExternalForm());
//        ImageView iv = new ImageView(image);
//        grid.setBackground(new Background(new BackgroundImage(image,BackgroundRepeat.NO_REPEAT,
//                BackgroundRepeat.NO_REPEAT,
//                BackgroundPosition.DEFAULT,
//                BackgroundSize.DEFAULT)));
        grid.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        scene1 = new Scene(grid,550,550);


        window.setScene(scene1);
        window.setTitle("Router");
        window.show();

    }
    public static ArrayList<Device> arr2 = new ArrayList();
    public void organizeInput(String message)
    {
        String []arr = new String[message.length()];
        arr=message.split("\n",message.length());
        for(String s:arr)
        {
            String [] temp = new String[s.length()];
            temp=s.split(" ",s.length());
            Device obj = new Device(temp[0],temp[1]);
            arr2.add(obj);
        }
        numberOfWifiConnections =Integer.parseInt(wifi.getText());
        numberOfDevicesToConnect = Integer.parseInt(numOfDevices.getText());
        Network.networkUtilization();
        System.out.println("wifi "+numberOfWifiConnections);
        try {
            Scanner readFromFile =new Scanner(new File("/home/seif/Desktop/books/5th semester/os/osAss2/src/com/company/output.txt"));
            String output;
            while (readFromFile.hasNext())
            {
                output = readFromFile.nextLine();
                outputArea.appendText(output+"\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


}
