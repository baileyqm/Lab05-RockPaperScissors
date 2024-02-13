package FortuneTeller;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {


    int pastValue = -1;
    int index = -2;
    Random rnd = new Random();
    String[] fortunesList = {
            "You will discover a hidden stash of mismatched socks in your laundry.",
            "Expect to find the TV remote in the last place you look.",
            "A talking parrot will critique your fashion choices.",
            "Your next meal will involve an accidental extra serving of ketchup.",
            "Unexpected compliments will come from a squirrel in the park.",
            "You will meet someone who believes in unicorns as much as you do.",
            "Inflate your expectations, but not your balloons – they might pop!",
            "A rubber duck will bring you profound insights in the bathtub.",
            "Your phone will autocorrect your serious message to something hilarious.",
            "You will become a dance sensation in your living room, unseen by others.",
            "An origami frog will become your spiritual guide for the day.",
            "A mysterious box of chocolates will grant you the power of super puns.",
            "A fortune cookie will actually predict your next snack craving correctly.",
            "Your pet goldfish will offer valuable financial advice (in bubbles).",
            "You will accidentally send a love letter to your favorite pizza place."};

    public FortuneTellerFrame(){

        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        JPanel mainPnl, titlePnl, fortunePnl,cmdPnl;
        ImageIcon fortuneImg = new ImageIcon(System.getProperty("user.dir") + "/src/FortuneTeller/FortuneTellerPic.png");

        //JLabel titleLbl = new JLabel("Fortune Teller", fortuneImg,SwingConstants.CENTER);

        JLabel titleLbl = new JLabel();
        titleLbl.setFont(new Font("Impact", Font.BOLD, 48));
        titleLbl.setIcon(fortuneImg);
        titleLbl.setText("Fortune Teller!");
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);

        TextArea textArea = new TextArea(15,70);
        textArea.setEditable(false);
        JScrollPane scroller = new JScrollPane(textArea);

        setTitle("Fortune Teller Program");
        mainPnl = new JPanel();
        titlePnl = new JPanel();
        fortunePnl = new JPanel();
        cmdPnl = new JPanel();

        add(mainPnl);

        mainPnl.setLayout(new BorderLayout());
        mainPnl.add(titlePnl,BorderLayout.NORTH);
        mainPnl.add(fortunePnl,BorderLayout.CENTER);
        mainPnl.add(cmdPnl,BorderLayout.SOUTH);

        Color bgColor = new Color(207,165,204);
        Color btnColor = new Color(255,223,0);
        titlePnl.setBackground(bgColor);
        //Title Panel Info
        titlePnl.add(titleLbl);

        fortunePnl.add(scroller);
        fortunePnl.setBackground(bgColor);
        textArea.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));


        //CMD Panel Info
        JButton fortuneBtn = new JButton("Read My Fortune!");
        JButton quitBtn = new JButton("Quit");

        quitBtn.addActionListener(e -> {
            System.exit(0);
        });
        fortuneBtn.addActionListener(e -> {
            do {
                index = rnd.nextInt(15);
            } while (index < 0);

            do{
                index = rnd.nextInt(15);
            } while (pastValue == index);

            textArea.append(fortunesList[index] + "\n");
            pastValue = index;
        });

        quitBtn.setFont(new Font("Times New Roman", Font.PLAIN, 19));
        fortuneBtn.setFont(new Font("Times New Roman", Font.PLAIN, 19));

        cmdPnl.setLayout(new GridLayout(1,2));
        cmdPnl.add(fortuneBtn);
        cmdPnl.add(quitBtn);

        quitBtn.setOpaque(true);
        fortuneBtn.setOpaque(true);

        quitBtn.setBackground(btnColor);
        fortuneBtn.setBackground(btnColor);
        cmdPnl.setBackground(bgColor);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0,0,(int)(.75*screenSize.width), (int)(.75*screenSize.height));
        setLocationRelativeTo(null);
    }

}

