package login.uitil;

public class LoginForm {

	public static String getLoginForm(String username){
		StringBuffer sb=new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>Login</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<h1>Form!!</h1>");
		sb.append("<form action=\"LoginValidateServlet\"></br>");
		sb.append("<input type=\"text\" name=\"username\" value=\""+username+"\"></br>");
		sb.append("<input type=\"text\" name=\"password\" value=\"\"></br>");
		sb.append("<input type=\"submit\" value=\"Login\">");
		sb.append("</form>");
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();
	}
}
