class Dog extends Animal {
    static int numberOfDog;
    private int maxSwimDistance;
Dog(String name){
        super(name, (int)(Math.random()*301)+300, Math.random()+0.5);
    maxSwimDistance=(int)(Math.random()*5)+8;
        type="Dog";
        numberOfDog++;
    }
    void info(){
        System.out.printf(type+"\n"+name+"\n"+"maxRunDistance "+maxRunDistance+"\n"+"maxSwimDistance "+maxSwimDistance+"\n"+
                "maxHeight "+"%.3f\n",maxHeight);
    }
    void swim(int swimDistance){
        if(swimDistance<=maxSwimDistance) System.out.println(type+" "+name+" swum");
        else System.out.println(type+" "+name+" drowned");
    }
}
