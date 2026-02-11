package components;

import java.util.List;
    /*Calculator class handles all of the programs calculations*/

    public class Calculator {
    
    /*Sum, count and average of the "numbers" array are
    assigned to the fields here, to be used by the ResultsPanel class 
    to display the output on the frontend */ 
    
    public double sum = 0;
    public int count = 0;
    public double average = 0;

    /*The TokenContainer class acts as the programs lexical analyzer. 
    This is where we are defining what the token will contain, defining a place to store the user input, 
    and code to initialize a new token.*/
    
    public enum TokenContents {
        NUMBER,
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

    /* In infoAnalyzer() the values are put into the array one by one, through the onAddNumberClicked() method 
    in the "InputPanel" class. 
    Here the analyzer is validating the users input before it is put into the array
    The program can only accept whole numbers, integers and decimals.
    if the analyzer detects a invalid input, it prevents the program from adding it into the array 
    and displays the proper error message. 
    */
    
    public static TokenContainer infoAnalyzer(String info) {

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

    /*resetCalculator() is a helper method 
    that clears the calculators fields before the every 
    calculation.*/
    
    public void resetCalculator() {
        sum = 0;
        count = 0;
        average = 0;
    }
    
    /*this method acts as the programs calculator. 
    It is invoked by the CaculateArray() method
    and finds the average of the "numbers" dataset. Once completed
    the count,sum and average are stored and sent to the ResultsPanel class
    to display the results.*/
    
    public void calculateAverage(List<Double> numbers) {        
    
        /*resetCaclulator() prevents program from iterating itself if the user 
        presses calculate button twice.  
        */
        resetCalculator();

        //Loops through all of the values in the array  
        for (double n : numbers) {       
            sum += n;
            count++;    
        }
       
        //exists once all method iterates through all of the array's values
        if (count > 0) {
            average = sum / count;
        }
    }
}

