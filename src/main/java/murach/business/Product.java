package murach.business;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"Product\"")
public class Product implements Serializable {
    private int productID;

    public Product() {
    }
    public Product(String productName, Float price, String description, String images, String brand, String category, Float weight, Float nutritionalValue) {
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.images = images;
        this.brand=brand;
        this.category=category;
        this.weight=weight;
        this.nutritionalValue=nutritionalValue;
    }
    private String productName;
    private Float price;
    private String description;
    private String images;
    private String brand;
    private String category;
    private Float weight;
    private Float nutritionalValue;
    
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
    
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }
    
    public Float getNutritionalValue() {
        return nutritionalValue;
    }

    public void setNutritionalValue(Float nutritionalValue) {
        this.nutritionalValue = nutritionalValue;
    }
    
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    
    public int getProductID() {
        return productID;
    }
    public void setProductID(int productID) {
        this.productID = productID;
    }
    
    @Override
    public String toString() {
        return "Product{" +
               "productid=" + productID +
               ", productname='" + productName + '\'' +
               ", price=" + price +
               // ... (thêm các thu?c tính khác)
               '}';
    }
}