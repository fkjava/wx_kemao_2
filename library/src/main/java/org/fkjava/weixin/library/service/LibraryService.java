package org.fkjava.weixin.library.service;

import org.fkjava.weixin.library.domain.Book;
import org.fkjava.weixin.library.domain.DebitList;
import org.springframework.data.domain.Page;

public interface LibraryService {

	// Spring Data的Page对象表示一页数据
	public Page<Book> search(String keyword, int pageNumber);

	public void add(String id, DebitList debitList);

	public void remove(String id, DebitList debitList);
}
