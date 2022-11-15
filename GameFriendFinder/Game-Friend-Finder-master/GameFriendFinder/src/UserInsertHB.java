import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Info;
import util.UtilDB;

@WebServlet("/UserInsertHB")
public class UserInsertHB extends HttpServlet implements Info {
   private static final long serialVersionUID = 1L;

   public UserInsertHB() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String firstName = request.getParameter("FirstName").trim();
      String lastName = request.getParameter("LastName").trim();
      String userName = request.getParameter("UserName").trim();
      String console = request.getParameter("Console").trim();
      String games = request.getParameter("Games").trim();
      UtilDB.createUsers(firstName, lastName, userName, console, games);

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Database Result";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");
      out.println("<li> Fist Name: " + firstName);
      out.println("<li> Last Name: " + lastName);
      out.println("<li> User Name: " + userName);
      out.println("<li> Console: " + console);
      out.println("<li> Games: " + games);
      out.println("</ul>");
      out.println("<a href=/" + projectName + "/" + thanksforsigning + ">Next</a> <br>");
      out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
