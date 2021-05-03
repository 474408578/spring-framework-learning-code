<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>demo</title>
</head>
<body>
    <table id="dept-table" border="1">
        <thead>
        <tr>
            <th width="320px">id</th>
            <th width="150px">名称</th>
            <th width="150px">电话</th>
            <th width="100px">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${deptList != null}">
            <c:forEach items="${deptList}" var="dept">
                <tr>
                    <td align="center">${dept.id}</td>
                    <td align="center">${dept.name}</td>
                    <td align="center">${dept.tel}</td>
                    <td align="center">
                        <a href="${pageContext.request.contextPath}/department/edit?id=${dept.id}">编辑</a>
                        <a href="javascript:del(${dept.id})">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
</body>
</html>