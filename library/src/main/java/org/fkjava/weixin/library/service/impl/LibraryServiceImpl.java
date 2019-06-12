package org.fkjava.weixin.library.service.impl;

import org.fkjava.weixin.library.domain.Book;
import org.fkjava.weixin.library.repository.BookRepository;
import org.fkjava.weixin.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class LibraryServiceImpl implements LibraryService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public Page<Book> search(String keyword, int pageNumber) {

		// 1.封装分页条件，因为是基于Spring Data的，所以Spring Data本身就提供了分页封装
		// 10 : 表示每页最多10条数据
		Pageable pageable = PageRequest.of(pageNumber, 10);

		// 2.利用关键字进行搜索，得到Page对象
		Page<Book> page;
		if (StringUtils.isEmpty(keyword)) {
			// 没有关键字，只需要查询全部可用数据即可
			// find 表示生成select语句
			// Disabled 表示用户实体对象（Book）里面的disabled字段来作为查询条件
			// False 表示查询disabled = false的对象
			// 最终SQL: select * from Book where disabled = false
			// 注意：只要返回Page对象的方法，就一定要提供Pageable参数。
			page = this.bookRepository.findByDisabledFalse(pageable);
		} else {
			// 有关键字，要根据关键字搜索可用数据
			// 最终SQL: select * from Book where disabled = false and name like '%' + keyword
			// + '%'
			page = this.bookRepository.findByDisabledFalseAndNameContaining(keyword, pageable);
		}
		return page;
	}
}
