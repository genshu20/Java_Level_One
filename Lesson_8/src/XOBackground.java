import java.util.*;
public class XOBackground {
    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '*';
    static Scanner sc = new Scanner((System.in));
    static Random random = new Random();

    public boolean isMapFull(char[][] ch) {
        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch.length; j++) {
                if (ch[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public int getNumber(String welcome, int min, int max) {
        int a = min - 1;
        do {
            System.out.println(welcome);
            if (sc.hasNextInt()) {
                a = sc.nextInt();
            } else sc.next();
        } while (a < min || a > max);
        return a;
    }

    public boolean isCellValid(int x, int y, char[][] ch) {
        if (x < 0 || x >= ch.length || y < 0 || y >= ch.length) return false;
        if (ch[x][y] == DOT_EMPTY) return true;
        return false;
    }

    public void aiTurn(char[][] ch,int dtw) {
        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch.length; j++) {
                if (ch[i][j] == DOT_EMPTY) {
                    ch[i][j] = DOT_O;

                    if (checkWin(DOT_O, dtw, ch)) return;
                    else ch[i][j] = DOT_EMPTY;
                }
            }
        }
        for (int k = dtw; k > 0; k--) {
            for (int i = 0; i < ch.length; i++) {
                for (int j = 0; j < ch.length; j++) {
                    if (ch[i][j] == DOT_EMPTY) {
                        ch[i][j] = DOT_X;
                        if (checkWin(DOT_X, k, ch)) {
                            ch[i][j] = DOT_O;
                            return;
                        }else ch[i][j]=DOT_EMPTY;
                    }
                }
            }
        }
    }

    public void humanTurn(char[][] ch) {
        int x, y;
        x = getNumber("enter x", 1, ch.length);
        y = getNumber("enter y", 1, ch.length);
        ch[y - 1][x - 1] = DOT_X;
    }

    public static char[][] initMap(int n) {
        char[][] ch = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ch[i][j] = DOT_EMPTY;

            }
        }
        return ch;
    }

    public void printMap(char[][] ch) {
        for (int i = 0; i <= ch.length; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < ch.length; i++) {
            System.out.printf("%2d ", (i + 1));
            for (int j = 0; j < ch.length; j++) {
                System.out.print(ch[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public boolean checkHor(int dtw,int x,int y,char c,char[][]ch){
        for (int i = x; i <x+dtw ; i++) {
            if(i>=ch.length)return false;
            if(ch[y][i]!=c)return false;
        }
        return true;
    }
    public boolean checkVer(int dtw,int x,int y,char c,char[][]ch){
        for (int i = y; i <y+dtw ; i++) {
            if(i>=ch.length)return false;
            if(ch[i][x]!=c)return false;
        }
        return true;
    }
    public boolean checkWr(int dtw,int x,int y,char c,char[][]ch){
        for (int i = 0; i<dtw ; i++) {
            if (i+y >= ch.length || i+x >= ch.length) return false;
            if (ch[i+y][i+x] != c) return false;
        }
        return true;
    }
    public boolean checkLeft(int dtw,int x,int y,char c,char[][]ch){
        for (int i = 0; i<dtw ; i++) {
            if (i+y >= ch.length ||x-i <0) return false;
            if (ch[i+y][x-i] != c) return false;
        }
        return true;
    }
    public boolean checkWin(char simb,int dtw,char[][]ch){
        for (int i = 0; i <ch.length ; i++) {
            for (int j = 0; j <ch.length ; j++) {
                if(ch[i][j]==simb){
                    if(checkHor(dtw,j,i,simb,ch)||checkVer(dtw,j,i,simb,ch)||checkLeft(dtw,j,i,simb,ch)||checkWr(dtw,j,i,simb,ch))return true;
                }
            }
        }
        return false;
    }
}
