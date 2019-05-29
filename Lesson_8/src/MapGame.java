import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MapGame extends JPanel {
    XOBackground xob = new XOBackground();
    public static final int MODE_H_V_A = 0;
    public static final int MODE_H_V_H = 1;
    static char[][] field;
    int fieldSizeX;
    int fieldSizeY;
    int winLength;
    int cellHeight;
    int cellWidth;
    boolean isInit = false;
    int mode;
    boolean b=false;
    public MapGame() {
        setBackground(Color.ORANGE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
    }
    private void update(MouseEvent e) {
        char ch;
        if(!b)ch=xob.DOT_X;
        else ch=xob.DOT_O;
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
            if (xob.isCellValid(cellX, cellY, field)) {
                System.out.println(cellX + " " + cellY);
                field[cellX][cellY] = ch;

                repaint();
                if (xob.checkWin(ch, winLength, field)) {
                    GameWindow.startNewGameWindow.setVisible(true);
                    StartNewGameWindow.winner.setText(ch+" - is WON!");
                } else if (xob.isMapFull(field)) {
                    GameWindow.startNewGameWindow.setVisible(true);
                    StartNewGameWindow.winner.setText("DRAW");
                } else {
                    if(mode==MODE_H_V_A) {
                        xob.aiTurn(field, winLength);
                        repaint();
                        if (xob.checkWin(xob.DOT_O, winLength, field)) {
                            GameWindow.startNewGameWindow.setVisible(true);
                            StartNewGameWindow.winner.setText("O - is WON!");
                        } else if (xob.isMapFull(field)) {
                            GameWindow.startNewGameWindow.setVisible(true);
                            StartNewGameWindow.winner.setText("DRAW");
                        }
                    }else b=!b;

                    }
                }
            }

        public void startNewGame ( int mode, int fieldSizeX, int fieldSizeY, int winLength){
            System.out.println(mode + " " + fieldSizeX + " " + fieldSizeY + " " + winLength);
            this.fieldSizeX = fieldSizeX;
            this.fieldSizeY = fieldSizeY;
            this.winLength = winLength;
            this.mode=mode;
            field = new char[fieldSizeY][fieldSizeX];
            isInit = true;
            repaint();
        }

        @Override
        protected void paintComponent (Graphics g){
            super.paintComponent(g);
            render(g);
        }

        private void render (Graphics g) {
            if (!isInit) return;
            int panelWidth = getWidth();
            int panelHeight = getHeight();
            cellHeight = panelHeight / fieldSizeY;
            cellWidth = panelWidth / fieldSizeX;
            for (int i = 0; i < fieldSizeY; i++) {
                int y = i * cellHeight;
                g.drawLine(0, y, panelWidth, y);
            }
            for (int i = 0; i < fieldSizeX; i++) {
                int x = i * cellWidth;
                g.drawLine(x, 0, x, panelWidth);
            }
            for (int i = 0; i <fieldSizeY ; i++) {
                for (int j = 0; j <fieldSizeX ; j++) {
                    if(field[i][j]==xob.DOT_X){
                        g.drawLine(i*cellWidth + 2, j*cellHeight + 2, (i+1)*cellWidth - 4, (j+1)*cellHeight - 4);
                        g.drawLine((i+1)*cellWidth - 4, j*cellHeight + 2, i*cellWidth + 2, (j+1)*cellHeight - 4);
                    }
                    if(field[i][j]==xob.DOT_O){
                        g.drawOval(i*cellWidth + 2, j*cellHeight + 2, cellWidth - 4, cellHeight - 4);

                }
            }
            }
        }
    }

