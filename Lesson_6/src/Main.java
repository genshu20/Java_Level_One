public class Main {
    public static void main(String[] args) {
        Assistent ass=new Assistent();
        Animal[]pets=new Animal[6];
        pets[0]=new Dog("Shar");
        pets[1]=new Dog("Rex");
        pets[2]=new Dog("Bob");
        pets[3]=new Cat("Bars");
        pets[4]=new Cat("Vas");
        pets[5]=new Cat("Black");
        System.out.println("created "+Animal.numberOfAnimal+" animals "+Dog.numberOfDog+" dogs "+Cat.numberOfCat+" cats ");
        for(Animal a:pets){
            a.info();
            System.out.println();
        }
       int rd=ass.getNumber("enter the run distance up 100 to 600 ",100,600);
       int sd=ass.getNumber("enter the swim distance up 8 to 12 ",0,12);
       double jh=ass.getNumber("enter the jump height up 0,5 to 2,5 ",0.5,2.5);
       for(Animal a:pets){
           a.run(rd);
           a.jump(jh);
           if(a.type.equals("Dog"))((Dog)a).swim(sd);
       }
    }

}
