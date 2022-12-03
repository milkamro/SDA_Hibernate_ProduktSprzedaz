package pl.sda.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.hibernate.model.Produkt;
import pl.sda.hibernate.model.Sprzedaz;

import java.util.Scanner;

public class Main_usun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            System.out.println("Co chcesz usunac: (produkt / sprzedaz)");
            String encjaUsuwana = sc.nextLine();
            if (encjaUsuwana.equalsIgnoreCase("sprzedaz")) {

                System.out.println("Podaj id sprzedazy którą chcesz usunać:");
                String id = sc.nextLine();
                Long sprzedazId = Long.parseLong(id);

                Sprzedaz sprzedaz = session.get(Sprzedaz.class, sprzedazId);
                if (sprzedaz != null) {
                                        session.remove(sprzedaz);
                } else {
                    System.err.println("Sprzedaz nie istnieje");
                }
            } else if (encjaUsuwana.equalsIgnoreCase("produkt")) {

                System.out.println("Podaj id produktu do usuniecia:");
                String id = sc.nextLine();
                Long produktId = Long.parseLong(id);

                Produkt produkt = session.get(Produkt.class, produktId);
                if (produkt != null) {
                                        if (!produkt.getOperacjeSprzedazy().isEmpty()) {

                        for (Sprzedaz sprzedaz : produkt.getOperacjeSprzedazy()) {
                            session.remove(sprzedaz);
                        }
                    }
                    session.remove(produkt);
                } else {
                    System.err.println("Produkt nie istnieje.");
                }
            }
            transaction.commit();
        } catch (Exception ioe) {
                  System.err.println("Błąd bazy: " + ioe);
        }
    }
}
