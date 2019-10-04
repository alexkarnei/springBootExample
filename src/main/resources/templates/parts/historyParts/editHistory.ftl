<h3>Edit history</h3>
<#if savingReport??><div>${savingReport}</div></#if>
<div class="form-group mt-3">
    <form method="post" >

        <input type="hidden" name="id" value="<#if usingHistory?? && usingHistory.id??>${car.id}</#if>">
        <div class="form-group">
            <input type="text" name="notes"
                   <#--class="form-control ${(markError??)?string('is-invalid', '')}"-->
                   value="<#if usingHistory??>${usingHistory.notes}</#if>" placeholder="Enter the notes">
            <#--<#if markError??>
                <div class="invalid-feedback">
                    ${markError}
                </div>
            </#if>-->
        </div>
        <div class="form-group">
            <input type="text" name="owner"
                  <#-- class="form-control ${(modelError??)?string('is-invalid', '')}"-->
                   value="<#if usingHistory??>${usingHistory.owner.id}</#if>" placeholder="Enter the owner Id">
           <#-- <#if modelError??>
                <div class="invalid-feedback">
                    ${modelError}
                </div>
            </#if>-->
        </div>
        <div class="form-group">
            <input type="text" name="car"
              <#--     class="form-control ${(colorError??)?string('is-invalid', '')}"-->
                   value="<#if usingHistory??>${usingHistory.car.id}</#if>" placeholder="Enter the car Id">
          <#--  <#if colorError??>
                <div class="invalid-feedback">
                    ${colorError}
                </div>
            </#if>-->
        </div>
       <#-- <div class="form-group">
            <input type="text" name="vin"
                   class="form-control ${(vinError??)?string('is-invalid', '')}"
                   value="<#if car??>${car.vin}</#if>" placeholder="Enter the number">
            <#if vinError??>
                <div class="invalid-feedback">
                    ${vinError}
                </div>
            </#if>
        </div>-->
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div class="form-group mt-2">
            <input class="btn btn-primary" type="submit" value="Submit"/>
        </div>
    </form>
</div>