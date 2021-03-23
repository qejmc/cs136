package p9_package;

public class BinaryAdderClass
   {
      private final int BASE_TWO = 2;
      private final int DEFAULT_CAPACITY = 50;
      private final char SPACE = ' ';
      
      private int[] bitArray;
      private int numBits;
      
      public BinaryAdderClass()
         {
            this.bitArray = new int[DEFAULT_CAPACITY];
            this.numBits = 0;
         }
      
      public BinaryAdderClass(int decimalValue)
         {
            this.bitArray = convertToBinary(decimalValue);
         }
      
      public BinaryAdderClass(BinaryAdderClass copied)
         {
            int index;
            
            this.numBits = copied.numBits;
            bitArray = new int[DEFAULT_CAPACITY];
            
            for(index = 0; index < DEFAULT_CAPACITY; index++)
               {
                  this.bitArray[index] = copied.bitArray[index];
               }
         }
      
      public void addValue(int decimalValue)
         {
            BinaryAdderClass addend = new BinaryAdderClass(decimalValue);
            addValue(addend);
         }
      
      public void addValue(BinaryAdderClass addend)
         {
            //this.bitArray = addend.bitArray;
            int index, resultBit, carry;

            carry = 0;
            
            for(index = 0; index < DEFAULT_CAPACITY; index++)
               {
                  resultBit = carry + this.bitArray[index] + 
                        addend.bitArray[index];
                  
                  switch(resultBit)
                     {
                        case 0:
                           this.bitArray[index] = 0;
                           carry = 0;
                           break;
                        case 1:
                           this.bitArray[index] = 1;
                           carry = 0;
                           break;
                        case 2:
                           this.bitArray[index] = 0;
                           carry = 1;
                           break;
                        case 3:
                           this.bitArray[index] = 1;
                           carry = 1;
                           break;
                     }
               }
            
         }
      
      private int[] convertToBinary(int decimalValue)
         {
            int counter, index, bit;
            int [] bits;
            
            counter = decimalValue;
            
            bits = new int[DEFAULT_CAPACITY];
            
            for(index = 0; index < DEFAULT_CAPACITY; index++)
               {
                  bit = counter % BASE_TWO;
                  bits[index] = bit;
                  
                  counter /= BASE_TWO;
               }
            
            return bits;
            
         }
      
      public void displayBits(int blockSize)
         {
            int counter, currentBit, whiteSpace, index;
            
            counter = DEFAULT_CAPACITY - 1;
            currentBit = 0;
            
            while(currentBit != 1)
               {
                  currentBit = bitArray[counter];
                  counter--;
               }
            
            numBits = counter + 1;
            
            whiteSpace = blockSize - numBits;
            
            displayChars(whiteSpace - 1, SPACE);
            
            for(index = numBits; index >= 0; index--)
               {
                  System.out.print(bitArray[index]);
               }
            
            System.out.print("\n");
            
         }
      
      public void displayChars(int numChars, char outChar)
         {
            int index;
            
            for(index = 0; index < numChars; index++)
               {
                  System.out.print(outChar);
               }
            
            //System.out.print("\n");
         }
      
      //TODO: Implement somewhere?
      private int findMax(int valOne, int valOther)
         {
            if(valOne <= valOther)
               {
                  return valOther;
               }
            
            return valOne;
         }
      
      @Override
      public java.lang.String toString()
         {
            int index;
            
            String tempString = "";
            
            for(index = 0; index <= numBits; index++)
               {
                  tempString += bitArray[index];
               }
            
            return tempString;
         }
   }
