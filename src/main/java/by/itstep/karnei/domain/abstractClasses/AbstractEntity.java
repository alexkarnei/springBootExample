package by.itstep.karnei.domain.abstractClasses;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "CREATEDDATE", updatable = false)
    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;
}
