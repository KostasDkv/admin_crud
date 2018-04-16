

package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "variety")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Variety.findAll", query = "SELECT v FROM Variety v")
    , @NamedQuery(name = "Variety.findByVarietyId", query = "SELECT v FROM Variety v WHERE v.varietyId = :varietyId")
    , @NamedQuery(name = "Variety.findByVarietyName", query = "SELECT v FROM Variety v WHERE v.varietyName = :varietyName")})
public class Variety implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "variety_id")
    private Integer varietyId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "variety_name")
    private String varietyName;
    @OneToMany(mappedBy = "typeId")
    private Collection<Product> productCollection;
    @JoinColumn(name = "type_id", referencedColumnName = "type_id")
    @ManyToOne(optional = false)
    private Type typeId;

    public Variety() {
    }

    public Variety(Integer varietyId) {
        this.varietyId = varietyId;
    }

    public Variety(Integer varietyId, String varietyName) {
        this.varietyId = varietyId;
        this.varietyName = varietyName;
    }

    public Integer getVarietyId() {
        return varietyId;
    }

    public void setVarietyId(Integer varietyId) {
        this.varietyId = varietyId;
    }

    public String getVarietyName() {
        return varietyName;
    }

    public void setVarietyName(String varietyName) {
        this.varietyName = varietyName;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    public Type getTypeId() {
        return typeId;
    }

    public void setTypeId(Type typeId) {
        this.typeId = typeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (varietyId != null ? varietyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Variety)) {
            return false;
        }
        Variety other = (Variety) object;
        if ((this.varietyId == null && other.varietyId != null) || (this.varietyId != null && !this.varietyId.equals(other.varietyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Variety[ varietyId=" + varietyId + " ]";
    }

}
