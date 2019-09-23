<#import "../pager.ftl" as p>
<@p.pager url page/>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Mark</th>
        <th scope="col">Model</th>
      <#--  <th scope="col">CreatedDate</th>
        <th scope="col">UpdatedDate</th>-->
        <th scope="col">Vin</th>
        <th scope="col">Color</th>
        <th scope="col">Is deleted</th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>
    <#list page.content as car>
        <tbody>
        <tr ${car.deleted?then("class='alert-danger'","class='table-success'")}>
            <#if car.id??>
                <td>${car.id}</td></#if>
            <#if car.mark??>
                <td>${car.mark}</td></#if>
            <#if car.model??>
                <td>${car.model}</td></#if>
           <#-- <#if car.createdDate??>
                <td>${car.createdDate}</td></#if>
            <#if car.updatedDate??>
                <td>${car.updatedDate}</td></#if>-->
            <#if car.vin??>
                <td>${car.vin}</td></#if>
            <#if car.color??>
                <td>${car.color}</td></#if>
            <#if car.deleted??>
                <td >${car.deleted?then( "true"," false")}</td></#if>
            <td><a href="cars?editCar=${car.id}">edit</a></td>
            <td>${car.deleted?then('<a href="cars?repareCar=${car.id}">repare</a>',
                '<a href="cars?removeCar=${car.id}">remove</a>')}
            </td>
        </tr>
        </tbody>
    <#else>
        Cars list is empty!
    </#list>
</table>
<@p.pager url page/>