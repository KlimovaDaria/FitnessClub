<#import "parts/common.ftl" as c>

<@c.page>



<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" >
    Edit profile
</a>


<div class = "collapse" id = "collapseExample" >
    <form method="post" >
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Name: </label>
        <div class="col-sm-4">
            <input type="text" class="form-control" name="name" placeholder="" value="${(customer.name!"")?ifExists}">
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Last Name: </label>
        <div class="col-sm-4">
            <input type="lastName" class="form-control" name="lastName" placeholder="" value="${(customer.lastName!"")?ifExists}">
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Objective : </label>
        <div class="col-sm-4">
            <input type="text" class="form-control" name="objective" value="${(customer.objective!"")?ifExists}"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Weight: </label>
        <div class="col-sm-1">
            <input type="number" class="form-control" name="weight" placeholder="" value="${(customer.weight!"")?ifExists}">
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Growth: </label>
        <div class="col-sm-1">
            <input type="number" class="form-control" name="growth"  placeholder="" value="${(customer.growth!"")?ifExists}">
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <div class="form-group">
        <button type="submit" class="btn btn-primary">Save</button>
    </div>
    </form>
</div>

</@c.page>