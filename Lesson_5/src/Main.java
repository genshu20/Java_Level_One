public class Main {

    public static void main(String[] args) {
	Musician[]exodus=new Musician[5];
	exodus[0]=new Musician("Souza Steve","vocal","Souza@mail.ru","212850a",1000000,55);
	exodus[1]=new Musician("Holt Gary Holt","guitars","Holt@mail.ru","212850b",900000,55);
	exodus[2]=new Musician("Hunting Tom","drums","Hunting@mail.ru","212850v",800000,54);
	exodus[3]=new Musician("Altus Lee","guitars","Altus@mail.ru","212850g",700000,53);
	exodus[4]=new Musician("Gibson Jack","bass","Gibson@mail.ru","212850d",600000,52);
        for (int i = 0; i <exodus.length ; i++) {
            if(exodus[i].getAge()>53)exodus[i].printMusician();
        }
    }
}
