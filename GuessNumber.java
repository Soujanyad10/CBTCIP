import java.util.Random;
import java.util.Scanner;
public class GuessNumber {

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        int RandNum = rand.nextInt(100) + 1;
        int i = 1;
        int attempt = 7;

        while (attempt>0) {
            System.out.println("Round:" + i);

            System.out.println("Enter your guess(1-100):");

            int playerGuess = sc.nextInt();

            if (playerGuess == RandNum) {
                System.out.println("YAHOO!! You get it right.");
                break;
            } else if (playerGuess > RandNum) {
                System.out.println("OOPS!! Number is lower.");
            } else if (playerGuess < RandNum) {
                System.out.println("OOPS!! Number is higher.");
            }

            i++; attempt--;
        }

        if(i>7){
            System.out.println("YOU LOSE!!");
            System.out.println("score: 0");
            System.out.println("The number was: "+RandNum);
        } else {
            System.out.println("Your Score:" + (100 - (i-1)*14));
        }
    }
}
