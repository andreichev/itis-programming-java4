package ru.itis.hibernateexample.model;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String color;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @Override
    public String toString() {
        return "Car " +
                "id=" + id +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", driver=" + driver;
    }
}
