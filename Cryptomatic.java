
/**
 * A program to encrypt and decrypt text using the Jean-Tailléfer & Pierre-Wacozyk algorithm.
 * 
 * @author Lars Flyger
 * @version 1/17/2016
 */

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class Cryptomatic
{
    public static void main(String[] args) throws IOException
    {
       int choice = 0;
       Scanner scan = new Scanner(System.in);
       
       while(choice != 4)
       {
           //print menu
           System.out.println("Select an option:");
           System.out.println("1: Encrypt a file with a given key.");
           System.out.println("2: Decrypt a file with a given key.");
           System.out.println("3: Decrypt a file with brute force, given a corresponding plaintext file.");
           System.out.println("4: Exit the program.");
           
           //read the integer input from the user
           choice = scan.nextInt();
           
           switch(choice)
           {
               case 1:
                   try
                   {
                       //read name of input file
                       String msg = "";
                       System.out.println("");
                       System.out.println("Enter the name of the file to encrypt: ");
                       String fileName = scan.nextLine();
                       File inFile = new File(fileName);
                       
                       //read key (consists of a 16-bit value, read as the value of two chars)
                       System.out.println("");
                       System.out.println("Enter the first character in the key.");
                       int k1 = scan.nextInt();
                       System.out.println("Enter the second character in the key.");
                       int k2 = scan.nextInt();
                       
                       //open stream of input file
                       InputStream in = new FileInputStream(inFile);
                       Reader fileRead = new InputStreamReader(in);
                       
                       //add buffer for efficiency
                       Reader buffer = new BufferedReader(fileRead);
                       
                       //create new buffered writer for writing file
                       FileWriter writer = new FileWriter("EncryptedFile.txt");
                       
                       //read characters from file
                       int r;
                       char c;
                       
                       int toggle = 0; //toggle between first and second char of key
                       while((r = buffer.read()) != -1)
                       {
                           if (toggle == 0)
                           {
                                //encrypt with bitwise or of plaintext character and 
                                //first character of key
                                c = (char)(r ^ k1);
                                msg = msg + Character.toString(c);
                                toggle = 1;
                           }
                           
                           if (toggle == 1)
                           {
                               //encrypt with bitwise or of plaintext character and 
                               //second character of key
                               c = (char)(r ^ k2);
                               msg = msg + Character.toString(c);
                               toggle = 0;
                           }
                       }
                       
                       //write encrypted string to outfile
                       writer.write(msg);
                       
                       //close io objects
                       writer.close();
                       buffer.close();
                       fileRead.close();
                       in.close();
                   }
                   
                   catch (IOException e)
                   {
                       
                   }
                   
                   break;
               case 2:
                   try
                   {
                       //read name of input file
                       String msg = "";
                       System.out.println("");
                       System.out.println("Enter the name of the file to encrypt: ");
                       String fileName = scan.nextLine();
                       File inFile = new File(fileName);
                           
                       //read key (consists of a 16-bit value, read as the value of two chars)
                       System.out.println("");
                       System.out.println("Enter the first character in the key.");
                       int k1 = scan.nextInt();
                       System.out.println("Enter the second character in the key.");
                       int k2 = scan.nextInt();
                            
                       //open stream of input file
                       InputStream in = new FileInputStream(inFile);
                       Reader fileRead = new InputStreamReader(in);
                           
                       //add buffer for efficiency
                       Reader buffer = new BufferedReader(fileRead);
                           
                       //create new buffered writer for writing file
                       FileWriter writer = new FileWriter("EncryptedFile.txt");
                           
                       //read characters from file
                       int r;
                       char c;
                           
                       int toggle = 0; //toggle between first and second char of key
                       while((r = buffer.read()) != -1)
                       {
                           if (toggle == 0)
                           {
                                //encrypt with bitwise or of plaintext character and 
                                //first character of key
                                c = (char)(r ^ k1);
                                msg = msg + Character.toString(c);
                                toggle = 1;
                           }
                           
                           if (toggle == 1)
                           {
                               //encrypt with bitwise or of plaintext character and 
                               //second character of key
                               c = (char)(r ^ k2);
                               msg = msg + Character.toString(c);
                               toggle = 0;
                           }
                       }
                           
                       //write encrypted string to outfile
                       writer.write(msg);
                           
                       //close io objects
                       writer.close();
                       buffer.close();
                       fileRead.close();
                       in.close();
                   }
                   
                   catch (IOException e)
                   {
                       
                   }
                   
                   break;
           
               //case 3:
           
               case 4:
                   return;
           
               default:
                   System.out.println("");
                   System.out.println("Invalid input.");
                   System.out.println("");
                   break;
           }
       }
       
       return;
    }
}
