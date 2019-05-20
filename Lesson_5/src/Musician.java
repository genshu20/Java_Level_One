public class Musician {
   private String  name;
   private String  instrument;
   private String  email;
   private String  phone;
   private int  salary;
   private int  age;
public Musician(String  name,String  instrument,String  email,String  phone,int  salary,int  age){
    this.name=name;
    this.instrument=instrument;
    this.email=email;
    this.phone=phone;
    this.salary=salary;
    this.age=age;
}
public void setName(String name){
    this.name=name;
}
    public void setInstrument(String instrument){
        this.instrument=instrument;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    public void setSalary(int salary){
        this.salary=salary;
    }
    public void setAge(int age){
        this.age=age;
    }
    public String getName() {
        return name;
    }
    public String getInstrument(){
    return instrument;
    }
    public String getEmail(){
        return email;
    }
    public String getPhone(){
        return phone;
    }
    public int getSalary(){
        return salary;
    }
    public int getAge(){
        return age;
    }
public void printMusician(){
    System.out.print(name.split(" ")[0]+"\n"+name.split(" ")[1]+"\n"+instrument+"\n"+email+"\n"+phone+"\n"+salary
            +"\n"+age+"\n" );
}
}
