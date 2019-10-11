package by.itstep.karnei.domain;

import by.itstep.karnei.domain.abstractClasses.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
public class Car extends AbstractEntity {

    @NotBlank(message = "Заполни поле")
    private String mark;

    @NotBlank(message = "Заполни поле")
    private String model;

    @Pattern(regexp = "[a-z0-9]{17}")
    private String vin;

    @NotBlank(message = "Заполни меня")
    private String color;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "car")
            @JsonIgnore
    Set<UsingHistory> carsHistory;
}
