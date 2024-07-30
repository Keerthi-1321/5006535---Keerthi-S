public class ProxyPatternTest {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        // Images will be loaded from disk only when display() is called
        image1.display();
        System.out.println();
        image2.display();
        System.out.println();
        // Subsequent calls to display() will not trigger loading from disk
        image1.display();
    }
}
