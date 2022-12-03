package pl.sda.hibernate.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;

import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Produkt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
//    @Enumerated(value = EnumType.STRING)
    private String kategoria;

    @Column(nullable = false)
    private String nazwa;

    @Formula("(SELECT (SUM(s.cena*s.ilosc)/SUM(s.ilosc)) FROM Sprzedaz s WHERE s.artykul_id=id)")
    private Double sredniaCenaSprzedazy;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "artykul")
    private Set<Sprzedaz> operacjeSprzedazy;

}
