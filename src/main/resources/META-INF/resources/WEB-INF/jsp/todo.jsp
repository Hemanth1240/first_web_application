<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>
<div class="container mt-4">
    <h1>Enter Todo Details</h1>

    <!-- Display error messages if any -->
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger">${errorMessage}</div>
    </c:if>

    <form:form method="post" modelAttribute="todo">
        <div class="mb-3">
            <fieldset>
                <form:label path="description">Description</form:label>
                <form:input type="text" path="description" cssClass="form-control"/>
                <form:errors path="description" cssClass="text-danger"/>
            </fieldset>
        </div>

        <div class="mb-3">
            <fieldset>
                <form:label path="targetDate">Target Date</form:label>
                <form:input type="text" id="targetDate" path="targetDate" cssClass="form-control"/>
                <form:errors path="targetDate" cssClass="text-danger"/>
            </fieldset>
        </div>

        <form:input path="id" type="hidden"/>
        <form:input path="completed" type="hidden"/>

        <button type="submit" class="btn btn-success">Add Todo</button>
    </form:form>
</div>
<%@include file="common/footer.jspf" %>
<script type="text/javascript">
    $(document).ready(function () {
        $('#targetDate').datepicker({
            format: 'dd/mm/yyyy',
            autoclose: true,
            todayHighlight: true
        });
    });
</script>

