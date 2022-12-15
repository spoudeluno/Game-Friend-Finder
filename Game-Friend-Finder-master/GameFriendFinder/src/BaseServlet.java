import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import datamodel.User;
import util.Info;
import util.UtilDB;

@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public BaseServlet() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html");

      // #1
     UtilDB.createUsers("Lloyd", "Baoumar", "ldb", "playstation","call of");
     // UtilDBbaoumar.createStudents("Lloyd1", "Baoumar1", "728790181", "lb@uno.edu1");
     // UtilDBbaoumar.createStudents("Lloyd2", "Baoumar2", "728790182", "lb@uno.edu2");
      //UtilDBbaoumar.createStudents("Lloyd3", "Baoumar3", "728790183", "lb@uno.edu3");
      
      
      // #2
      retrieveDisplayData(response.getWriter());
   }

   void retrieveDisplayData(PrintWriter out) {
      String title = "Gamers in Database Result";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
            "transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");
      List<User> listUsers = UtilDB.listUsers();
      for (User user : listUsers) {
         System.out.println("[DBG] " + user.getId() + ", " //
               + user.getFirstName() + ", " //
               + user.getLastName() + ", "
               + user.getUserName() + ", "
               + user.getconsole() + ", "
               + user.getgames());

         out.println("<li>" + user.getId() + ", " //
        		 + user.getFirstName() + ", " //
                 + user.getLastName() + ", "
                 + user.getUserName() + ", "
                 + user.getconsole() + ", "
                 + user.getgames());
      }
      out.println("</ul>");
      out.println("<a href=/" + util.Info.projectName + "/" + util.Info.backhome + ">Home</a> <br>");
      out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
