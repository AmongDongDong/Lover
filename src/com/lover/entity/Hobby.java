package com.lover.entity;
/**
 * 用户兴趣爱好
 * @author 胡倩玲
 *
 */
public class Hobby {
	private int hobbyid;//兴趣爱好id
	private String greens;//喜欢的菜
	private String famous;//欣赏的名人
	private String song;//喜欢的歌
	private String book;//喜欢的书
	private String thing;//喜欢做的事
	public Hobby() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hobby(int hobbyid, String greens, String famous, String song, String book, String thing) {
		super();
		this.hobbyid = hobbyid;
		this.greens = greens;
		this.famous = famous;
		this.song = song;
		this.book = book;
		this.thing = thing;
	}
	public int getHobbyid() {
		return hobbyid;
	}
	public void setHobbyid(int hobbyid) {
		this.hobbyid = hobbyid;
	}
	public String getGreens() {
		return greens;
	}
	public void setGreens(String greens) {
		this.greens = greens;
	}
	public String getFamous() {
		return famous;
	}
	public void setFamous(String famous) {
		this.famous = famous;
	}
	public String getSong() {
		return song;
	}
	public void setSong(String song) {
		this.song = song;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	public String getThing() {
		return thing;
	}
	public void setThing(String thing) {
		this.thing = thing;
	}
	@Override
	public String toString() {
		return "Hobby [hobbyid=" + hobbyid + ", greens=" + greens + ", famous=" + famous + ", song=" + song + ", book="
				+ book + ", thing=" + thing + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((famous == null) ? 0 : famous.hashCode());
		result = prime * result + ((greens == null) ? 0 : greens.hashCode());
		result = prime * result + hobbyid;
		result = prime * result + ((song == null) ? 0 : song.hashCode());
		result = prime * result + ((thing == null) ? 0 : thing.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hobby other = (Hobby) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (famous == null) {
			if (other.famous != null)
				return false;
		} else if (!famous.equals(other.famous))
			return false;
		if (greens == null) {
			if (other.greens != null)
				return false;
		} else if (!greens.equals(other.greens))
			return false;
		if (hobbyid != other.hobbyid)
			return false;
		if (song == null) {
			if (other.song != null)
				return false;
		} else if (!song.equals(other.song))
			return false;
		if (thing == null) {
			if (other.thing != null)
				return false;
		} else if (!thing.equals(other.thing))
			return false;
		return true;
	}
	
	
}
