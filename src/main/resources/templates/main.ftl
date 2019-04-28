<#import "parts/common.ftl" as c>

<@c.page>

<div class="form-row">
    <div class="form-group col-md-6">
        <form method="get" action="/main" class="form-inline">
            <input type="text" name="filter" class="form-control" placeholder="Search by tag">
            <button type="submit" class="btn btn-primary ml-2">Search</button>
        </form>
    </div>
</div>




    <#list trainers as trainer>
        <div class="card my-3">

            <div class="m-2">
                <a href = "/trainer"><span>${trainer.name} ${trainer.lastName}</span></br></a>
                <i>${trainer.qualification}</i>
            </div>
        </div>

    <#else>
No trainers
    </#list>

</@c.page>