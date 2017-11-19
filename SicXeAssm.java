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
    //File file = new File (args[0]);

      BufferedReader br = null;

       try{
       //Input from Command Line Argument
       //Scanner input = new Scanner (file);
       br = new BufferedReader(new FileReader(args[0]));

       String contentLine = br.readLine();

       while(contentLine != null){
            if(!contentLine.startsWith(".") || !contentLine.isEmpty()){ //FUTURE WORK: Disregard blank lines
              System.out.println(contentLine);
              contentLine = br.readLine();
            }
       }

       }//end try


       //Prints an error if the file is not found or is wrong
       catch(IOException exception){
           exception.printStackTrace();
             //System.out.println("Error reading the file \""  + br.getPath() + "\" ");
       }//end catch

       finally{
          try {
            if (br != null)
               br.close();
          }
          catch (IOException closeException) {
             System.out.println("Error in closing the BufferedReader");
          }

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

  static HashMap<String> directives = new HashMap<String, Integer>();
  static HashMap<String, Integer> registers = new HashMap<String, Integer>();
  static HashMap<String, Integer> instructions = new HashMap<String, Integer>();
  static HashMap<String, Integer> OPTABLE = new HashMap<String, Integer>();

  static{
    //Instructions
    instructions.put("ADD",      0x18);
    instructions.put("ADDF",     0x58);
    instructions.put("ADDR",     0x90);
    instructions.put("AND",      0x40);
    instructions.put("CLEAR",    0xB4);
    instructions.put("COMP",     0x28);
    instructions.put("COMPF",    0x88);
    instructions.put("COMPR",    0xA0);
    instructions.put("DIV",      0x24);
    instructions.put("DIVF",     0x64);
    instructions.put("DIVR",     0x9C);
    instructions.put("FIX",      0xC4);
    instructions.put("FLOAT",    0xC0);
    instructions.put("HIO",      0xF4);
    instructions.put("J",        0x3C);
    instructions.put("JEQ",      0x30);
    instructions.put("JGT",      0x34);
    instructions.put("JLT",      0x38);
    instructions.put("JSUB",     0x48);
    instructions.put("LDA",      0x00);
    instructions.put("LDB",      0x68);
    instructions.put("LDCH",     0x50);
    instructions.put("LDF",      0x70);
    instructions.put("LDL",      0x08);
    instructions.put("LDS",      0x6C);
    instructions.put("LDT",      0x74);
    instructions.put("LDX",      0x04);
    instructions.put("LPS",      0xD0);
    instructions.put("MUL",      0x20);
    instructions.put("MULF",     0x60);
    instructions.put("MULR",     0x98);
    instructions.put("NORM",     0xC8);
    instructions.put("OR",       0x44);
    instructions.put("RD",       0xD8);
    instructions.put("RMO",      0xAC);
    instructions.put("RSUB",     0x4C);
    instructions.put("SHIFTL",   0xA4);
    instructions.put("SHIFTR",   0xA8);
    instructions.put("SIO",      0xF0);
    instructions.put("SSK",      0xEC);
    instructions.put("STA",      0x0C);
    instructions.put("STB",      0x78);
    instructions.put("STCH",     0x54);
    instructions.put("STI",      0xD4);
    instructions.put("STL",      0x14);
    instructions.put("STS",      0x7C);
    instructions.put("STSW",     0xE8);
    instructions.put("STT",      0x84);
    instructions.put("STX",      0x10);
    instructions.put("SUB",      0x1C);
    instructions.put("SUBF",     0x5C);
    instructions.put("SUBR",     0x94);
    instructions.put("SVC",      0xB0);
    instructions.put("TD",       0xE0);
    instructions.put("TIO",      0xF8);
    instructions.put("TIX",      0x2C);
    instructions.put("TIXR",     0xB8);
    instructions.put("WD",       0xDC);

    //Registers
    registers.put("A", 0);
    registers.put("X", 1);
    registers.put("L", 2);
    registers.put("S", 4);
    registers.put("T", 5);
    registers.put("F", 6);
    //7 is probably the CC register
    registers.put("PC", 8);
    registers.put("SW", 9);

    //Directives
    directives.put("START");
    directives.put("END");
    directives.put("BASE");
    directives.put("NOBASE");
    directives.put("RESB");
    directives.put("RESW");
    directives.put("BYTE");
    directives.put("WORD");
    directives.put("ORG");
    directives.put("EXTREF");
    directives.put("EXTDEF");
    //Not implemented (Parser will recognize which are and aren't)
    directives.put("LTORG");
    directives.put("EQU");
    directives.put("CSECT");
    directives.put("USE");
  }


 }
