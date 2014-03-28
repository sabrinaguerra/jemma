package org.fiware.jemma.zigbee.pa;

/** Copyright (C) 2012 Telecom Italia S.p.A. **/

import org.energy_home.jemma.ah.cluster.zigbee.metering.SimpleMeteringServer;
import org.energy_home.jemma.ah.hac.ApplianceException;
import org.energy_home.jemma.ah.hac.IAttributeValue;
import org.energy_home.jemma.ah.hac.IEndPointRequestContext;
import org.energy_home.jemma.ah.hac.IServiceClustersListener;
import org.energy_home.jemma.ah.hac.ServiceClusterException;
import org.energy_home.jemma.ah.zigbee.ZigBeeDevice;
import org.energy_home.jemma.ah.zigbee.zcl.cluster.general.ZclIdentifyClient;
import org.energy_home.jemma.ah.zigbee.zcl.cluster.general.ZclOnOffServer;
import org.energy_home.jemma.ah.zigbee.zcl.cluster.metering.ZclSimpleMeteringServer;
import org.energy_home.jemma.ah.zigbee.zcl.lib.ZclEndPoint;
import org.energy_home.jemma.zgd.jaxb.ServiceDescriptor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.osgi.framework.BundleContext;

import com.ericsson.deviceaccess.api.GenericDevice;
import com.ericsson.deviceaccess.spi.schema.SchemaBasedGenericDevice;

//public class ZigBeeGenericDeviceImpl extends SchemaBasedGenericDevice implements GenericDevice, IServiceClustersListener {
public class ZigBeeGenericDeviceImpl extends SchemaBasedGenericDevice implements IServiceClustersListener {

	private static int UPDATECTXT = 1;
	private ZigBeeDevice device;
	//private final static Log log = LogFactory.getLog(ZigBeeDeviceFactory.class);
	private BundleContext bc;
	boolean currentTarget;
	protected ZclGenericDeviceAppliance appliance = null;
	protected HashMap services = new HashMap();	
	private Object sLock = new Object();
	
	
	private class NgsiUpdateTask extends Thread {

		private ZigBeeSwitchPowerImpl zbsp;
		private Integer instPower;
		private ZigBeeGenericDeviceImpl zbgdi;

		public NgsiUpdateTask (ZigBeeGenericDeviceImpl zbgdi,Integer instPower, ZigBeeSwitchPowerImpl zbsp) {
			this.instPower = instPower;
			this.zbsp = zbsp;
			this.zbgdi = zbgdi;
		}

		@Override
		public void run() {

			// for each incoming power value from the ZigBee network, a new NGSIClient is instanced 
			// to enable an updateContext operation towards the DataHandling GE.
			new NGSIClientOperation(zbgdi, instPower, zbsp.getCurrentStatus(),UPDATECTXT);
			System.out.println("$$$ NgsiUpdateTask: UPDATE sent ");

		}
	} // end of NgsiFactoryTask
	
	
	public ZigBeeGenericDeviceImpl(ZigBeeDevice dev) {
		System.out.println("$$$ ZigBeeGenericDeviceImpl: constructor");
		this.device = dev;
	}
	
	public void init () {
		System.out.println("$$$ ZigBeeGenericDeviceImpl: init");
		synchronized (sLock) {
			ServiceDescriptor sd = device.getServiceDescriptor();
			short endpoint = sd.getEndPoint();
			System.out.println("$$$ Endpoint: " + endpoint);
			List<Integer> iclus = sd.getSimpleDescriptor()
					.getApplicationInputCluster();
			System.out.println("$$$ Input Clusters: ");
			for (int c : iclus) {
				System.out.printf("%04x ", c);
			}
			System.out.println("\n$$$ Output Clusters: ");
			List<Integer> oclus = sd.getSimpleDescriptor()
					.getApplicationOutputCluster();
			for (int c : oclus) {
				System.out.printf("%04x ", c);
			}
			System.out.println("");
	
			try {
				this.appliance = new ZclGenericDeviceAppliance("ah.app."+device.getIeeeAddress()+ "." + endpoint);
			} catch (ApplianceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ZclEndPoint ep = appliance.zclGetEndPoint();
			if (iclus.contains(0x0006)) {
				ZclOnOffServer onOffCluster = null;
				try {
					onOffCluster = new ZclOnOffServer();
					ep.addServiceCluster(onOffCluster);
				} catch (ApplianceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
				
				// ZCL profile, OnOff cluster;
				services.put("SwitchPower", new ZigBeeSwitchPowerImpl(onOffCluster));
				
				System.out
						.println("$$$ ZigBeeGenericDeviceImpl: created a new instance of SwitchPower");
			}
			
			if(iclus.contains(0x0702)) { 
				// SmartEnergy profile, Metering cluster
				ZclSimpleMeteringServer simpleMeteringCluster = null;
				try {
					simpleMeteringCluster = new ZclSimpleMeteringServer();
					ep.addServiceCluster(simpleMeteringCluster);
				} catch (ApplianceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				services.put("PowerSensor", new ZigBeePowerSensorImpl(simpleMeteringCluster));
				System.out
				.println("$$$ ZigBeeGenericDeviceImpl: created a new instance of PowerSensor");
			}
			
			if (iclus.contains(0x0003)) {
				// Identify client
				// SmartEnergy profile, Metering cluster
				ZclIdentifyClient identifyClient = null;
				try {
					identifyClient = new ZclIdentifyClient();
					ep.addServiceCluster(identifyClient);
				} catch (ApplianceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			appliance.attach(device);	
			ep.registerServiceClustersListener(this);
			for (Iterator iterator = services.values().iterator(); iterator.hasNext();)
				((IServiceClusterInit) iterator.next()).initStatus();
			
			setService(services);
		}
	}
		
	public void release() {
		System.out.println("$$$ ZigBeeGenericDeviceImpl: release");
		synchronized (sLock) {
			try {
				if (appliance != null)
					appliance.detach(device);
			} catch (ApplianceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			device = null;
		}
	}

	@Override
	public void notifyAttributeValue(String clusterName, String attributeName, IAttributeValue attributeValue,
			IEndPointRequestContext endPointRequestContext) throws ServiceClusterException, ApplianceException {
		if (clusterName.equals(SimpleMeteringServer.class.getName())) {
			if (attributeName.equals(SimpleMeteringServer.ATTR_IstantaneousDemand_NAME)) {
				ZigBeePowerSensorImpl zbps = ((ZigBeePowerSensorImpl)services.get("PowerSensor"));
				Integer instPower = (Integer) attributeValue.getValue();
				zbps.notifyCurrentPower(instPower);
				// for each incoming power value from the ZigBee network, a new NGSIClient is instanced 
				// to enable an updateContext operation towards the DataHandling GE.
				ZigBeeSwitchPowerImpl zbsp = ((ZigBeeSwitchPowerImpl)services.get("SwitchPower"));
				new NgsiUpdateTask(this,instPower, zbsp).run();
				// ngsiClient = new NGSIClientOperation(this, instPower, zbsp.getCurrentStatus(),UPDATECTXT);
				System.out.println("\nReceived inst power " + attributeValue.getValue() + " from appliance " + appliance.getPid());
			}
		}
		
	}

	@Override
	public void notifyReadResponse(String clusterName, String attributeName, IAttributeValue attributeValue,
			IEndPointRequestContext endPointRequestContext) throws ServiceClusterException, ApplianceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyWriteResponse(String clusterName, String attributeName, IAttributeValue attributeValue,
			IEndPointRequestContext endPointRequestContext) throws ServiceClusterException, ApplianceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyCommandResponse(String clusterName, String commandName, Object response,
			IEndPointRequestContext endPointRequestContext) throws ApplianceException {
		// TODO Auto-generated method stub
		
	}

}
