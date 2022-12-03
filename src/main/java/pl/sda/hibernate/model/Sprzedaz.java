package pl.sda.hibernate.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Sprzedaz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime dataCzasSprzedazy;

    private double cena;
    private int ilosc;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Produkt artykul;
}
