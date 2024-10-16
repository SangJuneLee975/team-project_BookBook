package org.bookbook.controller;

import org.bookbook.domain.LikeVO;
import org.bookbook.service.BookSearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
public class LikeController {

	private final BookSearchService bookSearchService;

	public LikeController(BookSearchService bookSearchService) {
		this.bookSearchService = bookSearchService;
	}

	// ���ƿ� �߰� �κ�
	@PostMapping("/api/addLike")
	@ResponseBody
	public ResponseEntity<String> addLike(@RequestParam String userId, @RequestParam int bookId) {
		log.info("userId:" + userId);
		log.info("bookId:" + bookId);

		LikeVO like = new LikeVO();
		like.setUserId(userId);
		like.setBookId(bookId);

		log.info(like);

		bookSearchService.addLike(like);

		return ResponseEntity.ok("���ƿ䰡 ���������� �߰��Ǿ����ϴ�");
	}

	// ���� ���� �κ�
	@PostMapping("/api/deleteLike")
	@ResponseBody
	public ResponseEntity<String> deleteLike(@RequestParam String userId, @RequestParam int bookId) {
		log.info("userId:" + userId);
		log.info("bookId:" + bookId);

		LikeVO like = new LikeVO();

		like.setUserId(userId);
		like.setBookId(bookId);

		log.info(like);

		bookSearchService.deleteLike(like);

		return ResponseEntity.ok("������ ���������� �����Ǿ����ϴ�");
	}
}
