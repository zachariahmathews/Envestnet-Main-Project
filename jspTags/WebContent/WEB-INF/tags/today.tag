<%@ tag body-content="empty" import="java.text.SimpleDateFormat"%>
<%
SimpleDateFormat sdf=new SimpleDateFormat();
%>
<jsp:useBean id="today" class="java.util.Date" scope="page"/>
Today: ${today.date}/${today.month+1}/${today.year+1900}<br>
<%= sdf.format(new java.util.Date())%>