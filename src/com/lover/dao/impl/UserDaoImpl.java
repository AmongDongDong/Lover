package com.lover.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lover.dao.UserDao;
import com.lover.entity.Basic;
import com.lover.entity.Couple;
import com.lover.entity.Detail;
import com.lover.entity.Hobby;
import com.lover.entity.Worklife;
import com.lover.util.DataBaseUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public Basic selectbasic(int id) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		Basic u = null;
		try {
			conn = DataBaseUtil.getConnection();
			String sql = "select sex,head,birthdy,marry,education,nick_name,phone,address,salary,height from u_basic where user_id="
					+ id;
			stat = conn.createStatement();

			rs = stat.executeQuery(sql);
			while (rs.next()) {
				String sex = rs.getString("sex");
				Date birthday = rs.getDate("birthdy");
				String marry = rs.getString("marry");
				String education = rs.getString("education");
				String nickname = rs.getString("nick_name");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String salary = rs.getString("salary");
				int height = rs.getInt("height");
				String head = rs.getString("head");
				int uid = new Integer(id);
				u = new Basic(uid, sex, birthday, marry, education, nickname, phone, address, salary, height , head);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.close(conn, stat, rs);
		}

		return u;
	}

	public void updatebasic(int id, String nickname, String phone, String address, String salary, int heighta) {
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			conn = DataBaseUtil.getConnection();
			String sql = "update u_basic set phone=?,nick_name=?,address=?,salary=?,height=? where user_id=" + id;
			pre = conn.prepareStatement(sql);
			pre.setString(1, phone);
			pre.setString(2, nickname);
			pre.setString(3, address);
			pre.setString(4, salary);
			pre.setInt(5, heighta);
			pre.executeUpdate();
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.close(conn, pre, rs);
		}
	}

	@Override
	public Detail selectdetail(int id) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		Detail d = null;
		try {
			conn = DataBaseUtil.getConnection();
			String sql = "SELECT d.detail_id det,d.place pl,d.weight w,d.body body,d.star star,d.have_baby hb,d.want_baby wb,d.when_marry wm,d.heart_talk ht "
					+ "FROM u_detail d JOIN u_basic b ON d.detail_id = b.detail_id WHERE b.user_id=" + id;
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				String place = rs.getString("pl");
				int weight = rs.getInt("w");
				String body = rs.getString("body");
				String star = rs.getString("star");
				String hbaby = rs.getString("hb");
				String wbaby = rs.getString("wb");
				String wmarry = rs.getString("wm");
				String hearttalk = rs.getString("ht");
				int did = rs.getInt("det");
				d = new Detail(did, place, weight, body, star, hbaby, wbaby, wmarry, hearttalk);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DataBaseUtil.close(conn, stat, rs);
		}
		return d;
	}

	@Override
	public void updatedetail(int id, String place, int weighta, String body, String star, String havechild,
			String wantchild, String marry, String hearttalk) {
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			conn = DataBaseUtil.getConnection();
			String sql = "UPDATE u_detail d JOIN u_basic b ON d.detail_id = b.detail_id SET d.place=?,d.weight=?,d.body=?,d.star=?,d.have_baby=?,d.want_baby=?,d.when_marry=?,d.heart_talk=? WHERE b.user_id="
					+ id;
			pre = conn.prepareStatement(sql);
			pre.setString(1, place);
			pre.setInt(2, weighta);
			pre.setString(3, body);
			pre.setString(4, star);
			pre.setString(5, havechild);
			pre.setString(6, wantchild);
			pre.setString(7, marry);
			pre.setString(8, hearttalk);
			pre.executeUpdate();
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.close(conn, pre, rs);
		}
	}

	@Override
	public Worklife selectworklife(int id) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		Worklife w = null;
		try {
			conn = DataBaseUtil.getConnection();
			String sql = "SELECT w.work_id wid,w.w_type wt,w.w_house wh,w.w_car wc,w.w_smoke ws,w.w_drink wd FROM u_work w JOIN u_basic b ON w.work_id= b.work_id WHERE b.user_id="
					+ id;
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				int workid = rs.getInt("wid");
				String type = rs.getString("wt");
				String house = rs.getString("wh");
				String car = rs.getString("wc");
				String smoke = rs.getString("ws");
				String drink = rs.getString("wd");
				w = new Worklife(workid, type, house, car, smoke, drink);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.close(conn, stat, rs);
		}
		return w;
	}

	@Override
	public void updateworklide(int id, String type, String house, String car, String smoke, String drink) {
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			conn = DataBaseUtil.getConnection();
			String sql = "UPDATE u_work w JOIN u_basic b ON w.work_id = b.work_id SET w.w_type=?,w.w_house=?,w.w_car=?,w.w_smoke=?,w.w_drink=? WHERE b.user_id="
					+ id;
			pre = conn.prepareStatement(sql);
			pre.setString(1, type);
			pre.setString(2, house);
			pre.setString(3, car);
			pre.setString(4, smoke);
			pre.setString(5, drink);
			pre.executeUpdate();
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.close(conn, pre, rs);
		}
	}

	@Override
	public Couple selectcouple(int id) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		Couple c = null;
		try {
			conn = DataBaseUtil.getConnection();
			String sql = "SELECT c.couple_id cid,c.c_salary salary,c.c_age age,c.c_height ch,c.c_education edu,c.c_marry marry,"
					+ "c.c_body body,c.c_address addr,c.c_hbaby hb,c.c_wbaby wb,c.c_somke cs,c.c_drink cd,"
					+ "c.c_photo cp FROM u_couple c JOIN u_basic b ON c.couple_id = b.couple_id WHERE b.user_id=" + id;
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				int coupleid = rs.getInt("cid");
				String age = rs.getString("age");
				String salary = rs.getString("salary");
				String height = rs.getString("ch");
				String education = rs.getString("edu");
				String marry = rs.getString("marry");
				String body = rs.getString("body");
				String address = rs.getString("addr");
				String hbaby = rs.getString("hb");
				String wbaby = rs.getString("wb");
				String smoke = rs.getString("cs");
				String drink = rs.getString("cd");
				String photo = rs.getString("cp");
				c = new Couple(coupleid, age, height, salary, education, marry, body, address, hbaby, wbaby, smoke,
						drink, photo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.close(conn, stat, rs);
		}
		return c;
	}

	@Override
	public void updatecouple(int id, String age, String height, String salary, String edu, String marry, String body,
			String place, String hchild, String wchild, String smoke, String drink, String photo) {
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			conn = DataBaseUtil.getConnection();
			String sql = "UPDATE u_couple c JOIN u_basic b ON c.couple_id = b.couple_id SET c.c_age=?,"
					+ "c.c_height=?,c.c_salary=?,c.c_education=?,c.c_marry=?,c.c_body=?,c.c_address=?,"
					+ "c.c_hbaby=?,c.c_wbaby=?,c.c_somke=?,c.c_drink=?,c.c_photo=? WHERE b.user_id=" + id;
			pre = conn.prepareStatement(sql);
			pre.setString(1, age);
			pre.setString(2, height);
			pre.setString(3, salary);
			pre.setString(4, edu);
			pre.setString(5, marry);
			pre.setString(6, body);
			pre.setString(7, place);
			pre.setString(8, hchild);
			pre.setString(9, wchild);
			pre.setString(10, smoke);
			pre.setString(11, drink);
			pre.setString(12, photo);
			pre.executeUpdate();
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.close(conn, pre, rs);
		}
	}

	@Override
	public Hobby selecthobby(int id) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		Hobby h = null;
		try {
			conn = DataBaseUtil.getConnection();
			String sql = "SELECT h.hobby_id hid,h.greens g,h.famous f,h.song s,h.book b,h.thing t "
					+ "FROM u_hobby h JOIN u_basic b ON h.hobby_id= b.hobby_id WHERE b.user_id=" + id;
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				int hobbyid = rs.getInt("hid");
				String greens = rs.getString("g");
				String famous = rs.getString("f");
				String song = rs.getString("s");
				String book = rs.getString("b");
				String thing = rs.getString("t");
				h = new Hobby(hobbyid, greens, famous, song, book, thing);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.close(conn, stat, rs);
		}
		return h;
	}

	@Override
	public void updatehobby(int id, String greens, String famous, String song, String book, String thing) {
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			conn = DataBaseUtil.getConnection();
			String sql = "UPDATE u_hobby h JOIN u_basic b ON h.hobby_id= b.hobby_id SET h.greens=?,h.famous=?,h.song=?,h.book=?,h.thing=? WHERE b.user_id="
					+ id;
			pre = conn.prepareStatement(sql);
			pre.setString(1, greens);
			pre.setString(2, famous);
			pre.setString(3, song);
			pre.setString(4, book);
			pre.setString(5, thing);
			pre.executeUpdate();
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.close(conn, pre, rs);
		}
	}

	@Override
	public void updatehead(int uid, String newName) {
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			conn = DataBaseUtil.getConnection();
			String sql = "UPDATE u_basic SET head=? WHERE user_id=" + uid;
			pre = conn.prepareStatement(sql);
			pre.setString(1, newName);
			pre.executeUpdate();
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.close(conn, pre, rs);
		}
	}

	@Override
	public ArrayList<Basic> selectAll(int pageno, int count) {
		ArrayList<Basic> ar = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			conn = DataBaseUtil.getConnection();
			String sql = "select user_id,head,sex,birthdy,marry,education,nick_name,phone,address,salary,height FROM u_basic LIMIT ?,?";
			pre = conn.prepareStatement(sql);
			// 如果需要带参数,则设置
			pre.setInt(1, pageno * count - count);
			pre.setInt(2, count);
			// 现在没有参数
			rs = pre.executeQuery();
			// 获取数据
			while (rs.next()) {
				int userid = rs.getInt("user_id");
				String sex = rs.getString("sex");
				Date birth = rs.getDate("birthdy");
				String marry = rs.getString("marry");
				String education = rs.getString("education");
				String nick = rs.getString("nick_name");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String salary = rs.getString("salary");
				String head = rs.getString("head");
				int height = rs.getInt("height");
				Basic b = new Basic(userid, sex, birth, marry, education, nick, phone, address, salary, height,head);
				ar.add(b);
			}
			return ar;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.close(conn, pre, rs);
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(new UserDaoImpl().selectAll(1, 2));
	}

	

	@Override
	public Detail queryDetail(int userid) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		Detail d = null;
		try {
			conn = DataBaseUtil.getConnection();
			String sql = "SELECT d.heart_talk ht,d.body db,d.star s FROM u_detail d JOIN u_basic b ON d.detail_id = b.detail_id WHERE b.user_id="
					+ userid;
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				String hearttalk = rs.getString("ht");
				String body = rs.getString("db");
				String star = rs.getString("s");
				d = new Detail(hearttalk, body, star);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.close(conn, stat, rs);
		}
		return d;
	}

	/*
	 * public static void main1(String[] args) throws SQLException { UserDaoImpl
	 * u = new UserDaoImpl(); System.out.println(u.findCondition("男", null,
	 * null, null)); }
	 */
	@Override
	public int querycount() {
		int count = 0;
		// 链接数据库
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			conn = DataBaseUtil.getConnection();
			// sql语句
			String sql = "SELECT count(*) from u_basic";
			pre = conn.prepareStatement(sql);
			// 如果需要带参数,则设置
			// 现在没有参数
			rs = pre.executeQuery();
			// 获取数据
			if (rs.next()) {
				count = rs.getInt(1);
			}
			/*
			 * 这里的异常，到底是抛出去，还是现在处理 如果出现异常，我需要释放资源，需要在finally中处理
			 */
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DataBaseUtil.close(conn, pre, rs);
		}
		return 0;
	}
	
	@Override
	public ArrayList<Basic> findConditions(String sex, String edu, String height, String salary) throws SQLException{
		ArrayList<Basic> ar = new ArrayList<Basic>();
		ArrayList as = new ArrayList();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			conn = DataBaseUtil.getConnection();
			String sql = "SELECT user_id,sex,birthdy,marry,education,head,nick_name,phone,address,salary,height FROM u_basic WHERE 1=1 ";
			if (!sex.equals("")) {
				sql += " and sex=?";
				as.add(sex);
			}
			if (!edu.equals("")) {
				sql += " and education=?";
				as.add(edu);
			}
			if (!height.equals("")) {
				sql += " and height BETWEEN " + height;
			}
			if (!salary.equals("")) {
				sql += " and salary=?";
				as.add(salary);
			}
			pre = conn.prepareStatement(sql);
			for (int i = 0; i < as.size(); i++) {
				String str = (String) as.get(i);
				pre.setString(i + 1, str);
			}
			rs = pre.executeQuery();
			// 获取数据
			while (rs.next()) {
				int userid = rs.getInt("user_id");
				String sexa = rs.getString("sex");
				Date birth = rs.getDate("birthdy");
				String marry = rs.getString("marry");
				String education = rs.getString("education");
				String nick = rs.getString("nick_name");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String salarya = rs.getString("salary");
				String head = rs.getString("head");
				int heighta = (Integer) rs.getInt("height");
				Basic b = new Basic(userid, sexa, birth, marry, education, nick, phone, address, salarya, heighta , head);
				ar.add(b);
			}
			return ar;
		} finally {
			DataBaseUtil.close(conn, pre, rs);
		}
	}
	

	@Override
	public ArrayList<Basic> findCondition(String sex, String edu, String height, String salary, int pageno, int count) throws SQLException {
		ArrayList<Basic> ar = new ArrayList<Basic>();
		ArrayList as = new ArrayList();
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			conn = DataBaseUtil.getConnection();
			String sql = "SELECT user_id,sex,birthdy,marry,education,head,nick_name,phone,address,salary,height FROM u_basic WHERE 1=1 ";
			if (!sex.equals("")) {
				sql += " and sex=?";
				as.add(sex);
			}
			if (!edu.equals("")) {
				sql += " and education=?";
				as.add(edu);
			}
			if (!height.equals("")) {
				sql += " and height BETWEEN " + height;
			}
			if (!salary.equals("")) {
				sql += " and salary=?";
				as.add(salary);
			}
			sql = sql + " limit "+(pageno * count - count)+","+count;
			System.out.println(sql);
			pre = conn.prepareStatement(sql);
			for (int i = 0; i < as.size(); i++) {
				String str = (String) as.get(i);
				pre.setString(i + 1, str);
			}
			rs = pre.executeQuery();
			// 获取数据
			while (rs.next()) {
				int userid = rs.getInt("user_id");
				String sexa = rs.getString("sex");
				Date birth = rs.getDate("birthdy");
				String marry = rs.getString("marry");
				String education = rs.getString("education");
				String nick = rs.getString("nick_name");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String salarya = rs.getString("salary");
				String head = rs.getString("head");
				int heighta = (Integer) rs.getInt("height");
				Basic b = new Basic(userid, sexa, birth, marry, education, nick, phone, address, salarya, heighta , head);
				ar.add(b);
			}
			return ar;
		} finally {
			DataBaseUtil.close(conn, pre, rs);
		}
	}
}
