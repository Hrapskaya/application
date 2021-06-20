<#import "parts/common.ftlh" as common>
<@common.page>
    <div class="card col-8">
        <h5 class="card-header">Login form</h5>
        <form action="/login" method="post">
            <div><label> User Name : <input type="text" name="username"/> </label></div>
            <div><label> Password: <input type="password" name="password"/> </label></div>
            <div><input type="submit" value="Sign In"/></div>
        </form>
    </div>
</@common.page>