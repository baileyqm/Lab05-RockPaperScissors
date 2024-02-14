package RockPaperScissors;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame {
    JPanel mainPnl = new JPanel();
    JPanel titlePnl = new JPanel();
    JPanel gamePnl = new JPanel();
    JPanel cmdPnl = new JPanel();

    TextArea gameTextArea = new TextArea(15,70);

    JTextField playWinFld = new JTextField("0");
    JTextField compWinFld = new JTextField("0");
    JTextField tiesFld = new JTextField("0");

    //Vars used to track current Play
    /*
        Rock = 0
        Paper = 1
        Scissors = 2
     */
    int playerCrtPlay = 0;
    int compCrtPlay = 0;

    Random rnd = new Random();

    //Vars to measure wins
    int playerWinsNum = 0;
    int compWinsNum = 0;
    int tiesNum = 0;

    public RockPaperScissorsFrame(){


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        setTitle("Rock, Paper, Scissors!");
        mainPnl = new JPanel();

        add(mainPnl);

        mainPnl.setLayout(new BorderLayout());

        createLabelPanel();
        mainPnl.add(titlePnl,BorderLayout.NORTH);

        createGamePanel();
        mainPnl.add(gamePnl,BorderLayout.CENTER);

        createCmdPanel();
        mainPnl.add(cmdPnl,BorderLayout.SOUTH);

        pack();
        setVisible(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int)(.75*screenSize.width),(int)(.75*screenSize.height));
        setLocationRelativeTo(null);
    }

    private void createLabelPanel(){
        JLabel titleLbl = new JLabel("Rock, Paper, Scissors Game! - Created by Quinn Bailey (Baileyqm)");
        titlePnl.add(titleLbl);
    }
    private void createGamePanel(){
        gamePnl.setLayout(new GridLayout(1,2));
        gameTextArea.setEditable(false);
        JScrollPane scroller = new JScrollPane(gameTextArea);
        gamePnl.add(scroller);
        JPanel statsPnl = new JPanel(new GridLayout(2,1));


        JLabel playWinLbl, compWinLbl,tiesLbl;
        playWinLbl = new JLabel("Player Wins: ");
        compWinLbl = new JLabel("Computer Wins: ");
        tiesLbl = new JLabel("Ties: ");

        JPanel realData = new JPanel(new GridLayout(3,1));



        playWinFld.setColumns(3);
        compWinFld.setColumns(3);
        tiesFld.setColumns(3);

        playWinFld.setHorizontalAlignment(JTextField.CENTER);
        compWinFld.setHorizontalAlignment(JTextField.CENTER);
        tiesFld.setHorizontalAlignment(JTextField.CENTER);

        playWinFld.setEditable(false);
        compWinFld.setEditable(false);
        tiesFld.setEditable(false);

        JPanel playWinPnl = new JPanel();
        playWinPnl.add(playWinLbl);
        playWinPnl.add(playWinFld);

        JPanel compWinPnl = new JPanel();
        compWinPnl.add(compWinLbl);
        compWinPnl.add(compWinFld);

        JPanel tiesPnl = new JPanel();
        tiesPnl.add(tiesLbl);
        tiesPnl.add(tiesFld);

        realData.add(playWinPnl);
        realData.add(compWinPnl);
        realData.add(tiesPnl);
        JPanel blankPanel = new JPanel();
        statsPnl.add(realData);
        statsPnl.add(blankPanel);
        gamePnl.add(statsPnl);
    }
    private void createCmdPanel(){
        JButton rockBtn = new JButton();
        JButton paperBtn = new JButton();
        JButton scissorsBtn = new JButton();
        JButton quitBtn = new JButton();
        cmdPnl.setLayout(new GridLayout(1,4));



        ImageIcon rockImg = new ImageIcon(System.getProperty("user.dir") + "/src/RockPaperScissors/RockImage.png");
        ImageIcon paperImg = new ImageIcon(System.getProperty("user.dir") + "/src/RockPaperScissors/PaperImage.png");
        ImageIcon scissorsImg = new ImageIcon(System.getProperty("user.dir") + "/src/RockPaperScissors/ScissorsImage.png");
        rockBtn.setIcon(rockImg);
        paperBtn.setIcon(paperImg);
        scissorsBtn.setIcon(scissorsImg);
        quitBtn.setText("Quit!");

        rockBtn.addActionListener(e -> {
            playerCrtPlay = 0;
            compCrtPlay = rnd.nextInt(3);
            RPSRound(compCrtPlay,playerCrtPlay);
        });

        paperBtn.addActionListener(e -> {
            playerCrtPlay = 1;
            compCrtPlay = rnd.nextInt(3);
            RPSRound(compCrtPlay,playerCrtPlay);
        });

        scissorsBtn.addActionListener(e -> {
            playerCrtPlay = 2;
            compCrtPlay = rnd.nextInt(3);
            RPSRound(compCrtPlay,playerCrtPlay);
        });


        quitBtn.addActionListener(e -> System.exit(0));

        cmdPnl.add(rockBtn);
        cmdPnl.add(paperBtn);
        cmdPnl.add(scissorsBtn);
        cmdPnl.add(quitBtn);
    }

    /*
        Rock = 0
        Paper = 1
        Scissors = 2
     */

    private void RPSRound(int compPlay,int playerPlay){
        //Player Wins
        if(compPlay == 0 && playerPlay == 1){
            playerWinsNum += 1;
            gameTextArea.append("Paper covers Rock (Player Wins!)\n");
            playWinFld.setText(String.valueOf(playerWinsNum));
        }else if(compPlay == 1 && playerPlay == 2){
            playerWinsNum += 1;
            gameTextArea.append("Scissors cuts Paper (Player Wins!)\n");
            playWinFld.setText(String.valueOf(playerWinsNum));
        }else if(compPlay == 2 && playerPlay == 0){
            playerWinsNum += 1;
            gameTextArea.append("Rock breaks Scissors (Player Wins!)\n");
            playWinFld.setText(String.valueOf(playerWinsNum));
        }

        //Computer Wins
        else if (compPlay == 0 && playerPlay == 2) {
            compWinsNum += 1;
            gameTextArea.append("Rock breaks Scissors (Computer Wins!)\n");
            compWinFld.setText(String.valueOf(compWinsNum));
        } else if (compPlay == 1 && playerPlay == 0) {
            compWinsNum += 1;
            gameTextArea.append("Paper covers Rock (Computer Wins!)\n");
            compWinFld.setText(String.valueOf(compWinsNum));
        } else if (compPlay == 2 && playerPlay == 1) {
            compWinsNum += 1;
            gameTextArea.append("Scissors cut Paper (Computer Wins!)\n");
            compWinFld.setText(String.valueOf(compWinsNum));
        }
        //Tie
        else
        {
            tiesNum += 1;
            gameTextArea.append("You both selected the same move! (Tie)\n");
            tiesFld.setText(String.valueOf(tiesNum));
        }
    }
}

