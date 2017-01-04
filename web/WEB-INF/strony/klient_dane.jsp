<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://www.springframework.org/tags" prefix="spring" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>SSI</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Oswald:300,400,700" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body id="register-wrapper">

	<div class="register-site">

		<div class="register-bar">
	        <nav class="navbar navbar-static-top">
	            <div class="container-fluid">
	                <div class="navbar-option pull-left">
	                    <label>
	                    	<a href="index.html" style="text-decoration: none"><h3 style="color: black">ME&BIKE</h3></a>
	                    </label>
	                </div>
	            </div>
	        </nav>
	    </div>

	    <div class="register-wrapper-inner">	        
             <div class="col-xs-offset-4">
			    <div class="register-form">
			   		<div class="form-group">
			            <label for="inputName">Imie:</label>
			            <input type="name" class="form-control" id="inputName">
			        </div>
			        <div class="form-group">
			            <label for="inputSurname">Nazwisko:</label>
			            <input type="surname" class="form-control" id="inputSurname">
			        </div>

			        <div class="form-group">
			            <label for="inputEmail">Adres email:</label>
			            <input type="email" class="form-control" id="inputEmail">				            
			        </div>
			        
			        <div class="form-group" style="margin-bottom: 20px;">
			            <label for="inputPassword">Hasło:</label>
			            <input type="password" class="form-control" id="inputPassword">
			            <!-- <a href="#" class="tooltip" title="Hasło powinno zawierać min 6 znaków - w tym jedną cyfrę.">Podpowiedź?</a> -->
			            <a class="podpowiedz" href="#">Podpowiedź?<span>Hasło powinno zawierać min 6 znaków - w tym jedną cyfrę.</span></a>
			        </div>
			        <div class="form-group" style="margin-bottom: 30px;">
			            <label for="inputPassword" style="padding-top: 0px;">Powtórz hasło:</label>
			            <input type="password" class="form-control" id="inputPassword">
			        </div>
			        
			        <a href="klient.html"><button class="btn btn-success pull-right">Zapisz zmiany</button></a>
			        <div class="clearfix"></div>			        
			    </div>
		    </div>	    
		</div>




	</div>


<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/script.js"></script>	
</body>
</html>