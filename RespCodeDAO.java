package com.ubot.application.service;

import com.ubot.application.entity.RespCodeBean;
import com.ubot.application.exception.MSGException;
import com.ubot.application.util.DateTool;

public class RespCodeDAO {
	public static RespCodeBean getRespCode() throws MSGException {
		AnnoucementDAO annoucementDAO = new AnnoucementDAO();
		AdBorderDAO adBorderDAO = new AdBorderDAO();
		RespCodeBean respCodeBean = new RespCodeBean();
		DateTool dateTool = new DateTool();
		
		respCodeBean.setSvcName("IBKI120101-我先塞假的");
		if (annoucementDAO.selectAllMsg() != null && adBorderDAO.selectAllMsgCarouselList() != null
				&& adBorderDAO.selectAllMsgHotProductList() != null) {
			respCodeBean.setRtnCode("0000");
			respCodeBean.setRtnDesc("交易成功");
		}else {
			respCodeBean.setRtnCode("404");
			respCodeBean.setRtnDesc("交易失敗");
		}
		respCodeBean.setTime(dateTool.getNowDateTime());
		return respCodeBean;
	}
}
