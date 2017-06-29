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

  public static char getRandomChar(Random gen) {
    int r = gen.nextInt('a' - '0') + '0' + 1;
    while (!(r >= 'a' || (r <= 'Z' && r >= 'A') || (r <= '9' && r >= '0'))) {
      r = gen.nextInt('a' - '0') + '0' + 1;
    }
    return (char) r;
  }

  public static int countDigitsInString(String pw) {
    int count = 0;
    for (int i = 0; i < pw.length(); i++) {
      if (Character.isDigit(pw.charAt(i)))
        count++;
    }
    return count;
  }

  public static int countAlphabeticInString(String pw) {
    int count = 0;
    for (int i = 0; i < pw.length(); i++) {
      if (Character.isAlphabetic(pw.charAt(i)))
        count++;
    }
    return count;
  }

  public static boolean passwordMeetsRequirments(String pw) {
    if (pw.length() < passwordLength)
      return false;

    if (countDigitsInString(pw) < (passwordLength/3))
      return false;

    if (countAlphabeticInString(pw) < (passwordLength/3))
      return false;

    return true;
  }
}