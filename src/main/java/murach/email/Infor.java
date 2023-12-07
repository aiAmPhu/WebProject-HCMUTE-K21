package murach.email;

import java.io.*;
import java.util.List;
//import javax.mail.MessagingException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.*;
import murach.business.Orders;
import murach.business.Users;
import murach.data.*;
//import murach.util.MailUtilLocal;

@WebServlet(urlPatterns = "/infor")
public class Infor extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //doPost ?ang ph?, k c? t?c d?ng
        String url = "/index.jsp";
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";
        }
        if (action.equals("join")) {
            url = "/index.jsp";
        } else if (action.equals("add")) {
//            String a = "a";
                String b = request.getParameter("username");
//            String c = request.getParameter("password");
//            String d = request.getParameter("firstname");
//            String e = request.getParameter("lastname");
//            String f = request.getParameter("phonenumber");
//            String g = request.getParameter("address");
//            String h = "0";
//            String address="aaaa";
//            String role="aaaa";
            List<Users> users = UsersDB.selectUsername(b);
            if (!users.isEmpty()) {
                Users authenticatedUser1 = users.get(1); //lay cot dau tien cot 0
                String address = authenticatedUser1.getAddress();
                Users authenticatedUser2 = users.get(2); //lay cot dau tien cot 0
                String firstname = authenticatedUser2.getFirstname();
                Users authenticatedUser3 = users.get(3); //lay cot dau tien cot 0
                String lastname = authenticatedUser3.getLastname();
                Users authenticatedUser4 = users.get(4); //lay cot dau tien cot 0
                String password = authenticatedUser4.getPassword();
                Users authenticatedUser5 = users.get(5); //lay cot dau tien cot 0
                String phone = authenticatedUser5.getPhonenumber();
                Users authenticatedUser6 = users.get(6); //lay cot dau tien cot 0
                String role = authenticatedUser6.getRoless();
                Users authenticatedUser7 = users.get(7); //lay cot dau tien cot 0
                String username = authenticatedUser7.getUsername();
                Users user = new Users(username,password,firstname,lastname,phone,address,role);
//            if (UserDB.usernameExists(b, c)) {
//                request.setAttribute("mess", "User already exists");
//                url = "/login.jsp";
//            } else {
                // Insert the user into the database
//                UserDB.insert(user);
                request.setAttribute("user", user);
                url = "/thanks_1.jsp";
            }
            else {
                url = "/thanks.jsp";
            }
            
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String url = null;
        if (cookies != null) 
        {
            String usernameValue = null;
            String userId=null;
            // Ki?m tra xem cookie "username" c? t?n t?i hay kh?ng
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    usernameValue = cookie.getValue();
                    break;
                }
            }
            
            for (Cookie cookie : cookies) {
                if ("userId".equals(cookie.getName())) {
                    userId = cookie.getValue();
                    int userIDaaa = Integer.parseInt(userId);
                    break;
                }
            }
            
            if (usernameValue != null) 
            {
                List<Users> users = UsersDB.selectUsername(usernameValue);
                if (!users.isEmpty()) 
                {
                    Users authenticatedUser = users.get(0);
                    String address = authenticatedUser.getAddress();
                    String firstname = authenticatedUser.getFirstname();
                    String lastname = authenticatedUser.getLastname();
                    String password = authenticatedUser.getPassword();
                    String phone = authenticatedUser.getPhonenumber();
                    String role = authenticatedUser.getRoless();

                    Users user = new Users(usernameValue, password, firstname, lastname, phone, address, role);
                    request.setAttribute("user", user);
//                    request.getRequestDispatcher("/inforUser.jsp").forward(request, response);
                } 
                else 
                {
                    response.getWriter().write("Kh?ng t?m th?y th?ng tin user cho username: " + usernameValue);
                }
            }
            if (userId!=null) 
            {
                int userIDaaa = Integer.parseInt(userId);
//                System.out.printf("gia tr? userIdaaaa: ",userIDaaa);
                List<Orders> orders = OrderDB.selectUserId(userIDaaa);
//                System.out.printf("Oders: %s%n", orders);
                if (!orders.isEmpty()) 
                {
                    
                    request.setAttribute("listP", orders);
                    System.out.printf("ListO: %s%n", orders);
                    url="/inforUser.jsp";
                } else 
                {
                    url = "/test.jsp";
                }
            } 
        } 
        else 
        {
            response.getWriter().write("Vui l?ng ??ng nh?p ?? truy c?p trang n?y");
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}