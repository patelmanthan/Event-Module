<%@ include file="/init.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<liferay-portlet:resourceURL var="resourceUrl" />

<c:forEach items="${formNameList}" var="formName">
formName.formInstanceId : ${formName.formInstanceId}<br/>
formName.createDate :${formName.createDate}<br/>
formName.name : ${formName.name}<br/>
formName.description : ${formName.description}<br/>
<button onclick="callServeResource(${formName.formInstanceId})" class="primary-button">Show data</button> <br/>
<div class="displayformdata_${formName.formInstanceId}"></div>
<br/>
</c:forEach>


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
					$(".displayformdata_"+formID).html("");
					if(data.length === 0){
						$(".displayformdata_"+formID).append("<span> No form data present </span><br/>")
					}
					$(data).each(function(index, value){
						$(".displayformdata_"+formID).append("<span>"+ data[index].email +"</span><br/>");
					})
                   }
              }
        });
 
    });
}
</script>