package practice.reverseArray;

public class ReverseArray {

    public static String[] reverse(String[] strings) {
        //TODO: Напишите код, который меняет порядок расположения элементов внутри массива на обратный.
        String[] Array = new String[strings.length];
        int min = 0;
        String[] stringsClone = strings.clone();
       for(int max = stringsClone.length-1;max >= 0; max--){
           strings[min] = stringsClone[max];
           min++;
       }
        return strings;
    }

}