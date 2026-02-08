import java.util.Scanner;

public class Main {

    //Here we are defining what the token will contain, defining a place to store the user input, 
    //and code to initialize a new token.
    enum TokenContents {
        NUMBER,
        DONE,
        INVALID
    }

    static class TokenContainer {
        TokenContents type;
        String userInput;

        TokenContainer(TokenContents type, String userInput) {
            this.type = type;
            this.userInput = userInput;
        }
    }

    //Here we have an analyzer that looks at the users input and determines whether or not it is a valid number,
    //The word 'done' to end, or a non valid input. 
    static TokenContainer infoAnalyzer(String info) {

        if (info.equalsIgnoreCase("done")) {
            return new TokenContainer(TokenContents.DONE, info);
        }

        boolean containsNumber = false;
        boolean containsDecimal = false;

        int startingNumber = 0;

        if (info.length() > 0 && (info.charAt(0) == '+' || info.charAt(0) == '-')) {
        startingNumber = 1;
        }

        if (startingNumber >= info.length()) {
        return new TokenContainer(TokenContents.INVALID, info);
        }

        for (int i = startingNumber; i < info.length(); i++) {
            char currentChar = info.charAt(i);

            if (Character.isDigit(currentChar)) {
                containsNumber = true;

            } else if (currentChar == '.') {
                if (containsDecimal) {
                    return new TokenContainer(TokenContents.INVALID, info);
                }
                containsDecimal = true;

            } else {
                return new TokenContainer(TokenContents.INVALID, info);
            }
        }

        if (!containsNumber) {
            return new TokenContainer(TokenContents.INVALID, info);
        }

        return new TokenContainer(TokenContents.NUMBER, info);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double sum = 0;
        int count = 0;

        System.out.println("Please enter numbers, only one per line and then type the word 'done' to finish.");

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