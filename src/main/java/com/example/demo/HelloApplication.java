package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.IOException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

//Laver 4 labels til vores overskrifter
        Label label1 = new Label("Program");
        Label label2 = new Label("Subject 1");
        Label label3 = new Label("Subject 2");
        Label label4 = new Label("Electives");

//Opretter en combobox med to muligheder
        ComboBox<String> comboBox = new ComboBox<>();
        Model m=new Model();
        comboBox.getItems().add("HumTek");//henter HumTek klasse fra Mads' program
        comboBox.getItems().add("NatBach");

        


        //for (String s : m.baseCourse("HumTek")) comboBox.getItems().add(s);
        //VBox root= new VBox(label1, comboBox, new VBox(label2));
        //GridPane til at styre placeringen af vores Labels
        GridPane root = new GridPane();
        root.add(label1,1,1);
        root.add(comboBox,1,2);//placering af combox1 (program combobox)
        root.add(label2,2,1);
        root.add(label3,3,1);
        root.add(label4,4,1);
        //HBox root = new HBox;


   /* comboBox.getItems().addAll("NatBach", "HumTek");
    ComboBox<String> c=new ComboBox<> ();
    c.getItems().add("NatBach");
    c.getItems().add("HumTek");


        ComboBox<String> comboBox2 = new ComboBox<>();
        Model m2=new Model();
        VBox vbox2=new VBox(label2, comboBox2);
        for (String s: m2.baseCourse("subjectCourses")) comboBox2.getItems().add(s);
*/

        Scene scene = new Scene(root,500, 500);//hvor stor vores scene er
        stage.setTitle("Hello!");
        stage.setScene(scene);
        //stage.setScene(scene2);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}