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
            <#if car.id??>
                <td>${car.id}</td>
            </#if>
            <#if car.mark??>
                <td>${car.mark}</td></#if>
            <#if car.model??>
                <td>${car.model}</td></#if>
            <#if car.createdDate??>
                <td>${car.createdDate}</td></#if>
            <#if car.updatedDate??>
                <td>${car.updatedDate}</td></#if>
        <#else>
            Cars list is empty!
        </#list>
    </tr>
</table>
<form method="post">
    <input type="text" name="mark" value="" placeholder="Enter the mark">
    <input type="text" name="model" value="" placeholder="Enter the model">
    <input type="submit" name="Submit">
</form>