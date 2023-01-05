package com.example.plug.Model.Permissions;


import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serial;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetPermissionsResponseDTO", propOrder = {
        "rqUID",
        "rqTM",
        "permission"
})

@XmlSeeAlso({
        GetPermissionsResponse.class
})
public class GetPermissionsResponseDTO implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;
    @XmlElement(name = "RqUID", required = true)
    protected String rqUID;
    @XmlElement(name = "RqTm", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar rqTM;
    @XmlElement(name = "Permissions", required = true)
    protected PermissionTypeDTO permission;

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

    public PermissionTypeDTO getPermission() {
        return permission;
    }

    public void setPermission(PermissionTypeDTO permission) {
        this.permission = permission;
    }
}
