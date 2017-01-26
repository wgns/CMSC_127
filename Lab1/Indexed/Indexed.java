package Lab1.Indexed;

import java.io.*;
import java.util.*;

/**
 * Created by Wina Gen Sotto on January 26, 2017.
 */
public class Indexed {
   public static final String INDEX_FILE = "/Users/winag/IdeaProjects/CMSC 127/src/Lab1/Indexed/indexed_index.txt";
   public static final String DATA_FILE = "/Users/winag/IdeaProjects/CMSC 127/src/Lab1/Indexed/indexed_data.txt";

   public static void main(String[] args) {
      while (true) {
         System.out.print("Enter a name to be searched (enter 'e' to exit): ");
         Scanner sc = new Scanner(System.in);
         String name = sc.nextLine();
         int index = 0;

         if (name.equals("e")) {
            break;
         }

         BufferedReader br = null;

         try {
            String current;

            br = new BufferedReader(new FileReader(INDEX_FILE));

            while ((current = br.readLine()) != null) {
               if (current.charAt(0) == name.charAt(0)) {
                  index = Character.getNumericValue(current.charAt(2));
                  break;
               }
            }
         } catch (IOException e) {
            e.printStackTrace();
         } finally {
            try {
               if (br != null) {
                  br.close();
               }
            } catch (IOException ex) {
               ex.printStackTrace();
            }
         }

         try {
            String current;

            br = new BufferedReader(new FileReader(DATA_FILE));

            for (int i = 0; (current = br.readLine()) != null; i++) {
               if (i == index) {
                  if (current.equals(name)) {
                     System.out.println("Name found.\n");
                     break;
                  } else {
                     boolean found = false;

                     while ((current = br.readLine()) != null && current.charAt(0) == name.charAt(0)) {
                        if (current.equals(name)) {
                           System.out.println("Name found.\n");
                           found = true;
                           break;
                        }
                     }

                     if (!found) {
                        System.out.println("Name not found.\n");
                     }
                  }
               }
            }
         } catch (IOException e) {
            e.printStackTrace();
         } finally {
            try {
               if (br != null) {
                  br.close();
               }
            } catch (IOException ex) {
               ex.printStackTrace();
            }
         }
      }
   }
}
