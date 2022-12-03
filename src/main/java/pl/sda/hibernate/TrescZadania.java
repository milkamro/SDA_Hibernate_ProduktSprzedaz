package pl.sda.hibernate;

public class TrescZadania {

//    Modele:
//    1. Produkt
//    - nazwa
//    - kategoria (ZYWNOSC, NAPOJE, INNE)
//      * (dodatkowe / Formula) średnia [ważona] cena sprzedaży produktu
//            (SUM(cena*ilosc)/SUM(ilosc))  // dziekować: @Dominik Kowalczyk
//    2. Sprzedaż (sprzedaż produktu)
//    - data i czas (creation timestamp)
//    - cena
//    - ilosc


//    Stwórz program który umożliwia:
//    - dodawanie produktów
//    - dodawanie sprzedaży (do istniejących produktów)
//    - wyświetlanie listy produktów
//    - wyświetlanie listy sprzedaży
//    - wyświetlanie listy sprzedaży danego produktu
//    - usuwanie sprzedaży
//    - usuwanie produktu (jeśli produkt ma sprzedaże, to usuwamy sprzedaże również)
//      * (dodatkowe) usuwanie produktu 2 (jeśli produkt ma sprzedaże, to nie usuwamy sprzedaży, tylko ustawiamy produkt w sprzedaży na null)
}


//    Zadanie domowe (create):
//        Stwórz zapytania SQL do stworzenia struktury bazy (tabel produkt i sprzedaz).
//        Zadanie domowe (insert):
//        Stwórz zapytania insert które dodadzą:
//        założenie: mamy kategorie produktu: PRZEMYSLOWE, ZYWNOSC, INNE
//        3 (dowolne) produkty żywnościowe + 1 do 5 sprzedaży danego produktu w okresie 01.01.2020 do 01.03.2020
//        3 (dowolne) produkty przemyslowe + 1 do 5 sprzedaży danego produktu w okresie 01.01.2020 do 01.03.2020
//        3 (dowolne) produkty inne + 1 do 5 sprzedaży danego produktu w okresie 01.01.2020 do 01.03.2020
//        produkt "trutka" w kategorii "ZYWNOSC"
//        Zadanie domowe (select):
//        Mając bazę danych taką jak na powyższym rysunku stwórz zapytania SQL (klasyczne select'y) do:
//        szukania produktu po nazwie kategorii 'ZYWNOSC'
//        szukania unikalnych produktow ktore byly spzedawane pomiedzy 10 stycznia a 20 lutego
//        szukania unikalnych produktów których cena nigdy nie przekroczyła 10 zł
//        Zadanie domowe (update):
//        stwórz zapytanie aktualizujące wszystkie kategorie produktu którego nazwa zawiera 'trutka' z ZYWNOSC na PRZEMYSŁOWE
//        stworz zapytanie aktualizujące cenę wszystkich sprzedaży produktów o nazwie 'masło' sprzedanych w ciągu ostatnich 3 godzin