import java.awt.*;
import javax.swing.*;


public class TypingRaceGUI {

    

    public static void startRaceGUI(){
        
        JFrame frame = new JFrame("Typing Race Simulator");

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);

        JButton startButton = new JButton("Start Race");
        panel.add(startButton);

        startButton.addActionListener(e -> {
            chooseConfiguration();
        });

        frame.setVisible(true);


        }    

        public static void chooseConfiguration(){
            JFrame newFrame = new JFrame("Typing Race Simulator");
            newFrame.setSize(400, 300);

            newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //Panel 1
            JPanel panel1 = new JPanel();
            panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
            JLabel configLabel = new JLabel("New Race Configuration");
            panel1.add(configLabel);
            newFrame.add(panel1);


            newFrame.setVisible(true);
        }

        public static void main(String [] args){
            startRaceGUI();
        }

}