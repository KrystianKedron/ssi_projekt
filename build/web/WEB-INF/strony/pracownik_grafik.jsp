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

    <!-- kalendarz pochodzi z http://bootsnipp.com/snippets/j20Mj -->
</head>

<body id="admin-wrapper">

    <div class="admin-site">
        <nav class="navbar navbar-static-top">
            <div class="container-fluid">
                <div class="navbar-option pull-left">
                    <label>
                        <a href="index.html" style="text-decoration: none"><h3 style="color: black">ME&BIKE</h3></a>
                    </label>
                </div>
                <div class="navbar-option pull-right">
                    <a href="index.html" class="pull-right"><p>Wyloguj</p></a>
                    <a href="#" class="pull-right"><p>Jan Kowalski <i class="fa fa-caret-down" aria-hidden="true"></i></p></a>
                </div>
            </div>
        </nav>
        <div class="sidebar-left">
            <div class="sidebar-option">
                <span class="sidebar-option-title">Pracownik</span>
                <ul>
                     <li><a href="pracownikZadania.html"><i class="fa fa-check-circle" aria-hidden="true"></i> Moje zadania</a></li>
                    <li><a href="#"><i class="fa fa-gg-circle" aria-hidden="true"></i> Grafik</a></li>
                    <li><a href="pracownikCennik.html"><i class="fa fa-money" aria-hidden="true"></i> Cennik usług</a></li>
                </ul>
            </div>
           
        </div>
        <div class="main-wrapper" style="min-width: 850px">
            <div class="main-wrapper-inner" >

                <div class="main-panel" >
                    <div id="kalendarz" style="float: left; padding: 10%; padding-top: 0; margin-bottom: 0; padding-bottom: 0;" >
                         
                        <div id="calendar" style="max-height: 450px"></div>                   
                   </div>
                </div>
            </div>
        </div>

    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="<c:url value="js/calendar.js" />"></script>
</body>
</html>
