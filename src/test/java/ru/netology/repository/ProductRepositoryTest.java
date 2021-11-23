package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NonexistentIdException;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repo = new ProductRepository();
    private Product first = new Book(1, "Pride and Prejudice", 500, "Jane Austen");
    private Product second = new Book(2, "The Green Mile", 450, "Stephen King");
    private Product third = new Book(3, "Emma", 400, "Jane Austen");

    @BeforeEach
    public void setUp() {
        repo.save(first);
        repo.save(second);
        repo.save(third);
    }

    @Test
    void shouldRemoveByExistingId() {

        repo.removeById(2);

        Product[] expected = new Product[]{first, third};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByNonexistentId() {

        assertThrows(NonexistentIdException.class, () -> {
            repo.removeById(4);
        });
    }
}