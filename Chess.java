import java.util.Scanner;

public class Chess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter board size: ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                if ((i + j) % 2 == 0)
                    System.out.print("* ");
                else
                    System.out.print(" ");
            System.out.println();
        }
    }
}
