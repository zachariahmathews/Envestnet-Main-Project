package searchapp.util;

import java.io.Writer;
import java.util.List;

import searchapp.bean.SearchItem;

public class SearchForm {

	public static String getSearchForm(List<SearchItem> items){
		
		StringBuffer sb=new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>Login</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<h1>Search and display</h1>");
		sb.append("<form action=\"SearchServlet\">");
		sb.append("<table>");
		sb.append("<tr>");
		sb.append("<td>Search by Name</td>");
		sb.append("<td>:&nbsp;<input type=\"radio\" name=\"g1\" onclick=\"setName()\" value=\"name\"></td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append("<td>Search by Dept</td>");
		sb.append("<td>:&nbsp;<input type=\"radio\" name=\"g1\" onclick=\"setDept()\" value=\"dept\"></td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append("<td>Search by <div id=\"searchBy\"></div></td>");
		sb.append("<td>:&nbsp;<input type=\"text\" name=\"searchKey\"></td>");
		sb.append("<td><input type=\"submit\" value=\"Search\"></td>");
		sb.append("</tr>");
		sb.append("</table>");
		sb.append("</form></br>");
		sb.append("<table width=\"500px\">");
		sb.append("<tr>");
		sb.append("<td><a href=\"SortServlet?type=name\">Name</a></td>");
		sb.append("<td><a href=\"SortServlet?type=salary\">Salary</a></td>");
		sb.append("<td>Dept</td>");
		sb.append("</tr>");
		if(items!=null){
			
			for(SearchItem item:items){
				
				sb.append("<tr>");
				sb.append("<td>"+item.getName()+"</td>");
				sb.append("<td>"+item.getSalary()+"</td>");
				sb.append("<td>"+item.getDepartment()+"</td>");
				sb.append("</tr>");
			}
		}
		sb.append("</table>");
		sb.append("<script type=\"text/javascript\" src=\"script.js\"></script>");
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();
	}
}
