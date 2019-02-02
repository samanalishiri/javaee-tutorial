package com.saman.tutorial.javaee.ejb;

import com.saman.tutorial.javaee.ejb.service.user.UserModel;
import com.saman.tutorial.javaee.ejb.service.user.UserService;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.logging.Logger;

@RunWith(Arquillian.class)
public class RepositoryTest {

    private final Logger logger = Logger.getLogger("RepositoryTest");

    private final UserModel.Builder userBuilder = UserModel.newBuilder();

    @Inject
    private UserService userRepository;

    @Deployment
    public static JavaArchive createTestArchive() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar")
                .addPackages(true, "com.saman.tutorial.javaee.ejb")
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    public void init() {
        userRepository.save(userBuilder.id(1).username("admin").email("admin@gmail.com").password("123").build());
    }

    public void truncate() {
        userRepository.delete(1);
    }

    @Test
    public void findByUserIdTest() {
        init();

        UserModel user = userRepository.findById(1);
        Assert.assertNotNull(user);
        Assert.assertEquals(new Integer(1), user.getId());

        truncate();
    }

}
