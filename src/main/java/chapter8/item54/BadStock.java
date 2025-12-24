package chapter8.item54;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BadStock {
    private final List<Product> productsInStock = new ArrayList<>(); // Products now are unavailable

    public List<Product> getProductList() {
        return productsInStock.isEmpty() ? null : new ArrayList<>(productsInStock);
    }

    // Pre-allocating the array each time this is invoked
    public Product[] getProductArray() {
        return productsInStock.toArray(new Product[productsInStock.size()]);
    }

    public static void main(String[] args) {
        BadStock stock = new BadStock();

        System.out.println(stock.getProductArray() == stock.getProductArray());

        Product[] productArray = stock.getProductArray();
        if (Arrays.stream(productArray).anyMatch(p -> p.equals(Product.KEYBOARD))) {
            System.out.println("Jolly good");
        }else {
            System.out.println("Thousand apologies");
        }

        List<Product> productList = stock.getProductList();
        if (productList.contains(Product.COMPUTER)) { // NullPointerException
            System.out.println("Jolly good");
        }else {
            System.out.println("Thousand apologies");
        }
    }
}
