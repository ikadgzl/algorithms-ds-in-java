package Recursion;

public class Recursion {

  // Fibonacci numbers ->
  public static int findFibonacci(int n) {
    if (n < 2) return 1;

    // 1 1 2 3 5 8 13 21..
    return findFibonacci(n - 1) + findFibonacci(n - 2);
  }

  // Find sum of digits of a positive number ->
  public static int sumOfDigits(int n) {
    if (n / 10 < 1) return n;

    // 544 - 54 - 4
    return n % 10 + sumOfDigits(n / 10);
  }

  // Find power of a number  ->
  public static int powerOfNumber(int n, int pow) {
    if (pow < 1) return 1;

    // 2^3 -> 2 * 2 * 2
    return n * powerOfNumber(n, pow - 1);
  }

  // Find factorial of a number -> {
  public static int factorialOfNumber(int n) {
    if (n < 1) return 1;

    // 3! = 3 * 2 * 1;
    return n * factorialOfNumber(n - 1);
  }

  // Find GCD of two numbers ->
  public static int findGDC(int n, int k) {
    if (n % k == 0) return k;

    // Use Euclidean algorithm for this problem.
    // 54|34 -> 54 = 34 * 1 + 20
    //       -> 34 = 20 * 1 + 14
    //       -> 20 = 14 * 1 + 6
    //       -> 14 = 6 * 2 + (2)
    //       -> 6 = 2 * 3 + 0, then 2 is the GDC.
    return findGDC(k, n % k);
  }

  // Find decimal-to-binary ->
  public static int decimalToBinary(int n) {
    if (n < 1) return n;

    // 13 to binary:
    // n/2 = quotient | remainder
    // 13 / 2 = 6 | 1
    // 6 / 2 = 3 | 0
    // 3 / 2 = 1 | 1
    // 1 / 2 = 0 | 1, then 1101 is the binary form of n.

    return (n % 2) + (10 * decimalToBinary(n / 2));
  }

  // Find product of array ->
  public static int productOfArray(int[] a, int n) {
    if (n < 1) return 1;

    return a[n - 1] * productOfArray(a, n - 1);
  }

  // Find recursive range ->
  public static int recursiveRange(int n) {
    if (n < 1) return n;

    return n + recursiveRange(n - 1);
  }

  // Reverse string using recursion ->
  public static String reverseString(String s) {
    if (s.isEmpty()) return s;

    // test -> est -> st -> t
    return reverseString(s.substring(1)) + s.charAt(0);
  }

  // Check if palindrome using recursion ->
  public static boolean isPalindrome(String s) {
    if(s.length() < 2) return true;

    if(s.charAt(0) == s.charAt(s.length() - 1)) {
      return isPalindrome(s.substring(1, s.length() - 1));
    }

    return false;
  }


}
