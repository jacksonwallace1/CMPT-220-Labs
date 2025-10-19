import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DealOrNoDeal {
    public static void main(String[] args){
        double[] cases = {.01, 1, 5, 10, 25, 50, 75, 100, 200, 300, 400, 500, 700, 1000, 5000, 10000, 25000, 50000, 75000, 100000, 200000, 300000, 400000, 500000, 750000, 1000000};
        Random r = new Random();
        for (int i = cases.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            double t = cases[i];
            cases[i] = cases[j];
            cases[j] = t;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose your case: (Enter a number 0-25)");
        int playerCase = sc.nextInt();
        cases = revealCases(6, cases, playerCase);
        banker(cases);
        cases = revealCases(5, cases, playerCase);
        banker(cases);
        cases = revealCases(4, cases, playerCase);
        banker(cases);
        cases = revealCases(3, cases, playerCase);
        banker(cases);
        cases = revealCases(2, cases, playerCase);
        banker(cases);
        cases = revealCases(1, cases, playerCase);
        banker(cases);
        cases = revealCases(1, cases, playerCase);
        banker(cases);
        cases = revealCases(1, cases, playerCase);
        banker(cases);
        cases = revealCases(1, cases, playerCase);
        System.out.println("Switch to the final case? Yes or No");
        Scanner s = new Scanner(System.in);
        String response = s.nextLine();
        if(response.toUpperCase().equals("YES")){
            for(int i = 0; i < cases.length; i++){
                if((i != playerCase) && (cases[i] != 0)){
                    endGame(cases[i]);
                }
            } 
        }else{
            endGame(cases[playerCase]);
        }
    }
    
    public static void banker(double[] cases){
        double offer = avg(cases);
        System.out.println("Banker's Offer: " + offer);
        System.out.println("Deal or No Deal?");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        if(choice.toUpperCase().equals("DEAL")){
            endGame(offer);
        }
    }

    public static double avg(double[] arr){
        int sum = 0;
        int len = 0;
        for(int i = 0; i < arr.length; i++){
            if (arr[i] != 0){
                sum += arr[i];
                len += 1;
            }
        }
        return sum/len;
    }

    public static double[] revealCases(int num, double[] cases, int playerCase){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < num; i++){
            System.out.println("Choose a case to reveal: (Enter a number 0-25)");
            int revealed = sc.nextInt();
            if(cases[revealed] == 0){
                i--;
                System.out.println("Already revealed");
            }else if(revealed == playerCase){
                i--;
                System.out.println("That is your case");
            }else{
                System.out.println(revealed + " = " + cases[revealed]);
                cases[revealed] = 0;
            }
        }
        return cases;
    }

    public static void endGame(double reward){
        System.out.println("Congratualations, you won $" + reward);
        System.exit(0);
    }
}
