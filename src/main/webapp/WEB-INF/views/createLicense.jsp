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
    
    <!-- formValidation CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/bower_components/formValidation/css/formValidation.min.css"/>">
    
    <!-- Custom Fonts -->
    <link rel="stylesheet" href="<c:url value="/resources/bower_components/font-awesome/css/font-awesome.min.css"/>" type="text/css">
    
    <!-- Datetimepicker CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/bower_components/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css"/>" type="text/css">
        
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
                    <h1 class="page-header">Create License</h1>
                </div>
                <!-- /.col-lg-12 -->                                
            </div>
            <!-- /.row -->
            
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Input License Information
                        </div>
                        <div class="panel-body">
	                        <sf:form method="POST" modelAttribute="licenseCreationForm" id="createLicenseForm">	
	                        	<div class="row">
		                        	<div class="col-lg-6">
		                        		<div class="form-group">
		                        			<label>License Name:</label>		                        			
		                        			
		                        			<sf:select path="licenseName" class="form-control">
		                        				<option value="" selected disabled style='display:none;'>Select license you want to apply</option>
	                        					<option value="" >Create a new license name</option>
	                        					<sf:options items="${licenseNameList }"></sf:options>	                        					
		                        			</sf:select>
		                        			<p id="newName" class="help-block" style="display: none;">Type a new name here:</p>
		                        			<input id="txtLicName" class="form-control" type="hidden"/>
		                        				                        			
		                        		</div>
		                        		<div class="form-group">
		                        			<label for="licKey">License Key:</label>
		                        			<sf:input path="licenseKey" type="text" class="form-control"/>	                        			
		                        		</div>
		                        		<div class="form-group">
		                        			<label for="licType">License Type:</label>
		                        			<div class="radio">
		                        				<label>
		                        					<sf:radiobutton path="licenseType" value="OS" required="true"/>
		                        					OS
		                        				</label>
		                        				<label>
		                        					<sf:radiobutton path="licenseType" value="App"/>
		                        				    App
		                        				</label>
		                        			</div>
		                        		</div>
		                        		<div class="form-group">
		                        			<label for="licSite">From Site:</label>
		                        			<sf:select path="fromSite" class="form-control">
		                        				<option value="" disabled selected style='display:none;'>Select your option</option>
		                        				<sf:option value="Wuxi"/>
		                        				<sf:option value="Suzhou" />
		                        				
		                        			</sf:select>	                        			
		                        		</div>
		                        		<div class="form-group">
		                        			<label for="quantity">Quantity:</label>
		                        			<sf:input path="quantity" id="quantity" type="number" min="1" class="form-control" required="true"/>	                        			
		                        		</div>	                        		
		                        		<div class="form-group">
		                        			<label for="price">Price:</label>
		                        			<div class="form-group input-group">
			                        			<span class="input-group-addon">$</span>
			                        			<sf:input path="totalPrice" id="price" type="number" step="any" min="1" class="form-control"/>
			                        		</div>	                        			
		                        		</div>
		                        		
		                        	</div>
	                        		<div class="col-lg-6">
	                        			<div class="form-group">
		                        			<label for="expDate">Expire Date:</label>
							                <div class='input-group date' id='expDate'>
							                    <sf:input path="expireDate" type='text' class="form-control" />
							                    <span class="input-group-addon">
							                        <span class="fa fa-calendar"></span>
							                    </span>
							                </div>
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
    
    <!-- moment JS -->
    <script src="<c:url value="/resources/bower_components/moment/moment.min.js"/>"> </script>
    
    <!-- DatetimePicker JS -->
    <script src="<c:url value="/resources/bower_components/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"/>"></script>
    
    <!-- Custom Theme JavaScript -->
    <script src="<c:url value="/resources/dist/js/sb-admin-2.js"/>"></script>
    
    <!-- formValidation JavaScript -->
    <script src="<c:url value="/resources/bower_components/formValidation/js/formValidation.min.js"/>"></script>
    <script src="<c:url value="/resources/bower_components/formValidation/js/framework/bootstrap.min.js"/>"></script>
        
    <!-- Initial Datetimepicker -->
    <script type="text/javascript">
	    jQuery(function () {
	        jQuery('#expDate').datetimepicker({
	        	format:'YYYY-MM-DD'	
	    	});
	        $('#licenseName').change(function(){
	        	if($(this).val() == ""){
	        		$("#txtLicName").attr('name','licenseName').attr('type',"text");	        		
	        		$("#licenseName").removeAttr("name");
	        		$('#newName').removeAttr('style');
	        	}else{
	        		$("#txtLicName").removeAttr('name').attr('type','hidden');
	        		$("#licenseName").attr('name','licenseName');
	        		$('#newName').attr('style','display: none;');
	        	}
	        });
	        
	        $('#home,#license').addClass('in');
	        
	        $('#createLicenseForm').formValidation({
	        	framework: 'bootstrap',
    			icon: {
    				valid: 'glyphicon glyphicon-ok',
    				invalid: 'glyphicon glyphicon-remove',
    				validating: 'glyphicon glyphicon-refresh'
    			},
    			fields: {
    				fromSite:{
    					validators:{
    						notEmpty: {
    							message: 'The Site is required and cannot be empty'
    						}
    					}
    				},
    				license:{
    					selector: '#txtLicName',
    					validators:{
    						notEmpty: {
    							message: 'The License Name is required and cannot be empty'
    						}
    					}
    				}
    			}
	        });
	    });
    </script>
    
</body>
</html>