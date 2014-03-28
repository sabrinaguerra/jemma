package org.fiware.jemma.zigbee.pa;

/** Copyright (C) 2012 Telecom Italia S.p.A. **/

import org.energy_home.jemma.ah.hac.ApplianceException;
import org.energy_home.jemma.ah.hac.IServiceCluster;
import org.energy_home.jemma.ah.zigbee.zcl.lib.ZclEndPoint;

public class ZclGenericDeviceEndPoint extends ZclEndPoint {

	
	public ZclGenericDeviceEndPoint(String type) throws ApplianceException {
		super(type);
	}
	
	public IServiceCluster[] getPeerServiceClusters(String clusterName) {
		return new IServiceCluster[] {CoreApplianceServices.getServiceCluster(clusterName)};
	}
}
