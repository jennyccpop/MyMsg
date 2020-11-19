package com.ubot.application.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import com.ubot.application.service.AnnoucementDAO;
import com.ubot.application.service.RespCodeDAO;
import com.ubot.application.util.DateTool;
import com.ubot.application.entity.RespCodeBean;
import com.ubot.application.entity.jasonlayermodel.JsonLayer;
import com.ubot.application.entity.jasonlayermodel.RespCodeRespBodyLayer;
import com.ubot.application.service.AdBorderDAO;

/**
 * @author Jenny
 *
 * @Description
 */

@WebServlet("/AnnoucementAdServlet")
public class AnnoucementAdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AnnoucementAdServlet() {
		super();

	}

	/**
	 * @return
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Gson gson = new Gson();
		AnnoucementDAO annoucementDAO = new AnnoucementDAO();
		AdBorderDAO adBorderDAO = new AdBorderDAO();

		try {
			List stringAdBorderMsgCarouselList = adBorderDAO.selectAllMsgCarouselList();
			List stringAdBorderHotProductList = adBorderDAO.selectAllMsgHotProductList();
			List stringAnnoucement = annoucementDAO.selectAllMsg();

			// 內層
			JsonLayer layer2 = new JsonLayer(stringAdBorderMsgCarouselList, stringAdBorderHotProductList,
					stringAnnoucement);
			// 外層
			RespCodeDAO c = new RespCodeDAO();
			RespCodeBean gg = c.getRespCode();
			RespCodeRespBodyLayer res = new RespCodeRespBodyLayer(gg, layer2);

			String jsonResult = gson.toJson(res);
			try (PrintWriter out = response.getWriter()) {
				out.print(jsonResult);
			}
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
