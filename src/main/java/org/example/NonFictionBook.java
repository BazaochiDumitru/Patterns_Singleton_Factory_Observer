package org.example;

// Factory Method Pattern
public class NonFictionBook implements Book {
    private String title;

    public NonFictionBook(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
