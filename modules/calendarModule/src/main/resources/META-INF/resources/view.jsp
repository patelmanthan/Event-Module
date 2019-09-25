<%@ include file="/init.jsp" %>


<liferay-portlet:resourceURL var="getCountyURL">
	<liferay-portlet:param name="task" value="getCounty"/>
</liferay-portlet:resourceURL>

<p>Click on this paragraph.</p>

<script type="text/javascript">
$(document).ready(function() {
	$("p").click(function(){
	$.ajax({
		url : '${getCountyURL}',
		data : {
			
		}, 
		async:false,
		success : function(data) {
		console.log("succ");							
			
		}
	});
	});
});
 
</script>