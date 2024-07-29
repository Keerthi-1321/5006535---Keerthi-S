import java.util.Arrays;

public class BinarySearch {
    public static Book binarySearch(Book[] books, String title) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return books[mid]; // Book found
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Book not found
    }

    public static void main(String[] args) {
        Book[] books = {
                new Book("B001", "Java Programming", "Author A"),
                new Book("B002", "Data Structures And Algorithms", "Author B"),
                new Book("B003", "Computer Networks", "Author C"),
                new Book("B004", "Database Management System", "Author D")
        };

        // Sort the array for binary search
        Arrays.sort(books, (b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));

        // Linear search example
        Book foundBook1 = LinearSearch.linearSearch(books, "Data Structures And Algorithms");
        System.out.println("Linear Search Result: " + (foundBook1 != null ? foundBook1 : "Book not found"));

        // Binary search example
        Book foundBook2 = binarySearch(books, "Database Management System");
        System.out.println("Binary Search Result: " + (foundBook2 != null ? foundBook2 : "Book not found"));
    }
}
