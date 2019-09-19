package com.lover.entity;

import java.util.Date;
/**
 * 留言
 * @author XM
 *
 */
public class Message {
	private int m_id;//留言id
	private int message_id;//留言人id
	private int messaged_id;//被留言人id
	private String m_content;//留言内容
	private String m_date;//留言的时间
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(int m_id, int message_id, int messaged_id, String m_content, String m_date) {
		super();
		this.m_id = m_id;
		this.message_id = message_id;
		this.messaged_id = messaged_id;
		this.m_content = m_content;
		this.m_date = m_date;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public int getMessage_id() {
		return message_id;
	}
	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}
	public int getMessaged_id() {
		return messaged_id;
	}
	public void setMessaged_id(int messaged_id) {
		this.messaged_id = messaged_id;
	}
	public String getM_content() {
		return m_content;
	}
	public void setM_content(String m_content) {
		this.m_content = m_content;
	}
	public String getM_date() {
		return m_date;
	}
	public void setM_date(String m_date) {
		this.m_date = m_date;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((m_content == null) ? 0 : m_content.hashCode());
		result = prime * result + ((m_date == null) ? 0 : m_date.hashCode());
		result = prime * result + m_id;
		result = prime * result + message_id;
		result = prime * result + messaged_id;
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
		Message other = (Message) obj;
		if (m_content == null) {
			if (other.m_content != null)
				return false;
		} else if (!m_content.equals(other.m_content))
			return false;
		if (m_date == null) {
			if (other.m_date != null)
				return false;
		} else if (!m_date.equals(other.m_date))
			return false;
		if (m_id != other.m_id)
			return false;
		if (message_id != other.message_id)
			return false;
		if (messaged_id != other.messaged_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Message [m_id=" + m_id + ", message_id=" + message_id + ", messaged_id=" + messaged_id + ", m_content="
				+ m_content + ", m_date=" + m_date + "]";
	}
	
}
