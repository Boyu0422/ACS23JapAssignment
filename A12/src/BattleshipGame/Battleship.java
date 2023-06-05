/**
 * File name: Battleship.java
 * identification: Boyu Li 041003345
 * Course: CST8221 - JAP, Lab Section: 302
 * Assignment: A12
 * Professor: Paulo Sousa
 * Date: 6/2/2023
 * Compiler: Oracle Open JDK - version: 20.0.1 2023-04-18
 * Purpose: To utilize the Java Swing to visualize the game interface
 * */

package BattleshipGame;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.io.Serial;

/**
 * Class name: Battleship
 * Methods list:
 * 1. initializeMainWindow
 * 2. initializeControlPanel
 * 3. initializeUserPanel
 * 4. initializeAdversaryPanel
 * 5. launchInterface
 * 6. addListenerForComboBox
 * 7. addListenerForButton
 * 8. setLanguage
 * 9. refreshInterface
 * Constants list:
 * 1. DEFAULT_DIMENSION
 * 2. serialVersionUID
 * Purpose: The class implements the user interface for game battleship
 * @author Boyu Li
 * @version 1.0
 * @see java.awt javax.swing java.io
 * @since 20.0.1
 * */

public class Battleship extends JFrame{
    /**
     * Method name: Battleship
     * Purpose: Overload constructor
     * Algorithm: no
     * */
    Battleship(){}
    /**
     * serialVersionUID
     * */
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * The title of the game
     * */
    String TITLE = "Battleship (Boyu Li 345)";

    /**
     * The label for language button
     * */
    String LABLANG = "Languages: ";

    /**
     * The first language option
     * */
    String LANG1 = "English";

    /**
     * The second language option
     * */
    String LANG2 = "Chinese";

    /**
     * The label for time text field
     * */
    String LABTIME = "Time: ";

    /**
     * The button name for reset button
     * */
    String BUTRST = "Reset";

    /**
     * The label for dimension button
     * */
    String LABDIME = "Dimension: ";

    /**
     * The user panel of the game
     * */
    JPanel userPanel;

    /**
     * The button name for play button
     * */
    String BUPLAY = "Play";

    /**
     * The button name for random button
     * */

    String BURAND = "Random";

    /**
     * The button name for design button
     * */
    String BUDESIGN = "Design";

    /**
     * The adversary panel of the game
     * */
    JPanel adversaryPanel;

    /**
     * The control panel of the game
     * */
    JPanel controlPanel;

    /**
     * The logo of the game
     * */
    JLabel gameLogo;

    /**
     * The combo box for language switching
     * */
    JComboBox<String> languageBox;

    /**
     * The panel for the language switching component of the game
     * */
    JPanel languagePanel;

    /**
     * The combo box for dimension switching
     * */
    JComboBox<Integer> dimensionBox;

    /**
     * The panel for the dimension switching
     */
    JPanel dimensionPanel;

    /**
     * The button for design mode switching
     * */
    JButton designModeButton;

    /**
     * The button for random mode switching
     * */
    JButton randModeButton;

    /**
     * The panel for design mode and random mode
     * */
    JPanel modePanel;

    /**
     * The text area to display the game history/log
     * */
    JTextArea historyArea;

    /**
     * The panel for the game history displaying component
     * */

    JPanel historyAreaPanel;

    /**
     * The label for the game time text area
     * */
    JLabel timeLabel;

    /**
     * The text field to display the game time
     * */
    JTextField timeTextFiled;

    /**
     * the panel for game time displaying component
     * */
    JPanel timePanel;

    /**
     * The game resetting button
     * */
    JButton resetButton;

    /**
     * The panel for game resetting component
     * */
    JPanel resetPanel;

    /**
     * The game playing button
     * */
    JButton playButton;

    /**
     * The panel for game playing component
     * */
    JPanel playPanel;

    /**
     * The panel to display the character I at user panel
     * */
    JPanel panelI;

    /**
     * The panel to display the character U at user panel
     * */
    JPanel panelU;

    /**
     * The default dimension for the game
     * */
    static final Integer DEFAULT_DIMENSION = 8;

    /**
     * The x coordinates of the grid on the panel
     * */
    JPanel XCoordinates;

    /**
     * The y coordinates of the grid on the panel
     * */
    JPanel YCoordinates;

    /**
     * The panel to display the grid of user panel
     * */
    JPanel userGridPanel;

    /**
     * The panel for user life displaying component
     * */
    JPanel userLifePanel;

    /**
     * The progress bar to display the life of the user
     * */
    JProgressBar userLifeProgressBar;

    /**
     * The label of user life
     * */
    JLabel userLifeLabel;

    /**
     * The panel to display the grid of adversary panel
     * */
    JPanel adversaryGridPanel;

    /**
     * The panel for adversary life displaying component
     * */
    JPanel adversaryLifePanel;

    /**
     * The progress bar to display the life of the adversary
     * */
    JProgressBar adversaryLifeProgressBar;

    /**
     * The label of adversary life
     * */
    JLabel adversaryLifeLabel;

    /**
     * The array to manage the buttons from the user panel grid
     * */
    JButton[][] userPanelGridButtons;

    /**
     * The array to manage the buttons from the adversary panel grid
     * */
    JButton[][] adversaryPanelGridButtons;

    /**
     * Method name: initializeMainWindow
     * Purpose: To initialize the main interface and the component of the game
     * Algorithm: The method utilizes the Java Swing to visualize the main window of the game
     * */
    public void initializeMainWindow() {
        //Set up and initialize of the main windows with the basic characters
        setTitle(TITLE);
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 1, 1);
        setLayout(flowLayout);
        setResizable(false);
        setSize(1000, 488);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*
        * Set up and initialize the background color of user, adversary and control panel
        * */
        userPanel = new JPanel();
        userPanel.setBackground(Color.blue);

        adversaryPanel = new JPanel();
        adversaryPanel.setBackground(Color.yellow);

        controlPanel = new JPanel();
        controlPanel.setBackground(Color.gray);

        //Set up and initialize the size of the user, adversary and control panel
        userPanel.setPreferredSize(new Dimension(390, 449));
        controlPanel.setPreferredSize(new Dimension(200, 449));
        adversaryPanel.setPreferredSize(new Dimension(390, 449));


        //Adding the three panels to the main frame
        add(userPanel);
        add(controlPanel);
        add(adversaryPanel);
    }

    /**
     * Method name: initializeUserPanel
     * Purpose: To initialize the interface and components of user panel
     * Algorithm: The method utilizes the Java Swing to visualize the user panel and
     * manage the grids by array
     * */
    public void initializeControlPanel() {
        //Set the layout of control panel to box layout
        BoxLayout boxLayout = new BoxLayout(controlPanel, BoxLayout.Y_AXIS);
        controlPanel.setLayout(boxLayout);
        /*
        * Set up and add the game logo for the game
        * */
        JPanel logoPanel;
        logoPanel = new JPanel();
        gameLogo = new JLabel();
        gameLogo.setIcon(new ImageIcon("../bin/images/logo.png"));
        gameLogo.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoPanel.add(gameLogo);
        controlPanel.add(logoPanel);

        //Set up and initialize the panels for game mode switching component
        designModeButton = new JButton(BUDESIGN);
        randModeButton = new JButton(BURAND);
        modePanel = new JPanel();
        modePanel.add(designModeButton);
        modePanel.add(randModeButton);
        controlPanel.add(modePanel);

        //Set up and initialize the language box for game language switching component
        JLabel languageLabel = new JLabel(LABLANG);
        String[] allLanguages = {LANG1, LANG2};
        languageBox = new JComboBox<>(allLanguages);
        languageBox.setSelectedIndex(0);
        languagePanel = new JPanel();
        languagePanel.add(languageLabel);
        languagePanel.add(languageBox);
        controlPanel.add(languagePanel);

        //Set up and initialize the dimension box for game dimension switching component
        JLabel dimensionLabel = new JLabel(LABDIME);
        Integer[] allDimensions = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        dimensionBox = new JComboBox<>(allDimensions);
        dimensionBox.setSelectedIndex(7);
        dimensionPanel = new JPanel();
        dimensionPanel.add(dimensionLabel);
        dimensionPanel.add(dimensionBox);
        controlPanel.add(dimensionPanel);

        //Set up and initialize the game log text area for game history displaying component
        historyArea = new JTextArea();
        historyArea.setEditable(false);
        historyArea.setPreferredSize(new Dimension(180, 240));
        historyArea.setBackground(Color.WHITE);
        historyAreaPanel = new JPanel();
        historyAreaPanel.add(historyArea);
        controlPanel.add(historyAreaPanel);

        //Set up and initialize the game time text field for game time displaying component
        timeLabel = new JLabel(LABTIME);
        timeTextFiled = new JTextField();
        timeTextFiled.setEditable(false);
        timeTextFiled.setPreferredSize(new Dimension(50, 20));
        timePanel = new JPanel();
        timePanel.add(timeLabel);
        timePanel.add(timeTextFiled);
        controlPanel.add(timePanel);

        //Set up and initialize the reset button for the game resetting component
        resetButton = new JButton(BUTRST);
        resetPanel = new JPanel();
        resetPanel.add(resetButton);
        controlPanel.add(resetPanel);

        //Set up and initialize the play button for the game playing component
        playButton = new JButton(BUPLAY);
        playPanel = new JPanel();
        playPanel.add(playButton);
        controlPanel.add(playPanel);
    }

    /**
     * Method name: initializeUserPanel
     * Purpose: To initialize the interface and components of user panel
     * Algorithm: The method utilizes the Java Swing to visualize the user panel and
     * manage the grids by array
     * */
    public void initializeUserPanel() {
        //Set up the layout of user panel to flowlayout
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 1, 1);
        userPanel.setLayout(flowLayout);
        GridLayout gridLayout1 = new GridLayout(1, DEFAULT_DIMENSION, 1, 1);

        //Set up and initialize the X coordinates of the user panel to display the coordinates of the grid
        XCoordinates = new JPanel();
        XCoordinates.setLayout(gridLayout1);
        XCoordinates.setPreferredSize(new Dimension(337, 50));

        //Initialize and set up the label of letter I and add it to the user panel
        panelI = new JPanel();
        JLabel textI = new JLabel("I", JLabel.CENTER);
        panelI.setPreferredSize(new Dimension(50, 50));
        panelI.setLayout(new BorderLayout());
        panelI.add(textI, BorderLayout.CENTER);
        userPanel.add(panelI);

        //Use double for loop to fulfil all the X coordinates for user panel
        for (int i = 97; i < DEFAULT_DIMENSION + 97; i++) {
            char letter = (char) i;
            String letterString = Character.toString(letter);
            JLabel coordinateLabel = new JLabel(letterString, JLabel.CENTER);
            XCoordinates.add(coordinateLabel);
        }
        userPanel.add(XCoordinates);

        //Set up and initialize the Y coordinates of the user panel to display the coordinates of the grid
        GridLayout gridLayout2 = new GridLayout(DEFAULT_DIMENSION, 1, 1, 1);
        YCoordinates = new JPanel();
        YCoordinates.setPreferredSize(new Dimension(50, 337));
        YCoordinates.setLayout(gridLayout2);

        //Use double for loop to fulfil all the Y coordinates for user panel
        for (int i = 65; i < DEFAULT_DIMENSION + 65; i++) {
            char letter = (char) i;
            String letterString = Character.toString(letter);
            JLabel coordinateLabel = new JLabel(letterString, JLabel.CENTER);
            YCoordinates.add(coordinateLabel);
        }
        userPanel.add(YCoordinates);

        //Set up the user panel grid
        userGridPanel = new JPanel();
        userGridPanel.setPreferredSize(new Dimension(337, 337));
        GridLayout gridLayout3 = new GridLayout(DEFAULT_DIMENSION, DEFAULT_DIMENSION, 1, 1);
        userGridPanel.setLayout(gridLayout3);

        //Initialize each buttons of the grid on user panel by double for loop
        userPanelGridButtons = new JButton[8][8];
        for (int i = 0; i < DEFAULT_DIMENSION; i++) {
            for (int j = 0; j < DEFAULT_DIMENSION; j++) {
                JButton button = new JButton();
                userPanelGridButtons[i][j] = button;
                userGridPanel.add(userPanelGridButtons[i][j]);
            }
        }
        userPanel.add(userGridPanel);

        //Initialize and set up the life progress bar for the user panel
        userLifeProgressBar = new JProgressBar(0, 100);
        userLifeProgressBar.setPreferredSize(new Dimension(280, 50));
        userLifeLabel = new JLabel("Live1: ");
        userLifePanel = new JPanel();
        userLifePanel.setPreferredSize(new Dimension(388, 100));
        userLifePanel.add(userLifeLabel);
        userLifePanel.add(userLifeProgressBar);
        userPanel.add(userLifePanel);
    }


    /**
     * Method name: launchInterface
     * Purpose: To lunch the interface of the game
     * Algorithm: no
     * manage the grids by array
     * */
    public void launchInterface(){
        initializeMainWindow();
        initializeControlPanel();
        initializeUserPanel();
        initializeAdversaryPanel();
        refreshInterface();
    }


    /**
     * Method name: initializeAdversaryPanel
     * Purpose: To initialize the interface and components of adversary panel
     * Algorithm: The method utilizes the Java Swing to visualize the adversary panel and
     * manage the grids by array
     * */
    public void initializeAdversaryPanel() {
        //Set up the layout of adversary panel to flowlayout
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 1, 1);
        adversaryPanel.setLayout(flowLayout);
        GridLayout gridLayout1 = new GridLayout(1, DEFAULT_DIMENSION, 1, 1);

        //Set up and initialize the X coordinates of the adversary panel to display the coordinates of the grid
        XCoordinates = new JPanel();
        XCoordinates.setLayout(gridLayout1);
        XCoordinates.setPreferredSize(new Dimension(337, 50));
        panelU = new JPanel();

        //Initialize and set up the label of letter U and add it to the adversary panel
        JLabel textI = new JLabel("U", JLabel.CENTER);
        panelU.setPreferredSize(new Dimension(50, 50));
        panelU.setLayout(new BorderLayout());
        panelU.add(textI, BorderLayout.CENTER);
        adversaryPanel.add(panelU);

        //Use double for loop to fulfil all the X coordinates for adversary panel
        for (int i = 97; i < DEFAULT_DIMENSION + 97; i++) {
            char letter = (char) i;
            String letterString = Character.toString(letter);
            JLabel coordinateLabel = new JLabel(letterString, JLabel.CENTER);
            XCoordinates.add(coordinateLabel);
        }
        adversaryPanel.add(XCoordinates);

        //Set up and initialize the Y coordinates of the adversary panel to display the coordinates of the grid
        GridLayout gridLayout2 = new GridLayout(DEFAULT_DIMENSION, 1, 1, 1);
        YCoordinates = new JPanel();
        YCoordinates.setPreferredSize(new Dimension(50, 337));
        YCoordinates.setLayout(gridLayout2);

        //Use double for loop to fulfil all the Y coordinates for adversary panel
        for (int i = 65; i < DEFAULT_DIMENSION + 65; i++) {
            char letter = (char) i;
            String letterString = Character.toString(letter);
            JLabel coordinateLabel = new JLabel(letterString, JLabel.CENTER);
            YCoordinates.add(coordinateLabel);
        }

        //Set up the adversary panel grid
        adversaryPanel.add(YCoordinates);
        adversaryGridPanel = new JPanel();
        adversaryGridPanel.setPreferredSize(new Dimension(337, 337));
        GridLayout gridLayout3 = new GridLayout(DEFAULT_DIMENSION, DEFAULT_DIMENSION, 1, 1);
        adversaryGridPanel.setLayout(gridLayout3);

        //Initialize each buttons of the grid on user panel by double for loop
        adversaryPanelGridButtons = new JButton[8][8];
        for (int i = 0; i < DEFAULT_DIMENSION; i++) {
            for (int j = 0; j < DEFAULT_DIMENSION; j++) {
                JButton button = new JButton();
                adversaryPanelGridButtons[i][j] = button;
                adversaryGridPanel.add(adversaryPanelGridButtons[i][j]);
            }
        }

        //Initialize and set up the life progress bar for the adversary panel
        adversaryPanel.add(adversaryGridPanel);
        adversaryLifeProgressBar = new JProgressBar(0, 100);
        adversaryLifeProgressBar.setPreferredSize(new Dimension(280, 50));
        adversaryLifeLabel = new JLabel("Live2: ");
        adversaryLifePanel = new JPanel();
        adversaryLifePanel.setPreferredSize(new Dimension(388, 100));
        adversaryLifePanel.add(adversaryLifeLabel);
        adversaryLifePanel.add(adversaryLifeProgressBar);
        adversaryPanel.add(adversaryLifePanel);
    }

    /**
     * Method name: addListenerForComboBox
     * Purpose: To set up listener for all Combo box
     * Algorithm: no
     * @param itemListener - the item listener for combo box
     * */
    public void addListenerForComboBox(ItemListener itemListener) {
        languageBox.addItemListener(itemListener);
        dimensionBox.addItemListener(itemListener);
    }

    /**
     * Method name: addListenerForButton
     * Purpose: To set up listener for all Button
     * Algorithm: Use double for loop to set up listener for each button in adversary and user panel
     * @param actionListener - the listener for button
     * */
    public void addListenerForButton(ActionListener actionListener){
        playButton.addActionListener(actionListener);
        resetButton.addActionListener(actionListener);
        designModeButton.addActionListener(actionListener);
        randModeButton.addActionListener(actionListener);
        //Use double for loop to set up listener for each buttons in both user and adversary grid
        for (int i = 0; i < userPanelGridButtons.length; i++){
            for (int j = 0; j < userPanelGridButtons[0].length;j++){
                userPanelGridButtons[i][j].addActionListener(actionListener);
                adversaryPanelGridButtons[i][j].addActionListener(actionListener);
            }
        }
    }

    /**
     * Method name: initializeUserPanel
     * Purpose: To initialize the interface and components of user panel
     * Algorithm: The method utilizes the Java Swing to visualize the user panel and
     * manage the grids by array
     * */
    public void refreshInterface(){
        revalidate();
        repaint();
        setVisible(true);
    }
}
