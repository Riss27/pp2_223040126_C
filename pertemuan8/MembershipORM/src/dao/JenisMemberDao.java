package dao;

import model.JenisMember;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

public class JenisMemberDao {

    private SqlSession sqlSession;

    public JenisMemberDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public void insert(JenisMember jenisMember) {
        sqlSession.insert("JenisMemberMapper.insert", jenisMember);
    }

    public List<JenisMember> findAll() {
        return sqlSession.selectList("JenisMemberMapper.findAll");
    }
}
