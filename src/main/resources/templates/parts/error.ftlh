<#macro error message>
    <#if message??>
    <div class="alert alert-warning col-6" role="alert">
        ${message}
    </div>
    </#if>
</#macro>