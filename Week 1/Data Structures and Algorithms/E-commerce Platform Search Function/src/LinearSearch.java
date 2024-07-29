public class LinearSearch {
    public static Product linearSearch(Product[] products, String productId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductId().equals(productId)) {
                return products[i];
            }
        }
        return null; // Product not found
    }
}
