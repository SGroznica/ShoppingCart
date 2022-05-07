package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UI {

    Cart cart = new Cart();
    private int ch = 0;

    private String commandString = "";

    private Product product;
    private List<Product> products;
    public UI () {
        products = new ArrayList<>();
        menu();
    }

    public void startScreen () {
        System.out.println("******************************");
        System.out.println("*************Store************");
        System.out.println("******************************");
        System.out.println();
        System.out.println("1. Add Store Products");
        System.out.println("2. Display Store Products");
        System.out.println("3. Display Cart");
        System.out.println("0. Exit");
    }

    public void storeProductsMenu() {
        System.out.println("1. Add to Cart");
        System.out.println("2. Remove From Cart");
        System.out.println("3. Checkout");
        System.out.println("0. Exit");
    }

    public void menu () {
        do {
            startScreen();
            getUserInput();

            switch (ch) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    displayStoreProducts();
                    System.out.println();
                    System.out.println("prije store");
                    storeProductsMenu();
                    System.out.println("poslije store");
                    ch = getUserInput();
                    System.out.println("poslije input");
                    innerChoice1();
                    System.out.println("poslije choice");
                    break;
                case 3:
                    showCart();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:

                    break;
            }
        } while (ch != 0);
    }

    public void menu_string () {
        do {
            startScreen();
            getCommand();
            String[] command = new String[] {};
            command = commandString.split(" ");
            /*
            * commnand[0] = "ADD"
            * commnand[1] = "1"
            * commnand[2] = "T-Shirt"
            * commnand[3] = "3"
            * commnand[4] = "5.99"
            * */
            /*
            * command = commandString.split(" ", 2);
            /*
            * commnand[0] = "ADD"
            * commnand[1] = "1 T-Shirt 3 5.99"
            * */

            switch (command[0]) {
                case "ADD":
                    //addProduct(command);
                    addProduct();
                case "DISPLAY":
                    displayStoreProducts();
                    System.out.println();
                    storeProductsMenu();
                    getUserInput();
                    innerChoice1();
                    break;
                case "CART":
                    showCart();
                    break;
                case "EXIT":
                    System.exit(0);
                    break;
                default:

                    break;
            }
        } while (commandString != "END");
    }

    private String getCommand()  {
        Scanner in = new Scanner (System.in);
        commandString = (in.nextLine());
        System.out.println(commandString);
        return commandString;
    }

    private void addProduct() {
        Product p = new Product();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Add item to inventory, \n INPUT: sku(number) name(string) quantity(number) price(number); e.g. ADD 1 T-Shirt 3 5.99");

        String add = scanner.nextLine();
        System.out.println(add);

        String[] result = new String[]{};
        result = add.split(" ");

        p.setSku(Integer.valueOf(result[0]));
        p.setName(result[1]);
        p.setQuantity(Integer.valueOf(result[2]));
        p.setPrice(Double.valueOf(result[3]));
        products.add(p);

        System.out.println(products);



        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
        System.out.println(result[3]);

        //menu();
    }
    /*
        private void addProduct(parametar) {
        Product p = new Product();
        //Scanner scanner = new Scanner(System.in);

        System.out.println("Add item to inventory, \n INPUT: sku(number) name(string) quantity(number) price(number); e.g. ADD 1 T-Shirt 3 5.99");

        //String add = scanner.nextLine();
        //System.out.println(add);

        String[] result = new String[]{};
        parametar = add.split(" ");

        p.setSku(Integer.valueOf(result[0]));
        p.setName(result[1]);
        p.setQuantity(Integer.valueOf(result[2]));
        p.setPrice(Double.valueOf(result[3]));

        System.out.println(products);

        products.add(p);



        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
        System.out.println(result[3]);

        menu();
    }
    * */

    private void innerChoice1() {
        System.out.println("u choiceu");
        System.out.println(ch);
        switch (ch) {
            case 1:
                System.out.println("case 1");
                addProductToCart();
                showCart();
                break;
            case 2:
                removeProductFromCart();
                break;
            default:

                break;
        }
    }

    private int getUserInput()  {
        Scanner in = new Scanner (System.in);
        ch = Integer.parseInt(in.nextLine());
        System.out.println("input utipkan");
        return ch;
    }

    private void displayStoreProducts() {
        //List<Product> products = new Inventory().getProducts();
        for (Product prod: products) {
            System.out.println(
                    prod.getSku() + "- " +
                            prod.getName() + " " +
                            prod.getQuantity() + " " +
                            prod.getPrice()
            );
        }
    }

    private void addProductToCart() {
        int sku = getUserInput();
        cart.addProductToCartBySku(sku);
    }

    private void showCart() {
        cart.printCartItems();
    }

    private void removeProductFromCart() {
        int sku = getUserInput();
        cart.removeProductBySku(sku);
    }

}
