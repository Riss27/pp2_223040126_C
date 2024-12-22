package model;

public class Mahasiswa {
    private int id;
    private String nama;
    private int nim;
    private String jurusan;
    private String email;

    public int getId() { 
        return id; 
    }

    public void setId(int id) { 
        this.id = id; 
    }

    public String getNama() { 
        return nama; 
    }

    public void setNama(String nama) { 
        this.nama = nama; 
    }

    public int getNim() { 
        return nim; 
    }

    public void setNim(int nim) { 
        this.nim = nim; 
    }

    public String getJurusan() { 
        return jurusan; 
    }

    public void setJurusan(String jurusan) { 
        this.jurusan = jurusan; 
    }

    public String getEmail() { 
        return email; 
    }

    public void setEmail(String email) { 
        this.email = email; 
    }
}