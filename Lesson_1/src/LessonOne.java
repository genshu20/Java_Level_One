import java.sql.SQLOutput;
import java.util.Scanner;

public class LessonOne {
	public static double abcdCalc(int a,int b,double c,int d){
		return a*(b+(c/d));
	}
	public static int readInt(){
		System.out.println("Enter the number");
		Scanner sc=new Scanner(System.in);
		if(sc.hasNextInt()){
			return sc.nextInt();

		}else{
			System.out.println("Wrong, enter else");
			return(readInt());
		}
	}
	public static boolean football(int a,int b){
		if((a+b)>=10&&(a+b)<=20)return true;
		else return false;
		}
	public static void 	compareZeroPrint(int a){
		if(a>=0)System.out.println("positive");
		else System.out.println("negative");
	}
	public static boolean compareZero(int a){
		if(a<0)return true;
		else return false;
	}
	public static void hello(String name){
		System.out.println("Hello "+name+"!");
	}
	public static String readString() {
		System.out.println("Enter the name");
		Scanner sc = new Scanner(System.in);
		if (sc.hasNext()) return sc.next();
		else {
			System.out.println("Wrong, enter else");
			return (readString());
		}
	}
	public static void bissextile(int year){
	if(year%4==0&&(year%100!=0||year%400==0)) System.out.println(
			year+" year is bissextile");
	else System.out.println(
			year+" year is not bissextile");
	}
    public static void main(String[] args) {
	byte by=100;
	short sh=200;
	int in=33000;
	long lo=3000000000L;
	float fl=1.33f;
	double doub=1.4444;
	char ch=65;
	char chch='B';
	boolean bo=false;
	System.out.println("byte by= "+by+"\n"+"short sh= "
			+sh+"\n"+"int in= "+in+"\n"+"long lo= "+lo+"\n"+
			"float fl= "+fl+"\n"+"double doub= "+doub+
			"\n"+"char ch= "+ch+"\n"+"char chch= "+chch+
			"\n"+"boolean bo= "+bo);
	int a=readInt();// write your code here
	int b=readInt();// write your code here
	double c=readInt();// write your code here
	int d=readInt();
		System.out.println("a*(b+(c/d)= "+abcdCalc(a,b,c,d));
		a=readInt();// write your code here
		b=readInt();
		if(football(a,b)) System.out.println("Goal");
		else System.out.println("Miss");
    a=readInt();
		compareZeroPrint(a);
		System.out.println(compareZero(a));
		String name=readString();
		hello(name);
		int year=0;
		while(year<=0){
			year=readInt();
		}
		bissextile(year);

		// write your code here
    }
}
