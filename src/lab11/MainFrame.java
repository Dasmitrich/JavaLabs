package lab11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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

                switch (logic.cnt % 2) {
                    case 0:
                        b.setText("0");
                        logic.EndOfGame(b);
                        break;
                    case 1:
                        b.setText("X");
                        logic.EndOfGame(b);
                        break;
                }
                b.setEnabled(false);
                System.out.println(button1.getText());
            }
        };
        for (int i = 0; i < 9; i++) {
            buttons[i].setFont(myFont);
            buttons[i].setText("*");
            buttons[i].addActionListener(btnListener);
        }
        button1.setText("1");
        button5.setText("1");
        button9.setText("1");
    }

    public class Logic{
        int cnt = 1;

        public void EndOfGame(JButton button){
            cnt++;

            if(
                    button1.getText() == button2.getText() && button1.getText() == button3.getText()||
                    button4.getText() == button5.getText() && button4.getText() == button6.getText()||
                    button7.getText() == button8.getText() && button7.getText() == button9.getText()||
                    button1.getText() == button5.getText() && button1.getText() == button9.getText()||
                    button1.getText() == button4.getText() && button1.getText() == button7.getText()||
                    button2.getText() == button5.getText() && button2.getText() == button9.getText()||
                    button3.getText() == button6.getText() && button3.getText() == button9.getText()||
                    button3.getText() == button5.getText() && button3.getText() == button7.getText()
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
            if (cnt == 10) {
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
}