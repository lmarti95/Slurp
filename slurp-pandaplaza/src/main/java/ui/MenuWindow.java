package main.java.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MenuWindow extends JFrame implements ActionListener {

    private Image backgroundImage = null;

    private static final String ID_NEW_GAME = "new_game";
    private static final String ID_LOAD_GAME = "load_game";
    private static final String ID_EXIT_GAME = "exit_game";

    public MenuWindow(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setTitle("Pandapláza");

        try {
            backgroundImage = javax.imageio.ImageIO.read(new File("main/resources/main_menu_bg.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.createAndShow();

        this.setVisible(true);
    }

    public void createAndShow(){
        setContentPane(new JPanel(new BorderLayout()) {
            @Override public void paintComponent(Graphics g) {
                if (backgroundImage != null)
                    g.drawImage(backgroundImage, 0, 0, null);
            }
        });


        JPanel p_layout = new JPanel();
        p_layout.setLayout(new BoxLayout(p_layout, BoxLayout.PAGE_AXIS));

        JTextField ta_welcomeMsg_1 = new JTextField("Welcom to Panda Plaza!");
        JTextField ta_welcomeMsg_2 = new JTextField("Would you like to start a new game or load a previous one?");
        p_layout.add(ta_welcomeMsg_1);
        p_layout.add(ta_welcomeMsg_2);

        JPanel p_buttons = new JPanel();
        JButton b_newGame = new JButton("New Game");
        b_newGame.setActionCommand(ID_NEW_GAME);
        b_newGame.addActionListener(this);

        JButton b_loadGame = new JButton("Load Game");
        b_loadGame.setActionCommand(ID_LOAD_GAME);
        b_loadGame.addActionListener(this);

        JButton b_exit = new JButton("Exit Game");
        b_exit.setActionCommand(ID_EXIT_GAME);
        b_exit.addActionListener(this);

        p_buttons.add(b_newGame);
        p_buttons.add(b_loadGame);
        p_buttons.add(b_exit);

        p_layout.add(p_buttons);

        add(p_layout, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if(actionCommand.equals(ID_NEW_GAME)){

        } else if (actionCommand.equals(ID_LOAD_GAME)){

        } else if (actionCommand.equals(ID_EXIT_GAME)){
            System.exit(0);
        }
    }
}
