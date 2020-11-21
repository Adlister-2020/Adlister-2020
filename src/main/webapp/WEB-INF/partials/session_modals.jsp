<%--
  Created by IntelliJ IDEA.
  User: rdelarosa
  Date: 11/21/20
  Time: 11:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!---------------- Sign in Modal ---------------------->
<div class="modal fade" id="signInModal" tabindex="0">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div>
                <button class="close mr-auto pt-1 pr-4"  data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <h4 class="text-center px-2"> Sign In </h4>

                <jsp:include page="login_form.jsp"/>
                <br>
                <p class="hint-text text-center small text text-muted">Don’t have an account?
                    <a href="/register" class="text-success" >Sign Up </a>
                </p>
            </div>
        </div>
    </div>
</div>

<!---------------- !Sign in Modal ---------------------->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!---------------- Registration Modal ---------------------->
<div class="modal fade" id="registerModal" tabindex="0">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div>
                <button class="close mr-auto pt-1 pr-4"  data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <h4 class="text-center px-2"> Sign up </h4>

                <jsp:include page="register_form.jsp"/>
                <br>
                <p class="hint-text text-center small text text-muted">Have an account?
                    <a href="/login" class="text-success" >Sign In </a>
                </p>
            </div>
        </div>
    </div>
</div>

<!---------------- !Sign in Modal ---------------------->
