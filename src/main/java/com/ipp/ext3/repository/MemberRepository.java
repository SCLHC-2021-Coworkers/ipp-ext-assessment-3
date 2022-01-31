package com.ipp.ext3.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipp.ext3.dto.MemberDto;
import com.ipp.ext3.util.DbUtil;

public class MemberRepository {

	private static MemberRepository mRepo = new MemberRepository();

	private DbUtil dbUtil;

	private MemberRepository() {
		this.dbUtil = DbUtil.getInstance();
	}

	public static MemberRepository getInstance() {
		return MemberRepository.mRepo;
	}
	
	public boolean addMember(MemberDto mem) {
		if (mem == null) {
			return false;
		}

		String pId = mem.getpId();
		String pPw = mem.getpPw();
		String cName = mem.getcName();
		String cEmail = mem.getcEmail();
		String cTel = mem.getcTel();

		String sql = new StringBuilder("")
				.append("insert ")
					.append("into custom_01 ")
					.append("(p_id, p_pw, c_name, c_email, c_tel) ")
				.append("values (?, ?, ?, ? ,?)")
				.toString();

		PreparedStatement stmt = this.dbUtil.createStmt(sql);

		try {
			stmt.setString(1, pId);
			stmt.setString(2, pPw);
			stmt.setString(3, cName);
			stmt.setString(4, cEmail);
			stmt.setString(5, cTel);

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public List<MemberDto> getMemberList() {
		List<MemberDto> mList = new ArrayList<>();
		
		String sql = new StringBuilder("")
				.append("select ")
					.append("c.p_id, ")
					.append("c.p_pw, ")
					.append("c.c_name, ")
					.append("c.c_email, ")
					.append("c.c_tel ")
				.append("from ")
					.append("custom_01 c")
				.toString();

		PreparedStatement stmt = this.dbUtil.createStmt(sql);

		try {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				MemberDto mem = new MemberDto();
				mem.setpId(rs.getString("p_id"));
				mem.setpPw(rs.getString("p_pw"));
				mem.setcName(rs.getString("c_name"));
				mem.setcEmail(rs.getString("c_email"));
				mem.setcTel(rs.getString("c_tel"));
				mList.add(mem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mList;
	}

}
