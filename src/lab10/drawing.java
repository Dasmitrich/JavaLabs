package lab10;

import javax.swing.*;
import java.awt.*;

public class drawing {
    drawing() {
        JFrame Window = new JFrame() {
        };
        Window.setVisible(true);
        Window.setDefaultCloseOperation(Window.EXIT_ON_CLOSE);
        Window.setTitle("Калькулятор");
        Toolkit tool = Toolkit.getDefaultToolkit();
        Dimension dim = tool.getScreenSize();
        Window.setBounds(dim.width / 2 - 250, dim.height / 2 - 250, 300, 420);
        Window.add(new Panel());
    }
}

class run{
    public static void main(String[] args) {
        {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new drawing();
                }
            });
        }
    }
}