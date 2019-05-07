import java.util.*;

public class LessonTwo {
    public static int[] getArrayInt(String welcome) {//для получения int[] с клавиатуры
        System.out.println(welcome);
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> enterList = new ArrayList<Integer>();
        String stringEnter = null;
        if (sc.hasNextLine()) stringEnter = sc.nextLine();
        String[] arrayStringEnter = stringEnter.split(" ");
        for (int i = 0; i < arrayStringEnter.length; i++) {
            try {
                enterList.add(Integer.parseInt(arrayStringEnter[i]));
            } catch (NumberFormatException e) {
                System.out.println("wrong enter");
            }
        }
        int[] enterArray = new int[enterList.size()];
        for (int i = 0; i < enterArray.length; i++) {
            enterArray[i] = enterList.get(i);
        }
        System.out.println(Arrays.toString(enterArray));
        return enterArray;
    }

    public static int readInt(String welcome) {//для получения int с клавиатуры
        System.out.println(welcome);
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            return sc.nextInt();

        } else {
            System.out.println("wrong enter");
            return (readInt(welcome));
        }
    }
    public static boolean division(int[]arr) {//метод для задания 6
        int totalSum=0;
        int tempSum=0;
        boolean b=false;
        for(int i=0;i<arr.length;i++){
            totalSum+=arr[i];
        }
        if(totalSum%2!=0)return false;
        for(int i=0;i<arr.length;i++){
            tempSum+=arr[i];
            if(tempSum==totalSum/2){
                b=true;
                System.out.println("division point:i= "+i);
                break;
            }
        }
        return b;
    }
    public static void shift(int[] arr,int sh){//метод для 7 задания. Без интернета!
        System.out.println(Arrays.toString(arr));
        int a=sh/Math.abs(sh);
        int i=0;
        while(i< Math.abs(sh%arr.length)) {
            int buf = arr[0];
            for (int j = 0; ; j = (arr.length+(j - a))%arr.length) {
                if ((arr.length+(j - a))%arr.length == 0) {
                    arr[j] = buf;
                    break;
                }
                arr[j] = arr[(arr.length+(j - a))%arr.length];
            }
            i++;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static int[] shift2(int[]arr,int n){
        System.out.println(Arrays.toString(arr));
        int k=n%arr.length+arr.length;
        for (int i = 0; i <k ; i++) {
            int tmp=arr[arr.length-1];
            for(int j=arr.length-1;j>0;j--){
              arr[j]=arr[j-1];
            }
            arr[0]=tmp;
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] oneEndZero = getArrayInt("enter ones and zeros");//задание 1
        for (int i = 0; i < oneEndZero.length; i++) {
            if (oneEndZero[i] == 0) oneEndZero[i] = 1;
            else if (oneEndZero[i] == 1) oneEndZero[i] = 0;
            else {
                System.out.println(oneEndZero[i] + " wrong number, reenter please");
            }// write your code here
        }
        System.out.println(Arrays.toString(oneEndZero));
        int[] eight = new int[8];//задание 2
        for (int i = 0; i < eight.length; i++) {
            eight[i] = i * 3;
        }
        System.out.println(Arrays.toString(eight));
        int[] exerciseThree = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};//задание 3
        for (int i = 0; i < exerciseThree.length; i++) {
            if (exerciseThree[i] < 6) exerciseThree[i] *= 3;
        }
        System.out.println(Arrays.toString(exerciseThree));
        int n = readInt("enter the dimension of the matrix");//задание 4
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == i || j == (n - 1 - i)) {
                    matrix[i][j] = 1;
                }
                System.out.printf("%2d", matrix[i][j]);
            }
            System.out.println();
        }
        int m = readInt("enter the arrays length");
        int[] exerciseFiveSixSeven = new int[m];//получаем массив для 5,6,7  заданий
        for (int i = 0; i < m; i++) {
            exerciseFiveSixSeven[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(exerciseFiveSixSeven));
        int[] exerciseFive = exerciseFiveSixSeven.clone();//задание 5; решение видел в интернете до начала курса:)
        boolean b = false;
        while (!b) {
            b = true;
            for (int i = 0; i < m - 1; i++) {
                if (exerciseFive[i] > exerciseFive[i + 1]) {
                    b = false;
                    int buf = exerciseFive[i];
                    exerciseFive[i] = exerciseFive[i + 1];
                    exerciseFive[i + 1] = buf;
                }
            }
        }
        System.out.println(Arrays.toString(exerciseFive));
        System.out.println("min: " + exerciseFive[0] + " max: " + exerciseFive[m - 1]);
        int[] exerciseFiveSort = exerciseFiveSixSeven.clone();//задание 5 другой способ
        Arrays.sort(exerciseFiveSort);
        System.out.println(Arrays.toString(exerciseFiveSort));
        System.out.println("min: " + exerciseFiveSort[0] + " max: " + exerciseFiveSort[m - 1]);
        int[] exerciseFiveSelection = exerciseFiveSixSeven.clone();//задание 5 третий способ
        for (int i = 0; i < m; i++) {
            int small = i;
            for (int j = i; j < m; j++) {
                if (exerciseFiveSelection[j] < exerciseFiveSelection[small]) {
                    small = j;
                }
            }
            int buf = exerciseFiveSelection[i];
            exerciseFiveSelection[i] = exerciseFiveSelection[small];
            exerciseFiveSelection[small] = buf;
        }
        System.out.println(Arrays.toString(exerciseFiveSelection));
        System.out.println("min: " + exerciseFiveSelection[0] + " max: " + exerciseFiveSelection[m - 1]);
        int[] exerciseFiveInsert = exerciseFiveSixSeven.clone();//задание 5 четвёртый способ
        for (int i = 1; i <m ; i++) {
            int buf=exerciseFiveInsert[i];
            int j=i-1;
            while (j>=0&&buf<exerciseFiveInsert[j]){
                exerciseFiveInsert[j+1]=exerciseFiveInsert[j];
                j--;
            }
            exerciseFiveInsert[j+1]=buf;
        }
        System.out.println(Arrays.toString(exerciseFiveInsert));
        System.out.println("min: " + exerciseFiveInsert[0] + " max: " + exerciseFiveInsert[m - 1]);
        System.out.println(division(exerciseFiveSixSeven));//задание 6
        int sh=readInt("enter the shift of array");//задание 7
        int[]exSeven1=exerciseFiveSixSeven.clone();
        int[]exSeven2=exerciseFiveSixSeven.clone();
        System.out.println(Arrays.toString(shift2(exSeven1,sh)));
        shift(exSeven2,sh);
    }
}
