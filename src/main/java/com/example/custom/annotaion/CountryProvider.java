package com.example.custom.annotaion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

public interface CountryProvider {

	List<String> getPermittedCountries();

	@Component
	public static class DefaultCountryProvider implements CountryProvider {

		@Override
		public List<String> getPermittedCountries() {
			List<String> countryList = new ArrayList<>();
			countryList.add("India");
			countryList.add("Israel");
			countryList.add("France");
			countryList.add("Thailand");
			countryList.add("Vietnam");
			return countryList;
		}
	}
}
