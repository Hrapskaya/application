<#include "security.ftlh">
<#macro menu>
    <ul class="nav flex-column">
        <li class="nav-item">
            <a class="nav-link" href="/user">List</a>
        </li>
        <#if user?? && isAdmin==true>
            <li class="nav-item">
                <a class="nav-link" href="/user/new">New</a>
            </li>
        </#if>
    </ul>
</#macro>