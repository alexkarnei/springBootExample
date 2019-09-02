<#import "parts/pageTemplate.ftl" as pt>
<@pt.page>
    <#include "parts/carsList.ftl">
    <h3> Edit car </h3>
    <#if savingReport??>${savingReport}</#if>
    <div class="form-group mt-3">
        <form method="post">
            <input type="hidden" name="id" value="<#if oneCar?? && oneCar.id??>${oneCar.id}</#if>">
            <div class="form-group">
                <input type="text" name="mark"
                       class="form-control ${(markError??)?string('is-invalid', '')}"
                       value="<#if oneCar??>${oneCar.mark}</#if>" placeholder="Enter the mark">
                <#if markError??>
                <div class="invalid-feedback">
                    ${markError}
                </div>
                </#if>
            </div>
            <div class="form-group">
                <input type="text" name="model"
                       class="form-control ${(modelError??)?string('is-invalid', '')}"
                       value="<#if oneCar??>${oneCar.model}</#if>"
                       placeholder="Enter the model">
                <#if modelError??>
                <div class="invalid-feedback">
                    ${modelError}
                </div>
                </#if>
            </div>
            <div class="form-group">
                <input type="text" name="vin"
                       class="form-control ${(vinError??)?string('is-invalid', '')}"
                       value="<#if oneCar?? && oneCar.vin??>${oneCar.vin}</#if>"
                       placeholder="Enter vin">
                <#if vinError??>
                <div class="invalid-feedback">
                    ${vinError}
                </div>
                </#if>
            </div>
            <div class="form-group">
                <input type="color" name="color"
                       class="form-control ${(vinError??)?string('is-invalid', '')}"
                       value="<#if oneCar?? && oneCar.color??>${oneCar.color}</#if>"
                       placeholder="Enter the color">
                <#if colorError??>
                <div class="invalid-feedback">
                    ${colorError}
                </div>
                </#if>
            </div>
            <#--   <input type="text" name="manufactureYear" value="<#if oneCar??>${oneCar.manufactureYear}</#if>" placeholder="Enter the manufacture year">
               <br><#if manufactureYearError??>${ManufactureYear}</#if><br>-->
            <div class="form-group mt-2">
                <input class="btn btn-primary" type="submit" value="Submit">
            </div>
        </form>
    </div>
</@pt.page>