package pl.sda.hibernate;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import pl.sda.hibernate.model.Produkt;
import pl.sda.hibernate.model.Sprzedaz;

import java.util.List;
import java.util.Scanner;

public class Main_listy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Co wypisac (produkt / sprzedaz / sprzedazProduktu):");
        String wypisanaEncja = scanner.nextLine();

        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            if (wypisanaEncja.equalsIgnoreCase("produkt")) {
                TypedQuery<Produkt> zapytanie = session.createQuery("FROM Produkt", Produkt.class);
                List<Produkt> lista = zapytanie.getResultList();
                lista.forEach(System.out::println);

            } else if (wypisanaEncja.equalsIgnoreCase("sprzedaz")) {
                TypedQuery<Sprzedaz> zapytanie = session.createQuery("FROM Sprzedaz", Sprzedaz.class);
                List<Sprzedaz> lista = zapytanie.getResultList();
                lista.forEach(System.out::println);

            }
//            else if (wypisanaEncja.equalsIgnoreCase("sprzedazProduktu")) {
//            TypedQuery<Sprzedaz> zapytanie = session.createQuery("FROM Sprzedaz", Sprzedaz.class);
//            List<Sprzedaz> lista = zapytanie.getResultList();
//            lista.forEach(System.out::println);
//        }

        else {
                System.err.println("Nieznana komenda");
            }
        } catch (Exception e) {
            System.err.println("Błąd bazy");
        }
    }
}