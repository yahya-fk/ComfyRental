<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Create User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous"></head>
<body>
    <style>
        /* Set the fixed height of the footer here */
        .footer {
            position: fixed;
            bottom: 0;
            width: 100%;
            height: 7%;
            background-color: #f5f5f5;
        }
    </style>
    <header>
        <nav class="navbar navbar-expand-sm navbar-toggleable-sm navbar-light bg-white border-bottom box-shadow mb-3">
            <div class="container-fluid">
                <a class="navbar-brand" asp-area="" asp-controller="Home" asp-action="Index">admin</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target=".navbar-collapse" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="navbar-collapse collapse d-sm-inline-flex justify-content-between">
                    <ul class="navbar-nav flex-grow-1">
                        <li class="nav-item">
                            <a class="nav-link text-dark" asp-area="" asp-controller="Home" asp-action="Index">Home</a>
                        </li>
                        <li class="nav-item">
                            <a asp-action="" asp-controller="User" class="nav-link text-dark">User</a>
                        </li>
                        <li class="nav-item">
                            <a asp-action="" asp-controller="Subscription" class="nav-link text-dark">Subscription</a>
                        </li>
                        <li class="nav-item">
                            <a asp-action="" asp-controller="Bill" class="nav-link text-dark">Bill</a>
                        </li>
                    </ul>
                </div>
                <button class="btn btn-outline-secondary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasWithBothOptions" aria-controls="offcanvasWithBothOptions">Menu</button>

            </div>
        </nav>
    </header>
    <div class="container">
        <main role="main" class="pb-3">
            <div class="offcanvas offcanvas-end" data-bs-scroll="true" tabindex="-1" id="offcanvasWithBothOptions" aria-labelledby="offcanvasWithBothOptionsLabel">
                <div class="offcanvas-header">
                    <h5 class="offcanvas-title" id="offcanvasWithBothOptionsLabel">Menu</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                </div>
                <div class="offcanvas-body">
                    <div class="container">
                        <div class="row">
                            <div class="list-group">
                                <a asp-action="" asp-controller="User" class="list-group-item list-group-item-action">User Management</a>
                                <a asp-action="" asp-controller="Subscription" class="list-group-item list-group-item-action">Subscription Mangement</a>
                                <a asp-action="" asp-controller="Bill" class="list-group-item list-group-item-action">Bill Mangement</a>
                                <a asp-action="logout" asp-controller="User" class="list-group-item text-white bg-danger list-group-item-action">Logout</a>

                            </div>

                        </div>
                    </div>
                </div>
            </div>



            <form method="post" class="card shadow-sm p-5" action="saveUser">
                <div class="container">
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
            </form>

        </main>
    </div>
    <footer class="border-top footer text-muted">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    &copy; 2024  Yahya FEKRANE - Rihab NIKH
                </div>
                <div class="col-md-6 text-right">
                    <a href="https://www.linkedin.com/in/rihab-nikh/" target="_blank" class="text-muted me-2"><i class="bi bi-linkedin"></i>Rihab's LinkedIn</a>
                    <a href="https://linkedin.com/in/yahya-fekrane" target="_blank" class="text-muted me-2"><i class="bi bi-linkedin"></i>Yahya's LinkedIn</a>
                    <a href="https://github.com/Rihab-nikh" target="_blank" class="text-muted me-2"><i class="bi bi-instagram"></i>Rihab's Github</a>
                    <a href="https://github.com/yahya-fk" target="_blank" class="text-muted"><i class="bi bi-github"></i>Yahya's GitHub</a>
                </div>
            </div>
        </div>
    </footer>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>