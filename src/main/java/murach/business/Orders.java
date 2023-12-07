package murach.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "\"Orders\"")
public class Orders implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderID;
    @ManyToOne()
    private Users customer;
    
    


    @Temporal(javax.persistence.TemporalType.DATE)
    private Date orderDate;
    private float totalMoney;
    private int orderStatus;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;
    

    public Orders() {
    }

    public Orders(Users customer, int orderStatus, float totalMoney, Date date,List<OrderDetail> orderDetails) {
        this.customer=customer;
        this.orderStatus=orderStatus;
        this.orderDate = date;
        this.totalMoney = totalMoney;
        this.orderDetails = new ArrayList<OrderDetail>();
        setDetails(orderDetails);
    }
    
    private void setDetails(List<OrderDetail> orderDetails) {
        for (var item :orderDetails) {
            String productName = item.getProductName();
            String brand = item.getBrand();
            String productImage = item.getImages();
            float weight = item.getWeight();
            float price = item.getPrice();
            String description = item.getDescription();
            int quantity = item.getQuantity();
            this.orderDetails.add(new OrderDetail(productName,brand,productImage,weight,price,description,quantity));
        }
    }
    
    public Users getCustomer() {
        return this.customer;
    }

    public void setCustomer(Users id) {
        this.customer = id;
    }
    
    public int getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(int id) {
        this.orderStatus = id;
    }
    
                
    public int getId() {
        return this.orderID;
    }

    public void setId(int id) {
        this.orderID = id;
    }
    
    public Date getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Date id) {
        this.orderDate = id;
    }
    
    public float getTotalMoney() {
        return this.totalMoney;
    }

    public void setTotalMoney(float id) {
        this.totalMoney = id;
    }
    
    @Override
    public String toString() {
        int var10000 = this.orderID;
        float var2000=this.totalMoney;
        return "Cart{orderID=" + var10000 + "} "+ "Totalmoney"+ var2000;
    }
}