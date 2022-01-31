<%@page import="com.ipp.ext3.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원목록 조회</title>
<link rel="stylesheet" href="stylesheet/main.css">
<style>
	.wrapper {
		width: 80vw;
	}
	table {
		width: 100%;
	}
	h1 {
		text-align: center;
	}
</style>
</head>
<body>
	<%
		List<MemberDto> memberList = (List<MemberDto>) request.getAttribute("memberList");
	%>
	<div class="container">
		<div class="vertical-align">
			<div class="wrapper">
				<h1>회원목록조회</h1>
				<table>
					<thead>
						<tr>
							<th>회원아이디</th>
							<th>회원이름</th>
							<th>이메일</th>
							<th>연락처</th>
						</tr>
					</thead>
					<tbody>
						<% for (MemberDto mem : memberList) { %>
							<tr>
								<td><%= mem.getpId() %></td>
								<td><%= mem.getcName() %></td>
								<td><%= mem.getcEmail() %></td>
								<td><%= mem.getcTel() %></td>
							</tr>
						<% } %>
					</tbody>
				</table>
				<button type="button" id="toBackBtn">뒤로가기</button>
			</div>
		</div>
	</div>
	<script>
		document.getElementById('toBackBtn').onclick = function () {
			window.location.href = 'register.do';
		}
	</script>
</body>
</html>