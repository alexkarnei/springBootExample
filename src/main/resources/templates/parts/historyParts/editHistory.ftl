<h3>Edit history</h3>
<#if savingReport??>
    <div>${savingReport}</div></#if>
<div class="form-group mt-3">
    <form method="post">
        <input type="hidden" name="id" value="<#if usingHistory?? && usingHistory.id??>${usingHistory.id}</#if>">
        <div class="form-group">
            <input type="text" name="notes"
                   value="<#if usingHistory?? && usingHistory.notes?? >${usingHistory.notes}</#if>"
                   placeholder="Enter the notes">
        </div>
        <div class="form-group">
            <input type="text" name="owner"
                   value="<#if usingHistory?? && usingHistory.owner??>${usingHistory.owner.id}</#if>"
                   placeholder="Enter the owner Id">
        </div>
        <div class="form-group">
            <input type="text" name="car"
                   value="<#if usingHistory?? &&usingHistory.car??>${usingHistory.car.id}</#if>"
                   placeholder="Enter the car Id">
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div class="form-group mt-2">
            <input class="btn btn-primary" type="submit" value="Submit"/>
        </div>
    </form>
</div>