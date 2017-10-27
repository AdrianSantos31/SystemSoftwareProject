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
import java.lang.*;
import java.util.*;

public class SicXeAssm{
  public static void main(String[] args) throws FileNotFoundException, IOException{

      //File Class -  get the file using the command line argument
      File inputFile = new File (args[0]);

      //Reads the file - reads the file
      Scanner input = new Scanner(inputFile);

      //ArrayList Implementation
      ArrayList<String> stringArrList = new ArrayList<String>();
      ArrayList<String> emptyStringArrList = new ArrayList<String>();

      //Hashmap Implementations
      HashMap<String, String> TEST = new HashMap<String, String>();
      HashMap<String, Integer> OPTAB = new HashMap<String, Integer>();
      HashMap<String, Integer> SYMTAB = new HashMap<String, Integer>();

      while(input.hasNext()){
          String line = input.nextLine();

          System.out.println(line);//Test the input file - TEST ONLY

          if(!line.isEmpty()){
            String[] strArray = line.split("\\s+");

            for(int i = 0; i < strArray.length; i++){

              /*
                Use this in order to access the empty element
                  if(strArray[0].equals("")){
                    strArray.clear();
                  }else{
                  //Statement
                  }
              */
                System.out.println("[" + i + "] : "+ strArray[i]);//Test the input file - TEST ONLY

            }
            System.out.println("- - - - - \t - - - - - \t   E N D   \t - - - - - \t - - - - - ");//Test the input file - TEST ONLY
            stringArrList.add(line);

          }


      }

      System.out.println("");//Test the input file - TEST ONLY
      //Get the Array List Information - TEST ONLY
      System.out.println("The array list size is: " + stringArrList.size());



      /*

      This part is already working, enable after codes are working

        //File class - Create a file
        File outputFile1 = new File("test.lst");//lst file
        File outputFile2 = new File("test.obj");// obj file

        //Check if files are already existing
        if(outputFile1.exists() && outputFile2.exists()){
          System.out.println("The file is already done");
          System.exit(1);
        }

        try(
        //PrintWriter class - to write on the created file
        PrintWriter output1 = new PrintWriter(outputFile1);
        PrintWriter output2 = new PrintWriter(outputFile2);
        ){
        output1.println("Hello");
        output1.println("testing the file output");
        }


      */

      //Closes the input
      input.close();

      passOne();// - TEST ONLY
      passTwo();// - TEST ONLY

  }//end main method


  //passOne
  public static void passOne(){
    System.out.println("Testing passOne");
  }//end passOne

  //passTwo
  public static void passTwo(){
    System.out.println("Testing passTwo");
  }//end passTwo




}//end SicXeAssm.java

//Implemented Solutions - Keep for later possible use
  /*

  This part is already working, enable after codes are working

    //File class - Create a file
    File outputFile1 = new File("test.lst");//lst file
    File outputFile2 = new File("test.obj");// obj file

    //Check if files are already existing
    if(outputFile1.exists() && outputFile2.exists()){
      System.out.println("Files already exist");
      System.exit(1);
    }

    try(
    //PrintWriter class - to write on the created file
    PrintWriter output1 = new PrintWriter(outputFile1);
    PrintWriter output2 = new PrintWriter(outputFile2);
    ){
    output1.println("Hello");
    output1.println("testing the file output");
    }


  */

  /*

  Alternative method for file input

  try{
    Scanner input = new Scanner(file);

    //Reads all the input file
    while(inputFile.hasNextLine()){
      String line = input.nextLine();
      if(!line.isEmpty()){
        stringArrList.add(line);
        System.out.println(line);
      }
    }

    //Get the Array List Information
    System.out.println(stringArrList.size());

    //Closes the input
    inputFile.close();

    //Test the Methods
    passOne();
    passTwo();

    try(output1){
      output1.println("Test");
    }
  }


  //Prints an error if the file is not found / is wrong
  catch(FileNotFoundException exception){
        System.out.println("The file \""  + file.getPath() + "\" was not found.");
  }
  */
