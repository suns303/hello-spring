package kr.re.kitri.hello.dao;

import kr.re.kitri.hello.model.Amigo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by danawacomputer on 2017-06-15.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
                "classpath:spring/applicationContext.xml",
                "classpath:spring/db.xml"})

public class AmigoDaoTest {

    private ApplicationContext context;

    @Before
    public void setup(){
        context = new ClassPathXmlApplicationContext(
                "classpath:spring/db.xml",
                "classpath:spring/applicationContext.xml");
    }

    @Autowired
    private AmigoDao amigoDao;

    @Test
    public void testInsertAmigo(){

        Amigo amigo = new Amigo();
        amigo.setName("kyungyeon1");
        amigo.setPhone("010660744321");
        amigo.setEmail("mil1kis");
        amigoDao.insertAmigo(amigo);

    }
}
