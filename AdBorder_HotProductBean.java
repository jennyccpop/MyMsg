package com.ubot.application.entity;

import java.util.List;

public class AdBorder_HotProductBean {

	private List<AdBorderBean> HotProduct;

	public AdBorder_HotProductBean() {
		super();
	}

	public AdBorder_HotProductBean(List<AdBorderBean> hotProduct) {
		super();
		HotProduct = hotProduct;
	}

	public List<AdBorderBean> getHotProduct() {
		return HotProduct;
	}

	public void setHotProduct(List<AdBorderBean> hotProduct) {
		HotProduct = hotProduct;
	}

}
