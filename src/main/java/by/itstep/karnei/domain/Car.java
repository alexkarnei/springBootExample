package by.itstep.karnei.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "CREATEDDATE", updatable = false)
    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    @NotBlank(message = "Заполни поле")
    private String mark;

    @NotBlank(message = "Заполни поле")
    private String model;

    @NotBlank
    private String registrationNumber;

    @NotBlank(message = "Заполни меня")
    private String color;

   /* private LocalDate manufactureYear;*/

    /*public Car(LocalDateTime createdDate, LocalDateTime updatedDate,
               @NotBlank(message = "Заполни поле") String mark,
               @NotBlank(message = "Заполни поле") String model,
               @NotBlank String registrationNumber,
               @NotBlank(message = "Заполни меня") String color,
               LocalDate manufactureYear) {
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.mark = mark;
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.color = color;
       *//* this.manufactureYear = manufactureYear;*//*
    }

    public Car() {
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
*/
   /* public LocalDate getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(LocalDate manufactureYear) {
        this.manufactureYear = manufactureYear;
    }
*/
    /*public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
*/
}
