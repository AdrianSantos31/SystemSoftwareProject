/*
This is the project for System Software.
Members:
Sotiri Kolvani - N00845431
Adrian Santos - N00798593
Ahmed Sehic - n00969861

Instructions

1  What is required?
  DONE - 1. You must submit exactly one source file SicXeAssm.java.
  DONE - 2. Include the names of the group members at the top of the program file.
  DONE - 3. The program must accept the name of the input source file as a command-line argument. It must report an error message if the file is not found.
  4. The program must work accurately with PC relative and base relative modes. Clearly, you need to implement the BASE directive in your program. Also take care about various instruction formats.
  5. There must be two methods named passOne and passTwo which does their respective tasks. Feel free to use as many auxiliary methods as you wish.
  6. The program must be able to handle any number of whitespaces or tabs inthe input source code.
  7. The data structures OPTAB and SYMTAB must be implemented as hashtables. Do not use any other names.
  8. Do not change the name of the LOCCTR variable.
  9. The program must generate two files: the listing file having.lst extension and the object program having.obj extension.
  10. Strictly follow the format of the object program mentioned in the book. Any slight deviation may result in a test failure.
  11. The program should be able do common types of error-checks such as incorrect spelling of a mnemonic, label not defined,
  inability to assemble becausedisplacement is out of range etc.
  12. Comment your JAVA program appropriately to ensure readability and un-derstandability.

2.) What is NOT Required?
1. Implementation of theEQU, USE, CSECT directives. In case you do not implement these, your program should report to the user in the.lst file that it cannot handle these with the corresponding line numbers.
2. You are not required to implement literals, floating point instructions and division instructions. In case you do not implement these, your program should report to the user in the.lstfile that it cannot handle these withthe corresponding line numbers.
3. Implementation of HIO, LPS, SSK, STI, STSW, SVC, SIO, TIO instructions. In case you do not implement these, your program should report in the.lstfile that it cannot handle these with the corresponding line numbers.
*/

//Library Imports
import java.io.*;
import java.util.*;
import java.lang.*;


public class SicXeAssm{
  public static void main(String[] args){
    //Read the file from command line argument
     File file = new File (args[0]);

       try{
       //Input from Command Line Argument
       Scanner input = new Scanner (file);

       //Read all lines
       while(input.hasNextLine()){
         String line = input.nextLine();


         if(!line.startsWith(".")){ //FUTURE WORK: Disregard blank lines
           System.out.println(line);
         }

         else if(input.nextLine()) {
           string = str.replace("\\s","").trim();
         } //end if



       }//end while

         //Closes the file
         input.close();
       }//end try


       //Prints an error if the file is not found or is wrong
       catch(IOException exception){
             System.out.println("Error reading the file \""  + file.getPath() + "\" ");
       }//end catch

       finally{

       }//end finally
  }//end main
}//end SicXeAssm class

//Format class
/*
enum Format{
  FORMAT1,
  FORMAT2R,
  FORMAT2N,
  FORMAT2RR,
  FORMAT2RN,
  FORMATN34,
  FORMAT34M
}
*/

class Global{

  public static final Hashtable<String,Integer> OPTABLE = new Hashtable<String,Integer>() {{
      put("ADD",      0x18);
      put("ADDF",     0x58);
      put("ADDR",     0x90);
      put("AND",      0x40);
      put("CLEAR",    0xB4);
      put("COMP",     0x28);
      put("COMPF",    0x88);
      put("COMPR",    0xA0);
      put("DIV",      0x24);
      put("DIVF",     0x64);
      put("DIVR",     0x9C);
      put("FIX",      0xC4);
      put("FLOAT",    0xC0);
      put("HIO",      0xF4);
      put("J",        0x3C);
      put("JEQ",      0x30);
      put("JGT",      0x34);
      put("JLT",      0x38);
      put("JSUB",     0x48);
      put("LDA",      0x00);
      put("LDB",      0x68);
      put("LDCH",     0x50);
      put("LDF",      0x70);
      put("LDL",      0x08);
      put("LDS",      0x6C);
      put("LDT",      0x74);
      put("LDX",      0x04);
      put("LPS",      0xD0);
      put("MUL",      0x20);
      put("MULF",     0x60);
      put("MULR",     0x98);
      put("NORM",     0xC8);
      put("OR",       0x44);
      put("RD",       0xD8);
      put("RMO",      0xAC);
      put("RSUB",     0x4C);
      put("SHIFTL",   0xA4);
      put("SHIFTR",   0xA8);
      put("SIO",      0xF0);
      put("SSK",      0xEC);
      put("STA",      0x0C);
      put("STB",      0x78);
      put("STCH",     0x54);
      put("STI",      0xD4);
      put("STL",      0x14);
      put("STS",      0x7C);
      put("STSW",     0xE8);
      put("STT",      0x84);
      put("STX",      0x10);
      put("SUB",      0x1C);
      put("SUBF",     0x5C);
      put("SUBR",     0x94);
      put("SVC",      0xB0);
      put("TD",       0xE0);
      put("TIO",      0xF8);
      put("TIX",      0x2C);
      put("TIXR",     0xB8);
      put("WD",       0xDC);

   }};


   Enumeration showOpTable;
   String str;

   showOpTable = OPTABLE.keys();

   while(showOpTable.hasMoreElements()) {
   str = (String) showOpTable.nextElement();
   System.out.println(str + ": " + OPTABLE.get(str));
  }

 }
