package com.cognizant.ormlearn.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.CountryService;

@Transactional
@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	CountryRepository countryRepository;

	@Override
	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}

	@Override
	public void addCountry(Country country) {
		countryRepository.save(country);
	}

	@Override
	public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
		Optional<Country> result = countryRepository.findById(countryCode);

		if (!result.isPresent()) {
			throw new CountryNotFoundException("Country not found");
		}
		return result.get();
	}

	@Override
	public Country updateCountry(String code,String name) {
		Optional<Country> country=countryRepository.findById(code);
		country.ifPresent(country1 -> country1.setName(name));
		return country.get();
		
	
}


	@Override
	public void deleteCountry(String code) {
		countryRepository.deleteById(code);
	}

	@Override
	public List<Country> findCountryByCharacter(String name) {

		return countryRepository.findByCountryQuery(name);
	}
	@Override
	public List<Country> findCountryByAlphabet(String name) {

		return countryRepository.findByFirstCharacter(name);
	}

}