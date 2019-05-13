import java.util.Scanner;

public class LessonThree {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        GuessNumber gn=new GuessNumber();
        GuessWord gw=new GuessWord();
        int select=gn.getNumber("Enter the number of exercise",1,2);
        if(select==1) gn.playGame();
        else gw.playGame();
        }
	// write your code here
    }

