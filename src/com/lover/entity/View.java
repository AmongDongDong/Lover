package com.lover.entity;
/**
 * 视频信息
 * @author 胡倩玲
 *
 */
public class View {
	private int viewid;//视频id
	private String view;//视频
	public View() {
		super();
		// TODO Auto-generated constructor stub
	}
	public View(int viewid, String view) {
		super();
		this.viewid = viewid;
		this.view = view;
	}
	public int getViewid() {
		return viewid;
	}
	public void setViewid(int viewid) {
		this.viewid = viewid;
	}
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	@Override
	public String toString() {
		return "View [viewid=" + viewid + ", view=" + view + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((view == null) ? 0 : view.hashCode());
		result = prime * result + viewid;
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
		View other = (View) obj;
		if (view == null) {
			if (other.view != null)
				return false;
		} else if (!view.equals(other.view))
			return false;
		if (viewid != other.viewid)
			return false;
		return true;
	}
	
}
