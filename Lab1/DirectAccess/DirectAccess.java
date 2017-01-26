package Lab1.DirectAccess;

import java.io.*;

/**
 * Created by Wina Gen Sotto on January 26, 2017.
 */
public class DirectAccess {
   public static final String NAME_FILE = "/Users/winag/IdeaProjects/CMSC 127/src/Lab1/DirectAccess/directaccess_name.txt";
   public static final String HASH_FILE = "/Users/winag/IdeaProjects/CMSC 127/src/Lab1/DirectAccess/directaccess_hash.txt";

   public static void main(String[] args) {
      BufferedReader br = null;

      try {
         File file = new File(HASH_FILE);
         String current;

         if (!file.exists()) {
            file.createNewFile();
         }

         BufferedWriter bw = new BufferedWriter(new FileWriter(file));
         br = new BufferedReader(new FileReader(NAME_FILE));

         while ((current = br.readLine()) != null) {
            Hash h = new Hash();
            String hashCode = Integer.toString(h.hashCode(current));

            bw.write(hashCode);
            bw.newLine();
         }

         bw.close();
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
