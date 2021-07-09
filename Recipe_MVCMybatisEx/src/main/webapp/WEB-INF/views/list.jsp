<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모 테이블 내용 보이기</title>
</head>
<body>
		전체 개수 : ${totalCount }개 <br />
		
		<c:if test="${not empty list }">
			<c:forEach var="vo" items ="${list }">
				${vo.idx }. ${vo.name } :
				<c:out value="${vo.content }"/> - <fmt:formatDate value="${vo.regDate }" pattern="yyyy-MM-dd hh:mm:ss"/> <br />
			</c:forEach>
		</c:if>
		<c:if test="${empty list }">
			~데이터 없다
		</c:if>

</body>
</html>