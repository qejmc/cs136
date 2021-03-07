package p7_package;

public class FunctionToolClass
   {
      // initialize table widths
      public static final int MENU_BLOCK_SIZE = 30;
      
      // initialize selection bounds
      public static final int LOW_MENU_SELECTION = 1;
      public static final int HIGH_MENU_SELECTION = 3;
      
      // initialize selection values
      public static final int FIND_NEXT_PRIME = 1;
      public static final int FIND_SINE = 2;
      public static final int FIND_SQUARE_ROOT = 3;

      // initialize calculation constants
      public static final int SINE_ITERATIONS = 9;
      public static final double PRECISION = .000001;
      public static final int LONG_PRECISION = 6;
      public static final int PRIME_STARTING_VALUE = 2;
      public static final int SINE_STARTING_VALUE = 1;
      public static final int FACTORIAL_LOWER_BOUND = 1;
      
      // initialize spacing constants
      public static final int TWO_ENDLINES = 2;
      
      // crate Console_IO instance
      public static Console_IO_Class conIO = new Console_IO_Class();
      
      public static void main(String args[])
         {
            // Declare variables
            int selection;
            double value, result = 0.0;

            // Prompt user for operation to be preformed
            // Method: getUserSelection
            selection = getUserSelection();
            
            // Prompt for the value to be preformed on by the operation
            // Method: getUserInput
            value = getUserInput(selection);
            
            // Determine the result of the operation on the value
            switch(selection)
            {
               // If the operation called is to find the next prime (1)
               case FIND_NEXT_PRIME:
                  // Find the next prime of the value (casted as an integer)
                  // Method: findNextPrime
                  result = findNextPrime((int) value);
                  break;
               // If the operation called is to find the sine (2)
               case FIND_SINE:
                  // Find the sine of the value
                  // Method: findSine
                  result = findSine(value); 
                  break;
               // If the operation called is to find the square root (3)
               case FIND_SQUARE_ROOT:
                  // Find the square root of the value
                  // Method: findSquareRoot
                  result = findSquareRoot(value);
                  break;
            }
            
            // Display the results to the user
            // Method: showResults
            showResults(result, selection);
            
         }
      
      /*
      Name: getUserSelection
      Process: gets a valid user selection
      Method Input/Parameters: none
      Method Output/Parameters: none
      Method Output/Returned: selection value (1-3) (int)
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: none
      */
      public static int getUserSelection()
         {
            // Declare variables
            int selection;
            
            do
               {
                  // Display the menu to the user
                  // Method: displayMenu
                  selection = displayMenu();
               }
            // Continue to display menu while selection is not valid (1-3)
            while(selection < LOW_MENU_SELECTION || selection > 
               HIGH_MENU_SELECTION);
            
            // Return the selection value
            return selection;
         }
      
      /*
      Name: displayMenu
      Process: displays the menu to the user and prompts the user for a
         selection value
      Method Input/Parameters: none
      Method Output/Parameters: none
      Method Output/Returned: user defined integer (int)
      Device Input/Keyboard: none
      Device Output/Monitor: title, instructions, and prompt
      Dependencies: Console IO Class tools
      */
      public static int displayMenu()
         {
            // Print title
            // Methods: printString, printEndlines
            conIO.printString("MENU", MENU_BLOCK_SIZE , "CENTER");
            conIO.printEndlines(TWO_ENDLINES);
            
            // Print instructions
            // Methods: printString, printEndlines
            conIO.printString("1. Find Next Prime");
            conIO.printEndlines(TWO_ENDLINES);
            conIO.printString("2. Find Sine");
            conIO.printEndlines(TWO_ENDLINES);
            conIO.printString("3. Find Square Root");
            conIO.printEndlines(TWO_ENDLINES);
            
            // Prompt user for selection integer and return it
            // Method: promptForInt
            return conIO.promptForInt("Enter your selection choice: ");
            
         }
      
      /*
      Name: getUserInput
      Process: prompts user for value to be operated upon
      Method Input/Parameters: operation selection (int)
      Method Output/Parameters: none
      Method Output/Returned: value to be operated upon (double)
      Device Input/Keyboard: none
      Device Output/Monitor: prompt displayed
      Dependencies: Console IO Class tools
      */
      public static double getUserInput(int operationSelection)
         {
            // Initialize varibles
            String prompt = "";
            
            // Print spacing
            // Method: printEndline
            conIO.printEndline();
            
            // Determine which prompt to send to user based upon selection
            switch(operationSelection)
               {
                  // If the operation called is to find the next prime (1)
                  case FIND_NEXT_PRIME:
                     // Set prompt to prime
                     prompt = "Enter start value for finding prime, "
                           + "must be greater than 1.0: ";
                     break;
                  // If the operation called is to find the sine (2)
                  case FIND_SINE:
                     // Set prompt to sine
                     prompt = "Enter value to find sine, "
                           + "must be greater than 1.0: ";
                     break;
                  // If the operation called is to find the square root (3) 
                  case FIND_SQUARE_ROOT:
                     // Set prompt to sqrt
                     prompt = "Enter value to find square root, "
                           + "must be greater than 1.0: ";
                     break;
               }
            
            // Prompt user for value with determined prompt and return it
            // Method: promptForDouble
            return conIO.promptForDouble(prompt);
            
         }
      
      /*
      Name: findNextPrime
      Process: finds the next prime after a given start value
      Method Input/Parameters: start value (int)
      Method Output/Parameters: none
      Method Output/Returned: next prime (int)
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: none
      */
      public static int findNextPrime(int startValue)
         {
            // Declare/ Initialize variables
            int counter, nextPrime = startValue;
            
            // Check each value if it is prime starting with the start value
            for(counter = startValue; nextPrime == startValue; counter++)
               {
                  // Check if the value is prime
                  // Method: isPrime
                  if(isPrime(counter))
                     {
                        // If the value is prime, the next prime is the current
                        // value
                        nextPrime = counter;
                     }
               }
            
            // Return the next prime
            return nextPrime;
            
         }
      
      /*
      Name: isPrime
      Process: check if a given value is prime
      Method Input/Parameters: potential prime number (int)
      Method Output/Parameters: none
      Method Output/Returned: whether the number is prime or not (boolean)
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: none
      */
      public static boolean isPrime(int value)
         {
            // Declare and intialize variables
            int counter;
            double halfValue;
            boolean isPrime = true;
            
            // Finds half of the value
            halfValue = value / 2;
            
            // Non-prime numbers are always divisible by atleast one value less
            // than half of the number. The counter halts at half the value and
            // if the value was not divisible by any of the counter values, the
            // number is prime
            for(counter = PRIME_STARTING_VALUE; counter <= halfValue; counter++)
               {
                  // If the value is divisble by the current possible divisor
                  if(value % counter == 0)
                     {
                        // The number is divisble by the divisor, meaning the
                        // number is not prime
                        isPrime = false;
                     }
               }
            
            // Returns whether the number is prime or not
            return isPrime;
            
         }
      
      /*
      Name: findSine
      Process: Uses the taylor series to approximate the sine of a given value
      Method Input/Parameters: value (angle) (double)
      Method Output/Parameters: none
      Method Output/Returned: approximated sine of the value (double)
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: Math class
      */
      public static double findSine(double value)
         {
            // Declare and initialize variables
            int counter, oddConversion, coeff = -1;
            double sine = value, denominator, numerator;
            
            // Starting at 1, the counter increases until it is less than the
            // globally defined sine iterations
            for(counter = SINE_STARTING_VALUE; counter < SINE_ITERATIONS; 
                  counter++)
               {
                  // Converts the counter value to the corresponding odd value,
                  // creating the odd sequence needed for the taylor series
                  oddConversion = 2*counter + 1;
                  
                  // Calculates the numerator for a given term in the series
                  // Method: Math.pow
                  numerator = (coeff) * Math.pow(value, oddConversion);
                  
                  // Calculates the denominator
                  // Method: findFactorial
                  denominator = findFactorial(oddConversion);
                  
                  // Approximates the sine; as the counter increases, the
                  // accuracy of the sine value increases
                  sine = sine + numerator / denominator;
                  
                  // Coefficient alters between -1 and 1
                  coeff = -coeff;
               }
            
            // Returns the approximated sine value
            return sine;
            
         }
      
      /*
      Name: findFactorial
      Process: Finds the factorial of a given value. Uses long values due to
         overflow errors for large values
      Method Input/Parameters: value (int)
      Method Output/Parameters: none
      Method Output/Returned: value! (long)
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: none
      */
      public static long findFactorial(int value)
         {
            // Declare and intialize values
            long counter, factorial = 1;
            
            // Starting at the given value, iterate downward
            for(counter = value; counter > FACTORIAL_LOWER_BOUND; counter--)
               {
                  // Multiply recursively by each counter value
                  factorial = factorial * counter;
               }
            
            // Return the factorial value
            return factorial;
            
         }
      
      /*
      Name: findSquareRoot
      Process: Finds the square root of a given value using the divide strategy
      Method Input/Parameters: value (double)
      Method Output/Parameters: none
      Method Output/Returned: approximated sqrt (double)
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: none
      */
      public static double findSquareRoot(double value)
         {
            // Declare and initalize variables
            double potentialSqrt;
            double lowerBound = 0, upperBound = value;
            
            // Algorithm begins by checking half of the value
            potentialSqrt = value / 2;
            
            // While the potential sqrt squared does not equal the target value
            // within precision, continue iterating
            while(!((potentialSqrt * potentialSqrt + PRECISION) > value && 
                  (potentialSqrt * potentialSqrt - PRECISION) < value))
               {
                  // Finds the halfway point between the upper and lower bounds
                  potentialSqrt = (upperBound - lowerBound) / 2 + lowerBound;
                  
                  // If the potential sqrt squared is less than the value
                  if(potentialSqrt * potentialSqrt < value)
                     {
                        // Set the new lower bound to the potential sqrt
                        lowerBound = potentialSqrt;
                     }
                  // Otherwise, if the potential sqrt squared is greater than
                  // the value
                  else if(potentialSqrt * potentialSqrt > value)
                     {
                        // Set the new upper bound to the potential sqrt
                        upperBound = potentialSqrt;
                     }
               }
            
            // Returns the approximated sqrt of the value
            return potentialSqrt;
            
         }
      
      /*
      Name: showResults
      Process: displays the results of the operation to the user
      Method Input/Parameters: none
      Method Output/Parameters: none
      Method Output/Returned: none
      Device Input/Keyboard: none
      Device Output/Monitor: result displayed
      Dependencies: Console IO Class tools
      */
      public static void showResults(double result, int inputSelection)
         {
            // Declare and initialize variables
            String displayString = "";
            
            // Print spacing
            // Method: printEndline
            conIO.printEndline();
            
            // Determine the operation conducted
            switch(inputSelection)
               {
                  // If the program found the next prime
                  case FIND_NEXT_PRIME:
                     // Display the result to user
                     // Methods: printString, printInt
                     displayString = "Next prime value is: ";
                     conIO.printString(displayString);
                     conIO.printInt((int) result);
                     break;
                  // If the program approximated sine
                  case FIND_SINE:
                     // Display the result to user
                     // Methods: printString, printDouble
                     displayString = "Sine value is: ";
                     conIO.printString(displayString);
                     conIO.printDouble(result, LONG_PRECISION);
                     break;
                  // If the program approximated the sqrt
                  case FIND_SQUARE_ROOT:
                     // Display the result to user
                     // Methods: printString, printDouble
                     displayString = "Square root is: ";
                     conIO.printString(displayString);
                     conIO.printDouble(result, LONG_PRECISION);
                     break;
               }

            // Display program end
            // Methods: printEndlines, printString
            conIO.printEndlines(TWO_ENDLINES);
            conIO.printString("Program End");
            
         }
   }
