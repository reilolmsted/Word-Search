import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Object{

    private static char [][] wordGrid;

    public static void Object(){//constructor class initializes word puzzle array

        wordGrid = new char[10][10];
        for(int i = 0; i < 10; i++){
            for(int j=0; j < 10; j++){
                wordGrid[i][j]='?';
            }
        }
        for(char[] row : wordGrid)
            System.out.println(Arrays.toString(row));
    }

    public void getPrint(){

        for(int i = 0; i < 10; i++){
            for(int j=0; j < 10; j++){
                Random text = new Random();
                char c = (char)(text.nextInt(26) + 'A');
                wordGrid[i][j] = c;
            }
        }
        for(char[] row : wordGrid)
            System.out.println(Arrays.toString(row));


    }

    public void getCreate(int height, int width){

        wordGrid = new char[height][width];
        for(int i = 0; i < height; i++){
            for(int j=0; j < height; j++){
                Random text = new Random();
                char c = (char)(text.nextInt(26) + 'A');
                wordGrid[i][j] = c;
            }
        }
        for(char[] row : wordGrid)
            System.out.println(Arrays.toString(row));
    }

    public void arrayGenerate(ArrayList<String>userWords){


        System.out.println(userWords.toString());
        for(String x : userWords){
            for(int i = 0; i < x.length(); i++){


            }
        }
    }
}
