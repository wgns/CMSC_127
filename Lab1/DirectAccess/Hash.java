package Lab1.DirectAccess;

/**
 * Created by Wina Gen Sotto on January 26, 2017.
 */
public class Hash {
   public int hashCode(String s) {
      int hash = 7;

      for (int i = 0; i < s.length(); i++) {
         hash = (hash * 31 + s.charAt(i)) % 1000;
      }

      return hash;
   }
}
