<div id="editEmployeeModal${userPage.id}" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/edit-user" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Edit Employee</h4>
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">

                    <div class="form-group">

                        <input type="hidden" value="${userPage.id}" name="id" class="form-control">
                    </div>

                    <div class="form-group">
                        <label>Username</label>
                        <input type="text" value="${userPage.userName}" name="userName" class="form-control">
                    </div>

                    <div class="form-group">
                        <label>Email</label> <input type="text" value="${userPage.email}" name="email" class="form-control"
                                                    required>
                    </div>

                    <div class="form-group">
                        <label>Age</label> <input type="text" value="${userPage.age}" name="age" class="form-control"
                                                  required>
                    </div>

                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default"
                           data-dismiss="modal" value="Cancel"> <button
                        type="submit" class="btn btn-info" >Save</button>
                </div>
            </form>
        </div>
    </div>
</div>