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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TraitementJsonCellenza {

	private static final String TOKEN_URL = "https://test.salesforce.com/services/oauth2/token";

	public static void main(String[] args) throws Exception {

			

			
		try {	
			
			String content = "{\"locality\":\"Région de Paris, France\",\"company\":\"Carmignac\",\"position\":\"SSIS Consultant\",\"picture\":\"https://env-production-profile-pictures.s3.eu-central-1.amazonaws.com/51294/picture.jpg\",\"contacts\":{\"phones\":[\"\",null],\"mails\":[\"\",null]},\"firstname\":\"mamadou\",\"lastname\":\"BA\",\"metadatas\":{\"skills\":[{\"name\":\"Unix\",\"hidden\":false,\"date\":\"2016-09-29T11:53:06.511Z\"},{\"name\":\"Multithreading\",\"hidden\":false,\"date\":\"2016-09-29T11:53:06.511Z\"},{\"name\":\"Trading Systems\",\"hidden\":false,\"date\":\"2016-09-29T11:53:06.511Z\"},{\"name\":\"SQL\",\"hidden\":false,\"date\":\"2016-09-29T11:53:06.511Z\"},{\"name\":\"C++\",\"hidden\":false,\"date\":\"2016-09-29T11:53:06.511Z\"},{\"name\":\"Market Data\",\"hidden\":false,\"date\":\"2016-09-29T11:53:06.511Z\"},{\"name\":\"Design Patterns\",\"hidden\":false,\"date\":\"2016-09-29T11:53:06.511Z\"},{\"name\":\"C#\",\"hidden\":false,\"date\":\"2016-09-29T11:53:06.511Z\"},{\"name\":\"Electronic Trading\",\"hidden\":false,\"date\":\"2016-09-29T11:53:06.511Z\"},{\"name\":\"Exchange Connectivity\",\"hidden\":false,\"date\":\"2016-09-29T11:53:06.511Z\"},{\"name\":\"Shell Scripting\",\"hidden\":false,\"date\":\"2016-09-29T11:53:06.511Z\"},{\"name\":\"Sybase\",\"hidden\":false,\"date\":\"2016-09-29T11:53:06.511Z\"},{\"name\":\".NET\",\"hidden\":false,\"date\":\"2016-10-26T12:46:10.350Z\"},{\"name\":\"ASP.NET\",\"hidden\":false,\"date\":\"2016-10-26T12:46:10.350Z\"},{\"name\":\"VB.NET\",\"hidden\":false,\"date\":\"2016-10-26T12:46:10.350Z\"},{\"name\":\"UML\",\"hidden\":false,\"date\":\"2016-10-26T12:46:10.350Z\"},{\"name\":\"LINQ\",\"hidden\":false,\"date\":\"2016-10-26T12:46:10.350Z\"},{\"name\":\"Visual Studio\",\"hidden\":false,\"date\":\"2016-10-26T12:46:10.350Z\"},{\"name\":\"Oracle\",\"hidden\":false,\"date\":\"2016-10-26T12:46:10.350Z\"},{\"name\":\"AJAX\",\"hidden\":false,\"date\":\"2016-10-26T12:46:10.350Z\"},{\"name\":\"NHibernate\",\"hidden\":false,\"date\":\"2016-10-26T12:46:10.350Z\"},{\"name\":\"OOP\",\"hidden\":false,\"date\":\"2016-10-26T12:46:10.350Z\"},{\"name\":\"Telerik Web Controls\",\"hidden\":false,\"date\":\"2016-10-26T12:46:10.350Z\"},{\"name\":\"Software Design Patterns\",\"hidden\":false,\"date\":\"2016-10-26T12:46:10.351Z\"},{\"name\":\"Aspose\",\"hidden\":false,\"date\":\"2016-10-26T12:46:10.351Z\"}],\"languages\":[{\"name\":\"English\",\"hidden\":false,\"date\":\"2016-10-26T12:46:10.351Z\"},{\"name\":\"French\",\"hidden\":false,\"date\":\"2016-10-26T12:46:10.351Z\"},{\"name\":\"Arabic\",\"hidden\":false,\"date\":\"2016-10-26T12:46:10.351Z\"},{\"name\":\"Wolof\",\"hidden\":false,\"date\":\"2016-10-26T12:46:10.351Z\"}]},\"categories\":[\"Web\",\"Mobile\"],\"skills\":[\"Unix\",\"Multithreading\",\"Trading Systems\",\"SQL\",\"C++\",\"Market Data\",\"Design Patterns\",\"C#\",\"Electronic Trading\",\"Exchange Connectivity\",\"Shell Scripting\",\"Sybase\",\".NET\",\"ASP.NET\",\"VB.NET\",\"UML\",\"LINQ\",\"Visual Studio\",\"Oracle\",\"AJAX\",\"NHibernate\",\"OOP\",\"Telerik Web Controls\",\"Software Design Patterns\",\"Aspose\"],\"experience\":[{\"date\":{\"from\":\"2002-01-01T00:00:00.000Z\",\"to\":\"2007-01-01T00:00:00.000Z\"},\"position\":\"Software engineer\",\"company\":\"gl trade\",\"creation_date\":\"2016-09-29T11:53:06.510Z\"},{\"date\":{\"from\":\"2008-01-01T00:00:00.000Z\",\"to\":\"2013-01-01T00:00:00.000Z\"},\"position\":\"Consultant Senior\",\"company\":\"Softeam Cadextan\",\"creation_date\":\"2017-10-02T13:26:59.037Z\"},{\"date\":{\"from\":\"2007-04-01T00:00:00.000Z\",\"to\":\"2010-12-01T00:00:00.000Z\"},\"position\":\"Software engineer\",\"company\":\"Umanis\",\"creation_date\":\"2016-09-29T11:53:06.510Z\"},{\"date\":{},\"position\":\"Consultant Senior\",\"company\":\"Softeam Cadextan\",\"creation_date\":\"2017-03-29T08:36:26.837Z\"},{\"date\":{\"from\":\"2007-05-01T00:00:00.000Z\",\"to\":\"2010-12-01T00:00:00.000Z\"},\"position\":\"contractor\",\"company\":\"Societe Generale\",\"creation_date\":\"2016-09-29T11:53:06.510Z\"},{\"date\":{},\"position\":\"SSIS Consultant\",\"company\":\"Carmignac\",\"creation_date\":\"2017-03-29T08:36:26.837Z\"},{\"date\":{\"from\":\"2002-03-01T00:00:00.000Z\",\"to\":\"2007-04-01T00:00:00.000Z\"},\"position\":\"Software engineer\",\"company\":\"GL Trade\",\"creation_date\":\"2016-09-29T11:53:06.510Z\"},{\"date\":{},\"position\":\"ASP.NET MVC / SSIS Consultant\",\"company\":\"Candriam\",\"creation_date\":\"2017-03-29T08:36:26.837Z\"},{\"date\":{\"from\":\"2011-01-01T00:00:00.000Z\",\"to\":\"2015-03-01T00:00:00.000Z\"},\"position\":\"Senior Software Engineer\",\"company\":\"Aubay\",\"creation_date\":\"2016-09-29T11:53:06.510Z\"},{\"date\":{\"from\":\"2008-01-01T00:00:00.000Z\",\"to\":\"2011-01-01T00:00:00.000Z\"},\"position\":\"ASP.NET C# developper\",\"company\":\"Amundi Asset Management\",\"creation_date\":\"2016-10-26T12:46:10.347Z\"},{\"date\":{\"from\":\"2011-01-01T00:00:00.000Z\",\"to\":\"2015-03-01T00:00:00.000Z\"},\"position\":\"Senior Software Engineer\",\"company\":\"Credit Agricole CIB\",\"creation_date\":\"2016-09-29T11:53:06.510Z\"},{\"date\":{\"from\":\"2003-07-01T00:00:00.000Z\",\"to\":\"2003-12-01T00:00:00.000Z\"},\"position\":\"Windev / Webdev Developper\",\"company\":\"chambre d'agriculture du loiret\",\"creation_date\":\"2016-10-26T12:46:10.347Z\"},{\"date\":{\"from\":\"2003-01-01T00:00:00.000Z\",\"to\":\"2007-01-01T00:00:00.000Z\"},\"position\":\"software engineer\",\"company\":\"SunGard Global Trading\",\"creation_date\":\"2016-09-29T11:53:06.510Z\"},{\"date\":{\"from\":\"2012-03-01T00:00:00.000Z\",\"to\":\"2013-03-01T00:00:00.000Z\"},\"position\":\"Asp.net Analyst / Programmer\",\"company\":\"Ivanhoé Cambridge\",\"creation_date\":\"2017-10-02T13:26:59.037Z\"},{\"date\":{\"from\":\"2013-09-01T00:00:00.000Z\",\"to\":\"2014-11-01T00:00:00.000Z\"},\"position\":\"Senior .Net Consultant\",\"company\":\"Dexia Asset Management\",\"creation_date\":\"2017-10-02T13:26:59.037Z\"},{\"date\":{\"from\":\"2014-12-01T00:00:00.000Z\",\"to\":\"2016-06-01T00:00:00.000Z\"},\"position\":\"ASP.NET MVC / SSIS Consultant\",\"company\":\"Candriam\",\"creation_date\":\"2017-10-02T13:26:59.037Z\"},{\"date\":{\"from\":\"2016-07-01T00:00:00.000Z\"},\"position\":\"SSIS Consultant\",\"company\":\"Carmignac\",\"creation_date\":\"2017-10-02T13:26:59.037Z\"},{\"date\":{},\"position\":\"Senior .Net Consultant\",\"company\":\"Dexia Asset Management\",\"creation_date\":\"2017-03-29T08:36:26.837Z\"},{\"date\":{\"from\":\"2014-01-01T00:00:00.000Z\",\"to\":\"2015-01-01T00:00:00.000Z\"},\"position\":\"Senior Software Engineer\",\"company\":\"HSBC\",\"creation_date\":\"2016-09-29T11:54:15.661Z\"},{\"date\":{\"from\":\"2013-09-01T00:00:00.000Z\"},\"position\":\"Senior .Net Consultant\",\"company\":\"Front Consulting\",\"creation_date\":\"2016-10-26T12:46:10.347Z\"},{\"date\":{\"from\":\"2005-04-01T00:00:00.000Z\",\"to\":\"2008-08-01T00:00:00.000Z\"},\"position\":\".NET Analyst / Programmer\",\"company\":\"NextiraOne\",\"creation_date\":\"2016-10-26T12:46:10.347Z\"},{\"date\":{},\"position\":\"Asp.net Analyst / Programmer\",\"company\":\"Ivanhoé Cambridge\",\"creation_date\":\"2017-03-29T08:36:26.837Z\"}],\"education\":[{\"date\":{\"from\":\"1997-01-01T00:00:00.000Z\",\"to\":\"2002-01-01T00:00:00.000Z\"},\"grade\":\"\",\"title\":\"Université du Havre\",\"creation_date\":\"2016-09-29T11:53:06.511Z\"},{\"date\":{\"from\":\"2001-01-01T00:00:00.000Z\",\"to\":\"2005-01-01T00:00:00.000Z\"},\"grade\":\"Master, Computer Science\",\"title\":\"IUP MIAGE\",\"creation_date\":\"2016-10-26T12:46:10.348Z\"},{\"date\":{\"from\":\"2001-01-01T00:00:00.000Z\",\"to\":\"2005-01-01T00:00:00.000Z\"},\"grade\":\", \",\"title\":\"IUP MIAGE\",\"creation_date\":\"2017-03-29T08:36:26.849Z\"}],\"languages\":[\"English\",\"French\",\"Arabic\",\"Wolof\"]}";
			// parse
			final ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

			//final JsonNode queryResults = mapper.readValue(queryResponse.getEntity().getContent(), JsonNode.class);

			// Mapping result and create CSV file.
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			
			//List<Map<String, String>> flatJson = JSONFlattener.parseJson(content);
			
			
			List<Map<String, String>>  flatJson = JSONFlattener.parseJson(new File("./4lignes.json"), "UTF-8");
			System.out.println(" flatJson " + flatJson);
			
			CSVWriter.writeToFile(CSVWriter.getCSV(flatJson, ","), "files/ligne4.csv");
			

			
			
			//CSVWriter.writeToFile(CSVWriter.getCSV(flatJson), "./profil_string.csv");

			// System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(queryResults));

			System.out.println("1. Convert List of person objects to JSON :");
			//System.out.println(arrayToJson);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private List<Map<String, String>> listToListOfMap(List<CampaignMember> listCampaign) {

		List flatJson = new ArrayList<Map<String, String>>();
		// flatJson.add(parse(jsonObject));

		return null;

	}

}
