package com.ubot.application.entity.jasonlayermodel;

import java.util.List;

import com.ubot.application.entity.AnnoucementBean;

public class JsonLayer {
	private List<AnnoucementBean> Carousel;
	private List<AnnoucementBean> HotProduct;
	private List<AnnoucementBean> News;

	public JsonLayer() {
		super();
	}

	public JsonLayer(List<AnnoucementBean> carouselList,List<AnnoucementBean> hotProduct,List<AnnoucementBean> news) {
		super();
		HotProduct = hotProduct;
		Carousel = carouselList;
		News = news;
	}

}
