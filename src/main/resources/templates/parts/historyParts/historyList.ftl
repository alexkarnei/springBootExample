<#import "../pager.ftl" as p>
<@p.pager url page/>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Notes</th>
        <th scope="col">Is Free</th>
        <th scope="col">Owner</th>
        <th scope="col">Car</th>
    </tr>
    </thead>
    <#list page.content as history>
        <tbody>
        <tr ${history.free?then("class='table-success'","class='alert-danger'")}>
            <#if history.id??>
                <td>${history.id}</td></#if>
            <#if history.notes??>
                <td>${history.notes}</td></#if>
            <#if history.free??>
                <td >${history.free?then( "true"," false")}</td></#if>
            <#if history.owner.id??>
                <td>${history.owner.id}</td></#if>
            <#if history.car.id??>
                <td>${history.car.id}</td></#if>

        </tr>
        </tbody>
    <#else>
       <tr> History list is empty!</tr>
    </#list>
</table>
<@p.pager url page/>