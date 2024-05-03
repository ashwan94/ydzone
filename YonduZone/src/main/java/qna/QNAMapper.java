package qna;

import java.util.List;

import common.SearchVO;

public interface QNAMapper {
	int getQNAListCount(SearchVO vo);
	List<QNAVO> getQNAList(SearchVO vo);
	QNAVO getQNA(int searchNo);
	int insertQNA(QNAVO vo);
	int updateQNA(QNAVO vo);
	int deleteQNA(int deleteNo);
}
