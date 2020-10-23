package lab10;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel {

    private JButton numbers[] = new JButton[10];
    private JTextField field = new JTextField();
    private JButton backspace = new JButton("Backspace");
    private JButton clear = new JButton("Cl");
    private JButton equal = new JButton("=");
    private JButton plus = new JButton("+");
    private JButton multiply = new JButton("*");
    private JButton divide = new JButton("/");
    private JButton minus = new JButton("-");
    private  JButton dot = new JButton(".");
    private double num1 = 0;
    private double num2 = 0;
    private char sym;

    public Panel(){

        setLayout(null);

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                numbers[i*3+j+1] = new JButton((j*3+i+1)+"");
                numbers[i*3+j+1].setBounds(i*(50+20)+10, 100 + j * (50+20)+10, 50, 50);
                add(numbers[i*3+j+1]);
            }
        }

        numbers[0] = new JButton("0");
        numbers[0].setBounds(80, 320, 50, 50);
        add(numbers[0]);

        plus.setBounds(220, 110, 50, 50);
        add(plus);

        minus.setBounds(220, 180, 50, 50);
        add(minus);

        multiply.setBounds(220, 250, 50, 50);
        add(multiply);

        divide.setBounds(220, 320, 50, 50);
        add(divide);

        clear.setBounds(10, 320, 50, 50);
        add(clear);

        equal.setBounds(150, 320, 50, 50);
        add(equal);

        dot.setBounds(220, 80, 50, 20);
        add(dot);

        backspace.setBounds(10, 80, 190, 20);
        add(backspace);

        field.setEditable(false);
        field.setBounds(20, 20, 240, 50);
        add(field);

        ActionListener operListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dot.setEnabled(true);
                JButton temp = new JButton();
                temp = (JButton) e.getSource();

                String str = field.getText();
                if(str.length()!=0) {
                    if (temp == clear) {
                        field.setText(null);
                        num1 = 0;
                        num2 = 0;
                    }
                    if (temp == backspace) {
                        str = str.substring(0, str.length() - 1);
                        field.setText(str);
                    }
                    if (temp == plus) {
                        num1 = Double.parseDouble(field.getText());
                        System.out.println(num1);
                        field.setText(null);
                        sym = '+';
                    }
                    if (temp == minus) {
                        num1 = Double.parseDouble(field.getText());
                        field.setText(null);
                        sym = '-';
                    }
                    if (temp == multiply) {
                        num1 = Double.parseDouble(field.getText());
                        field.setText(null);
                        sym = '*';
                    }
                    if (temp == divide) {
                        num1 = Double.parseDouble(field.getText());
                        field.setText(null);
                        sym = '/';
                    }
                    if(temp == dot){
                        field.setText(field.getText() + ".");
                        dot.setEnabled(false);
                    }

                    if(temp == equal) {

                        num2 = Double.parseDouble(field.getText());
                        field.setText(null);

                        switch (sym) {
                            case '+':
                                num1 += num2;
                                field.setText(Double.toString(num1));
                                break;
                            case '-':
                                num1 -= num2;
                                field.setText(Double.toString(num1));
                                break;
                            case '*':
                                num1 *= num2;
                                field.setText(Double.toString(num1));
                                break;
                            case '/':
                                if (num2 != 0.0)
                                    num1 /= num2;
                                else
                                    System.err.println("Деление на ноль невозможно");
                                field.setText(Double.toString(num1));
                                break;
                        }
                    }
                }
            }
        };
        clear.addActionListener(operListener);
        backspace.addActionListener(operListener);
        equal.addActionListener(operListener);
        plus.addActionListener(operListener);
        minus.addActionListener(operListener);
        divide.addActionListener(operListener);
        multiply.addActionListener(operListener);

        ActionListener numListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton b = new JButton();
                b = (JButton) e.getSource();
                if(b == dot)
                    dot.setEnabled(false);

                field.setText(field.getText() + b.getText());
            }
        };
        for(JButton but: numbers){
            but.addActionListener(numListener);
        }
        dot.addActionListener(operListener);
    }
}