import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        while (scanner.hasNext()) {
            int item = scanner.nextInt();
            if (item == 0) {
                break;
            }
            sum += item;
        }
        System.out.println(sum);
    }
}