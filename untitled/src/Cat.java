class Cat {
    private String name;
    private int appetite;
    boolean satiety;

     Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        satiety = false;
    }

    void eat(Plate p) {
        if (p.getFood() >= appetite) {
            p.decreaseFood(appetite);
            satiety = true;
            appetite=0;
        } else System.out.println(name+" eat!");
    }
    void catInfo(){
        System.out.println(name+" "+appetite);
    }
}
