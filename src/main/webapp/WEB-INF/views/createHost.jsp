<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

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
                    <h1 class="page-header">Create Host</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Input Host Information
                        </div>
                        <div class="panel-body">
	                        <sf:form method="POST" modelAttribute="hoe">	
	                        	<div class="row">
		                        	<div class="col-lg-6">
		                        		<div class="form-group">
		                        			<label>Host Name:</label>		                        			
		                        			<sf:input path="hostname" class="form-control" placeholder="Enter host name here." required="true"/>	                        			
		                        		</div>
		                        		<div class="form-group">
		                        			<label>Host Type:</label>
		                        			<div class="radio">
		                        				<label>
		                        					<sf:radiobutton path="hostType" value="Virtual" required="true"/>
		                        					Virtual
		                        				</label>
		                        				<label>
		                        					<sf:radiobutton path="hostType" value="Physical" />
		                        				    Physical
		                        				</label>
		                        			</div>                      			
		                        		</div>
		                        		<div class="form-group">
		                        			<label>Serial Number:</label>		                        			
		                        			<sf:input path="serialNumber" class="form-control" placeholder="Enter serial number here."/>
		                        		</div>
		                        		<div class="form-group">
		                        			<label>Number of CPU:</label>		                        			
		                        			<sf:input path="noOfCpu" type="number" min="1" class="form-control"  required="true"/>	                        			
		                        		</div>
		                        		<div class="form-group">
		                        			<label>IP Address:</label>		                        			
		                        			<sf:input path="ip" class="form-control" placeholder="Enter IP Address here."/>
		                        		</div>
		                        		<div class="form-group">
		                        			<label>Location:</label>		                        			
		                        			<sf:input path="location" class="form-control" placeholder="Enter location here."/>
		                        		</div>		                        		
		                        		
		                        	</div>
	                        		
	                        	</div>
	                        	<div class="row">
	                        		<div class="col-lg-12">
		                        		<button type="submit" class="btn btn-default">Submit Button</button>
		                        		<button type="reset" class="btn btn-default">Reset Button</button>
		                        	</div>
	                        	</div>
	                        </sf:form>
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
    
    <script>
    	$(document).ready(function(){
    		$('#home,#host').addClass('in');
    	})
    </script>
</body>
</html>