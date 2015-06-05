<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

    <!-- DataTables CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css"/>" >

	<!-- DataTables Responsive CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/bower_components/datatables-responsive/css/dataTables.responsive.css"/>">

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
                    <h1 class="page-header">Apply License</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <div class="row">
            	<div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Apply licenses for host
                        </div>
                        <div class="panel-body">
                        	<sf:form modelAttribute="asn">
                        		<div class="col-lg-6">
                        			<div class="form-group">
                        				<label>License Name:</label>                        			
	                        			<sf:select path="invId" class="form-control">
	                        				<option value="" disabled selected style='display:none;'>Select your option</option>
	                        				<sf:options items="${licNameList }"></sf:options>
	                        			</sf:select>
	                        			<p class="form-control-static" id="leftNum">NUMBER license(s) left.</p>
                        			</div>
                        			<div class="form-group">
                        				<label>Host Name:</label>
                        				<sf:select path="hostId" class="form-control" >
                        					<option value="" disabled selected style='display:none;'>Select your option</option>                        					
		                        			<sf:options items="${hostnameList }"></sf:options>
	                        			</sf:select>
                        			</div>
                        			<div class="form-group">
                        				<h3>Apply Number:</h3>                        				
                        				<sf:input path="quantity" type="number" class="form-control text-center" min="1" required="true"/>                        				                        
                        			</div>
                        			<button type="submit" class="btn btn-primary">Confirm</button>
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
    
    <!-- DataTables JavaScript -->
    <script src="<c:url value="/resources/bower_components/datatables/media/js/jquery.dataTables.min.js"/>"></script>
    <script src="<c:url value="/resources/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"/>"></script>
    <script src="<c:url value="/resources/bower_components/datatables-responsive/js/dataTables.responsive.js"/>"></script>
    
    <!-- Custom Theme JavaScript -->
    <script src="<c:url value="/resources/dist/js/sb-admin-2.js"/>"></script>
    
    <script>
    	$(document).ready(function() {
    		var map = {
    			<c:forEach items="${leftNum}" var="item" varStatus="loop">
    				'${item.key}': '${item.value}' ${not loop.last ? ',':''}
    			</c:forEach>
    		};
    		
    		$('#invId').change(function(){
    			var index = $(this).children(":selected").val();
    			var left = map[index];
    			$('#leftNum').html("<font color='#d9534f'><strong>" + left+ "</strong></font>" +" license(s) left.");
    			$('#quantity').attr('max',left);
    		});
    	});
    </script>
    
</body>
</html>