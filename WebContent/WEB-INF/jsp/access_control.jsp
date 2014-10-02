<%-- 
    Document   : Access Controll
    Created on : 7 Sept, 2014
    Author     : Bhavik
--%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>        
        <jsp:include page="header.jsp" />
        <script type="text/javascript">
            function changeSecurityLevel() {
                if ($("#acl_security_level").val() != -1) {
                    $("#categoryId").val($("#acl_security_level").val());
                    $("#securityForm").submit();
                } else {
                    alert('<spring:message code="message.accesstype.invalidseclevel" text="Message value is missing !!!"/>');
                }
            }
        </script>

    </head>
    <body role="document">
        <form method="POST" action="access_control.html" id="securityForm">
            <input type="hidden" name="categoryId" id="categoryId" value="">
        </form>
        <jsp:include page="headermenu.jsp" />
        <div class="container">
            <div class="row container">
                <div class="dashboard_main">
                    <div class="desh-icon-bg">
                        <img src="img/i-mgmt.png">
                    </div>
                    <div class="page-title-text"><spring:message code="label.accesstype.accetypemanagement" text="Label value is missing !!!"/></div>
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
                <div class="col-md-9">
                    <div class="catagory-main-box top-radius">
                        <div class="cat-box-title cat-title-font top-radius"><spring:message code="label.accesstype.accetypemanagement" text="Label value is missing !!!"/></div>
                        <spring:message text="Default Text" code="employeecategory.search.placeholder" var="search"/>
                        <div class="tab-content">
                            <div class="tab-pane active" id="demo">
                                <div class="row tb-margin">
                                    <div class="col-sm-10">
                                        <center><div class="dataTables_length" id="dttable_length">
                                                <label>Employee Category&nbsp;&nbsp;
                                                    <select name="dttable_length" id="acl_security_level" aria-controls="dttable" onchange="changeSecurityLevel();">
                                                        <option value="-1">Select</option>
                                                        <c:forEach var="employeeCategory" items="${employeeCategoryList}">
                                                            <option value="${employeeCategory.id}"  <c:if test="${categoryId == employeeCategory.id}"> SELECTED </c:if> >${employeeCategory.category}</option>
                                                        </c:forEach>
                                                    </select>
                                                </label>
                                            </div>
                                        </center>
                                    </div>
                                </div>
                                <form id="updateACL" name="updateACL" method="POST" action="updateACL.html">
                                    <table class="table table-bordered table-striped" data-filter="#filter" data-page-size="5">
                                        <thead class="orange-bg border-t">
                                            <tr>
                                                <th data-toggle="true">
                                                    <spring:message code="label.accesstype.modules" text="Label value is missing !!!"/>
                                                </th>
                                                <th data-hide="phone">
                                                    <spring:message code="label.accesstype.access" text="Label value is missing !!!"/> 
                                                </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="aclEntity" items="${entityWiseACLDetails}">
                                                <tr>
                                                    <td>${aclEntity.aclModule}</td>
                                                    <td>
                                                        <select name="${aclEntity.aclEntityId}" id="${aclEntity.aclEntityId}" aria-controls="dttable">
                                                            <option value="1"  <c:if test="${aclEntity.permissionLevel == 1}"> SELECTED </c:if> ><spring:message code="label.accesstype.view" text="Label value is missing !!!"/></option>
                                                            <option value="2"  <c:if test="${aclEntity.permissionLevel == 2}"> SELECTED </c:if> ><spring:message code="label.accesstype.create" text="Label value is missing !!!"/></option>
                                                            <option value="3"  <c:if test="${aclEntity.permissionLevel == 3}"> SELECTED </c:if> ><spring:message code="label.accesstype.update" text="Label value is missing !!!"/></option>
                                                            <option value="7"  <c:if test="${aclEntity.permissionLevel == 7}"> SELECTED </c:if> ><spring:message code="label.accesstype.delete" text="Label value is missing !!!"/></option>
                                                            </select>
                                                        </td>
                                                    </tr>                                        
                                            </c:forEach>
                                        </tbody>
                                        <tfoot class="hide-if-no-paging">
                                            <tr>
                                                <td colspan="8">
                                                    <div class="pagination pagination-centered"></div>
                                                </td>
                                            </tr>
                                        </tfoot>
                                    </table>
                                        <input type="submit" value="<spring:message code="label.accesstype.UpdateACLDetails" text="Label value is missing !!!"/>">
                                </form>
                            </div>                            
                        </div>
                    </div>
                </div>
            </div>
            <div class=""></div>
            <div class=""></div>
        </div>
        <!-- /container -->
        <!--Responsive Table-->
        <script type="text/javascript">
        </script>
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.dataTables.min.js"></script>
        <script src="js/dataTables.responsive.min.js"></script>
        <script src="js/ajax-bootstrap3.js"></script>
        <script src="js/docs.min.js"></script>
        <script type="text/javascript">
                                                                $(document).ready(function() {
                                                                    $('.row-delete').click(function(eve) {
                    var row = this;
                                                                    eve.preventDefault();
                                                                        $.ajax({
                                                                            url: $(row).attr('href')
                        , success: function(response) {
                                                                    if (response === true) {
                                                                $(row).closest('tr').remove();
                                                        }
                }
                    });
                    return false;
                });
            });
        </script>
    </body>
</html>
