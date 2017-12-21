package com.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import eu.oresys.salesforces.utils.CSVWriter;
import eu.oresys.salesforces.utils.JSONFlattener;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SalesforceRestStarter {

	private static final String TOKEN_URL = "https://test.salesforce.com/services/oauth2/token";

	public static void main(String[] args) throws Exception {

		String username = "caroline.faure@oresys.prod.reprise";
		String password = "crm2018!" + "DPcxW6YVzACLCJum5qzPIl4R0";
		String consumerKey = "3MVG9w8uXui2aB_o42KkdJALseJjjrCoK4fBnXTKhJgid4OLaTNsrWvQwRFHgrE2k7OtcfJMEQwfUAcj7k6vF";
		String consumerSecret = "8004342494227891874";

		/*
		 * if (args.length == 4) { username = args[0]; password = args[1]; consumerKey =
		 * args[2]; consumerSecret = args[3]; } else if (System.console() != null) {
		 * System.out.print("Salesforce Username: "); username =
		 * System.console().readLine();
		 * 
		 * System.out.print("Salesforce Password: "); password = new
		 * String(System.console().readPassword());
		 * 
		 * System.out.print("Salesforce Consumer Key: "); consumerKey =
		 * System.console().readLine();
		 * 
		 * System.out.print("Salesforce Consumer Secret: "); consumerSecret = new
		 * String(System.console().readPassword()); } else { throw new
		 * Exception("You need to specify username, password, consumer key, and consumer secret"
		 * ); }
		 */

		try {
			// login
			final CloseableHttpClient httpclient = HttpClients.createDefault();

			final List<NameValuePair> loginParams = new ArrayList<NameValuePair>();
			loginParams.add(new BasicNameValuePair("client_id", consumerKey));
			loginParams.add(new BasicNameValuePair("client_secret", consumerSecret));
			loginParams.add(new BasicNameValuePair("grant_type", "password"));
			loginParams.add(new BasicNameValuePair("username", username));
			loginParams.add(new BasicNameValuePair("password", password));

			final HttpPost post = new HttpPost(TOKEN_URL);
			post.setEntity(new UrlEncodedFormEntity(loginParams));

			final HttpResponse loginResponse = httpclient.execute(post);

			// parse
			final ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

			final JsonNode loginResult = mapper.readValue(loginResponse.getEntity().getContent(), JsonNode.class);
			System.out.println("loginResult = :" + loginResult);
			final String accessToken = loginResult.get("access_token").asText();
			final String instanceUrl = loginResult.get("instance_url").asText();

			// query contacts
			final URIBuilder builder = new URIBuilder(instanceUrl);
			
			builder.setPath("/services/data/v41.0/query/").setParameter("q",
					"SELECT campaignId,contactId,email FROM CampaignMember where CampaignId='7014E000000JlGZQA0' and (status='ciblé' or status='invité') and (Email!=null) and Campaign.status ='OK pour envoi'");

			final HttpGet get = new HttpGet(builder.build());
			get.setHeader("Authorization", "Bearer " + accessToken);

			final HttpResponse queryResponse = httpclient.execute(get);

			final JsonNode queryResults = mapper.readValue(queryResponse.getEntity().getContent(), JsonNode.class);

			// Mapping result and create CSV file.
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			//System.out.println("mmmmmmmmmm " + queryResults.get("records"));
			List<CampaignMember> listCampaign = mapper.readValue(queryResults.get("records").toString(),
					new TypeReference<List<CampaignMember>>() {
					});

			//System.out.println(listCampaign);

			String arrayToJson = mapper.writeValueAsString(listCampaign);
			List<Map<String, String>> flatJson = JSONFlattener.parseJson(arrayToJson);

			System.out.println(" flatJson " + flatJson);

			CSVWriter.writeToFile(CSVWriter.getCSV(flatJson), "./sample_string.csv");

			// System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(queryResults));

			System.out.println("1. Convert List of person objects to JSON :");
			System.out.println(arrayToJson);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private List<Map<String, String>> listToListOfMap(List<CampaignMember> listCampaign) {

		List flatJson = new ArrayList<Map<String, String>>();
		// flatJson.add(parse(jsonObject));

		return null;

	}

}
