package com.knubisoft.graphql;

import com.knubisoft.graphql.model.Book;
import com.knubisoft.graphql.repository.BookRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class BookMutation implements GraphQLMutationResolver {

    @Autowired
    private BookRepository bookRepository;

    @MutationMapping
    public Book createBook(@Argument Integer id, @Argument String title, @Argument String author, @Argument int pages) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPages(pages);
        return bookRepository.save(book);
    }
}
