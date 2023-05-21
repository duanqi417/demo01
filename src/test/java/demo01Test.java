import com.duan.mapper.CourseMapper;
import com.duan.pojo.Course;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class demo01Test {

      //查询id=2的课程信息

    @Test
    public void selectByIdTest() throws IOException {
        int id = 2;
        //1/获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);

        Course course = courseMapper.selectById(id);

        System.out.println(course);
        sqlSession.close();
    }


     //查询所有计算机学院开设课程信息

    @Test
    public void selectAllBySchoolTest() throws IOException {
        int school = 1;
        //1/获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);

        List<Course> course = courseMapper.selectAllBySchool(school);

        System.out.println(course);
        sqlSession.close();
    }

     // 将 id=4 这⻔课程的课时数修改为 32+8=40；


    @Test
    public void updateByHoursTest() throws IOException {
        int id = 4;
        int hours = 40;

        //1/获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);

        int  course = courseMapper.updateByHours(hours,id);

        System.out.println(course);
        //需要提交事务，数据库才会更新
        sqlSession.commit();
        //关闭sqlSession
        sqlSession.close();
    }

      //插⼊⼀条新的课程记录： names=”⼤数据存储“，hours=32，schools =1；

    @Test
    public void insertAllTest() throws IOException {
        String name = "大数据存储";
        int hours = 32;
        int schools = 1;

        //1/获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);

        int course = courseMapper.insertAll(name, hours, schools);

        System.out.println(course);
        //需要提交事务，数据库才会更新
        sqlSession.commit();
        //关闭sqlSession
        sqlSession.close();
    }


      //输出所有的学院开设的课程信息

    @Test
    public void selectAllTest() throws IOException {

        //1/获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);

        List<Course> course = courseMapper.selectAll();

        System.out.println(course);
        sqlSession.close();
    }
}
