package murach.business;

import java.io.Serializable;
import java.util.Date;
//import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "\"Storage\"")
public class Storage implements Serializable {
    @Id
    private int product;

    public Storage() {
    }
    public Storage(int productName, Date price) {
        this.quantity = productName;
        this.expirationDate = price;
    }
    private int quantity;
//    @Temporal(javax.persistence.TemporalType.DATE)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date expirationDate;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
    
    public int getProduct() {
        return product;
    }
    public void setProduct(int product) {
        this.product = product;
    }
    
}