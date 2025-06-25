import java.util.Arrays;

class Product implements Comparable<Product> {
    int productId;
    String productName;
    String category;

    public Product(int id, String name, String category) {
        this.productId = id;
        this.productName = name;
        this.category = category;
    }

    @Override
    public int compareTo(Product other) {
        return this.productName.compareToIgnoreCase(other.productName);
    }

    @Override
    public String toString() {
        return "[" + productId + ", " + productName + ", " + category + "]";
    }
}

public class ProductSearch{

    public static Product linearSearch(Product[] products, String target) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(target)) {
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String target) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(target);

            if (cmp == 0)
                return products[mid];
            else if (cmp < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] productList = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Fashion"),
            new Product(103, "Book", "Education"),
            new Product(104, "Phone", "Electronics"),
        };

        System.out.println("Linear Search");
        Product result1 = linearSearch(productList, "Book");
        System.out.println(result1 != null ? "Found: " + result1 : "Not Found");

        Arrays.sort(productList);
        System.out.println();
        System.out.println("Binary Search");
        Product result2 = binarySearch(productList, "Book");
        System.out.println(result2 != null ? "Found: " + result2 : "Not Found");
    }
}