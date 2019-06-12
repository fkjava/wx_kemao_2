package org.fkjava.weixin.library.controller;

import org.fkjava.weixin.library.domain.Book;
import org.fkjava.weixin.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/kemao_2/library")
public class IndexController {

	@Autowired
	private LibraryService libraryService;

	@RequestMapping
	public String index(//
			// required表示是否必须的，如果为false则可以传入null
			@RequestParam(name = "keyword", required = false) String keyword, //
			// defaultValue表示没有此参数的时候，强制设置为0。Spring Data里面的分页都是从0开始的。
			@RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber, //
			Model model//
	) {
		Page<Book> page = this.libraryService.search(keyword, pageNumber);
		model.addAttribute("page", page);

		// Spring Boot默认只在/META-INF/resources目录找查找文件。
		return "/WEB-INF/views/library/index.jsp";
	}
}
