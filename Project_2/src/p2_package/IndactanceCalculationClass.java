package p2_package;

public class IndactanceCalculationClass
    {
     public static final char DASH = '-';
     public static final char DOUBLE_DASH = '=';
     public static final char PIPE = '|';
     public static final char CROSS = '+';
     
     public static final int TWO_ENDLINES = 2;
     public static final int PRECISION = 2;
     public static final int TABLE_WIDTH = 65;
     public static final int MEASURED_BLOCK_WIDTH = 20;
     public static final int NAME_BLOCK_WIDTH = 29;
     public static final int VALUE_BLOCK_WIDTH = 12;

     public static final String PIPE_SPACE = "| ";
     public static final String SPACE_PIPE = " |";
     public static final String CROSS_SPACE = "+ ";

     public static final double TWO_PI = 2.0 * Math.PI;
     
     public static void main( String[] args )
        {
         
         Console_IO_Class conIO = new Console_IO_Class();
         
         //Table title
         
         conIO.printString("Indactance Calculation Program");
         conIO.printEndline();
         conIO.printChars(NAME_BLOCK_WIDTH + 1, DOUBLE_DASH);
         conIO.printEndlines(TWO_ENDLINES);
         
         //Inputs
         
         double current = conIO.promptForDouble("  Enter Current       (A): ");
         double resistance = 
               conIO.promptForDouble("  Enter Resistance (Ohms): ");
         double frequency = 
               conIO.promptForDouble("  Enter Frequency    (hz): ");
         double capacitance = 
               conIO.promptForDouble("  Enter Capacitance   (F): ");
         
         //Calculation
         
         double numerator = current * resistance;
         double denominator = TWO_PI * frequency * capacitance;
         double indactance = numerator / denominator;
         
         //Formatting variables
         
         String formattedCurrent = conIO.formatDouble(current, PRECISION);
         String formattedResistance = conIO.formatDouble(resistance, PRECISION);
         String formattedFrequency = conIO.formatDouble(frequency, PRECISION);
         String formattedCapacitance = 
               conIO.formatDouble(capacitance, PRECISION);
         String formattedIndactance = conIO.formatDouble(indactance, PRECISION);
         
         //Output
         
         //Line 0-1
         
         conIO.printEndline();
         conIO.printChar(PIPE);
         conIO.printChars(TABLE_WIDTH, DOUBLE_DASH);
         conIO.printChar(PIPE);
         conIO.printEndline();
         
         //Line 2
         
         conIO.printChar(PIPE);
         conIO.printString("INDACTANCE CALCULATION PROGRAM", 
               TABLE_WIDTH, "CENTER");
         conIO.printChar(PIPE);
         conIO.printEndline();
         
         //Line 3
         
         conIO.printChar(PIPE);
         conIO.printChars(TABLE_WIDTH, DASH);
         conIO.printChar(PIPE);
         conIO.printEndline();
         
         //Line 4
         
         conIO.printChar(PIPE);
         conIO.printString("MEASURED", MEASURED_BLOCK_WIDTH + 1, "CENTER");
         conIO.printChar(PIPE);
         conIO.printString("NAME", NAME_BLOCK_WIDTH + 1, "CENTER");
         conIO.printChar(PIPE);
         conIO.printString("VALUE", VALUE_BLOCK_WIDTH, "CENTER");
         conIO.printChar(PIPE);
         conIO.printEndline();
         
         //Line 5
         
         conIO.printChar(PIPE);
         conIO.printChars(MEASURED_BLOCK_WIDTH + 1, DOUBLE_DASH);
         conIO.printChar(PIPE);
         conIO.printChars(NAME_BLOCK_WIDTH + 1, DOUBLE_DASH);
         conIO.printChar(PIPE);
         conIO.printChars(VALUE_BLOCK_WIDTH, DOUBLE_DASH);
         conIO.printChar(PIPE);
         conIO.printEndline();
         
         //Line 6
         
         conIO.printString(PIPE_SPACE);
         conIO.printString("Field", MEASURED_BLOCK_WIDTH, "LEFT");
         conIO.printString(CROSS_SPACE);
         conIO.printString("Current", NAME_BLOCK_WIDTH, "LEFT");
         conIO.printChar(CROSS);
         conIO.printString(formattedCurrent, VALUE_BLOCK_WIDTH - 1, "RIGHT");
         conIO.printString(SPACE_PIPE);
         conIO.printEndline();
         
         //Line 7
         
         conIO.printChar(PIPE);
         conIO.printChars(MEASURED_BLOCK_WIDTH + 1, DASH);
         conIO.printChar(PIPE);
         conIO.printChars(NAME_BLOCK_WIDTH + 1, DASH);
         conIO.printChar(PIPE);
         conIO.printChars(VALUE_BLOCK_WIDTH, DASH);
         conIO.printChar(PIPE);
         conIO.printEndline();
         
         //Line 8
         
         conIO.printString(PIPE_SPACE);
         conIO.printString("Field", MEASURED_BLOCK_WIDTH, "LEFT");
         conIO.printString(CROSS_SPACE);
         conIO.printString("Resistance", NAME_BLOCK_WIDTH, "LEFT");
         conIO.printChar(CROSS);
         conIO.printString(formattedResistance, VALUE_BLOCK_WIDTH - 1, "RIGHT");
         conIO.printString(SPACE_PIPE);
         conIO.printEndline();
         
         //Line 9
         
         conIO.printChar(PIPE);
         conIO.printChars(MEASURED_BLOCK_WIDTH + 1, DASH);
         conIO.printChar(PIPE);
         conIO.printChars(NAME_BLOCK_WIDTH + 1, DASH);
         conIO.printChar(PIPE);
         conIO.printChars(VALUE_BLOCK_WIDTH, DASH);
         conIO.printChar(PIPE);
         conIO.printEndline();
         
         //Line 10
         
         conIO.printString(PIPE_SPACE);
         conIO.printString("Laboratory", MEASURED_BLOCK_WIDTH, "LEFT");
         conIO.printString(CROSS_SPACE);
         conIO.printString("Frequency", NAME_BLOCK_WIDTH, "LEFT");
         conIO.printChar(CROSS);
         conIO.printString(formattedFrequency, VALUE_BLOCK_WIDTH - 1, "RIGHT");
         conIO.printString(SPACE_PIPE);
         conIO.printEndline();
         
         //Line 11
         
         conIO.printChar(PIPE);
         conIO.printChars(MEASURED_BLOCK_WIDTH + 1, DASH);
         conIO.printChar(PIPE);
         conIO.printChars(NAME_BLOCK_WIDTH + 1, DASH);
         conIO.printChar(PIPE);
         conIO.printChars(VALUE_BLOCK_WIDTH, DASH);
         conIO.printChar(PIPE);
         conIO.printEndline();
         
         //Line 12
         
         conIO.printString(PIPE_SPACE);
         conIO.printString("Field", MEASURED_BLOCK_WIDTH, "LEFT");
         conIO.printString(CROSS_SPACE);
         conIO.printString("Capacitance", NAME_BLOCK_WIDTH, "LEFT");
         conIO.printChar(CROSS);
         conIO.printString(formattedCapacitance, 
               VALUE_BLOCK_WIDTH - 1, "RIGHT");
         conIO.printString(SPACE_PIPE);
         conIO.printEndline();
         
         //Line 13
         
         conIO.printChar(PIPE);
         conIO.printChars(MEASURED_BLOCK_WIDTH + 1, DASH);
         conIO.printChar(PIPE);
         conIO.printChars(NAME_BLOCK_WIDTH + 1, DASH);
         conIO.printChar(PIPE);
         conIO.printChars(VALUE_BLOCK_WIDTH, DASH);
         conIO.printChar(PIPE);
         conIO.printEndline();
         
         //Line 14
         
         conIO.printString(PIPE_SPACE);
         conIO.printString("Calculated Result", MEASURED_BLOCK_WIDTH, "LEFT");
         conIO.printString(CROSS_SPACE);
         conIO.printString("Capacitive Indactance", NAME_BLOCK_WIDTH, "LEFT");
         conIO.printChar(CROSS);
         conIO.printString(formattedIndactance, VALUE_BLOCK_WIDTH - 1, "RIGHT");
         conIO.printString(SPACE_PIPE);
         conIO.printEndline();
         
         //Line 15-16
         
         conIO.printChar(PIPE);
         conIO.printChars(MEASURED_BLOCK_WIDTH + 1, DASH);
         conIO.printChar(PIPE);
         conIO.printChars(NAME_BLOCK_WIDTH + 1, DASH);
         conIO.printChar(PIPE);
         conIO.printChars(VALUE_BLOCK_WIDTH, DASH);
         conIO.printChar(PIPE);
         conIO.printEndlines(TWO_ENDLINES);
         
         //Line 17
         
         conIO.printString("End Program");
         
        }

    } 

