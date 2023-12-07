/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package murach.email;

import murach.util.CookieUtil;
import murach.business.*;
import murach.data.*;
import java.io.IOException;
import java.util.List;
import java.util.Locale.Category;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Duc Vinh
 */
@WebServlet(name="shop",value="/shop")
public class ShopServlet extends HttpServlet {

@Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        Cookie[] cookies = request.getCookies();
//
//        if (cookies != null) {
//            String usernameValue = null;
//
//            // Ki?m tra xem cookie "username" c� t?n t?i hay kh�ng
//            for (Cookie cookie : cookies) {
//                if ("username".equals(cookie.getName())) {
//                    usernameValue = cookie.getValue();
//                    break;
//                }
//            }
//
//            if (usernameValue != null) {
//                // N?u cookie "username" t?n t?i, s? d?ng gi� tr? ?? truy xu?t d? li?u t? c? s? d? li?u
//                List<Users> users = UserDB.selectUsername(usernameValue);
//
//                if (!users.isEmpty()) {
//                    Users authenticatedUser = users.get(0);
//
//                    // L?y c�c gi� tr? t? ??i t??ng authenticatedUser
//                    String address = authenticatedUser.getAddress();
//                    String firstname = authenticatedUser.getFirstname();
//                    String lastname = authenticatedUser.getLastname();
//                    String password = authenticatedUser.getPassword();
//                    String phone = authenticatedUser.getPhonenumber();
//                    String role = authenticatedUser.getRoless();
//
//                    // T?o ??i t??ng Users t? d? li?u truy xu?t ???c
//                    Users user = new Users(usernameValue, password, firstname, lastname, phone, address, role);
//
//                    // ??t thu?c t�nh "user" v�o request ?? s? d?ng trong trang JSP
//                    request.setAttribute("user", user);
//
//                    // Chuy?n h??ng ??n trang thanks_1.jsp
//                    request.getRequestDispatcher("/thanks_1.jsp").forward(request, response);
//                } else {
//                    // Tr??ng h?p kh�ng t�m th?y th�ng tin user trong c? s? d? li?u
//                    // C� th? x? l� theo � c?a b?n, v� d?: th�ng b�o l?i ho?c chuy?n h??ng ??n trang kh�c
//                    response.getWriter().write("Kh�ng t�m th?y th�ng tin user cho username: " + usernameValue);
//                }
//            } else {
//                // Tr??ng h?p cookie "username" kh�ng t?n t?i
//                // C� th? x? l� theo � c?a b?n, v� d?: chuy?n h??ng ??n trang ??ng nh?p
//                response.getWriter().write("Vui l�ng ??ng nh?p ?? truy c?p trang n�y");
//            }
//        } else {
//            // Tr??ng h?p kh�ng c� cookie n�o trong request
//            // C� th? x? l� theo � c?a b?n, v� d?: chuy?n h??ng ??n trang ??ng nh?p
//            response.getWriter().write("Vui l�ng ??ng nh?p ?? truy c?p trang n�y");
//        }
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String url;
        List<Product> products = ProductDB.getAllProducts();

        if (!products.isEmpty()) {
            // ??t danh s�ch s?n ph?m v�o request
            request.setAttribute("listP", products);
            url = "/shop.jsp";

            // Log th�ng tin danh s�ch s?n ph?m
//            LOGGER.info("List of Products:");
//            for (Product product : products) {
//                LOGGER.info(product.toString());
//            }
        } else {
            url = "/thanks.jsp";
        }

        // Chuy?n h??ng ??n trang JSP mong mu?n
        getServletContext().getRequestDispatcher(url).forward(request, response);     
    }
}