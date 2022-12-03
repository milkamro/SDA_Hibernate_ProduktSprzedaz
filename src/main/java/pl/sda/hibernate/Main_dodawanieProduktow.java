package pl.sda.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.hibernate.model.Kategoria;
import pl.sda.hibernate.model.Produkt;

import java.util.Scanner;

public class Main_dodawanieProduktow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Podaj nazwe produktu:");
        String nazwa = sc.nextLine();

        System.out.println("Podaj kategorie ZYWNOSC,NAPOJE,PRZEMYSLOWE,INNE:");
        String kategoriaProduktu = sc.nextLine();
//        kategoriaProduktu = kategoriaProduktu.toUpperCase();
//        Kategoria kategoria = Kategoria.valueOf(kategoriaProduktu);

        Produkt produkt = Produkt.builder()
                .kategoria(kategoriaProduktu)
                .nazwa(nazwa)
                .build();

        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.persist(produkt);

            transaction.commit();
        } catch (Exception e) {
            System.err.println("Błąd dodawania produktu do bazy");
        }
    }
}