
import com.gao.dao.RoleMapper;
import com.gao.domain.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author gaols
 * @version 1.0
 * @date 2021/8/3 22:32
 */
public class RoleTest {
    private  SqlSession sqlSession;
    private  RoleMapper mapper;
    private  InputStream ins;
    @BeforeClass
    public void init() throws IOException {
        //读取配置文件
        ins = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        //构建SqlSessionFactory工厂
        SqlSessionFactory factory = builder.build(ins);
        sqlSession = factory.openSession();
        mapper = sqlSession.getMapper(RoleMapper.class);
    }
    @AfterClass
    public void finish() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        ins.close();
    }

    @Test
    public void testFinAll(){
        List<Role> rs = mapper.finAll();
        for (Role role : rs) {
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }

}
