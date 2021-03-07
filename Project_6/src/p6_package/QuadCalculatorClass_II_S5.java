package p6_package;

public class QuadCalculatorClass_II_S5
   {
      // initialize table characters

      
      // initialize line controls


      // initialize table string components

      
      // initialize table widths

      
      // initialize calculation constants


      // initialize two endlines constant

      
      public static void main(String[] args)
         {
            // initialize program
               
               // initialize variables

                  
               // show title
               //Methods: printTitle

            
            // get coefficients from user
               // get coefficient A
               //Method: promptForCoef

               // get coefficient B
               //Method: promptForCoef

               // get coefficient C
               //Method: promptForCoef

            
            // process the quadratic roots
            
               // calculate the denominator
               //Method: calcDenom

            
               // calculate the discriminant
               //Method: calcDiscrim

            
               // calculate roots
            
                  //Test for complex

                  //Otherwise, calculate 2 roots

                  //Test for single Root

                  
                  //Calculate discriminant Sqrt
                  //Methods: Math.sqrt

                     // calculate root one
                     //Method: calcRoot

                     // calculate root two
                     //Method: calcRoot


            // display roots
            
               // display table title
               //Method: displayTableTitle

            
               // display table subtitle
               //Method: displayTableSubtitles

            
               // display user input values
               //Method: displayDataLine

            
               // display if complex

                  //Method: displayDataLine

               // display if single root

                  //Method: displayDataLine

               // otherwise, display both roots

                  // display root one
                  //Method: displayDataLine

                  // display root two
                  //Method: displayDataLine

               //display ending line
               //Method: displayDataLine

            // end program
         
               // display program end
               //Method: displayProgramEnd
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

            
            //Print program title (line 1)
            //Methods: printString, printEndline

            
            //Print separating bar (line 2)
            //Methods: printChars, printEndlines

            
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

            
            //Prompts the user for an integer with given prompt String and
            //returns that integer
            //Methods: promptForInt

            return 0; //temporary stub return
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
            
            return 0.0; //temporary stub return
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
            
            return 0.0; //temporary stub return
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
            
            return 0.0; //temporary stub return
            
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

            
            //Displays table header line
            //Methods: printEndline, displayLine

            
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

            
            //Displays line above subtitles
            //Methods: printEndline, displayLine

            
            //Displays table subtitles
            //Methods: printString, printChar, printEndline

            
            
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

            
            //Display line above data
            //Methods: printEndline, displayLine

            
            //Display data line
            //Methods: printString, printChar, printDouble, printEndline

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

            
            //If method is called to display broken line

                  //Prints broken line
                  //Methods: printChar, printChars

            //Otherwise, if method is called to display solid line

                  //Prints solid line
                  //Methods: printChar, printChars
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

            
            //Prints end program
            //Methods: printEndlines, printString

         }
   }
