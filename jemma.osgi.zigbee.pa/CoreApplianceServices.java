package org.fiware.jemma.zigbee.pa;

/** Copyright (C) 2012 Telecom Italia S.p.A. **/

import org.energy_home.jemma.ah.cluster.zigbee.general.IdentifyQueryResponse;


import org.energy_home.jemma.ah.cluster.zigbee.general.IdentifyServer;
import org.energy_home.jemma.ah.hac.ApplianceException;
import org.energy_home.jemma.ah.hac.IAppliance;
import org.energy_home.jemma.ah.hac.IApplianceDescriptor;
import org.energy_home.jemma.ah.hac.IEndPointRequestContext;
import org.energy_home.jemma.ah.hac.IServiceCluster;
import org.energy_home.jemma.ah.hac.ServiceClusterException;
import org.energy_home.jemma.ah.hac.lib.Appliance;
import org.energy_home.jemma.ah.hac.lib.ApplianceDescriptor;
import org.energy_home.jemma.ah.hac.lib.EndPoint;
import org.energy_home.jemma.ah.hac.lib.ServiceCluster;

import java.util.Hashtable;
import java.util.Random;

public class CoreApplianceServices extends Appliance implements IdentifyServer {
	private static CoreApplianceServices instance = null;
	
	private static final String APPLIANCE_TYPE = "ah.app.cas";
	private static final String END_POINT_TYPE = "ah.ep.cas";
	public static final String APPLIANCE_FRIENDLY_NAME = "Core Appliance Services";
	public static final IApplianceDescriptor APPLIANCE_DESCRIPTOR = new ApplianceDescriptor(APPLIANCE_TYPE, null,
			APPLIANCE_FRIENDLY_NAME);
	private static Hashtable config = new Hashtable(1);

	static {
		try {
			instance = new CoreApplianceServices();
		} catch (ApplianceException e) {
			e.printStackTrace();
		}
	}
	
	public static IServiceCluster getServiceCluster(String name) {
		if (name.equals(IdentifyServer.class.getName()))
			return instance.identifyServer;
		else 
			return null;
	}
	
	private EndPoint endPoint;
	private ServiceCluster identifyServer;

	static {
		config.put(IAppliance.APPLIANCE_NAME_PROPERTY, APPLIANCE_FRIENDLY_NAME);
	}

	public CoreApplianceServices() throws ApplianceException {
		super(APPLIANCE_TYPE, config);
		endPoint = addEndPoint(END_POINT_TYPE);
		identifyServer = endPoint.registerCluster(IdentifyServer.class.getName(), this);
	}

	public synchronized void start() {
		super.start();
		System.out.println("Core appliance started");
	}

	public synchronized void stop() {
		super.stop();
		System.out.println("AAL appliance stopped");
	}
	
	public IApplianceDescriptor getDescriptor() {
		return APPLIANCE_DESCRIPTOR;
	}



	public int getIdentifyTime(IEndPointRequestContext context) throws ApplianceException {
		return new Random().nextInt();
	}

	public IdentifyQueryResponse execIdentifyQuery(IEndPointRequestContext context)
			throws ApplianceException {
	
		IAppliance originatingAppliance = context.getPeerEndPoint().getAppliance();			
		return new IdentifyQueryResponse(0xFFFF);
	}


	public void execIdentify(IEndPointRequestContext context) throws ApplianceException {
		// TODO: check for final implementation
		System.out.println("execIdentify ");
	}

	public void setIdentifyTime(int IdentifyTime, IEndPointRequestContext context) throws ApplianceException {
		// TODO: check for final implementation
		System.out.println("setIdentifyTime " + IdentifyTime);
	}


	public void execIdentify(int IdentifyTime, IEndPointRequestContext context)
			throws ApplianceException, ServiceClusterException {
		// TODO Auto-generated method stub
		
	}
}
