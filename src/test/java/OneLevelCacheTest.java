import entity.User;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



/**
 * Created by HASEE on 2018/11/12.
 */
public class OneLevelCacheTest {
    public static void main(String[] args){
        SqlSession sqlSession=null;
        try {
            sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
            OneLevelCacheTest t=new OneLevelCacheTest();
            t.testCache1(sqlSession);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            try{
                if(sqlSession!=null)sqlSession.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void testCache1(SqlSession sqlSession){
        UserMapper um=sqlSession.getMapper(UserMapper.class);
        User user=um.selectUserById(1);
        System.out.println(user);
        User user1=um.selectUserById(1);
        System.out.println(user1);
    }
}
