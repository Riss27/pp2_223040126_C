package dao;

import model.Member;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

public class MemberDao {

    private SqlSession sqlSession;

    public MemberDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public void insert(Member member) {
        sqlSession.insert("MemberMapper.insert", member);
    }

    public List<Member> findAll() {
        return sqlSession.selectList("MemberMapper.findAll");
    }
    
    public void update(Member member) {
        sqlSession.update("MemberMapper.update", member);
    }

    public void delete(String id) {
        sqlSession.delete("MemberMapper.delete", id);
    }
}
