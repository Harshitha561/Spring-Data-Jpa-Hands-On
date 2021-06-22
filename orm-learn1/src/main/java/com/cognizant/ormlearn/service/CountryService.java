package com.cognizant.ormlearn.service;

import java.util.List;

import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import com.cognizant.ormlearn.model.Country;

public interface CountryService {

	public List<Country> getAllCountries();

	public Country findCountryByCode(String countryCode) throws CountryNotFoundException;

	public void addCountry(Country country);

   public Country updateCountry(String code, String name);

	void deleteCountry(String code);
	
	List<Country> findCountryByCharacter(String name);

	List<Country> findCountryByAlphabet(String name);

	
}