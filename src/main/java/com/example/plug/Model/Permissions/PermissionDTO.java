package com.example.plug.Model.Permissions;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serial;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PermissionDTO", propOrder = {
        "personId",
        "representId",
        "documentId",
        "typePerson"
})
public class PermissionDTO implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;
    @XmlElement(name = "PersonId", required = true)
    protected String personId;
    @XmlElement(name = "RepresentId", required = true)
    protected String representId;
    @XmlElement(name = "DocumentId", required = true)
    protected String documentId;
    @XmlElement(name = "TypePerson", required = true)
    protected String typePerson;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getRepresentId() {
        return representId;
    }

    public void setRepresentId(String representId) {
        this.representId = representId;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getTypePerson() {
        return typePerson;
    }

    public void setTypePerson(String typePerson) {
        this.typePerson = typePerson;
    }
}
