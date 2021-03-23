package p9_package;

public class BinaryAdderClass
   {
      // Declare and initialize constants
      private final int BASE_TWO = 2;
      private final int DEFAULT_CAPACITY = 50;
      private final char SPACE = ' ';
      
      // Declare member variables
      private int[] bitArray;
      private int numBits;
      
      /**
       * Default constructor
       */
      public BinaryAdderClass()
         {
            // Initalize the bit array with default capacity
            bitArray = new int[DEFAULT_CAPACITY];
            // Initialize the number of bits to 0
            numBits = 0;
         }
      
      /**
       * Initialization Constructor
       * 
       * @param decimal value (base 10)
       */
      public BinaryAdderClass(int decimalValue)
         {
            // Generate the binary bit array
            // Method: convertToBinary
            bitArray = convertToBinary(decimalValue);
         }
      
      /**
       * Copy constructor
       * 
       * @param copied Object to copy from
       */
      public BinaryAdderClass(BinaryAdderClass copied)
         {
            // Declare variables
            int index;
            
            // Sets member variables equal in both instances
            this.numBits = copied.numBits;
            
            // Initialize new bit array
            bitArray = new int[DEFAULT_CAPACITY];
            
            // Loop through each value of the bit arrays
            for(index = 0; index < DEFAULT_CAPACITY; index++)
               {
                  // Set each value of each array equal to eachother
                  this.bitArray[index] = copied.bitArray[index];
               }
         }
      
      /*
      Name: addValue
      Process: creates a new instance and adds the bit strings
      Method Input/Parameters: decimal value (int)
      Method Output/Parameters: none
      Method Output/Returned: none
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: none
      */
      public void addValue(int decimalValue)
         {
            // Create a temporary new instance
            BinaryAdderClass addend = new BinaryAdderClass(decimalValue);
            // Add new instance value to current instance
            addValue(addend);
         }
      
      /*
      Name: addValue
      Process: adds two bit strings and stores the result as the current array
      Method Input/Parameters: seperate object instance (BinaryAdderClass)
      Method Output/Parameters: none
      Method Output/Returned: none
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: none
      */
      public void addValue(BinaryAdderClass addend)
         {
            // Declare variables
            int index, resultBit, carry, maxValue;
            
            // Find the max value of the arrays
            // Method: findMax
            maxValue = findMax(this.numBits, addend.numBits);
            maxValue = DEFAULT_CAPACITY;
            
            // Set the default carry value to 0
            carry = 0;
            
            // Loop through each value of the arrays
            for(index = 0; index < maxValue; index++)
               {
                  // Calculate the result of the binary addition
                  resultBit = carry + this.bitArray[index] + 
                        addend.bitArray[index];
                  
                  // Results will range from 0-3
                  switch(resultBit)
                     {
                        // If result is 0 (00)
                        case 0:
                           // Set result to 0
                           this.bitArray[index] = 0;
                           // Set carry to 0
                           carry = 0;
                           break;
                        // If result is 1 (01)
                        case 1:
                           // Set result to 1
                           this.bitArray[index] = 1;
                           // Set carry to 0
                           carry = 0;
                           break;
                        // If result is 2 (10)
                        case 2:
                           // Set result to 0
                           this.bitArray[index] = 0;
                           // Set carry to 1
                           carry = 1;
                           break;
                        // If result is 3 (11)
                        case 3:
                           // Set result to 1
                           this.bitArray[index] = 1;
                           // Set carry to 1
                           carry = 1;
                           break;
                     }
               }
            
         }
      
      /*
      Name: convertToBinary
      Process: converts a decimal value to binary in little endian
      Method Input/Parameters: decimal value (int)
      Method Output/Parameters: none
      Method Output/Returned: bit array (int[])
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: none
      */
      private int[] convertToBinary(int decimalValue)
         {
            // Declare variables
            int counter, index, bit;
            int [] bits;
            
            // Set starting value to original value
            counter = decimalValue;
            
            // Create a new bits array to store conversion
            bits = new int[DEFAULT_CAPACITY];
            
            // Loop through each value in the bits array
            for(index = 0; index < DEFAULT_CAPACITY; index++)
               {
                  // Determine the remainder after dividing by 2
                  bit = counter % BASE_TWO;
                  // Set the array at the index to the bit
                  bits[index] = bit;
                  
                  // Divide the value by 2
                  counter /= BASE_TWO;
               }
            
            // Return the array of bits
            return bits;
            
         }
      
      /*
      Name: displayBits
      Process: displays the bit array to console
      Method Input/Parameters: block size of text (int)
      Method Output/Parameters: none
      Method Output/Returned: none
      Device Input/Keyboard: none
      Device Output/Monitor: Bit array shown to screen
      Dependencies: none
      */
      public void displayBits(int blockSize)
         {
            // Declare variables
            int counter, currentBit, whiteSpace, index;
            
            // Initialize variables
            counter = DEFAULT_CAPACITY - 1;
            currentBit = 0;
            
            // Find the first non-0 bit
            while(currentBit != 1)
               {
                  // Find the current bit at the location
                  currentBit = bitArray[counter];
                  // Lower the location value by 1
                  counter--;
               }
            
            // Set the first non-0 bit location to the number of bits
            numBits = counter + 1;
            
            // Determine the amount of whitespace to print
            whiteSpace = blockSize - numBits;
            
            // Print the whitespace
            // Method: displayChars
            displayChars(whiteSpace - 1, SPACE);
            
            // Loop through array backwards to display in big endian
            for(index = numBits; index >= 0; index--)
               {
                  // Print each bit
                  System.out.print(bitArray[index]);
               }
            
            // Print spacing
            System.out.print("\n");
            
         }
      
      /*
      Name: displayChars
      Process: converts a character that is an integer to an integer
      Method Input/Parameters: number of characters (int), character to display
         (char)
      Method Output/Parameters: none
      Method Output/Returned: none
      Device Input/Keyboard: none
      Device Output/Monitor: characters printed to screen
      Dependencies: none
      */
      public void displayChars(int numChars, char outChar)
         {
            // Declare variables
            int index;
            
            // Loop through each character
            for(index = 0; index < numChars; index++)
               {
                  // Print each character
                  System.out.print(outChar);
               }
            
         }
      
      /*
      Name: findMax
      Process: finds the maximum of two decimal values
      Method Input/Parameters: one value (int), other value (int)
      Method Output/Parameters: none
      Method Output/Returned: maximum value
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: none
      */
      private int findMax(int valOne, int valOther)
         {
            // Check if valOne <= ValOther
            if(valOne <= valOther)
               {
                  // Return that valOther is max
                  return valOther;
               }
            
            // Otherwise, return that valOne is max
            return valOne;
         }
      
      /*
      Name: toString
      Process: converts the bit array to a string
      Method Input/Parameters: none
      Method Output/Parameters: none
      Method Output/Returned: resulting string (String)
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: none
      */
      @Override
      public String toString()
         {
            // Declare and initialize variables
            int index;
            
            String tempString = " ";
            
            // Loop through each bit in the bit array backwards to display as
            // big endian
            for(index = numBits; index >= 0; index--)
               {
                  // Add the bit to the string
                  tempString += bitArray[index];
               }
            
            // Return the string
            return tempString;
         }
   }
