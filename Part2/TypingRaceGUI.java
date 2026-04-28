import java.awt.*;
import javax.swing.*;


public class TypingRaceGUI {

    

    public static void startRaceGUI(){
        
        JFrame frame = new JFrame("Typing Race Simulator");

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);

        JButton newButton = new JButton("New Race");
        panel.add(newButton);

        newButton.addActionListener(e -> {
            chooseConfiguration();
        });

        frame.setVisible(true);


        }    

        public static void chooseConfiguration(){
            JFrame newFrame = new JFrame("Typing Race Simulator");
            newFrame.setSize(400, 300);

            newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new GridLayout(8, 1));

            //Panel 1
            JPanel panel1 = new JPanel();
            panel1.setLayout(new GridBagLayout());
            panel1.setBackground(Color.LIGHT_GRAY);
            JLabel configLabel = new JLabel("New Race Configuration");
            panel1.add(configLabel);
            mainPanel.add(panel1);

            //Panel 2
            JPanel panel2 = new JPanel();
            panel2.setLayout(new GridBagLayout());
            JLabel config1 = new JLabel("Passage Selection: ");
            String[] options = {"Short", "Medium", "Long"};
            JComboBox<String> configComboBox = new JComboBox<>(options);
            String passageLength = (String) configComboBox.getSelectedItem();
            panel2.add(config1);
            panel2.add(configComboBox);
            mainPanel.add(panel2);

            //Panel 3
            JPanel panel3 = new JPanel();
            panel3.setLayout(new GridBagLayout());
            JLabel config2 = new JLabel("Seat count: ");
            JTextField seatCountField = new JTextField(6);
            panel3.add(config2);
            panel3.add(seatCountField);
            mainPanel.add(panel3);

            //Panel 4
            JPanel panel4 = new JPanel();
            panel4.setLayout(new GridBagLayout());
            panel4.setBackground(Color.LIGHT_GRAY);
            JLabel configLabel2 = new JLabel("Difficulty Modifiers:");
            panel4.add(configLabel2);
            mainPanel.add(panel4);

            //Panel 5
            JPanel panel5 = new JPanel();
            panel5.setLayout(new GridBagLayout());
            JLabel config3 = new JLabel("Autocorrect On/Off: ");
            String[] options2 = {"On", "Off"};
            JComboBox<String> configComboBox2 = new JComboBox<>(options2);
            String autocorrect = (String) configComboBox2.getSelectedItem();
            panel5.add(config3);
            panel5.add(configComboBox2);
            mainPanel.add(panel5);

            //Panel 6
            JPanel panel6 = new JPanel();
            panel6.setLayout(new GridBagLayout());
            JLabel config4 = new JLabel("Caffeine Mode: ");
            String[] options3 = {"On", "Off"};
            JComboBox<String> configComboBox3 = new JComboBox<>(options3);
            String caffeineMode = (String) configComboBox3.getSelectedItem();
            panel6.add(configComboBox3);
            mainPanel.add(panel6);

            //Panel 7
            JPanel panel7 = new JPanel();
            panel7.setLayout(new GridBagLayout());
            JLabel config5 = new JLabel("Night Mode: ");
            String[] options4 = {"On", "Off"};
            JComboBox<String> configComboBox4 = new JComboBox<>(options4);
            String nightMode = (String) configComboBox4.getSelectedItem();
            panel7.add(config5);
            panel7.add(configComboBox4);
            mainPanel.add(panel7);

            //Panel 8
            JPanel panel8 = new JPanel();
            panel8.setLayout(new GridBagLayout());
            JButton startButton = new JButton("Start Race");
            panel8.add(startButton);
            mainPanel.add(panel8);

            startButton.addActionListener(e -> {
                String numPlayers = seatCountField.getText();
                customiseTypists(passageLength, numPlayers, autocorrect, caffeineMode, nightMode);
            });

            newFrame.add(mainPanel);

            newFrame.setVisible(true);
        }

        public static void customiseTypists(String passageLength, String numPlayers, String autocorrect, String caffeineMode, String nightMode){
            JFrame typistFrame = new JFrame("Typing Race Simulator");
            typistFrame.setSize(400, 300);
            typistFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel mainPanel = new JPanel();
            int numPanels = Integer.parseInt(numPlayers) * 7;
            numPanels = numPanels + 1;
            mainPanel.setLayout(new GridLayout(numPanels, 1));

            for (int i = 0; i < Integer.parseInt(numPlayers); i++){
                JPanel typistPanel = new JPanel();
                typistPanel.setLayout(new GridBagLayout());
                JLabel typistLabel = new JLabel("Typist " + (i + 1));
                typistPanel.setBackground(Color.LIGHT_GRAY);
                typistPanel.add(typistLabel);
                mainPanel.add(typistPanel);

                //Typing Style Panel
                JPanel typingStyle = new JPanel();
                typingStyle.setLayout(new GridBagLayout());
                JLabel typingStyleLabel = new JLabel("Typing Style: ");
                String [] options = {"Touch Typist", "Hunt and Peck", "Phone Thumbs", "Voice-to-Text"};
                JComboBox<String> typingStyleComboBox = new JComboBox<>(options);
                typingStyle.add(typingStyleLabel);
                typingStyle.add(typingStyleComboBox);
                mainPanel.add(typingStyle);

                //Keyboard Type Panel
                JPanel keyboardType = new JPanel();
                keyboardType.setLayout(new GridBagLayout());
                JLabel keyboardTypeLabel = new JLabel("Keyboard Type: ");
                String [] options2 = {"Mechanical", "Membrane", "Touchscreen", "Stenography"};
                JComboBox<String> keyboardTypeComboBox = new JComboBox<>(options2);
                keyboardType.add(keyboardTypeLabel);
                keyboardType.add(keyboardTypeComboBox);
                mainPanel.add(keyboardType);
                

                //User symbol panel
                JPanel userSymbol = new JPanel();
                userSymbol.setLayout(new GridBagLayout());
                JLabel userSymbolLabel = new JLabel("User Symbol: ");
                JTextField userSymbolField = new JTextField(6);
                userSymbol.add(userSymbolLabel);
                userSymbol.add(userSymbolField);
                mainPanel.add(userSymbol);

                //User colour panel
                JPanel userColour = new JPanel();
                userColour.setLayout(new GridBagLayout());
                JLabel userColourLabel = new JLabel("User Colour: ");
                String [] options3 = {"Red", "Blue", "Green", "Yellow"};
                JComboBox<String> userColourField = new JComboBox<>(options3);
                userColour.add(userColourLabel);
                userColour.add(userColourField);
                mainPanel.add(userColour);
            }
            
            typistFrame.add(mainPanel);

            typistFrame.setVisible(true);
        }

        public static void main(String [] args){
            startRaceGUI();
        }

}