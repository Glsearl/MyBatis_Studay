
import com.gao.dao.UserMapper;
import com.gao.dao.impl.UserMapperImpl;
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
import java.util.Date;
import java.util.List;

/**
 * @author gaols
 * @version 1.0
 * @date 2021/8/3 22:32
 */
public class MyBatisImplTest {
    private    InputStream ins;
    private  UserMapper mapper;
    @BeforeClass
    public void init() throws IOException {
        //读取配置文件
        ins = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        //构建SqlSessionFactory工厂
        SqlSessionFactory factory = builder.build(ins);
        mapper=new UserMapperImpl(factory);
    }
    @AfterClass
    public void finish() throws IOException {
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
    public void testSaveUser(){
        User user=new User();
        user.setUsername("王思聪");
        user.setSex("男");
        user.setAddress("上海市");
        Date date=new Date();
//        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String time = simpleDateFormat.format(date);
        long time = date.getTime();
        user.setBirthday(new java.sql.Date(time));
        System.out.println("保存前的user："+user);
        mapper.saveUser(user);
        System.out.println("保存后的user："+user);
    }
    @Test
    public void testUpdateUser(){
        User user=new User();
        user.setUsername("刘亦菲");
        user.setSex("女");
        user.setAddress("北京市");
        user.setId(49);
        Date date=new Date();
        long time = date.getTime();
        user.setBirthday(new java.sql.Date(time));
        mapper.updateUser(user);
    }
    @Test
    public void testDeleteUserById(){
        mapper.deleteUserById(49);
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
    public void testCount(){
        int i= mapper.count();
        System.out.println(i);
    }
    @Test
    public void testFindByVo(){
        QueryVo vo=new QueryVo();
        User  user=new User();
        user.setUsername("%王%");
        vo.setUser(user);
        List<User> users=mapper.findByVo(vo);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }
}
