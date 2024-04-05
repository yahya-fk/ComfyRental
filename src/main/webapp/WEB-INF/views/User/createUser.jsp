<%@ include file="../Shared/Header.jsp"%>
<form method="post"  class="card shadow-sm p-5" action="saveUser">
    <div class="container ">
        <div class="row align-items-center">
            <div class="text-center mb-2">
                <h3>Add User :</h3>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="firstName">First Name<span class="text-danger"> *</span></label>
                        <input type="text" id="firstName" class="form-control" required onblur="validate(1)" name="firstName">
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="lastName">Last Name<span class="text-danger"> *</span></label>
                        <input type="text" id="lastName" class="form-control" required onblur="validate(2)" name="lastName">
                    </div>
                </div>
            </div>

            <div class="row">
                <h6>Your Authentication Credentials</h6>
                <hr>
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="email">Email<span class="text-danger"> *</span></label>
                        <input type="email" id="email"  class="form-control" required onblur="validate(3)" name="email">
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="password">Password<span class="text-danger"> *</span></label>
                        <input type="password" id="password"  class="form-control" required onblur="validate(3)" name="password">
                    </div>
                </div>
                <hr>
            </div>
            <div class="row mt-3">
                <div class="form-group">
                    <label for="firstName">Image Path:<span class="text-danger"> *</span></label>
                    <input type="text" id="imgPath" class="form-control" required onblur="validate(1)" name="imgPath">
                </div>
                <div class="col-md-12">
                    <div class="form-group">
                        <button class="btn btn-outline-primary w-100">Submit</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
<%@ include file="../Shared/Footer.jsp"%>
