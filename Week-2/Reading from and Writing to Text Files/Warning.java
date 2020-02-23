// ****************************************************************************
// Warning.java
//
// Reads student data from a text file and writes data to another text file.
// ****************************************************************************
import java.util.Scanner;
import java.io.*;

public class Warning{
    // --------------------------------------------------------------------
    // Reads student data (name, semester hours, quality points) from a
    // text file, computes the GPA, then writes data to another file
    // if the student is placed on academic warning.
    // --------------------------------------------------------------------
    public static void main (String[] args){
        
    int creditHrs; // number of semester hours earned
    double qualityPts; // number of quality points earned
    double gpa; // grade point (quality point) average
    String line, name, address,  inputName = "students.dat";
    String outputName = "warning.dat";
    File inputFile, outputFile;
    PrintWriter outFile;
    FileWriter fileWriter;
    
    address = "D:\\Tugas\\Semester 4\\Analisis dan Perancangan Perangkat Lunak\\Praktik\\File\\";
    
    try{
        // Set up scanner to input file
        inputFile = new File(address + inputName);
        Scanner input = new Scanner(inputFile);
        
        // Set up the output file stream
        fileWriter = new FileWriter(address + outputName);
        outFile = new PrintWriter(fileWriter);
        
        // Print a header to the output file
        outFile.println ("Students on Academic Warning\n");
        
        // Process the input file, one token at a time
        while (input.hasNext()){
            line = input.nextLine();
            name = line.split("\\s")[0];
            creditHrs =  Integer.parseInt(line.split("\\s")[1]);
            qualityPts = Double.parseDouble(line.split("\\s")[2]);
            
            gpa = qualityPts/creditHrs;
            
            if(gpa < 1.5 && creditHrs < 30){
                outFile.println(name + " " + Integer.toString(creditHrs) + " " + Double.toString(gpa));
            }
            else if(gpa < 1.75 && creditHrs < 60){
                outFile.println(name + " " + Integer.toString(creditHrs) + " " + Double.toString(gpa));
            }else if(gpa < 2){
                outFile.println(name + " " + Integer.toString(creditHrs) + " " + Double.toString(gpa));
            }
                    
        }
        outFile.close();
    }
    catch (FileNotFoundException exception){
        System.out.println ("The file " + inputName + " was not found.");
    }
    catch (IOException exception){
        System.out.println (exception);
    }
    catch (NumberFormatException e){
        System.out.println ("Format error in input file: " + e);
    }
    }
}
