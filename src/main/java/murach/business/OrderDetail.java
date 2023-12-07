/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package murach.business;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Duc Vinh
 */
@Entity
@Table(name="OrderDetail")
public class OrderDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String productName;
    private String brand;
    private String images;    // t?o data ki?m m?y url c� ��?ng d?n ng?n ng?n, d�i qu� 255 k? t? l� b? qua kia l?i
    private Float weight;
    private Float price;
    private String description; // c�i n�y c?ng ng?n ng?n hoi, kh?i ti?ng vi?t c�ng t?t
    private int quantity;


    public OrderDetail() {
    }

    public OrderDetail(String productName, String brand, String images, Float weight, Float productCost, String description, int quantity) {
        this.productName = productName;
        this.brand = brand;
        this.images = images;
        this.weight = weight;
        this.price = productCost;
        this.description = description;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
    
    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
    
    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
