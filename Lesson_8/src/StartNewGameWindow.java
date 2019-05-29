import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartNewGameWindow extends JFrame {
    private final GameWindow gameWindow;
    private static final int WIN_HEIGHT=230;
    private static final int WIN_WIDTH=350;
    private static final int MIN_WIN_LEN=3;
    private static final int MAX_WIN_LEN=10;
    private static final int MIN_FIELD_SIZE=3;
    private static final int MAX_FIELD_SIZE=10;
    private static final String STR_WIN_LEN="Winning length:";
    private static final String STR_FIELD_SIZE="Field size:";
    private JRadioButton jrbHumVsAi=new JRadioButton("Human vs Ai",true);
    private JRadioButton jrbHumVsHum=new JRadioButton("Human vs Human");
    private ButtonGroup gameMode =new ButtonGroup();
    private JSlider slFieldSize;
    private JSlider slWinLength;
    static JLabel winner;

    public StartNewGameWindow(GameWindow gameWindow){
        this.gameWindow = gameWindow;
        setSize(WIN_WIDTH,WIN_HEIGHT);
        setTitle("New game parameters");
        Rectangle gameWindowBounds=gameWindow.getBounds();
        int posX=(int)(gameWindowBounds.getCenterX()-WIN_WIDTH/2);
        int posY=(int)(gameWindowBounds.getCenterY()-WIN_HEIGHT/2);
        setLocation(posX,posY);
        setLayout(new GridLayout(11,1));
        addGameControlMode();
        addGameControlFieldWinLength();
        winner=new JLabel();
        add(winner);
        JButton btnStartGame=new JButton("Start Game");
        btnStartGame.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                btnStartGameClick();
            }

        });
        add(btnStartGame);
        setVisible(false);
    }
    private void btnStartGameClick() {
        setVisible(false);
        int gameMode;
        if (jrbHumVsAi.isSelected()) {
            gameMode = MapGame.MODE_H_V_A;
        } else {
            gameMode = MapGame.MODE_H_V_H;
        }
        int fieldSize = slFieldSize.getValue();
        int winLength = slWinLength.getValue();
        gameWindow.startNewGame(gameMode,fieldSize,fieldSize,winLength);
        MapGame.field=XOBackground.initMap(fieldSize);
    }
    private void addGameControlMode(){
       add(new JLabel("Choose game mode"));
       add(jrbHumVsAi);
       add(jrbHumVsHum);
       gameMode.add(jrbHumVsAi);
       gameMode.add(jrbHumVsHum);
    }
    private void addGameControlFieldWinLength() {
        add(new JLabel("Choose field size: "));
        JLabel lbFieldSize=new JLabel(STR_FIELD_SIZE+MIN_FIELD_SIZE);
        add(lbFieldSize);
        slFieldSize=new JSlider(MIN_FIELD_SIZE,MAX_FIELD_SIZE,MIN_FIELD_SIZE);
        slFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
               int currentFieldSize=slFieldSize.getValue();
               lbFieldSize.setText(STR_FIELD_SIZE+currentFieldSize);
               slWinLength.setMaximum(currentFieldSize);
            }
        });
        add(slFieldSize);
        add(new JLabel("Choose winning length: "));
        JLabel lbWinLen=new JLabel(STR_WIN_LEN+MIN_WIN_LEN);
        add(lbWinLen);
        slWinLength=new JSlider(MIN_WIN_LEN,MAX_WIN_LEN,MIN_WIN_LEN);
        slWinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentWinLength=slWinLength.getValue();
                lbWinLen.setText(STR_WIN_LEN+currentWinLength);
            }
        });
        add(slWinLength);
    }
}
