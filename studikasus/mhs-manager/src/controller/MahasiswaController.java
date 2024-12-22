
package controller;

import model.*;
import view.MahasiswaPdf;
import view.MahasiswaView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MahasiswaController {
    private MahasiswaView view;
    private MahasiswaMapper mapper;
    private MahasiswaPdf pdf;

    public MahasiswaController(MahasiswaView view, MahasiswaMapper mapper, MahasiswaPdf pdf) {
        this.view = view;
        this.mapper = mapper;
        this.pdf = pdf;

        this.view.addAddMahasiswaListener(new AddMahasiswaListener());
        this.view.addUpdateMahasiswaListener(new UpdateMahasiswaListener());
        this.view.addDeleteMahasiswaListener(new DeleteMahasiswaListener());
        this.view.addRefreshListener(new RefreshListener());
        this.view.addExportListener(new ExportListener());
    }

    class AddMahasiswaListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = view.getName();
        String email = view.getEmail();
        String nimStr = view.getNim();
        String jurusan = view.getJurusan();

        if (!name.isEmpty() && !email.isEmpty() && !nimStr.isEmpty() && !jurusan.isEmpty()) {
            try {
                int nim = Integer.parseInt(nimStr);  // Mengubah nim menjadi int
                Mahasiswa mahasiswa = new Mahasiswa();
                mahasiswa.setNama(name);
                mahasiswa.setEmail(email);
                mahasiswa.setNim(nim);
                mahasiswa.setJurusan(jurusan);
                mapper.insertMahasiswa(mahasiswa);
                JOptionPane.showMessageDialog(view, "Mahasiswa added successfully!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(view, "Please enter a valid NIM.");
            }
        } else {
            JOptionPane.showMessageDialog(view, "Please fill in all fields.");
        }
    }
}

    class UpdateMahasiswaListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedId = view.getSelectedMahasiswaId();
        if (selectedId != -1) {
            String name = view.getName();
            String email = view.getEmail();
            String nimStr = view.getNim();
            String jurusan = view.getJurusan();

            if (!name.isEmpty() && !email.isEmpty() && !nimStr.isEmpty() && !jurusan.isEmpty()) {
                try {
                    int nim = Integer.parseInt(nimStr);
                    Mahasiswa mahasiswa = new Mahasiswa();
                    mahasiswa.setId(selectedId);
                    mahasiswa.setNama(name);
                    mahasiswa.setEmail(email);
                    mahasiswa.setNim(nim);
                    mahasiswa.setJurusan(jurusan);
                    mapper.updateMahasiswa(mahasiswa);
                    JOptionPane.showMessageDialog(view, "Mahasiswa updated successfully!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(view, "Please enter a valid NIM.");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Please fill in all fields.");
            }
        } else {
            JOptionPane.showMessageDialog(view, "Please select a mahasiswa to update.");
        }
    }
}



    class DeleteMahasiswaListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedId = view.getSelectedMahasiswaId();
        if (selectedId != -1) {
            int confirmation = JOptionPane.showConfirmDialog(view, 
                "Are you sure you want to delete this mahasiswa?", 
                "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if (confirmation == JOptionPane.YES_OPTION) {
                mapper.deleteMahasiswa(selectedId);
                JOptionPane.showMessageDialog(view, "Mahasiswa deleted successfully!");
                // Perbarui tampilan list
                new RefreshListener().actionPerformed(null);
            }
        } else {
            JOptionPane.showMessageDialog(view, "Please select a mahasiswa to delete.");
        }
    }
}



    class RefreshListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<Mahasiswa> mahasiswas = mapper.getAllMahasiswa();
            String[] mahasiswaArray = mahasiswas.stream()
                    .map(m -> m.getNama() + " (" + m.getEmail() + ")")
                    .toArray(String[]::new);
            view.setMahasiswaList(mahasiswaArray);
        }
    }

    class ExportListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<Mahasiswa> mahasiswas = mapper.getAllMahasiswa();
            pdf.exportPdf(mahasiswas);
            JOptionPane.showMessageDialog(view, "Mahasiswa data exported to PDF.");
        }
    }
}