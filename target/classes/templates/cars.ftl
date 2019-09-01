<#import "parts/pageTemplate.ftl" as pt>
<@pt.page>
    <#include "parts/carsList.ftl">
    <h3> Edit car </h3>
    <#if savingReport??>${savingReport}</#if>

    <form method="post">
        <input type="hidden" name="id" value="<#if oneCar?? && oneCar.id??>${oneCar.id}</#if>">
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
</@pt.page>