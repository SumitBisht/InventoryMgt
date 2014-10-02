<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <%--<%@include file="header.jsp" %>--%>
        <jsp:include page="header.jsp" />
        <script type="text/javascript">
            function submitDetailsForm() {
                return true;
            }
        </script>
        <style>
            .error {
                color: #ff0000;
            }
            .errorblock {
                color: #000;
                background-color: #ffEEEE;
                border: 3px solid #ff0000;
                padding: 8px;
                margin: 16px;
            }
        </style>
    </head>
    <body role="document">

        <c:if test="${bank.id == null}">
            <c:set var="formaction" value="add-bank.html" />
            <spring:message code="label.bank" text="Default Text" var="pagetitletext" />
            <spring:message code="label.add.bank" text="Default Text" var="catboxtitle" />
            <spring:message code="label.bank.save" text="Default Text" var="savebutton" />
        </c:if>
        <c:if test="${bank.id != null}">
            <c:set var="formaction" value="edit-bank.html?id=${bank.id}" />
            <spring:message code="label.bank" text="Default Text" var="pagetitletext" />
            <spring:message code="label.edit.bank" text="Default Text" var="catboxtitle" />
            <spring:message code="label.bank.update" text="Default Text" var="savebutton" />
        </c:if>
        <jsp:include page="headermenu.jsp" />
        <div class="container">
            <div class="row container">
                <div class="dashboard_main">
                    <div class="desh-icon-bg">
                        <img src="img/i-mgmt.png">
                    </div>
                    <div class="page-title-text">${pagetitletext}</div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-3">
                    <div class="catagory-main-box top-radius">
                        <!--<div class="cat-table-title"></div>-->
                        <!-- MUNU -->    
                        <div id='cssmenu'>
                            <%@include  file="finance_mgt_menu.jsp" %>
                        </div>
                        <!-- END MUNU -->    
                    </div>  
                </div>
                <div class="col-md-9">
                    <div class="catagory-main-box top-radius">
                        <div class="cat-box-title cat-title-font top-radius">${catboxtitle}</div>
                        <form:form action="${formaction}" method="post" modelAttribute="bank">
                            <form:hidden path="id"/>
                            <div class="row tb-margin">
                                <div class="col-sm-2"></div>
                                <div class="col-sm-8">
                                    <c:if test="${not empty error}">  
                                        <div class="row text-pad-top"><div class="errorblock">${error}</div></div>
                                        </c:if>
                                        <c:if test="${not empty success}">  
                                        <div class="row text-pad-top"><div class="successblock">${success}</div></div>
                                        </c:if>
                                    <div class="form-group">
                                        <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm"><spring:message code="label.bank.name" text="Default Text"/></label>
                                        <div class="col-sm-8 col-xs-12">
                                            <form:input type="text" class="form-control" path="name" placeholder="Name" />
                                            <form:errors path="name" cssClass="error" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm"><spring:message code="label.bank.address1" text="Default Text"/></label>
                                        <div class="col-sm-8 col-xs-12">                                            
                                            <form:input type="text" class="form-control" path="address1" placeholder="Address1" />
                                            <form:errors path="address1" cssClass="error" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm"><spring:message code="label.bank.address2" text="Default Text"/></label>
                                        <div class="col-sm-8 col-xs-12">                                            
                                            <form:input type="text" class="form-control" path="address2" placeholder="Address2" />
                                            <form:errors path="address2" cssClass="error" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm"><spring:message code="label.bank.city" text="Default Text"/></label>
                                        <div class="col-sm-8 col-xs-12">                                            
                                            <form:input type="text" class="form-control" path="city" placeholder="City" />
                                            <form:errors path="city" cssClass="error" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm"><spring:message code="label.bank.country" text="Default Text"/></label>
                                        <div class="col-sm-8 col-xs-12">
                                            <form:select class="form-control" path="countryId">
                                                <form:option value=""><spring:message code="label.bank.country.placeholder" text="Default Text"/></form:option>
                                                <form:options items="${countryList}" itemLabel="name" itemValue="id" />
                                            </form:select>
                                            <form:errors path="countryId" cssClass="error" />
                                        </div>
                                    </div>

                                    <div class="col-sm-2"></div>
                                </div>
                                <div class="div-center">
                                    <input type="submit" class="btn btn-orange" onclick="return submitDetailsForm();" value="${savebutton}" />
                                    <button type="button" class="btn btn-orange" onclick="javascript:history.back();"><spring:message code="label.purorder.cancel" text="Default Text"/></button>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
                <div class=""></div>
                <div class=""></div>
            </div>
        </div>
        <!-- /container -->
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="js/bootstrap.min.js"></script>
        <!-- Jquery UI Javascript -->
        <script src="js/jquery-ui.js"></script>
       
    </body>
</html>