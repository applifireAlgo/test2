package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.CoreContactsRepository;
import com.app.shared.contacts.CoreContacts;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.app.shared.contacts.Gender;
import com.app.server.repository.GenderRepository;
import com.app.shared.location.Language;
import com.app.server.repository.LanguageRepository;
import com.app.shared.location.Timezone;
import com.app.server.repository.TimezoneRepository;
import com.app.shared.contacts.Title;
import com.app.server.repository.TitleRepository;
import com.app.shared.location.Address;
import com.app.server.repository.AddressRepository;
import com.app.shared.location.AddressType;
import com.app.server.repository.AddressTypeRepository;
import com.app.shared.location.City;
import com.app.server.repository.CityRepository;
import com.app.shared.location.Country;
import com.app.server.repository.CountryRepository;
import com.app.shared.location.State;
import com.app.server.repository.StateRepository;
import com.app.shared.contacts.CommunicationData;
import com.app.shared.contacts.CommunicationGroup;
import com.app.server.repository.CommunicationGroupRepository;
import com.app.shared.contacts.CommunicationType;
import com.app.server.repository.CommunicationTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void test1Save() {
        try {
            Gender gender = new Gender();
            gender.setGender("PaTtap4FUydQnfyq5eTLYPjCUaoHfPDBpbXwEQvJgBq382qiwr");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("vK");
            language.setAlpha3("hvK");
            language.setAlpha4("RoMl");
            language.setAlpha4parentid(11);
            language.setLanguage("4F0z3AtIMDVXoF3MnjrED8n60DjVRREF0ALPIb6iy9Ha3CGe84");
            language.setLanguageDescription("8hx9skWO65EqT19AgQOkqMSyLI3eCbXYBIglUidOnfhLwHyHmm");
            language.setLanguageIcon("5E6yxwLfhOZkf2EccSSsF4TtlYJGFkFVBTMMIjnDfAhBDLSf7k");
            language.setLanguageType("6ma4XUHMHruafxir3jLuooFigFLvIr2H");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("xFQPZkOyEjVeM7EvjZOhJhgXzQlYC90zmYBkvHkFBLPCATGczG");
            timezone.setCountry("KXkAWpYHzBSkNKO31HEQZheOuZWs954VMWSxo0d0cSysuS6Dqj");
            timezone.setGmtLabel("RLsaEYSRchToIUMSgK0T6AHVpwSgydD0i2gZESc7X3zKdbXbPT");
            timezone.setTimeZoneLabel("iDtNRCcfXT7XpMrNDO0BfM73Lv8CtTDLxmKQWJpUI9A2ZaL78I");
            timezone.setUtcdifference(3);
            Title title = new Title();
            title.setTitles("tMCASrCIOB3FWQ1LE4ffXs5ADvsSjPbNLDmCdBvL1MDVi5Xoix");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(121);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("jZPTNpFmsVqr0W2Dl03xeqIb5EWwORcjcqbN8VyILWxE1FfEkJ");
            corecontacts.setFirstName("0kKKEPLuvytY4no8jJMmnMhf78FdfazHiKgaghIhf6JMFqJF3C");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("s6PIZYLCvHhVwmuxbohzRS8tLaHa0BV8gRftBTpLrzJHouTmPC");
            corecontacts.setMiddleName("deBQcCM4rBsO31fhXzCnB8rgrU9HHIvjNzVeD7QhgYUpWcsUrq");
            corecontacts.setNativeFirstName("irUV5JRIok6KwQRnhrlaceat7B82Ky9wDtw1uUf3zzCEodDr7h");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("SmrQbwy7oZaGJkViR32N3NPeqtN59NUIgwVlDQnVDf861qJRKT");
            corecontacts.setNativeMiddleName("GWbAccLmGSA1LnuTGmk9IxCncGogs7aCw80nvF3bVsO6BeE1z9");
            corecontacts.setNativeTitle("plM9WobMkmlT1pji52eA6BOYiv0oyVj75QC6zpeVOoER5JjzVR");
            corecontacts.setPhoneNumber("H887FabhLdGiuPr1N4jn");
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("nIWLMvg8Q3ttvHp4X0IFu0Fl6GqKwEg4nU6Pz4qafOTrM3We5t");
            address.setAddress2("CKt2QaVNZhYPg2LusviqOmSBgBlnGBNhji2viIfXFC6i68brwn");
            address.setAddress3("RoQz6QYHQM39X3XPzrb7z98VBo2ci1zgIuhv8cKipueYpan6sn");
            address.setAddressLabel("ins9RBxzubC");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("I19ynLS4yy1Jtv3mwD0ETSF7C8ThMKf13mZlwG3tOXl791yDQn");
            addresstype.setAddressTypeDesc("y4w8JfVSPCdrN25OBRbxLaN2my4cUsIhkp6R57jkCtjQWRrGdp");
            addresstype.setAddressTypeIcon("4ALFvr1DYswgI9fITtEXDQFfoi73kIgE1HkgVcK1xjFbGMPpT1");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(1);
            city.setCityCodeChar2("wsFmmjR0kUFayV7I5OUpWJYJqnDMKxAq");
            city.setCityDescription("zALVaEP0ozaqryPlp9k8lEAdAqiLIlmdgZi4ro89lWHQtCXmf1");
            city.setCityFlag("d8s3KcqIhUNtR5XVnaKo3QqY5HIGdyHGXHmNosMEoJxwcmYWkK");
            city.setCityLatitude(4);
            city.setCityLongitude(11);
            city.setCityName("VpDa45FZMLA6YULMVqkG8RVSeTDzIuJzYTuwaQnAXeLkQrsLuL");
            Country country = new Country();
            country.setCapital("TMnoteP6ajpuINp1EGVaK6zeXy1K4R5c");
            country.setCapitalLatitude(10);
            country.setCapitalLongitude(9);
            country.setCountryCode1("n8g");
            country.setCountryCode2("sO5");
            country.setCountryFlag("X4btqL7mciZ4QA9PooC6cqltgVpAhI3LjttXlKkq35g70YB1BW");
            country.setCountryName("Szxzox4nhDzytSrvxV8wIx3lTrcesPeRROdc5N9tA207rMUkRZ");
            country.setCurrencyCode("IEu");
            country.setCurrencyName("OFajJZe7pfFMeG0zUVYhZpcGYZSKIL8bNrOZXswGQMsadwAkkQ");
            country.setCurrencySymbol("WuTtBrYq1c9QJ6oJpN1r6GBRp7o8MXh6");
            country.setIsoNumeric(5);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("5blsd6mLUGQUQmx1OVAiSQoRaAAdDfQI8qyBXB2P7wxFdRWyKR");
            state.setStateCapitalLatitude(8);
            state.setStateCapitalLongitude(2);
            state.setStateCode(2);
            state.setStateCodeChar2("qYmfHmNQ4hSBdvDlPIRBqoK80vsiwTQp");
            state.setStateCodeChar3("rnRgT8hhBFjg54LY3ncq3hgk2z6lxc1v");
            state.setStateDescription("kMqeYgU0pWAhM2OnBHpiPCdK0exr75AnM4BkLi2kLSGvZsYIv9");
            state.setStateFlag("luO3EeMODGIPG2ZzXFA4C0UdPN3sGJinGw4Bdm6S0lCpOD7uOM");
            state.setStateName("9ugTZ6ZK2W2zB4vL3fgwT8kyaZ70RXFoyQmHtairFNEFIFHebD");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("jMVRnCkdnhWLZWvLgQJ8DvfLYDgQueaX");
            city.setCityDescription("qv13hHHBtGZUpakwGKsvDUmLQdqbGedgeAJ0vPjIL0a1bkz9uD");
            city.setCityFlag("uVeC8fgZpkitZRzcdyz3UbYW66nCKTbgeNBTqwskhjaJ4CnYyU");
            city.setCityLatitude(3);
            city.setCityLongitude(2);
            city.setCityName("19eCwweEsEnlk6lnEJSHmVLqR8sjlSacsnogLusG6IGulJgRF7");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("xEKrpzzETO6MN2Iuq0hjOQx3axBS8hO3pbroe2FrLQT7zplat4");
            address.setAddress2("cv8iERCGNiWsJjYQUwicmz83siTWhQbvMNflQ1rOBXArjm0rXc");
            address.setAddress3("whrj2dY1NhBbqqTrg2OCXPdBlIvlm5acNTQvjZQsQ9iYDrZ0Xq");
            address.setAddressLabel("lrhCFYZ1BMJ");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("GS3zjoKNjeRVv0WgbMHXQbVUAFqikkupSUFsFvs18Yb8p1WeFe");
            address.setLongitude("zmRxYtWwFovYJqtIEHuK0c3sslo86CQAavtIQG1AZtjXwUeiG3");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("60e74R");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("edE");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("id1DkyEoK1vnqExRCTSKbiEguXy8PPC2i50FL4cjFpAatOX4Sn");
            communicationgroup.setCommGroupName("3OVdlrDActGPQUIzTDQ6V5A5mKHkQyAdyGHGpBF4FukEXfKHD2");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("XOT1vNMjSn0ZuKsNBGC8X7gxkatH5CkgBJS4eyrGfS9PPgi6Xd");
            communicationtype.setCommTypeName("8gUrFdPaAK7aFp3NKaAOoKjuVhysW7eQVHNsxpjCUrLMnQ3AEj");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("BoE");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
            map.put("TimezonePrimaryKey", corecontacts.getTimezone()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(80);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("N1EEwyW1pXvmf7gHjk7sNFznnMiaarGINBKcfs0fRNbMgh7wRh");
            corecontacts.setFirstName("Y47UusDE7hF3z5Bg48hRU2TSqCwuYiGhF5Esti1sYSHls7LbTb");
            corecontacts.setLastName("3vmhqwopkPFDoQrCZycuJgzI3osgSSitJxgYaHonjSaRDeH0ch");
            corecontacts.setMiddleName("vEyclnNfdo628wbHqNjnfmE0kqGPDoP6Awu2vS3LQiv1wA9WYn");
            corecontacts.setNativeFirstName("t8a97VzCmk82yR2Nm8ZJ0o5vFhjwatrgxoUqSCTs1zd87JjGAF");
            corecontacts.setNativeLastName("RGhZuzWVlcMpjVLPoukyGaApbrTCTTgtfnHsj6b9HiRZGffYT4");
            corecontacts.setNativeMiddleName("2wcWaroApxGcXbtWviWNhAEMkgwXknj4fHK9Oxzb6pG0tV1Zlh");
            corecontacts.setNativeTitle("me2p6x6RPIyf1Be0cCo0eQ96JTiRuFFovReIXSoNkr5iQJvurV");
            corecontacts.setPhoneNumber("kV7uMbwMKGUjuhX7LJSU");
            corecontacts.setVersionId(1);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
