/*
This is the project for System Software.
Members:
Sotiri Kolvani
Adrian Santos - N00798593
Ahmed Sehic


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
import java.lang.*;
import java.util.*;

public class SicXeAssm{
  public static void main(String[] args) throws FileNotFoundException{

    //Reads the File from the command Line argument
    File file = new File (args[0]);
    Scanner input = new Scanner (file);

    //Reads all the input file
    while(input.hasNextLine()){
      String line = input.nextLine();
      System.out.println(line);
    }

    //Closes the input
    input.close();

  }
}
