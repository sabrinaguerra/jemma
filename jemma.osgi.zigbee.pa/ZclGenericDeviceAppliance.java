package org.fiware.jemma.zigbee.pa;

/** Copyright (C) 2012 Telecom Italia S.p.A. **/

import java.util.Hashtable;

import org.energy_home.jemma.ah.hac.ApplianceException;
import org.energy_home.jemma.ah.hac.IAppliance;
import org.energy_home.jemma.ah.hac.IApplianceDescriptor;
import org.energy_home.jemma.ah.hac.lib.ApplianceDescriptor;
import org.energy_home.jemma.ah.zigbee.zcl.lib.ZclAppliance;
import org.energy_home.jemma.ah.zigbee.zcl.lib.ZclEndPoint;

public class ZclGenericDeviceAppliance extends ZclAppliance {
	private static final String APPLIANCE_TYPE = "ah.app.gda";
	private static final String END_POINT_TYPE = "ah.ep.gda";
	public static final String APPLIANCE_FRIENDLY_NAME = "Generic Device Appliance";
	public static final IApplianceDescriptor APPLIANCE_DESCRIPTOR = new ApplianceDescriptor(APPLIANCE_TYPE, null,
			APPLIANCE_FRIENDLY_NAME);
	private static Hashtable config = new Hashtable(1);

	private ZclGenericDeviceEndPoint endPoint;

	static {
		config.put(IAppliance.APPLIANCE_NAME_PROPERTY, APPLIANCE_FRIENDLY_NAME);
	}

	public ZclGenericDeviceAppliance(String pid) throws ApplianceException {
		super(pid, config);
		endPoint = (ZclGenericDeviceEndPoint)addEndPoint(new ZclGenericDeviceEndPoint(END_POINT_TYPE));
	}
	
	public IApplianceDescriptor getDescriptor() {
		return APPLIANCE_DESCRIPTOR;
	}
	
	public ZclEndPoint zclGetEndPoint() {
		return endPoint;
	}
	
	protected void attached() {
		System.out.println("attached");
	}

	protected void detached() {
		System.out.println("detached");
	}

}
