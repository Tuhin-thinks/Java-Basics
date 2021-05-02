/*
  A simple application to count button clicks on the window
 */
package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI implements ActionListener {
    private int clicks = 0;
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JButton button = new JButton();
    private JLabel label = new JLabel();

    public static void centreWindow(JFrame frame, int width, int height) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);

        // calculate perfect center
        int perf_x = (int) x - width/2;
        int perf_y = (int) y - height/2;

        frame.setLocation(perf_x, perf_y);
    }

    public UI() {
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0,1));
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        centreWindow(frame, 480, 250);  // this centers the window [w.r.t the screen]
        frame.setTitle("Click Counter");
        frame.setPreferredSize(new Dimension(480, 250));
        frame.pack();
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);

        label.setText("Number of clicks:"+clicks++);
        button.setText("Click Me!");
        Dimension button_d = new Dimension(50, 10);
        button.setMaximumSize(button_d);
        button.setSize(50, 10);
        button.addActionListener(this);
    }
    public static void main(String[] args){
        new UI();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        label.setText("Number of clicks:"+clicks++);
    }
}
