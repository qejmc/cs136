package p11_package;


/**
 * Class uses linked list to encrypt text
 * 
 *
 *
 */

public class EncryptionClassDrei
   {
    /**
     * Constant for one digit offset in calculations
     */
    private final int ONE_DIGIT_OFFSET = 10;
   
    /**
     * Constant for two digit offset in calculations
     */
    private final int TWO_DIGIT_OFFSET = 100;
   
    /**
     * Constant for one digit offset in calculations
     */
    private final int THREE_DIGIT_OFFSET = 1000;
   
    /**
     * Constant for minimum random iterations in encryption
     */
    private final int MIN_ITERATIONS = 3;
   
    /**
     * Constant for maximum random iterations in encryption
     */
    private final int MAX_ITERATIONS = 5;
   
    /**
     * Constant for minimum three digit random number
     */
    private final int THREE_DIGIT_LOW = 100;
   
    /**
     * Constant for maximum three digit random number
     */
    private final int THREE_DIGIT_HIGH = 999;
   
    /**
     * Constant for minimum two digit random number
     */
    private final int TWO_DIGIT_LOW = 10;
   
    /**
     * Constant for maximum two digit random number
     */
    private final int TWO_DIGIT_HIGH = 99;
   
    /**
     * Constant for caret character
     */
    private final char CARET_CHAR = '^';
   
    /**
     * Head reference for linked list
     */
    private NodeClass headRef;
    
    /**
     * Default constructor
     * <p>
     * Sets head reference to null
     */
    EncryptionClassDrei()
       {
          // Set the headRef to null
          headRef = null;
       }
    
    /**
     * Initialization constructor
     * <p>
     * Accepts and encrypts String parameter
     * <p>
     * Dependencies: encryptString
     * 
     * @param toEncrypt String value to be encrypted
     */
    EncryptionClassDrei( String toEncrypt )
       {
          // Initalize the list with a random start value
             // Method: generateNineDigitRandom
          long randomStart = generateNineDigitRandom();
          
          // Set the headRef to a random long in order to initialize it with a
          // non-null value
          headRef = new NodeClass(randomStart);
          
          // Encrypt the string
             // Method: encryptString
          encryptString(toEncrypt);
       }
    
    /**
     * Copy constructor
     * <p>
     * Copies other linked list into this linked list, 
     * making duplicate with new data
     * <p>
     * Dependencies: NodeClass copy constructor
     * 
     * @param copied EncryptionClassDrei object with linked list to be copied
     */
    EncryptionClassDrei( EncryptionClassDrei copied )
       {
          // Declare variables
          NodeClass wkgRef;
          
          // Set the head ref to null
          this.headRef = null;
          
          // Check if the list is not empty
          if(copied.headRef != null)
             {
                // Set the current headRef to the copied headRef
                this.headRef = copied.headRef;
                
                // Initialize the working ref
                   // Method: NodeClass copy constructor
                wkgRef = new NodeClass(copied.headRef);
                      
                // Loop through the list
                while(wkgRef != null)
                   {
                      // Set the current ref equal to the next ref
                      wkgRef = wkgRef.nextRef;
                   }
             }
          
       }
   
    /**
     * appendItem
     * <p>
     * Adds item to end of list, uses helper method
     * <p>
     * Dependencies: appendItemHelper
     * 
     * @param newVal long value to be appended to list
     */
    public void appendItem( long newVal )
       {
          // Append the item to the end of the list
             // Method: appendItemHelper
          appendItemHelper(headRef, newVal);
       }
    
    /**
     * appendItemHelper
     * <p>
     * Recursively iterates to end of list, then adds node
     * <p>
     * Dependencies: NodeClass copy constructor
     * 
     * @param wkgRef NodeClass reference pointing to current node in recursion
     * 
     * @param newVal long value to be appended to list
     * 
     * @return NodeClass reference to most recent node in recursion
     */
    public NodeClass appendItemHelper( NodeClass wkgRef, long newVal )
       {
          // Declare and initialize variables
          NodeClass current = wkgRef;
          NodeClass newRef = new NodeClass(newVal);

          // Set the nextRef to null
          newRef.nextRef = null;

          // Check if wkgRef is null
          if(wkgRef == null)
             {
                // If so, set the wkgRef to the newRef
                wkgRef = newRef;
             }
          
          // Otherwise,
          else
             {
                // Loop through the references until it reaches the end
                while(current.nextRef != null)
                   {
                      // Set the reference to point to the "end + 1"
                      current = current.nextRef;
                   }

                // Set the next reference to the new reference
                current.nextRef = newRef;
             }
          
          // Return the wkgRef
          return wkgRef;
       }
    
    /**
     * decodeCharacter
     * <p>
     * Removes values encoded in long, reassembles and returns as character
     * <p>
     * Incoming character first digit is in the 7th position (000000x00, 
     * the second digit is in the fourth position (000x00000),
     * and the third digit is in the  first position (x00000000)
     * <p>
     * Dependencies: none
     * 
     * @param encodedLong long value holding encoded character value
     * 
     * @return value holding decoded character
     */
    public char decodeCharacter( long encodedLong )
       {
          // Declare variables
          long modifier, modifier2, modifier3;
          
          // Determine x in x00000000
          modifier = (encodedLong - encodedLong % (THREE_DIGIT_OFFSET * 
                THREE_DIGIT_OFFSET * TWO_DIGIT_OFFSET)) / (THREE_DIGIT_OFFSET * 
                      THREE_DIGIT_OFFSET * TWO_DIGIT_OFFSET);
          
          // Reduce to 0xx...
          encodedLong -= (THREE_DIGIT_OFFSET * THREE_DIGIT_OFFSET * 
                TWO_DIGIT_OFFSET) * modifier;
          
          // Reduce to 000xxx...
          encodedLong -= (encodedLong - encodedLong % (THREE_DIGIT_OFFSET * 
                THREE_DIGIT_OFFSET));
          
          // Determine y in 000y00000
          modifier2 = (encodedLong - encodedLong % (THREE_DIGIT_OFFSET * 
                TWO_DIGIT_OFFSET)) / (THREE_DIGIT_OFFSET * TWO_DIGIT_OFFSET);
          
          // Reduce to 00000xx...
          encodedLong -= (encodedLong - encodedLong % (THREE_DIGIT_OFFSET));
          
          // Determine z in 000000z00
          modifier3 = (encodedLong - encodedLong % TWO_DIGIT_OFFSET) / 
                TWO_DIGIT_OFFSET;
          
          // Determine zyx
          encodedLong = modifier  + (modifier2 * ONE_DIGIT_OFFSET) + 
                modifier3 * TWO_DIGIT_OFFSET;
          
          // Return the converted character of zyx 
          return (char) encodedLong;  // temporary stub return
       }
        
    /**
     * decryptList
     * <p>
     * Converts linked list of encoded integers into string
     * <p>
     * Dependencies: decodeCharacter
     * 
     * @param wkgRef NodeClass reference to uncloaked linked list
     * 
     * @return String result of processing
     */
    public String decryptList( NodeClass wkgRef )
       {
          // Declare and initialize variables
          String decrypted = "";
          
          // Loop through references
          while(wkgRef != null)
             {
                // Add the decoded character to the decrypted string
                   // Method: decodeCharacter
                decrypted += decodeCharacter(wkgRef.encryptedVal);
                
                // Set the wkgRef to the next ref
                wkgRef = wkgRef.nextRef;
             }
          
          // Return the decypted string
          return decrypted;
       }
   
    /**
     * displayEncryptedList (overloaded)
     * <p>
     * Displays THIS linked list as series of numbers with a specified width
     * 
     * @param width integer value specifying how many numbers on a line
     */
    public void displayEncryptedList( int width )
       {
          // Call displayEncryptedList with wkgRef being the headRef
             // Method: displayEncryptedList
          displayEncryptedList(headRef, width);
       }
    
       /**
     * displayEncryptedList (overloaded)
     * <p>
     * Displays USER PROVIDED linked list as series of numbers 
     * with a specified width
     * 
     * @param wkgRef NodeClass reference starting at head of list
     * 
     * @param width integer value specifying how many numbers on a line
     */
    public void displayEncryptedList( NodeClass wkgRef, int width )
       {
          // Declare and initialize variables
          int counter = 0;
          char currentChar = 0;
          
          // Print a new line
             // Method: println
          System.out.println();
          
          // Traverse through the LinkedList
          while(wkgRef != null)
             {
                // Increase the counter
                counter++;
                
                // Print the name and id at the wkgRef node 
                System.out.print(wkgRef.encryptedVal);
                
                // Determine the current character
                   // Method: decodeCharacter
                currentChar = decodeCharacter(wkgRef.encryptedVal);
                
                // Print the formatted character
                   // Method: format
                System.out.format("('%s') ", currentChar);
                
                // If the row reaches the width
                if(counter % width == 0) 
                   {
                      // Print a new line
                         // Method: println
                      System.out.println();
                   }
                
                // Go to next node
                wkgRef = wkgRef.nextRef;
                
             }
          
          // Print a new line
             // Method: println
          System.out.println();
       }
    
    /**
     * encodeCharacter
     * <p>
     * Sets three-digit character value into nine-digit long such that
     * the first digit is in the 7th position (000000x00), the second digit 
     * is in the fourth position (000x00000)and the third digit is in the 
     * first position (x00000000)
     * <p>
     * Dependencies: getRandBetween
     * 
     * @param encodeChar character value to be encoded
     * 
     * @return long value containing encoded character
     */
    public long encodeCharacter( char encodeChar )
       {
        // initialize method, variables
       
           // set the character to an integer
           int charInt = (int)encodeChar;
           
           // get the first/LSD digit
           int firstDigit = charInt % ONE_DIGIT_OFFSET;
           
           // declare other variables
           int thirdDigit, secondDigit;
           long resultLong;
        
        // divide off first digit
        charInt /= ONE_DIGIT_OFFSET;
        
        // capture second digit
        secondDigit = charInt % ONE_DIGIT_OFFSET;
        
        // divide off second digit
        charInt /= ONE_DIGIT_OFFSET;
        
        // capture third digit
        thirdDigit = charInt;
        
        // set first digit in long value
           // method: getRandBetween
        resultLong = firstDigit * TWO_DIGIT_OFFSET 
                              + getRandBetween( TWO_DIGIT_LOW, TWO_DIGIT_HIGH );
        
        // set second digit in long value
           // method: getRandBetween
        resultLong = secondDigit * TWO_DIGIT_OFFSET 
                        + getRandBetween( TWO_DIGIT_LOW, TWO_DIGIT_HIGH ) 
                                               + resultLong * THREE_DIGIT_OFFSET;
        
        // set third digit in long value
           // method: getRandBetween
        resultLong = thirdDigit * TWO_DIGIT_OFFSET
                        + getRandBetween( TWO_DIGIT_LOW, TWO_DIGIT_HIGH )
                                               + resultLong * THREE_DIGIT_OFFSET;
        // return long value
        return resultLong;
       }
    
    /**
     * encryptString
     * <p>
     * Generates random groups of values in linked list,
     * then places caret and next character,
     * repeats this process until end of string,
     * then adds one more random group
     * <p>
     * Each random group has a random number between 3 and 5 values
     * which are themselves random
     * <p>
     * Dependencies: .length, charAt, getRandBetween, generateNineDigitRandom,
     * encodeCharacer, appendItem
     * 
     * @param toEncrypt String value to be encrypted to linked list
     */
    public void encryptString( String toEncrypt )
       {
        // initialize method, variables
        int index = 0;
        int randIndex, numIterations;
        long nineDigitRand, charLongValue;
        char encodeChar;
        
        // loop to end of string
           // method: .length
        while( index < toEncrypt.length() )
           {
            // create number of random iterations
               // method: getRandBetween
            numIterations = getRandBetween( MIN_ITERATIONS, MAX_ITERATIONS );
            
            // loop across random iterations
            for( randIndex = 0; randIndex < numIterations; randIndex++ )
               {
                // create dummy number
                   // method: generateNineDigitRandom
                nineDigitRand = generateNineDigitRandom();
                
                // add item to linked list
                   // method: appendItem
                appendItem( nineDigitRand );
               }           
            // end loop
           
            // create value for caret
               // method: encodeCharacter
            charLongValue = encodeCharacter( CARET_CHAR );
            
            // add caret to linked list
               // method: appendItem
            appendItem( charLongValue );
            
            // get next character to encrypt
               // method: .charAt
            encodeChar = toEncrypt.charAt( index );
            
            // create value for new character
               // method: encodeCharacter
            charLongValue = encodeCharacter( encodeChar );
            
            // add item to linked list
               // method: appendItem
            appendItem( charLongValue );
            
            // increment loop index
            index++;
           }
        // end loop
        
        // add one more series of random values
        
           // create number of random iterations
              // method: getRandBetween
           numIterations = getRandBetween( MIN_ITERATIONS, MAX_ITERATIONS );
                
           // loop across random iterations
           for( randIndex = 0; randIndex < numIterations; randIndex++ )
              {
               // create new random value
                  // method: generateNineDigitRandom
               nineDigitRand = generateNineDigitRandom();
               
               // add value to linked list
                  // method: appendItem
               appendItem( nineDigitRand );
              }           
           // end loop
       }    
   
    /**
     * generateNineDigitRandom
     * <p>
     * Generates a nine digit random value for cloaking encrypted data
     * <p>
     * Dependencies: getRandBetween
     * 
     * @return nine digit random long
     */
    public long generateNineDigitRandom()
       {
          // Declare variables
          long random;
          
          // Get 3 random digits
             // Method: getRandBetween
          random = getRandBetween(THREE_DIGIT_LOW, THREE_DIGIT_HIGH);
          // Move digits to xxx000000
          random *= THREE_DIGIT_OFFSET * THREE_DIGIT_OFFSET;
          // Get 3 new random digits and move them to xxxyyy000
             // Method: getRandBetween
          random += getRandBetween(THREE_DIGIT_LOW, THREE_DIGIT_HIGH) * 
                THREE_DIGIT_OFFSET;
          // Get the last 3 random digits and add them creatign xxxyyyzzz
             // Method: getRandBetween
          random += getRandBetween(THREE_DIGIT_LOW, THREE_DIGIT_HIGH);
          
          // Return the randomly generated long
          return random;
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
        // initialize method, variables
       
           // create range value
           int range = high - low + 1;
   
        // find random within range, inclusive, return
           // method: Math.random
        return (int)( Math.random() * range + low );
       }
    
    /**
     * isCharacter
     * <p>
     * Returns Boolean true if node holds specified character,
     * false otherwise
     * <p>
     * Dependencies: decodeCharacter
     * 
     * @param testRef NodeClass reference to given node
     * 
     * @param testChar character value to be tested in node
     * 
     * @return Boolean result of specified test
     */
    public boolean isCharacter( NodeClass testRef, char testChar )
       {
          // Declare variables
          long encrypted;
          char decodedChar;
          
          // Determine the encrypted value
          encrypted = testRef.encryptedVal;
          
          // Decode the character and determine its value
             // Method: decodeCharacter
          decodedChar = decodeCharacter(encrypted);
          
          // Check if the decoded char is equal to the test char
          if(decodedChar == testChar)
             {
                // If so, return true
                return true;
             }
          
          // Otherwise, return false
          return false;
       }
    
    /**
     * uncloakList
     * <p>
     * Removes all random and caret nodes from linked list, 
     * linked list with encoded integers/characters remains
     * <p>
     * Dependencies: isCharacter
     * 
     * @return NodeClass reference to newly created linked list
     * containing only the encoded text letters
     */
    public NodeClass uncloakList()
       {
        // initialize method, variables
       
           // set working reference to head reference
           NodeClass wkgRef = headRef;
           
           // set other references to null
           NodeClass wkgResultRef = null, resultRef = null;
        
        // loop to end of linked list   
        while( wkgRef != null )
           {
            // search for caret
               // method: isCharacter
            while( wkgRef != null && !isCharacter( wkgRef, CARET_CHAR ) )
               {
                // skip ahead in linked list
                wkgRef = wkgRef.nextRef;               
               }
            
            // check for caret found (not null)
            if( wkgRef != null )
               {
                // skip over caret
                wkgRef = wkgRef.nextRef;
                
                // check for result reference null (empty)
                if( resultRef == null )
                   {
                    // set result reference to working reference
                    resultRef = wkgRef;
                    
                    // set a working result reference to the result reference
                    wkgResultRef = resultRef;
                   }
                
                // otherwise, assume result reference already has data
                else
                   {
                    // link the newest found character node
                    //   to the working result reference
                    wkgResultRef.nextRef = wkgRef;
                    
                    // advance the working result reference
                    wkgResultRef = wkgResultRef.nextRef;
                   }
               }
           }
        // end loop across linked list
        
        // set end for working result reference
        wkgResultRef.nextRef = null;
        
        // return result reference
        return resultRef;
       }
   }