<#import "../pager.ftl" as p>
<@p.pager url page/>
<table class="table">
    <thead class="thead-light">
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Firstname</th>
        <th scope="col">Lastname</th>
        <#--  <th scope="col">CreatedDate</th>
          <th scope="col">UpdatedDate</th>-->
        <th scope="col">Surname</th>
        <th scope="col">Birthday</th>
        <th scope="col">Is deleted</th>
<#--        <th scope="col"></th>-->
<#--        <th scope="col"></th>-->
    </tr>
    </thead>
    <#list page.content as owner>
        <tbody>
<#--        <tr ${owner.deleted?then("class='alert-danger'","class='table-success'")}>-->
            <#if owner.id??>
                <td>${owner.id}</td></#if>
            <#if owner.firstName??>
                <td>${owner.firstName}</td></#if>
            <#if owner.lastname??>
                <td>${owner.lastname}</td></#if>
            <#-- <#if car.createdDate??>
                 <td>${car.createdDate}</td></#if>
             <#if car.updatedDate??>
                 <td>${car.updatedDate}</td></#if>-->
            <#if owner.surname??>
                <td>${owner.surname}</td></#if>
            <#if owner.birthday??>
                <td>${owner.birthday}</td></#if>
            <#if owner.deleted??>
                <td>${owner.deleted?then( "true"," false")}</td></#if>
<#--            <td><a href="owners?editOwner=${owner.id}">edit</a></td>-->
<#--            <td>${owner.deleted?then('<a href="owners?repareCar=${car.id}">repare</a>',-->
<#--                '<a href="cars?removeCar=${car.id}">remove</a>')}-->
            </td>
<#--        </tr>-->
        </tbody>
    <#else>
        Owners list is empty!
    </#list>
</table>
<@p.pager url page/>
