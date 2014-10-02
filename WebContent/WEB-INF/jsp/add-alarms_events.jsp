<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <%--<%@include file="header.jsp" %>--%>
        <jsp:include page="header.jsp"></jsp:include>
        </head>

        <body role="document">

        <jsp:include page="headermenu.jsp"></jsp:include>

        <div class="container">
            <div class="row container">
                <div class="dashboard_main">
                    <div class="desh-icon-bg">
                        <img src="img/i-mgmt.png">
                    </div>
                    <div class="page-title-text">Add Alarm Events</div>
                </div>
            </div>	
            <div class="row">
                <div class="col-md-3">
                    <div class="catagory-main-box top-radius">

                        <!--<div class="cat-table-title"></div>-->
                        <!-- MUNU -->    
                        <div id='cssmenu'>
                            <ul>
                                <li class=''><a href='alarms.html'><span>Alams</span></a></li>
                                <li class='active'><a href='alarms_events.html'><span>Alams Event</span></a></li>
                            </ul>
                        </div>
                        <!-- END MUNU -->    

                    </div>
                </div>
                <div class="col-md-9">
                    <div class="catagory-main-box top-radius">
                        <div class="cat-box-title cat-title-font top-radius">Add Alarm List</div>

                        <div class="row tb-margin">
                            <div class="col-sm-2"></div>
                            <div class="col-sm-8 visible-lg visible-md visible-sm">

                                <div class="form-group">
                                    <label class="col-sm-4 col-xs-12 control-label search-text"> Alarm event:</label>
                                    <div class="col-sm-8 col-xs-12">
                                        <input id="filter" class="form-control" type="text"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-4 col-xs-12 control-label search-text">Alarm name:</label>
                                    <div class="col-sm-8 col-xs-12">
                                        <select class="form-control">
                                            <option>Select</option>
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-4 col-xs-12 control-label search-text"> Time:</label>
                                    <div class="col-sm-8 col-xs-12">
                                        <input id="filter" class="form-control" type="text"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-4 col-xs-12 control-label search-text">Next execution:</label>
                                    <div class="col-sm-8 col-xs-12">
                                        <input id="filter" class="form-control" type="text"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-4 col-xs-12 control-label search-text">Expiry date:</label>
                                    <div class="col-sm-8 col-xs-12">
                                        <input id="filter" class="form-control" type="text"/>
                                    </div>
                                </div>

                            </div>

                            <div class="col-sm-8 visible-xs">

                                <div class="form-group">
                                    <div class="col-xs-12">
                                        <input id="filter" class="form-control" type="text" placeholder="Alarm event:"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-sm-8 col-xs-12">
                                        <select class="form-control">
                                            <option>Alarm name:</option>
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-sm-8 col-xs-12">
                                        <input id="filter" class="form-control" type="text" placeholder="Time:"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-sm-8 col-xs-12">
                                        <input id="filter" class="form-control" type="text" placeholder="Next execution:"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-sm-8 col-xs-12">
                                        <input id="filter" class="form-control" type="text" placeholder="Expiry date:"/>
                                    </div>
                                </div>

                            </div>


                            <div class="col-sm-2"></div>
                        </div>
                        <div class="row text-pad-top visible-lg visible-md visible-sm">
                            <div class="div-center">
                                <button type="button" class="btn btn-orange">Save</button>
                                <button type="button" class="btn btn-orange">Cancel</button>
                            </div>
                        </div>
                        <div class="row text-pad-top visible-xs ">
                            <div class="div-center-xs">
                                <button type="button" class="btn btn-orange">Save</button>
                                <button type="button" class="btn btn-orange">Cancel</button>
                            </div>
                        </div>


                    </div>
                </div>

            </div>

            <div class=""></div>
            <div class=""></div>


        </div>
        <!-- /container -->


        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
