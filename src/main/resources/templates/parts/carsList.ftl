<#import "pager.ftl" as p>
<@p.pager url page/>
<table>
    <tr>
        <th>Id</th>
        <th>Mark</th>
        <th>Model</th>
        <th>CreatedDate</th>
        <th>UpdatedDate</th>
        <th>Vin</th>
        <th>Color</th>
        <th>Is deleted</th>

    </tr>
    <#list page.content as car>
        <tr>
            <#if car.id??>
                <td>${car.id}</td></#if>
            <#if car.mark??>
                <td>${car.mark}</td></#if>
            <#if car.model??>
                <td>${car.model}</td></#if>
            <#if car.createdDate??>
                <td>${car.createdDate}</td></#if>
            <#if car.updatedDate??>
                <td>${car.updatedDate}</td></#if>
            <#if car.vin??>
                <td>${car.vin}</td></#if>
            <#if car.color??>
                <td>${car.color}</td></#if>
            <#if car.deleted??>
                <td>${car.deleted?then("true","false")}</td></#if>
            <td><a href="cars?editCar=${car.id}">edit</a></td>
            <td>${car.deleted?then('<a href="cars?repareCar=${car.id}">repare</a>',
                '<a href="cars?removeCar=${car.id}">remove</a>')}
            </td>
        </tr>
    <#else>
        Cars list is empty!
    </#list>
</table>
<@p.pager url page/>