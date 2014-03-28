package org.fiware.jemma.zigbee.pa;

/** Copyright (C) 2012 Telecom Italia S.p.A. **/

import org.energy_home.jemma.ah.hac.lib.AttributeValue;
import org.energy_home.jemma.ah.zigbee.IZclFrame;
import org.energy_home.jemma.ah.zigbee.ZigBeeDevice;
import org.energy_home.jemma.ah.zigbee.ZigBeeDeviceListener;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.framework.BundleContext;

import com.ericsson.deviceaccess.api.GenericDevice;

public class ZigBeeDeviceFactory implements ZigBeeDeviceListener {
	private static Timer timerDevice = new Timer("Device Factory Timer");
	private static Timer timerNgsi = new Timer("Ngsi Factory Timer");
	private Object sLock = new Object();

	private HashMap<String, ZigBeeGenericDeviceImpl> devices = new HashMap<String, ZigBeeGenericDeviceImpl>();
	private BundleContext bc;
	private NGSIClientOperation ngsiClient;
	private static int REGISTERCTXT = 0;
	private static int RESETDB = 2;
	private static int RESTARTCEP = 3;
	
	String urlEsper4FastData, urlEventSink;

	private final static Log log = LogFactory.getLog(ZigBeeDeviceFactory.class);
	
	private class ZigBeeFactoryTask extends TimerTask {
		
		private ZigBeeGenericDeviceImpl genericDevice;

		public ZigBeeFactoryTask(ZigBeeGenericDeviceImpl genericDevice) {
			this.genericDevice = genericDevice;
		}

		@Override
		public void run() {
			genericDevice.init();
			bc.registerService(GenericDevice.class.getName(), genericDevice,
					null);
			System.out
					.println("$$$ ZigBeeDeviceFactory: service zbGenericDevice registered ");
			
		}
	} // end of ZigBeeFactoryTask
	
	private class NgsiFactoryTask extends Thread {

		private ZigBeeGenericDeviceImpl genericDevice;

		public NgsiFactoryTask (ZigBeeGenericDeviceImpl genericDevice) {
			this.genericDevice = genericDevice;
		}

		@Override
		public void run() {

			// for each ZigBee device discovered, a new NGSIClient is instanced 
			// to enable a registerContext operation towards the DataHandling GE.
			ngsiClient = new NGSIClientOperation(genericDevice, REGISTERCTXT);
			System.out.println("$$$ NgsiFactoryTask: REGISTER sent ");

		}
	} // end of NgsiFactoryTask
	
	public ZigBeeDeviceFactory ()
	{
		System.out.println("#### ZigBeeDeviceFactory constructor");
		
		urlEsper4FastData = System.getProperty(NGSIClientOperation.URLNGSIESPER4FASTDATA);
		urlEventSink = System.getProperty(NGSIClientOperation.URLNGSIEVENTSINK);
		
		if (urlEsper4FastData != null || urlEventSink != null)
		{
			System.out.println("#### ZigBeeDeviceFactory.constructor: RESETDB and RESTARTCEP");
			// when a ZigBeeDeviceFactory is created, a new NGSIClient is instanced 
			// to enable a resetDB operation towards the DB embedded into the DataHandling GE.
			ngsiClient = new NGSIClientOperation(RESETDB);
			System.out.println("#### ZigBeeDeviceFactory constructor: a resetDB is sent");
			ngsiClient = new NGSIClientOperation(RESTARTCEP);
			System.out.println("#### ZigBeeDeviceFactory constructor: a CEP instance is created");
		}
		
	}
	
	

	protected void setZigBeeDevice(ZigBeeDevice dev) {
		
		synchronized (sLock) {
			System.out
					.println("$$$ ZigBeeDeviceFactory: setZigBeeDevice enter IEEE "+dev.getIeeeAddress());
			if(!devices.containsKey(dev.getIeeeAddress())) {
				
				ZigBeeGenericDeviceImpl genericDevice = new ZigBeeGenericDeviceImpl(dev);
				genericDevice.setURN(dev.getIeeeAddress());
				genericDevice.setId(dev.getIeeeAddress());
				genericDevice.setName("FlegPlug"+dev.getIeeeAddress());
				genericDevice.setManufacturer("FlexGrid s.r.l");
				genericDevice.setModelName("FlexPlug");
				genericDevice.setProtocol("ZigBee");

				this.devices.put(dev.getIeeeAddress(), genericDevice);
				
				timerDevice.schedule(new ZigBeeFactoryTask(genericDevice), 1000);
				new NgsiFactoryTask(genericDevice).run();
				

			} else 
				System.out.println("$$$ device is already present");
			 
		}
	}

	protected void unsetZigBeeDevice(ZigBeeDevice dev) {
		System.out.println("$$$ unsetZigBeeDevice enter");
		synchronized (sLock) {
			String address = dev.getIeeeAddress();
			//ZigBeeGenericDeviceImpl genericDevice = devices.get(address);
			ZigBeeGenericDeviceImpl genericDevice = this.devices.remove(address);
			if (genericDevice != null)
				genericDevice.release();
		}
	}

	protected void activate(BundleContext bc, Map props) {
		this.bc = bc;
		System.out.println("$$$ activate enter");
	}
	
	protected void deactivate(BundleContext bc) {
		this.bc = null;
		System.out.println("$$$ deactivate enter");
		Iterator it = (Iterator) devices.values().iterator();
		while (it.hasNext()) {
			ZigBeeGenericDeviceImpl genericDevice = (ZigBeeGenericDeviceImpl) it.next();
			if (genericDevice != null) {
				genericDevice.release();
			}
		}
	}
	
	@Override
	public boolean notifyZclFrame(short clusterId, IZclFrame zclFrame)
			throws Exception {
		System.out.println("$$$ notifyZclFrame enter");
		return false;
	}

	protected void notifyAttributeValue(String name, AttributeValue attrValue) {
		// TODO Auto-generated method stub
		System.out.println("notifyAttributeValue: received attribute");
	}

	@Override
	public void notifyEvent(int event) {
		System.out.println("notifyEvent enter");
		
	}

	
}