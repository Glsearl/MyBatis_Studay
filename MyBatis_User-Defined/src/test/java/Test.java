import com.gao.dao.UserMapper;
import com.gao.domain.User;
import com.mybatis.io.Resources;
import com.mybatis.session.SqlSession;
import com.mybatis.session.SqlSessionFactory;
import com.mybatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author gaols
 * @version 1.0
 * @date 2021/8/3 22:32
 */
public class Test {
    public static void main(String[] args) throws IOException {
        //读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        //构建SqlSessionFactory工厂
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        //通过代理模式获取UserMapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.finAll();
        for (User user : users) {
            System.out.println(user);
        }
        resourceAsStream.close();
        sqlSession.close();
    }
}
