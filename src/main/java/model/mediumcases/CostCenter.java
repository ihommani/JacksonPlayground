package model.mediumcases;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "centres")
public class CostCenter {

    @JacksonXmlElementWrapper(useWrapping = false, localName = "donnees")
    @JsonProperty(value = "donnees")
    private List<Data> datas;

    public List<Data> getDatas() {
        return datas;
    }

    public void setDatas(List<Data> datas) {
        this.datas = datas;
    }

    public static class Data {
        @JacksonXmlProperty(isAttribute = true, localName = "numero")
        private String number;
        private String designation;

        public void setNumber(String number) {
            this.number = number;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        public String getNumber() {
            return number;
        }

        public String getDesignation() {
            return designation;
        }
    }
}
