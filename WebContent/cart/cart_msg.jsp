<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script language="javascript">
	if(${cFlag}){
		alert("장바구니에 상품을 담았습니다.");
		history.go(-1); 
	}else{
		alert("동일한 상품이 장바구니에 담겨있습니다.");
		history.go(-1); 
	}

</script>