package p3_package;

public class PolyMultiplierClass_S4
   {
      //Initialize constants
      private static final char EQUALS = '=';
      private static final char SPACE = ' ';
      
      private static final int EQUAL_CHARS = 21;
      private static final int TAB_SPACE = 2;
      private static final int DOUBLE_LINE_SKIP = 2;
      //Create console IO instance
         //Instantiate with private and static
      private static Console_IO_Class conIO = new Console_IO_Class();
      
      public static void main(String[] args) 
         {
            //Initialize program
               //Initialize Variables
            int varA, varB, varBC, varC, varAD, varD, varR, varS, varT;
               //Display Title
                  //Method: conIO.printString, conIO.printChars, 
                  // conIO.printEndline(s)
            conIO.printString("Polynomial Calculator");
            conIO.printEndline();
            conIO.printChars(EQUAL_CHARS, EQUALS);
            conIO.printEndlines(DOUBLE_LINE_SKIP);
            
            conIO.printString("Multiplies two polynomial expressions");
            conIO.printChars(TAB_SPACE, SPACE);
            conIO.printEndline();
            conIO.printString("in the form: ( ax + b ) * ( cx + d )");
            conIO.printEndlines(DOUBLE_LINE_SKIP);
            
            //Prompt user for coefficients
               //Get coeff a
                  //Method: conIO.promptForInt
            varA = conIO.promptForInt("Enter coefficient a: ");        
               //Get coeff b
                  //Method: conIO.promptForInt
            varB = conIO.promptForInt("Enter coefficient b: ");
               //Get coeff c
                  //Method: conIO.promptForInt
            varC = conIO.promptForInt("Enter coefficient c: ");
               //Get coeff d
                  //Method: conIO.promptForInt
            varD = conIO.promptForInt("Enter coefficient d: ");
               //Print endline
                  //Method: conIO.printEndline
            conIO.printEndline();

            //Multiply polynomials
               //Calculate r
                  //Calculate a*c
            varR = varA * varC;
               //Calculate s
                  //Calculate b*c
            varBC = varB * varC;
                  //Calculate a*d
            varAD = varA * varD;           
                  //Calculate b*c + a*d
            varS = varBC + varAD;
               //Calculate t
                  //Calculate b*d
            varT = varB * varD;

            //Display results
               //Display header
                  //Method: conIO.printString, conIO.printEndline
            conIO.printString("Result: ");
            conIO.printEndline();
               //Display original polynomial
                  //Method: conIO.printString and conIO.printInt
            conIO.printString("( ");
            conIO.printInt(varA);
            conIO.printString("x + ");
            conIO.printInt(varB);
            conIO.printString(" )*( ");
            conIO.printInt(varC);
            conIO.printString("x + ");
            conIO.printInt(varD);
            conIO.printString(" ) ");
               //Display =
                  //Method: conIO.printChar
            conIO.printChar(EQUALS);
            conIO.printChar(SPACE);
               //Display 2nd degree polynomial
                  //Method: conIO.printString, conIO.printInt, 
                  // conIO.printEndlines
            conIO.printInt(varR);
            conIO.printString("x^2 + ");
            conIO.printInt(varS);
            conIO.printString("x + ");
            conIO.printInt(varT);
            conIO.printEndlines(DOUBLE_LINE_SKIP);
   
            //End program
               //Display program end
                  //Method: conIO.printString
            conIO.printString("Program End");
            
         }
   }

