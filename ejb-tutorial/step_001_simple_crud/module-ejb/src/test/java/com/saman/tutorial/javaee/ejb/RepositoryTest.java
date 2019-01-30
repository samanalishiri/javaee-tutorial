package com.saman.tutorial.javaee.ejb;

import com.saman.tutorial.javaee.ejb.domain.UserEntity;
import com.saman.tutorial.javaee.ejb.repository.user.UserRepository;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RunWith(Arquillian.class)
public class RepositoryTest {

    public static final Logger LOGGER = Logger.getLogger("RepositoryTest");
    @Inject
    private UserRepository userRepository;

    @Deployment
    public static JavaArchive createTestArchive() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar")
                .addPackages(true, "com.saman.tutorial.javaee.ejb")
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Before
    public void init() throws Exception {

        UserEntity entity = new UserEntity();
        entity.setId(1);
        entity.setUsername("samanalishiri");
        entity.setEmail("samanalishiri@gmail.com");
        entity.setPassword("123");

        Integer id = userRepository.save(entity);

        Assert.assertNotNull("save user failed", id);
        LOGGER.info(entity.toString());
    }

    @After
    public void tearDown() throws Exception {
        List<UserEntity> users;

        users = userRepository.findAll();
        Assert.assertNotNull(users);

        users.stream().forEach(e -> userRepository.delete(e.getId()));

        users = userRepository.findAll();
        Assert.assertNotNull(users);
        Assert.assertEquals("truncate user table failed", 0, users.size());
    }

    @Test
    public void findAllUserTest() {
        List<UserEntity> users = userRepository.findAll();

        Assert.assertNotNull("users is null", users);
        Assert.assertEquals(String.format("number of users: %s", users.size()), 1, users.size());

        LOGGER.info(String.join("\n", users.stream().map(UserEntity::toString).collect(Collectors.toList())));
    }

}
