package pl.put.poznan.transformer.app;

import pl.put.poznan.transformer.exceptions.BadTextTransformationException;
import pl.put.poznan.transformer.logic.TextTransformer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LaunchPanel  extends JFrame implements ActionListener {

    JFrame frame;
    JLabel titleLabel;
    JTextArea textArea;
    JTextArea outputArea;
    JTextArea optionsArea;
    JButton submitButton;
    JButton addButton;
    JButton clearButton;
    JComboBox comboBox;

    LaunchPanel(){

        titleLabel = new JLabel();
        titleLabel.setText("TEXT TRANSFORMER");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.TOP);
        titleLabel.setForeground(Color.black); // set font color of text
        titleLabel.setFont(new Font("Arial",Font.PLAIN,50));
        titleLabel.setBounds(60,0,650,100);

        textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(400,150));
        textArea.setBounds(5,100,400,150);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Consolas",Font.PLAIN,25));
        textArea.setForeground(Color.white);
        textArea.setBackground(Color.black);
        textArea.setCaretColor(Color.white);
        textArea.setText("(Insert your text here)");

        outputArea = new JTextArea();
        outputArea.setPreferredSize(new Dimension(400,150));
        outputArea.setBounds(5,300,400,150);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setFont(new Font("Consolas",Font.PLAIN,25));
        outputArea.setForeground(Color.white);
        outputArea.setBackground(Color.black);
        outputArea.setCaretColor(Color.white);
        outputArea.setText("(Output)");
        outputArea.setEditable(false);

        optionsArea = new JTextArea();
        optionsArea.setPreferredSize(new Dimension(400,150));
        optionsArea.setBounds(425,150,340,150);
        optionsArea.setEditable(false);
        optionsArea.setLineWrap(true);
        optionsArea.setWrapStyleWord(true);

        submitButton = new JButton();
        submitButton.setText("Submit");
        submitButton.setBounds(425,310,340,40);
        submitButton.setFocusable(false);
        submitButton.setBorder(BorderFactory.createEtchedBorder());
        submitButton.addActionListener(this);

        clearButton = new JButton();
        clearButton.setText("Clear");
        clearButton.setBounds(665,100,100,40);
        clearButton.setFocusable(false);
        clearButton.setBorder(BorderFactory.createEtchedBorder());
        clearButton.addActionListener(this);

        addButton = new JButton();
        addButton.setText("Add");
        addButton.setBounds(555,100,100,40);
        addButton.addActionListener(this);

        String [] options = {"--Options--","upper", "lower",
                "capitalize","abbreviate","expand","inverse",
                "duplicate", "numbersToText", "latexFormat"};

        comboBox = new JComboBox(options);
        comboBox.setBounds(425,100,120,40);
        comboBox.setFocusable(false);
        comboBox.addActionListener(this);


        frame = new JFrame("Text Transformer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,500);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.add(titleLabel);
        frame.add(textArea);
        frame.add(outputArea);
        frame.add(submitButton);
        frame.add(comboBox);
        frame.add(optionsArea);
        frame.add(addButton);
        frame.add(clearButton);
        frame.setVisible(true);

    }
    String opt = "";

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addButton){
            if (!comboBox.getSelectedItem().toString().equals("--Options--")) {
                opt= opt + comboBox.getSelectedItem().toString() ;

                optionsArea.setText(opt);
                opt = opt + ",";
            }
        }
        if(e.getSource()==clearButton){
            opt="";
            optionsArea.setText(opt);
        }
        if(e.getSource()==submitButton){


            String text = textArea.getText();

            String[] transform = optionsArea.getText().split(",");

            System.out.println(transform[0]);

            if (!optionsArea.getText().isEmpty()) {
                try {
                    TextTransformer transformer = new TextTransformer(transform);
                    text = transformer.transform(text);
                }
                catch(BadTextTransformationException ex){
                    System.out.println("Error! Transformation error!");
                }
            }


            System.out.println("-------TEXT TRANSFORMED!-------");

            outputArea.setText(text);
        }

    }
}
