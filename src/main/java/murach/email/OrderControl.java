package murach.email;

import java.io.*;
import java.util.List;
//import javax.mail.MessagingException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.*;
import murach.business.Product;
//import murach.business.Users;
import murach.data.ProductDB;
import java.util.logging.Logger;
import murach.business.Orders;
import murach.data.OrderDB;

//import murach.util.MailUtilLocal;

@WebServlet(urlPatterns = "/abc")
public class OrderControl extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(ProductControl.class.getName());
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
       doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String url;
        List<Orders> orders = OrderDB.getAllOrders();

        if (!orders.isEmpty()) {
            // ??t danh sách s?n ph?m vào request
            request.setAttribute("listO", orders);
            url = "/ManagerOrder.jsp";

            // Log thông tin danh sách s?n ph?m
//            LOGGER.info("List of Products:");
//            for (Product product : products) {
//                LOGGER.info(product.toString());
//            }
        } else {
            url = "/test.jsp";
        }

        // Chuy?n h??ng ??n trang JSP mong mu?n
        getServletContext().getRequestDispatcher(url).forward(request, response);    
    }
}