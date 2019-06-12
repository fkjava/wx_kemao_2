package org.fkjava.weixin.library.repository;

import org.fkjava.weixin.library.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// 这个接口跟MyBatis的Mapper接口是一个含义的，都是用来操作数据库的表。
@Repository
public interface BookRepository extends JpaRepository<Book, String> {

	Page<Book> findByDisabledFalse(Pageable pageable);

	Page<Book> findByDisabledFalseAndNameContaining(String keyword, Pageable pageable);

}
