import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.Event;
import util.UtilDB;

@WebServlet("/MyServletHibernateDB")
public class MyServletHibernateDB extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public MyServletHibernateDB() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html");

      // #1
      UtilDB.createEvents("Joe's Birthday", "0402", 1);
      UtilDB.createEvents("Leo's Birthday", "0331", 2);
      UtilDB.createEvents("The Eagles' Concert", "0326", 3);
      UtilDB.createEvents("My Fake Birthday", "1111", 0);
      
      // #2
      retrieveDisplayData(response.getWriter());
      
      // #3
      //??
   }

   void retrieveDisplayData(PrintWriter out) {
      String title = "Database Result";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
            "transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");
      List<Event> listEvents = UtilDB.listEvents();
      for (Event event : listEvents) {
         System.out.println("[DBG] " + event.getId() + ", " //
               + event.getName() + ", " //
               + event.getDate() + ", " //
               + event.getPeople());

         out.println("<li>" + event.getId() + ", " //
               + event.getName() + ", " //
               + event.getDate() + ", " //
               + event.getPeople() + "</li>");
      }
      out.println("</ul>");
      out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
