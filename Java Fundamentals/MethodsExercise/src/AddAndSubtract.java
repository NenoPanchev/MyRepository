import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());
        int c = Integer.parseInt(scan.nextLine());
        System.out.println(resultABminusC(a,b,c));
    }
    static int sumOfAB(int a, int b) {
        return a+b;
    }
    static int resultABminusC(int a, int b, int c) {
        return sumOfAB(a,b) - c;
    }
}
