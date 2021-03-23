package p8_package;

public class EncryptionClass
   {
      // Declare global constants
      private static int TWO_END_LINES = 2;
      
      // Instantiate console IO
      private static Console_IO_Class conIO = new Console_IO_Class();
      
      //TODO: Alphabetize methods
      public static void main(String[] args)
         {
            // Declare variables
            String encryptKey, string, decryptKey, secondaryString;

            int[] intArray, secondaryIntArray;
            char[] charArray, encryptedString, secondaryCharArray;
            char[] decryptedString;
            
            // Print title
            // Methods: printString, printEndlines
            conIO.printString("Encryption / Decryption Program");
            conIO.printEndlines(TWO_END_LINES);
            
            // Display encryption instructions
            // Methods: printString, printEndlines
            conIO.printString("Part one accepts a series of key integers and "
                  + "then a string to be encrypted.");
            conIO.printEndlines(TWO_END_LINES);
            
            // Prompt for encryption key and string
               // Prompt for encryption key
               // Method: prompyForString
            encryptKey = conIO.promptForString("Enter series of numbers: ");
               // Prompt for string
               // Method: prompyForString
            string = conIO.promptForString("Enter string to be encrypted: ");
            
            // Convert key and string to arrays
               // Convert key to int array
               // Method: convertStringToIntArray
            intArray = convertStringToIntArray(encryptKey);
               // Convert string to char array
               // Method: convertStringToCharArray
            charArray = convertStringToCharArray(string);
            
            // Encrypt the string with the key
            // Method: encryptString
            encryptedString = encryptString(intArray, charArray);
            
            // Display encrypted string to user
            // Method: displayStringWithLeader
            displayStringWithLeader("Encrypted String: ", encryptedString);
            
            // Display decryption instructions
            // Method: printString, printEndlines
            conIO.printString("Part two accepts a series of key integers and "
                  + "then a string to be decrypted.");
            conIO.printEndlines(TWO_END_LINES);
            
            // Prompt for decryption key and string
               // Prompt for decryption key
               // Method: promptForString
            decryptKey = conIO.promptForString("Enter series of numbers"
                  + ": ");
               // Prompt for string
               // Method: promptForString
            secondaryString = conIO.promptForString("Enter string to be decrypt"
                  + "ed: ");
            
            // Convert key and string to arrays
               // Convert key to int array
               // Method: convertStringToIntArray
            secondaryIntArray = convertStringToIntArray(decryptKey);
               // Convert string to char array
               // Method: convertStringToCharArray
            secondaryCharArray = convertStringToCharArray(secondaryString);
            
            // Decrypt the string with the key
            // Method: decryptString
            decryptedString = decryptString(secondaryIntArray, 
                  secondaryCharArray);
            
            // Display decrypted string to user
            // Method: displayStringWithLeader
            displayStringWithLeader("Decrypted String: ", decryptedString);
            
            // Display end program
            // Method: printString
            conIO.printString("End Program");
            
         }
      
      /*
      Name: charToInt
      Process: converts a character that is an integer to an integer
      Method Input/Parameters: character (char)
      Method Output/Parameters: none
      Method Output/Returned: converted integer (int)
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: none
      */
      private static int charToInt(char inChar)
         {
            // Delcare variables
            int integer, maxInt = 10;
            
            // Converts char to int
            integer = (int)( inChar - '0' );
            
            // Check if the converted integer is less than 10 (if < 10, it is an
            // int)
            if(integer < maxInt)
               {
                  // Return the converted integer
                  return integer;
               }
            
            // Returns default value if character was not an integer
            return 0;
         }
      
      /*
      Name: convertStringToIntArray
      Process: converts a given string of integers to an integer array
      Method Input/Parameters: string of integers (String)
      Method Output/Parameters: none
      Method Output/Returned: array of integers (int[])
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: none
      */
      private static int[] convertStringToIntArray(String string)
         {
            // Delcare variables
            int index, length, currentInt;
            char currentChar;
            int[] intArray;
            
            // Determine length of string
            length = string.length();
            
            // Set the capacity of the array to the length
            intArray = new int[length];
            
            // Loop through each character and convert it to an int
            for(index = 0; index < length; index++)
               {
                  // Determine the current character
                  currentChar = string.charAt(index);
                  // Convert the character to an int
                  currentInt = charToInt(currentChar);
                  // Add the converted value to the array
                  intArray[index] = currentInt;
               }
            
            // Return the integer array
            return intArray;
         }
      
      /*
      Name: convertStringToCharArray
      Process: converts a given string of characters to an character array
      Method Input/Parameters: string of characters (String)
      Method Output/Parameters: none
      Method Output/Returned: array of characters (char[])
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: none
      */
      private static char[] convertStringToCharArray(String string)
         {
            // Delcare variables
            int index, length;
            char currentChar;
            char[] charArray;
            
            // Find the length of the string
            length = string.length();
            
            // Set the capacity of the array to the length
            charArray = new char[length];
            
            // Loop through each character
            for(index = 0; index < length; index++)
               {
                  // Determine the current character
                  currentChar = string.charAt(index);
                  // Add the character to the array
                  charArray[index] = currentChar;
               }
            
            // Return the character array
            return charArray;
         }
      
      /*
      Name: encryptString
      Process: encrypts a given string using a given key
      Method Input/Parameters: string (char[]), encryption key (int[])
      Method Output/Parameters: none
      Method Output/Returned: encrypted string (char[])
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: none
      */
      private static char[] encryptString(int[] encryptKey, char[] string)
         {
            // Declare variables
            int stringLength, stringIndex, encryptKeyIndex = 0;
            int stringInt, encryptKeyLength;
            char currentChar;
            char[] encryptedString;
            
            // Determine length of string
            stringLength = string.length;
            // Determine length of key
            encryptKeyLength = encryptKey.length;
            
            // Set the capacity of the encrypted string to the string length
            encryptedString = new char[stringLength];
            
            // Loop through each value of the string to be encrypted
            for(stringIndex = 0; stringIndex < stringLength; stringIndex++)
               {
                  // Loop through the key until end, then start at 0 again
                  encryptKeyIndex = encryptKeyIndex % encryptKeyLength;
                  // Determine the current character
                  currentChar = string[stringIndex];
                  // Convert the character to its ASCII value
                  stringInt = (int) currentChar;
                  // Add the current key value to the ASCII value
                  encryptedString[stringIndex] = (char) (stringInt + 
                        encryptKey[encryptKeyIndex]);
                  // Increase the key index by 1
                  encryptKeyIndex++;
                  
               }
            
            // Return the encrypted string
            return encryptedString;
         }
      
      /*
      Name: decryptString
      Process: decrypts a given string using a given key
      Method Input/Parameters: string (char[]), encryption key (int[])
      Method Output/Parameters: none
      Method Output/Returned: decrypted string (char[])
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: none
      */
      private static char[] decryptString(int[] encryptKey, char[] string)
         {
            // Declare variables
            int stringLength, stringIndex, encryptKeyIndex = 0;
            int stringInt, encryptKeyLength;
            char currentChar;
            char[] decryptedString;
            
            // Determine length of string
            stringLength = string.length;
            // Determine length of key
            encryptKeyLength = encryptKey.length;
            
            // Set the capacity of the decrypted string to the string length
            decryptedString = new char[stringLength];
            
            // Loop through each value of the string to be decrypted
            for(stringIndex = 0; stringIndex < stringLength; stringIndex++)
               {
                  // Loop through the key until end, then start at 0 again
                  encryptKeyIndex = encryptKeyIndex % encryptKeyLength;
                  // Determine the current character
                  currentChar = string[stringIndex];
                  // Convert the character to its ASCII value
                  stringInt = (int) currentChar;
                  // Subtract the current key value from the ASCII value
                  decryptedString[stringIndex] = (char) (stringInt - 
                        encryptKey[encryptKeyIndex]);
                  // Increase the key index by 1
                  encryptKeyIndex++;
               }
            
            // Return the decrypted string
            return decryptedString;
         }
      
      /*
      Name: displayStringWithLeader
      Process: displays a leader string followed by the latter character array
      Method Input/Parameters: leader (String), latter array (char[])
      Method Output/Parameters: none
      Method Output/Returned: none
      Device Input/Keyboard: none
      Device Output/Monitor: displays string and array to screen
      Dependencies: console IO class tools
      */
      private static void displayStringWithLeader(String leader, char[] latter)
         {
            // Declare variables
            int index;
            
            // Display leader text
            // Methods: printEndline, printString
            conIO.printEndline();
            conIO.printString(leader);
            
            // Loop through each value of the latter array
            for(index = 0; index < latter.length; index++)
               {
                  // Print each character from the array
                  // Method: printChar
                  conIO.printChar(latter[index]);
               }
            
            // Print spacing
            // Method: printEndlines
            conIO.printEndlines(TWO_END_LINES);
         }
      
      
   }
