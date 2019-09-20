package by.itstep.karnei.domain;

import by.itstep.karnei.domain.abstractClasses.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class Owner extends AbstractEntity {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastname;

    @NotBlank
    private String surname;

    private LocalDate birthday;


}
