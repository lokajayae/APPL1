
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class mainFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean found = false;
        
        //Membuat scanner untuk input filename
        Scanner input = new Scanner(System.in);
        
        
        //Membaca file dalam try-catch
        Scanner in = null;
        while(!found){
            System.out.println("\nMasukkan Address File : ");
            String address = input.nextLine();
             File file = new File(address);
             
            try {
                in = new Scanner(file);
            } catch (FileNotFoundException e) {
                System.out.println("File Tidak dapat Ditemukan");
            } finally {
                if (in != null)
                    found = true;
            }
        }
        
        int linenum = 1;
        
        while(in.hasNext()){
            System.out.println("line " + linenum + " : " 
            + in.nextLine());
            linenum++;
        }
        
    }
    
}
