package model.mediumcases;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.common.io.Resources;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class MediumCaseTest {

    @Test
    public void test_cost_center_serialisation() throws Exception {

        XmlMapper xmlMapper = new XmlMapper();

        CostCenter costCenter = new CostCenter();

        CostCenter.Data data1 = new CostCenter.Data();
        data1.setDesignation("designation_data1");
        data1.setNumber("1");
        CostCenter.Data data2 = new CostCenter.Data();
        data1.setDesignation("designation_data2");
        data1.setNumber("2");
        CostCenter.Data data3 = new CostCenter.Data();
        data1.setDesignation("designation_data3");
        data1.setNumber("3");

        costCenter.setDatas(Arrays.asList(data1, data2, data3));
        xmlMapper.writeValue(Files.newBufferedWriter(Files.createTempFile("hello", "world")), costCenter);
    }

    @Test
    public void test_cost_center_deserialisation() throws Exception {
        XmlMapper xmlMapper = new XmlMapper();

        URL resource = Resources.getResource("mediumcase/sap_cost_center_example.xml");

        Path path = Paths.get(resource.getPath());

        CostCenter costCenter = xmlMapper.readValue(path.toFile(), CostCenter.class);

        Assertions.assertThat(costCenter.getDatas()).hasSize(4);
        Assertions.assertThat(costCenter.getDatas().get(0).getNumber()).isEqualTo("1401000099");
        Assertions.assertThat(costCenter.getDatas().get(0).getDesignation()).isEqualTo("DIR.SERV.GÉNÉRAUX");
    }

    @Test
    public void test_internal_order_designation() throws Exception {
        XmlMapper xmlMapper = new XmlMapper();

        URL resource = Resources.getResource("mediumcase/sap_internal_order_example.xml");
        Path path = Paths.get(resource.getPath());
        InternalOrder internalOrder = xmlMapper.readValue(path.toFile(), InternalOrder.class);

        Assertions.assertThat(internalOrder.getDatas()).hasSize(6);
    }

    @Test
    public void test_provider_deseriatlisation() throws Exception {
        XmlMapper xmlMapper = new XmlMapper();

        URL resource = Resources.getResource("mediumcase/sap_provider_example.xml");
        Path path = Paths.get(resource.getPath());
        Provider provider = xmlMapper.readValue(path.toFile(), Provider.class);

        Assertions.assertThat(provider.getDatas()).hasSize(3);
    }
}