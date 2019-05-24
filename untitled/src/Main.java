public class Main {
    public static void main(String[] args) {
        Cat[] cats = new Cat[5];
        int j = 0;
        for (int i = 0; i < 5; i++) {
            j += 10;
            cats[i] = new Cat("Cat" + (i + 1), j);
            cats[i].catInfo();
        }
        Plate plate = new Plate(60);
        plate.info();
        boolean hunger = true;
        while (hunger) {
            hunger = false;
            for (int i = 0; i < cats.length; i++) {
                cats[i].eat(plate);
                if (!cats[i].satiety) hunger = true;
                cats[i].catInfo();
            }
            if(hunger)plate.addFood();
        }
    }
}