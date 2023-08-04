package com.kh.notice.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.notice.model.vo.Notice;
import com.kh.notice.model.vo.PageData;

public class NoticeDAO {

	public int insertNotice(SqlSession session, Notice notice) {
		int result = session.insert("NoticeMapper.insertnotice",notice);
		return result;
	}

	public List<Notice> selectNotice(SqlSession session,int currentPage) {
		
		/*
		 * RowBounds는 왜 쓰나요? 쿼리문을 변경하지 않고도 페이징을 처리할 수 있게 해주는 클래스
		 * RowBounds의 동작은 offset값과 limit값을 이용하여 동작한다.
		 * limit값은 한 페이지당 보여주고 싶은 게시물의 갯수이다.
		 * offset은 시작값 변하는 값이다.
		 * 1페이지 에서는 0부터 시작해서 10개를 가져오고  1~10
		 * 2페이지에서는 10부터 시작해서 10개를 가져온다. 11~20
		 * 3페이지에서는 20부터 시작해서 10개를 가져온다. 21~30
		 */
		int limit =10 ;
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Notice>nList = session.selectList("NoticeMapper.selectnotice",null,rowBounds);
		return nList;
	}
	

	public int updateList(SqlSession session,Notice notice) {
		int result = session.update("NoticeMapper.noticeUpdate",notice);
		return result;
	}

	public int deleteNotice(SqlSession session, String noticeNo) {
		int result = session.delete("NoticeMapper.noticeDelete",noticeNo);
		
		return result;
	}

	public Notice selectOneByNo(SqlSession session,int noticeNo) {
		Notice notice = session.selectOne("NoticeMapper.selectOneByNo",noticeNo);
		
		
		return notice;
	}



}
