/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package murach.email;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import murach.business.*;
import murach.business.Product;
import murach.data.CartDB;
import murach.data.ProductDB;

/**
 *
 * @author Duc Vinh
 */
@WebServlet(name = "cart", value = "/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
       
        if (session == null || session.getAttribute("users") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }
        String action = req.getParameter("action");
        Cart cart = (Cart) session.getAttribute("cart");
        if ("add".equals(action)) {
            addToCart(req, cart);
        } else if ("delete".equals(action)) {
            deletefromcart(req, cart);
        } else if ("addquantity".equals(action)) {
            addQuantity(req, cart);
        } else if ("minusquantity".equals(action)) {
            minusQuantity(req, cart);
        }
        CartDB.update(cart);
        String referer = req.getHeader("referer");
        resp.sendRedirect(referer);
    }


    private void addToCart(HttpServletRequest req, Cart cart) {
        int productID = Integer.parseInt(req.getParameter("productID"));
        Product product = ProductDB.getProductByID(productID);
        CartLine cartLine = new CartLine(product);
        cart.addCartLine(cartLine);
    }

    private void deletefromcart(HttpServletRequest req, Cart cart) {
        int productID = Integer.parseInt(req.getParameter("productID"));
        cart.removeCartLine(productID);
    }

    private void addQuantity(HttpServletRequest req, Cart cart) {
        int productID = Integer.parseInt(req.getParameter("productID"));
        cart.addQuantityProduct(productID);
    }

    private void minusQuantity(HttpServletRequest req, Cart cart) {
        int productID = Integer.parseInt(req.getParameter("productID"));
        cart.minusQuantityProduct(productID);
    }
}

