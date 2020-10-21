package lab11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class MainFrame extends JFrame {
    private JPanel panel1;
    protected JButton button4;
    protected JButton button1;
    protected JButton button7;
    protected JButton button5;
    protected JButton button2;
    protected JButton button8;
    protected JButton button3;
    protected JButton button6;
    protected JButton button9;

    Font myFont = new Font("Serif", Font.BOLD, 50);
    JButton buttons[] = {button1, button2, button3, button4, button5, button6, button7, button8, button9};
    Logic logic = new Logic();
    int player = 1; // 0 - игра pvp; 1 - игра с компьютером
    int cicleShield = 0;

    public MainFrame() {
        add(panel1);
        Toolkit tool = Toolkit.getDefaultToolkit();
        Dimension dim = tool.getScreenSize();
        setBounds(dim.width / 2 - 250, dim.height / 2 - 250, 400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ActionListener btnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JButton b;
                b = (JButton) e.getSource();
                if(player == 1) {
                     if(logic.cnt % 2 == 1){
                           b.setText("X");
                           logic.EndOfGameCheck();
                           b.setEnabled(false);
                    }
                    if (logic.cnt % 2 == 0) {
                        System.out.println("aistep");
                        new AiLogic().BotStep();
                    }
                }
                if(player == 0){
                        switch (logic.cnt % 2) {
                            case 0:
                                b.setText("0");
                                logic.EndOfGameCheck();
                                break;
                            case 1:
                                b.setText("X");
                                logic.EndOfGameCheck();
                                break;
                        }
                   b.setEnabled(false);
                }
            }
        };

        for (int i = 0; i < 9; i++) {
            buttons[i].setFont(myFont);
            buttons[i].setText("*");
            buttons[i].addActionListener(btnListener);
        }
    }

    class Logic{
        int cnt = 1;

        public void EndOfGameCheck(){

            cnt++;
            System.out.println("cnt++");

                if(
                        (button1.getText() !="*" && (button1.getText() == button2.getText() && button1.getText() == button3.getText()))||
                    (button4.getText() !="*" && (button4.getText() == button5.getText() && button4.getText() == button6.getText()))||
                    (button7.getText() !="*" && (button7.getText() == button8.getText() && button7.getText() == button9.getText()))||
                    (button1.getText() !="*" && (button1.getText() == button5.getText() && button1.getText() == button9.getText()))||
                    (button1.getText() !="*" && (button1.getText() == button4.getText() && button1.getText() == button7.getText()))||
                    (button2.getText() !="*" && (button2.getText() == button5.getText() && button2.getText() == button8.getText()))||
                    (button3.getText() !="*" && (button3.getText() == button6.getText() && button3.getText() == button9.getText()))||
                    (button3.getText() !="*" && (button3.getText() == button5.getText() && button3.getText() == button7.getText()))
            ) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), cnt % 2 + 1 + " Player won!");
                            dispose();
                            new Run().main(null);
                    }
                });
            }
            else if (cnt == 10) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Draw!");
                            dispose();
                            new Run().main(null);
                    }
                });
            }
        }
    }

    class AiLogic {
        int btnvalue[] = {20, 10, 20, 10, 15, 10, 20, 10, 20};
        int PathsValue[] = new int[8];

        public void BotStep() {

            for (int i = 0; i < 9; i++) {
                if (buttons[i].getText() == "0") {
                    btnvalue[i] += 30;
                    System.out.println("0: " + btnvalue[i]);
                }
                if (buttons[i].getText() == "X") {
                    btnvalue[i] = 0;
                    System.out.println("X: " + btnvalue[i]);
                }
                if (buttons[i].getText() == "*") {
                    btnvalue[i] += 5;
                    System.out.println("*: " + btnvalue[i]);
                }
            }


            int[][] Paths = {{btnvalue[0], btnvalue[1], btnvalue[2]}, {btnvalue[3], btnvalue[4], btnvalue[5]},
                    {btnvalue[6], btnvalue[7], btnvalue[8]}, {btnvalue[0], btnvalue[4], btnvalue[8]},
                    {btnvalue[0], btnvalue[3], btnvalue[6]}, {btnvalue[1], btnvalue[4], btnvalue[7]},
                    {btnvalue[2], btnvalue[5], btnvalue[8]}, {btnvalue[2], btnvalue[4], btnvalue[6]}
            };

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 3; j++) {
                    PathsValue[i] += Paths[i][j];
                }
                System.out.println("pathvalue:" + i + " " + PathsValue[i]);
            }

            int bestPathValue = 0;
            int worstPathValue = 100;
            int n = 0;

            for (int i = 0; i < 8; i++) {
                if (bestPathValue < PathsValue[i])
                    bestPathValue = PathsValue[i];
                if (worstPathValue > PathsValue[i])
                    worstPathValue = PathsValue[i];
            }
            System.out.println("worst value: "+ worstPathValue);

            for (int i = 0; i < 8; i++) {
                if (bestPathValue == PathsValue[i])
                    n++;
            }

            int bestChoice[] = new int[n];
            n = 0;
            for (int i = 0; i < 8; i++) {
                if (bestPathValue == PathsValue[i]) {
                    bestChoice[n] = i;
                    System.out.println("choice: " + bestChoice[n]);
                    n++;
                }
            }

            botSetButton(bestChoice, worstPathValue, cicleShield);
        }

        void botSetButton(int[] bestChoice, int worstPathValue, int cicleShield) {
            cicleShield++;

            int bestFinalChoice = bestChoice[new Random().nextInt(bestChoice.length)];

            if (cicleShield > 2) {
                bestFinalChoice = worstPathChoose(worstPathValue);
                System.out.println("using of worst value: " + bestFinalChoice);
            }

            System.out.println(bestFinalChoice);

            switch (bestFinalChoice) {
                case 0:
                    if (button1.getText() != "0" && button1.getText() != "X" && button1.isEnabled()) {
                        button1.setText("0");
                        button1.setEnabled(false);
                    } else if (button3.getText() != "0" && button3.getText() != "X" && button3.isEnabled()) {
                        button3.setText("0");
                        button3.setEnabled(false);
                    } else if (button2.getText() != "0" && button2.getText() != "X" && button2.isEnabled()) {
                        button2.setText("0");
                        button2.setEnabled(false);
                    } else if(cicleShield<2)
                        botSetButton(bestChoice, worstPathValue, cicleShield);
                    break;
                case 1:
                    if (button4.getText() != "0" && button4.getText() != "X" && button4.isEnabled()) {
                        button4.setText("0");
                        button4.setEnabled(false);
                    } else if (button6.getText() != "0" && button6.getText() != "X" && button6.isEnabled()) {
                        button6.setText("0");
                        button6.setEnabled(false);
                    } else if (button5.getText() != "0" && button5.getText() != "X" && button5.isEnabled()) {
                        button5.setText("0");
                        button5.setEnabled(false);
                    } else if(cicleShield<2)
                        botSetButton(bestChoice, worstPathValue, cicleShield);
                    break;
                case 2:
                    if (button7.getText() != "0" && button7.getText() != "X" && button7.isEnabled()) {
                        button7.setText("0");
                        button7.setEnabled(false);
                    } else if (button8.getText() != "0" && button8.getText() != "X" && button8.isEnabled()) {
                        button8.setText("0");
                        button8.setEnabled(false);
                    } else if (button9.getText() != "0" && button9.getText() != "X" && button9.isEnabled()) {
                        button9.setText("0");
                        button9.setEnabled(false);
                    } else if(cicleShield<2)
                        botSetButton(bestChoice, worstPathValue, cicleShield);
                    break;
                case 3:
                    if (button1.getText() != "0" && button1.getText() != "X" && button1.isEnabled()) {
                        button1.setText("0");
                        button1.setEnabled(false);
                    } else if (button9.getText() != "0" && button9.getText() != "X" && button9.isEnabled()) {
                        button9.setText("0");
                        button9.setEnabled(false);
                    } else if (button5.getText() != "0" && button5.getText() != "X" && button5.isEnabled()) {
                        button5.setText("0");
                        button5.setEnabled(false);
                    } else if(cicleShield<2)
                        botSetButton(bestChoice, worstPathValue, cicleShield);

                    break;
                case 4:
                    if (button1.getText() != "0" && button1.getText() != "X" && button1.isEnabled()) {
                        button1.setText("0");
                        button1.setEnabled(false);
                    } else if (button7.getText() != "0" && button7.getText() != "X" && button7.isEnabled()) {
                        button7.setText("0");
                        button7.setEnabled(false);
                    } else if (button4.getText() != "0" && button4.getText() != "X" && button4.isEnabled()) {
                        button4.setText("0");
                        button4.setEnabled(false);
                    } else if(cicleShield<2)
                        botSetButton(bestChoice, worstPathValue, cicleShield);
                    break;
                case 5:
                    if (button2.getText() != "0" && button2.getText() != "X" && button2.isEnabled()) {
                        button2.setText("0");
                        button2.setEnabled(false);
                    } else if (button8.getText() != "0" && button8.getText() != "X" && button8.isEnabled()) {
                        button8.setText("0");
                        button8.setEnabled(false);
                    } else if (button5.getText() != "0" && button5.getText() != "X" && button5.isEnabled()) {
                        button5.setText("0");
                        button5.setEnabled(false);
                    }else if(cicleShield<2)
                        botSetButton(bestChoice, worstPathValue, cicleShield);

                    break;
                case 6:
                    if (button3.getText() != "0" && button3.getText() != "X" && button3.isEnabled()) {
                        button3.setText("0");
                        button3.setEnabled(false);
                    } else if (button9.getText() != "0" && button9.getText() != "X" && button9.isEnabled()) {
                        button9.setText("0");
                        button9.setEnabled(false);
                    } else if (button6.getText() != "0" && button6.getText() != "X" && button6.isEnabled()) {
                        button6.setText("0");
                        button6.setEnabled(false);
                    } else if(cicleShield<2)
                        botSetButton(bestChoice, worstPathValue, cicleShield);

                    break;
                case 7:
                    if (button3.getText() != "0" && button3.getText() != "X" && button3.isEnabled()) {
                        button3.setText("0");
                        button3.setEnabled(false);
                    } else if (button7.getText() != "0" && button7.getText() != "X" && button7.isEnabled()) {
                        button7.setText("0");
                        button7.setEnabled(false);
                    } else if (button5.getText() != "0" && button5.getText() != "X" && button5.isEnabled()) {
                        button5.setText("0");
                        button5.setEnabled(false);
                    } else if(cicleShield<2)
                        botSetButton(bestChoice, worstPathValue, cicleShield);
                    break;
            }
            if(cicleShield<2)
                logic.EndOfGameCheck();
                System.out.println("cnt: " + logic.cnt);
            }

            int worstPathChoose(int worstPathValue){
            int n =0;
            for (int i = 0; i < 8; i++) {
                if (worstPathValue == PathsValue[i])
                    n++;
            }

            int bestChoice[] = new int[n];
            n = 0;
            for (int i = 0; i < 8; i++) {
                if (worstPathValue == PathsValue[i]) {
                    bestChoice[n] = i;
                    n++;
                }
            }
            int WorstPath = bestChoice[new Random().nextInt(bestChoice.length)];
            return WorstPath;
        }
    }
}