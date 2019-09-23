<h3>Edit owner</h3>
<#if savingReport??><div>${savingReport}</div></#if>
<div class="form-group mt-3">
    <form method="post" >

        <input type="hidden" name="id" value="<#if owner?? && owner.id??>${owner.id}</#if>">

        <div class="form-group">
            <input type="text" name="firstName"
                   class="form-control ${(firstNameError??)?string('is-invalid', '')}"
                   value="<#if owmer??>${owner.firstName}</#if>" placeholder="Enter the firstName">
            <#if firstNameError??>
                <div class="invalid-feedback">
                    ${firstNameError}
                </div>
            </#if>
        </div>
        <div class="form-group">
            <input type="text" name="lastname"
                   class="form-control ${(lastname??)?string('is-invalid', '')}"
                   value="<#if owner??>${owner.lastname}</#if>" placeholder="Enter the lastname">
            <#if lastnameError??>
                <div class="invalid-feedback">
                    ${lastnameError}
                </div>
            </#if>
        </div>
        <div class="form-group">
            <input type="text" name="surname"
                   class="form-control ${(surnameError??)?string('is-invalid', '')}"
                   value="<#if car??>${owner.surname}</#if>" placeholder="Enter the surname">
            <#if surnameError??>
                <div class="invalid-feedback">
                    ${surnameError}
                </div>
            </#if>
        </div>
        <div class="form-group">
            <input type="date" name="birth"
                   class="form-control ${(birthError??)?string('is-invalid', '')}"
                   value="<#if owner??>${owner.birthday}</#if>" placeholder="Enter the number">
            <#if vinError??>
                <div class="invalid-feedback">
                    ${birthdayError}
                </div>
            </#if>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div class="form-group mt-2">
            <input class="btn btn-primary" type="submit" value="Submit"/>
        </div>
    </form>
</div>