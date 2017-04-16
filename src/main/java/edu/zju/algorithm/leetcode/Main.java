import java.util.Scanner;

/**
 * Created by admin on 2016/10/10.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int odds = 0;
        int evens = 0;
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            if (num % 2 == 0)
                evens++;
            else
                odds++;
        }
        System.out.println(Math.abs(evens-odds));
    }
}
