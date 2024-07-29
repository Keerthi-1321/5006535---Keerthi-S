import java.util.Arrays;

public class BinarySearch {
    public static Product binarySearch(Product[] products, String productId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductId().compareTo(productId);

            if (comparison == 0) {
                return products[mid]; // Product found
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Product not found
    }

    public static void main(String[] args) {
        // Example usage
        Product[] products = {
                new Product("P001", "Product 1", "Category A"),
                new Product("P002", "Product 2", "Category B"),
                new Product("P003", "Product 3", "Category A"),
                new Product("P004", "Product 4", "Category C")
        };

        // Sort the array for binary search
        Arrays.sort(products, (p1, p2) -> p1.getProductId().compareTo(p2.getProductId()));

        // Linear search example
        Product foundProduct1 = LinearSearch.linearSearch(products, "P002");
        System.out.println("Linear Search Result: " + (foundProduct1 != null ? foundProduct1 : "Product not found"));

        // Binary search example
        Product foundProduct2 = binarySearch(products, "P002");
        System.out.println("Binary Search Result: " + (foundProduct2 != null ? foundProduct2 : "Product not found"));
    }
}
