<#import "parts/pagination.ftlh" as p>
<#import "parts/common.ftlh" as common>
<@common.page>
    <form action="/user" >
        <label>
            UserNameFilter:
            <input type="text" name="filterUsername" value="<#if filterUsername??>${filterUsername}</#if>"/>
        </label>
        <label>
            UserRoleFilter:
            <select class="form-select" aria-label="UserRoleFilter" name="filterUserRole">
                <option value="">None</option>
                <option <#if filterUserRole?? && filterUserRole=='USER'>selected</#if> value="USER">
                    User
                </option>
                <option <#if filterUserRole?? && filterUserRole=='ADMIN'>selected</#if> value="ADMIN">
                    Admin
                </option>
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
<#assign filter=""/>
    <#if filterUserRole??>
        <#assign filter ="&filterUserRole=${filterUserRole}"/>
    </#if>
    <#if filterUsername??>
        <#assign filter ="${filter}&filterUsername=${filterUsername}"/>
    </#if>
<@p.pagination "/user" userPage filter/>
</@common.page>