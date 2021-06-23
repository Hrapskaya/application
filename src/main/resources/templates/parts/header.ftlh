<#macro header>
    <nav class="navbar">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">Test Application</a>

<#--            <#if ${}?? >-->
<#--                <form class="form-inline my-2 my-lg-0" action="/login">-->
<#--                    <button class="btn btn-outline-success my-2 my-sm-0">-->
<#--                        Login-->
<#--                    </button>-->
<#--                </form>-->
<#--            </sec:authorize>-->
<#--            <sec:authorize access="isAuthenticated()">-->
<#--                <nav class="navbar navbar-light bg-light">-->
<#--                    <span class="navbar-text">-->

<#--                    </span>-->
<#--                </nav>-->
<#--                <form class="form-inline my-2 my-lg-0">-->
<#--                    <button class="btn btn-outline-success my-2 my-sm-0"-->
<#--                            formaction="/exit">Exit-->
<#--                    </button>-->
<#--                </form>-->
<#--            </sec:authorize>-->

                        <form class="d-flex" action="/login">
                            <button class="btn " type="submit">Login</button>
                        </form>
                            <form class="form-inline my-2 my-lg-0">
                                <button class="btn btn-outline-success my-2 my-sm-0"
                                        formaction="/logout">Exit
                                </button>
                            </form>
        </div>
    </nav>
</#macro>