/**
 * This file is part of JEMMA - http://jemma.energy-home.org
 * (C) Copyright 2013 Telecom Italia (http://www.telecomitalia.it)
 *
 * JEMMA is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License (LGPL) version 3
 * or later as published by the Free Software Foundation, which accompanies
 * this distribution and is available at http://www.gnu.org/licenses/lgpl.html
 *
 * JEMMA is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License (LGPL) for more details.
 *
 */
package org.energy_home.jemma.ah.m2m.device;

import org.energy_home.jemma.m2m.connection.ConnectionParameters;

public interface M2MDeviceConfigurator {
	public boolean isStarted();

	public boolean isConnected();

	public M2MDeviceConfig getConfiguration();

	public void setConfiguration(M2MDeviceConfig config) throws M2MServiceException;

	public ConnectionParameters getCurrentConnectionParameters();
}
