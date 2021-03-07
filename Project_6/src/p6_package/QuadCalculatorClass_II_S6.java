package p6_package;

public class QuadCalculatorClass_II_S6
   {
      // initialize table characters
      public static final char DASH = '-';
      public static final char DOUBLE_DASH = '=';
      public static final char PIPE = '|';
      public static final char CROSS = '+';
      
      // initialize line controls
      public static final int SOLID = 1001;
      public static final int BROKEN = 2002; 

      // initialize table string components
      public static final String PIPE_SPACE = "| ";
      public static final String SPACE_PIPE = " |";
      public static final String CROSS_SPACE = "+ ";
      
      // initialize table widths
      public static final int PRECISION = 2;
      public static final int TABLE_WIDTH = 44;
      public static final int NAME_BLOCK_WIDTH = 29;
      public static final int VALUE_BLOCK_WIDTH = 12;
      
      // initialize calculation constants
      public static final int DENOMINATOR_COEFF = 2;
      public static final int DISCRIMINANT_COEFF = 4;

      // initialize two endlines constant
      public static final int TWO_ENDLINES = 2;
      
      public static void main(String[] args)
         {
            // initialize program
               
               // initialize variables
            int coeffA, coeffB, coeffC;
            double discriminant, discriminantSqrt, denominator;
            boolean complex = false, hasSingleRoot = false;
            double rootOne = 0.00, rootTwo = 0.00;
                  
               // show title
               //Methods: printTitle
            printTitle();
            
            // get coefficients from user
               // get coefficient A
               //Method: promptForCoef
            coeffA = promptForCoef("Enter Coefficient A: ");
               // get coefficient B
               //Method: promptForCoef
            coeffB = promptForCoef("Enter Coefficient B: ");
               // get coefficient C
               //Method: promptForCoef
            coeffC = promptForCoef("Enter Coefficient C: ");
            
            // process the quadratic roots
            
               // calculate the denominator
               //Method: calcDenom
            denominator = calcDenom(coeffA);
            
               // calculate the discriminant
               //Method: calcDiscrim
            discriminant = calcDiscrim(coeffA, coeffB, coeffC);
            
               // calculate roots
            
                  //Test for complex
            if(discriminant < 0) 
               {
                  complex = true;
               }
               
                  //Otherwise, calculate 2 roots
            else
               {
                  //Test for single Root
                  if(discriminant == 0)
                  {
                     hasSingleRoot = true;
                  }
                  
                  //Calculate discriminant Sqrt
                  //Methods: Math.sqrt
                  discriminantSqrt = Math.sqrt(discriminant);
                     // calculate root one
                     //Method: calcRoot
                  rootOne = calcRoot(coeffB, discriminantSqrt, denominator);
                     // calculate root two
                     //Method: calcRoot
                  rootTwo = calcRoot(coeffB, -discriminantSqrt, denominator);
               }
            // display roots
            
               // display table title
               //Method: displayTableTitle
            displayTableTitle();
            
               // display table subtitle
               //Method: displayTableSubtitles
            displayTableSubtitles();
            
               // display user input values
               //Method: displayDataLine
            displayDataLine("Coefficient A", coeffA, DOUBLE_DASH);
            displayDataLine("Coefficient B", coeffB, DASH);
            displayDataLine("Coefficient C", coeffC, DASH);
            
               // display if complex
            if(complex)
               {
                  //Method: displayDataLine
                  displayDataLine("Complex Roots", rootOne, DOUBLE_DASH);
               }
               // display if single root
            else if(hasSingleRoot)
               {
                  //Method: displayDataLine
                  displayDataLine("Single Root", rootOne, DOUBLE_DASH);
               }
               // otherwise, display both roots
            else
               {
                  // display root one
                  //Method: displayDataLine
                  displayDataLine("Root One", rootOne, DOUBLE_DASH);
                  
                  // display root two
                  //Method: displayDataLine
                  displayDataLine("Root Two", rootTwo, DASH);
               }
            
               //display ending line
               //Method: displayDataLine
            displayLine(DOUBLE_DASH, "BROKEN");
         
            // end program
         
               // display program end
               //Method: displayProgramEnd
            displayProgramEnd();
         }
      
      /*
      Name: printTitle
      Process: displays the program title on the monitor
      Method Input/Parameters: none
      Method Output/Parameters: none
      Method Output/Returned: none
      Device Input/Keyboard: none
      Device Output/Monitor: title displayed
      Dependencies: Console IO Class tools
      */
      public static void printTitle()
         {
            //Instantiate Console_IO_Class
            Console_IO_Class conIO = new Console_IO_Class();
            
            //Print program title (line 1)
            //Methods: printString, printEndline
            conIO.printString("Quadratic Root Finding Program");
            conIO.printEndline();
            
            //Print separating bar (line 2)
            //Methods: printChars, printEndlines
            conIO.printChars(NAME_BLOCK_WIDTH + 1, DOUBLE_DASH);
            conIO.printEndlines(TWO_ENDLINES);
            
         }
      
      /*
      Name: promptForCoef
      Process: prompts the user to enter a coefficient
      Method Input/Parameters: message to user
      Method Output/Parameters: none
      Method Output/Returned: coefficient that the user entered
      Device Input/Keyboard: none
      Device Output/Monitor: prompt displayed
      Dependencies: Console IO Class tools
      */
      public static int promptForCoef(String promptString)
         {
            //Instantiate Console_IO_Class
            Console_IO_Class conIO = new Console_IO_Class();
            
            //Prompts the user for an integer with given prompt String and
            //returns that integer
            //Methods: promptForInt
            return conIO.promptForInt(promptString);
         }
      
      /*
      Name: calcDenom
      Process: calculates the denominator of the equation
      Method Input/Parameters: coefficient A
      Method Output/Parameters: none
      Method Output/Returned: denominator
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: none
      */
      public static double calcDenom(int coeffA)
         {
            //Calcuates the denominator and returns the value
            return DENOMINATOR_COEFF * coeffA;
         }
      
      /*
      Name: calcDiscrim
      Process: calculates the discriminant
      Method Input/Parameters: coefficients A, B, and C
      Method Output/Parameters: none
      Method Output/Returned: discriminant
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: none
      */
      public static double calcDiscrim(int coeffA, int coeffB, int coeffC)
         {
            //Calculates the discriminant and returns the value
            return coeffB * coeffB - DISCRIMINANT_COEFF * coeffA * coeffC;
         }
      
      /*
      Name: calcRoot
      Process: calculates one root
      Method Input/Parameters: Coefficient B (int), the sqrt of the 
         discriminant (double), the denominator (double)
      Method Output/Parameters: none
      Method Output/Returned: root
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: none
      */
      public static double calcRoot(int coeffB, double discriminantSqrt, 
            double denominator)
         {
            //Calculates one root
            return (-coeffB + discriminantSqrt) / denominator;
            
         }
      
      /*
      Name: displayTableTitle
      Process: displays the title of the table
      Method Input/Parameters: none
      Method Output/Parameters: none
      Method Output/Returned: none
      Device Input/Keyboard: none
      Device Output/Monitor: table title
      Dependencies: Console IO Class tools
      */
      public static void displayTableTitle()
         {
            //Instantiate Console_IO_Class
            Console_IO_Class conIO = new Console_IO_Class();
            
            //Displays table header line
            //Methods: printEndline, displayLine
            conIO.printEndline();
            displayLine(DOUBLE_DASH, "SOLID");
            conIO.printEndline();
            
            conIO.printChar(PIPE);
            conIO.printString("QUADRATIC ROOT RESULTS", TABLE_WIDTH, "CENTER");
            conIO.printChar(PIPE);
            conIO.printEndline();
            
         }
      
      /*
      Name: displayTableSubtitles
      Process: displays the subtitles of the table
      Method Input/Parameters: none
      Method Output/Parameters: none
      Method Output/Returned: none
      Device Input/Keyboard: none
      Device Output/Monitor: table subtitles
      Dependencies: Console IO Class tools
      */
      public static void displayTableSubtitles()
         {
            //Instantiate Console_IO_Class
            Console_IO_Class conIO = new Console_IO_Class();
            
            //Displays line above subtitles
            //Methods: printEndline, displayLine
            displayLine(DASH, "SOLID");
            conIO.printEndline();
            
            //Displays table subtitles
            //Methods: printString, printChar, printEndline
            conIO.printString(PIPE_SPACE);
            conIO.printString("VALUE NAME", NAME_BLOCK_WIDTH, "CENTER");
            conIO.printChar(PIPE);
            conIO.printString("VALUE", VALUE_BLOCK_WIDTH, "CENTER");
            conIO.printString(SPACE_PIPE);
            conIO.printEndline();
            
            
         }
      
      /*
      Name: displayDataLine
      Process: displays a line of data in the table
      Method Input/Parameters: description (String), the value (double),
         character of the line above the data line (char)
      Method Output/Parameters: none
      Method Output/Returned: none
      Device Input/Keyboard: none
      Device Output/Monitor: divider and data line
      Dependencies: Console IO Class tools
      */
      public static void displayDataLine(String description, double number, 
            char lineChar)
         {
            //Instantiate Console_IO_Class
            Console_IO_Class conIO = new Console_IO_Class();
            
            //Display line above data
            //Methods: printEndline, displayLine
            displayLine(lineChar, "BROKEN");
            conIO.printEndline();
            
            //Display data line
            //Methods: printString, printChar, printDouble, printEndline
            conIO.printString(PIPE_SPACE);
            conIO.printString(description, NAME_BLOCK_WIDTH, "LEFT");
            conIO.printChar(CROSS);
            conIO.printDouble(number, PRECISION, VALUE_BLOCK_WIDTH, "RIGHT");
            conIO.printString(SPACE_PIPE);
            conIO.printEndline();
         }
      
      /*
      Name: displayLine
      Process: displays a line, either broken or solid
      Method Input/Parameters: character line is filled with (char), "BROKEN"
         or "SOLID" (String)
      Method Output/Parameters: none
      Method Output/Returned: none
      Device Input/Keyboard: none
      Device Output/Monitor: divider line
      Dependencies: Console IO Class tools
      */
      public static void displayLine(char lineChar, String type)
         {
            //Instantiate Console_IO_Class
            Console_IO_Class conIO = new Console_IO_Class();
            
            //If method is called to display broken line
            if(type == "BROKEN")
               {
                  //Prints broken line
                  //Methods: printChar, printChars
                  conIO.printChar(PIPE);
                  conIO.printChars(NAME_BLOCK_WIDTH + 1, lineChar);
                  conIO.printChar(PIPE);
                  conIO.printChars(VALUE_BLOCK_WIDTH + 1, lineChar);
                  conIO.printChar(PIPE);
               }
            //Otherwise, if method is called to display solid line
            else if(type == "SOLID")
               {
                  //Prints solid line
                  //Methods: printChar, printChars
                  conIO.printChar(PIPE);
                  conIO.printChars(TABLE_WIDTH, lineChar);
                  conIO.printChar(PIPE);
               }
         }
      
      /*
      Name: displayProgramEnd
      Process: displays the end of the program
      Method Input/Parameters: none
      Method Output/Parameters: none
      Method Output/Returned: none
      Device Input/Keyboard: none
      Device Output/Monitor: message displayed
      Dependencies: Console IO Class tools
      */
      public static void displayProgramEnd()
         {
            //Instantiate Console_IO_Class
            Console_IO_Class conIO = new Console_IO_Class();
            
            //Prints end program
            //Methods: printEndlines, printString
            conIO.printEndlines(TWO_ENDLINES);
            conIO.printString("End Program");
         }
   }
