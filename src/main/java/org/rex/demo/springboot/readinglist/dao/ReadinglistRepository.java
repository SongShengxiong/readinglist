package org.rex.demo.springboot.readinglist.dao;

import org.rex.demo.springboot.readinglist.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by songsx-a on 2017/6/23.
 */
public interface ReadinglistRepository extends JpaRepository<Book, Long> {
    List<Book> findByReader(String reader);
}
