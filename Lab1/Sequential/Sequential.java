package Lab1.Sequential;

import java.io.*;
import java.util.*;

/**
 * Created by Wina Gen Sotto on January 26, 2017.
 */
public class Sequential {
   public static final String FILE_NAME = "/Users/winag/IdeaProjects/CMSC 127/src/Lab1/Sequential/sequential.txt";

   public static void main(String[] args) {
      ArrayList<String> names = new ArrayList<>();
      BufferedReader br = null;

      try {
         String current;

         br = new BufferedReader(new FileReader(FILE_NAME));

         while ((current = br.readLine()) != null) {
            names.add(current);
         }

         names.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
               for (int i = 0; i < o1.length() && i < o2.length(); i++) {
                  if (o1.charAt(i) < o2.charAt(i)) {
                     return -1;
                  } else if (o1.charAt(i) > o2.charAt(i)) {
                     return 1;
                  }
               }

               return 0;
               //return (int) o1.charAt(0) < (int) o2.charAt(0) ? -1 : (int) o1.charAt(0) == (int) o2.charAt(0) ? 0 : 1;
            }
         });
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

      String newName = new String();

      while (true) {
         System.out.print("Enter a new name to be inserted to the file (enter 'e' to exit): ");
         Scanner sc = new Scanner(System.in);
         newName = sc.nextLine();

         if (newName.equals("e")) {
            break;
         }

         names.add(newName);
         names.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
               for (int i = 0; i < o1.length() && i < o2.length(); i++) {
                  if (o1.charAt(i) < o2.charAt(i)) {
                     return -1;
                  } else if (o1.charAt(i) > o2.charAt(i)) {
                     return 1;
                  }
               }

               return 0;
            }
         });

         try {
            File file = new File(FILE_NAME);

            BufferedWriter bw = new BufferedWriter(new FileWriter(file));

            for (int i = 0; i < names.size(); i++) {
               bw.write(names.get(i));
               bw.newLine();
            }

            bw.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }
}
