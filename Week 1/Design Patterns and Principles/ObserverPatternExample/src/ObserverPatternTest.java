public class ObserverPatternTest {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp("MobileApp1");
        Observer webApp = new WebApp("WebApp1");

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setStockPrice(100.50);
        stockMarket.setStockPrice(102.75);

        stockMarket.deregisterObserver(mobileApp);
        stockMarket.setStockPrice(105.00);
    }
}
