/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package murach.email;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import murach.business.Cart;
import murach.business.Users;
import murach.data.CartDB;
import murach.data.DBUtil;
import murach.data.UsersDB;

/**
 *
 * @author Duc Vinh
 */
@WebServlet(name = "showcart", value = "/showcart")
public class ShowCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        int userID = Integer.parseInt(req.getParameter("userid"));
        Users user = UsersDB.getUsersByID(userID);
        // L?y ra cart t? customer và thêm cartline vào cart
        int cartID = CartDB.getCartByUsers(user).getId();
        // t?m Cart theo cart ID
        Cart cart = em.find(Cart.class,cartID);

        Long cartlinesCount = cart.getCartLines().stream().count();
        req.setAttribute("userId",userID);
        req.setAttribute("cartlineid",cartID);
        req .setAttribute("cartlinecount",cartlinesCount);
        req.setAttribute("list",cart.getCartLines());
        req.getRequestDispatcher("cart.jsp").forward(req,resp);
    }
}

