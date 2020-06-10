public class Product {
    private String category;
    private String productName;
    private String aisle;
    private String price;
    private String discount;

    public Product(String category, String productName, String aisle, String price, String discount){
        this.category = category;
        this.productName = productName;
        this.aisle = aisle;
        this.price = price;
        this.discount = discount;
    }

    public String getCategory() {
        return category;
    }

    public String getProductName() {
        return productName;
    }

    public String getAisle() {
        return aisle;
    }

    public String getPrice() {
        return price;
    }

    public String getDiscount() {
        return discount;
    }

    public String toString(){
        return this.category + ";"+this.productName + ";" + this.aisle +";" + this.price +";" + this.discount;
    }
}
