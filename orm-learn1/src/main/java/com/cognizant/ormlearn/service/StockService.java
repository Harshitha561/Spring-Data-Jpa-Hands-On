package com.cognizant.ormlearn.service;

import java.util.Date;
import java.util.List;

import com.cognizant.ormlearn.model.Stock;

public interface StockService {
	List<Stock> getAllStockDetails();

	List<Stock> findStockUsingCode(String code);

	List<Stock> getFBStockInSep19(String code, Date startDate, Date endDate);

	List<Stock> getGoogleStockGreaterThan1250(String code, double price);

	List<Stock> findTop3DatesByVolumeStock();

	List<Stock> find3LowNetflixStocks(String code);
}