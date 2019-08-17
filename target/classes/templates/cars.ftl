<table>
    <tr>
        <th>Id</th>
        <th>Model</th>
        <th>Mark</th>
        <th>CreatedDate</th>
        <th>UpdatedDate</th>
    </tr>
    <tr>
    <#list carsList as car>
        <td>${car.id}</td>
        <td>${car.mark}</td>
        <td>${car.model}</td>
       <#-- <td>${car.createdDate}</td>
        <td>${car.updatedDate}</td>-->
    <#else>
        Cars list is empty!
    </#list>
    </tr>
</table>