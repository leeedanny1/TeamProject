<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 	<link rel="stylesheet" href="/css/reset.css">
    <link rel="stylesheet" href="/css/include/include.css">
    <link rel="stylesheet" href="/css/index.css">
     <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
    <jsp:include page="../include/header.jsp"/> 
      
      <main class="wrap main">
      <h1>item_code: ${products.item_code }</h1>
      <h1>item_title: ${products.item_title }</h1>
      <h1>item_writer: ${products.item_writer }</h1>
      <h1>item_content: ${products.item_content }</h1>
      <h1>create_date: ${products.create_date }</h1>
     </main>
</body>
</html>