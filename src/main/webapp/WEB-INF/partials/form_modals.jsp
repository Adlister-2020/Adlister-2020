<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rdelarosa
  Date: 11/21/20
  Time: 11:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!---------------- Sign in Modal ---------------------->
<c:if test="${requestScope['javax.servlet.forward.request_uri'] != '/login'}">
<div class="modal fade" id="signInModal" tabindex="0">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content" style="border-radius: 1.25rem;">
            <div>
                <button class="close mr-auto pt-1 pr-4"  data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body" >
                <h4 class="text-center px-2"> Sign In </h4>
                <jsp:include page="../sessions/login_form.jsp"/>
                <br>
                <p class="hint-text text-center small text text-muted">Don’t have an account?
                    <a href="#" class="text-success" onclick="getFormModal()" >Sign Up </a>
                </p>
            </div>
        </div>
    </div>
</div>
</c:if>

<!---------------- !Sign in Modal ---------------------->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!---------------- Registration Modal ---------------------->
<div class="modal fade" id="registerModal" tabindex="0">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content" style="border-radius: 1.25rem;">
            <div>
                <button class="close mr-auto pt-1 pr-4"  data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <h4 class="text-center px-2"> Sign up </h4>

                <jsp:include page="../users/register_form.jsp"/>
                <br>
                <p class="hint-text text-center small text text-muted">Already Registered?
                    <a href="#" class="text-success" onclick="getFormModal()"  >Sign In</a>
                </p>
            </div>
        </div>
    </div>
</div>

<!---------------- !Sign in Modal ---------------------->
