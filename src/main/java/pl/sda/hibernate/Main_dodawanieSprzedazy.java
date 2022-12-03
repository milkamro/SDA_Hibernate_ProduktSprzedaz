package pl.sda.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.hibernate.model.Produkt;
import pl.sda.hibernate.model.Sprzedaz;

import java.util.Scanner;

public class Main_dodawanieSprzedazy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj id produktu:");
        String idProduktu = sc.nextLine();
        Long id = Long.parseLong(idProduktu);

        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Produkt szukanyProdukt = session.get(Produkt.class, id);

            if (szukanyProdukt != null) {
                System.out.println("Podaj cene:");
                String dodawanaCena = sc.nextLine();
                double wartoscCeny = Double.parseDouble(dodawanaCena);

                System.out.println("Podaj ilosc:");
                int iloscProduktow = sc.nextInt();
                sc.nextLine();
                Sprzedaz nowaSprzedaz = Sprzedaz.builder()
                        .artykul(szukanyProdukt)
                        .cena(wartoscCeny)
                        .ilosc(iloscProduktow)
                        .build();

                session.persist(nowaSprzedaz);

            } else {
                System.err.println("Taki produkt nie istnieje");
            }

            transaction.commit();
        } catch (Exception e) {
            System.err.println("Błąd bazy");
        }
    }
}
