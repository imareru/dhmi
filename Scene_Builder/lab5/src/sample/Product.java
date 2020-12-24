package sample;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Product {
   private String productName;
   private String productId;
    private String productCount;
   private String productSum;

    private static Product product;

    public Product(String productId, String productName, String productSum, String productCount){
        this.productId = productId;
        this.productName = productName;
        this.productSum = productSum;
        this.productCount = productCount;
    }

    public Product() {

    }


    public static void addProduct(Product product) {
    }

    public String getProductName(){

        return productName;
    }

    public void setProductName(String productName){

        this.productName = productName;
    }

    public String getProductId(){

        return productId;
    }
    public void setProductId(String productId){
        this.productId = productId;
    }
    public String getProductCount(){

        return productCount;
    }
    public void setProductCount(String productCount){

        this.productCount = productCount;
    }
    public String getProductSum(){

        return productSum;
    }
    public void setProductSum(String productSum){

        this.productSum = productSum;
    }

    public void saveProductInfo() throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("D:\\University\\2_semestr\\PCHMI\\Practika\\Scene_Builder\\lab5\\src\\sample\\products.txt", true));
        pw.println();
        pw.print(productId + " " + productName + " " + productSum + " " + productCount);
        pw.close();
    }

}

