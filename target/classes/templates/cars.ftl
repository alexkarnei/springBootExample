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
    <#list carsList as car>
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

<h3> Car edit </h3>
<#if savingReport??>${savingReport}></#if>

<form method="post">
    <input type="text" name="mark" value="<#if oneCar??>${oneCar.mark}</#if>" placeholder="Enter the mark">
    <br><#if markError??>${markError}</#if><br>
    <input type="text" name="model" value="<#if oneCar??>${oneCar.model}</#if>" placeholder="Enter the model">
    <br><#if modelError??>${modelError}</#if><br>
    <input type="text" name="vin"
           value="<#if oneCar?? && oneCar.vin??>${oneCar.vin}</#if>"
           placeholder="Enter vin">
    <br><#if vinError??>${vinError}</#if><br>
    <input type="color" name="color" value="<#if oneCar?? && oneCar.color??>${oneCar.color}</#if>"
           placeholder="Enter the color">
    <br><#if colorError??>${colorError}</#if><br>
    <#--   <input type="text" name="manufactureYear" value="<#if oneCar??>${oneCar.manufactureYear}</#if>" placeholder="Enter the manufacture year">
       <br><#if manufactureYearError??>${ManufactureYear}</#if><br>-->
    <input type="submit" value="Submit">
</form>
