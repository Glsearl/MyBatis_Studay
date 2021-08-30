
import com.gao.dao.UserMapper;
import com.gao.domain.QueryVo;
import com.gao.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

/**
 * @author gaols
 * @version 1.0
 * @date 2021/8/3 22:32
 */
public class MyBatisCRUDTest {
    private  SqlSession sqlSession;
    private  UserMapper mapper;
    private    InputStream ins;
    @BeforeClass
    public void init() throws IOException {
        //读取配置文件
        ins = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        //构建SqlSessionFactory工厂
        SqlSessionFactory factory = builder.build(ins);
        sqlSession = factory.openSession();
        mapper = sqlSession.getMapper(UserMapper.class);
    }
    @AfterClass
    public void finish() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        ins.close();
    }

    @Test
    public void testFinAll(){
        List<User> users = mapper.finAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void testFindUserById(){
      User user= mapper.findUserById(48);
        System.out.println(user);
    }
    @Test
    public void testFindUserByName(){
        //模糊查询
//        List<User> users= mapper.findUserByName("%王%");
        List<User> users= mapper.findUserByName("王");
        System.out.println(users);
    }
    @Test
    public void testFindByVo(){
        QueryVo vo=new QueryVo();
        List<Integer> ids=new ArrayList<>();
        ids.add(41);
        ids.add(42);
        ids.add(43);
        vo.setIds(ids);
        List<User> users=mapper.findByVo(vo);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }
    @Test
    public void testFindUserByUser(){
        User  user=new User();
        user.setUsername("老王");
//        user.setSex("女");
        List<User> users= mapper.findUserByUser(user);
        System.out.println(users);
    }
}
