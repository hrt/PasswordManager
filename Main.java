import java.io.Console;
import java.io.IOException;
import java.util.Random;
import java.awt.datatransfer.*;
import java.awt.Toolkit;


public class Main {

  private static final int PASSWORD_LENGTH = 18;

  private static Random rndKey;
  private static Random rndSite;

  public static void main(String[] args) throws IOException {
    Console br = System.console();

    /* Setting key based seed */
    String masterKey = new String(br.readPassword());
    long seed = stringToLong(masterKey);
    rndKey = new Random(seed);

    /* Setting site based seed */
    String website = args[0];
    long websiteNumber = stringToLong(website);
    rndSite = new Random(websiteNumber);

    /* Generating password */
    String pw = "";

    while (!meetsRequirments(pw)) {
      pw = "";
      while (pw.length() < PASSWORD_LENGTH) {
        pw += returnRandomChar(rndKey);
        pw += returnRandomChar(rndSite);
      }
    }

    StringSelection selection = new StringSelection(pw);
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    clipboard.setContents(selection, selection);

    br.readLine();
  }

  private static long stringToLong(String s) {
    long l = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      int z = c;
      if (c % 2 == 0) {
        l += z;
      } else {
        l -= z;
      }
    }
    return l;
  }

  private static char returnRandomChar(Random gen) {
    int r = gen.nextInt('a' - '0') + '0' + 1;
    while (!(r >= 'a' || (r <= 'Z' && r >= 'A') || (r <= '9' && r >= '0'))) {
      r = gen.nextInt('a' - '0') + '0' + 1;
    }
    return (char) r;
  }

  private static int countDigits(String pw) {
    int count = 0;
    for (int i = 0; i < pw.length(); i++) {
      if (Character.isDigit(pw.charAt(i)))
        count++;
    }
    return count;
  }

  private static int countAlphabetic(String pw) {
    int count = 0;
    for (int i = 0; i < pw.length(); i++) {
      if (Character.isAlphabetic(pw.charAt(i)))
        count++;
    }
    return count;
  }

  private static boolean meetsRequirments(String pw) {
    if (pw.length() < PASSWORD_LENGTH)
      return false;

    if (countDigits(pw) < (PASSWORD_LENGTH/3))
      return false;

    if (countAlphabetic(pw) < (PASSWORD_LENGTH/3))
      return false;

    return true;
  }
}
