import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private static final int WIN_HEIGHT=555;
    private static final int WIN_WIDTH=505;
    private static final int WIN_X=800;
    private static final int WIN_Y=200;
    static StartNewGameWindow startNewGameWindow;
    private static MapGame field;

    public GameWindow(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(WIN_X,WIN_Y,WIN_WIDTH,WIN_HEIGHT);
        setTitle("Tic-Tac");
        JPanel panel=new JPanel(new GridLayout(1,2));
        JButton newGame=new JButton("New game");
        JButton exit=new JButton("Exit");
        panel.add(newGame);
        panel.add(exit);
        startNewGameWindow=new StartNewGameWindow(this);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewGameWindow.setVisible(true);
            }
        });
        add(panel,BorderLayout.SOUTH);
        field=new MapGame();
        add(field);
        setVisible(true);
    }
    public void startNewGame(int mode,int fieldSizeX,int fieldSizeY,int winLength){
        field.startNewGame(mode,fieldSizeX,fieldSizeY,winLength);
    }

}
