<#macro login path isRegisterForm>
<form action="${path}" method="post">
    <#if isRegisterForm>
    <div class="form-group row">
        <label class="col-sm-6 col-form-label">
            To log in to your account, you need to specify a valid mobile phone number
            specified in the contract (for example, 79112345678).
        </label>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Phone: </label>
        <div class="col-sm-6">
            <input type="phone" class="form-control" name="phone" placeholder="">
        </div>
    </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Email: </label>
            <div class="col-sm-6">
                <input type="email" class="form-control" name="email" placeholder="some@some.com">
            </div>
        </div>
    </#if>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> User Name : </label>
        <div class="col-sm-6">
            <input type="text" class="form-control" name="username"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Password: </label>
        <div class="col-sm-6">
            <input type="password" class="form-control" name="password" placeholder="Password">
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <#if !isRegisterForm><a href="/registration">Add new user</a></#if>
    <button class="btn btn-primary" type="submit"><#if isRegisterForm>Create<#else>Sign In</#if></button>
</form>
</#macro>

<#macro logout>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button class="btn btn-primary" type="submit">Sign Out</button>
</form>
</#macro>