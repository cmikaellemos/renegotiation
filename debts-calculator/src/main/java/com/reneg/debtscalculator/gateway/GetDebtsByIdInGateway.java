package com.reneg.debtscalculator.gateway;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.reneg.debtscalculator.dataprovider.GetDebtsByIdInDataProvider;
import com.reneg.debtscalculator.domain.dto.Debt;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GetDebtsByIdInGateway implements GetDebtsByIdInDataProvider {

	@Override
	public List<Debt> getDebtsByIdIn(List<Long> ids) {
		var client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder(
			URI.create(String.format("http://localhost:8080/api/debts-query/v1/debts?ids=%s", 
			ids.stream().map(id -> id.toString()).collect(Collectors.joining(","))))
		)
		.GET()
		.build();
		try {
			var response = client.send(request, BodyHandlers.ofString());
			Gson gson = new Gson();
			return Arrays.asList(gson.fromJson(response.body(), Debt[].class));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Erro ao obter produtos de renegociação");
		}
		return Collections.emptyList();
	}

}
