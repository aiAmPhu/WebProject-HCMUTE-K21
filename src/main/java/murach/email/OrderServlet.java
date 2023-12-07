/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package murach.email;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import javax.persistence.criteria.Order;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import murach.business.Cart;
import murach.business.OrderDetail;
import murach.business.Users;
import murach.business.Orders;
import murach.data.CartDB;
import murach.data.OrderDB;

/**
 *
 * @author Duc Vinh
 */
@WebServlet(name="order",value="/order")
public class OrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        if (session == null || session.getAttribute("users") == null) {
            resp.sendRedirect("Login.jsp");
            return;
        }
        String action = req.getParameter("action");
        if ("add".equals(action)){
            addOrder(req);
        }
        String referer = req.getHeader("referer");
        resp.sendRedirect(referer);
    }

    private void addOrder(HttpServletRequest req) {
        HttpSession session = req.getSession();
        Cart cart = (Cart)session.getAttribute("cart");
        Users user = (Users)session.getAttribute("users");

        List<OrderDetail> listOrderDetails = new ArrayList<>();
        for (var item : cart.getCartLines()) {
            String productName = item.getProduct().getProductName();
            String brand = item.getProduct().getBrand();
            String productImage = item.getProduct().getImages();
            float weight = item.getProduct().getWeight();
            float price = item.getProduct().getPrice();
            String description = item.getProduct().getDescription();
            int quantity = item.getQuantity();
            OrderDetail orderDetail = new OrderDetail(productName, brand, productImage, weight, price, description, quantity);
            listOrderDetails.add(orderDetail);
        }
        
        // L?y giá tr? t? tham s? request
        String inputString = req.getParameter("totalPrice");

        inputString = inputString.replace(".", "");

        // Bây gi? chuy?n ð?i chu?i ð? s?a ð?i thành s? th?c
        float totalPrice = Float.parseFloat(inputString);

        int orderStatus = 0;
        Date currentDate = new Date();
        Orders oder = new Orders(user,orderStatus,totalPrice,currentDate,new ArrayList<>(listOrderDetails)) ;
        OrderDB.insert(oder);
        req.setAttribute("user", oder);
        CartDB.removeCartLines(cart);
        req.setAttribute("c", cart);

//        int x = 1+1;
//        System.out.printf("UserIDDDD: %s%n", x);
    }
}
