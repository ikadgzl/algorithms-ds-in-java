package Arrays;

public class Arrays {

  public static void findMissing() {
    int intArray[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100};

    int sum1 = 0;
    int sum2 = 0;

    for (int i : intArray) {
      sum1 += i;
    }

    sum2 = (100 * 101) / 2;

    int difference = sum2 - sum1;

    System.out.format("Missing number is: %d", difference);
  }

  public static void findSumPairs() {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    int target = 17;

    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] + arr[j] == target) {
          System.out.printf("%d + %d = %d \n", arr[i], arr[j], target);
        }
      }
    }
  }

  public static void findNumberInArray(int n) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == n) {
        System.out.printf("The number %d is at index of %d", n, i);
      }
    }
  }

  public static void findMaxProductPairs() {
    int[] arr = {10, 60, 30, 40, 50};

    int maxProduct = 0;
    String maxProductPairs = "";

    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] * arr[j] > maxProduct) {
          maxProduct = arr[i] * arr[j];
          maxProductPairs = String.format("%d, %d", arr[i], arr[j]);
        }
      }
    }

    System.out.println(maxProductPairs);
  }

  public static boolean isUnique() {
    int[] arr = {10, 60, 30, 40, 50, 10};

    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] == arr[j]) {
          return false;
        }
      }
    }

    return true;
  }

  // Check if given two arrays are same without using sort or hash, set etc..
  public static boolean isPermutation() {
    int[] arr1 = {1, 2, 3, 4, 5, 6};
    int[] arr2 = {5, 4, 3, 2, 1, 6};

    if (arr1.length != arr2.length) return false;

    int sum1 = 0, sum2 = 0;
    int mul1 = 1, mul2 = 1;

    for (int i = 0; i < arr1.length; i++) {
      sum1 += arr1[i];
      mul1 *= arr1[i];
      sum2 += arr2[i];
      mul2 *= arr2[i];
    }

    if (sum1 == sum2 && mul1 == mul2) return true;

    return false;
  }

  public static int[][] rotateMatrixBy90() {
    int[][] matrix = {{1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}};
    int size = matrix.length;

    int temp = 0;
    for (int i = 0; i < size; i++) {
      for (int j = i; j < size; j++) {
        temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size / 2; j++) {
        temp = matrix[i][j];
        matrix[i][j] = matrix[i][size - 1 - j];
        matrix[i][size - 1 - j] = temp;
      }
    }

    return matrix;
  }

  public static int[][] rotateMatrixBy90V2() {
    int[][] matrix = {{1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}
    };
    int size = matrix.length;

    int temp = 0;
    for (int i = 0; i < size / 2; i++) {
      for (int j = i; j < size - i - 1; j++) {
        temp = matrix[i][j];

        matrix[i][j] = matrix[size - j - 1][i];
        matrix[size - j - 1][i] = matrix[size - i - 1][size - j - 1];
        matrix[size - i - 1][size - j - 1] = matrix[j][size - i - 1];
        matrix[j][size - i - 1] = temp;
      }
    }

    return matrix;
  }
}
