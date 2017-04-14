import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char keepGoing = 'G';
        String input = "";
        String output="";

        System.out.println("Welcome to the Pig Latin Translator");

        do {
            System.out.println("\nEnter in a line to be translated");

            input = scan.nextLine();

            output = getPigLatin(input);

            System.out.println(output);

            System.out.println("Translate again? (y/n)");
            keepGoing = scan.next().charAt(0);
            scan.nextLine();


        }
        while (keepGoing =='y' || keepGoing == 'Y');


    }

    public static String getPigLatin(String input){
        if (input.length()==0)
           return  "";
        int indexOfNextSpace = input.indexOf(" ");

        if (indexOfNextSpace<0)
            return translateWord(input);

        if (indexOfNextSpace ==0)
            return getPigLatin(input.substring(1));
        else{

            return  translateWord(input.substring(0, indexOfNextSpace)) +" " +  getPigLatin(input.substring(indexOfNextSpace));

        }

    }
    public static String translateWord(String input){
        input = input.toLowerCase();
        if (isVowel(input.charAt(0))){
            return input + "way";
        }
        else {
            char temp = '1';
            while (!isVowel(input.charAt(0))){
                input += input.charAt(0);
                input =  input.substring(1);
            }
            return input + "ay";

            //added a comment to test GitHub
        }


    }
    public static boolean isVowel(char input){
        switch(input){
            case 'a' :
            case 'e' :
            case 'i' :
            case 'o' :
            case 'u' :
            case 'y' : return true;
            default  : return false;


        }
    }
}
