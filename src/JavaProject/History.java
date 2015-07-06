package JavaProject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by sharvanih.s on 06/07/15.
 */
public class History {
    public List<String> getHistory(String from,String to,int empid) throws IOException, SQLException, ClassNotFoundException {
        Connection conn=new DbConnection().DbConnect();
        List<String> leaves=new ArrayList<String>() ;
        String query="select *,(leave_to - leave_from) from leaves where leave_from>=? and leave_to<=? and emp_id=? ;";
        PreparedStatement st=conn.prepareStatement(query);
        st.setString(1,from);
        st.setString(2,to);
        st.setInt(3, empid);
        ResultSet res=st.executeQuery();

        while(res.next()){
            //entry|leave_from|leave_to|leave_status|applied_on|days
            String entry=res.getInt(1)+"_"+res.getString(3)+"_"+res.getString(4)+"_"+res.getString(5)+"_"+res.getString(6)+"_"+res.getString(7);
            leaves.add(entry);
        }
        st.close();
        conn.close();

        return leaves;
    }
    public void leaveCancel(String entry,int days,int empid) throws IOException, SQLException, ClassNotFoundException {
        Connection conn=new DbConnection().DbConnect();
        String query ="update leaves set leave_status=? where entry=?;";
        PreparedStatement st=conn.prepareStatement(query);
        st.setString(1,"C");
        st.setString(2,entry);
        st.executeUpdate();
        query="update employees set " +
                "pending_leaves=pending_leaves+?, " +
                "applied_leaves=applied_leaves-?," +
                "cancelled_leaves=cancelled_leaves+? " +
                " where empid=?;";
        st=conn.prepareStatement(query);
        st.setInt(1,days); st.setInt(2,days); st.setInt(3,days);
        st.setInt(4,empid);
        st.executeUpdate();
        st.close();
        conn.close();

    }
}
