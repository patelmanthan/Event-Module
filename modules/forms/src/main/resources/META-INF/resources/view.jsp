<%@ include file="/init.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<liferay-portlet:resourceURL var="resourceUrl" />

	<div class="table-responsive">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>#</th>
				<th>Event Name</th>
				<th>Start Time</th>
				<th>Description</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${calendarBookings}" var="calendarBooking">
				<tr>
					<th scope="row">${calendarBooking.calendarBookingId}</th>
					<td>${calendarBooking.title}</td>
					<td>${calendarBooking.startTime}</td>
					<td>${calendarBooking.endTime}</td>
					<td><button
							onclick="callServeResource(${formAttribute.get(calendarBooking.calendarBookingId)})"
							class="primary-button ">Show Event form data</button></td>
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
						console.log(data);
						$(".displayformdata").html("");
						$(".tabledata").show();
						if(data.length === 0){
							$(".displayformdata").append("<tr><td> No form data present </td></tr>");
						}
						$(data).each(function(index, value){
							if(!value.email == ''){
								if(data[index].status === "1"){
									$(".displayformdata").append("<tr><td>"+ data[index].email +"</td><td class="+data[index].recordVersionId+" ><button onclick=\"approveRecord("+data[index].contentId+","+data[index].kaleoInstanceTokenId+","+data[index].userId+","+data[index].recordVersionId+")\">Approved</button></td></tr>");
								}else{
									$(".displayformdata").append("<tr><td>"+ data[index].email +"</td></tr>");
								}
							}					
						});
              		}
        		}
 
    	});
	});
}
function approveRecord(recordID, kaleoInstanceTokenId, userId,recordVersionId){
    AUI().use('aui-io-request', function(A){
        A.io.request('${resourceUrl}', {
        	method: 'post',
               data: {
            	   <portlet:namespace />recordID: recordID,
            	   <portlet:namespace />kaleoInstanceTokenId : kaleoInstanceTokenId,
            	   <portlet:namespace />userId : userId,
            	   <portlet:namespace />recordVersionId : recordVersionId,
               },
               on: {
                   	success: function() {
					var data = JSON.parse(this.get('responseData'));
					if(data.status == "success"){
						$("."+recordVersionId).hide();
					}
                   }
              }
        });
 
    });
} 
</script> 