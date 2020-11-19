package com.ubot.application.entity;

import java.util.List;

public class AdBorder_CarouselBean {
	
	
	private List<AdBorderBean> Carousel;

	
	public AdBorder_CarouselBean() {
		super();
	}

	public AdBorder_CarouselBean(List<AdBorderBean> carousel) {
		super();
		Carousel = carousel;
	}

	public List<AdBorderBean> getCarouselList() {
		return Carousel;
	}

	public void setCarouselList(List<AdBorderBean> carouselList) {
		Carousel = carouselList;
	}
	

}
