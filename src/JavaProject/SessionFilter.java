package JavaProject;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by sharvanih.s on 06/07/15.
 */
public class SessionFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpreq= (HttpServletRequest) req;
        HttpServletResponse httpresp = (HttpServletResponse) resp;
        HttpSession ses=httpreq.getSession();
        httpresp.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
        httpresp.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
        httpresp.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
        httpresp.setHeader("Pragma", "no-cache"); //HTTP 1.0 backward compatibility
        String usr= (String) ses.getAttribute("username");
        if (usr!=null) {
            //System.out.println(((HttpServletRequest) req).getServletPath());
            if (usr.equals("null")) {
                httpreq.setAttribute("error", "Invalid Session.");
                httpreq.getRequestDispatcher("index.jsp").forward(httpreq, httpresp);
            }
        }
        else
        {
           // System.out.println(((HttpServletRequest) req).getServletPath());
            //System.out.println(ses.getCreationTime());

            //System.out.println("null session");
        }

        chain.doFilter(httpreq, httpresp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
