package org.example;

// Observer Pattern
public class LibraryUser implements LibraryMember {
    private String name;

    public LibraryUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " a primit o notificare: " + message);
    }
}
