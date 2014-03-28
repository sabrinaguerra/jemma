package org.fiware.jemma.zigbee.pa;

/** Copyright (C) 2012 Telecom Italia S.p.A. **/


import java.net.*;
import java.io.*;
import java.util.*;


public class NGSIClientOperation
{
	public int REGISTERCTXT = 0;
	public int UPDATECTXT = 1;
	String urlAddress;
	String urlAddressSink;
	
	/* URLs to test the ZPA with the instance of Esper4FastData.  
	 * The prefix of these URLs are configured as system environment variable --> defined into URLNGSIESPER4FASTDATA
	 * The instance of Esper4FastData could be deployed in the Tomcat on the remote testbed in Sevilla and in this case the URL prefix should be for example:
	 * 							http://130.206.81.67/Esper4FastData/
	 * Otherwise the instance of Esper4FastData could be deployed in the Tomcat on my PC and in this case the URL prefix should be for example:
	 * 							http://127.0.0.1/Esper4FastData/
	 * 
	 * URL postfix to reset the embedded DB (mandatory operation ONLY to communicate with the Data Handling):
	 * 				database/reset
	 * 
	 * URL postfix for the registerContext method:
	 * 				ngsi9/registerContext
	 * 
	 * URL postfix for the updateContext method:
	 *				ngsi10/updateContext 
	 **/
	
	/* URLs to test the ZPA with the client servlet local on my PC 
	 * If the system environment variable (URLNGSIESPER4FASTDATA) is NOT setted then the prefix of these URLs are set (as default value --> URLNGSISERVLETZPA):
	 *  						http://127.0.0.1:8080/zpa/
	 *  
	 * URL postfix to reset the embedded DB (mandatory operation ONLY to communicate with the Data Handling):
	 * 				database/reset
	 * 
	 * URL postfix for the registerContext method:
	 * 				registerContext
	 * 
	 * URL postfix for the updateContext method:
	 *				updateContext
	*/

	protected static String URLNGSIESPER4FASTDATA = "Esper4FastData.ngsi.uri";
	protected static String URLNGSIEVENTSINK = "EventSink.ngsi.uri";
	private static String URLNGSISERVLETZPA = "http://127.0.0.1:8080/zpa/";
	private static String NGSI9 = "NGSI9/";
	private static String NGSI10 = "NGSI10/";
	
	String urlEsper4FastData = System.getProperty(URLNGSIESPER4FASTDATA);
	String urlEventSink = System.getProperty(URLNGSIEVENTSINK);
	
	private static String URLNGSIRC = "registerContext";
	private static String URLNGSIUC = "updateContext";
	private static String URLNGSIRESETGE = "admin/esper4fastdata";
	private static String URLNGSISTARTGE = "cep/instance";
	
	private static String CLIENTZPALOCALADDR = "it.telecomitalia.client.zpa.local-address";
	private String localClientUri = System.getProperty(CLIENTZPALOCALADDR);
	
	private static String ZPAURI = "/zpa/ngsi";

	String method;
	String body;
	int lines = 30;
	private ZigBeeGenericDeviceImpl device;
	float power;
	int status;

	
	public NGSIClientOperation(int typeOperation)
	{
		init (null, power, status, typeOperation);
	}
	
	public NGSIClientOperation(ZigBeeGenericDeviceImpl dev, int typeOperation)
	{
		init (dev, power, status, typeOperation);
	}


	public NGSIClientOperation (ZigBeeGenericDeviceImpl dev, float power, int status ,int typeOperation)
	{
		init (dev, power, status, typeOperation);
	}
	
	////////////////////
	protected void eventConsumerUrl (int typeOperation) {
		
		String url;
		
		System.out.println("@@@@@@ eventConsumerUrl ENV VAR urlEsper4FastData= "+ urlEsper4FastData);
		System.out.println("@@@@@@ eventConsumerUrl ENV VAR urlEventSink= "+ urlEventSink);
		System.out.println("@@@@@@ eventConsumerUrl NGSI URL of local client servlet ZPA  = "+ localClientUri);
		
		switch (typeOperation)
		{
		case 0: // registerContext
			
			url = urlEsper4FastData == null ? localClientUri :  urlEsper4FastData+NGSI9;
			urlAddress = url + URLNGSIRC;
			method = "POST";
			break;
		case 1: // updateContext
			url = urlEsper4FastData == null ? localClientUri :  urlEsper4FastData+NGSI10;
			urlAddress = url + URLNGSIUC;
			method = "POST";
			break;
		case 2: // reset the DB of the GE. It is only used for the init phase
			url = urlEsper4FastData == null ? localClientUri :  urlEsper4FastData;
			urlAddress = url + URLNGSIRESETGE;
			// URL for reset the EventSink
			//url = urlEventSink == null ? URLNGSISERVLETZPA :  urlEventSink;
			//urlAddressSink = url + URLNGSIRESETGE;
			method = "DELETE";
			break;
		case 3: // start the CEP component. It is only used for the init phase
			url = urlEsper4FastData == null ? localClientUri :  urlEsper4FastData;
			urlAddress = url + URLNGSISTARTGE;
			// URL for start the EventSink
			//url = urlEventSink == null ? URLNGSISERVLETZPA :  urlEventSink;
			//urlAddressSink = url + URLNGSISTARTGE;
			method = "POST";
			break;
		default:
			break;
		} // end of switch
		
		System.out.println("@@@@@@ eventConsumerUrl urlAddress = "+ urlAddress);
		System.out.println("@@@@@@ eventConsumerUrl urlAddressSink = "+ urlAddressSink);

	}
	///////////////////
	
	private void init (ZigBeeGenericDeviceImpl dev, float power, int status, int typeOperation)
	{
		HttpURLConnection connection = null;
		BufferedReader in;
		long time;
		String line;
		StringBuffer responseBody = new StringBuffer();
		Vector<String> response = new Vector<String>();
		Enumeration<String> e;
		OutputStreamWriter out = null;

		this.device = dev;
		this.power = power;
		this.status = status;
		
		/***************************************************************************
		 * Create the URL  to communicate with the Event Consumer (currently this is the Data Handling)     *
		 ***************************************************************************/
		eventConsumerUrl (typeOperation);


		System.out.println("\n### Sending request: "+method+" "+urlAddress);

		/***************************************************************************
		 * Create the connection to the remote object referred to by the URL        *
		 ***************************************************************************/
		try
		{
			connection = (HttpURLConnection)new URL(urlAddress).openConnection();
		}
		catch (MalformedURLException x)
		{
			System.out.println("!!! MARLFORMED URL EXCEPTION: "+x.getMessage());
			x.printStackTrace();
			return;
			
		}
		catch (IOException j)
		{
			System.out.println("!!! IO EXCEPTION: "+j.getMessage());
			j.printStackTrace();
			return;
			
		}

		/***************************************************************************
		 * Set the HTTP method (it can be GET, POST, PUT, or DELETE)                *
		 ***************************************************************************/
		try
		{
			connection.setRequestMethod(method);
		}
		catch (ProtocolException y)
		{
			System.out.println("!!! PROTOCOL EXCEPTION: "+y.getMessage());
			y.printStackTrace();
			
		}

		connection.setDoOutput(true);
		
		/***************************************************************************
		 * If method is POST or PUT then write the request body                     *
		 ***************************************************************************/
		if (method.equals("POST") || method.equals("PUT"))
		{
			//
			
			if (typeOperation != 2)
			{
				connection.setRequestProperty ("Content-Type", "application/xml");

				out = setPayload (connection, typeOperation);
				try {
					out.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					if (connection!= null) 
						connection.disconnect();
					return;
				}
			}
		
			System.out.println("\n### request sent: "+method+" "+urlAddress);

		} // end IF for 'POST' and 'PUT'
		

		/***************************************************************************
		 * Open the communication link to the resource referenced by the URL        *
		 ***************************************************************************/
		time = System.currentTimeMillis();
		try
		{
			connection.connect();
			
		}
		catch (IOException z)
		{
			System.out.println("!!! IO EXCEPTION: "+z.getMessage());
			z.printStackTrace();
			if (connection!= null) 
				connection.disconnect();
			return;
		}

		/***************************************************************************
		 * Get the response body                                                    *
		 ***************************************************************************/
		try
		{
			in = new BufferedReader(
					new InputStreamReader(connection.getInputStream()));
			while ((line = in.readLine()) != null)
			{
				responseBody.append(line);
				response.add(line);
			}
			in.close();
		}
		catch (IOException w)
		{
			System.out.println("!!! IO EXCEPTION: "+w.getMessage());
			w.printStackTrace();
			if (connection!= null) 
				connection.disconnect();
			return;
			
		}

		/***************************************************************************
		 * Close the communication link                                             *
		 ***************************************************************************/
		connection.disconnect();
		time = System.currentTimeMillis() - time;
		
		 

		/***************************************************************************
		 * Print the response                                                       *
		 ***************************************************************************/
		System.out.println("### Response received: read "+responseBody.length()+
				" chars in "+time+"ms");
		System.out.println("### Status: "+connection.getHeaderField(0));
		System.out.println("### Response Body:");
		e = response.elements();
		for (int i = 0; e.hasMoreElements() && i < lines; i++)
			System.out.println(e.nextElement());
		
		
	} // end of init
	


	protected OutputStreamWriter setPayload (HttpURLConnection connection, int typeOperation)
	{
		OutputStreamWriter out = null;
	//	String localClientUri;

		try
		{
			out = new OutputStreamWriter(connection.getOutputStream());

			switch (typeOperation)
			{
			case 0: // registerContext
				
				// get the environment property
			//	localClientUri = System.getProperty(CLIENTZPALOCALADDR); 
				
				System.out.println ("setPayload case:registerContext "+CLIENTZPALOCALADDR+" : "+localClientUri);
				
				try {
					out.write("<?xml version='1.0' encoding='UTF-8'?>");
					out.write("<registerContextRequest>");
					out.write("<contextRegistrationList>");
					out.write("<contextRegistration>");
					out.write("<entityIdList>");
					out.write("<entityId type='SmartPlug' isPattern='false'>");
					out.write("<id>"+device.getId()+"</id>");
					out.write("</entityId>");
					out.write("</entityIdList>");
					out.write("<contextRegistrationAttributeList>");
					out.write("<contextRegistrationAttribute>");
					out.write("<name>name</name>"); // attribute 'name'
					out.write("<type>xs:string</type>");
					out.write("<isDomain>false</isDomain>");
					out.write("</contextRegistrationAttribute>");
					out.write("<contextRegistrationAttribute>");
					out.write("<name>manufacturer</name>"); // attribute 'manufacturer'
					out.write("<type>xs:string</type>");
					out.write("<isDomain>false</isDomain>");
					out.write("</contextRegistrationAttribute>");
					out.write("<contextRegistrationAttribute>");
					out.write("<name>model</name>"); // attribute 'model'
					out.write("<type>xs:string</type>");
					out.write("<isDomain>false</isDomain>");
					out.write("</contextRegistrationAttribute>");
					out.write("<contextRegistrationAttribute>");
					out.write("<name>protocol</name>"); // attribute 'protocol'
					out.write("<type>xs:string</type>");
					out.write("<isDomain>false</isDomain>");
					out.write("</contextRegistrationAttribute>");
					out.write("<contextRegistrationAttribute>");
					out.write("<name>currentPower</name>"); // attribute 'currentPower'
					out.write("<type>xs:float</type>");
					out.write("<isDomain>false</isDomain>");
					out.write("</contextRegistrationAttribute>");
					out.write("<contextRegistrationAttribute>");
					out.write("<name>currentState</name>"); // attribute 'currentState'
					out.write("<type>xs:integer</type>");
					out.write("<isDomain>false</isDomain>");
					out.write("</contextRegistrationAttribute>");
					out.write("</contextRegistrationAttributeList>");
					out.write("<registrationMetaData>");
					out.write("<contextMetadata>");
					out.write("<name>timestamp</name>");
					out.write("<type>xs:dateTime</type>");
					out.write("<value/>");
					out.write("</contextMetadata>");
					out.write("</registrationMetaData>");
					out.write("<providingApplication>"+localClientUri+ZPAURI+"</providingApplication>");
					out.write("</contextRegistration>");
					out.write("</contextRegistrationList>");
					out.write("<duration>P5D</duration>");
					out.write("<registrationId/>");
					out.write("</registerContextRequest>");

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;
			case 1: // updateContext
				
				out.write("<?xml version='1.0' encoding='UTF-8' standalone='no'?>");
				out.write("<updateContextRequest>");
				out.write("  <contextElementList>");
				out.write("    <contextElement>");
				out.write("      <entityId type='SmartPlug' isPattern='false'>");
				out.write("        <id>"+device.getId()+"</id>");
				out.write("      </entityId>");
				out.write("      <attributeDomainName>SmartPlug</attributeDomainName>");
				out.write("      <contextAttributeList>");
				out.write("        <contextAttribute>");
				out.write("          <name>name</name>"); // attribute 'name'
				out.write("          <type>xs:string</type>");
				out.write("          <contextValue>"+device.getName()+"</contextValue>");
				out.write("        </contextAttribute>");
				out.write("        <contextAttribute>");
				out.write("          <name>manufacturer</name>"); // attribute 'manufacturer'
				out.write("          <type>xs:string</type>");
				out.write("          <contextValue>"+device+"</contextValue>");
				out.write("        </contextAttribute>");
				out.write("        <contextAttribute>");
				out.write("          <name>model</name>"); // attribute 'model'
				out.write("          <type>xs:string</type>");
				out.write("          <contextValue>"+device.getModelName()+"</contextValue>");
				out.write("        </contextAttribute>");
				out.write("        <contextAttribute>");
				out.write("          <name>protocol</name>"); // attribute 'protocol'
				out.write("          <type>xs:string</type>");
				out.write("          <contextValue>"+device.getProtocol()+"</contextValue>");
				out.write("        </contextAttribute>");
				out.write("        <contextAttribute>");
				out.write("          <name>currentPower</name>"); // attribute 'currentPower'
				out.write("          <type>xs:float</type>");
				out.write("          <contextValue>"+power+"</contextValue>");
				out.write("        </contextAttribute>");
				out.write("        <contextAttribute>");
				out.write("          <name>currentState</name>"); // attribute 'currentState'
				out.write("          <type>xs:integer</type>");
				out.write("          <contextValue>"+status+"</contextValue>");
				out.write("        </contextAttribute>");
				out.write("      </contextAttributeList>");
				out.write("      <domainMetadata>");
				out.write("        <contextMetadata>");
				out.write("          <name>timestamp</name>");
				out.write("          <type>xs:dataTime</type>");
				out.write("          <value>"+System.currentTimeMillis()+"</value>");
				out.write("        </contextMetadata>");
				out.write("      </domainMetadata>");
				out.write("    </contextElement>");
				out.write("  </contextElementList>");			
				out.write("  <updateAction>UPDATE</updateAction>");
				out.write("</updateContextRequest>");

				break;
				
			default:
				break;

			} // end switch

			//out.close();
			
		} // end try on OutputStreamWriter
		catch (IOException e)
		{
			System.out.println("!!! IO EXCEPTION: "+e.getMessage());
			e.printStackTrace();
		}

		return out;
	}
}