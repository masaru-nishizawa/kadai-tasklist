<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="./layout/app.jsp">
    <c:param name="content">
        <h2>タスク${task.id}の内容編集ページ</h2>
            <form method="POST" action="${pageContext.request.contextPath}/update">
                <c:import url="./layout/_form.jsp"/>
            </form>

            <p><a href="${pageContext.request.contextPath}/index">タスク一覧へ戻る</a>
            <p><a href="#" onclick="confirmDestroy();">このタスクを削除する</a>
            <form method="post" action="${pageContext.request.contextPath}/destroy">
                <input type="hidden" name="_token" value="${_token}"/>
            </form>

            function confirmDestroy(){
                if (confirm("本当に削除してよろしいですか？"))｛
                    document.forms[1].submit();
                }
            }

    </c:param>
</c:import>