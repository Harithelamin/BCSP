<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: Harith
  Date: 4/1/2019
  Time: 9:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <link href="<c:url value='/static/css/bcsp.css' />" rel="stylesheet"></link>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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
<div class="container">
    <sec:authorize access="hasRole('ADMIN') or hasRole('SUPERVISOR')">
      <form:form method="POST" class="form-horizontal" modelAttribute="dimensions" enctype="multipart/form-data">
        <div class="form-group">
            <div class=" ${status.error ? 'has-error' : ''}">
                <label>Registration Code</label>
                <div>
                    <c:choose>
                        <c:when test="${edit}">
                            <form:input type="text" class="form-control" path="dimensionId" id="dimensionId" disabled="true"/>
                        </c:when>
                        <c:otherwise>
                            <form:input type="text" path="dimensionId" id="dimensionId" disabled="true" />
                            <div class="has-error">
                                <form:errors path="dimensionId"/>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>



        <div class="form-group">
            <div class=" ${status.error ? 'has-error' : ''}">
                <label>Reference Name</label>
                <div>
                    <form:input type="text" path="name" id="name"/>
                    <div class="has-error"><form:errors path="name"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="form-group">
            <div class=" ${status.error ? 'has-error' : ''}">
                <label>Mobile Number</label>
                <div>
                    <form:input type="text" path="mobileNumber" id="mobileNumber" />
                    <div class="has-error">
                        <form:errors path="mobileNumber"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class=" ${status.error ? 'has-error' : ''}">
                <label>Email</label>
                <div>
                    <form:input type="email" path="email" id="email" />
                    <div class="has-error">
                        <form:errors path="email"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="form-group">
            <div class="${status.error ? 'has-error' : ''}">
                <label>Personal Or Institute</label>
                <div>
                    <label> <form:radiobutton path="personalOrInstitute" value="Private" /> Personal</label>
                    <label> <form:radiobutton path="personalOrInstitute" value="Institute" /> Institute
                    </label> <br />
                    <form:errors path="personalOrInstitute" />
                </div>
            </div>
        </div>

        <div class="form-group">
            <div>
                <div>
                    Photo: <input type="file" name="photo" id="photo" path="photo">
                    <div class="has-error">

                    </div>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class=" ${status.error ? 'has-error' : ''}">
                <label>Description</label>
                 <div>
                      <form:textarea rows="5" cols="100%" path="dimensiondescription" id="dimensiondescription" name="dimensiondescription" />
                      <div class="has-error">
                          <form:errors path="dimensiondescription"/>
                      </div>
                 </div>
            </div>
        </div>
        <div class="border2">
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
        </div>

        <div>
            <div>
                <div>
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update"/> or <a href="<c:url value='/dimensionslist' />">Cancel</a>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Upload"/> or <a href="<c:url value='/dimensionslist' />">Cancel</a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
      </form:form>
    </sec:authorize>
</div>
</div>
</body>

