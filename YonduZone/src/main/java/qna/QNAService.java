package qna;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.SearchVO;
import qna.QNAMapper;
import qna.QNAVO;

public class QNAService {
	
	private final QNAMapper mapper;
	
	public QNAService(SqlSession session) {
		this.mapper = session.getMapper(QNAMapper.class);
	}
	
	public int getQNAListCount(SearchVO vo) {
		return mapper.getQNAListCount(vo);
	}
	
	public List<QNAVO> getQNAList(SearchVO vo) {
		return mapper.getQNAList(vo);
	}
	
	public QNAVO getQNA(int searchNo) {
		return mapper.getQNA(searchNo);
	}
	
	public int insertQNA(QNAVO vo) {
		return mapper.insertQNA(vo);
	}
	
	public int updateQNA(QNAVO vo) {
		return mapper.updateQNA(vo);
	}
	
	public int deleteQNA(int deleteNo) {
		return mapper.deleteQNA(deleteNo);
	}

}
