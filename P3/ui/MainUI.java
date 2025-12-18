package P3.ui;

import java.util.Scanner;

import P3.repo.ProductRepositoryImpl;
import P3.service.ProductService;

public class MainUI {

    public static void main(String[] args) {

        ProductService service = new ProductService(new ProductRepositoryImpl());
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== PRODUCT MANAGEMENT =====");
            System.out.println("1. Add Product");
            System.out.println("2. List of Products");
            System.out.println("3. Search Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    service.addProduct(id, name, price);
                    System.out.println("Product added!");
                    break;

                case 2:
                    service.getAllProducts().forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    int sid = sc.nextInt();

                    var product = service.getProductById(sid);
                    if (product != null)
                        System.out.println(product);
                    else
                        System.out.println("Product not found!");
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();

                    if (service.deleteProduct(did))
                        System.out.println("Deleted!");
                    else
                        System.out.println("No product found!");
                    break;

                case 5:
                    System.out.println("Thank you!");
                    sc.close();
                    System.exit(0);
            }
        }
    }
}
