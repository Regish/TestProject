package JavaProject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by sharvanih.s on 06/07/15.
 */
public class CancelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String entry=request.getParameter("q");
        int days= Integer.parseInt(request.getParameter("n"));
        int empid= (Integer)request.getSession().getAttribute("empid");
        try {
            new History().leaveCancel(entry,days,empid);
            request.getRequestDispatcher("views/history.jsp").forward(request,response);
        }catch(ClassNotFoundException ce){
            request.setAttribute("exception",ce);
            request.getRequestDispatcher("views/error.jsp").forward(request,response);
        }catch(SQLException se){
            se.printStackTrace();

            request.setAttribute("exception",se);
            request.getRequestDispatcher("views/error.jsp").forward(request,response);
        }
    }
}
