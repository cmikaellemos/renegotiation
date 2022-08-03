package com.reneg.debtscalculator.gateway;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.reneg.debtscalculator.dataprovider.GetProductsDataProvider;
import com.reneg.debtscalculator.domain.dto.Product;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GetProductsGateway implements GetProductsDataProvider {

	@Override
	public List<Product> getProducts() {
		var client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder(
			URI.create("http://localhost:8082/api/products-query/v1/products")
		)
		.GET()
		.build();
		try {
			var response = client.send(request, BodyHandlers.ofString());
			Gson gson = new Gson();
			return Arrays.asList(gson.fromJson(response.body(), Product[].class));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Erro ao obter produtos de renegociação");
		}
		return Collections.emptyList();
	}

}
