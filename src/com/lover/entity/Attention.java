package com.lover.entity;
/**
 * 关注人
 * @author 胡倩玲
 *
 */
public class Attention {
	private int attention_id;//关注人id
	private int attentioned_id;//被关注人id
	public Attention() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Attention(int attention_id, int attentioned_id) {
		super();
		this.attention_id = attention_id;
		this.attentioned_id = attentioned_id;
	}
	public int getAttention_id() {
		return attention_id;
	}
	public void setAttention_id(int attention_id) {
		this.attention_id = attention_id;
	}
	public int getAttentioned_id() {
		return attentioned_id;
	}
	public void setAttentioned_id(int attentioned_id) {
		this.attentioned_id = attentioned_id;
	}
	@Override
	public String toString() {
		return "Attention [attention_id=" + attention_id + ", attentioned_id=" + attentioned_id + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + attention_id;
		result = prime * result + attentioned_id;
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
		Attention other = (Attention) obj;
		if (attention_id != other.attention_id)
			return false;
		if (attentioned_id != other.attentioned_id)
			return false;
		return true;
	}
	
	
}
