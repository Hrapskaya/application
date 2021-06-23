<#import "parts/common.ftlh" as common>
<@common.page>


    <form action="/user/edit" method="post">
        <div class="row mb-3">
            <div class="col-sm-6">
                    <#if userAccount??>
                        <h3>${userAccount.username}</h3>
                        <input type="hidden" name="username" value="${userAccount.username}"/>
                    </#if>
            </div>
        </div>
        <div class="row mb-3">
            <label for="firstName" class="col-sm-2 col-form-label">First Name :</label>
            <div class="col-sm-6">
                <input id="firstName" type="text" name="firstName"
                       value="<#if userAccount??>${userAccount.firstName}</#if>"
                       class="form-control ${(firstNameError??)?string('is-invalid', '')}"
                       placeholder="First name"/>
                <#if firstNameError??>
                    <div class="invalid-feedback">
                        ${firstNameError}
                    </div>
                </#if>
            </div>
        </div>

        <div class="mb-3 row">
            <label for="lastName" class="col-sm-2 col-form-label">Last Name :</label>
            <div class="col-sm-6">
                <input id="lastName" type="text" name="lastName"
                       value="<#if userAccount??>${userAccount.lastName}</#if>"
                       class="form-control ${(lastNameError??)?string('is-invalid', '')}"
                       placeholder="Last name"/>
                <#if lastNameError??>
                    <div class="invalid-feedback">
                        ${lastNameError}
                    </div>
                </#if>
            </div>
        </div>

        <div class="mb-3 row">
            <label for="password" class="col-sm-2 col-form-label">Password:</label>
            <div class="col-sm-6">
                <input id="password" type="password" name="password"
                       class="form-control ${(passwordError??)?string('is-invalid', '')}"
                       placeholder="Password"/>
                <#if passwordError??>
                    <div class="invalid-feedback">
                        ${passwordError}
                    </div>
                </#if>
            </div>
        </div>

        <div class="mb-3 row">
            <label for="repeatPassword" class="col-sm-2 col-form-label">Password:</label>
            <div class="col-sm-6">
                <input id="repeatPassword" type="password" name="repeatPassword"
                       class="form-control ${(repeatPasswordError??)?string('is-invalid', '')}"
                       placeholder="Repeat password"/>
                <#if repeatPasswordError??>
                    <div class="invalid-feedback">
                        ${repeatPasswordError}
                    </div>
                </#if>
            </div>
        </div>
        <div class="mb-3 row">
            <div class="dropdown">
                <select name="status">
                    <option value="ACTIVE">Active</option>
                    <option value="INACTIVE">Inactive</option>
                </select>
                <select name="role">
                    <option value="USER">User</option>
                    <option value="ADMIN">Admin</option>
                </select>
            </div>
        </div>
        <div class="mb-3 row">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button class="btn btn-primary" type="submit">Save</button>
        </div>
    </form>

</@common.page>
