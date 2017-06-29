import java.io.Console;
import java.io.IOException;
import java.util.Random;
import java.awt.datatransfer.*;
import java.awt.Toolkit;


public class Main {

  private static Random rndKey;
  private static Random rndSite;

  public static void main(String[] args) throws IOException {
    int passwordLength = 18;
    Util util = new Util(passwordLength);
    Console br = System.console();

    /* Setting key based seed */
    String masterKey = new String(br.readPassword());
    long seed = util.stringToLong(masterKey);
    rndKey = new Random(seed);

    /* Setting site based seed */
    String website = args[0];
    long websiteNumber = util.stringToLong(website);
    rndSite = new Random(websiteNumber);

    /* Generating password */
    String pw = "";

    while (!util.meetsRequirments(pw)) {
      pw = "";
      while (pw.length() < passwordLength) {
        pw += util.returnRandomChar(rndKey);
        pw += util.returnRandomChar(rndSite);
      }
    }

    StringSelection selection = new StringSelection(pw);
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    clipboard.setContents(selection, selection);

    br.readLine();
  }
}
