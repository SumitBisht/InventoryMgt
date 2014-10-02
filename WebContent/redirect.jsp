<%--
Views should be stored under the WEB-INF folder so that
they are not accessible except through controller process.

This JSP is here to provide a redirect to the dispatcher
servlet but should be the only JSP outside of WEB-INF.
command to convert the property file...
C:\Users\Aamir Mansuri>"c:\Program Files (x86)\Java\jdk1.6.0_18\bin\native2ascii
.exe"  -encoding utf8 E:\Java\workspace\InvMgmt\src\java\messages_ar.properties
Desktop\messages_ar.properties

--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% response.sendRedirect("dashboard.html"); %>
