package com.example.plug.Model.Permissions;


import javax.xml.bind.annotation.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListPermissionDTO", propOrder = {
        "permissionDTO"
})
public class ListPermissionDTO implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;
    @XmlElement(name = "PermissionDTO", required = true)
    protected List<PermissionDTO> permissionDTO;

    public List<PermissionDTO> getPermissionDTO() {
        if (permissionDTO == null) {
            permissionDTO = new ArrayList<PermissionDTO>();
        }
        return this.permissionDTO;
    }

    public void setPermissionDTO(List<PermissionDTO> permissionDTO){
        this.permissionDTO = permissionDTO;
    }
}
