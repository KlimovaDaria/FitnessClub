<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
User editor
    <form action = "/trainer" >
        <input type = "text" name = "name" value = "${trainer.name}">
        <input type = "text" name = "last_name" value = "${trainer.last_name}">
        <input type = "text" name = "qualification" value = "${trainer.qualification}">
        <input type = "hidden" name = "userId" value = "${trainer.id}">
        <input type = "hidden" name = "_csrf" value = "${_csrf.token}">
        <button type = "submit">Sign up</button>
    </form>
</@c.page>