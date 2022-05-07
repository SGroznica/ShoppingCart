package Start;

import Model.Inventory;
import Model.Product;
import Utility.Insert;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Start {

    private Product product;
    private List<Product> products;

    private Inventory inventory;
    private List<Inventory>inventories;
    private Scanner input;

    public Start() {
        products = new ArrayList<>();
        inventories = new ArrayList<>();
        input = new Scanner(System.in);
        header();
        mainMenu();
        input.close();


    }


    public void mainMenu() {
        System.out.println("1. Work with products");
        System.out.println("2. Work with inventory");
        System.out.println("3. Work with shopping cart");
        System.out.println("4. Exit");
        switch (Insert.inputInt(input, "Choose", 1, 4)){
            case 1 -> productsMenu();
            case 2 -> inventoryMenu();
            case 3 -> shoppingCartMenu();
            case 4 -> exitAplication();
        }

    }

    private void productsMenu() {
        System.out.println("1. List of products");
        System.out.println("2. Add new product");
        System.out.println("3. Change product");
        System.out.println("4. Remove product");
        System.out.println("5. Return to main menu");
        switch (Insert.inputInt(input, "Choose", 1, 5)){
            case 1 -> productList();
            case 2 -> productAdd();
            case 3 -> productChange();
            case 4 -> productRemove();
            case 5 -> mainMenu();
        }
    }


    private void productAdd() {
        Product p = new Product();
        p.setId(Insert.inputInt(input, "Input product ID"));
        p.setSku(Insert.inputInt(input, "Input product SKU"));
        p.setName(Insert.inputString(input, "Input product name"));
        p.setPrice(Insert.inputBigDecimal(input, "Input product price"));
        p.setQuantity(Insert.inputInt(input,"Input product quantity"));

        products.add(p);
        productsMenu();
    }

    private void productChange() {
        allProducts();
        int i = Insert.inputInt(input,"Insert product ID you wish to change");
        product = products.get(i-1);
        System.out.println("What do you wish to change?");
        productChangeMenu();

    }

    private void productChangeMenu() {
        String decision;
        boolean yn = true;

        System.out.println("1. Change SKU");
        System.out.println("2. Change Name");
        System.out.println("3. Change Price");
        System.out.println("4. Change Quantity");
        System.out.println("5. Return");
        switch (Insert.inputInt(input, "Choose", 1, 5)){
            case 1 -> {
                product.setSku(Insert.inputInt(input, "Change SKU (" + product.getSku() + ")"));
                System.out.println("Do you want to change something else: Yes or No");
                decision = input.nextLine();
                switch (decision){
                    case "Yes":
                        yn=true;

                        productChangeMenu();

                    case "No":
                        yn = false;
                        productsMenu();

                    default:
                        boolean repeat = true;

                        while (repeat)
                        {
                            System.out.println("Input has to be Yes or No");
                            decision = input.nextLine();

                            switch (decision)
                            {
                                case "Yes":
                                    yn = true;
                                    repeat = false;
                                    productChangeMenu();

                                case "No":
                                    yn = repeat = false;
                                    productsMenu();
                                default:
                                    repeat = true;
                            }
                        }
                        break;

                }

            }
            case 2 -> {
                product.setName(Insert.inputString(input, "Change name (" + product.getName() + ")"));
                System.out.println("Do you want to change something else: Yes or No");
                decision = input.nextLine();
                switch (decision){
                    case "Yes":
                        yn=true;

                        productChangeMenu();

                    case "No":
                        yn = false;
                        productsMenu();

                    default:
                        boolean repeat = true;

                        while (repeat)
                        {
                            System.out.println("Input has to be Yes or No");
                            decision = input.nextLine();

                            switch (decision)
                            {
                                case "Yes":
                                    yn = true;
                                    repeat = false;
                                    productChangeMenu();

                                case "No":
                                    yn = repeat = false;
                                    productsMenu();
                                default:
                                    repeat = true;
                            }
                        }
                        break;

                }
            }
            case 3 -> {
                product.setPrice(Insert.inputBigDecimal(input, "Change price (" + product.getPrice() + ")"));
                System.out.println("Do you want to change something else: Yes or No");
                decision = input.nextLine();
                switch (decision){
                    case "Yes":
                        yn=true;

                        productChangeMenu();

                    case "No":
                        yn = false;
                        productsMenu();

                    default:

                        boolean repeat = true;

                        while (repeat)
                        {
                            System.out.println("Input has to be Yes or No");
                            decision = input.nextLine();

                            switch (decision)
                            {
                                case "Yes":
                                    yn = true;
                                    repeat = false;
                                    productChangeMenu();

                                case "No":
                                    yn = repeat = false;
                                    break;
                                default:
                                    repeat = true;
                            }
                        }
                        break;

                }
            }
            case 4 -> {
                product.setQuantity(Insert.inputInt(input, "Change quantity (" + product.getQuantity() + ")"));
                System.out.println("Do you want to change something else: Yes or No");
                decision = input.nextLine();
                switch (decision){
                    case "Yes":
                        yn=true;

                        productChangeMenu();

                    case "No":
                        yn = false;
                        productsMenu();

                    default:

                        boolean repeat = true;

                        while (repeat)
                        {
                            System.out.println("Input has to be Yes or No");
                            decision = input.nextLine();

                            switch (decision)
                            {
                                case "Yes":
                                    yn = true;
                                    repeat = false;
                                    productChangeMenu();

                                case "No":
                                    yn = repeat = false;
                                    productsMenu();
                                default:
                                    repeat = true;
                            }
                        }
                        break;

                }
            }
            case 5 -> productsMenu();
        }


    }

    private void productRemove(){
        allProducts();
        products.remove(Insert.inputInt(input, "Enter product ID you wish to delete")-1);
        productsMenu();

    }

    private void productList() {
        for(Product p: products){
            System.out.println(p);
        }
        productsMenu();
    }

    private void allProducts(){
        int b=1;
        for (Product p: products) {
            System.out.println(b++ + ". " + p);
        }
    }

    private void inventoryMenu() {
        System.out.println("1. List of inventories");
        System.out.println("2. Create inventory");
        System.out.println("3. Add products to inventory");
        System.out.println("4. Remove products from inventory");
        System.out.println("5. Return");
        switch (Insert.inputInt(input, "Choose", 1, 4)) {
            case 1 -> inventoryList();
            case 2 -> createInventoryMenu();
            case 3 -> addProductsMenu();
            case 4 -> removeProductsMenu();
            case 5 -> mainMenu();


        }
    }
    private void createInventoryMenu() {
        Inventory i = new Inventory();
        i.setId(Insert.inputInt(input, "Input inventory ID"));
        i.setName(Insert.inputString(input, "Input inventory name"));
        inventories.add(i);
        inventoryMenu();
    }
    private void inventoryList() {
        for(Inventory in: inventories){
            System.out.println(in);
        }
        inventoryMenu();

    }



    private void addProductsMenu() {
        System.out.println("1. List products");
        System.out.println("2. A");
        System.out.println("3. Add products to inventory");
        System.out.println("4. Remove products from inventory");
        System.out.println("5. Return");
        switch (Insert.inputInt(input, "Choose", 1, 4)) {
            case 1 -> inventoryList();
            case 2 -> createInventoryMenu();
            case 3 -> addProductsMenu();
            case 4 -> removeProductsMenu();
            case 5 -> mainMenu();
        }


    }
    private void removeProductsMenu() {
    }
    private void shoppingCartMenu() {
    }

    private void exitAplication() {
    }

    private void header() {
        System.out.println("******************************");
        System.out.println("********Online Store**********");
        System.out.println("******************************");
        System.out.println();
    }

    ;



    public static void main(String[] args) {
    new Start();


    }
}
