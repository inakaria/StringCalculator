import java.util.*;


public class Main {
    public static void main(String[] args) {
        try {
            StringCalculator calc = new StringCalculator();
            Scanner sc = new Scanner(System.in);

            System.out.println("Input the string with numbers: ");
            String input = sc.nextLine();
            calc.add(input);
            
            sc.close();
        }
        catch(NumberFormatException n) {
            System.out.println("Incorrect input");
        }
        catch(IllegalArgumentException i) {
            System.out.println("Incorrect input");
        }
    }
}
