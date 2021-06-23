<#import "parts/common.ftlh" as common>
<#import "parts/error.ftlh" as e>
<@common.page>
    <#if error??>
        <@e.error error/>
    </#if>
    <#if userAccount??>
        <div class="card col-6">
            <div class="card-header">
                ${userAccount.username}
                <a href="/user/${userAccount.id}/edit" class="btn btn-primary col-2">Edit</a>
            </div>
            <div class="card-body">
                <table class="table table-borderless">
                    <tbody>
                    <tr>
                        <td>First name:</td>
                        <td>${userAccount.firstName}</td>
                    </tr>
                    <tr>
                        <td>Last name:</td>
                        <td>${userAccount.lastName}</td>
                    </tr>
                    <tr>
                        <td>Created At:</td>
                        <td>${userAccount.createdAt}</td>
                    </tr>
                    <tr>
                        <td>Role:</td>
                        <td>${userAccount.role}</td>
                    </tr>
                    <tr>
                        <td>Status:</td>
                        <td>${userAccount.status}</td>
                    </tr>
                    </tbody>
                </table>
                <a href="/user/${userAccount.id}?changeLock" class="btn btn-primary">Lock/Unlock</a>
            </div>
        </div>
    </#if>
</@common.page>