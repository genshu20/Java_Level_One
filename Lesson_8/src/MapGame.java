import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MapGame extends JPanel {
    public static final int MODE_H_V_A=0;
    public static final int MODE_H_V_H=1;
    int[][]field;
     int fieldSizeX;
     int fieldSizeY;
     int winLength;
     int cellHeight;
     int cellWidth;
     boolean isInit=false;
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
        int cellX=e.getX()/cellWidth;
        int cellY=e.getY()/cellHeight;
        System.out.println(cellX+" "+cellY);
        repaint();
    }
    public void startNewGame(int mode,int fieldSizeX,int fieldSizeY,int winLength){
        System.out.println(mode+" "+fieldSizeX+" "+fieldSizeY+" "+winLength);
        this.fieldSizeX=fieldSizeX;
        this.fieldSizeY=fieldSizeY;
        this.winLength=winLength;
        field=new int[fieldSizeY][fieldSizeX];
        isInit=true;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        if(!isInit)return;
        int panelWidth=getWidth();
        int panelHeight=getHeight();
        cellHeight=panelHeight/fieldSizeY;
        cellWidth=panelWidth/fieldSizeX;
        for (int i = 0; i <fieldSizeY ; i++) {
            int y=i*cellHeight;
            g.drawLine(0,y,panelWidth,y);
        }
        for (int i = 0; i <fieldSizeX ; i++) {
            int x=i*cellWidth;
            g.drawLine(x,0,x,panelWidth);
        }
    }
    void drow0(Graphics g,int x,int y){
        g.drawOval(x+2,y+2,cellWidth-4,
                cellHeight-4);
    }
    void drowX(Graphics g,int x,int y){
        g.drawLine(x+2,y+2,x+cellWidth-4,y+cellHeight-4);
        g.drawLine(x+cellWidth-4,y+2,x+2,y+cellHeight-4);
    }
}
