package com.study.www.guestbook.service;

import java.util.List;

import com.study.www.guestbook.dto.GuestBook;

public interface GuestBookService {
	public static final Integer LIMIT = 5;
	public List<GuestBook> getGuestBooks(Integer start);
	public int deleteGuestBook(Long id, String ip);
	public GuestBook addGuestBook(GuestBook guestBook, String ip);
	public int getCount();
}
