package JavaProject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sharvanih.s on 05/07/15.
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn=null;
        String usr=request.getParameter("username");
        String pwd=request.getParameter("password");
        try{
            conn=new DbConnection().DbConnect();
            String query="select * from employees where emp_usr=? and emp_pwd=? ;";
            PreparedStatement st= conn.prepareStatement(query);
            st.setString(1,usr);
            st.setString(2,pwd);
            ResultSet res=st.executeQuery();
            if(!res.first())
            {
                request.setAttribute("error","Invalid username or password");
                request.getRequestDispatcher("views/index.jsp").forward(request,response);
            }
            else {
                HttpSession session = request.getSession();
                session.setAttribute("username", usr);
                session.setAttribute("empid", res.getInt(1));
                request.getRequestDispatcher("views/home.jsp").forward(request, response);

            }
        }catch(ClassNotFoundException ce){
            request.setAttribute("exception",ce);
            request.getRequestDispatcher("views/error.jsp").forward(request,response);
        }catch(SQLException se){
            se.printStackTrace();
            request.setAttribute("exception",se);
            request.getRequestDispatcher("views/error.jsp").forward(request,response);
        }
        finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
