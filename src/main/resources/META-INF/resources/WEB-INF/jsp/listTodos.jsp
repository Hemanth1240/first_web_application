<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>
<div class="container mt-4">
    <h2 class="text-center">Your Todos</h2>
    <hr>

    <div class="table-responsive">
        <table class="table table-bordered table-striped">
            <thead class="table-dark">
            <tr>
                <th>Description</th>
                <th>Target Date</th>
                <th>Status</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${todos}" var="todo">
                <tr>
                    <td>${todo.description}</td>
                    <td>${todo.targetDate}</td>
                    <td>
                        <c:choose>
                            <c:when test="${todo.completed}">
                                <span class="badge bg-success">Completed</span>
                            </c:when>
                            <c:otherwise>
                                <span class="badge bg-danger">Pending</span>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <a href = "delete-todo?id=${todo.id}" class = "btn btn-warning">Delete</a>
                    </td>
                    <td>
                        <a href = "update-todo?id=${todo.id}" class = "btn btn-success">Update</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a href="add-todo" class = "btn btn-success">Add Todo</a>
    </div>
</div>

<%@include file="common/footer.jspf" %>
