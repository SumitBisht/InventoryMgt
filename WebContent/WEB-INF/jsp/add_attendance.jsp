<%-- 
    Document   : add_attendance
    Created on : Aug 26, 2014, 11:43:53 PM
    Author     : sweta
--%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <%--<%@include file="header.jsp" %>--%>
        <jsp:include page="header.jsp"></jsp:include>
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
        <jsp:include page="headermenu.jsp"></jsp:include>
            <div class="container">
                <div class="row container">
                    <div class="dashboard_main">
                        <div class="desh-icon-bg">
                            <img src="img/i-mgmt.png">
                        </div>
                        <div class="page-title-text"><spring:message code="add.attendance" text="Default Text"/></div>
                </div>
            </div>	
            <div class="row">
                <div class="col-md-3">
                    <div class="catagory-main-box top-radius">
                        <!--<div class="cat-table-title"></div>-->
                        <!-- MUNU -->    
                        <div id='cssmenu'>
                            <ul>
                                <li class='has-sub active'><a href='employee.html'><span><spring:message code="menu.employeemanagement" text="Label value is missing !!!"/></span></a>
                                    <li class=''><a href='access_control.html'><span><spring:message code="menu.empmanagement.acl" text="Label value is missing !!!"/></span></a></li>
                                <li class=''><a href='payslips_list.html'><span><spring:message code="menu.payslips" text="Label value is missing !!!"/></span></a></li>
                                <li class='last'><a href='#'><span><spring:message code="menu.employeeleavemanagement" text="Label value is missing !!!"/></span></a>
                                    <ul style='display: block;'>
                                        <li><a href='leave_types.html'><span><spring:message code="menu.addleavetype" text="Label value is missing !!!"/></span></a></li>
                                        <li class="active"><a href='hr_attendence.html'><span><spring:message code="menu.attendanceregister" text="Label value is missing !!!"/></span></a></li>
                                        <li class='last'><a href='hr_attendence_report.html'><span><spring:message code="menu.attendancereport" text="Label value is missing !!!"/></span></a></li>
                                        <li class='last'><a href='hr_resetleaves.html'><span><spring:message code="menu.resetleave" text="Label value is missing !!!"/></span></a></li>
                                    </ul>
                                </li>
                                <li class=''><a href='#'><span><spring:message code="menu.settings" text="Label value is missing !!!"/></span></a>
                                    <ul style='display: block;'>
                                        <li><a href='employee_category.html'><span><spring:message code="menu.employeecategory" text="Label value is missing !!!"/></span></a></li>
                                        <li class="active"><a href='employee_department.html'><span><spring:message code="menu.employeedepartment" text="Label value is missing !!!"/></span></a></li>
                                        <li class='last'><a href='payroll_category.html'><span><spring:message code="menu.payrollcategory" text="Label value is missing !!!"/></span></a></li>
                                        <li class='last'><a href='bank.html'><span><spring:message code="menu.bank" text="Label value is missing !!!"/></span></a></li>
                                    </ul>
                                </li>

                            </ul>
                        </div>
                        <!-- END MUNU -->    
                    </div>
                </div>
                <spring:message code="label.payrollcategory.category.placeholder" var="categoryplaceholder" text="Default Text" />
                <spring:message code="label.attendance.date.placeholder" var="attendancedateplaceholder" text="Default Text" />                
                <div class="col-md-9">
                    <div class="catagory-main-box top-radius">
                        <div class="cat-box-title cat-title-font top-radius"><spring:message code="label.attendance" text="Default Text"/></div>
                        <div class="row text-pad-top visible-lg visible-md visible-sm">
                            <form:form action="add_attendance.html" method="POST" modelAttribute="attendance">                                
                                <div class="row tb-margin">
                                    <div class="col-sm-2"></div>
                                    <div class="col-sm-8">
                                        <c:if test="${not empty error}">  
                                            <div class="row text-pad-top visible-lg visible-md visible-sm"><div class="errorblock">${error}</div></div>
                                            </c:if>
                                            <c:if test="${not empty success}">  
                                            <div class="row text-pad-top visible-lg visible-md visible-sm"><div class="successblock">${success}</div></div>
                                            </c:if>

                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.attendance.employee" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">
                                                <form:select class="form-control" path="employeeId">
                                                    <form:options items="${employeeList}" itemLabel="employeeNumber" itemValue="id"/>
                                                </form:select>
                                                <form:errors path="employeeId" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm"><spring:message code="label.attendance.date" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control datepicker" path="attendanceDate" placeholder="${attendancedateplaceholder}" />
                                                <form:errors path="attendanceDate" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.attendance.intime" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">
                                                <form:select class="form-control" path="inHour">
                                                    <form:option value=""><spring:message code="label.attendance.hours.placeholder" text="Default Text"/></form:option>
                                                    <form:options items="${hoursList}"/>
                                                </form:select>
                                                <form:select class="form-control" path="inMinutes">
                                                     <form:option value=""><spring:message code="label.attendance.minutes.placeholder" text="Default Text"/></form:option>
                                                    <form:options items="${minutesList}" />
                                                </form:select>

                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.attendance.outtime" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">
                                                <form:select class="form-control" path="outHour">
                                                    <form:option value=""><spring:message code="label.attendance.hours.placeholder" text="Default Text"/></form:option>
                                                    <form:options items="${hoursList}"/>
                                                </form:select>
                                                <form:select class="form-control" path="outMinutes">
                                                     <form:option value=""><spring:message code="label.attendance.minutes.placeholder" text="Default Text"/></form:option>
                                                    <form:options items="${minutesList}" />
                                                </form:select>

                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.attendance.isleave" text=""/></label>
                                            <div class="col-sm-8 col-xs-12">
                                                <div class="form-control">
                                                    <form:checkbox path="isLeave"/><spring:message code="label.attendance.isleave" text="Default Text"/>

                                                </div>
                                                <form:errors path="isLeave" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.attendance.ishalfday" text=""/></label>
                                            <div class="col-sm-8 col-xs-12">
                                                <div class="form-control">
                                                    <form:checkbox path="isHalfDay"/><spring:message code="label.attendance.ishalfday" text="Default Text"/>

                                                </div>
                                                <form:errors path="isHalfDay" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.attendance.leavetype" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">
                                                <form:select class="form-control" path="employeeLeaveTypeId">
                                                    <form:option value=""><spring:message code="label.attendance.leavetype.placeholder" text="Default Text"/></form:option>
                                                    <form:options items="${employeeLeaveTypeList}" itemLabel="name" itemValue="id"/>
                                                </form:select>
                                                <form:errors path="employeeLeaveTypeId" cssClass="error" />
                                            </div>
                                        </div>

                                        <div class="col-sm-2"></div>
                                    </div>
                                    <div class="div-center">
                                        <button type="submit" class="btn btn-orange" onclick="return submitDetailsForm();"><spring:message code="label.save" text="Default Text"/></button>
                                        <button type="button" class="btn btn-orange" onclick="javascript:history.back();"><spring:message code="label.cancel" text="Default Text"/></button>
                                    </div>
                                </form:form>
                            </div>
                        </div>
                        <!--                        <div class="row text-pad-top visible-xs">
                                                   
                                                </div>-->
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
        <script type="text/javascript">
                                         $('.datepicker').datepicker({dateFormat: 'dd/mm/yy'});
        </script>
    </body>
</html>