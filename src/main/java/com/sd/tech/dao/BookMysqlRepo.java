package com.sd.tech.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sd.tech.model.Book;

@Repository("bmyql")
public interface BookMysqlRepo extends JpaRepository<Book, Integer> {

}
