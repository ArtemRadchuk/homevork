package service.impl;

import lombok.RequiredArgsConstructor;

import model.Author;
import org.springframework.stereotype.Service;
import repository.impl.AuthorRepositoryImpl;
import service.AuthorService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepositoryImpl authorRepository;

    @Override
    public Author createAuthor(String name) {
        Author author = new Author();
        author.setName(name);
        authorRepository.create(author);
        return author;
    }

    @Override
    public void deleteAuthorById(int id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<Author> authorList() {
       return authorRepository.findAll();
    }

    @Override
    public Author findAuthor(String name) {
        return authorRepository.findByName(name);
    }

  /*  @Override
    public void deleteAuthor(Author author) {

    }*/


}
