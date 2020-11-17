<%--
  Created by IntelliJ IDEA.
  User: thomascrowder
  Date: 11/17/20
  Time: 11:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <div class="form-group">
            <label for="${param.id}">${param.id}</label>
            <input id="${param.id}" name="${param.id}" class="form-control" type="${param.type}" style="border-color: red" required>
            <div>
                Please choose a different ${param.id}.
            </div>
        </div>


