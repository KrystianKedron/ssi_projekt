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
                    <a href="#" class="pull-right"><p>Gabriela Maj <i class="fa fa-caret-down" aria-hidden="true"></i></p></a>
                </div>
            </div>
        </nav>
        <div class="sidebar-left">
            
            <div class="sidebar-option">
                <span class="sidebar-option-title">Klient</span>
                <ul>
                    <li><a href="klientDane.html"><i class="fa fa-address-card-o" aria-hidden="true"></i> Moje dane</a></li>
                    <li><a href="klientZamow.html"><i class="fa fa-bicycle" aria-hidden="true"></i> Zamów usługę</a></li>
                    <li><a href="klientStatus.html"><i class="fa fa-question-circle-o" aria-hidden="true"></i> Status zamówienia</a></li>
                    <li><a href="#"><i class="fa fa-money" aria-hidden="true"></i> Cennik usług</a></li>
                </ul>
            </div>
        </div>

        <div class="main-wrapper">
            <div class="main-wrapper-inner">

                <div class="main-panel">
                    <h3 class="text-center">Cennik usług</h3>


                    <!-- *****************************************poszczególne zespoły *************************************** -->
                    <h4><a href="#colZespoly" data-toggle="collapse" style="text-decoration: none">SERWIS POSZCZEGÓLNYCH ZESPOŁÓW</a></h4>

                    <div id="colZespoly" class="panel-group collapse">

                        <div class="panel panel-default">
                            <a href="#colHamulce" data-toggle="collapse" data-parent="#colZespoly" style="text-decoration: none"><h5>Hamulce</h5></a>
                            <div id="colHamulce" class="collapse in">
                                <ul>
                                    <li>Regulacje hamulca 10zł</li>
                                    <li>Wymiana i regulacja klocków 10zł</li>
                                    <li>Wymiana linki z regulacją 10zł</li>
                                    <li>Zalanie, odpowietrzenie hamulca tarczowego 45zł</li>
                                </ul>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <a href="#colNaped" data-toggle="collapse" data-parent="#colZespoly" style="text-decoration: none"><h5>Napęd</h5></a>
                            <div id="colNaped" class="collapse">
                                <ul>
                                    <li>Smarowanie łańcucha 5zł</li>
                                    <li>Czyszczenie i smarowanie łańcucha 10zł</li>
                                    <li>Wymiana łańcucha, kasety, wolnobiegu, pedałów 10zł</li>
                                    <li>Serwis suportu lub wymiana wkładu suportu 25zł</li>
                                </ul>
                            </div>
                        </div>

                        <div class="panel panel-default">
                            <a href="#colPrzerzutki" data-toggle="collapse" data-parent="#colZespoly" style="text-decoration: none"><h5>Przerzutki</h5></a>
                            <div id="colPrzerzutki" class="collapse">
                                <ul>
                                    <li>Regulacja przerzutki 15zł</li>
                                    <li>Wymiana i regulacja przerzutki 20zł</li>
                                    <li>Wymiana linki z regulacją przerzutki 20zł</li>
                                    <li>Wymiana manetki i regulacja przerzutki 30zł</li>
                                </ul>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <a href="#colStery" data-toggle="collapse" data-parent="#colZespoly" style="text-decoration: none"><h5>Stery</h5></a>
                            <div id="colStery" class="collapse">
                                <ul>
                                    <li>Kasowanie luzu w sterach 5zł</li>
                                    <li>Czyszczenie i smarowanie łożysk sterów 20zł</li>
                                    <li>Wymiana sterów 30zł</li>
                                </ul>
                            </div>
                        </div>

                        <div class="panel panel-default">
                            <a href="#colZawieszenie" data-toggle="collapse" data-parent="#colZespoly" style="text-decoration: none"><h5>Zawieszenie</h5></a>
                            <div id="colZawieszenie" class="collapse">
                                <ul>
                                    <li>Serwis amortyzatora olejowego 150zł</li>
                                    <li>Serwis amortyzatora sprężynowego 100zł</li>
                                    <li>Regulacja ciśnienia 5zł</li>
                                </ul>
                            </div>
                        </div>

                        <div class="panel panel-default">
                            <a href="#colKolaOpony" data-toggle="collapse" data-parent="#colZespoly" style="text-decoration: none"><h5>Koła i opony</h5></a>
                            <div id="colKolaOpony" class="collapse">
                                <ul>
                                    <li>Pompowanie kół 0zł !</li>
                                    <li>Wymiana dętki lub opony 10-20zł* </li>
                                    <li>Centrowanie koła 20-40zł*</li>
                                    <li>Serwis piasty 30zł</li>
                                    <li>Zaplatanie koła 50zł</li>
                                    <br/>
                                    <li style="list-style-type: none"><i>* cena zależna od czasu wymaganego na naprawę usterki </i></li>
                                </ul>
                            </div>
                        </div>

                        <div class="panel panel-default">
                            <a href="#colMontaz" data-toggle="collapse" data-parent="#colZespoly" style="text-decoration: none"><h5>Montaż i regulacja</h5></a>
                            <div id="colMontaz" class="collapse">
                                <ul>
                                    <li>Podpórki 5zł</li>
                                    <li>Siodełka 10zł</li>
                                    <li>Licznika 10zł</li>
                                    <li>Kółek bocznych 15zł</li>
                                    <li>Błotników 25zł</li>
                                </ul>
                            </div>
                        </div>

                        <div class="panel panel-default">
                            <a href="#colDodatkowe" data-toggle="collapse" data-parent="#colZespoly" style="text-decoration: none"><h5>Dodatkowe usługi</h5></a>
                            <div id="colDodatkowe" class="collapse">
                                <ul>
                                    <li>Gruntowne czyszczenie łańcucha z założeniem spinki 40zł</li>
                                    <li>Polerowanie roweru 50zł</li>
                                    <li>Lakierowanie ramy, widelca, błotników i bagażnika  350zł</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <hr>

                    <!-- *************************pakiety****************************** -->

                    <h4><a href="#colPakiety" data-toggle="collapse"  style="text-decoration: none">PAKIETY</a></h4>
                    <div id="colPakiety" class="panel-group collapse">

                    <div class="panel panel-default">
                        <a href="#colSerwis" data-toggle="collapse" data-parent="#colPakiety" style="text-decoration: none"><h5>Serwis napędu</h5></a>
                        <div id="colSerwis" class="collapse in">
                            <ul>
                                <li>Czyszczenie i smarowanie zębatek i łańcucha</li>
                                <li>Czyszczenie, smarowanie i regulacja przerzutek</li>
                                <ul>
                                    <li class="col-xs-offset-4" style="list-style-type: none;">30zł</li>
                                </ul>
                            </ul>
                        </div>
                    </div>

                    <div class="panel panel-default">
                        <a href="#colPrzegladPodst" data-toggle="collapse" data-parent="#colPakiety" style="text-decoration: none"><h5>Przegląd podstawowy</h5></a>
                        <div id="colPrzegladPodst" class="collapse">
                            <ul>
                                <li>Czyszczenie i smarowanie zębatek i łańcucha</li>
                                <li>Czyszczenie, smarowanie i regulacja przerzutek</li>
                                <li>Regulacja hamulców</li>
                                <li>Dokręcanie nakrętek piast, suportu, pedałów i sterów</li>
                                <li>Czyszczenie roweru</li>
                                <ul>
                                    <li class="col-xs-offset-4" style="list-style-type: none;">60zł</li>
                                </ul>
                            </ul>
                        </div>
                    </div>

                    <div class="panel panel-default">
                        <a href="#colPrzegladPosr" data-toggle="collapse" data-parent="#colPakiety" style="text-decoration: none"><h5>Przegląd pośredni</h5></a>
                        <div id="colPrzegladPosr" class="collapse">
                            <ul>
                                <li>Czyszczenie i smarowanie zębatek i łańcucha</li>
                                <li>Czyszczenie, smarowanie i regulacja przerzutek</li>
                                <li>Regulacja hamulców</li>
                                <li>Dokręcanie nakrętek piast, suportu, pedałów i sterów</li>
                                <li>Czyszczenie roweru</li>
                                <li>Czyszczenie i smarowanie piast</li>
                                <ul>
                                    <li class="col-xs-offset-4" style="list-style-type: none;">100zł</li>
                                </ul>
                            </ul>
                        </div>
                    </div>

                    <div class="panel panel-default">
                        <a href="#colPrzegladKompl" data-toggle="collapse" data-parent="#colPakiety" style="text-decoration: none"><h5>Przegląd kompleksowy</h5></a>
                        <div id="colPrzegladKompl" class="collapse">
                            <ul>
                                <li>Czyszczenie i smarowanie zębatek i łańcucha</li>
                                <li>Czyszczenie, smarowanie i regulacja przerzutek</li>
                                <li>Regulacja hamulców</li>
                                <li>Dokręcanie nakrętek piast, suportu, pedałów i sterów</li>
                                <li>Czyszczenie roweru</li>
                                <li>Czyszczenie i smarowanie piast</li>
                                <li>Centrowanie kół</li>
                                <li>Czyszczenie i smarowanie sterów i suportu</li>
                                <ul>
                                    <li class="col-xs-offset-4" style="list-style-type: none;">150zł</li>
                                </ul>
                            </ul>
                        </div>
                    </div>
                    </div>
                    <hr>

            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="js/script.js"></script>
</body>
</html>
