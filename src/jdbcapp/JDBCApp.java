package jdbcapp;

import java.util.ArrayList;
import java.util.Scanner;
import jdbcapp.dao.ProductDAO;
import jdbcapp.model.Product;

public class JDBCApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product p = null;
        int x = 0;
        do{
            System.out.println("Press 1 for insert");
            System.out.println("Press 2 for delete");
            System.out.println("Press 3 for update");
            System.out.println("Press 4 for select");
            System.out.println("Press 5 for exit");
            System.out.println("Enter Your choice");
            int choice = sc.nextInt();
            switch(choice){
                case 1: 
                    System.out.println("Enter Product Name");
                    String pname = sc.next();
                    System.out.println("Enter Product Price");
                    float price = sc.nextFloat();
                    System.out.println("Enter Description");
                    String desc = sc.next();
                     p = new Product(pname, price, desc);
                    x = new ProductDAO().insert(p);
                    if(x!=0)
                        System.out.println("Record Inserted...");
                    else
                        System.out.println("Record Not Inserted...");
                    break;
                case 2: 
                    System.out.println("Enter Product Id to be deleted...");
                    int pid = sc.nextInt();
                    p = new Product();
                    p.setId(pid);
                    x = new ProductDAO().delete(p);
                    if(x!=0)
                        System.out.println("Record Deleted..");
                    else
                        System.out.println("Record Not Deleted...");
                    break;
                case 3: 
                    System.out.println("Enter product id to be updated...");
                    int productId = sc.nextInt();
                    System.out.println("Enter Product Name");
                    String productName = sc.next();
                    System.out.println("Enter Price");
                    float productPrice = sc.nextFloat();
                    System.out.println("Enter Desription");
                    String productDesc = sc.next();
                    
                    p = new Product(productId, productName, productPrice, productDesc);
                    x = new ProductDAO().update(p);
                    if(x!=0)
                        System.out.println("Record Updated...");
                    else
                        System.out.println("Record Not Updated...");
                    break;
                case 4: 
                    ArrayList<Product> al = new ProductDAO().getProductList();
                    for(Product product: al){
                        System.out.println(product.getId()+" "+product.getName()+" "+product.getPrice()+" "+product.getDescription());
                    }
                    break;    
                case 5: 
                    System.exit(0);
                    break;
            }
        }while(true);
    }
    
}
