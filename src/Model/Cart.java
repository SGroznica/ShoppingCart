package Model;

import java.util.ArrayList;
import java.util.List;

public class Cart {


    List<Product> cartItems = new ArrayList<Product>();

    public void addProductToCartBySku(int sku) {
        Product product = getProductBySku(sku);
        addToCart(product);
    }

    private Product getProductBySku(int sku) {
        Product product = null;
        List<Product> products = new Inventory().getProducts();
        for (Product prod: products) {
            if (prod.getSku() == sku) {
                product = prod;
                break;
            }
        }
        return product;
    }

    private void addToCart(Product product) {
        cartItems.add(product);
    }

    public void removeProductBySku(int sku) {
        Product prod = getProductBySku(sku);
        cartItems.remove(prod);
    }

    void printCartItems() {
        for (Product prod: cartItems) {
            System.out.println(prod.getName());
        }
    }

}
