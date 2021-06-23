<#import "parts/pagination.ftlh" as p>
<#import "parts/common.ftlh" as common>
<@common.page>
    <form action="/user" >
        <label>
            UserNameFilter:
            <input type="text" name="filterUsername"/>
        </label>
        <label>
            UserRoleFilter:
            <select class="form-select" aria-label="UserRoleFilter" name="filterUserRole">
                <option value="">None</option>
                <option value="USER">User</option>
                <option value="ADMIN">Admin</option>
            </select>
        </label>
        <input type="submit" value="Submit">
    </form>
<table class="table">
    <thead>
    <tr>
        <th scope="col">UserName</th>
        <th scope="col">FirstName</th>
        <th scope="col">LastName</th>
        <th scope="col">Role</th>
        <th scope="col">Status</th>
        <th scope="col">Created at</th>
    </tr>
    </thead>
    <tbody>
    <#list userPage.content as user>
    <tr>
        <th scope="row"><a href="/user/${user.id}">${user.username}</a></th>
        <td>${user.firstName}</td>
        <td>${user.lastName}</td>
        <td>${user.role}</td>
        <td>${user.status}</td>
        <td>${user.createdAt}</td>
    </tr>
    </#list>
    </tbody>
</table>

<@p.pagination "/user" userPage />
</@common.page>