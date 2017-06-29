import java.util.Random;

public final class Util {

  public static int passwordLength;

  public Util(int pwLength) {
    passwordLength = pwLength;
  }

  public static long stringToLong(String s) {
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

  public static char returnRandomChar(Random gen) {
    int r = gen.nextInt('a' - '0') + '0' + 1;
    while (!(r >= 'a' || (r <= 'Z' && r >= 'A') || (r <= '9' && r >= '0'))) {
      r = gen.nextInt('a' - '0') + '0' + 1;
    }
    return (char) r;
  }

  public static int countDigits(String pw) {
    int count = 0;
    for (int i = 0; i < pw.length(); i++) {
      if (Character.isDigit(pw.charAt(i)))
        count++;
    }
    return count;
  }

  public static int countAlphabetic(String pw) {
    int count = 0;
    for (int i = 0; i < pw.length(); i++) {
      if (Character.isAlphabetic(pw.charAt(i)))
        count++;
    }
    return count;
  }

  public static boolean meetsRequirments(String pw) {
    if (pw.length() < passwordLength)
      return false;

    if (countDigits(pw) < (passwordLength/3))
      return false;

    if (countAlphabetic(pw) < (passwordLength/3))
      return false;

    return true;
  }
}