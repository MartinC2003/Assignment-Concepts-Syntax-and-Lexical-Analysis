import java.util.Scanner;

public class Main {

    //This is where we are defining what the token will contain, defining a place to store the user input, 
    //and code to initialize a new token.
    enum TokenContents {
        NUMBER,
        COMPLETE,
        INVALIDINPUT
    }

    static class TokenContainer {
        TokenContents type;
        String userInput;

        TokenContainer (TokenContents type, String userInput) {
            this.type = type;
            this.userInput = userInput;
        }
    }

    //Here we have an analyzer that looks at the users input and determines whether or not it is a valid number,
    //The word 'complete' to end, or a non valid input. 
    static TokenContainer infoAnalyzer(String info) {

        if (info.equalsIgnoreCase("complete")) {
            return new TokenContainer(TokenContents.COMPLETE, info);
        }

        boolean containsNumber = false;
        boolean containsDecimal = false;

        int startingNumber = 0;

        if (info.length() > 0 && (info.charAt(0) == '+' || info.charAt(0) == '-')) {
        startingNumber = 1;
        }

        if (startingNumber >= info.length()) {
        return new TokenContainer(TokenContents.INVALIDINPUT, info);
        }

        for (int i = startingNumber; i < info.length(); i++) {
            char currentChar = info.charAt(i);

            if (Character.isDigit(currentChar)) {
                containsNumber = true;

            } else if (currentChar == '.') {
                if (containsDecimal) {
                    return new TokenContainer(TokenContents.INVALIDINPUT, info);
                }
                containsDecimal = true;

            } else {
                return new TokenContainer (TokenContents.INVALIDINPUT, info);
            }
        }

        if (!containsNumber) {
            return new TokenContainer(TokenContents.INVALIDINPUT, info);
        }

        return new TokenContainer(TokenContents.NUMBER, info);
    }

    //Sets up the program by prepping the variables and giving the user instructions on how to work it.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double sum = 0;
        int count = 0;

        System.out.println("Please enter numbers, only one per line and then type the word 'complete' to finish.");

        //This is processing the user's inputted information. By sending it through the analyzer it either decides to add a number, 
        //end the process, or give you an error message based upon the analyzers return.
        while (true) {
            System.out.print("> ");
            String inputInfo = sc.nextLine().trim();
            TokenContainer token = infoAnalyzer(inputInfo);

            if (token.type == TokenContents.NUMBER) {
                double inputNumber = Double.parseDouble(token.userInput);
                sum += inputNumber;
                count++;

            } else if (token.type == TokenContents.COMPLETE) {
                break;

            } else {
                System.out.println("That's not a valid number, please try again.");
            }
        }
        //Displays all the results
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