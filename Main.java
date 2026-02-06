import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double sum = 0;
        int count = 0;

        System.out.println("Enter numbers one per line. Type 'done' to finish.");

        while (true) {
            System.out.print("> ");
            String input = sc.nextLine().trim();

            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                double num = Double.parseDouble(input);
                sum += num;
                count++;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            }
        }

        System.out.println("\nSum = " + sum);
        System.out.println("Count = " + count);

        if (count > 0) {
            System.out.println("Average = " + (sum / count));
        } else {
            System.out.println("Average = N/A");
        }

        sc.close();
    }
}