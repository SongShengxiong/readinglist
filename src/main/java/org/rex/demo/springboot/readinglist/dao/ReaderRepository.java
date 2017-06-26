package org.rex.demo.springboot.readinglist.dao;

import org.rex.demo.springboot.readinglist.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by RexSong on 2017/6/25.
 */
public interface ReaderRepository extends JpaRepository<Reader, String> {

}
