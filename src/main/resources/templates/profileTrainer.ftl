<#import "parts/common.ftl" as c>

<@c.page>
    <form method="post" >
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Name: </label>
            <div class="col-sm-4">
                <input type="text" class="form-control" name="name" placeholder="" value="${(trainer.name!"")?ifExists}">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Last Name: </label>
            <div class="col-sm-4">
                <input type="lastName" class="form-control" name="lastName" placeholder="" value="${(trainer.lastName!"")?ifExists}">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Objective : </label>
            <div class="col-sm-4">
                <input type="text" class="form-control" name="objective" value="${(trainer.qualification!"")?ifExists}"/>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div class="form-group">
            <button type="submit" class="btn btn-primary">Save</button>
        </div>
    </form>

</@c.page>