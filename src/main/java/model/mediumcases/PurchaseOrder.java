package model.mediumcases;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JsonRootName(value = "DA")
public class PurchaseOrder {
    @JsonProperty(required = true)
    @JacksonXmlProperty(isAttribute = true)
    private String id;
    @JsonProperty(required = true)
    @JacksonXmlProperty(isAttribute = true, localName = "titre")
    private String title;
    @JsonProperty(required = true)
    @JacksonXmlProperty(isAttribute = true, localName = "montant_engagement")
    private Double amount;
    @JsonProperty(required = true)
    @JacksonXmlProperty(isAttribute = true)
    private Long date;
    @JsonProperty(required = true)
    @JacksonXmlProperty(isAttribute = true, localName = "type_de_commande")
    private String type;
    @JsonProperty(required = true)
    @JacksonXmlCData
    private String description;
    @JsonProperty(required = true, value = "fournisseur")
    private String provider;
    @JsonProperty(required = true, value = "refFournisseur")
    private String providerReference;
    @JsonProperty(required = true)
    @JacksonXmlElementWrapper(localName = "postes")
    private List<PosteData> poste;

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public void setProviderReference(String providerReference) {
        this.providerReference = providerReference;
    }

    public void setPoste(List<PosteData> poste) {
        this.poste = poste;
    }

    public static class PosteData {
        @JsonProperty(required = true, value = "type_imputation")
        private String imputationType;
        @JsonProperty(required = true, value = "type_de_poste")
        private String posteType;
        @JsonProperty(required = true, value = "designation")
        private String designation;
        @JsonProperty(required = true, value = "quantite")
        private String quantity;
        @JsonProperty(required = true, value = "date_livraison_souhaitee")
        private Long deliveryDate;
        @JsonProperty(required = true, value = "commentaire")
        private String comment;

        @JsonIgnore
        private String fournisseur;
        @JsonIgnore
        private String fournisseurReference;

        public void setImputationType(String imputationType) {
            this.imputationType = imputationType;
        }

        public void setPosteType(String posteType) {
            this.posteType = posteType;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        public void setDeliveryDate(Long deliveryDate) {
            this.deliveryDate = deliveryDate;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public void setFournisseur(String fournisseur) {
            this.fournisseur = fournisseur;
        }

        public void setFournisseurReference(String fournisseurReference) {
            this.fournisseurReference = fournisseurReference;
        }
    }
}
