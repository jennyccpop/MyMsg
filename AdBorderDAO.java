package com.ubot.application.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.ubot.application.entity.AdBorderBean;
import com.ubot.application.exception.MSGException;

/**
 * @author Jenny
 *
 * @Description 廣告維護(跑馬燈+熱門產品)
 */

public class AdBorderDAO {
	
//指定的排序:UPTIME
	private static final String SELECT_ALL_MSG = "SELECT ARCHIVES,UUID,TITLE,UPTIME,DOWNTIME,LINK,MEMO,BLOCK FROM IBKINST.AD_BOARD ab ORDER BY UPTIME;";

	public List selectAllMsgHotProductList() throws MSGException {

		Gson gson = new Gson();
		List<AdBorderBean> HotProductList = new ArrayList<AdBorderBean>();
		List<AdBorderBean> CarouselList = new ArrayList<AdBorderBean>();
		String jsonResult1 = null;
		String jsonResult2 = null;
		try (Connection conn = RDBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_MSG);) {
			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					//blob轉換為base64
					byte[] arr = rs.getBytes("ARCHIVES");
					String archives_base64 = javax.xml.bind.DatatypeConverter.printBase64Binary(arr);
					
					AdBorderBean columnName = new AdBorderBean();
					columnName.setArchives(archives_base64);
					columnName.setUuid(rs.getString("UUID"));
					columnName.setTitle(rs.getString("TITLE"));
					columnName.setUptime(rs.getString("UPTIME"));
					columnName.setDowntime(rs.getString("DOWNTIME"));
					columnName.setLink(rs.getString("LINK"));
					columnName.setMemo(rs.getString("MEMO"));

					if (rs.getString("BLOCK").equals("HotProduct")) {
						HotProductList.add(columnName);
						jsonResult1 = gson.toJson(HotProductList);
					} else if (rs.getString("BLOCK").equals("Carousel")) {
						CarouselList.add(columnName);
						jsonResult2 = gson.toJson(CarouselList);
					}
				}
				System.out.println(jsonResult1);

				return HotProductList;
			}
		} catch (SQLException e) {
			throw new MSGException("查詢全部產品失敗", e);
		}
	}

	/**
	 * 
	 * @param args
	 * @throws News
	 */
	public List selectAllMsgCarouselList() throws MSGException {

		Gson gson = new Gson();
		
		List<AdBorderBean> CarouselList = new ArrayList<AdBorderBean>();
		String jsonResult1 = null;
		String jsonResult2 = null;
		try (Connection conn = RDBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_MSG);) {
			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					//blob轉換為base64
					byte[] arr = rs.getBytes("ARCHIVES");
					String archives_base64 = javax.xml.bind.DatatypeConverter.printBase64Binary(arr);
					
					AdBorderBean columnName = new AdBorderBean();
					columnName.setArchives(archives_base64);
					columnName.setUuid(rs.getString("UUID"));
					columnName.setTitle(rs.getString("TITLE"));
					columnName.setUptime(rs.getString("UPTIME"));
					columnName.setDowntime(rs.getString("DOWNTIME"));
					columnName.setLink(rs.getString("LINK"));
					columnName.setMemo(rs.getString("MEMO"));

					if (rs.getString("BLOCK").equals("Carousel")) {
						CarouselList.add(columnName);
						jsonResult1 = gson.toJson(CarouselList);
					}
				}
				System.out.println(jsonResult1);

				return CarouselList;
			}
		} catch (SQLException e) {
			throw new MSGException("查詢全部產品失敗", e);
		}
	}
	
	public static void main(String[] args) throws MSGException {
		AdBorderDAO a = new AdBorderDAO();
		a.selectAllMsgCarouselList();
	}
}
