package com.knubisoft.graphql.controller;

import com.knubisoft.graphql.model.Book;
import com.knubisoft.graphql.repository.BookRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.kickstart.tools.GraphQLResolver;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController implements GraphQLQueryResolver {

    @Autowired
    private BookRepository bookRepository;

    @SchemaMapping(typeName = "Query", value = "allBooks")
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @QueryMapping
    public Optional<Book> findOne(@Argument Integer id) {
        return bookRepository.findById(id);
    }

}
