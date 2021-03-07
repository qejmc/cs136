package p5_package;

public class PolyMultiplierClass_II_S4
   {
      
      //Character constants
      private static final char DOUBLE_DASH = '=';
      
      //Spacing constants
      private static final int TITLE_WIDTH = 32;
      private static final int DOUBLE_ENDLINE = 2;
      
      //Create console IO instance
      private static Console_IO_Class conIO = new Console_IO_Class();
      
      public static void main(String[] args) 
         {  
            
            //Declaration/ Initialization of Variables
            int degree, coeffA = 0, coeffB = 0, coeffC = 0, coeffD = 0;
            int coeffE = 0, coeffF = 0;
            int productAC, productBD, productBE, productBF;
            int productADBC, productAEBD, productAFBE;
            
            boolean outOfRange = false;
            
            //Display Title
            //Methods: printString, printEndline, printChars, printEndlines
            conIO.printString("Polynomial Calculator, Part Deux");
            conIO.printEndline();
            conIO.printChars(TITLE_WIDTH, DOUBLE_DASH);
            conIO.printEndlines(DOUBLE_ENDLINE);
            
            //Display Instructions
            //Methods: printString, printEndline, printEndlines
            conIO.printString("Multiplies a first degree polynomial");
            conIO.printEndline();
            conIO.printString("  by a first degree form: ( ax + b ) * "
                  + "( cx + d )");
            conIO.printEndline();
            conIO.printString("  or by a second degree form: ( ax + b ) * "
                  + "( cx^2 + dx + e )");
            conIO.printEndline();
            conIO.printString("  or by a third degree form: ( ax + b ) * "
                  + "( cx^3 + dx^2 + ex + f )");
            conIO.printEndline();
            conIO.printString("depending on user selection");
            conIO.printEndlines(DOUBLE_ENDLINE);
            
            //Prompt for 1-3
            //Method: promptForInt
            degree = conIO.promptForInt("Enter degree form (1-3): ");
            
            //Set flag to true for inputs <1 and >3
            if(degree < 1 || degree > 3) 
               {
                  outOfRange = true;
               }
            
            //If out of range, end program early (skip calculations)
            if(outOfRange)
               {
                  //Method: printEndline, printString
                  conIO.printEndline();
                  conIO.printString("Incorrect number of polynomial degrees "
                        + "entered - Program Aborted");
               }
            
            //Otherwise, prompt user for variables and preform calculations
            else
               {
                  //Check for first degree or greater
                  if(degree > 0)
                     {
                        //Method: promptForInt
                        coeffA = conIO.promptForInt("Enter coefficient a: ");
                        coeffB = conIO.promptForInt("Enter coefficient b: ");
                        coeffC = conIO.promptForInt("Enter coefficient c: ");
                        coeffD = conIO.promptForInt("Enter coefficient d: ");
                     }
                  
                  //Check for second degree or greater
                  if(degree > 1)
                     {
                        //Method: promptForInt
                        coeffE = conIO.promptForInt("Enter coefficient e: ");
                     }
                  
                  //Check for third degree or greater
                  if(degree > 2)
                     {
                        //Method: promptForInt
                        coeffF = conIO.promptForInt("Enter coefficient f: ");
                     }
            
                  //Calculate expansion
                  productAC = coeffA * coeffC;
                  productBD = coeffB * coeffD;
                  productBE = coeffB * coeffE;
                  productBF = coeffB * coeffF;
                  
                  productADBC = coeffA * coeffD + coeffB * coeffC;
                  productAEBD = coeffA * coeffE + productBD;
                  productAFBE = coeffA * coeffF + productBE;
                  
                  //==============
                  //Display result
                  //==============
                  
                  //Common result lines:
                  //Result line 1
                  //Methods: printEndline, printString
                  conIO.printEndline();
                  conIO.printString("Result:");
                  conIO.printEndline();
                  
                  //Result line 2
                  //Methods: printString, printInt
                  conIO.printString("( ");
                  conIO.printInt(coeffA);
                  conIO.printString("x + ");
                  conIO.printInt(coeffB);
                  conIO.printString(" )*( ");
                  
                  //Check for first degree
                  if(degree == 1) 
                     {
                        //Displays original input:
                        //Methods: printString, printInt
                        conIO.printInt(coeffC);
                        conIO.printString("x + ");
                        conIO.printInt(coeffD);
                        conIO.printString(" ) = ");
                        
                        //Prints result in the form:
                        //(ac)x^2 + (bc + ad)x + (bd)
                        
                        //Does not print out parts of result with 0 coefficients
                        if(productAC != 0)
                           {
                              //Methods: printString, printInt
                              conIO.printInt(productAC);
                              conIO.printString("x^2 + ");
                           }
                        if(productADBC != 0)
                           {
                              //Methods: printString, printInt
                              conIO.printInt(productADBC);
                              conIO.printString("x + ");
                           }
                        if(productBD != 0)
                           {
                              //Methods: printInt
                              conIO.printInt(productBD);
                           }
                     }
                  
                  //Check for second degree
                  else if(degree == 2) 
                     {
                        //Displays original input:
                        //Methods: printString, printInt
                        conIO.printInt(coeffC);
                        conIO.printString("x^2 + ");
                        conIO.printInt(coeffD);
                        conIO.printString("x + ");
                        conIO.printInt(coeffE);
                        conIO.printString(") = ");
                        
                        //Prints result in the form:
                        //(ac)x^3 + (bc + ad)x^2 + (ae+bd)x + (be)
                        
                        if(productAC != 0)
                           {
                              //Methods: printString, printInt
                              conIO.printInt(productAC);
                              conIO.printString("x^3 + ");
                           }
                        if(productADBC != 0)
                           {
                              //Methods: printString, printInt
                              conIO.printInt(productADBC);
                              conIO.printString("x^2 + ");
                           }
                        if(productAEBD != 0)
                           {
                              //Methods: printString, printInt
                              conIO.printInt(productAEBD);
                              conIO.printString("x + ");
                           }
                        if(productBE != 0)
                           {
                              //Methods: printInt
                              conIO.printInt(productBE);
                           }
                     }
                  
                  //Otherwise, assume third degree
                  else
                     {
                        //Displays original input:
                        //Methods: printString, printInt
                        conIO.printInt(coeffC);
                        conIO.printString("x^3 + ");
                        conIO.printInt(coeffD);
                        conIO.printString("x^2 + ");
                        conIO.printInt(coeffE);
                        conIO.printString("x + ");
                        conIO.printInt(coeffF);
                        conIO.printString(") = ");
                        
                        //Prints result in the form:
                        //(ac)x^4 + (bc + ad)x^3 + (ae+bd)x^2 + 
                        //    (af + be)x + (bf)
                        
                        if(productAC != 0)
                           {
                              //Methods: printString, printInt
                              conIO.printInt(productAC);
                              conIO.printString("x^4 + ");
                           }
                        if(productADBC != 0)
                           {
                              //Methods: printString, printInt
                              conIO.printInt(productADBC);
                              conIO.printString("x^3 + ");
                           }
                        if(productAEBD != 0)
                           {
                              //Methods: printString, printInt
                              conIO.printInt(productAEBD);
                              conIO.printString("x^2 + ");
                           }
                        if(productAFBE != 0)
                           {
                              //Methods: printString, printInt
                              conIO.printInt(productAFBE);
                              conIO.printString("x + ");
                           }
                        if(productBF != 0)
                           {
                              //Methods: printInt
                              conIO.printInt(productBF);
                           }
                     }
               }
               
            //End program
            //Methods: printString, printEndlines
            conIO.printEndlines(DOUBLE_ENDLINE);
            conIO.printString("Program End");
            
            
            
            
         }
      
   }
