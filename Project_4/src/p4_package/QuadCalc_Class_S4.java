package p4_package;

public class QuadCalc_Class_S4
   {
      //Standard character constants
      public static final char DASH = '-';
      public static final char DOUBLE_DASH = '=';
      public static final char PIPE = '|';
      public static final char CROSS = '+';

      //Character constants with spacing
      public static final String PIPE_SPACE = "| ";
      public static final String SPACE_PIPE = " |";
      public static final String CROSS_SPACE = "+ ";
      
      //Integer constants
      public static final int PRECISION = 2;
      public static final int TABLE_WIDTH = 44;
      public static final int NAME_BLOCK_WIDTH = 29;
      public static final int VALUE_BLOCK_WIDTH = 12;
      public static final int DENOMINATOR_COEFF = 2;
      public static final int DISCRIMINANT_COEFF = 4;
      
      //Spacing constant
      public static final int TWO_ENDLINES = 2;
      
      //Precision constant
      public static final double PRECISION_OFFSET = 0.000001;
      
      //Create console IO instance
      private static Console_IO_Class conIO = new Console_IO_Class();
      
      public static void main(String[] args)
         {
            //Quadratic Formula:
            //x = (-b +- sqrt(b^2 - 4ac))/ 2a
            
            //Variable declarations
            int coeffA, coeffB, coeffC;
            double discriminant, discriminantSqrt, denominator;
            boolean complexFlag = false;
            double rootOne = 0.0, rootTwo = 0.0;
            
            //print title
            //Method: printString, printEndline(s), printChars
            conIO.printString("Quadratic Root Finding Program");
            conIO.printEndline();
            conIO.printChars(NAME_BLOCK_WIDTH + 1, DOUBLE_DASH);
            conIO.printEndlines(TWO_ENDLINES);
            
            //prompt user for a,b,c
            //Method: promptForInt, printEndlines
            coeffA = conIO.promptForInt("     Enter Coefficient A: ");
            coeffB = conIO.promptForInt("     Enter Coefficient B: ");
            coeffC = conIO.promptForInt("     Enter Coefficient C: ");
            conIO.printEndlines(TWO_ENDLINES);
            
            //find roots if possible
            //find discriminant
            discriminant = coeffB * coeffB - 
                  DISCRIMINANT_COEFF * coeffA * coeffC;
            
            //check for complex root
                //set complex flag to true
            if(discriminant < 0) 
               {
                  complexFlag = true;
               }
            //otherwise, find roots (assume 1 or 2 roots)
            else
               {
                 //find square root of discriminant
                 discriminantSqrt = Math.sqrt(discriminant);
                 //find denominator
                 denominator = DENOMINATOR_COEFF * coeffA;
                 //calculate both roots
                 rootOne = (-coeffB + discriminantSqrt) / denominator;
                 rootTwo = (-coeffB - discriminantSqrt) / denominator;
               }
            
            //display table
            //methods: printChar, printChars, printString, printEndline, 
            //printDouble
            
            //line 1
            conIO.printChar(PIPE);
            conIO.printChars(TABLE_WIDTH, DOUBLE_DASH);
            conIO.printChar(PIPE);
            conIO.printEndline();
            
            //line 2
            conIO.printChar(PIPE);
            conIO.printString("QUADRATIC ROOT RESULTS", TABLE_WIDTH, "CENTER");
            conIO.printChar(PIPE);
            conIO.printEndline();
            
            //line 3
            conIO.printChar(PIPE);
            conIO.printChars(TABLE_WIDTH, DASH);
            conIO.printChar(PIPE);
            conIO.printEndline();
            
            //line 4
            conIO.printString(PIPE_SPACE);
            conIO.printString("VALUE NAME", NAME_BLOCK_WIDTH, "CENTER");
            conIO.printChar(PIPE);
            conIO.printString("VALUE", VALUE_BLOCK_WIDTH, "CENTER");
            conIO.printString(SPACE_PIPE);
            conIO.printEndline();
            
            //line 5
            conIO.printChar(PIPE);
            conIO.printChars(NAME_BLOCK_WIDTH + 1, DOUBLE_DASH);
            conIO.printChar(PIPE);
            conIO.printChars(VALUE_BLOCK_WIDTH + 1, DOUBLE_DASH);
            conIO.printChar(PIPE);
            conIO.printEndline();
   
            //line 6
            conIO.printString(PIPE_SPACE);
            conIO.printString("Coefficient A", NAME_BLOCK_WIDTH, "LEFT");
            conIO.printChar(CROSS);
            conIO.printDouble(coeffA, PRECISION, VALUE_BLOCK_WIDTH, "RIGHT");
            conIO.printString(SPACE_PIPE);
            conIO.printEndline();
            
            //line 7
            conIO.printChar(PIPE);
            conIO.printChars(NAME_BLOCK_WIDTH + 1, DASH);
            conIO.printChar(PIPE);
            conIO.printChars(VALUE_BLOCK_WIDTH + 1, DASH);
            conIO.printChar(PIPE);
            conIO.printEndline();
            
            //line 8
            conIO.printString(PIPE_SPACE);
            conIO.printString("Coefficient B", NAME_BLOCK_WIDTH, "LEFT");
            conIO.printChar(CROSS);
            conIO.printDouble(coeffB, PRECISION, VALUE_BLOCK_WIDTH, "RIGHT");
            conIO.printString(SPACE_PIPE);
            conIO.printEndline();
            
            //line 9
            conIO.printChar(PIPE);
            conIO.printChars(NAME_BLOCK_WIDTH + 1, DASH);
            conIO.printChar(PIPE);
            conIO.printChars(VALUE_BLOCK_WIDTH + 1, DASH);
            conIO.printChar(PIPE);
            conIO.printEndline();
            
            //line 10
            conIO.printString(PIPE_SPACE);
            conIO.printString("Coefficient C", NAME_BLOCK_WIDTH, "LEFT");
            conIO.printChar(CROSS);
            conIO.printDouble(coeffC, PRECISION, VALUE_BLOCK_WIDTH, "RIGHT");
            conIO.printString(SPACE_PIPE);
            conIO.printEndline();
            
            //line 11
            conIO.printChar(PIPE);
            conIO.printChars(NAME_BLOCK_WIDTH + 1, DOUBLE_DASH);
            conIO.printChar(PIPE);
            conIO.printChars(VALUE_BLOCK_WIDTH + 1, DOUBLE_DASH);
            conIO.printChar(PIPE);
            conIO.printEndline();
            
            
            //check for complex
            //Method: if statement, printString, printChar, printEndline
            if(complexFlag)
               {
                  //subline 1
                  conIO.printString(PIPE_SPACE);
                  conIO.printString("Roots", NAME_BLOCK_WIDTH, "LEFT");
                  conIO.printChar(CROSS);
                  conIO.printString("Complex", VALUE_BLOCK_WIDTH, "RIGHT");
                  conIO.printString(SPACE_PIPE);
                  conIO.printEndline();
               }
            
            //check for only 1 root
            // if((num1 + offset > num2) && (num1 - offset < num2))
            // num1 == num2 within precision
            //Method: else if statement, printString, printChar, printDouble,
            //printEndline
            else if((rootOne + PRECISION_OFFSET > rootTwo) && 
                  (rootOne - PRECISION_OFFSET < rootTwo))
               {
                  //subline 1
                  conIO.printString(PIPE_SPACE);
                  conIO.printString("Single Root", NAME_BLOCK_WIDTH, "LEFT");
                  conIO.printChar(CROSS);
                  conIO.printDouble(rootOne, PRECISION, 
                        VALUE_BLOCK_WIDTH, "RIGHT");
                  conIO.printString(SPACE_PIPE);
                  conIO.printEndline();
               }
            
            //otherwise, 2 roots
            //Method: else, printString, printChar, printDouble, printEndline
            else
               {  
                  //subline 1
                  conIO.printString(PIPE_SPACE);
                  conIO.printString("Root One", NAME_BLOCK_WIDTH, "LEFT");
                  conIO.printChar(CROSS);
                  conIO.printDouble(rootOne, PRECISION, 
                        VALUE_BLOCK_WIDTH, "RIGHT");
                  conIO.printString(SPACE_PIPE);
                  conIO.printEndline();
                  
                  //subline 2
                  conIO.printChar(PIPE);
                  conIO.printChars(NAME_BLOCK_WIDTH + 1, DASH);
                  conIO.printChar(PIPE);
                  conIO.printChars(VALUE_BLOCK_WIDTH + 1, DASH);
                  conIO.printChar(PIPE);
                  conIO.printEndline();
                  
                  //subline 3
                  conIO.printString(PIPE_SPACE);
                  conIO.printString("Root Two", NAME_BLOCK_WIDTH, "LEFT");
                  conIO.printChar(CROSS);
                  conIO.printDouble(rootTwo, PRECISION, 
                        VALUE_BLOCK_WIDTH, "RIGHT");
                  conIO.printString(SPACE_PIPE);
                  conIO.printEndline();
               }
   
            
            //Ending line
            conIO.printChar(PIPE);
            conIO.printChars(NAME_BLOCK_WIDTH + 1, DOUBLE_DASH);
            conIO.printChar(PIPE);
            conIO.printChars(VALUE_BLOCK_WIDTH + 1, DOUBLE_DASH);
            conIO.printChar(PIPE);
            conIO.printEndlines(TWO_ENDLINES);
            
            //Print End Program
            conIO.printString("End Program");
         }

   }
