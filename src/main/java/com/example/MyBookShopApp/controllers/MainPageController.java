package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.services.AuthorService;
import com.example.MyBookShopApp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public MainPageController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping("/main")
    public String mainPage(Model model) {
        model.addAttribute("bookData", bookService.getBooksData());
        model.addAttribute("authorData", authorService.getAuthorsData());
        model.addAttribute("searchPlaceholder", "new search placeholder");
        return "index";
    }
}
