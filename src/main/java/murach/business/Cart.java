package murach.business;

import java.io.Serializable;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;
//import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;


@Entity
@Table(name = "Cart")
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartID;


    // Siêng nãng : Truy v?n 1  ð?i tý?ng là truy v?n quan h? ví d? nhý trên s? truy v?n cartline
    // Lan truy?n
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    orphanRemoval = true: N?u m?t "CartLine" không c?n ðý?c tham chi?u t? "Cart", nó s? t? ð?ng b? xóa.
    private List<CartLine> cartLines;
    @OneToOne
    private Users users;

    public Cart() {
        
    }

    public Cart(Users users) {
        this.users = users;
        this.cartLines = new ArrayList<CartLine>();
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public int getId() {
        return cartID;
    }


    public void setId(int ID) {
        this.cartID = ID;
    }

    public List<CartLine> getCartLines() {
        return cartLines;
    }

    public void setCartLines(List<CartLine> cartLines) {
        this.cartLines = cartLines;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "CartID=" + cartID +
                ", CartLines=" + cartLines +
                '}';
    }

    public void removeCartLine(int productID) {
    cartLines.removeIf(item -> item.getProduct().getProductID() == productID);
    }


    public int countCartLine() {
        return cartLines.size();
    }

    public void addCartLine(CartLine cartLine) {
        for (var item : cartLines) {
            if (item.getProduct().getProductID()==cartLine.getProduct().getProductID()) {
                item.setQuantity(item.getQuantity() + 1);
                return;
            }
        }
        cartLines.add(cartLine);
    }

    public void addQuantityProduct(int productID) {
        for (var item : cartLines) {
            if (item.getProduct().getProductID()==productID) {
                item.setQuantity(item.getQuantity() + 1);
                return;
            }
        }
    }

    public void minusQuantityProduct(int productID) {
        for (var item : cartLines) {
            if (item.getProduct().getProductID()==productID) {
                if (item.getQuantity() > 1) {
                    item.setQuantity(item.getQuantity() - 1);
                }
                return;
            }
        }
    }
}