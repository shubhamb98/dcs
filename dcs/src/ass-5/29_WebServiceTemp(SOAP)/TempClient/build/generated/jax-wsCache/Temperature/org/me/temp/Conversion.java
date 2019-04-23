
package org.me.temp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Conversion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Conversion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Farenheight" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Conversion", propOrder = {
    "farenheight"
})
public class Conversion {

    @XmlElement(name = "Farenheight")
    protected float farenheight;

    /**
     * Gets the value of the farenheight property.
     * 
     */
    public float getFarenheight() {
        return farenheight;
    }

    /**
     * Sets the value of the farenheight property.
     * 
     */
    public void setFarenheight(float value) {
        this.farenheight = value;
    }

}
