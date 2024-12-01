package dao;

import java.util.List;
import model.Member;
import model.JenisMember;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class MemberDao {
    private final SqlSessionFactory sqlSessionFactory;

    public MemberDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public int insert(Member member) {
        int result;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            result = sqlSession.getMapper(MemberMapper.class).insert(member); // Gunakan getMapper untuk akses
        }
        return result;
    }

    public int update(Member member) {
        int result;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            result = sqlSession.getMapper(MemberMapper.class).update(member); // Gunakan getMapper untuk akses
        }
        return result;
    }

    public int delete(String memberId) {
        int result;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            result = sqlSession.getMapper(MemberMapper.class).delete(memberId); // Gunakan getMapper untuk akses
        }
        return result;
    }

    public List<Member> findAll() {
        List<Member> result;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            result = sqlSession.getMapper(MemberMapper.class).findAll(); // Gunakan getMapper untuk akses
        }
        return result;
    }
}