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
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.08.27 at 12:45:05 PM CEST 
//


package org.energy_home.jemma.zgd.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ZCLCommandResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZCLCommandResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SourceEndpoint" type="{http://www.zigbee.org/GWGSchema}Endpoint"/>
 *         &lt;element name="CommandID" type="{http://www.zigbee.org/GWGSchema}CommandIdentifier"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZCLCommandResult", propOrder = {
    "sourceEndpoint",
    "commandID"
})
public class ZCLCommandResult {

    @XmlElement(name = "SourceEndpoint")
    protected short sourceEndpoint;
    @XmlElement(name = "CommandID")
    protected int commandID;

    /**
     * Gets the value of the sourceEndpoint property.
     * 
     */
    public short getSourceEndpoint() {
        return sourceEndpoint;
    }

    /**
     * Sets the value of the sourceEndpoint property.
     * 
     */
    public void setSourceEndpoint(short value) {
        this.sourceEndpoint = value;
    }

    /**
     * Gets the value of the commandID property.
     * 
     */
    public int getCommandID() {
        return commandID;
    }

    /**
     * Sets the value of the commandID property.
     * 
     */
    public void setCommandID(int value) {
        this.commandID = value;
    }

}
