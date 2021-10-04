/**
 * This program finds the unique FQDNs and 2LDs in a file, the file
 * is a command line argument.
 *
 * Useage:
 *   java ProcessFQDN2 -[c|t|s] names.txt results.txt
 *
 * @author Nirre Pluf {@literal }
 * @version 0.2, Oct. 3, 2021
 */

import java.io.*;
import java.util.Scanner;


public class ProcessFQDN2 {
   /**
    * main method, where the magic starts...
    
    * @param args String[], -[c|t|s] names.txt results.txt
    */
    public static void main(String[] args) {
        List<NameCount> uniqueHost = null;  // unique hostnames
        List<NameCount> unique2LD = null;   // unique 2LD names
        List<NameCount> uniqueTLD = null;   // unique TLD names
        int numFQDN;                        // number of FQDNs
        
        if(!argsOK(args))
            System.exit(1);

        /* use the list specified by the user... */
        if(args[0].equals("-t")) {
            uniqueHost = new TNCLinkedList();
            unique2LD = new TNCLinkedList();
            uniqueTLD = new TNCLinkedList();
        }  
        else if(args[0].equals("-c")) {
            uniqueHost = new CNCLinkedList();
            unique2LD = new CNCLinkedList();
            uniqueTLD = new CNCLinkedList();
        }
        else {
            uniqueHost = new NCLinkedList();
            unique2LD = new NCLinkedList();
            uniqueTLD = new NCLinkedList();
        }
        
        final long startTime = System.currentTimeMillis();
        numFQDN = readNameFile(args[1], uniqueHost, unique2LD, uniqueTLD);
        displayNameInfo(args[2], numFQDN, uniqueHost, unique2LD, uniqueTLD);
        final long endTime = System.currentTimeMillis();

        /* just subtract the two times */
        long difference = endTime - startTime;
        System.out.println("Time to complete: " + difference + " msec");
    }
    
    /* a lot more code here, hear? */


    /**
     *  This method reads (and eventually stores) FQDN and 2LD in the fqdn file
     *
     *  @param  filename is the fqdn filename (command line argument)
     */
    static int readNameFile(String fileName, List<NameCount> uniqueHost, List<NameCount> unique2LD,
                            List<NameCount> uniqueTLD) {
        int numFQDN = 0;  

        return numFQDN;  
    }


    /**
     *  This method displays the stats and FQDN and 2LD found in the file
     *
     *  @param  the lists...
     */
    static void displayNameInfo(String filename, int numFQDN, List<NameCount> uniqueHost, List<NameCount> unique2LD,
                                List<NameCount> uniqueTLD) {

    }

    /**
     *  This method returns true if the command line arguments are acceptable,
     *
     *  @param  args list of Strings (command line arguments)
     *  @return true if the arguments are acceptable, false otherwise
     */
     private static boolean argsOK(String[] args) {
         if(args.length < 3) {
             System.out.println("Usage: java program -[c|t|s] input_name_file output_name_file ");
             System.out.println("  -[c|t|s]          management (count, transpose, simple) ");
             System.out.println("  input_name_file   file containing hostnames ");
             System.out.println("  output_name_file  file to write unique FQDNs, 2LDs, and TLDs ");
             return false;
         }
         return true;
     }

}
