import com.gao.dao.Impl.UserMapperImpl;
import com.gao.dao.UserMapper;
import com.gao.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
        //使用UserMapper的实现类调用findAll方法
        UserMapper mapper=new UserMapperImpl(factory);
        List<User> users = mapper.finAll();
        for (User user : users) {
            System.out.println(user);
        }
        resourceAsStream.close();
    }
}
