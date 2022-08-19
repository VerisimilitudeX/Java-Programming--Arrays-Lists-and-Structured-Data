import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter key: ");
        int key = sc.nextInt();
        sc.close();

        CaesarCipher cc = new CaesarCipher(key);
        System.out.println(cc.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?"));
        System.out.println(cc.decrypt("Mjqqt"));
        cc.bruteForce("");
    }
}
