/**
 * Car.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.uge.webServices.project;

public class Car  implements java.io.Serializable {
    private boolean availability;

    private java.lang.Long id;

    private java.lang.String model;

    private java.lang.Long nextTenantId;

    private java.lang.Long price;

    private float rating;

    private long[] tenants;

    public Car() {
    }

    public Car(
           boolean availability,
           java.lang.Long id,
           java.lang.String model,
           java.lang.Long nextTenantId,
           java.lang.Long price,
           float rating,
           long[] tenants) {
           this.availability = availability;
           this.id = id;
           this.model = model;
           this.nextTenantId = nextTenantId;
           this.price = price;
           this.rating = rating;
           this.tenants = tenants;
    }


    /**
     * Gets the availability value for this Car.
     * 
     * @return availability
     */
    public boolean isAvailability() {
        return availability;
    }


    /**
     * Sets the availability value for this Car.
     * 
     * @param availability
     */
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }


    /**
     * Gets the id value for this Car.
     * 
     * @return id
     */
    public java.lang.Long getId() {
        return id;
    }


    /**
     * Sets the id value for this Car.
     * 
     * @param id
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }


    /**
     * Gets the model value for this Car.
     * 
     * @return model
     */
    public java.lang.String getModel() {
        return model;
    }


    /**
     * Sets the model value for this Car.
     * 
     * @param model
     */
    public void setModel(java.lang.String model) {
        this.model = model;
    }


    /**
     * Gets the nextTenantId value for this Car.
     * 
     * @return nextTenantId
     */
    public java.lang.Long getNextTenantId() {
        return nextTenantId;
    }


    /**
     * Sets the nextTenantId value for this Car.
     * 
     * @param nextTenantId
     */
    public void setNextTenantId(java.lang.Long nextTenantId) {
        this.nextTenantId = nextTenantId;
    }


    /**
     * Gets the price value for this Car.
     * 
     * @return price
     */
    public java.lang.Long getPrice() {
        return price;
    }


    /**
     * Sets the price value for this Car.
     * 
     * @param price
     */
    public void setPrice(java.lang.Long price) {
        this.price = price;
    }


    /**
     * Gets the rating value for this Car.
     * 
     * @return rating
     */
    public float getRating() {
        return rating;
    }


    /**
     * Sets the rating value for this Car.
     * 
     * @param rating
     */
    public void setRating(float rating) {
        this.rating = rating;
    }


    /**
     * Gets the tenants value for this Car.
     * 
     * @return tenants
     */
    public long[] getTenants() {
        return tenants;
    }


    /**
     * Sets the tenants value for this Car.
     * 
     * @param tenants
     */
    public void setTenants(long[] tenants) {
        this.tenants = tenants;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Car)) return false;
        Car other = (Car) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.availability == other.isAvailability() &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.model==null && other.getModel()==null) || 
             (this.model!=null &&
              this.model.equals(other.getModel()))) &&
            ((this.nextTenantId==null && other.getNextTenantId()==null) || 
             (this.nextTenantId!=null &&
              this.nextTenantId.equals(other.getNextTenantId()))) &&
            ((this.price==null && other.getPrice()==null) || 
             (this.price!=null &&
              this.price.equals(other.getPrice()))) &&
            this.rating == other.getRating() &&
            ((this.tenants==null && other.getTenants()==null) || 
             (this.tenants!=null &&
              java.util.Arrays.equals(this.tenants, other.getTenants())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += (isAvailability() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getModel() != null) {
            _hashCode += getModel().hashCode();
        }
        if (getNextTenantId() != null) {
            _hashCode += getNextTenantId().hashCode();
        }
        if (getPrice() != null) {
            _hashCode += getPrice().hashCode();
        }
        _hashCode += new Float(getRating()).hashCode();
        if (getTenants() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTenants());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTenants(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Car.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://project.webServices.uge.fr", "Car"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("availability");
        elemField.setXmlName(new javax.xml.namespace.QName("http://project.webServices.uge.fr", "availability"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://project.webServices.uge.fr", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("model");
        elemField.setXmlName(new javax.xml.namespace.QName("http://project.webServices.uge.fr", "model"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nextTenantId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://project.webServices.uge.fr", "nextTenantId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("price");
        elemField.setXmlName(new javax.xml.namespace.QName("http://project.webServices.uge.fr", "price"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rating");
        elemField.setXmlName(new javax.xml.namespace.QName("http://project.webServices.uge.fr", "rating"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tenants");
        elemField.setXmlName(new javax.xml.namespace.QName("http://project.webServices.uge.fr", "tenants"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://project.webServices.uge.fr", "item"));
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
