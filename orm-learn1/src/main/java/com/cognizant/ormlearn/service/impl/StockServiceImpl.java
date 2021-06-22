package com.cognizant.ormlearn.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;
import com.cognizant.ormlearn.service.StockService;


@Service
@Transactional
public class StockServiceImpl implements StockService {

	@Autowired
	private StockRepository stockRepository;
	
	@Override
	public List<Stock> getAllStockDetails() {
		return stockRepository.findAll();
	}

	@Override
	public List<Stock> findStockUsingCode(String code) {

		return stockRepository.findStockByCode(code);
	}

	@Override
	public List<Stock> getFBStockInSep19(String code, Date startDate, Date endDate) {
		

		return stockRepository.fbStockOfSep19(code, startDate, endDate);
	}

	@Override
	public List<Stock> getGoogleStockGreaterThan1250(String code, double price) {
		System.out.println(stockRepository.googleStocks(code, price));

		return stockRepository.googleStocks(code, price);
	}

	@Override
	public List<Stock> findTop3DatesByVolumeStock() {
		

		return stockRepository.top3Dates();
	}

	@Override
	public List<Stock> find3LowNetflixStocks(String code) {
		System.out.println(stockRepository.lowNetflixStocks(code));
		
		return stockRepository.lowNetflixStocks(code);
	}


}