package com.example.plug.Model.Permissions;

import javax.xml.bind.annotation.*;
import java.io.Serial;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PermissionTypeDTO", propOrder = {
        "listPermission"
})
public class PermissionTypeDTO implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;
    @XmlElement(name = "ListPermission")
    protected ListPermissionDTO listPermission;

    public ListPermissionDTO getListPermission() {
        return listPermission;
    }

    public void setListPermission(ListPermissionDTO listPermission) {
        this.listPermission = listPermission;
    }
}
