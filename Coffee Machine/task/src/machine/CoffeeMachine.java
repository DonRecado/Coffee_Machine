package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        Machine cMachine = new Machine();

        while (flag) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = scanner.nextLine();

            switch (action) {
                case "buy":
                    System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                    if (scanner.hasNextInt()) {
                        int type = scanner.nextInt();
                        cMachine.buy(type);
                    } else {
                        scanner.nextLine();
                        System.out.println();
                    }
                    break;
                case "fill":
                    System.out.println("\nWrite how many ml of water you want to add: ");
                    int water = scanner.nextInt();
                    System.out.println("Write how many ml of milk you want to add: ");
                    int milk = scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add: ");
                    int beans = scanner.nextInt();
                    System.out.println("Write how many disposable cups of coffee you want to add: ");
                    int cups = scanner.nextInt();

                    cMachine.fill(water, milk, beans, cups);
                    System.out.println();
                    break;
                case "take":
                    cMachine.take();
                    break;
                case "remaining":
                    System.out.println("\n" + cMachine);
                    break;
                case "exit":
                    flag = false;
                    break;

            }
        }
        scanner.close();


    }
}
