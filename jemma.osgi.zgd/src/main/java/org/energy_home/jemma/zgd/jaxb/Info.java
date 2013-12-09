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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 *     		This type is the XML root type of procedure responses, event
 *     		requests and event responses. It contains pertinent general
 *     		parameters and results, some recurrent result types and the
 *     		"Detail" choice, which contains the actual information being
 *     		conveyed.
 *     	
 * 
 * <p>Java class for Info complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Info">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Status" type="{http://www.zigbee.org/GWGRESTSchema}Status"/>
 *         &lt;element name="RequestIdentifier" type="{http://www.zigbee.org/GWGSchema}RequestIdentifier" minOccurs="0"/>
 *         &lt;element name="EventCallbackIdentifier" type="{http://www.zigbee.org/GWGSchema}CallbackIdentifier" minOccurs="0"/>
 *         &lt;element name="NWKStatus" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="Detail" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Version" type="{http://www.zigbee.org/GWGSchema}Version" minOccurs="0"/>
 *                   &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="PolledMessage" type="{http://www.zigbee.org/GWGSchema}PolledMessage" minOccurs="0"/>
 *                   &lt;element name="CallbackIdentifier" type="{http://www.zigbee.org/GWGSchema}CallbackIdentifier" minOccurs="0"/>
 *                   &lt;element name="Callbacks" type="{http://www.zigbee.org/GWGSchema}CallbackIdentifierList" minOccurs="0"/>
 *                   &lt;element name="Aliases" type="{http://www.zigbee.org/GWGSchema}Aliases" minOccurs="0"/>
 *                   &lt;element name="WSNNode" type="{http://www.zigbee.org/GWGSchema}WSNNode" minOccurs="0"/>
 *                   &lt;element name="WSNNodes" type="{http://www.zigbee.org/GWGSchema}WSNNodeList" minOccurs="0"/>
 *                   &lt;element name="NodeServices" type="{http://www.zigbee.org/GWGSchema}NodeServices" minOccurs="0"/>
 *                   &lt;element name="ServiceDescriptor" type="{http://www.zigbee.org/GWGSchema}ServiceDescriptor" minOccurs="0"/>
 *                   &lt;element name="NodeServicesList" type="{http://www.zigbee.org/GWGSchema}NodeServicesList" minOccurs="0"/>
 *                   &lt;element name="StartupAttributeInfo" type="{http://www.zigbee.org/GWGSchema}StartupAttributeInfo" minOccurs="0"/>
 *                   &lt;element name="ZDPMessage" type="{http://www.zigbee.org/GWGSchema}ZDPMessage" minOccurs="0"/>
 *                   &lt;element name="ZCLCommandResult" type="{http://www.zigbee.org/GWGSchema}ZCLCommandResult" minOccurs="0"/>
 *                   &lt;element name="ZCLMessage" type="{http://www.zigbee.org/GWGSchema}ZCLMessage" minOccurs="0"/>
 *                   &lt;element name="Endpoint" type="{http://www.zigbee.org/GWGSchema}Endpoint" minOccurs="0"/>
 *                   &lt;element name="Groups" type="{http://www.zigbee.org/GWGSchema}GroupList" minOccurs="0"/>
 *                   &lt;element name="Bindings" type="{http://www.zigbee.org/GWGSchema}BindingList" minOccurs="0"/>
 *                   &lt;element name="APSMessageEvent" type="{http://www.zigbee.org/GWGSchema}APSMessageEvent" minOccurs="0"/>
 *                   &lt;element name="APSMessageResult" type="{http://www.zigbee.org/GWGSchema}APSMessageResult" minOccurs="0"/>
 *                   &lt;element name="NodeDescriptor" type="{http://www.zigbee.org/GWGSchema}NodeDescriptor" minOccurs="0"/>
 *                   &lt;element name="PowerDescriptor" type="{http://www.zigbee.org/GWGSchema}PowerDescriptor" minOccurs="0"/>
 *                   &lt;element name="UserDescriptor" type="{http://www.zigbee.org/GWGSchema}UserDescriptor" minOccurs="0"/>
 *                   &lt;element name="NetworkDescriptors" type="{http://www.zigbee.org/GWGSchema}NetworkDescriptorList" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="EnergyScanResult" type="{http://www.zigbee.org/GWGSchema}EnergyScanResult" minOccurs="0"/>
 *                   &lt;element name="NetworkStatusCode" type="{http://www.zigbee.org/GWGSchema}NetworkStatusCode" minOccurs="0"/>
 *                   &lt;element name="NWKMessageEvent" type="{http://www.zigbee.org/GWGSchema}NWKMessageEvent" minOccurs="0"/>
 *                   &lt;element name="NWKMessageResult" type="{http://www.zigbee.org/GWGSchema}NWKMessageResult" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Info", namespace = "http://www.zigbee.org/GWGRESTSchema", propOrder = {
    "status",
    "requestIdentifier",
    "eventCallbackIdentifier",
    "nwkStatus",
    "detail"
})
public class Info {

    @XmlElement(name = "Status", required = true)
    protected Status status;
    @XmlElement(name = "RequestIdentifier", type = String.class)
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    protected byte[] requestIdentifier;
    @XmlElement(name = "EventCallbackIdentifier")
    protected Long eventCallbackIdentifier;
    @XmlElement(name = "NWKStatus")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer nwkStatus;
    @XmlElement(name = "Detail")
    protected Info.Detail detail;

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Status }
     *     
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Status }
     *     
     */
    public void setStatus(Status value) {
        this.status = value;
    }

    /**
     * Gets the value of the requestIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public byte[] getRequestIdentifier() {
        return requestIdentifier;
    }

    /**
     * Sets the value of the requestIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestIdentifier(byte[] value) {
        this.requestIdentifier = ((byte[]) value);
    }

    /**
     * Gets the value of the eventCallbackIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getEventCallbackIdentifier() {
        return eventCallbackIdentifier;
    }

    /**
     * Sets the value of the eventCallbackIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setEventCallbackIdentifier(Long value) {
        this.eventCallbackIdentifier = value;
    }

    /**
     * Gets the value of the nwkStatus property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNWKStatus() {
        return nwkStatus;
    }

    /**
     * Sets the value of the nwkStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNWKStatus(Integer value) {
        this.nwkStatus = value;
    }

    /**
     * Gets the value of the detail property.
     * 
     * @return
     *     possible object is
     *     {@link Info.Detail }
     *     
     */
    public Info.Detail getDetail() {
        return detail;
    }

    /**
     * Sets the value of the detail property.
     * 
     * @param value
     *     allowed object is
     *     {@link Info.Detail }
     *     
     */
    public void setDetail(Info.Detail value) {
        this.detail = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Version" type="{http://www.zigbee.org/GWGSchema}Version" minOccurs="0"/>
     *         &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="PolledMessage" type="{http://www.zigbee.org/GWGSchema}PolledMessage" minOccurs="0"/>
     *         &lt;element name="CallbackIdentifier" type="{http://www.zigbee.org/GWGSchema}CallbackIdentifier" minOccurs="0"/>
     *         &lt;element name="Callbacks" type="{http://www.zigbee.org/GWGSchema}CallbackIdentifierList" minOccurs="0"/>
     *         &lt;element name="Aliases" type="{http://www.zigbee.org/GWGSchema}Aliases" minOccurs="0"/>
     *         &lt;element name="WSNNode" type="{http://www.zigbee.org/GWGSchema}WSNNode" minOccurs="0"/>
     *         &lt;element name="WSNNodes" type="{http://www.zigbee.org/GWGSchema}WSNNodeList" minOccurs="0"/>
     *         &lt;element name="NodeServices" type="{http://www.zigbee.org/GWGSchema}NodeServices" minOccurs="0"/>
     *         &lt;element name="ServiceDescriptor" type="{http://www.zigbee.org/GWGSchema}ServiceDescriptor" minOccurs="0"/>
     *         &lt;element name="NodeServicesList" type="{http://www.zigbee.org/GWGSchema}NodeServicesList" minOccurs="0"/>
     *         &lt;element name="StartupAttributeInfo" type="{http://www.zigbee.org/GWGSchema}StartupAttributeInfo" minOccurs="0"/>
     *         &lt;element name="ZDPMessage" type="{http://www.zigbee.org/GWGSchema}ZDPMessage" minOccurs="0"/>
     *         &lt;element name="ZCLCommandResult" type="{http://www.zigbee.org/GWGSchema}ZCLCommandResult" minOccurs="0"/>
     *         &lt;element name="ZCLMessage" type="{http://www.zigbee.org/GWGSchema}ZCLMessage" minOccurs="0"/>
     *         &lt;element name="Endpoint" type="{http://www.zigbee.org/GWGSchema}Endpoint" minOccurs="0"/>
     *         &lt;element name="Groups" type="{http://www.zigbee.org/GWGSchema}GroupList" minOccurs="0"/>
     *         &lt;element name="Bindings" type="{http://www.zigbee.org/GWGSchema}BindingList" minOccurs="0"/>
     *         &lt;element name="APSMessageEvent" type="{http://www.zigbee.org/GWGSchema}APSMessageEvent" minOccurs="0"/>
     *         &lt;element name="APSMessageResult" type="{http://www.zigbee.org/GWGSchema}APSMessageResult" minOccurs="0"/>
     *         &lt;element name="NodeDescriptor" type="{http://www.zigbee.org/GWGSchema}NodeDescriptor" minOccurs="0"/>
     *         &lt;element name="PowerDescriptor" type="{http://www.zigbee.org/GWGSchema}PowerDescriptor" minOccurs="0"/>
     *         &lt;element name="UserDescriptor" type="{http://www.zigbee.org/GWGSchema}UserDescriptor" minOccurs="0"/>
     *         &lt;element name="NetworkDescriptors" type="{http://www.zigbee.org/GWGSchema}NetworkDescriptorList" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="EnergyScanResult" type="{http://www.zigbee.org/GWGSchema}EnergyScanResult" minOccurs="0"/>
     *         &lt;element name="NetworkStatusCode" type="{http://www.zigbee.org/GWGSchema}NetworkStatusCode" minOccurs="0"/>
     *         &lt;element name="NWKMessageEvent" type="{http://www.zigbee.org/GWGSchema}NWKMessageEvent" minOccurs="0"/>
     *         &lt;element name="NWKMessageResult" type="{http://www.zigbee.org/GWGSchema}NWKMessageResult" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "version",
        "value",
        "polledMessage",
        "callbackIdentifier",
        "callbacks",
        "aliases",
        "wsnNode",
        "wsnNodes",
        "nodeServices",
        "serviceDescriptor",
        "nodeServicesList",
        "startupAttributeInfo",
        "zdpMessage",
        "zclCommandResult",
        "zclMessage",
        "endpoint",
        "groups",
        "bindings",
        "apsMessageEvent",
        "apsMessageResult",
        "nodeDescriptor",
        "powerDescriptor",
        "userDescriptor",
        "networkDescriptors",
        "energyScanResult",
        "networkStatusCode",
        "nwkMessageEvent",
        "nwkMessageResult"
    })
    public static class Detail {

        @XmlElement(name = "Version", namespace = "http://www.zigbee.org/GWGRESTSchema")
        protected Version version;
        @XmlElement(name = "Value", namespace = "http://www.zigbee.org/GWGRESTSchema")
        protected List<String> value;
        @XmlElement(name = "PolledMessage", namespace = "http://www.zigbee.org/GWGRESTSchema")
        protected PolledMessage polledMessage;
        @XmlElement(name = "CallbackIdentifier", namespace = "http://www.zigbee.org/GWGRESTSchema")
        protected Long callbackIdentifier;
        @XmlElement(name = "Callbacks", namespace = "http://www.zigbee.org/GWGRESTSchema")
        protected CallbackIdentifierList callbacks;
        @XmlElement(name = "Aliases", namespace = "http://www.zigbee.org/GWGRESTSchema")
        protected Aliases aliases;
        @XmlElement(name = "WSNNode", namespace = "http://www.zigbee.org/GWGRESTSchema")
        protected WSNNode wsnNode;
        @XmlElement(name = "WSNNodes", namespace = "http://www.zigbee.org/GWGRESTSchema")
        protected WSNNodeList wsnNodes;
        @XmlElement(name = "NodeServices", namespace = "http://www.zigbee.org/GWGRESTSchema")
        protected NodeServices nodeServices;
        @XmlElement(name = "ServiceDescriptor", namespace = "http://www.zigbee.org/GWGRESTSchema")
        protected ServiceDescriptor serviceDescriptor;
        @XmlElement(name = "NodeServicesList", namespace = "http://www.zigbee.org/GWGRESTSchema")
        protected NodeServicesList nodeServicesList;
        @XmlElement(name = "StartupAttributeInfo", namespace = "http://www.zigbee.org/GWGRESTSchema")
        protected StartupAttributeInfo startupAttributeInfo;
        @XmlElement(name = "ZDPMessage", namespace = "http://www.zigbee.org/GWGRESTSchema")
        protected ZDPMessage zdpMessage;
        @XmlElement(name = "ZCLCommandResult", namespace = "http://www.zigbee.org/GWGRESTSchema")
        protected ZCLCommandResult zclCommandResult;
        @XmlElement(name = "ZCLMessage", namespace = "http://www.zigbee.org/GWGRESTSchema")
        protected ZCLMessage zclMessage;
        @XmlElement(name = "Endpoint", namespace = "http://www.zigbee.org/GWGRESTSchema")
        protected Short endpoint;
        @XmlElement(name = "Groups", namespace = "http://www.zigbee.org/GWGRESTSchema")
        protected GroupList groups;
        @XmlElement(name = "Bindings", namespace = "http://www.zigbee.org/GWGRESTSchema")
        protected BindingList bindings;
        @XmlElement(name = "APSMessageEvent", namespace = "http://www.zigbee.org/GWGRESTSchema")
        protected APSMessageEvent apsMessageEvent;
        @XmlElement(name = "APSMessageResult", namespace = "http://www.zigbee.org/GWGRESTSchema")
        protected APSMessageResult apsMessageResult;
        @XmlElement(name = "NodeDescriptor", namespace = "http://www.zigbee.org/GWGRESTSchema")
        protected NodeDescriptor nodeDescriptor;
        @XmlElement(name = "PowerDescriptor", namespace = "http://www.zigbee.org/GWGRESTSchema")
        protected PowerDescriptor powerDescriptor;
        @XmlElement(name = "UserDescriptor", namespace = "http://www.zigbee.org/GWGRESTSchema")
        protected UserDescriptor userDescriptor;
        @XmlElement(name = "NetworkDescriptors", namespace = "http://www.zigbee.org/GWGRESTSchema")
        protected List<NetworkDescriptorList> networkDescriptors;
        @XmlElement(name = "EnergyScanResult", namespace = "http://www.zigbee.org/GWGRESTSchema")
        protected EnergyScanResult energyScanResult;
        @XmlElement(name = "NetworkStatusCode", namespace = "http://www.zigbee.org/GWGRESTSchema")
        protected NetworkStatusCode networkStatusCode;
        @XmlElement(name = "NWKMessageEvent", namespace = "http://www.zigbee.org/GWGRESTSchema")
        protected NWKMessageEvent nwkMessageEvent;
        @XmlElement(name = "NWKMessageResult", namespace = "http://www.zigbee.org/GWGRESTSchema")
        protected NWKMessageResult nwkMessageResult;

        /**
         * Gets the value of the version property.
         * 
         * @return
         *     possible object is
         *     {@link Version }
         *     
         */
        public Version getVersion() {
            return version;
        }

        /**
         * Sets the value of the version property.
         * 
         * @param value
         *     allowed object is
         *     {@link Version }
         *     
         */
        public void setVersion(Version value) {
            this.version = value;
        }

        /**
         * Gets the value of the value property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the value property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getValue().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getValue() {
            if (value == null) {
                value = new ArrayList<String>();
            }
            return this.value;
        }

        /**
         * Gets the value of the polledMessage property.
         * 
         * @return
         *     possible object is
         *     {@link PolledMessage }
         *     
         */
        public PolledMessage getPolledMessage() {
            return polledMessage;
        }

        /**
         * Sets the value of the polledMessage property.
         * 
         * @param value
         *     allowed object is
         *     {@link PolledMessage }
         *     
         */
        public void setPolledMessage(PolledMessage value) {
            this.polledMessage = value;
        }

        /**
         * Gets the value of the callbackIdentifier property.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getCallbackIdentifier() {
            return callbackIdentifier;
        }

        /**
         * Sets the value of the callbackIdentifier property.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setCallbackIdentifier(Long value) {
            this.callbackIdentifier = value;
        }

        /**
         * Gets the value of the callbacks property.
         * 
         * @return
         *     possible object is
         *     {@link CallbackIdentifierList }
         *     
         */
        public CallbackIdentifierList getCallbacks() {
            return callbacks;
        }

        /**
         * Sets the value of the callbacks property.
         * 
         * @param value
         *     allowed object is
         *     {@link CallbackIdentifierList }
         *     
         */
        public void setCallbacks(CallbackIdentifierList value) {
            this.callbacks = value;
        }

        /**
         * Gets the value of the aliases property.
         * 
         * @return
         *     possible object is
         *     {@link Aliases }
         *     
         */
        public Aliases getAliases() {
            return aliases;
        }

        /**
         * Sets the value of the aliases property.
         * 
         * @param value
         *     allowed object is
         *     {@link Aliases }
         *     
         */
        public void setAliases(Aliases value) {
            this.aliases = value;
        }

        /**
         * Gets the value of the wsnNode property.
         * 
         * @return
         *     possible object is
         *     {@link WSNNode }
         *     
         */
        public WSNNode getWSNNode() {
            return wsnNode;
        }

        /**
         * Sets the value of the wsnNode property.
         * 
         * @param value
         *     allowed object is
         *     {@link WSNNode }
         *     
         */
        public void setWSNNode(WSNNode value) {
            this.wsnNode = value;
        }

        /**
         * Gets the value of the wsnNodes property.
         * 
         * @return
         *     possible object is
         *     {@link WSNNodeList }
         *     
         */
        public WSNNodeList getWSNNodes() {
            return wsnNodes;
        }

        /**
         * Sets the value of the wsnNodes property.
         * 
         * @param value
         *     allowed object is
         *     {@link WSNNodeList }
         *     
         */
        public void setWSNNodes(WSNNodeList value) {
            this.wsnNodes = value;
        }

        /**
         * Gets the value of the nodeServices property.
         * 
         * @return
         *     possible object is
         *     {@link NodeServices }
         *     
         */
        public NodeServices getNodeServices() {
            return nodeServices;
        }

        /**
         * Sets the value of the nodeServices property.
         * 
         * @param value
         *     allowed object is
         *     {@link NodeServices }
         *     
         */
        public void setNodeServices(NodeServices value) {
            this.nodeServices = value;
        }

        /**
         * Gets the value of the serviceDescriptor property.
         * 
         * @return
         *     possible object is
         *     {@link ServiceDescriptor }
         *     
         */
        public ServiceDescriptor getServiceDescriptor() {
            return serviceDescriptor;
        }

        /**
         * Sets the value of the serviceDescriptor property.
         * 
         * @param value
         *     allowed object is
         *     {@link ServiceDescriptor }
         *     
         */
        public void setServiceDescriptor(ServiceDescriptor value) {
            this.serviceDescriptor = value;
        }

        /**
         * Gets the value of the nodeServicesList property.
         * 
         * @return
         *     possible object is
         *     {@link NodeServicesList }
         *     
         */
        public NodeServicesList getNodeServicesList() {
            return nodeServicesList;
        }

        /**
         * Sets the value of the nodeServicesList property.
         * 
         * @param value
         *     allowed object is
         *     {@link NodeServicesList }
         *     
         */
        public void setNodeServicesList(NodeServicesList value) {
            this.nodeServicesList = value;
        }

        /**
         * Gets the value of the startupAttributeInfo property.
         * 
         * @return
         *     possible object is
         *     {@link StartupAttributeInfo }
         *     
         */
        public StartupAttributeInfo getStartupAttributeInfo() {
            return startupAttributeInfo;
        }

        /**
         * Sets the value of the startupAttributeInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link StartupAttributeInfo }
         *     
         */
        public void setStartupAttributeInfo(StartupAttributeInfo value) {
            this.startupAttributeInfo = value;
        }

        /**
         * Gets the value of the zdpMessage property.
         * 
         * @return
         *     possible object is
         *     {@link ZDPMessage }
         *     
         */
        public ZDPMessage getZDPMessage() {
            return zdpMessage;
        }

        /**
         * Sets the value of the zdpMessage property.
         * 
         * @param value
         *     allowed object is
         *     {@link ZDPMessage }
         *     
         */
        public void setZDPMessage(ZDPMessage value) {
            this.zdpMessage = value;
        }

        /**
         * Gets the value of the zclCommandResult property.
         * 
         * @return
         *     possible object is
         *     {@link ZCLCommandResult }
         *     
         */
        public ZCLCommandResult getZCLCommandResult() {
            return zclCommandResult;
        }

        /**
         * Sets the value of the zclCommandResult property.
         * 
         * @param value
         *     allowed object is
         *     {@link ZCLCommandResult }
         *     
         */
        public void setZCLCommandResult(ZCLCommandResult value) {
            this.zclCommandResult = value;
        }

        /**
         * Gets the value of the zclMessage property.
         * 
         * @return
         *     possible object is
         *     {@link ZCLMessage }
         *     
         */
        public ZCLMessage getZCLMessage() {
            return zclMessage;
        }

        /**
         * Sets the value of the zclMessage property.
         * 
         * @param value
         *     allowed object is
         *     {@link ZCLMessage }
         *     
         */
        public void setZCLMessage(ZCLMessage value) {
            this.zclMessage = value;
        }

        /**
         * Gets the value of the endpoint property.
         * 
         * @return
         *     possible object is
         *     {@link Short }
         *     
         */
        public Short getEndpoint() {
            return endpoint;
        }

        /**
         * Sets the value of the endpoint property.
         * 
         * @param value
         *     allowed object is
         *     {@link Short }
         *     
         */
        public void setEndpoint(Short value) {
            this.endpoint = value;
        }

        /**
         * Gets the value of the groups property.
         * 
         * @return
         *     possible object is
         *     {@link GroupList }
         *     
         */
        public GroupList getGroups() {
            return groups;
        }

        /**
         * Sets the value of the groups property.
         * 
         * @param value
         *     allowed object is
         *     {@link GroupList }
         *     
         */
        public void setGroups(GroupList value) {
            this.groups = value;
        }

        /**
         * Gets the value of the bindings property.
         * 
         * @return
         *     possible object is
         *     {@link BindingList }
         *     
         */
        public BindingList getBindings() {
            return bindings;
        }

        /**
         * Sets the value of the bindings property.
         * 
         * @param value
         *     allowed object is
         *     {@link BindingList }
         *     
         */
        public void setBindings(BindingList value) {
            this.bindings = value;
        }

        /**
         * Gets the value of the apsMessageEvent property.
         * 
         * @return
         *     possible object is
         *     {@link APSMessageEvent }
         *     
         */
        public APSMessageEvent getAPSMessageEvent() {
            return apsMessageEvent;
        }

        /**
         * Sets the value of the apsMessageEvent property.
         * 
         * @param value
         *     allowed object is
         *     {@link APSMessageEvent }
         *     
         */
        public void setAPSMessageEvent(APSMessageEvent value) {
            this.apsMessageEvent = value;
        }

        /**
         * Gets the value of the apsMessageResult property.
         * 
         * @return
         *     possible object is
         *     {@link APSMessageResult }
         *     
         */
        public APSMessageResult getAPSMessageResult() {
            return apsMessageResult;
        }

        /**
         * Sets the value of the apsMessageResult property.
         * 
         * @param value
         *     allowed object is
         *     {@link APSMessageResult }
         *     
         */
        public void setAPSMessageResult(APSMessageResult value) {
            this.apsMessageResult = value;
        }

        /**
         * Gets the value of the nodeDescriptor property.
         * 
         * @return
         *     possible object is
         *     {@link NodeDescriptor }
         *     
         */
        public NodeDescriptor getNodeDescriptor() {
            return nodeDescriptor;
        }

        /**
         * Sets the value of the nodeDescriptor property.
         * 
         * @param value
         *     allowed object is
         *     {@link NodeDescriptor }
         *     
         */
        public void setNodeDescriptor(NodeDescriptor value) {
            this.nodeDescriptor = value;
        }

        /**
         * Gets the value of the powerDescriptor property.
         * 
         * @return
         *     possible object is
         *     {@link PowerDescriptor }
         *     
         */
        public PowerDescriptor getPowerDescriptor() {
            return powerDescriptor;
        }

        /**
         * Sets the value of the powerDescriptor property.
         * 
         * @param value
         *     allowed object is
         *     {@link PowerDescriptor }
         *     
         */
        public void setPowerDescriptor(PowerDescriptor value) {
            this.powerDescriptor = value;
        }

        /**
         * Gets the value of the userDescriptor property.
         * 
         * @return
         *     possible object is
         *     {@link UserDescriptor }
         *     
         */
        public UserDescriptor getUserDescriptor() {
            return userDescriptor;
        }

        /**
         * Sets the value of the userDescriptor property.
         * 
         * @param value
         *     allowed object is
         *     {@link UserDescriptor }
         *     
         */
        public void setUserDescriptor(UserDescriptor value) {
            this.userDescriptor = value;
        }

        /**
         * Gets the value of the networkDescriptors property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the networkDescriptors property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getNetworkDescriptors().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link NetworkDescriptorList }
         * 
         * 
         */
        public List<NetworkDescriptorList> getNetworkDescriptors() {
            if (networkDescriptors == null) {
                networkDescriptors = new ArrayList<NetworkDescriptorList>();
            }
            return this.networkDescriptors;
        }

        /**
         * Gets the value of the energyScanResult property.
         * 
         * @return
         *     possible object is
         *     {@link EnergyScanResult }
         *     
         */
        public EnergyScanResult getEnergyScanResult() {
            return energyScanResult;
        }

        /**
         * Sets the value of the energyScanResult property.
         * 
         * @param value
         *     allowed object is
         *     {@link EnergyScanResult }
         *     
         */
        public void setEnergyScanResult(EnergyScanResult value) {
            this.energyScanResult = value;
        }

        /**
         * Gets the value of the networkStatusCode property.
         * 
         * @return
         *     possible object is
         *     {@link NetworkStatusCode }
         *     
         */
        public NetworkStatusCode getNetworkStatusCode() {
            return networkStatusCode;
        }

        /**
         * Sets the value of the networkStatusCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link NetworkStatusCode }
         *     
         */
        public void setNetworkStatusCode(NetworkStatusCode value) {
            this.networkStatusCode = value;
        }

        /**
         * Gets the value of the nwkMessageEvent property.
         * 
         * @return
         *     possible object is
         *     {@link NWKMessageEvent }
         *     
         */
        public NWKMessageEvent getNWKMessageEvent() {
            return nwkMessageEvent;
        }

        /**
         * Sets the value of the nwkMessageEvent property.
         * 
         * @param value
         *     allowed object is
         *     {@link NWKMessageEvent }
         *     
         */
        public void setNWKMessageEvent(NWKMessageEvent value) {
            this.nwkMessageEvent = value;
        }

        /**
         * Gets the value of the nwkMessageResult property.
         * 
         * @return
         *     possible object is
         *     {@link NWKMessageResult }
         *     
         */
        public NWKMessageResult getNWKMessageResult() {
            return nwkMessageResult;
        }

        /**
         * Sets the value of the nwkMessageResult property.
         * 
         * @param value
         *     allowed object is
         *     {@link NWKMessageResult }
         *     
         */
        public void setNWKMessageResult(NWKMessageResult value) {
            this.nwkMessageResult = value;
        }

    }

}
