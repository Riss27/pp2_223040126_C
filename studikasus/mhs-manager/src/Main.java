import model.MyBatisUtil; 
import model.MahasiswaMapper;
import org.apache.ibatis.session.SqlSession; 

import view.MahasiswaPdf;
import view.MahasiswaView;
import controller.MahasiswaController;

public class Main {
    public static void main(String[] args) {
        SqlSession session = MyBatisUtil.getSqlSession(); 
        MahasiswaMapper mapper = session.getMapper(MahasiswaMapper.class);
        MahasiswaPdf pdf = new MahasiswaPdf();
        
        MahasiswaView view = new MahasiswaView(); 
        new MahasiswaController(view, mapper, pdf);
        
        view.setVisible(true);
    }
}