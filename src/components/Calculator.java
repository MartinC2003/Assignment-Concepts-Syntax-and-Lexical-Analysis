package components;

import java.util.List;

public class Calculator {
        double sum = 0;
        int count = 0;
        double average = 0;

    //This is where we are defining what the token will contain, defining a place to store the user input, 
    //and code to initialize a new token.
    public enum TokenContents {
        NUMBER,
        COMPLETE,
        INVALIDINPUT
    }
    
    public static class TokenContainer {
        public TokenContents type;
        public String userInput;

        TokenContainer (TokenContents type, String userInput) {
            this.type = type;
            this.userInput = userInput;
        }
    }

    public static TokenContainer infoAnalyzer(String info) {

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
    
    
    public void calculateAverage(List<Double> numbers) {

        if (numbers == null || numbers.isEmpty()) {
            return;   
        }

        for (double n : numbers) {
            sum += n;
            count++;
        }

        if (count > 0) {
            average = sum / count;
        }
    }
}

