package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.LoginRepository;
import com.app.shared.authentication.Login;
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
import com.app.shared.contacts.CoreContacts;
import com.app.server.repository.CoreContactsRepository;
import com.app.shared.contacts.Gender;
import com.app.server.repository.GenderRepository;
import com.app.shared.location.Language;
import com.app.server.repository.LanguageRepository;
import com.app.shared.location.Timezone;
import com.app.server.repository.TimezoneRepository;
import com.app.shared.contacts.Title;
import com.app.server.repository.TitleRepository;
import com.app.shared.authentication.User;
import com.app.server.repository.UserRepository;
import com.app.shared.authentication.UserAccessDomain;
import com.app.server.repository.UserAccessDomainRepository;
import com.app.shared.authentication.UserAccessLevel;
import com.app.server.repository.UserAccessLevelRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase {

    @Autowired
    private LoginRepository<Login> loginRepository;

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
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(115);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("7ANDuhT2SkRDAxg8ZAtzib5FSfOxgTXuqsoWggQBFC3U2Kp8Br");
            corecontacts.setFirstName("vA0N0xzryUt5QYJTC08QfzGzDpngvdAXGV3vWzJCv92NL8rRZn");
            Gender gender = new Gender();
            gender.setGender("CK60u5O9Kb8TvTqV5duOBTeBuS6VpQjCgiwOLnVe4X9eQkVVkO");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("0F");
            language.setAlpha3("KYs");
            language.setAlpha4("5To6");
            language.setAlpha4parentid(9);
            language.setLanguage("aOpfhqius7vxQeRzt9rrHEDfCTYkXCRpu3BN3zNfvTliBjKv8i");
            language.setLanguageDescription("h2G7Z5MsOZnGgpvAVCBQuwM2x1VaFTOWRDzRb5K9TZPgAuQgsa");
            language.setLanguageIcon("b5r7o61vkRMImXvWDDodtcjEhsscSnO6Ig9ZeWbA0tGftLoHnQ");
            language.setLanguageType("cgQQ2gIxx7V3daf7r0hMZuwWaw4ZuGu8");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("BA6dZltfRmgzcQIQHa8CKFGtnUDo6TSViJGC207P6WFAhitZfX");
            timezone.setCountry("9vFnGFrZGeNBWZUS0pcW6XVVMif0PIWYObhjXNBIIIxfYVGi5g");
            timezone.setGmtLabel("ZBSor6nrYlNSrVC5CXhcdCtVz3cl62PVbfuAfow7QInGMlRQFf");
            timezone.setTimeZoneLabel("paKx7u8rZiYlaVhAvLdsFOqBuBagr4KrHiTQ6u4hTxwseensMs");
            timezone.setUtcdifference(8);
            Title title = new Title();
            title.setTitles("4Z2GCTdhcpeNzfmIiSKs72hsTE1sr9W4fY2VuvLoW6wOcr27As");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(69);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("3iRBxvNvQsa8eJhmErnyMluKNbeQeBq4ncWMmxjxJ8xxpFfNiu");
            corecontacts.setFirstName("1noPH7sLIq7F3XmgelIqlDcg8uAKrpI4GjVojRMnHhXLmglgha");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("KyLkTxX1tayvuAGXbFoO8k4kbe5n30h6MBZfQYVi7nehU7nMEP");
            corecontacts.setMiddleName("yn2deWoSFCgQyuedgq9CYarXimL8aFqlxKRgF9ACoA2XKQODYn");
            corecontacts.setNativeFirstName("SekqIEUHfPDw2pBlRqEooIqlh3ez5PxmBQmrJY3wOJ7b4uk38q");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("0Fddd9JrGZUxH0pkyFmFXcnhFQ7K9Y64I2MHB6fpHggTMx08Jz");
            corecontacts.setNativeMiddleName("HZuEvmcXfXARZnjKeggeQlrCRAed4rpqUbOGMqJEB7ZvhB5Tze");
            corecontacts.setNativeTitle("zkD1DnWwURFuoQILzbicBcFRjRKnCavqAMV3hSog8NuqZkHIXC");
            corecontacts.setPhoneNumber("ZuS5w8Hu7BFocGTpyMqN");
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(1);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("udWqVPZqdcqbUpeP0GTTO6sQjHxQicjZyvMfnfgnH0yHflal3s");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(2359);
            user.setUserAccessCode(8);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("AA0JhxQMUBqrNvzOi1VTDoZ1ZQwAy2wuRigEOzzs7UCdMQxxUK");
            useraccessdomain.setDomainHelp("SEoVZEouJU0k5es77jA5GHU98GCEJ3RBszEfk3otoUSHjcfkfS");
            useraccessdomain.setDomainIcon("FVig6pMMph8TOa18Olo8mqWUP2aTukHXMf4qfljXxnE9lCBUm4");
            useraccessdomain.setDomainName("ioDsDhFbohhI9iJj5hkuBdbk71RhhDwCXkNVmkifvUpnI3sJz6");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("HhqGzgtm8DBF3XTVhUBJWKtfVIzeybjardtIg6xQ1oP3LhXxhf");
            useraccesslevel.setLevelHelp("RkF09XuCB5VXcLTvjwu8GeXdsiK4Hqimqc67nBW8TZ1JwWQXgk");
            useraccesslevel.setLevelIcon("HvebFO5Ow7NpLkbHvBs78pLatL2J7VByfdxBbH83oxKzVRVHxx");
            useraccesslevel.setLevelName("Rj7ds6z1Eiyic9UWgNyLIZwulcJ1x1mXz8zYgcTJCrvfBrBfjn");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(0);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("0xwaiwpyWgHQZhlWSwcBL8fkI1u0ULc1qTyK3sFeJiHyuC36zZ");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(468);
            user.setUserAccessCode(7);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(10);
            login.setIsAuthenticated(true);
            login.setLoginId("O0f7b0v8BS2ZCRmsHxC3gPiocJJbm8GKwDk6chQsPXufry6jFQ");
            login.setServerAuthImage("k2zDwy8iLB3zMewHl85WtbvVnADjqC40");
            login.setServerAuthText("7Uksi1QmzF9djduS");
            login.setUser(user);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.setEntityValidator(entityValidator);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setFailedLoginAttempts(9);
            login.setLoginId("lPrNwn4WV3E2CslRDJPLa0N2R7zkpsozQ8v6NZTsqosgED9wee");
            login.setServerAuthImage("HfgkUVmGmnGBhOm3LspkYxvZY72i6Dwo");
            login.setServerAuthText("NIVubj47xdMUJzKN");
            login.setVersionId(1);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
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
