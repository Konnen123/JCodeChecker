package Test;

import java.util.LinkedList;
import java.util.List;

public class Test {
    public int[] sumOfNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return new int[10];
    }

    private static boolean isPrime(int number) {
        if (number <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    protected void countEvenOddDigits(int number) {
        int evenCount = 0;
        int oddCount = 0;
        while (number > 0) {
            int digit = number % 10;
            if (digit % 2 == 0)
                evenCount++;
            else
                oddCount++;
            number /= 10;
        }
    }

    public String reverseString(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }

    public boolean isPalindrome(String str) {
        String reversed = reverseString(str);
        return str.equals(reversed);
    }

    public int findMax(int[] arr) {
        if (arr.length == 0)
            throw new IllegalArgumentException("Array is empty");
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    private boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        int[] count = new int[256];
        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i)]++;
            count[str2.charAt(i)]--;
        }
        for (int c : count) {
            if (c != 0)
                return false;
        }
        return true;
    }

    private static void fibonacci(int n) {
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int temp = a;
            a = b;
            b = temp + b;
        }
    }

    static int generateRandomNumber(int min, int max) {
        if (min >= max)
            throw new IllegalArgumentException("Invalid range");
        return (int) (Math.random() * (max - min + 1)) + min;
    }
    private List<Character> getChars()
    {
        List<Character> characters = new LinkedList<>();
        for(int i=0;i<9;i++)
        {
            characters.add((char)('0' + i));
        }
        return characters;
    }

    public String dayOfWeek(int day) {
        String dayName;
        switch (day) {
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thursday";
                break;
            case 5:
                dayName = "Friday";
                break;
            case 6:
                dayName = "Saturday";
                break;
            case 7:
                dayName = "Sunday";
                break;
            default:
                dayName = "Invalid day";
                break;
        }
        return dayName;
    }
}
