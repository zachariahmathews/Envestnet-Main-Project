package searchapp.servlets;

import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import searchapp.bean.SearchItem;
import searchapp.db.SQLConnUtil;
import searchapp.util.SearchForm;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();
		List<SearchItem> items=new ArrayList<SearchItem>();
		SQLConnUtil sqlutil=SQLConnUtil.getInstance();
		Connection conn=sqlutil.openConnection();
		try {
			
			
			Statement st=conn.createStatement();
			if(request.getParameter("g1").equalsIgnoreCase("name")){

				ResultSet rs=st.executeQuery("select * from T_0998_SearchTable");
				while(rs.next()){
					
					String[] splitName=rs.getString("name").split(" ");
					for(String name:splitName){
						
						if(name.equalsIgnoreCase(request.getParameter("searchKey"))){
							
							SearchItem si=new SearchItem(rs.getString("name"), Integer.parseInt(rs.getString("salary")), Integer.parseInt(rs.getString("department")));
							items.add(si);
						}
					}
					
				}


			}
			else{

				ResultSet rs=st.executeQuery("select * from T_0998_SearchTable where department="+request.getParameter("searchKey"));
				while(rs.next()){
					
					//System.out.println(rs.getString("name")+ Integer.parseInt(rs.getString("salary"))+ Integer.parseInt(rs.getString("department")));
					SearchItem si=new SearchItem(rs.getString("name"), Integer.parseInt(rs.getString("salary")), Integer.parseInt(rs.getString("department")));
					items.add(si);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.setAttribute("searchItems", items);
		sqlutil.closeConnection();
		Writer w=response.getWriter();
		w.write(SearchForm.getSearchForm(items));
		w.flush();
		w.close();
	}
}
