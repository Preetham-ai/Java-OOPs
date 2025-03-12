public class LargestInArray {
    public static void main(String[] args) {
        int[] numbers = {10, 45, 78, 23, 56, 89, 12};
        int max = numbers[0];

        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }

        System.out.println("Largest number: " + max);
    }
}
