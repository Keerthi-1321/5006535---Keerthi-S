public interface Document {
    void open();
    void close();
}

class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word Document.");
    }

    @Override
    public void close() {
        System.out.println("Closing Word Document.");
    }
}


class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF Document.");
    }

    @Override
    public void close() {
        System.out.println("Closing PDF Document.");
    }
}

class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Excel Document.");
    }

    @Override
    public void close() {
        System.out.println("Closing Excel Document.");
    }
}
