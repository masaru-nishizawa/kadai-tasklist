<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="./layout/app.jsp">
    <c:param name="content">
       <table>
            <tr>
                <th>タスクID</th>
                <td>${task.id}</td>
            </tr>
            <tr>
                <th>内容</th>
                <td>${task.content}</td>
            </tr>
            <tr>
                <th>作成日時</th>
                <td>${task.time_created}</td>
            </tr>
            <tr>
                <th>更新日時</th>
                <td>${task.time_updated }</td>
            </tr>
        </table>

        <br/><br/>

        <a href="${pageContext.request.contextPath}/index">タスク一覧へ戻る</a>
        <br/>
        <a href="${pageContext.request.contextPath}/edit">このタスクの編集</a>

    </c:param>
</c:import>