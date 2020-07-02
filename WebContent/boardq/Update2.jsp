<%@page contentType="text/html;charset=utf-8"%>

<%-- 
<%
	boolean flag = (Boolean)request.getAttribute("flag");
%>
--%>

	<script language='javascript'>
	if(${flags}){ //자바스크립트의 if
		alert("수정 성공 by MVC~");
	}else{
		alert("수정 실패 by MVC~");
	}
		location.href="boardq.do?m=list&cp=1&ps=3";
	</script>