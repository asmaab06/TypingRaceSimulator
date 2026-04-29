import java.awt.*;
import java.util.concurrent.TimeUnit;
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
            panel6.add(config4);
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
            JButton customiseButton = new JButton("Customise Typists");
            panel8.add(customiseButton);
            mainPanel.add(panel8);

            customiseButton.addActionListener(e -> {
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
            int numPanels = Integer.parseInt(numPlayers) * 6;
            numPanels = numPanels + 1;
            mainPanel.setLayout(new GridLayout(numPanels, 1));


            String[] symbols = new String[Integer.parseInt(numPlayers)];
            String[] typingStyles = new String[Integer.parseInt(numPlayers)];
            String[] keyboardTypes = new String[Integer.parseInt(numPlayers)];
            String[] userColours = new String[Integer.parseInt(numPlayers)];
            String[] accessoriesList = new String[Integer.parseInt(numPlayers)];



            for (int i = 0; i < Integer.parseInt(numPlayers); i++){
                System.out.println(i);
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
                typingStyles[i] = (String) typingStyleComboBox.getSelectedItem();
                typingStyle.add(typingStyleLabel);
                typingStyle.add(typingStyleComboBox);
                mainPanel.add(typingStyle);

                //Keyboard Type Panel
                JPanel keyboardType = new JPanel();
                keyboardType.setLayout(new GridBagLayout());
                JLabel keyboardTypeLabel = new JLabel("Keyboard Type: ");
                String [] options2 = {"Mechanical", "Membrane", "Touchscreen", "Stenography"};
                JComboBox<String> keyboardTypeComboBox = new JComboBox<>(options2);
                keyboardTypes[i] = (String) keyboardTypeComboBox.getSelectedItem();
                keyboardType.add(keyboardTypeLabel);
                keyboardType.add(keyboardTypeComboBox);
                mainPanel.add(keyboardType);
                

                

                //User colour panel
                JPanel userColour = new JPanel();
                userColour.setLayout(new GridBagLayout());
                JLabel userColourLabel = new JLabel("User Colour: ");
                String [] options3 = {"Red", "Blue", "Green", "Yellow"};
                JComboBox<String> userColourField = new JComboBox<>(options3);
                userColours[i] = (String) userColourField.getSelectedItem();
                userColour.add(userColourLabel);
                userColour.add(userColourField);
                mainPanel.add(userColour);

                //Accessories Panel
                JPanel accessories = new JPanel();
                accessories.setLayout(new GridBagLayout());
                JLabel accessoriesLabel = new JLabel("Accessories: ");
                String [] options4 = {"Wrist Support", "Energy Drink", "Noise-Cancelling Headphones"};
                JComboBox<String> accessoriesComboBox = new JComboBox<>(options4);
                accessoriesList[i] = (String) accessoriesComboBox.getSelectedItem();
                accessories.add(accessoriesLabel);
                accessories.add(accessoriesComboBox);
                mainPanel.add(accessories);

            }

            System.out.println(symbols[0]);
            
            //Start Button
            JPanel startPanel = new JPanel();
            startPanel.setLayout(new GridBagLayout());
            JButton startButton = new JButton("Start Race");
            startPanel.add(startButton);
            mainPanel.add(startPanel);

            startButton.addActionListener(e -> {

                startRace(passageLength, numPlayers, autocorrect, caffeineMode, nightMode, 
                typingStyles, keyboardTypes, userColours, accessoriesList);
            });

            typistFrame.add(mainPanel);

            typistFrame.setVisible(true);
        }

        public static void startRace(String passageLength, String numPlayers, String autocorrect, String caffeineMode, String nightMode, 
         String[] typingStyles, String[] keyboardTypes, 
        String[] userColours, String[] accessoriesList){
            JFrame raceFrame = new JFrame("Typing Race");
            raceFrame.setSize(400, 300);
            raceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel mainPanel = new JPanel();

            //Title Panel
            JPanel titlePanel = new JPanel();
            titlePanel.setLayout(new GridBagLayout());
            JLabel titleLabel = new JLabel("Typing Race");
            titlePanel.add(titleLabel);
            mainPanel.add(titlePanel);

            raceFrame.add(mainPanel);
            raceFrame.setVisible(true);

            int length = 0;
            if (passageLength.equals("Short")){
                length = 20;
            } else if (passageLength.equals("Medium")){
                length = 50;
            } else if (passageLength.equals("Long")){
                length = 100;
            }

            //Begin race

            Typist seat1Typist;
            Typist seat2Typist;
            Typist seat3Typist;
            Typist seat4Typist;
            Typist seat5Typist;
            Typist seat6Typist;

            double MISTYPE_BASE_CHANCE = 0.3;
            int SLIDE_BACK_AMOUNT   = 1;
            int BURNOUT_DURATION = 3;

            boolean finished = false;
            int winner = -1;

            Typist[] typists = new Typist[Integer.parseInt(numPlayers)];
            TypingRace race = new TypingRace(length);
            System.out.println(keyboardTypes[0]);     
            for (int i = 0; i < Integer.parseInt(numPlayers); i++){
                
                Typist typist = new Typist(userColours[i].charAt(0), userColours[i], 0.5);
                typists[i] = typist;
                race.addTypist(typist, i + 1);

            }

            while (!finished){
                
                for (int j = 0; j < Integer.parseInt(numPlayers); j++){
                    race.advanceTypist(typists[j]);
                }
                

                
                printRace();

                
                for (int k = 0; k < Integer.parseInt(numPlayers); k++){
                    if (race.raceFinishedBy(typists[k])){
                        finished = true;
                        winner = k;
                    }
                }

                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (Exception e) {}
            
            }

        }

        public static void printRace(){
            System.out.println("");
        }

        public static void main(String [] args){
            startRaceGUI();
        }

}