import java.io.IOException;
import java.util.Random;

public class Test {

  private static Random rndKey;
  private static Random rndSite;

  public static void main(String[] args) throws IOException {
    int passwordLength = 18;
    Util util = new Util(18);

    boolean allPassed = true;
    allPassed &= stringToLongTest(util);
    allPassed &= getRandomCharTest(util);
    allPassed &= countDigitsInStringTest(util);
    allPassed &= countAlphabeticInStringTest(util);
    allPassed &= passwordMeetsRequirmentsTest(util);

    if (allPassed)
      System.out.println("All tests passed..");
    else
      System.out.println("Tests failed..");
  }


  private static boolean stringToLongTest(Util util) {
    long l = util.stringToLong("HelloWorld!");
    return l == 167;
  }

  private static boolean getRandomCharTest(Util util) {
    long seed = 4l;
    Random rnd = new Random(seed);
    boolean allPassed = true;

    allPassed &= util.getRandomChar(rnd) == 'V';
    allPassed &= util.getRandomChar(rnd) == 'V';
    allPassed &= util.getRandomChar(rnd) == 'H';

    return allPassed;
  }

  private static boolean countDigitsInStringTest(Util util) {
    int countAlpha = util.countDigitsInString("asdasd");
    int countEmpty = util.countDigitsInString("");
    int countUnique = util.countDigitsInString("1a2a3a4;a5a6");
    int countDuplicate = util.countDigitsInString("4848474");

    boolean allPassed = true;

    allPassed &= countAlpha == 0;
    allPassed &= countEmpty == 0;
    allPassed &= countUnique == 6;
    allPassed &= countDuplicate == 7;

    return allPassed;
  }

  private static boolean countAlphabeticInStringTest(Util util) {
    int countDigits = util.countAlphabeticInString("51523531");
    int countEmpty = util.countAlphabeticInString("");
    int countUnique = util.countAlphabeticInString("k2l34f;");
    int countDuplicate = util.countAlphabeticInString("kkk");

    boolean allPassed = true;

    allPassed &= countDigits == 0;
    allPassed &= countEmpty == 0;
    allPassed &= countUnique == 3;
    allPassed &= countDuplicate == 3;

    return allPassed;
  }

  private static boolean passwordMeetsRequirmentsTest(Util util) {
    boolean allPassed = true;

    String correctPassword = "Za1BTQLT7Z518J9SEY";
    allPassed &= util.passwordMeetsRequirments(correctPassword);

    String shortPassword = "1234abcd";
    allPassed &= !util.passwordMeetsRequirments(shortPassword);

    String noDigitsPassword = "asedgdsgsgsdgsdgsdgsdgsdasdas";
    allPassed &= !util.passwordMeetsRequirments(noDigitsPassword);

    String noAlphaPassword = "1251253252642643763475751";
    allPassed &= !util.passwordMeetsRequirments(noAlphaPassword);

    return allPassed;
  }
}