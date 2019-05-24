import java.util.Scanner;

class Plate {
    private int food;
    private Scanner sc=new Scanner(System.in);

    Plate(int food) {
        this.food = food;
    }
    int getFood() {
        return food;
    }
    void decreaseFood(int n){
        if(n>food) System.out.println("not enough food");
        else food-=n;
    }
    void info() {
        System.out.println("plate: " + food);
    }
    void addFood() {
        System.out.println("add food");
        if (sc.hasNextInt()) {
            int a = sc.nextInt();
            food+=a;
        } else {
            sc.next();
            addFood();
        }
    }
}

