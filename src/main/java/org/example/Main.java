package org.example;

public class Main {
    public static void main(String[] args) {
        LibraryCatalog catalog = LibraryCatalog.getInstance();

        Book fictionBook1 = new FictionBook("Moby-Dick");
        Book fictionBook2 = new FictionBook("O călătorie spre centrul Pământului");
        Book nonFictionBook1 = new NonFictionBook("Arta Razboiului");
        Book nonFictionBook2 = new NonFictionBook("Sapiens: A Brief History of Humankind");

        catalog.addBook("Fiction", fictionBook1);
        catalog.addBook("Fiction", fictionBook2);
        catalog.addBook("NonFiction", nonFictionBook1);
        catalog.addBook("NonFiction", nonFictionBook2);

        catalog.listCatalog("Fiction");
        catalog.listCatalog("NonFiction");

        LibraryMember user1 = new LibraryUser("Alice");
        LibraryMember user2 = new LibraryUser("Bob");

        catalog.addObserver(user1);
        catalog.addObserver(user2);

        catalog.removeBook("Fiction", fictionBook1);
        catalog.removeBook("NonFiction", nonFictionBook1);
    }
}










/*
Acest proiect simplu de gestionare a bibliotecii folosește Singleton Pattern pentru a crea un catalog unic,
Factory Method Pattern pentru a crea cărți de ficțiune și non-ficțiune,
și Observer Pattern pentru a notifica membrii bibliotecii despre evenimente legate de cărți.
*/