package lesson4extend;

public class XOGame {
    public static void main(String[] args) {
        XOBackground xob = new XOBackground();
        int n = xob.getNumber("Enter size from 3 to 10", 3, 10);
        int dotsToWin = xob.getNumber("Enter DOTS_TO_WIN from 2 to size", 3, n);
        char[][] map = xob.initMap(n);
        xob.printMap(map);
        while (true) {
            xob.humanTurn(map);
            xob.printMap(map);
            if (xob.checkWin(xob.DOT_X, dotsToWin, map)) {
                System.out.println("human won");
                break;
            }
            if (xob.isMapFull(map)) {
                System.out.println("draw");
                break;
            }
            xob.aiTurn(map,dotsToWin);
            xob.printMap(map);
            if (xob.checkWin(xob.DOT_O, dotsToWin, map)) {
                System.out.println("machine won");
                break;
            }
            if (xob.isMapFull(map)) {
                System.out.println("draw");
                break;
            }
        }
        System.out.println("game over");
    }
}