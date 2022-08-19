import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter key: ");
        int key = sc.nextInt();

        CaesarCipher cc = new CaesarCipher(key);
        System.out.println(cc.encrypt("Hello"));
        System.out.println(cc.decrypt("Mjqqt"));
        bruteForce("");
    }
}
