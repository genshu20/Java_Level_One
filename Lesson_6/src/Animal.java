class Animal {
    static int numberOfAnimal;
    String type;
    String name;
    int maxRunDistance;
    double maxHeight;
    Animal(String name,int maxRunDistance,double maxHeight){
        this.name=name;
        this.maxRunDistance=maxRunDistance;
        this.maxHeight=maxHeight;
        numberOfAnimal++;
    }
    void setName(String name){
        this.name=name;
    }
    String getName(){
        return name;
    }
    int getNumberOfAnimal(){
        return numberOfAnimal;
    }
    void run(int runDistance){
        if(runDistance<=maxRunDistance) System.out.println(type+" "+name+" come running");
        else System.out.println(type+" "+name+" drop dead");
    }
    void jump(double height){
        if(height<=maxHeight) System.out.println(type+" "+name+" skipped");
        else System.out.println(type+" "+name+" crashed");
    }
    void info(){
        System.out.printf(type+"\n"+name+"\n"+"maxRunDistance "+maxRunDistance+"\n"+
        "maxHeight "+"%.3f\n",maxHeight);
    }
}
