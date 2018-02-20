<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<%@ include file="fragments/header.jsp" %>


<table class="table table-hover table-dark" style="margin-top: 8em">
    <thead>
    <tr>
        <th>
            <button type="button" class="btn btn-success" data-toggle="modal"
                    data-target="#addPersonModal" style="margin: 5px">Add new person
            </button>

            <%--Add new person modal--%>
            <div id="addPersonModal" class="modal fade " role="dialog">
                <div class="modal-dialog ">
                    <%--Modal content--%>
                    <div class="modal-content " style="color:#000000">
                        <div class="modal-header">
                            <h4 class="modal-title">Add new person</h4>
                        </div>

                        <div class="modal-body ">
                            <!-- We display the details entered by the user here -->
                            <form id="addPersonForm">
                                <div class="form-group row ">
                                    <label
                                            class="col-sm-2 col-form-label">Full Name</label>
                                    <div class="col-sm-10" style="align-self: center">
                                        <input id="person-name-add"
                                               type='text'
                                               required
                                        />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Date
                                        of birth</label>
                                    <div class="col-sm-10" style="align-self: center">
                                        <input id="person-birthday-add" class="appdatepicker" type='text'
                                               class="form-control"
                                        />
                                    </div>
                                </div>

                                <div class="modal-footer">
                                    <button type="submit" class="btn btn-primary" id="add">Add person
                                    </button>
                                    <button type="button" class="btn btn-default"
                                            data-dismiss="modal">Close
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>


        </th>

    </tr>

    <tr>
        <th>Name</th>
        <th>Date of birth</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="person" items="${personList}">
        <c:set var="personUri" scope="page" value="personPage?id=${person.id}"/>
        <tr style="cursor:pointer">
            <td onclick="window.location='${personUri}';">${person.fullName}</td>
            <fmt:parseDate value="${ person.birthDate }" pattern="yyyy-MM-dd" var="parsedDateTime"/>
            <td onclick="window.location='${personUri}';"><fmt:formatDate value="${parsedDateTime}"/></td>
            <td>
                <button
                        onclick="updatePerson(${person.id})"

                        type="button" class="btn btn-light"
                        data-toggle="modal"
                        data-target="#updatePersonModal"
                >Update
                </button>
                    <%--Update Person Modal--%>
                <div id="updatePersonModal" class="modal fade" role="dialog">
                    <div class="modal-dialog ">
                            <%--Modal content--%>
                        <div class="modal-content" style="color:black">
                            <div class="modal-header">
                                <h4 class="modal-title">Update Person</h4>
                            </div>
                            <div class="modal-body">
                                <!-- We display the details entered by the user here -->
                                <form id="updatePersonForm">
                                    <div class="form-group row ">
                                        <label
                                                class="col-sm-2 col-form-label">Name</label>
                                        <div class="col-sm-10">
                                            <input id="person-name-update"
                                                   type='text'
                                                   required
                                            />
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">Date
                                            of birth</label>
                                        <div class="col-sm-10">
                                            <input id="person-birthday-update" class="appdatepicker" type='text'
                                                   class="form-control"
                                            />
                                        </div>
                                    </div>

                                    <div class="modal-footer">
                                        <button type="submit" class="btn btn-primary" id="update">Update
                                        </button>
                                        <button type="button" class="btn btn-default"
                                                data-dismiss="modal">Close
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>


            </td>
            <td>
                    <%--Todo : add functionality--%>
                <button type="button" class="btn btn-danger">
                    Delete
                </button>

            </td>
        </tr>

    </c:forEach>
    </tbody>
</table>

<%@ include file="fragments/footer.jsp" %>

<script src="js/personList.js"></script>
<script src="js/personPage.js"></script>



