package murach.email;

import java.io.*;
import java.util.List;
//import javax.mail.MessagingException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.*;
import murach.business.Users;
import murach.data.UsersDB;
//import murach.util.MailUtilLocal;

@WebServlet(name = "login", value = "/login")
public class LoginControl extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String url = "/index";
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";
        }
        if (action.equals("join")) {
            url = "/index";
        } else if (action.equals("add")) {
//            String a = "a";
            String b = request.getParameter("username");
            String c = request.getParameter("password");
            String d = request.getParameter("remember");
//            String d = request.getParameter("firstname");
//            String e = request.getParameter("lastname");
//            String f = request.getParameter("phonenumber");
//            String g = request.getParameter("address");
//            String h = "0";
//            String address="aaaa";
//            String role="aaaa";
//            Users user = new Users(b,c,d,e,f,g,h);

//            Users user=new Users();
//            if (UserDB.selectUser(b,c) !=null){
//                request.setAttribute("user", user);
//                url = "/index.jsp";}
//            else{
//                request.setAttribute("mess", "wrong username or password");
//                url = "/index_1.jsp";
//            }
            List<Users> users = UsersDB.selectUser(b, c);
                
            if (!users.isEmpty()) {
                // User authenticated successfully
                Users authenticatedUser = users.get(0); //lay cot dau tien cot 0
                int userId = authenticatedUser.getUserid();
                String role=authenticatedUser.getRoless();
                // Ki?m tra xem role c? gi? tr? hay kh?ng
                if ("0".equals(role))
                {
                    System.out.println("UserID:           " + userId);
                    request.setAttribute("user", users.get(0));
    //                url = "/index.jsp";
                    HttpSession session=request.getSession();
                    session.setAttribute("acc",users);
                    Cookie u=new Cookie("username",b);
                    Cookie p=new Cookie("password",c);
                    Cookie r=new Cookie("role",role);
                    // Chuy?n ??i int th?nh chu?i
                    String userIdString = String.valueOf(userId);
                    Cookie id=new Cookie("userId", userIdString);
                    u.setMaxAge(1000); //c?i ??t th?i gian t?n t?i cookie tr?n tr?nh duy?t
                    id.setMaxAge(1000);
                    if (d!=null ) {
                        p.setMaxAge(1000);
    //                    response.addCookie(p);
                    }
                    else {
                        p.setMaxAge(0);
                    }
    //                p.setMaxAge(30);
                    response.addCookie(u);
                    response.addCookie(p);
                    response.addCookie(id);
                    response.sendRedirect(request.getContextPath() + "/index");
                }
                else
                {
                    request.setAttribute("user", users.get(0));
                    response.sendRedirect(request.getContextPath() + "/indexAdmin.jsp");
                }
            } else {
                // Authentication failed
                request.setAttribute("mess", "Wrong username or password");
                response.sendRedirect(request.getContextPath() + "/login");
            }
                
        }
        else if (action.equals("logout")) {
            // X?a cookie "username"
            Cookie usernameCookie = new Cookie("username", "");
            usernameCookie.setMaxAge(0);
            response.addCookie(usernameCookie);

            // X?a cookie "password"
            Cookie passwordCookie = new Cookie("password", "");
            passwordCookie.setMaxAge(0);
            response.addCookie(passwordCookie);

            // X?a cookie "userId"
            Cookie userIdCookie = new Cookie("userId", "");
            userIdCookie.setMaxAge(0);
            response.addCookie(userIdCookie);
            
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        doPost(request, response);
        Cookie arr[]=request.getCookies();
        if (arr !=null) {
            for (Cookie o :arr){
                if (o.getName().equals("userId")) {
                    // Chuy?n ??i gi? tr? t? chu?i sang int
                    int userId = Integer.parseInt(o.getValue());
                }
                if (o.getName().equals("username")){
                    request.setAttribute("username",o.getValue());
                }
                if (o.getName().equals("password")){
                    request.setAttribute("password",o.getValue());
                }
            }
        }
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }
}