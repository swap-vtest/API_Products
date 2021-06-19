package DL_Products_API;

public class payload_DL_Consent_200_Plus {
	
	
	public static String Addbook1(String aisle , String isbn) {
		String payload = "{\r\n"
				+ "    \"mode\": \"sync\",\r\n"
				+ "    \"data\": {\r\n"
				+ "        \"customer_dl_number\": \""+aisle+"\",\r\n"
				+ "        \"consent\": \"Y\",\r\n"
				+ "        \"consent_text\": \""+isbn+"\"\r\n"
				+ "    }\r\n"
				+ "}";
		//	+ "}\r\n";
		return payload ; 
	}

}
