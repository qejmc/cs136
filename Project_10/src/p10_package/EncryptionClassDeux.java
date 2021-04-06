package p10_package;

/**
 * Class encrypts, stores, and decrypts messages encoded and stored in an array 
 * of long integers
 * 
 *
 *
 */
public class EncryptionClassDeux
   {
    /**
     * Default string for generating default square array
     */
    private final String DEFAULT_STRING = "abcdefghijklmnopqrstuvwxyz";

    /**
     * Constant for decoding first three digits of long
     */
    private final int THREE_DIGIT_OFFSET = 1000;
  
    /**
     * Constant for decoding second three digits of long
     */
    private final int SIX_DIGIT_OFFSET = 1000000;

    /**
     * Constant for decoding third three digits of long
     */
    private final int NINE_DIGIT_OFFSET = 1000000000;

    /**
     * Constant for random index lower limit
     */
    private final int RAND_LOWER_LIMIT = 10;

    /**
     * Constant for random index upper limit
     */
    private final int RAND_UPPER_LIMIT = 99;

    /**
     * Constant for minimum string size
     */
    private final int MIN_STRING_LENGTH = 15;

    /**
     * Constant indicating high end of unused codes
     */
    private final int UNUSED_CODE_HIGH = 9;
    
    /**
     * Constant indicating low end of unused codes
     */
    private final int UNUSED_CODE_LOW = 2;
    
    /**
     * Constant indicating used code
     */
    private final int USED_CODE = 1;

    /**
     * Enumerated constant indicating control code for both number and character
     */
    public static final int ENUM_BOTH = 1001;
    
    /**
     * Enumerated constant indicating control code for character only
     */
    public static final int ENUM_CHARACTER_ONLY = 2002;
    
    /**
     * Enumerated constant indicating control code for number only
     */
    public static final int ENUM_NUMBER_ONLY = 3003;
    
    /**
     * Constant representing caret character
     */
    private final char CARET_CHAR = '^';
    
    /**
     * Constant representing caret character
     */
    private final char RIGHT_CURLY_BRACE_CHAR = '}';
    
    /**
     * Constant representing space character
     */
    private final char SPACE_CHAR = ' ';
    
    /**
     * Constant representing tilde character
     */
    private final char TILDE_CHAR = '~';
    
    /**
     * data array
     */
    private long array[][];
    
    /**
     * side capacity for square array
     */
    private int sideCapacity;
    
    /**
     * Default constructor
     * <p>
     * Creates an array with DEFAULT_STRING "abcdefghijklmnopqrstuvwxyz", 
     * sets all the elements in it to random characters,
     * and sets sideCapacity value
     * <p>
     * Dependencies: createArray
     */
    EncryptionClassDeux()
       {
        array = createArray( DEFAULT_STRING );
       }
    
    /**
     * Initialization constructor 
     * <p>
     * Captures and encrypts string, encodes, encrypts, and stores in array,
     * sets sideCapacity
     * <p>
     * Dependencies: encryptString
     * 
     * @param toEncrypt String object holding data to be encrypted
     * 
     */
    EncryptionClassDeux( String toEncrypt )
       {
        encryptString( toEncrypt );
       }
    
    /**
     * Copy constructor 
     * <p>
     * Dependencies: None
     * <p>
     * Copies other object into this object, including sideCapacity,
     * and individual array elements
     * 
     * @param copied EncryptionClassDeux object to be copied into this object
     * 
     */
    EncryptionClassDeux( EncryptionClassDeux copied )
       {
          // Declare variables
          int rowIndex, colIndex;
          
          // Set sideCapacties equal to eachother
          this.sideCapacity = copied.sideCapacity;
          
          // Loop through the array via rows
          for(rowIndex = 0; rowIndex < this.sideCapacity; rowIndex++)
             {
                // Loop through the array via columns
                for(colIndex = 0; colIndex < this.sideCapacity; colIndex++)
                   {
                      // Set each value equal to eachother
                      copied.array[rowIndex][colIndex] = 
                            this.array[rowIndex][colIndex];
                   }
             }
       }
    
    /**
     * Create array
     * <p>
     * Finds length of string to be encrypted; 
     * if string is less than MIN_STRING_LENGTH, 
     * length is set to MIN_STRING_LENGTH;
     * either way string length is then doubled
     * <p>
     * Finds the square root of the updated string length and sets side 
     * capacity; 
     * creates local array, then calls fillArray which sets all the elements 
     * in the array to random characters other than tilde ('~')
     * <p>
     * Returns local array to calling method
     * <p>
     * Dependencies: Math.length, Math.sqrt, fillArray
     * 
     * @param setUpString string used to find and process string length
     * 
     * @return array [][] of long values
     */
    private long [][] createArray( String setUpString )
       {
           int strLen = setUpString.length();        
           long [][] tempArr;
           
           if( strLen < MIN_STRING_LENGTH )
              {
                 strLen = MIN_STRING_LENGTH; 
              }
           
           // double length of string
           strLen *= 2;
           
           sideCapacity = (int)( Math.sqrt( strLen ) );
           
           tempArr = new long[ sideCapacity ][ sideCapacity ];
           
           tempArr = fillArray( tempArr );
                   
           return tempArr;
       }
    
    /**
     * displayArray
     * <p>
     * Depending on control code, array is displayed one of three ways: 
     * NUMBER_ONLY: displays array of long values; CHARACTER_ONLY: displays
     * encoded characters; BOTH: displays both numbers and characters
     * <p>
     * Uses System.out.format
     * <p>
     * Dependencies: System.out.println, System.out.format, getCharValue
     * 
     * @param ctrlCode integer control code to indicate kind of display
     */
    public void displayArray( int ctrlCode )
       {
          // Delare variables
          int rowIndex, colIndex;
          long encoded;
          boolean displayNumber, displayChar;
          char currentChar;
          
          // Initialize variables
          displayNumber = false;
          displayChar = false;
          
          // Print title
          // Method: println
          System.out.println("Array Display:");
          
          // Determine which data to display
          switch(ctrlCode)
             {
                // If number only, displayNumber is true
                case ENUM_NUMBER_ONLY:
                   displayNumber = true;
                   break;
                   
                // If char only, displayChar is true
                case ENUM_CHARACTER_ONLY:
                   displayChar = true;
                   break;
                   
                // If both, displayNumber and displayChar is true
                case ENUM_BOTH:
                   displayNumber = true;
                   displayChar = true;
                   break;
             }
          
          // Loop through the array
          for(rowIndex = 0; rowIndex < this.sideCapacity; rowIndex++)
             {
                // Loop through each column
                for(colIndex = 0; colIndex < this.sideCapacity; colIndex++)
                   {
                      // Print out spacing
                      // Method: format
                      System.out.format("%s%s", SPACE_CHAR, SPACE_CHAR);
                      
                      // Determine the current encoded long
                      encoded = array[rowIndex][colIndex];
                      
                      // If displayNumber
                      if(displayNumber)
                         {
                            // Print out the encoded long
                            // Method: format
                            System.out.format("%d", encoded);
                         }
                      
                      // If displayChar
                      if(displayChar)
                         {
                            // Get the converted character
                            currentChar = getCharValue(encoded);
                            
                            // Print out the character
                            // Methods: format, getCharValue
                            System.out.format("%s%s%s", "('", currentChar, 
                                  "')");
                         }
                      
                   }
                
                // Print new line after each row
                // Method: println
                System.out.println();
             }

       }
    
    /**
     * decryptArray
     * <p>
     * Finds the tilde in the array, and tracks the elements of the array
     * to set the individual character values back into a String; 
     * list of characters ends with a caret ('^')
     * <p>
     * Dependencies: findTilde, getNextXPos, getNextYPos, getCharValue
     * 
     * @return String value containing decrypted text
     */
    public String decryptString()
       {
          // Declare and initialize variables
          String decrypted = "";
          long current;
          int xPos, yPos;
          char charValue = ' ';
          
          // Initialize the current encoded value to the tilde value
          current = findTilde();
          
          // Loop through each encoded value until reaching ^
          while(charValue != CARET_CHAR)
             {
                // Find the current x and y pos
                // Methods: getNextXPos, getNextYPos
                xPos = getNextXPos(current);
                yPos = getNextYPos(current);
                
                // Find the current encoded value
                current = array[xPos][yPos];
                
                // Find the current char value
                // Method: getCharValue
                charValue = getCharValue(current);
                
                // Check if the current char is ~ or ^, if not then
                if((charValue != TILDE_CHAR) && (charValue != CARET_CHAR))
                   {
                      // Add the character to the decrypted string
                      decrypted += charValue;
                   }
             }
          
          // Return the decrypted string
          return decrypted;
       }
    
    /**
     * elementIsUsed
     * <p>
     * Returns true if element is used in the array, or if the current y 
     * position
     * is equal to the next y position and the current x position is equal to
     * the next x position
     * <p>
     * Dependencies: None
     * 
     * @param curYPos integer current y position to be tested
     * 
     * @param curXPos integer current x position to be tested
     * 
     * @param nextYPos integer next y position to be tested
     * 
     * @param nextXPos integer next x position to be tested
     * 
     * @return Boolean value indicating state of specified testing
     */
    private boolean elementIsUsed( int curYPos, 
                                       int curXPos, int nextYPos, int nextXPos )
       {
          // Declare and initialize variables
          boolean isUsed = false;
          long encoded, modifier;
          
          // Find the next encoded value
          encoded = array[nextYPos][nextXPos];
          
          // Determine the modifier on the value
          modifier = (encoded - encoded % NINE_DIGIT_OFFSET) / 
                NINE_DIGIT_OFFSET;
          
          // Check if the value is used
          if(modifier == USED_CODE)
             {
                // If so, the element is used
                isUsed = true;
             }
          
          // Otherwise, check if the current x and y pos are equal to the next
          // x and y position
          else if((curXPos == nextXPos) && (curYPos == nextYPos))
             {
                // If so, the element is used
                isUsed = true;
             }
   
          // Return the boolean value
          return isUsed;
       }

    /**
     * encodeData
     * <p>
     * Encodes four parts of data into long value as ucccyyyxxx
     * where u is the used flag
     * ccc is the character Unicode/ASCII value
     * yyy is the y position of an element
     * xxx is the x position of an element
     * <p>
     * Dependencies: None
     * 
     * @param used integer value indicating that the value is part 
     * of the encrypted string, which is encoded into the long value
     * 
     * @param dataChar character value encoded into the long value
     * 
     * @param yPos integer value encoded into the long value
     * 
     * @param xPos integer value encoded into the long value
     * 
     * @return long value containing encoded data
     */
    public long encodeData( int used, char dataChar, int yPos, int xPos )
       {
          // Declare and initialize variables
          // Start with the value 1000 and multiply is by the modifier code
          long encoded = THREE_DIGIT_OFFSET * used;
          
          // Add the dataChar
          encoded += (int) dataChar;
          
          // Increase the value to Uccc000
          encoded *= THREE_DIGIT_OFFSET;
          
          // Add the yPos
          encoded += yPos;
          
          // Increase the value to Ucccyyy000
          encoded *= THREE_DIGIT_OFFSET;
   
          // Add the xPos and return the value
          return encoded + xPos;
       }
    
   /**
     * encryptString
     * <p>
     * Creates array using the input string which also fills array with random 
     * characters, then places characters randomly around the array starting 
     * with a tilde ('~') and ending with a caret ('^')
     * <p>
     * Each long value in the array holds a used marker, the character,
     * and the y and x position of the next character
     * <p>
     * Process generates a new random y, x pair for each character data element
     * but verifies that the y, x pair has not already been used; once these
     * are found, the long value is encoded with the used marker, the character,
     * and the next y, x positions, and placed into the array
     * <p>
     * Dependencies: {String}.length, {String}.charAt, createArray, 
     * getRandBetween, encodeData, elementIsUsed
     * 
     * @param toEncrypt String value to be encrypted
     */
    public void encryptString( String toEncrypt )
       {
        long encodeVal;
        int currentYPos, currentXPos;
        int nextYPos, nextXPos;        
        int strIndex, strLen;
        char postChar = TILDE_CHAR;

        toEncrypt += CARET_CHAR;
        
        strLen = toEncrypt.length();
        
        array = createArray( toEncrypt );

        currentYPos = getRandBetween( 0, sideCapacity - 1 );
        currentXPos = getRandBetween( 0, sideCapacity - 1 );

        for( strIndex = 0; strIndex < strLen; strIndex++ )
           {
            do
               {
                nextYPos = getRandBetween( 0, sideCapacity - 1 );
                
                nextXPos = getRandBetween( 0, sideCapacity - 1 );
                
                encodeVal = encodeData( USED_CODE, 
                                               postChar, nextYPos, nextXPos );
               }
            while( elementIsUsed( currentYPos, 
                                            currentXPos, nextYPos, nextXPos ) );
            
            array[ currentYPos ][ currentXPos ] = encodeVal;
            
            currentYPos = nextYPos;
            
            currentXPos = nextXPos;
            
            postChar = toEncrypt.charAt( strIndex );
           }
        
        encodeVal = encodeData( USED_CODE, postChar, currentYPos, currentXPos );
        
        array[ currentYPos ][ currentXPos ] = encodeVal;
       }
    
    /**
     * fillArray
     * <p>
     * Fills temporary array with a random value between UNUSED_CODE_LOW and 
     * UNUSED_CODE_HIGH, a random character other than tilde ('~'), and a 
     * randomly generated y and x location between RAND_LOWER_LIMIT and
     * RAND_UPPER_LIMIT 
     * <p>
     * Dependencies: getRandBetween, getRandomChar, encodeData
     * 
     * @param arrayToFill long [][] array to be filled with random data
     * 
     * @return long [][] array with specified random values
     */
    public long [][] fillArray( long [][] arrayToFill )
       {
          // Declare variables
          int xPos, yPos, rowIndex, colIndex, used;
          char dataChar;
          
          // Loop through each row
          for(rowIndex = 0; rowIndex < this.sideCapacity; rowIndex++)
             {
                // Loop through each column
                for(colIndex = 0; colIndex < this.sideCapacity; colIndex++)
                   {
                      // Set a random used modifer between the bounds
                      // Method: getRandBetween
                      used = getRandBetween(UNUSED_CODE_LOW, UNUSED_CODE_HIGH);
                      
                      // Get a random character
                      // Method: getRandomChar
                      dataChar = getRandomChar();
                      
                      // Set a random x pos
                      // Method: getRandBetween
                      xPos = getRandBetween(RAND_LOWER_LIMIT, RAND_UPPER_LIMIT);
                      
                      // Set a random y pos
                      // Method: getRandBetween
                      yPos = getRandBetween(RAND_LOWER_LIMIT, RAND_UPPER_LIMIT);
                      
                      // Fill the current position in the array with the
                      // randomly generated encoded long
                      // Method: encodeData
                      arrayToFill[rowIndex][colIndex] = encodeData(used, 
                            dataChar, yPos, xPos);
                   }
             }
          
          // Return the array
          return arrayToFill;  // temporary stub return
       }
    
    /**
     * findTilde
     * <p>
     * Finds tilde encoded in two dimensional array of long values
     * <p>
     * Dependencies: getCharValue, encodeData
     * 
     * @return long encoded value containing UNUSED_CODE_LOW, TILDE_CHAR,
     * and the y and x locations of the TILDE_CHAR
     */
    private long findTilde()
       {
           // Declare and initialize variables
           int rowIndex, colIndex;
           long value, encoded = 0;
           
           // Loop through each row
           for(rowIndex = 0; rowIndex < this.sideCapacity; rowIndex++)
              {
                 // Loop through each column
                 for(colIndex = 0; colIndex < this.sideCapacity; colIndex++)
                    {
                       // Find the current value
                       value = array[rowIndex][colIndex];
                       
                       // Check if the tilde is equal to the char value
                       // Method: getCharValue
                       if(TILDE_CHAR == getCharValue(value))
                          {
                             // If so, set the value equal to the corresponding
                             // encoded value
                             // Method: encodeData
                             encoded = encodeData(UNUSED_CODE_LOW, TILDE_CHAR, 
                                   rowIndex, colIndex);
                          }
                    }
              }
   
           // Return the encoded value
           return encoded;
       }
    
    /**
     * getCharValue
     * <p>
     * decodes long integer to return character
     * <p>
     * Dependencies: None
     * 
     * @param encoded long value with encoded character to retrieve
     * 
     * @return character retrieved
     */
    private char getCharValue( long encoded )
       {
          // Declare variables
          char encodedChar;
          
          // Find the value
          encoded -= (encoded - encoded % NINE_DIGIT_OFFSET);
          
          // Find the character ASCII value
          encoded = (int) encoded / SIX_DIGIT_OFFSET;
          
          // Find the corresponding char
          encodedChar = (char) encoded;
          
          // Return the character
          return encodedChar;  // temporary stub return
       }
    
    /**
     * getRandBetween
     * <p>
     * Returns random value between low and high parameters, inclusive
     * <p>
     * Dependencies: Math.random
     * 
     * @param low integer value indicating low end of random range to generate
     * 
     * @param high integer value indicating high end of random range to generate
     * 
     * @return random value between low and high parameters, inclusive
     */
    public int getRandBetween( int low, int high )
       {
        int range = high - low + 1;
        
        return (int)( Math.random() * range + low );
       }

    /**
     * getRandomChar
     * <p>
     * Returns a Unicode/ASCII character from space (lowest printable character)
     * to right curly brace (highest printable character before tilde); 
     * tilde ('~') is never returned
     * <p>
     * Dependencies: getRandBetween
     * 
     * @return value containing random character
     */
    private char getRandomChar()
       {
        int randomVal;
        
        randomVal = getRandBetween( (int)SPACE_CHAR, 
                                                  (int)RIGHT_CURLY_BRACE_CHAR );
        
        return (char)randomVal;
       }
    
    /**
     * getNextXPos
     * <p>
     * Returns the next x position from the encoded value
     * <p>
     * Dependencies: None
     * 
     * @param encoded long value with encoded x location to retrieve
     * 
     * @return int x location retrieved
     */
    private int getNextXPos( long encoded )
       {
          // Reduce long to 0cccyyyxxx
          encoded -= (encoded - encoded % NINE_DIGIT_OFFSET);
          
          // Reduce long to 0000yyyxxx
          encoded -= (encoded - encoded % SIX_DIGIT_OFFSET);
          
          // Reduce long to 0000000xxx
          encoded /= THREE_DIGIT_OFFSET;
          
          // Return the xpos
          return (int) encoded;  // temporary stub return
       }

   /**
     * getNextYPos
     * <p>
     * Returns the y position from the encoded value
     * <p>
     * Dependencies: None
     * 
     * @param encoded long value with encoded y location to retrieve
     * 
     * @return int y location retrieved
     */
    private int getNextYPos( long encoded )
       {
          // Reduce long to 0cccyyyxxx
          encoded -= (encoded - encoded % NINE_DIGIT_OFFSET);
          
          // Reduce long to 0000yyyxxx
          encoded -=  (encoded - encoded % SIX_DIGIT_OFFSET);
          
          // Reduce long to 0000yyy000
          encoded -=  (encoded - encoded % THREE_DIGIT_OFFSET);
          
          // Return the yPos
          return (int) encoded;  // temporary stub return
       }

   }