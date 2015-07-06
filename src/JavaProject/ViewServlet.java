package JavaProject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by sharvanih.s on 06/07/15.
 */
public class ViewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fromDate=request.getParameter("fromDate");
        String toDate=request.getParameter("toDate");
        int empid= (Integer)request.getSession().getAttribute("empid");
        List<String> leaves;
        try {
            leaves=new History().getHistory(fromDate,toDate,empid);
            if(leaves.isEmpty()){
                request.setAttribute("error","No leaves in this range");
            }
            else{
                request.setAttribute("leaves",leaves);
            }
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
