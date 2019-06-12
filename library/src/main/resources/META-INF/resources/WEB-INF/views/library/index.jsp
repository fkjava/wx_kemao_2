<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 加入JSTL的标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书馆首页</title>
<link href="/kemao_2/library/css/main.css" rel="stylesheet"/>
</head>
<body>
	<form action="" method="get">
		<input name="keyword" placeholder="关键字" value="${param.keyword}"/>
		<button>搜索</button>
	</form>
	
	<%-- 循环输出查询得到的数据 --%>
<%-- 	<%
	Page<Book> page = (Page<Book>) request.getAttribute("page");
	List<Book> content = page.getContent();
	for( Book book : content ){
	%>
		<div>
			<img/>
			<span><%=book.getName() %></span>
		</div>
	<%} %> --%>
	
	<%-- ${page.content }是EL表达式，属于JSP 2.0的功能 --%>
	<%-- 它首先从request里面获取名为page的对象，然后再调用page对象里面的getCotnent()方法 --%>
	
	<c:forEach items="${page.content }" var="book">
		<div class="item">
			<div class="col-1">
				<img src="/kemao_2/library/images/${book.image }"/>
			</div>
			<div class="col-10">
				<span>${book.name }</span>
			</div>
			<div class="col-1 buttons">
				<a href="/kemao_2/library/debit?id=${book.id }" class="button">+</a>
			</div>
		</div>
	</c:forEach>
	
	<%-- 分页按钮 --%>
	<div>
		<c:if test="${page.number <= 0 }">
			<a>上一页</a>
		</c:if>
		<c:if test="${page.number > 0 }">
			<%-- param是EL表达式的内置对象，表示请求参数 --%>
			<%-- param.keyword 表示获取名为keyword的请求参数的值 --%>
			<%-- ${param.keyword} 等同于 request.getParameter("keyword") --%>
			<a href="?pageNumber=${page.number - 1 }&keyword=${param.keyword}">上一页</a>
		</c:if>
		<%-- c:if没有else，通常如果要使用else的时候改为用c:choose --%>
		<%-- c:choose类似于Java里面的switch case语句 --%>
		<c:choose>
			<%-- 页码从0开始，而总页数从1开始，所以要减一 --%>
			<c:when test="${page.number >= page.totalPages - 1 }">
				<a>下一页</a>
			</c:when>
			<c:otherwise>
				<a href="?pageNumber=${page.number + 1 }&keyword=${param.keyword}">下一页</a>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>