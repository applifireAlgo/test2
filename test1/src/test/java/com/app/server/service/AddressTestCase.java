package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.AddressRepository;
import com.app.shared.location.Address;
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
import com.app.shared.location.AddressType;
import com.app.server.repository.AddressTypeRepository;
import com.app.shared.location.City;
import com.app.server.repository.CityRepository;
import com.app.shared.location.Country;
import com.app.server.repository.CountryRepository;
import com.app.shared.location.State;
import com.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase {

    @Autowired
    private AddressRepository<Address> addressRepository;

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
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("lpghFrmB5AsY5DTdLJf3fRo8zZI4JvX59bbRuVTFgGyGnoz1Nv");
            addresstype.setAddressTypeDesc("j9l3ChHP2d62i4TpCaDE9lkkcpaP4BxufQUJ15t1a00fuxoiSh");
            addresstype.setAddressTypeIcon("8zwmFiXdld8fvtO7qGVV5p5eYJhzo4NaNNZ64HdzT0diowzNcm");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("FNnXAh1NpS1Eg6dr6P8eWOE7kOiXjIfq");
            city.setCityDescription("ek6NZeM4IkbkEddGZd6BlbTIz0hnYsTJCoEUJug17SGXkumnKA");
            city.setCityFlag("JhJozCZaykZeZkXbr3drJ12DtPt4hfx2ar2l8yrUQFdlmjrAK6");
            city.setCityLatitude(4);
            city.setCityLongitude(10);
            city.setCityName("u5YdJFFN1POTG1MfK9nBO1AhJzdK8ZenD3qdV8N37P0qZsE7Ji");
            Country country = new Country();
            country.setCapital("8fltbZfixsGWxdcnDXzqQiGNqn6uz6ST");
            country.setCapitalLatitude(4);
            country.setCapitalLongitude(7);
            country.setCountryCode1("l8L");
            country.setCountryCode2("MNw");
            country.setCountryFlag("47h7JlyCM58Cp0KfJSFpHNMpapKrvpa7XeiSmW5ohl8j1zwJ1g");
            country.setCountryName("lWfut5ZiT9Ox47axmSktAJTPCHbV70Uvcskx8tPS9MRP8wEv4V");
            country.setCurrencyCode("odP");
            country.setCurrencyName("WNSzr051GFnAbREdN5SCGyAMAbOcEWUdyq4A7fFLgCASBLfINi");
            country.setCurrencySymbol("aZ8QtpzpoFRxtqq3OCnuSLCtO28TFoCj");
            country.setIsoNumeric(7);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("dlpwFLjRv4gYkS1C4xscot6wdtdnY1tshyw4RIvD1PyXONKQ44");
            state.setStateCapitalLatitude(3);
            state.setStateCapitalLongitude(3);
            state.setStateCode(1);
            state.setStateCodeChar2("JscRvupyD9YdWDhJb9oFntcboFs1biTi");
            state.setStateCodeChar3("WdpA4Imo1nGyLkqkMcKE5x6thPHIE61L");
            state.setStateDescription("WI80ptoS5b5nbQoL0mGxeJhOH2K0JaPqXDCZUHfqDiWGWSfw0Q");
            state.setStateFlag("0SFAB16IAoUu9feECD7pzLl1RzmzrHL4pnwdKdXEIQPgXEg4hw");
            state.setStateName("lioW2sVE8T0Tn8nGvtmzn9huUNxV5w0VlIwYngTHbu60QHbRrg");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(3);
            city.setCityCodeChar2("DHBKUOuDe69XLqhinWr09x83QwDRM26f");
            city.setCityDescription("m4C3TwiaSK0zgJvwF6zqN37kcCQe0rmvVPaaQvKU4JtyQDhgba");
            city.setCityFlag("Wb91DYTy4ewsjWP31udvHxyWifSj8sL8G5ohdyeV8r21z5ZsHp");
            city.setCityLatitude(8);
            city.setCityLongitude(1);
            city.setCityName("9am0JSsxul1D5xpk5Xbknd6tliICO2cFtKaCqMhgUsQgNZ4Fht");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("QyWOtcg1H6IxOBsO7pySSZLQTxbPZhCo2fbwGktj5l7FkKjqyZ");
            address.setAddress2("r9SAjXoQOLfSl2zhN1madDdDXOMVmepea6GGCbI4F3Zj4Q6cki");
            address.setAddress3("dv4XfbtdTnoxKSR0zH1jtpSXjyL22y6nHBzKsTZkPyMAhjIawH");
            address.setAddressLabel("Q0SpoQjR3DV");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("m1z5G1gjTgEXYKfrFW7tWhp4LBnGezkSA03rG8X9U8ZnsObaaC");
            address.setLongitude("LiI7ya6rIi7CyvZjrA615PoZGpZCmU1JrGBXkqof8682GNZqMI");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("Gx1B2A");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.setEntityValidator(entityValidator);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress1("jO5nOMTlLUIOsyLiQGrSnC7IlqHwu602QyBYVxhG5LaB5TQi8c");
            address.setAddress2("pnp81XYHDRWcewpuNBPUfY63ee332St3LV20Z5zB5gFPxzZd6X");
            address.setAddress3("waGTfQpk6wBhnll9roF7zNVsTPNZjeaeI3dc93oq3dAc3M1Rsi");
            address.setAddressLabel("kmn0c6PTLf9");
            address.setLatitude("VwOnXKFG5i8Jq7aU8CxA1r4xG5ggp4u9vPT3jbXCXV0cDWLEi3");
            address.setLongitude("SWHaFyATU21cLLdCHKbKtcytamvperdn6rGffTtazRUGvJHUb8");
            address.setVersionId(1);
            address.setZipcode("EvvPKn");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
