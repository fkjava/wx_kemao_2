package org.fkjava.weixin.library.domain;

import java.util.List;

// 这个类不需要放入数据库，只是在内存里面使用
public class DebitList {

	// 准备借阅哪些图书
	private List<Book> books;

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
