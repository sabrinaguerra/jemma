package org.fiware.jemma.zigbee.pa;

/** Copyright (C) 2012 Telecom Italia S.p.A. **/

import org.energy_home.jemma.ah.cluster.zigbee.metering.SimpleMeteringServer;
import org.energy_home.jemma.ah.hac.IEndPointRequestContext;
import org.energy_home.jemma.ah.hac.IServiceCluster;
import org.energy_home.jemma.ah.hac.lib.SubscriptionParameters;
import org.energy_home.jemma.ah.zigbee.zcl.lib.ZclServiceCluster;
import org.energy_home.jemma.ah.zigbee.zcl.lib.ZclEndPoint;

import com.ericsson.deviceaccess.spi.service.homeautomation.power.PowerSensorBase;

public class ZigBeePowerSensorImpl extends PowerSensorBase implements IServiceClusterInit
{
	public float currentPower;
	protected SimpleMeteringServer simpleMeteringCluster;
	protected IEndPointRequestContext ctx;
	public ZigBeePowerSensorImpl (SimpleMeteringServer simpleMeteringCluster)
	{
		super();
		this.simpleMeteringCluster = simpleMeteringCluster;	
		this.ctx = ((ZclEndPoint)((ZclServiceCluster) simpleMeteringCluster).getEndPoint()).getDefaultRequestContext();
	}
	
	public void initStatus() {
		System.out.println("$$$ ZigBeePowerSensorImpl: enter");
		try {

			System.out
					.println("$$$ ZigBeePowerSensorImpl: simpleMeteringCluster attached");
			SubscriptionParameters parameters = new SubscriptionParameters(2, 2, 0);
			//SubscriptionParameters parameters = new SubscriptionParameters(10, 0xffff, 0);
			((IServiceCluster)simpleMeteringCluster).setAttributeSubscription(simpleMeteringCluster.ATTR_IstantaneousDemand_NAME, parameters, ctx);			
			
			//currentPower = simpleMeteringCluster.getIstantaneousDemand(ctx);
			//System.out.println("$$$ ZigBeePowerSensorImpl: CurrentPower with getIstantaneousDemand "+currentPower);
			// getProperties().setFloatValue("CurrentPower", currentPower);
			
		} catch (Throwable t1) {
			t1.printStackTrace();
		}
	}


	@Override
	protected void a() {
		// TODO Auto-generated method stub
		
	}

	public void notifyCurrentPower(float currentPower) {
		this.currentPower = currentPower;
		
		getProperties().setFloatValue("CurrentPower", currentPower);
		
		System.out.println("\n$$$ ZigBeePowerSensorImpl: CurrentPower with notifyCurrentPower "+currentPower);
	}

}

