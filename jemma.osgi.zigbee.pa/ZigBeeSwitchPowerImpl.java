package org.fiware.jemma.zigbee.pa;

/** Copyright (C) 2012 Telecom Italia S.p.A. **/

import com.ericsson.deviceaccess.spi.service.homeautomation.power.SwitchPowerBase;

import org.energy_home.jemma.ah.cluster.zigbee.general.OnOffServer;
import org.energy_home.jemma.ah.hac.ApplianceException;
import org.energy_home.jemma.ah.hac.IEndPointRequestContext;
import org.energy_home.jemma.ah.hac.ServiceClusterException;
import org.energy_home.jemma.ah.zigbee.zcl.lib.ZclEndPoint;
import org.energy_home.jemma.ah.zigbee.zcl.lib.ZclServiceCluster;

public class ZigBeeSwitchPowerImpl extends SwitchPowerBase implements IServiceClusterInit {
	protected OnOffServer onOffServer;
	protected IEndPointRequestContext ctx;
	
	public ZigBeeSwitchPowerImpl(OnOffServer onOffServer) {
		super();
		this.onOffServer = onOffServer;
		this.ctx = ((ZclEndPoint)((ZclServiceCluster) onOffServer).getEndPoint()).getDefaultRequestContext();
	}
	
	public void initStatus() {
		System.out.println("$$$ ZigBeeSwitchPowerImpl: enter");
		try {
			if(onOffServer.getOnOff(ctx))
			//if(currentTarget)
				getProperties().setIntValue("CurrentTarget", 1);
			else
				getProperties().setIntValue("CurrentTarget", 0);
			
			
			System.out
					.println("$$$ ZigBeeSwitchPowerImpl: onOffServer attached");

		} catch (Throwable t1) {
			t1.printStackTrace();
		}
	}

	@Override
	public void executeSetTarget(int newTarget) {
		// TODO Auto-generated method stub
		System.out.println("$$$ executeSetTarget: enter");
		switch (newTarget) {
		case 0:
			try {
				System.out.println("$$$ executeSetTarget: before execOff");
				onOffServer.execOff(null);
				System.out.println("$$$ executeSetTarget: after execOff");
			} catch (ApplianceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServiceClusterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case 1:
			try {
				System.out.println("$$$ executeSetTarget: before execOn");
				onOffServer.execOn(null);
				System.out.println("$$$ executeSetTarget: after execOn");
			} catch (ApplianceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServiceClusterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			default:
				System.out.println("$$$ executeSetTarget: default");
				break;

		}
		getProperties().setIntValue("CurrentTarget", newTarget);
		System.out.println("$$$ executeSetTarget: updated the CurrentTarget value");
	}

	public int getCurrentStatus()
	{
		System.out.println("$$$ ZigBeeSwitchPowerImpl.getCurrentStatus(): enter");
		initStatus();
		System.out.println("$$$ ZigBeeSwitchPowerImpl.getCurrentStatus() currentTarget read "+getProperties().getIntValue("CurrentTarget"));
		
		return  getProperties().getIntValue("CurrentTarget");
	}
	
	@Override
	protected void a() {
		// TODO Auto-generated method stub
		System.out.println("aaa");
	}
}
