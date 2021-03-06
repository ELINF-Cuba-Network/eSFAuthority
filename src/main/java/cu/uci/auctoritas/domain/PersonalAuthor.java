package cu.uci.auctoritas.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;


@Entity
public class PersonalAuthor {

    @Id
    private String uri;
    private String name;
    private String lastname;
    private String authority;

    @XmlElement
    public String getName() {
        return name;
    }
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }
    @XmlElement
    public String getAuthority() {
        return authority;
    }
    @XmlElement
    public void setAuthority(String authority) {
        this.authority = authority;
    }
    @XmlElement
    public String getUri() {
        return uri;
    }
    @XmlElement
    public void setUri(String uri) {
        this.uri = uri;
    }
    @XmlElement
    public String getLastname() {
        return lastname;
    }
    @XmlElement
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
