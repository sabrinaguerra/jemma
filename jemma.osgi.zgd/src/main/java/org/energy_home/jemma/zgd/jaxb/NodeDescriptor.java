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

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NodeDescriptor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NodeDescriptor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LogicalType" type="{http://www.zigbee.org/GWGSchema}LogicalType" minOccurs="0"/>
 *         &lt;element name="ComplexDescriptorAvailable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="UserDescriptorAvailable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="FrequencyBand" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="868MHz"/>
 *               &lt;enumeration value="900MHz"/>
 *               &lt;enumeration value="2400MHz"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MACCapabilityFlag" type="{http://www.zigbee.org/GWGSchema}MACCapability" minOccurs="0"/>
 *         &lt;element name="ManufacturerCode" type="{http://www.zigbee.org/GWGSchema}unsigned16Bit" minOccurs="0"/>
 *         &lt;element name="MaximumBufferSize" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="127"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MaximumIncomingTransferSize" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="32767"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ServerMask" type="{http://www.zigbee.org/GWGSchema}ServerMask" minOccurs="0"/>
 *         &lt;element name="MaximumOutgoingTransferSize" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="32767"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DescriptorCapabilityField" type="{http://www.zigbee.org/GWGSchema}DescriptorCapability" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NodeDescriptor", propOrder = {
    "logicalType",
    "complexDescriptorAvailable",
    "userDescriptorAvailable",
    "frequencyBand",
    "macCapabilityFlag",
    "manufacturerCode",
    "maximumBufferSize",
    "maximumIncomingTransferSize",
    "serverMask",
    "maximumOutgoingTransferSize",
    "descriptorCapabilityField"
})
public class NodeDescriptor implements Serializable {

	@XmlElement(name = "LogicalType")
    protected LogicalType logicalType;
    @XmlElement(name = "ComplexDescriptorAvailable")
    protected Boolean complexDescriptorAvailable;
    @XmlElement(name = "UserDescriptorAvailable")
    protected Boolean userDescriptorAvailable;
    @XmlElement(name = "FrequencyBand")
    protected String frequencyBand;
    @XmlElement(name = "MACCapabilityFlag")
    protected MACCapability macCapabilityFlag;
    @XmlElement(name = "ManufacturerCode")
    protected Integer manufacturerCode;
    @XmlElement(name = "MaximumBufferSize")
    protected Short maximumBufferSize;
    @XmlElement(name = "MaximumIncomingTransferSize")
    protected Integer maximumIncomingTransferSize;
    @XmlElement(name = "ServerMask")
    protected ServerMask serverMask;
    @XmlElement(name = "MaximumOutgoingTransferSize")
    protected Integer maximumOutgoingTransferSize;
    @XmlElement(name = "DescriptorCapabilityField")
    protected DescriptorCapability descriptorCapabilityField;

    /**
     * Gets the value of the logicalType property.
     * 
     * @return
     *     possible object is
     *     {@link LogicalType }
     *     
     */
    public LogicalType getLogicalType() {
        return logicalType;
    }

    /**
     * Sets the value of the logicalType property.
     * 
     * @param value
     *     allowed object is
     *     {@link LogicalType }
     *     
     */
    public void setLogicalType(LogicalType value) {
        this.logicalType = value;
    }

    /**
     * Gets the value of the complexDescriptorAvailable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isComplexDescriptorAvailable() {
        return complexDescriptorAvailable;
    }

    /**
     * Sets the value of the complexDescriptorAvailable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setComplexDescriptorAvailable(Boolean value) {
        this.complexDescriptorAvailable = value;
    }

    /**
     * Gets the value of the userDescriptorAvailable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUserDescriptorAvailable() {
        return userDescriptorAvailable;
    }

    /**
     * Sets the value of the userDescriptorAvailable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUserDescriptorAvailable(Boolean value) {
        this.userDescriptorAvailable = value;
    }

    /**
     * Gets the value of the frequencyBand property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrequencyBand() {
        return frequencyBand;
    }

    /**
     * Sets the value of the frequencyBand property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrequencyBand(String value) {
        this.frequencyBand = value;
    }

    /**
     * Gets the value of the macCapabilityFlag property.
     * 
     * @return
     *     possible object is
     *     {@link MACCapability }
     *     
     */
    public MACCapability getMACCapabilityFlag() {
        return macCapabilityFlag;
    }

    /**
     * Sets the value of the macCapabilityFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link MACCapability }
     *     
     */
    public void setMACCapabilityFlag(MACCapability value) {
        this.macCapabilityFlag = value;
    }

    /**
     * Gets the value of the manufacturerCode property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getManufacturerCode() {
        return manufacturerCode;
    }

    /**
     * Sets the value of the manufacturerCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setManufacturerCode(Integer value) {
        this.manufacturerCode = value;
    }

    /**
     * Gets the value of the maximumBufferSize property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getMaximumBufferSize() {
        return maximumBufferSize;
    }

    /**
     * Sets the value of the maximumBufferSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setMaximumBufferSize(Short value) {
        this.maximumBufferSize = value;
    }

    /**
     * Gets the value of the maximumIncomingTransferSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaximumIncomingTransferSize() {
        return maximumIncomingTransferSize;
    }

    /**
     * Sets the value of the maximumIncomingTransferSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaximumIncomingTransferSize(Integer value) {
        this.maximumIncomingTransferSize = value;
    }

    /**
     * Gets the value of the serverMask property.
     * 
     * @return
     *     possible object is
     *     {@link ServerMask }
     *     
     */
    public ServerMask getServerMask() {
        return serverMask;
    }

    /**
     * Sets the value of the serverMask property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServerMask }
     *     
     */
    public void setServerMask(ServerMask value) {
        this.serverMask = value;
    }

    /**
     * Gets the value of the maximumOutgoingTransferSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaximumOutgoingTransferSize() {
        return maximumOutgoingTransferSize;
    }

    /**
     * Sets the value of the maximumOutgoingTransferSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaximumOutgoingTransferSize(Integer value) {
        this.maximumOutgoingTransferSize = value;
    }

    /**
     * Gets the value of the descriptorCapabilityField property.
     * 
     * @return
     *     possible object is
     *     {@link DescriptorCapability }
     *     
     */
    public DescriptorCapability getDescriptorCapabilityField() {
        return descriptorCapabilityField;
    }

    /**
     * Sets the value of the descriptorCapabilityField property.
     * 
     * @param value
     *     allowed object is
     *     {@link DescriptorCapability }
     *     
     */
    public void setDescriptorCapabilityField(DescriptorCapability value) {
        this.descriptorCapabilityField = value;
    }

}
