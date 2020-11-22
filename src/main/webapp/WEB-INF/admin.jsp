<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Admin Dashboard"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div class="container">
    <nav class="nav justify-content-center nav-tabs nav-justified">
        <div class="nav nav-tabs" id="nav-tab" role="tablist">
            <a class="nav-link active" id="nav-home-tab" data-toggle="tab" href="#user-tab" role="tab"
               aria-controls="nav-home" aria-selected="true">Users</a>
            <a class="nav-link" id="nav-profile-tab" data-toggle="tab" href="#ad-tab" role="tab"
               aria-controls="nav-profile" aria-selected="false">Ads</a>
            <a class="nav-link" id="nav-contact-tab" data-toggle="tab" href="#category-tab" role="tab"
               aria-controls="nav-contact" aria-selected="false">Categories</a>
        </div>
    </nav>
    <div class="tab-content" id="nav-tabContent">
        <div class="tab-pane fade show active" id="user-tab" role="tabpanel" aria-labelledby="nav-home-tab">
            <table class="table table-responsive">
                <thead>
                <tr>
                    <th scope="col"></th>
                    <th scope="col"></th>
                    <th scope="col">id</th>
                    <th scope="col">username</th>
                    <th scope="col">email</th>
                    <th scope="col">role</th>
                    <th scope="col">created_at</th>
                    <th scope="col">updated_at</th>
                    <th scope="col">password</th>
                    <th scope="col">avatar</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>
                            <button type="button" class="btn btn-sm btn-primary" data-toggle="modal"
                                    data-target="#Modal1" data-whatever="${user.getId()}"> <%-- dynamiclly generate data-whatever --%>
                                Edit User
                            </button>
                        </td>
                        <td>
                            <button type="button" class="btn btn-sm btn-danger" data-toggle="modal"
                                    data-target="#model22" data-whatever="${user.getId()}"> <%-- dynamiclly generate data-whatever --%>
                                Delete User
                            </button>
                        </td>
                            <%-- send email to notify user --%>
                        <td><c:out value="${user.getId()}" /></td>
                        <td><c:out value="${user.getUsername()}" /></td>
                        <td><c:out value="${user.getEmail()}" /></td>
                        <td><c:out value="${user.getRole()}" /></td>
                        <td><c:out value="${user.getCreation()}" /></td>
                        <td><c:out value="" /></td>
                        <td><c:out value="${user.getPassword()}" /></td>
                        <td><c:out value="${user.getAvatar()}" /></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="modal fade" id="Modal1" tabindex="-1">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Edit User</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div id="user-id">User id = </div>
                            <form>
                                <div class="form-group">
                                    <label class="col-form-label">User role</label>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1">
                                        <label class="form-check-label" for="inlineRadio1">user</label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
                                        <label class="form-check-label" for="inlineRadio2">admin</label>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                            <button type="button" class="btn btn-primary">Submit</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="model22" tabindex="-1">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Delete User</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="confirmation">Are you sure you want to delete ?</div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                            <button type="button" class="btn btn-primary">Yes</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="tab-pane fade" id="ad-tab" role="tabpanel" aria-labelledby="nav-profile-tab">
            <table class="table table-striped table-responsive">
                <thead>
                <tr>
                    <th scope="col"></th>
                    <th scope="col"></th>
                    <th scope="col">id</th>
                    <th scope="col">user_id</th>
                    <th scope="col">title</th>
                    <th scope="col">description</th>
                    <th scope="col">created_at</th>
                    <th scope="col">updated_at</th>
                    <th scope="col">categories</th>
                    <th scope="col">image</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="ad" items="ads" >
                    <tr>
                        <td>
                            <button type="button" class="btn btn-sm btn-primary" data-toggle="modal"
                                    data-target="#modal-ad1" data-whatever="${ad.getId()}"> <%-- dynamiclly generate data-whatever --%>
                                Edit Ad
                            </button>
                        </td>
                        <td>
                            <button type="button" class="btn btn-sm btn-danger" data-toggle="modal"
                                    data-target="#ad-model2" data-whatever="${ad.getId()}"> <%-- dynamiclly generate data-whatever --%>
                                Delete Ad
                            </button>
                        </td>
                            <%-- send email to notify user --%>
                        <td><c:out value="${ad.getId()}" /></td>
                        <td><c:out value="${ad.getUserId()}" /></td>
                        <td><c:out value="${ad.getTitle()}" /></td>
                        <td><c:out value="${ad.getDescription()}" /></td>
                        <td><c:out value="${ad.getCreation()}" /></td>
                        <td><c:out value="${ad.getTimeStamp()}" /></td>
                        <td><c:out value="" /></td>
                        <td><c:out value="${ad.getImages()}" /></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="modal fade" id="modal-ad1" tabindex="-1">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Edit Ad</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div id="ad-id">Ad id = </div>
                            <form>
                                <div class="form-group">
                                    <label class="col-form-label">User role</label>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                            <button type="button" class="btn btn-primary">Submit</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="ad-model2" tabindex="-1">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Delete Ad</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="confirmation">Are you sure you want to delete ?</div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                            <button type="button" class="btn btn-primary">Yes</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="tab-pane fade" id="category-tab" role="tabpanel" aria-labelledby="nav-contact-tab">
            <table class="table table-striped table-responsive">
                <thead>
                <tr>
                    <th scope="col"></th>
                    <th scope="col">id</th>
                    <th scope="col">title</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="category" items="categories">
                    <tr>
                        <td>
                            <button type="button" class="btn btn-sm btn-primary" data-toggle="modal"
                                    data-target="#category-modal1" data-whatever="${category.getId()}"> <%-- dynamiclly generate data-whatever --%>
                                Edit Categories
                            </button>
                        </td>
                        <td><c:out value="${category.getId()}" /></td>
                        <td><c:out value="${category.getTitle()}" /></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="modal fade" id="category-modal1" tabindex="-1">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Edit Category</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div id="category-id">Category id = </div>
                            <form>
                                <div class="form-group">
                                    <label class="col-form-label">Category Title</label>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                            <button type="button" class="btn btn-primary">Submit</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/partials/footer.jsp"/>
<script>
    $('#Modal1').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget) // Button that triggered the modal
        var recipient = button.data('whatever') // Extract info from data-* attributes
        var modal = $(this)
        console.log(recipient);
        modal.find('.modal-body #user-id').text('User id = ' + recipient)
    })
    $('#model22').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget) // Button that triggered the modal
        var recipient = button.data('whatever') // Extract info from data-* attributes
        var modal = $(this)
        console.log(recipient);
        modal.find('.modal-body').text('Confirm deleting user with id ' + recipient + ' ?')
    })
    $('#modal-ad1').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget) // Button that triggered the modal
        var recipient = button.data('whatever') // Extract info from data-* attributes
        var modal = $(this)
        console.log(recipient);
        modal.find('.modal-body #user-id').text('Ad id = ' + recipient)
    })
    $('#ad-model2').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget) // Button that triggered the modal
        var recipient = button.data('whatever') // Extract info from data-* attributes
        var modal = $(this)
        console.log(recipient);
        modal.find('.modal-body').text('Confirm deleting ad with id ' + recipient + ' ?')
    })
    $('#category-modal1').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget) // Button that triggered the modal
        var recipient = button.data('whatever') // Extract info from data-* attributes
        var modal = $(this)
        console.log(recipient);
        modal.find('.modal-body #user-id').text('Category id = ' + recipient)
    })
</script>
</body>
</html>
