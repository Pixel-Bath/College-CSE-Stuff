// Kevin
// CSE 174
// Lab 3.2: File Converter
// 02-11-22

// This file will read 4 numbers from a given file and scale these numbers 
// from a given "scale value."
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileConverter {
  public static void main(String[] args) throws FileNotFoundException {
    
    // Prompt a file name and a scale value & save the values
    Scanner ip = new Scanner(System.in);
    System.out.print("Please enter the name of your input file: ");
    String fileName = ip.next();
    System.out.print("Please enter a double to use as your scaling value: ");
    double scaleValue = ip.nextDouble();
    
    Scanner in = new Scanner(new File(fileName));
    
    // Read the integer values in the given file
    int fileNumOne = in.nextInt();
    int fileNumTwo = in.nextInt();
    int fileNumThree = in.nextInt();
    int fileNumFour = in.nextInt();
    
    // Scale the numbers by the given scale value
    double scaleNumOne = fileNumOne * scaleValue;
    double scaleNumTwo = fileNumTwo * scaleValue;
    double scaleNumThree = fileNumThree * scaleValue;
    double scaleNumFour = fileNumFour * scaleValue;
    
    // print scaled values
    System.out.printf("%10.3f", scaleNumOne);
    System.out.println("");
    System.out.printf("%10.3f", scaleNumTwo);
    System.out.println("");
    System.out.printf("%10.3f", scaleNumThree);
    System.out.println("");
    System.out.printf("%10.3f", scaleNumFour);
    System.out.println("");
  }
} // end class
  
    
    
    
