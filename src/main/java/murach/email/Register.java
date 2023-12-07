package murach.email;

import java.io.*;
//import javax.mail.MessagingException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.*;
import murach.business.Cart;
import murach.business.Users;
import murach.data.*;
//import murach.util.MailUtilLocal;

@WebServlet(urlPatterns = "/emailList")
public class Register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
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
            String c = request.getParameter("password");
            String d = request.getParameter("firstname");
            String e = request.getParameter("lastname");
            String f = request.getParameter("phonenumber");
            String g = request.getParameter("address");
            String h = "0";
//            String address="aaaa";
//            String role="aaaa";
            Users user = new Users(b,c,d,e,f,g,h);
            if (UsersDB.usernameExists(b, c)) {
                request.setAttribute("mess", "User already exists");
                url = "/register.jsp";
            } else {
                // Insert the user into the database
                UsersDB.insert(user);
                Cart cart = new Cart(user);
                CartDB.insert(cart);
                request.setAttribute("user", user);
                url = "/registerSuccess.jsp";
            }
            
            // send email to user
//            String to = email;
//            String from = "huynh3896@gmail.com";
//            String subject = "Welcome to our email list";
//            String body = "Dear " + firstName + ",\n\n"
//                    + "Thanks for joining our email list. "
//                    + "We'll make sure to send "
//                    + "you announcements about new products "
//                    + "and promotions.\n"
//                    + "Have a great day and thanks again!\n\n"
//                    + "Kelly Slivkoff\n"
//                    + "Mike Murach & Associates";
//            boolean isBodyHTML = false;
//            try {
//                MailUtilLocal.sendMail(to, from, subject, body,
//                        isBodyHTML);
//
//            } catch (MessagingException e) {
//                String errorMessage
//                        = "ERROR: Unable to send email. "
//                        + "Check Tomcat logs for details.<br>"
//                        + "NOTE: You may need to configure your system "
//                        + "as described in chapter 14.<br>"
//                        + "ERROR MESSAGE: " + e.getMessage();
//                request.setAttribute("errorMessage", errorMessage);
//                this.log(
//                        "Unable to send email. \n"
//                        + "Here is the email you tried to send: \n"
//                        + "=====================================\n"
//                        + "TO: " + email + "\n"
//                        + "FROM: " + from + "\n"
//                        + "SUBJECT: " + subject + "\n\n"
//                        + body + "\n\n");
//            }
//            url = "/thanks.jsp";
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}