package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Singleton Pattern
public class LibraryCatalog {
    private static LibraryCatalog instance;
    private Map<String, List<Book>> catalog = new HashMap<>();
    private List<LibraryMember> observers = new ArrayList<>(); // Lista de observatori

    private LibraryCatalog() {
        catalog.put("Fiction", new ArrayList<>());
        catalog.put("NonFiction", new ArrayList<>());
    }

    public static LibraryCatalog getInstance() {
        if (instance == null) {
            instance = new LibraryCatalog();
        }
        return instance;
    }

    public void addBook(String category, Book book) {
        List<Book> bookList = catalog.get(category);
        if (bookList != null) {
            bookList.add(book);
            System.out.println("Carte adăugată la catalog (" + category + "): " + book.getTitle());
            notifyObservers("O nouă carte a fost adăugată la catalog (" + category + "): " + book.getTitle());
        } else {
            System.out.println("Categorie de carte invalidă: " + category);
        }
    }

    public void removeBook(String category, Book book) {
        List<Book> bookList = catalog.get(category);
        if (bookList != null) {
            bookList.remove(book);
            System.out.println("\nCarte eliminată din catalog (" + category + "): " + book.getTitle());
            notifyObservers("O carte a fost eliminată din catalog (" + category + "): " + book.getTitle());
        } else {
            System.out.println("Categorie de carte invalidă: " + category);
        }
    }

    public void listCatalog(String category) {
        List<Book> bookList = catalog.get(category);
        if (bookList != null) {
            System.out.println("\nCatalogul bibliotecii (" + category + "):");
            for (Book book : bookList) {
                System.out.println("- " + book.getTitle());
            }
        } else {
            System.out.println("Categorie de carte invalidă: " + category);
        }
    }

    // Metode pentru adăugare și eliminare observatori
    public void addObserver(LibraryMember observer) {
        observers.add(observer);
    }

    public void removeObserver(LibraryMember observer) {
        observers.remove(observer);
    }

    // Metodă pentru a notifica observatorii
    private void notifyObservers(String message) {
        for (LibraryMember observer : observers) {
            observer.update(message);
        }
    }
}
