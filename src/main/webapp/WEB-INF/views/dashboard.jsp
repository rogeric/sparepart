<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
        
	<title>Sparepart Management</title>

    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/bower_components/bootstrap/dist/css/bootstrap.min.css"/>">
    
    <!-- MetisMenu CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/bower_components/metisMenu/dist/metisMenu.min.css"/>">

    <!-- Timeline CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/dist/css/timeline.css"/>">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/dist/css/sb-admin-2.css"/>">
    
    <!-- Morris Charts CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/bower_components/morrisjs/morris.css"/>">
    
    <!-- Custom Fonts -->
    <link rel="stylesheet" href="<c:url value="/resources/bower_components/font-awesome/css/font-awesome.min.css"/>" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div id="wrapper">
		<jsp:include page="./template/navigation.jsp"></jsp:include>
		
		<div id="page-wrapper">
			<div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Dashboard</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <div class="row">
            	<div class="col-lg-8">
            		<div class="panel panel-default">
            			<div class="panel-heading">
                            <i class="fa fa-bar-chart-o fa-fw"></i> License Assignment Status
                        </div>
                        <div class="panel-body">
                        	<div id="assignment-bar-chart"></div>
                        </div>
                    </div>
            	</div>
            	<!-- col-lg-8 -->
            	
            	<div class="col-lg-4">
            		<div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-bell fa-fw"></i> Notifications Panel
                        </div>
                        <div class="panel-body">
                        	<div class="list-group">
                        		<c:if test="${empty lieList}">
                        			<a href="#" class="list-group-item">
                        				<i class="fa fa-thumbs-o-up fa-fw text-success"></i><c:out value="No issue found!" />
                        			</a>
                        		</c:if>
                        		<c:forEach var="lie" items="${lieList }">
                        			<a href="#" class="list-group-item">
                        				<i class="fa fa-warning fa-fw text-danger"></i><c:out value="${lie.licenseName} has been exceed occupied!" />
                        			</a>
                        		</c:forEach>
                        	</div>
                        </div>
                    </div>
            	</div>
            </div>
		</div>
	</div>
	<!-- /#wrapper -->
	
	<!-- jQuery -->
    <script src="<c:url value="/resources/bower_components/jquery/dist/jquery.min.js"/>"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"/>"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<c:url value="/resources/bower_components/metisMenu/dist/metisMenu.min.js"/>"></script>
    
    <!-- Custom Theme JavaScript -->
    <script src="<c:url value="/resources/dist/js/sb-admin-2.js"/>"></script>
    
    <!-- Morris Charts JavaScript -->
    <script src="<c:url value="/resources/bower_components/raphael/raphael-min.js"/>"></script>
    <script src="<c:url value="/resources/bower_components/morrisjs/morris.min.js"/>"></script>
    
    <script>
    	$(document).ready(function(){
    		Morris.Bar({
    			element: 'assignment-bar-chart',
    			data: [${data}],
    			xkey: 'name',
    			ykeys: ['occupied','available'],
    			stacked: true,
    			labels: ['Occupied','Available']
    		});
    		
    		$('#home,#license').addClass('in');
    	});
    </script>
</body>
</html>