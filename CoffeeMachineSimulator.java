import java.util.Scanner;

public class CoffeeMachineSimulator {
    private static int water = 0;
    private static int milk = 0;
    private static int coffeeBeans = 0;
    private static int money = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Coffee Machine Simulator ===");
            System.out.println("Available options: buy, fill, take, show, exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "buy":
                    buyCoffee(scanner);
                    break;
                case "fill":
                    fillIngredients(scanner);
                    break;
                case "take":
                    takeMoney();
                    break;
                case "show":
                    showIngredients();
                    break;
                case "exit":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void buyCoffee(Scanner scanner) {
        System.out.println("\nAvailable coffees:");
        System.out.println("1. Espresso ($4) - water: 250ml, milk: 0ml, coffee beans: 16g");
        System.out.println("2. Latte ($7) - water: 350ml, milk: 75ml, coffee beans: 20g");
        System.out.println("3. Cappuccino ($6) - water: 200ml, milk: 100ml, coffee beans: 12g");
        System.out.print("Enter the number of the coffee you want to buy: ");
        int coffeeChoice = scanner.nextInt();
        scanner.nextLine();

        int waterNeeded = 0;
        int milkNeeded = 0;
        int coffeeBeansNeeded = 0;
        int price = 0;

        switch (coffeeChoice) {
            case 1:
                waterNeeded = 250;
                coffeeBeansNeeded = 16;
                price = 4;
                break;
            case 2:
                waterNeeded = 350;
                milkNeeded = 75;
                coffeeBeansNeeded = 20;
                price = 7;
                break;
            case 3:
                waterNeeded = 200;
                milkNeeded = 100;
                coffeeBeansNeeded = 12;
                price = 6;
                break;
            default:
                System.out.println("Invalid coffee choice!");
                return;
        }

        if (water >= waterNeeded && milk >= milkNeeded && coffeeBeans >= coffeeBeansNeeded) {
            System.out.println("Dispensing coffee...");
            water -= waterNeeded;
            milk -= milkNeeded;
            coffeeBeans -= coffeeBeansNeeded;
            money += price;
            System.out.println("Enjoy your coffee!");
        } else {
            System.out.println("Insufficient ingredients! Cannot dispense coffee.");
        }
    }

    private static void fillIngredients(Scanner scanner) {
        System.out.print("\nEnter the amount of water to add (in ml): ");
        int waterToAdd = scanner.nextInt();
        System.out.print("Enter the amount of milk to add (in ml): ");
        int milkToAdd = scanner.nextInt();
        System.out.print("Enter the amount of coffee beans to add (in g): ");
        int coffeeBeansToAdd = scanner.nextInt();

        water += waterToAdd;
        milk += milkToAdd;
        coffeeBeans += coffeeBeansToAdd;
        System.out.println("Ingredients added successfully!");
    }

    private static void takeMoney() {
        System.out.println("\nTaking money: $" + money);
        money = 0;
    }

    private static void showIngredients() {
        System.out.println("\nCurrent ingredients:");
        System.out.println("Water: " + water + "ml");
        System.out.println("Milk: " + milk + "ml");
        System.out.println("Coffee Beans: " + coffeeBeans + "g");
        System.out.println("Money: $" + money);
    }
}
