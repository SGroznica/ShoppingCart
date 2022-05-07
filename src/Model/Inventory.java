package Model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {


    private final List<Product> products = new ArrayList<Product>();

    public Inventory() {
        this.initStoreItems();
    }

    public List<Product> getProducts() {
        return products;
    }


    private void initStoreItems() {
        for(Product p: products){
            System.out.println(p);
        }
    }

    /*public void initStoreItems() {

        String [] productNames = {"Lux Soap", "Fair n Lovely", "MTR"};
        Double [] productPrice = {40.00d, 60.00d, 30.00d};
        Integer [] stock = {10, 6, 10};

        for (int i=0; i < productNames.length; i++) {
            this.products.add(new Product(i+1, productNames[i], productPrice[i], stock[i]));
        }
    }*/
}
