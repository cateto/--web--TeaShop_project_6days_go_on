<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script language="javascript">
	if(${cFlag}){
		alert("장바구니에 상품을 담았습니다.");
		history.go(-1); 
	}else{
		alert("장바구니에 상품을 담지 못했습니다. 다시 시도해주세요");
		history.go(-1); 
	}

</script>