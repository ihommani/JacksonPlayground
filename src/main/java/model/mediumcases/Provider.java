package model.mediumcases;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "fournisseurs")
public class Provider {

    @JacksonXmlElementWrapper(useWrapping = false, localName = "donnees")
    @JsonProperty(value = "donnees")
    private List<Data> datas;

    public List<Data> getDatas() {
        return datas;
    }

    public void setDatas(List<Data> datas) {
        this.datas = datas;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        @JacksonXmlProperty(localName = "nom")
        private String name;
        @JacksonXmlProperty(localName = "blacklist")
        private String designation;

        public Data() {
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        public String getName() {
            return name;
        }

        public String getDesignation() {
            return designation;
        }
    }
}
