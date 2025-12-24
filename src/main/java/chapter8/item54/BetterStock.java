package chapter8.item54;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BetterStock {

    private final List<Product> productsInStock = new ArrayList<>(); // Products are now unavailable
    private static final Product[] EMPTY_PRODUCT_ARRAY = new Product[0];

    public List<Product> getProductList() {
        return productsInStock.isEmpty() ? List.of() : new ArrayList<>(productsInStock);
    }

    public Product[] getProductArray() {
        return productsInStock.toArray(EMPTY_PRODUCT_ARRAY);
    }

    public static void main(String[] args) {
        BetterStock stock = new BetterStock();

        System.out.println(stock.getProductArray() == stock.getProductArray());

        Product[] productArray = stock.getProductArray();
        if (Arrays.stream(productArray).anyMatch(p -> p.equals(Product.KEYBOARD))) {
            System.out.println("Jolly good");
        }else {
            System.out.println("Thousand apologies");
        }

        List<Product> productList = stock.getProductList();
        if (productList.contains(Product.COMPUTER)) {
            System.out.println("Jolly good");
        }else {
            System.out.println("Thousand apologies");
        }
    }
}
