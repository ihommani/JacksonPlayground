package model;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.common.io.Resources;
import model.simplecase.Contact;
import model.simplecase.ContactBook;
import model.simplecase.ContactBookVariation;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.time.temporal.ValueRange;
import java.util.Arrays;
import java.util.List;

public class ContactTest {

    @Test
    public void test_SimpleCase_deserialisation() throws Exception {
        XmlMapper xmlMapper = new XmlMapper();

        URL resource = Resources.getResource("simplecase/simplecase1.xml");
        Path path = Paths.get(resource.getPath());
        Contact contact = xmlMapper.readValue(path.toFile(), Contact.class);

        Assertions.assertThat(contact.getFirstName()).isEqualTo("ismael");
        Assertions.assertThat(contact.getName()).isEqualTo("hommani");
        Assertions.assertThat(contact.getAddress()).isNull();
    }

    @Test
    public void test_SimpleCase2_deserialisation() throws Exception {
        XmlMapper xmlMapper = new XmlMapper();

        URL resource = Resources.getResource("simplecase/simplecase2.xml");
        Path path = Paths.get(resource.getPath());
        Contact contact = xmlMapper.readValue(path.toFile(), Contact.class);

        Assertions.assertThat(contact.getFirstName()).isEqualTo("ismael");
        Assertions.assertThat(contact.getName()).isEqualTo("hommani");
        Assertions.assertThat(contact.getAddress()).isEqualTo("5 rue des eglantines");
        Assertions.assertThat(contact.getAge()).isEqualTo(30);
    }

    @Test
    public void test_SimpleCase3_deserialisation() throws Exception {
        XmlMapper xmlMapper = new XmlMapper();

        URL resource = Resources.getResource("simplecase/contact-book.xml");
        Path path = Paths.get(resource.getPath());
        ContactBook contacts = xmlMapper.readValue(path.toFile(), ContactBook.class);

        Assertions.assertThat(contacts.getContacts()).hasSize(2);
    }


    @Test
    public void test_serializing_list() throws Exception {

        XmlMapper xmlMapper = new XmlMapper();

        ContactBook contactBook = new ContactBook();

        Contact contact1 = new Contact();
        contact1.setFirstName("name1");

        Contact contact2 = new Contact();
        contact1.setFirstName("name2");

        List<Contact> contacts = Arrays.asList(contact1, contact2);

        contactBook.setContacts(contacts);

        xmlMapper.writeValue(Files.newBufferedWriter(Files.createTempFile("hello", "world")), contactBook);

    }

    @Test
    public void test_serializing_list_variation() throws Exception {

        XmlMapper xmlMapper = new XmlMapper();

        ContactBookVariation contactBook = new ContactBookVariation();

        Contact contact1 = new Contact();
        contact1.setFirstName("name1");
        contact1.setAccount(100000000.23456D);

        Contact contact2 = new Contact();
        contact2.setFirstName("name2");
        contact2.setAccount(100000000.0D);

        List<Contact> contacts = Arrays.asList(contact1, contact2);

        contactBook.setContacts(contacts);

        xmlMapper.writeValue(Files.newBufferedWriter(Files.createTempFile("hello", "world")), contactBook);

    }
}