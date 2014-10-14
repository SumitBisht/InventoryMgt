<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <head>
        <%--<%@include file="header.jsp" %>--%>
        <jsp:include page="header.jsp"></jsp:include>
   
   
    </head>

    <body role="document">

        <jsp:include page="headermenu.jsp"></jsp:include>

<div class="container">

<script type="text/javascript">


$(document).ready(function() {  
 setInterval(function() {
    $('#blink').animate( { backgroundColor: 'red' }, 1000)
    .animate( { backgroundColor: 'green' }, 1000); 
    }, 1000);
 });

/////////////////////////////////////////////
///////////////////////////////////////////// 
///////////////////////////////////////////// 
</script>


<div class="row container">
                <div class="dashboard_main">
                    <div class="desh-icon-bg">
                        <img src="img/i-mgmt.png">
                    </div>
                    <div class="page-title-text">Alarms</div>
                </div>
            </div>
            
            
            <div class="col-md-3">
            <div id="cssmenu">
                            <ul>
                               
                                <li class=""><a href="#"><span>Alarms</span></a>
                                    <ul style="display: block;">
                                        <li><a href="alarm.htm"><span>Inventory </span></a></li>
                                        <li class="active"><a href="alarmEmployee.htm"><span>Employee</span></a></li>
                                                 </ul>
                                </li>


                            </ul>
                        </div>
            </div>
             <div class="col-md-6">
                    <div class="catagory-main-box top-radius">
                        <div class="cat-box-title top-radius"></div>

                                    <center>
                                   <table   align="center" >
                                   <c:forEach var="item" items="${list}">
                                   <tr>
                                   <td> 
                                  
                           <a href="UpdateItem.html?updateItemId=${item.id}" >   <div id="blink" >     
                                 ${item.firstName} Is reached to low stock. Remaining stock is ${item.passportExpiryDate} 
                                  </div> </a>
                                   </td>
                                  
                                   </tr>
                                   </c:forEach>
                                   </table>
                                   </center>
                                   
                                   
                                   
                                   
                               
                    </div>
                </div>
                
                
                <div class="col-md-3">
            &nbsp;
            </div>
            
</div>
</body>
</html>