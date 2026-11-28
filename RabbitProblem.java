import java.util.Scanner;

public class RabbitProblem {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int first = 0;
        int second = 1;
        int next;

        System.out.print("Enter number of months: ");
        int months = input.nextInt();

        System.out.println("Rabbit pairs:");

        for (int i = 1; i <= months; i++) {
            System.out.println("Month " + i + ": " + second);

            next = first + second;
            first = second;
            second = next;
        }

        input.close();
    }
}
