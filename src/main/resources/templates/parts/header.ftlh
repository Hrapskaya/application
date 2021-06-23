<#include "security.ftlh">
<#macro header>
    <nav class="navbar">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">Test Application</a>

            <#if user??>
                <div d-flex>
                        ${name}
                <form action="/logout">
                    <button class="btn " type="submit">Logout</button>
                </form>
                </div>
                <#else>
                    <form class="d-flex" action="/login">
                        <button class="btn " type="submit">Login</button>
                    </form>
            </#if>
        </div>
    </nav>
</#macro>