package model;

import java.util.List;
import org.apache.ibatis.annotations.*;

public interface MahasiswaMapper {

    @Select("SELECT * FROM mahasiswa")
    List<Mahasiswa> getAllMahasiswa();

    @Insert("INSERT INTO mahasiswa (nama, nim, jurusan, email) VALUES (#{nama}, #{nim}, #{jurusan}, #{email})")
    void insertMahasiswa(Mahasiswa mahasiswa);

    @Update("UPDATE mahasiswa SET nama = #{nama}, nim = #{nim}, jurusan = #{jurusan}, email = #{email} WHERE id = #{id}")
    void updateMahasiswa(Mahasiswa mahasiswa);

    @Delete("DELETE FROM mahasiswa WHERE id = #{id}")
    void deleteMahasiswa(int id);
}
