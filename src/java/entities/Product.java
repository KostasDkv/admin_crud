

package entities;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
    , @NamedQuery(name = "Product.findByProductId", query = "SELECT p FROM Product p WHERE p.productId = :productId")
    , @NamedQuery(name = "Product.findByBasePriceIn", query = "SELECT p FROM Product p WHERE p.basePriceIn = :basePriceIn")
    , @NamedQuery(name = "Product.findByBasePriceOut", query = "SELECT p FROM Product p WHERE p.basePriceOut = :basePriceOut")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "product_id")
    private Integer productId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "base_price_in")
    private double basePriceIn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "base_price_out")
    private double basePriceOut;
    @JoinColumn(name = "type_id", referencedColumnName = "variety_id")
    @ManyToOne
    private Variety typeId;

    public Product() {
    }

    public Product(Integer productId) {
        this.productId = productId;
    }

    public Product(Integer productId, double basePriceIn, double basePriceOut) {
        this.productId = productId;
        this.basePriceIn = basePriceIn;
        this.basePriceOut = basePriceOut;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public double getBasePriceIn() {
        return basePriceIn;
    }

    public void setBasePriceIn(double basePriceIn) {
        this.basePriceIn = basePriceIn;
    }

    public double getBasePriceOut() {
        return basePriceOut;
    }

    public void setBasePriceOut(double basePriceOut) {
        this.basePriceOut = basePriceOut;
    }

    public Variety getTypeId() {
        return typeId;
    }

    public void setTypeId(Variety typeId) {
        this.typeId = typeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Product[ productId=" + productId + " ]";
    }

}
