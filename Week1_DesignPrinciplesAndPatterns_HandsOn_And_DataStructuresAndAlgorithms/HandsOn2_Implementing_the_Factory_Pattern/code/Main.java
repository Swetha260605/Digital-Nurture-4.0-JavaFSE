package code;
public class Main {

    // Step 1: Define Document Interface
    interface Document {
        void open();
    }

    // Step 2: Create Concrete Document Classes
    static class WordDocument implements Document {
        public void open() {
            System.out.println("Opening a Word document.");
        }
    }

    static class PdfDocument implements Document {
        public void open() {
            System.out.println("Opening a PDF document.");
        }
    }

    static class ExcelDocument implements Document {
        public void open() {
            System.out.println("Opening an Excel document.");
        }
    }

    // Step 3: Abstract Factory
    abstract static class DocumentFactory {
        public abstract Document createDocument();
    }

    // Step 4: Concrete Factories
    static class WordFactory extends DocumentFactory {
        public Document createDocument() {
            return new WordDocument();
        }
    }

    static class PdfFactory extends DocumentFactory {
        public Document createDocument() {
            return new PdfDocument();
        }
    }

    static class ExcelFactory extends DocumentFactory {
        public Document createDocument() {
            return new ExcelDocument();
        }
    }

    // Step 5: Test in main method
    public static void main(String[] args) {
        // Create Word Document
        DocumentFactory wordFactory = new WordFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();

        // Create PDF Document
        DocumentFactory pdfFactory = new PdfFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();

        // Create Excel Document
        DocumentFactory excelFactory = new ExcelFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
    }
}
