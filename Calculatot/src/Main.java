import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sc = scanner.nextLine();
        while (!sc.equals("exit")) {
            System.out.println(calc(sc));
            sc = scanner.nextLine();
        }
    }
    public static String calc (String input) {
        try {
            int a;
            int b;
            String sing;
            String[] symbol;
            symbol = input.split(" ");
            a = Integer.parseInt(symbol[0]);
            b = Integer.parseInt(symbol[2]);
            sing = symbol[1];
            if (!input.contains(" ")) {
                throw new IOException("Добавьте пробелы между операндами и операторами");
            }else if (symbol.length != 3) {
                    throw new IOException("throw IOException");
            } else if (a < 1) {
                throw new IOException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *); 1 > a/b > 10 ");
            } else if (a > 10) {
                throw new IOException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *); 1 > a/b > 10  ");
            } else if (b < 1) {
                throw new IOException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *); 1 > a/b > 10 ");
            } else if (b > 10) {
                throw new IOException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *); 1 > a/b > 10 ");
            } else if (!sing.matches("[*+-/]")) {
                throw new IOException("Cтрока не является математической операцией");
            }
            System.out.println(operation(a, b, sing));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return "---------------------";
    }

    static int operation ( int a, int b, String sing){
        return switch (sing) {
            case "*" -> a * b;
            case "+" -> a + b;
            case "-" -> a - b;
            case "/" -> a / b;
            default -> 0;
        };
    }
}


