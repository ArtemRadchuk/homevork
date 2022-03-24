package practice.twoDimensionalArray;

import java.util.Arrays;

public class TwoDimensionalArray {

    public static final char SYMBOL = 'X';

    public static char[][] getTwoDimensionalArray(int size) {
        char[][] Char = new char[size][size];
        int firstDimensionStart = 0;
        int firstDimensionEnd = Char.length - 1;
        int secondDimension = 0;
       int init = 0;
       for(;secondDimension < size ;secondDimension++){
           for(;init < size ;init++){
               Char[secondDimension][init] = ' ';
           }
           init =0;
       }
       secondDimension = 0;
        for (; secondDimension < Char.length;secondDimension++){
            Char[firstDimensionStart][secondDimension] = SYMBOL;
            Char[firstDimensionEnd][secondDimension] = SYMBOL;
            firstDimensionEnd--;
            firstDimensionStart++;
        }


        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ SYMBOL по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]
        return Char;
    }
}
