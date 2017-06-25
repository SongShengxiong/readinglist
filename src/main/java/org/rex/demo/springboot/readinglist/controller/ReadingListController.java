package org.rex.demo.springboot.readinglist.controller;

import org.rex.demo.springboot.readinglist.dao.ReadinglistRepository;
import org.rex.demo.springboot.readinglist.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by songsx-a on 2017/6/23.
 */
@Controller
@RequestMapping("/rl")
public class ReadingListController {

    private ReadinglistRepository readinglistRepository;

    @Autowired
    public ReadingListController(ReadinglistRepository readinglistRepository) {
        this.readinglistRepository = readinglistRepository;
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readersBooks(@PathVariable(name = "reader") String reader, Model model) {
        List<Book> readinglist = readinglistRepository.findByReader(reader);
        if (readinglist != null) {
            model.addAttribute("books", readinglist);
        }

        return "readingList";
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addToReadinglist(@PathVariable(name = "reader") String reader, Book book) {
        book.setReader(reader);
        readinglistRepository.save(book);
        return "redirect:/rl/{reader}";
    }
}
