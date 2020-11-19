package com.ubot.application.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.ubot.application.entity.AnnoucementBean;
import com.ubot.application.exception.MSGException;
import com.ubot.application.util.DateTool;

/**
 * @author Jenny
 *
 * @Description 重要訊息公告
 */

public class AnnoucementDAO {
	
//指定的排序:TOP,CDATE
	private static final String SELECT_ALL_MSG = "SELECT * FROM IBKINST.BULLETIN b ORDER BY TOP ASC, CDATE ASC;";

	public List selectAllMsg() throws MSGException {

		Gson gson = new Gson();
		List<AnnoucementBean> AnnoucementList = new ArrayList<AnnoucementBean>();
		try (Connection conn = RDBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_MSG);) {
			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					AnnoucementBean columnName = new AnnoucementBean();
					columnName.setTitle(rs.getString("TITLE"));
					columnName.setContent(rs.getString("CONTENT"));
					columnName.setCdate(DateTool.AdDateTimeFormat(
							rs.getString("CDATE"), "yyyyMMddHHmmss", "yyyy/MM/dd HH:mm:ss"));
					columnName.setTop(rs.getString("TOP"));
					AnnoucementList.add(columnName);

				}
				String jsonResult = gson.toJson(AnnoucementList);
				System.out.println(jsonResult);
				JsonElement result = gson.toJsonTree(jsonResult);
				return AnnoucementList;

			}
		} catch (SQLException e) {
			throw new MSGException("查詢全部產品失敗", e);
		}
	}

	public static void main(String[] args) throws MSGException {
		AnnoucementDAO a = new AnnoucementDAO();
		a.selectAllMsg();
	}
}
