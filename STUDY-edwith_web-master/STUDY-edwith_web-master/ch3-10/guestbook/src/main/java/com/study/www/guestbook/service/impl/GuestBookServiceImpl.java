package com.study.www.guestbook.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.www.guestbook.dao.GuestBookDao;
import com.study.www.guestbook.dao.LogDao;
import com.study.www.guestbook.dto.GuestBook;
import com.study.www.guestbook.dto.Log;
import com.study.www.guestbook.service.GuestBookService;

@Service
public class GuestBookServiceImpl implements GuestBookService{
	@Autowired
	GuestBookDao guestBookDao;
	@Autowired
	LogDao logDao;
	
	@Override
	@Transactional
	public List<GuestBook> getGuestBooks(Integer start) {
		// TODO Auto-generated method stub
		List<GuestBook> guestBooks = guestBookDao.selectAll(start, LIMIT);
		return guestBooks;
	}

	@Override
	@Transactional(readOnly=false)
	public int deleteGuestBook(Long id, String ip) {
		// TODO Auto-generated method stub
		Integer deleteCount  = guestBookDao.deleteById(id);
		Log log = new Log();
		log.setIp(ip);
		log.setMethod("delete");
		log.setRegdate(new Date());
		logDao.insert(log);
		return deleteCount;
	}

	@Override
	@Transactional(readOnly=false)
	public GuestBook addGuestBook(GuestBook guestBook, String ip) {
		// TODO Auto-generated method stub
		guestBook.setRegdate(new Date());
		Long id = guestBookDao.insert(guestBook);
		guestBook.setId(id);
		Log log = new Log();
		log.setIp(ip);
		log.setMethod("insert");
		log.setRegdate(new Date());
		logDao.insert(log);
		return guestBook;
	}

	@Override
	@Transactional
	public int getCount() {
		// TODO Auto-generated method stub
		return guestBookDao.selectCount();
	}

}
