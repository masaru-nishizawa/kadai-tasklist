<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<label for="content">タスクの内容</label>
<input type="text" name="content" value="${content}">
<br/><br/>

<input type="hidden" name="_token" value="${_token}"/>
<button type="submit">投稿</button>