<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Harith
  Date: 4/1/2019
  Time: 6:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="<c:url value='/static/css/bcsp.css' />" rel="stylesheet"></link>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-slider/9.7.2/css/bootstrap-slider.min.css">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-slider/9.7.2/bootstrap-slider.min.js"></script>

    <script>
        $('#ex1').slider({
            formatter: function(value) {
                return 'Current value: ' + value;
            }
        });
    </script>

</head>
<body>
<%@include file="../fragments/footer.jsp"%>
<form:form method="post"  modelAttribute ="dimensions" action="toolsReview">
    <div class="sidebar">
        <div class="border">
            <div class="range"><input id="ex1" type="text" path="dControl" name="dControl"
                                      data-provide="slider"
                                      data-slider-ticks="[1, 2, 3]"
                                      data-slider-ticks-snap-bounds="30"
                                      data-slider-value="2"
                                      data-slider-ticks-labels='["User in control", "Control", "Product In Control"]'/>
            </div>
            <div class="range"><input id="ex2" type="text" path="dMeaning" name="dMeaning"
                                      data-provide="slider"
                                      data-slider-ticks="[1, 2, 3]"
                                      data-slider-ticks-snap-bounds="30"
                                      data-slider-value="2"
                                      data-slider-ticks-labels='["Rarely", "Meaning", "Frequently"]'/>
            </div>
            <div class="range"><input id="ex3" type="text" path="dExposure" name="dExposure"
                                      data-provide="slider"
                                      data-slider-ticks="[1, 2, 3]"
                                      data-slider-ticks-snap-bounds="30"
                                      data-slider-value="2"
                                      data-slider-ticks-labels='["Promote", "Encouragement", "Discourage"]'/>
            </div>
            <div class="range"><input id="ex4" type="text" path="dEncouragement" name="dEncouragement"
                                      data-provide="slider"
                                      data-slider-ticks="[1, 2, 3]"
                                      data-slider-ticks-snap-bounds="30"
                                      data-slider-value="2"
                                      data-slider-ticks-labels='["Before use", "Timing", "After use"]'/>
            </div>
            <div class="range"><input id="ex5" type="text" path="dTiming" name="dTiming"
                                      data-provide="slider"
                                      data-slider-ticks="[1, 2, 3]"
                                      data-slider-ticks-snap-bounds="30"
                                      data-slider-value="2"
                                      data-slider-ticks-labels='["Before use", "Timing", "After use"]'/>
            </div>
            <div class="range"><input id="ex6" type="text" path="dEmpathy" name="dEmpathy"
                                      data-provide="slider"
                                      data-slider-ticks="[1, 2, 3]"
                                      data-slider-ticks-snap-bounds="30"
                                      data-slider-value="2"
                                      data-slider-ticks-labels='["Me", "Empathy", "Others"]'/>
            </div>
            <div class="range"><input id="ex7" type="text" path="dObtrusiveness" name="dObtrusiveness"
                                      data-provide="slider"
                                      data-slider-ticks="[1, 2, 3]"
                                      data-slider-ticks-snap-bounds="30"
                                      data-slider-value="2"
                                      data-slider-ticks-labels='["Obtrusive", "Obtrusiveness", "Unobtrusive"]'/>
            </div>
            <div class="range"><input id="ex8" type="text" path="dImportance" name="dImportance"
                                      data-provide="slider"
                                      data-slider-ticks="[1, 2, 3]"
                                      data-slider-ticks-snap-bounds="30"
                                      data-slider-value="2"
                                      data-slider-ticks-labels='["Important", "Importance", "Unimportant"]'/>
            </div>
            <div class="range"><input id="ex9" type="text" path="dDirection" name="dDirection"
                                      data-provide="slider"
                                      data-slider-ticks="[1, 2, 3]"
                                      data-slider-ticks-snap-bounds="30"
                                      data-slider-value="2"
                                      data-slider-ticks-labels='["In line", "Direction", "Opposing"]'/>
            </div>
            <div><input type="submit" value="Review" /></div>


        </div>
    </div>
</form:form>
</body>
</html>
