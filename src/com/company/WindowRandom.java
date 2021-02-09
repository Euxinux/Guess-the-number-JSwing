package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class WindowRandom extends JFrame {
    JFrame jFrame;
    int range;


    public WindowRandom(JFrame jFrame, int range) throws HeadlessException {
        this.jFrame = jFrame;
        this.range = range;
    }

    // method responsible for generate random number 0 to x
    public void GenerateNumbers(){
        jFrame.getContentPane().removeAll();
        BorderLayout layout = new BorderLayout();
        jFrame.setBounds(300,300,450,250);
        jFrame.setLayout(layout);
        jFrame.repaint();

        JButton bSet = new JButton("Add");
        JPanel jPanel = new JPanel();
        JTextField uNumberText = new JTextField();
        JTextField uInformationText = new JTextField("Please type your first number");

        uNumberText.setPreferredSize(new Dimension(75,20));
        uInformationText.setPreferredSize(new Dimension(400,20));
        int rNumber = new Random().nextInt(range);
        System.out.println(rNumber);

        DefaultListModel listModel = new DefaultListModel();
        JList jList = new JList(listModel);
        JScrollPane jScrollPane = new JScrollPane(jList);

        bSet.addActionListener(new ActionListener() {
            int i = 0;
            @Override
            public void actionPerformed(ActionEvent e) throws NumberFormatException {
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                try {
                    i++;
                    int uNumber = Integer.parseInt(uNumberText.getText());
                    listModel.addElement(i + ". " + uNumber);


                    if (uNumber < range && uNumber >= 0)
                    {
                        if (rNumber > uNumber) {
                            uInformationText.setText("Your type is too small, try one more time");
                            uNumberText.setText("");
                        } else if (rNumber < uNumber) {
                            uInformationText.setText("Your type is too high, try one more time");
                            uNumberText.setText("");
                        } else {
                            uInformationText.setText("Congratulation ! The random number is: " + rNumber + " You do it after: " + i + " times");
                        }
                    }
                    else
                        uInformationText.setText("Yours type is out of range try type your number in 0 to " + range);

                    }
                    catch(NumberFormatException error){
                            uInformationText.setText("Please enter number in range 0 to " + range);
                            uNumberText.setText("");
                    }

            }
        });

        jPanel.add(bSet);
        jPanel.add(uNumberText);
        jPanel.add(jScrollPane);
        jPanel.add(uInformationText);

        jFrame.getContentPane().add(jPanel);
        jFrame.setVisible(true);
    }
}
