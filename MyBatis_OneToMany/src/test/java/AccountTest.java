
import com.gao.dao.AccountMapper;
import com.gao.dao.UserMapper;
import com.gao.domain.Account;
import com.gao.domain.AccountUser;
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
import java.util.List;

/**
 * @author gaols
 * @version 1.0
 * @date 2021/8/3 22:32
 */
public class AccountTest {
    private  SqlSession sqlSession;
    private  AccountMapper mapper;
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
        mapper = sqlSession.getMapper(AccountMapper.class);
    }
    @AfterClass
    public void finish() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        ins.close();
    }

    @Test
    public void testFinAll(){
        List<Account> aus = mapper.findAll();
        for (Account au : aus) {
            System.out.println(au);
            System.out.println(au.getUser());
        }
    }

}
