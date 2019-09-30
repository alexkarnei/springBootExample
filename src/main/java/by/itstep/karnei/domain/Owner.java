package by.itstep.karnei.domain;

import by.itstep.karnei.domain.abstractClasses.AbstractEntity;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

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

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "owner")
    Set<UsingHistory> ownerHistory;
}
