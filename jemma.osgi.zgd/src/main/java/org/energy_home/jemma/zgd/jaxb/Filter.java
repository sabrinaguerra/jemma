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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Filter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Filter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LevelSpecification">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Level" type="{http://www.zigbee.org/GWGSchema}Level" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="AddressSpecification" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="NWKSourceAddress" type="{http://www.zigbee.org/GWGSchema}Address" minOccurs="0"/>
 *                   &lt;element name="APSSourceEndpoint" type="{http://www.zigbee.org/GWGSchema}Endpoint" minOccurs="0"/>
 *                   &lt;element name="APSDestinationEndpoint" type="{http://www.zigbee.org/GWGSchema}Endpoint" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="MessageSpecification" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="APSClusterIdentifier" type="{http://www.zigbee.org/GWGSchema}ClusterIdentifier" minOccurs="0"/>
 *                   &lt;element name="APSClusterGroup" type="{http://www.zigbee.org/GWGSchema}ClusterGroup" minOccurs="0"/>
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
@XmlType(name = "Filter", propOrder = {
    "levelSpecification",
    "addressSpecification",
    "messageSpecification"
})
public class Filter {

    @XmlElement(name = "LevelSpecification", required = true)
    protected Filter.LevelSpecification levelSpecification;
    @XmlElement(name = "AddressSpecification")
    protected List<Filter.AddressSpecification> addressSpecification;
    @XmlElement(name = "MessageSpecification")
    protected List<Filter.MessageSpecification> messageSpecification;

    /**
     * Gets the value of the levelSpecification property.
     * 
     * @return
     *     possible object is
     *     {@link Filter.LevelSpecification }
     *     
     */
    public Filter.LevelSpecification getLevelSpecification() {
        return levelSpecification;
    }

    /**
     * Sets the value of the levelSpecification property.
     * 
     * @param value
     *     allowed object is
     *     {@link Filter.LevelSpecification }
     *     
     */
    public void setLevelSpecification(Filter.LevelSpecification value) {
        this.levelSpecification = value;
    }

    /**
     * Gets the value of the addressSpecification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addressSpecification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddressSpecification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Filter.AddressSpecification }
     * 
     * 
     */
    public List<Filter.AddressSpecification> getAddressSpecification() {
        if (addressSpecification == null) {
            addressSpecification = new ArrayList<Filter.AddressSpecification>();
        }
        return this.addressSpecification;
    }

    /**
     * Gets the value of the messageSpecification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the messageSpecification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessageSpecification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Filter.MessageSpecification }
     * 
     * 
     */
    public List<Filter.MessageSpecification> getMessageSpecification() {
        if (messageSpecification == null) {
            messageSpecification = new ArrayList<Filter.MessageSpecification>();
        }
        return this.messageSpecification;
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
     *         &lt;element name="NWKSourceAddress" type="{http://www.zigbee.org/GWGSchema}Address" minOccurs="0"/>
     *         &lt;element name="APSSourceEndpoint" type="{http://www.zigbee.org/GWGSchema}Endpoint" minOccurs="0"/>
     *         &lt;element name="APSDestinationEndpoint" type="{http://www.zigbee.org/GWGSchema}Endpoint" minOccurs="0"/>
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
        "nwkSourceAddress",
        "apsSourceEndpoint",
        "apsDestinationEndpoint"
    })
    public static class AddressSpecification {

        @XmlElement(name = "NWKSourceAddress")
        protected Address nwkSourceAddress;
        @XmlElement(name = "APSSourceEndpoint")
        protected Short apsSourceEndpoint;
        @XmlElement(name = "APSDestinationEndpoint")
        protected Short apsDestinationEndpoint;

        /**
         * Gets the value of the nwkSourceAddress property.
         * 
         * @return
         *     possible object is
         *     {@link Address }
         *     
         */
        public Address getNWKSourceAddress() {
            return nwkSourceAddress;
        }

        /**
         * Sets the value of the nwkSourceAddress property.
         * 
         * @param value
         *     allowed object is
         *     {@link Address }
         *     
         */
        public void setNWKSourceAddress(Address value) {
            this.nwkSourceAddress = value;
        }

        /**
         * Gets the value of the apsSourceEndpoint property.
         * 
         * @return
         *     possible object is
         *     {@link Short }
         *     
         */
        public Short getAPSSourceEndpoint() {
            return apsSourceEndpoint;
        }

        /**
         * Sets the value of the apsSourceEndpoint property.
         * 
         * @param value
         *     allowed object is
         *     {@link Short }
         *     
         */
        public void setAPSSourceEndpoint(Short value) {
            this.apsSourceEndpoint = value;
        }

        /**
         * Gets the value of the apsDestinationEndpoint property.
         * 
         * @return
         *     possible object is
         *     {@link Short }
         *     
         */
        public Short getAPSDestinationEndpoint() {
            return apsDestinationEndpoint;
        }

        /**
         * Sets the value of the apsDestinationEndpoint property.
         * 
         * @param value
         *     allowed object is
         *     {@link Short }
         *     
         */
        public void setAPSDestinationEndpoint(Short value) {
            this.apsDestinationEndpoint = value;
        }

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
     *         &lt;element name="Level" type="{http://www.zigbee.org/GWGSchema}Level" maxOccurs="unbounded"/>
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
        "level"
    })
    public static class LevelSpecification {

        @XmlElement(name = "Level", required = true)
        protected List<Level> level;

        /**
         * Gets the value of the level property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the level property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLevel().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Level }
         * 
         * 
         */
        public List<Level> getLevel() {
            if (level == null) {
                level = new ArrayList<Level>();
            }
            return this.level;
        }

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
     *         &lt;element name="APSClusterIdentifier" type="{http://www.zigbee.org/GWGSchema}ClusterIdentifier" minOccurs="0"/>
     *         &lt;element name="APSClusterGroup" type="{http://www.zigbee.org/GWGSchema}ClusterGroup" minOccurs="0"/>
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
        "apsClusterIdentifier",
        "apsClusterGroup"
    })
    public static class MessageSpecification {

        @XmlElement(name = "APSClusterIdentifier")
        protected Integer apsClusterIdentifier;
        @XmlElement(name = "APSClusterGroup")
        protected String apsClusterGroup;

        /**
         * Gets the value of the apsClusterIdentifier property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getAPSClusterIdentifier() {
            return apsClusterIdentifier;
        }

        /**
         * Sets the value of the apsClusterIdentifier property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setAPSClusterIdentifier(Integer value) {
            this.apsClusterIdentifier = value;
        }

        /**
         * Gets the value of the apsClusterGroup property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAPSClusterGroup() {
            return apsClusterGroup;
        }

        /**
         * Sets the value of the apsClusterGroup property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAPSClusterGroup(String value) {
            this.apsClusterGroup = value;
        }

    }

}
