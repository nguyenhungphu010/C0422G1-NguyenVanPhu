package ss11_DSA_Stack_Queue.bai_tap.bai_3_decimal_to_binary;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class ConvertDecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Decimal number: ");
        int decimalNumb = Integer.parseInt(scanner.nextLine());
        Stack<Integer> stack = new Stack<>();
        int[] array;
        int binaryNummb;
        while (decimalNumb > 0){
            stack.push(decimalNumb%2);
            decimalNumb = decimalNumb/2;
        }
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            System.out.println(stack.pop());
        }
    }
}
