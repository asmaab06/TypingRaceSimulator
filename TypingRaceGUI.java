import javax.swing.*;

public class TypingRaceGUI {
    public static void startRaceGUI(){

        JFrame frame = new JFrame("Typing Race Simulator");

        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);

        JButton startButton = new JButton("Start Race");
        panel.add(startButton);

        frame.setVisible(true);
        }

        public static void main(String [] args){
            startRaceGUI();
        }


}