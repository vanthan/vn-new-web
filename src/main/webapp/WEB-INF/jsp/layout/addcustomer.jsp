<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Add new customer </h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="/user" method="post" >
                    <div class="mb-3">
                        <label  class="col-form-label">User Name:</label>
                        <input type="text" class="form-control" name="userName">
                    </div>
                    <div class="mb-3">
                        <label class="col-form-label">Email:</label>
                        <input type="text" class="form-control" name="email">
                    </div>
                    <div class="mb-3">
                        <label  class="col-form-label">Age:</label>
                        <textarea class="form-control" name="age"></textarea>
                    </div>

                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary btn-lg">Submit</button>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>