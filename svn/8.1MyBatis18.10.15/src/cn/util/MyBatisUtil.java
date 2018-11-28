package cn.util;

import java.io.IOException;  
import java.io.Reader;  
import org.apache.ibatis.io.Resources;  
import org.apache.ibatis.session.SqlSession;  
import org.apache.ibatis.session.SqlSessionFactory;  
import org.apache.ibatis.session.SqlSessionFactoryBuilder;  
  
/** 
 * ������ 
 */  
public class MyBatisUtil {  
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();  
    private static SqlSessionFactory sqlSessionFactory;  
    /** 
     * ����λ��src/mybatis-config.xml�����ļ� 
     */  
    static{  
        try {  
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);  
        } catch (IOException e) {  
            e.printStackTrace();  
            throw new RuntimeException(e);  
        }  
    }  
    /** 
     * ��ֹ���ͨ��new��������  
     */  
    private MyBatisUtil(){}  
    /** 
     * ��ȡSqlSession 
     */  
    public static SqlSession getSqlSession(){  
        //�ӵ�ǰ�߳��л�ȡSqlSession����  
        SqlSession sqlSession = threadLocal.get();  
        //���SqlSession����Ϊ��  
        if(sqlSession == null){  
            //��SqlSessionFactory�ǿյ�����£���ȡSqlSession����  
            sqlSession = sqlSessionFactory.openSession();  
            //��SqlSession�����뵱ǰ�̰߳���һ��  
            threadLocal.set(sqlSession);  
        }  
        //����SqlSession����  
        return sqlSession;  
    }  
    /** 
     * �ر�SqlSession�뵱ǰ�̷ֿ߳� 
     */  
    public static void closeSqlSession(){  
        //�ӵ�ǰ�߳��л�ȡSqlSession����  
        SqlSession sqlSession = threadLocal.get();  
        //���SqlSession����ǿ�  
        if(sqlSession != null){  
            //�ر�SqlSession����  
            sqlSession.close();  
            //�ֿ���ǰ�߳���SqlSession����Ĺ�ϵ��Ŀ������GC�������  
            threadLocal.remove();  
        }  
    }
}