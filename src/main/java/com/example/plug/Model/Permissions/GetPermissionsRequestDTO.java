package com.example.plug.Model.Permissions;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serial;
import java.io.Serializable;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetPermissionsRequest_DTO", propOrder = {
        "rqUID",
        "rqTM",
        "ownerID"
})
@XmlSeeAlso({
        GetPermissionsRequest.class
})
public class GetPermissionsRequestDTO implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;
    @XmlElement(name = "RqUID", required = true)
    protected String rqUID;
    @XmlElement(name = "RqTm", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar rqTM;
    @XmlElement(name = "OwnerID")
    protected String ownerID;

    public String getRqUID() {
        return rqUID;
    }

    public void setRqUID(String rqUID) {
        this.rqUID = rqUID;
    }

    public XMLGregorianCalendar getRqTM() {
        return rqTM;
    }

    public void setRqTM(XMLGregorianCalendar value) {
        this.rqTM = value;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

}


