<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<body>
<div class="main">
	<sec:authorize access="hasRole('ADMIN') or hasRole('SUPERVISOR')">
	<div class="generic-container">
		<div class="well lead">Patient Page</div>
		<div class="panel panel-default">
			<div class="panel-heading"><span class="lead"><a href="<c:url value='' />" class="btn-danger">Patient Info</a><a href="<c:url value='/showPatientInfo-${patient.id}' />" class="btn-dark">Reprot</a></span></div>
		  	<div class="panel-heading"><span class="lead"><a href="<c:url value='/addHd-${patient.id}' />" class="btn-danger">Baseline Info</a><a href="<c:url value='/showHd-${patient.id}' />" class="btn-dark">Reprot</a></span></div>
			<div class="panel-heading"><span class="lead"><a href="<c:url value='/addDonor-${patient.id}' />" class="btn-danger">Donor Info</a><a href="<c:url value='/showDonor-${patient.id}' />" class="btn-dark">Reprot</a></span></div>
			<div class="panel-heading"><span class="lead"><a href="<c:url value='/addTr-${patient.id}' />" class="btn-danger">Transplant Info</a><a href="<c:url value='/showTr-${patient.id}' />" class="btn-dark">Reprot</a></span></div>
			<div class="panel-heading"><span class="lead"><a href="<c:url value='/addTrF-${patient.id}' />" class="btn-danger">Follow-up after kidney transplantation</a><a href="<c:url value='/showTrF-${patient.id}' />" class="btn-dark">Reprot</a></span></div>
			<div class="panel-heading"><span class="lead"><a href="<c:url value='/newMonthlyFollowUp-${patient.id}' />" class="btn-danger">MontylyFollo Up </a><a href="<c:url value='/showMFUp-${patient.id}' />" class="btn-dark">Reprot</a></span></div>
			<div class="panel-heading"><span class="lead"><a href="<c:url value='/patientslist' />" class="btn-danger">Patients list</a></span></div>
			<div class="panel-heading"><span class="lead"> </span></div>
			<div class="panel-heading"><span class="lead">List of Documents </span></div>

		  	<div class="tablecontainer">
				<table class="table table-hover">
		    		<thead>
			      		<tr>
					        <th>No.</th>
					        <th>File Name</th>
					        <th>Type</th>
					        <th>Description</th>
					        <th width="100"></th>
					        <th width="100"></th>
						</tr>
			    	</thead>
		    		<tbody>
					<c:forEach items="${documents}" var="doc" varStatus="counter">
						<tr>
							<td>${counter.index + 1}</td>
							<td>${doc.name}</td>
							<td>${doc.type}</td>
							<td>${doc.description}</td>
							<td><a href="<c:url value='/download-document-${patient.id}-${doc.id}' />" class="btn btn-success custom-width">download</a></td>
							<td><a href="<c:url value='/delete-document-${patient.id}-${doc.id}' />" class="btn btn-danger custom-width">delete</a></td>
						</tr>
					</c:forEach>
		    		</tbody>
		    	</table>
		    </div>
		</div>
		<div class="panel panel-default">

			<div class="panel-heading"><span class="lead">Upload New Document</span></div>
			<div class="uploadcontainer">
				<form:form method="POST" modelAttribute="fileBucket" enctype="multipart/form-data" class="form-horizontal">

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable" for="file">Upload a document</label>
							<div class="col-md-7">
								<form:input type="file" path="file" id="file" class="form-control input-sm"/>
								<div class="has-error">
									<form:errors path="file" class="help-inline"/>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable" for="file">Description</label>
							<div class="col-md-7">
								<form:input type="text" path="description" id="description" class="form-control input-sm"/>
							</div>

						</div>
					</div>

					<div class="row">
						<div class="form-actions floatRight">
							<input type="submit" value="Upload" class="btn btn-primary btn-sm">
						</div>
					</div>

				</form:form>
				</div>
		</div>
			</sec:authorize>
</div>
</body>