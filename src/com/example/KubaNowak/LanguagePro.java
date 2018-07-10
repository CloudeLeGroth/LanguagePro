package com.example.KubaNowak;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public final class LanguagePro {

    private LinkedList<Word> dictionary = new LinkedList<>();

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
    private Label newWordLabel = new Label("Word: ");
    private Label newMeaningLabel = new Label("Meaning: ");

    //TextFields
    private TextField wordField = new TextField();
    private TextField wordsMeaningField = new TextField();
    private TextField newWordField = new TextField("word");
    private TextField newWordsMeaningField = new TextField("meaning");


    public LanguagePro() {
        setUpWindow(mainWindow);
        setUpAllButtons();
        setUpAllLabels();
        addStuffToMain();
        setUpEventListeners();
        setUpAllTextFields();
        addStuffToLearnWindow();
        addStuffToAddWordsWindow();
    }

    //Method to set the certain window up
    private void setUpWindow(Frame frame){
        frame.setLayout(null);
        frame.setSize(400,600);
        frame.setVisible(true);
    }

    private void setUpAllButtons(){
        addWordsButton.setBounds(150,300,100,25);
        learnButton.setBounds(150,400,100,25);
        quizButton.setBounds(150,200,100,25);
        previousButton.setBounds(75,500,100,25);
        nextButton.setBounds(225,500,100,25);
        submitButton.setBounds(150,300,100,25);
        backButton.setBounds(150,550,100,25);
    }

    private void setUpAllLabels(){
        welcomeLabel.setBounds(170,75,100,25);
        addNewWordLabel.setBounds(150,350,100,25);
        wordLabel.setBounds(175,100,100,25);
        meaningLabel.setBounds(160,200,100,25);
        newWordLabel.setBounds(175,100,100,25);
        newMeaningLabel.setBounds(160,200,100,25);
    }

    private void setUpAllTextFields(){
        wordField.setBounds(100,150,200,25);
        wordsMeaningField.setBounds(100,250,200,25);
        newWordField.setBounds(100,150,200,25);
        newWordsMeaningField.setBounds(100,250,200,25);
        wordField.setEditable(false);
        wordsMeaningField.setEditable(false);
    }

    private void addStuffToMain(){
        mainWindow.add(welcomeLabel);
        mainWindow.add(quizButton);
        mainWindow.add(addWordsButton);
        mainWindow.add(learnButton);
    }

    private void addStuffToLearnWindow(){
        learnWindow.add(previousButton);
        learnWindow.add(nextButton);
        learnWindow.add(backButton);
        learnWindow.add(wordLabel);
        learnWindow.add(meaningLabel);
        learnWindow.add(wordField);
        learnWindow.add(wordsMeaningField);
    }

    private void addStuffToAddWordsWindow(){
        addWindow.add(submitButton);
        addWindow.add(newWordLabel);
        addWindow.add(newMeaningLabel);
        addWindow.add(newWordField);
        addWindow.add(newWordsMeaningField);
        addWindow.add(backButton);
        wordField.setEditable(true);
        wordsMeaningField.setEditable(true);
    }

    private void setUpEventListeners(){
        learnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainWindow.setVisible(false);
                setUpWindow(learnWindow);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                learnWindow.setVisible(false);
                addWindow.setVisible(false);
                mainWindow.setVisible(true);
            }
        });

        addWordsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainWindow.setVisible(false);
                setUpWindow(addWindow);
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dictionary.add(new Word(newWordField.getText(),newWordsMeaningField.getText()));
                System.out.println(dictionary.get(0).getMeaing());
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int randomNum = ThreadLocalRandom.current().nextInt(0, dictionary.size());
                wordField.setText(dictionary.get(randomNum).getWord());
                wordsMeaningField.setText(dictionary.get(randomNum).getMeaing());
            }
        });
    }

}
