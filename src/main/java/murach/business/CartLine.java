/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package murach.business;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Duc Vinh
 */
@Entity
@Table(name="CartLine")
public class CartLine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartlineID;
    @ManyToOne(fetch=FetchType.EAGER)
    private Product product;
    private int quantity;

    public CartLine() {
    }
    public CartLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Float getTotal() {
        return quantity * product.getPrice();
    }



    public CartLine(Product product) {
        this.product = product;
        this.quantity = 1;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setId(int id) {
        this.cartlineID = id;
    }

    public int getId() {
        return cartlineID;
    }



}