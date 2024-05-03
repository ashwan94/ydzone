package qna;

import java.time.LocalDate;

public class QNAVO {
	
	private int no;
	private String writer;
	private String title;
	private String content;
	private LocalDate craeteDate;
	private LocalDate modifyDate;
	private int hits;
	private String delyn;
	
	public QNAVO() {
	}

	// INSERT 용 생성자
	public QNAVO(String writer, String title, String content) {
		this.writer = writer;
		this.title = title;
		this.content = content;
	}
	
	// UPDATE 용 생성자
	public QNAVO(int no, String writer, String title, String content) {
		this.no = no;
		this.writer = writer;
		this.title = title;
		this.content = content;
	}
	
	// LIST 용 생성자
	public QNAVO(int no, String writer, String title, LocalDate craeteDate, int hits) {
		this.no = no;
		this.writer = writer;
		this.title = title;
		this.craeteDate = craeteDate;
		this.hits = hits;
	}

	// SELECT 용 생성자
	public QNAVO(int no, String writer, String title, String content, LocalDate craeteDate, LocalDate modifyDate,
			int hits) {
		this.no = no;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.craeteDate = craeteDate;
		this.modifyDate = modifyDate;
		this.hits = hits;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getCraeteDate() {
		return craeteDate;
	}

	public void setCraeteDate(LocalDate craeteDate) {
		this.craeteDate = craeteDate;
	}

	public LocalDate getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(LocalDate modifyDate) {
		this.modifyDate = modifyDate;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", writer=" + writer + ", title=" + title + ", content=" + content
				+ ", craeteDate=" + craeteDate + ", modifyDate=" + modifyDate + ", hits=" + hits + "]";
	}

}
