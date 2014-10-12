    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <jsp:useBean id="today" class="java.util.Date" scope="page" />
    
<!-- Fixed navbar -->
<header role="banner" id="top" class="header1">
    <div class="container logo_paddingtop">
        <div class="navbar-header">
            <div class="container">
                <a href="index.htm">
                    <img  src="img/logo.jpg" width="150" height="150" class="logo img-responsive visible-sm visible-ms visible-lg">
                </a>
                <a href="index.htm">
                    <img src="img/mobile-logo.jpg" class="logo img-responsive visible-xs">
                </a>

                <div class="user-details-box">
                    <a href="#"><spring:message code="header.home"/></a> | <a href="<%= request.getContextPath()%>/logout.htm"><spring:message code="header.logout"/></a><br>
                    <fmt:formatDate value="${today}" pattern="EEEE - HH:m" /><br>
                    <fmt:formatDate value="${today}" pattern="MMMM d,yyyy" /><br>
                    <span class="normal-text">Welcome admin<br></span>
                    <a href="?lang=en">English</a> | <a href="?lang=ar">Arabic</a>
                </div>

            </div>
        </div>
    </div>
</header>

<div role="navigation" class="navbar navbar-default navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <button data-target=".navbar-collapse" data-toggle="collapse" class="navbar-toggle" type="button">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="item.html"><spring:message code="menu.invmgmt"/></a></li>
                <li><a href="employee.html"><spring:message code="menu.hr"/></a></li>
                <li><a href="finance_management.html"><spring:message code="menu.finance"/></a></li>
                               <li><a href="#contact"><spring:message code="menu.cashier"/></a></li>
                               <li><a href="#contact"><spring:message code="menu.purchase"/></a></li>
                               <li><a href="#contact"><spring:message code="menu.approve"/></a></li>
               
               
                <li><a href="#contact"><spring:message code="menu.reports"/></a></li>
                <li><a href="#contact"><spring:message code="menu.setting"/></a></li>
                <li><a href="alarm.htm"><spring:message code="menu.alarms"/></a></li>
            </ul>

        </div><!--/.nav-collapse -->
    </div>
</div>