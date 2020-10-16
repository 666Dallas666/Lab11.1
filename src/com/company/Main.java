package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Main extends JFrame {
    int attempts = 0;
    public Main(){
        JButton button = new JButton("Попытать удачу");
        JTextField textField = new JTextField();
        JLabel label = new JLabel();
        label.setText("Введите число:");
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        label.setBounds(200,70,100,20);
        textField.setBounds(100,100,300,40);
        button.setBounds(100,220,300,40);
        add(textField);
        add(button);
        add(label);
        int number = (int)(Math.random()*21);
        System.out.println("Задуманное число: " + number);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                boolean counter = false;
                int inputNumber = Integer.parseInt(textField.getText());
                attempts++;
                if (inputNumber == number) {
                    counter = true;
                    JOptionPane.showMessageDialog(null, "Вы выиграли!\n (Ничего)");
                    setVisible(false);
                    dispose();
                }
                else if (inputNumber < number){
                    textField.setText("");
                    JOptionPane.showMessageDialog(null,"Задуманное число больше\nОсталось попыток: " + (3 - attempts));
                }
                else {
                    textField.setText("");
                    JOptionPane.showMessageDialog(null,"Задуманное число меньше\nОсталось попыток: " + (3 - attempts));
                }
                if (attempts == 3 && !counter){
                    JOptionPane.showMessageDialog(null,"Вы проиграли");
                    remove(button);
                    remove(textField);
                    setVisible(false);
                    dispose();
                }
            }
        });
        setVisible(true);
    }
    public static void main(String[] args) {
        new Main();
    }
}