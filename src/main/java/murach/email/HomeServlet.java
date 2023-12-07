/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package murach.email;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import murach.business.Cart;
import murach.business.Product;
import murach.business.Users;
import murach.data.CartDB;
import murach.data.ProductDB;
import murach.data.UsersDB;
import murach.util.CookieUtil;

/**
 *
 * @author Duc Vinh
 */
@WebServlet(name="index",value="/index")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        List<Product> productList = ProductDB.getAllProducts();
        Cookie[] cookies = req.getCookies();
        String userid = CookieUtil.getCookieValue(cookies, "userId");
        

        if (!userid.isEmpty()) {
            Users users = UsersDB.getUsersByID(Integer.parseInt(userid));
            Cart cart = CartDB.getCartByUsers(users);
            HttpSession session = req.getSession();
            // Ð?t users và cart lên session
            session.setAttribute("users", users);
            session.setAttribute("cart", cart);
        } 

        req.setAttribute("listP", productList);

        // Chuy?n d? li?u ð?n trang 
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
