class Cat extends Animal {
    static int numberOfCat;
    Cat(String name){
        super(name, (int)(Math.random()*301)+100,
                Math.random()*1.5+1.0);
        type="Cat";
        numberOfCat++;
    }
}
