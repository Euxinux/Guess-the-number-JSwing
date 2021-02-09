package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class UserWindows extends JFrame
{
    JFrame frame = new JFrame();

    // Create JFrame
    public void UserWindowStart () throws InterruptedException {
        frame.setTitle("Guess the number");
        frame.setBounds(300,300,350,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // Set layout
        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        JButton bStart = new JButton("Start");
        JTextField textField = new JTextField("Hello user! Press START to play");
        TimeUnit.SECONDS.sleep(5);
        Font font = new Font("SansSerif", Font.BOLD, 20);
        textField.setFont(font);
        textField.setHorizontalAlignment(JTextField.CENTER);

        layout.setHorizontalGroup(
                layout.createParallelGroup().addComponent(bStart, GroupLayout.Alignment.CENTER).addComponent(textField,textField.getSize().width + 5,150, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup().addGroup(
                        layout.createSequentialGroup().addComponent(bStart).addComponent(textField,50,75,Short.MAX_VALUE)
                )
        );

        // Action Listener on button Start
        bStart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SetRange();
            }
        });
        JPanel jPanel1 = new JPanel();
        frame.getContentPane().add(jPanel1);
        jPanel1.add(bStart);
        jPanel1.add(textField);
        frame.setVisible(true);
    }

    // Set Range after set number and accept via button Start
    public void SetRange(){

        frame.getContentPane().removeAll();
        frame.setBounds(250,250,600,300);
        GroupLayout layout = new GroupLayout(frame.getContentPane());
        JPanel jPanel2 = new JPanel();
        frame.getContentPane().setLayout(layout);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);
        JButton setRange = new JButton("Set Range");
        final JTextField textField = new JTextField("Please type range of random generate 0 to x");
        JTextField textField2 = new JTextField();

        Font font = new Font("SansSerif", Font.BOLD, 20);
        textField.setFont(font);
        textField2.setFont(font);
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField2.setHorizontalAlignment(JTextField.CENTER);

        layout.setHorizontalGroup(
                layout.createParallelGroup().addComponent(textField,textField.getSize().width + 2,textField.getSize().width + 3, Short.MAX_VALUE).addGroup(
                    layout.createSequentialGroup().addComponent(textField2).addComponent(setRange)
                )
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup().addGroup(
                        layout.createSequentialGroup().addComponent(textField,textField.getSize().height + 2,textField.getSize().height + 3,Short.MAX_VALUE).addGroup(
                                layout.createParallelGroup().addComponent(textField2,10,20,30).addComponent(setRange)
                        )
                )
        );

        jPanel2.add(textField);
        jPanel2.add(setRange);
        jPanel2.add(textField2);
        frame.setVisible(true);

        setRange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
               // System.out.println(Integer.parseInt(textField2.getText()));
                try
                {
                    int range = Integer.parseInt(textField2.getText());
                    new WindowRandom(frame, range).GenerateNumbers();
                }
                catch (NumberFormatException eror)
                {
                    textField.setText("Please enter a number");
                    textField2.setText("");

                }
            }
        });


    }

}
