package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.IOException;
import java.util.Arrays;


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
        Model model = new Model(); //Gør ikke noget?
        comboBox.getItems().addAll(model.baseProgram());

        ComboBox<String> comboBox1 = new ComboBox<>();

        TextArea textArea1 = new TextArea();
        textArea1.setEditable(false);

        //lambda expressions. get value henter valgt program
        comboBox.setOnAction(event -> {
            String selectedProgram = comboBox.getValue(); // Henter valgt program fra første combobox
            comboBox1.getItems().clear(); // Ryd tidligere valg
            List<String> courses = model.baseCourse(selectedProgram); // Henter kurser fra Model
            if (courses != null) {
                comboBox1.getItems().addAll(courses);
            }
        });
        //Så man kan trykke på kursus 
        comboBox1.setOnAction(event -> {
            String selectedCourse = comboBox1.getValue();
            if (selectedCourse != null && !textArea1.getText().contains(selectedCourse)) {
                textArea1.setText(textArea1.getText() + selectedCourse + "\n");//Henter og gemmer valgt kursus
            }
        });


       /*
        TextArea textArea1 = new TextArea();
        String txt=textArea1.getText();

        textArea1.setOnAction(event -> {



        }

        */

        //comboBox.getItems().add("Humtek");//henter HumTek klasse fra Mads' program
        //comboBox.getItems().add("NatBach");





        /*if (comboBox.equals("NatBach")) {
            comboBox.getItems().add(ArrayList );
            return;
        }*/

            ComboBox<String> comboBox2 = new ComboBox<>();

            comboBox2.getItems().add("Computer Science");
            comboBox2.getItems().add("Informatik");
            comboBox2.getItems().add("Astrology");

            ComboBox<String> comboBox3 = new ComboBox<>();
            comboBox3.getItems().add("Computer Science");
            comboBox3.getItems().add("Informatik");
            comboBox3.getItems().add("Astrology");


            //(String s : m.baseCourse("HumTek")) comboBox.getItems().add(s);
            //VBox root= new VBox(label1, comboBox, new VBox(label2));
            //GridPane til at styre placeringen af vores Labels
            GridPane root = new GridPane();
            root.add(label1, 1, 1);
            root.add(comboBox, 1, 2);//placering af combox1 (program combobox)
            root.add(comboBox1,1,3);
            root.add(textArea1, 1, 4);
            root.add(label2, 2, 1);
            root.add(comboBox2, 2, 2);
            root.add(comboBox3, 3, 2);
            root.add(label3, 3, 1);
            root.add(label4, 4, 1);
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

            Scene scene = new Scene(root, 1000, 1000);//hvor stor vores scene er
            stage.setTitle("Bachelor program");
            stage.setScene(scene);
            //stage.setScene(scene2);
            stage.show();
        }

        public static void main(String[]args){
            launch();
        }
    }


