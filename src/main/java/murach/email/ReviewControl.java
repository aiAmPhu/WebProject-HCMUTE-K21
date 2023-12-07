package murach.email;

import java.io.*;
//import javax.mail.MessagingException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.*;
import murach.business.Review;
import murach.data.ReviewDB;
//import murach.util.MailUtilLocal;

@WebServlet(urlPatterns = "/review")
public class ReviewControl extends HttpServlet {

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
            String b = request.getParameter("name");
            String c = request.getParameter("phone");
            String d = request.getParameter("subject");
            String e = request.getParameter("feedback");
            Review user = new Review(b,c,d,e);
                // Insert the user into the database
                ReviewDB.insert(user);
                request.setAttribute("user", user);
                url = "/index.jsp";
            
            
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
        request.getRequestDispatcher("contact.jsp").forward(request,response);

    }
}