<table>
    <tr>
        <th>Id</th>
        <th>Model</th>
        <th>Mark</th>
        <th>CreatedDate</th>
        <th>UpdatedDate</th>
        <th>Registration Number</th>
        <th>Color</th>
        <th>Manufacture Year</th>
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
            <#if car.registrationNumber??>
                <td>${car.registrationNumber}</td></#if>
            <#if car.color??>
                <td>${car.color}</td></#if>
           <#-- <#if car.manufactureYear??>
                <td>${car.manufactureYear}</td></#if>-->
        </tr>
    <#else>
        Cars list is empty!
    </#list>
</table>
<form method="post">
    <input type="text" name="mark" value="<#if oneCar??>${oneCar.mark}</#if>" placeholder="Enter the mark">
    <br><#if markError??>${markError}</#if><br>
    <input type="text" name="model" value="<#if oneCar??>${oneCar.model}</#if>" placeholder="Enter the model">
    <br><#if modelError??>${modelError}</#if><br>
    <input type="text" name="registrationNumber" value="<#if oneCar??>${oneCar.registrationNumber}</#if>" placeholder="Enter the registration number">
    <br><#if registrationNumberError??>${registrationNumberError}</#if><br>
    <input type="color" name="color" value="<#if oneCar??>${oneCar.color}</#if>" placeholder="Enter the color">
    <br><#if colorError??>${colorError}</#if><br>
 <#--   <input type="text" name="manufactureYear" value="<#if oneCar??>${oneCar.manufactureYear}</#if>" placeholder="Enter the manufacture year">
    <br><#if manufactureYearError??>${ManufactureYear}</#if><br>-->
    <input type="submit" value="Submit">
</form>