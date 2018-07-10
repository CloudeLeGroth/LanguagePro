package com.example.KubaNowak;

import java.awt.*;

public final class LanguagePro {
    //Frames
    private Frame mainWindow = new Frame("Language Pro V1.0");
    private Frame addWindow = new Frame("Language Pro V1.0");
    private Frame learnWindow = new Frame("Language Pro V1.0");

    //Buttons
    private Button addWordsButton = new Button("Add words");
    private Button learnButton = new Button("Learn");
    private Button quizButton = new Button("Quiz");
    private Button previousButton = new Button("Previous");
    private Button nextButton = new Button("Next");
    private Button submitButton = new Button("Submit");
    private Button backButton = new Button("Back to menu");

    //Labels
    private Label welcomeLabel = new Label("Greetings!");
    private Label addNewWordLabel = new Label("Add new word:");
    private Label wordLabel = new Label("Word: ");
    private Label meaningLabel = new Label("Meaning: ");

    //TextFields
    private TextField newWord = new TextField();
    private TextField newWordsMeaning = new TextField();

    //Function to set the certain window up
    private void setUpWindow(Frame frame){
        frame.setLayout(null);
        frame.setSize(400,600);
        frame.setVisible(true);
    }

}
