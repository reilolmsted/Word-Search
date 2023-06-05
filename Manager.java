import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class Manager{
    private static char [][] wordGrid;
    private static char [][] wordSolution;
    private static List<String> userWords;

    public void Manager(){
        wordGrid = new char[20][20];
        wordSolution = new char[20][20];
        for(int i = 0; i < 20; i++){
            for(int j=0; j < 20; j++){
                wordGrid[i][j]='_';
                wordSolution[i][j]='_';
            }
        }
        userWords = new ArrayList<String>();
        printIntro();
    }

    public static void printIntro(){
        String select;

        do{
            Scanner input = new Scanner(System.in);
            System.out.println("Welcome to the word search generator!");
            System.out.println("This program allows you to create your own word puzzle");
            System.out.println("Please select one of the following options:");
            System.out.println("Press 'g' to generate a new word puzzle");
            System.out.println("Press 'p' to print out your word search");
            System.out.println("Press 's' to show the solution to your puzzle");
            System.out.println("Press 'c' to create a custom size for your puzzle (default is 20x20)");
            System.out.println("Press 'q' to quit the program");
            select = input.next();
            select.toLowerCase();

            switch(select){
                case("c"):
                    createGrid(input);
                    break;
                case("p"):
                    print();
                    break;
                case("g"):
                    generate(input);
                    break;
                case("s"):
                    printSolution();
                case("q"):
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Please enter a valid command");
                    break;
            }
        }while(!select.equals("q"));
    }

    public static void print(){
        for(char[] row : wordGrid)
            System.out.println(Arrays.toString(row));

    }

    public static void printSolution(){
        for(char[] row : wordSolution)
            System.out.println(Arrays.toString(row));

    }

    public static void createGrid(Scanner input){
        Object x = new Object();
        System.out.println("Type a height and width for your new puzzle");
        System.out.println("Height: ");
        int height = input.nextInt();
        System.out.println("Width: ");
        int width = input.nextInt();
        x.getCreate(height,width);

    }

    public static void generate(Scanner input) {
        Random r = new Random();
        getWords(input);
        //System.out.println(userWords.toString());
        for (String x : userWords) {
            int maxLimit = 0;
            int counter = 0;

            while(maxLimit < 100 && counter != x.length()) {
                maxLimit++;
                int numY = r.nextInt(20);
                int numX = r.nextInt(20);
                int assign = r.nextInt(3);
                counter = 0;

                if (assign == 0) { //horizonral placement
                    for (int i = 0; i < x.length() && numX + i < 20; i++) { //checks if word will fit
                        if (wordGrid[numY][numX + i] == '_')
                            counter++;
                    }
                    if (counter == x.length()) {
                        for (int i = 0; i < x.length(); i++) { //adds word to puzzle
                            wordGrid[numY][numX + i] = x.charAt(i);
                            wordSolution[numY][numX + i] = x.charAt(i);
                        }
                    }
                } // end of horizontal placement
                else if (assign == 1) { //vertical placement
                    for (int i = 0; i < x.length() && numY + i < 20; i++) { //checks if word will fit
                        if (wordGrid[numY + i][numX] == '_')
                            counter++;
                    }
                    if (counter == x.length()) {
                        for (int i = 0; i < x.length(); i++) { //adds word to puzzle
                            wordGrid[numY + i][numX] = x.charAt(i);
                            wordSolution[numY + i][numX] = x.charAt(i);
                        }
                    }
                } else { // diagonal placement
                    for (int i = 0; i < x.length() && (numY + i < 20 && numY + i < 20); i++) { //checks if word will fit
                        if (wordGrid[numY + i][numX + i] == '_')
                            counter++;
                    }
                    if (counter == x.length()) {
                        for (int i = 0; i < x.length(); i++) { //adds word to puzzle
                            wordGrid[numY + i][numX + i] = x.charAt(i);
                            wordSolution[numY + i][numX] = x.charAt(i);
                        }
                    }
                } // end of horizontal placement
            } // end of while
        } // end of for loop


        for (int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                if(wordGrid[i][j] == '_'){
                    char c = (char)(r.nextInt(26) + 'A');
                    wordGrid[i][j] = c;
                }
            }
        }

    } // end of generate method
    private static void getWords(Scanner input){
        System.out.println("How many words would you like to add to the puzzle?");
        int wordCount = input.nextInt();

        for(int i = 0; i < wordCount; i++){
            if(i == 0){
                System.out.println("Type a word: ");
                String word = input.next().toUpperCase();
                userWords.add(word);
            }else{
                System.out.println("Type another word");
                String word = input.next().toUpperCase();
                userWords.add(word);
            }
        }
    }
}