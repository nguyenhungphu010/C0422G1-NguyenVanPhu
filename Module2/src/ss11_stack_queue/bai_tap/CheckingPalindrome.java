package ss11_DSA_Stack_Queue.bai_tap.bai_4_checking_palindrome;

import java.util.*;

public class CheckingPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the String that need to check: ");
        String string = scanner.nextLine();
        String string2 = string.toUpperCase();

        // tao array chuoi
        String[] array = string2.split("");
        // tao Dequeue 1:
        Deque<String> strings1 = new ArrayDeque<>();
        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals(" ")) {
                strings1.addFirst(array[i]);
            }
        }

        // tao Dequeue 2;
        Deque<String> strings2 = new ArrayDeque<>();
        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals(" ")) {
                strings2.addLast(array[i]);
            }
        }

        String paragraph1;
        String paragraph2;
        boolean isFlag = true;
        int size = strings2.size();
        for (int i = 0; i < size; i++) {
            paragraph1 = strings1.pollFirst();
            paragraph2 = strings2.pollFirst();
            if (!paragraph1.equals(paragraph2)) {
                isFlag = false;
            }
        }
        if (isFlag) {
            System.out.println("Palindrome");
        } else {
            System.out.println("not Palindrome ");
        }
    }
}
