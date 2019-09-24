<%@ include file="/init.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<liferay-portlet:resourceURL var="resourceUrl" />

<div class="table-responsive">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>#</th>
				<th>Form Name</th>
				<th>Created Date</th>
				<th>Description</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${formNameList}" var="formName">
				<tr>
					<th scope="row">${formName.formInstanceId}</th>
					<td>${formName.name}</td>
					<td>${formName.createDate}</td>
					<td>${formName.description}</td>
					<td><button
							onclick="callServeResource(${formName.formInstanceId})"
							class="primary-button">Show data</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<br />
<hr>
<br />
<div class="table-responsive tabledata  hidden">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>email</th>
				<th>Status</th>
			</tr>
		</thead>
		<tbody class="displayformdata">
		</tbody>
	</table>
</div>

<script type="text/javascript">
function callServeResource(formID){
    AUI().use('aui-io-request', function(A){
        A.io.request('${resourceUrl}', {
        	method: 'post',
               data: {
            	   <portlet:namespace />Id: formID,
               },
               on: {
                   	success: function() {
						var data = JSON.parse(this.get('responseData'));
						$(".displayformdata").html("");
						$(".tabledata").show();
						if(data.length === 0){
							$(".displayformdata").append("<tr><td> No form data present </td></tr>");
						}
						$(data).each(function(index, value){
							if(!value.email == ''){
								$(".displayformdata").append("<tr><td>"+ data[index].email +"</td><td><button onclick=\"approveRecord("+data[index].contentId+")\">Approved</button></td></tr>");
							};
		                  });
              		}
        		}
 
    	});
	});
}
function approveRecord(recordID){
    AUI().use('aui-io-request', function(A){
        A.io.request('${resourceUrl}', {
        	method: 'post',
               data: {
            	   <portlet:namespace />recordID: recordID,
               },
               on: {
                   	success: function() {
					var data = JSON.parse(this.get('responseData'));
                   }
              }
        });
 
    });
} 
</script>