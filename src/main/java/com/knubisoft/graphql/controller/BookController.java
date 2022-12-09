package com.knubisoft.graphql.controller;

import com.knubisoft.graphql.model.Book;
import com.knubisoft.graphql.repository.BookRepository;
import graphql.kickstart.tools.GraphQLResolver;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController implements GraphQLResolver {

    private final List<Book> books = new ArrayList<>();

    @SchemaMapping(typeName = "Query",value = "allBooks")
    public List<Book> findAll() {
        return books;
    }
    @QueryMapping
    public Book findOne(@Argument  Integer id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }
    @MutationMapping
    public Book createBook(@Argument Integer id, @Argument String title, @Argument String author, @Argument  int pages) {
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setAuthor(author);
        book.setPages(pages);
        books.add(book);
        return book;
    }
}
