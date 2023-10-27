/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas;
import Swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import java.io.*;

/**
 *
 * @author wina agustina
 */

// Berfungsi untuk membuat bingkai (frame) baru pada GUI Java
public class StudiKasus extends JFrame{
    public StudiKasus(){
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int exit = JOptionPane.showConfirmDialog(null,
                        "Apakah anda yakin ingin keluar?", "Keluar",
                        JOptionPane.YES_NO_OPTION);
                if (exit == JOptionPane.YES_OPTION) {
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } else {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
        
//        Berfungsi untuk membuat label di awal tampilan dengan posisi tengah
        JLabel headerLabel = new JLabel("Form Biodata", JLabel.CENTER);
        headerLabel.setBounds(15, 15, 350, 20);
        
//        Berfungsi untuk membuat label untuk menampilkan suatu text         
        JLabel labelNama = new JLabel("Nama :");
        labelNama.setBounds(15,40,350,10);
//        Berfungsi untuk membuat textfield untuk menampilkan satu baris text 
        JTextField textFieldNama = new JTextField();
        textFieldNama.setBounds(15,60,350,30);

//        Berfungsi untuk membuat label untuk menampilkan suatu text         
        JLabel labelTelepon = new JLabel("Nomor HP :");
        labelTelepon.setBounds(15,100,350,10);
//        Berfungsi untuk membuat textfield untuk menampilkan satu baris text 
        JTextField textFieldTelepon = new JTextField();
        textFieldTelepon.setBounds(15,120,350,30);
       
//        Berfungsi untuk membuat label untuk menampilkan suatu text 
        JLabel labelRadio = new JLabel("Jenis Kelamin :");
        labelRadio.setBounds(15,160,350,10);
//        Berfungsi untuk membuat button bentuk lingkaran
        JRadioButton radioButton1 = new JRadioButton("Laki-laki", true);
        radioButton1.setBounds(15,180,350,20);
//        Berfungsi untuk membuat button bentuk lingkaran
        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(15,210,350,20);
//        Berfungsi untuk menggabungkan button yang telah dibuat
        ButtonGroup bg = new ButtonGroup();
//        Berfungsi untuk menambahkan radioButton1 dan 2 pada ButtonGroup
        bg.add(radioButton1);
        bg.add(radioButton2);
                
//        Berfungsi untuk membuat label untuk menampilkan suatu text         
        JLabel labelAlamat = new JLabel("Alamat :");
        labelAlamat.setBounds(15,240,350,10);
//        Berfungsi untuk membuat text panjang
        JTextArea txtOutput = new JTextArea();
        txtOutput.setBounds(15, 260, 350, 70);
                            
//        Berfungsi untuk membuat button atau tombol
        JButton button = new JButton("Tambahkan");
        button.setBounds(15,340,110,40);
        
//        Berfungsi untuk membuat tabel
        javax.swing.JTable table = new JTable();
//        Berfungsi untuk membungkus tabel pada panel bergulir (bisa di scroll)
        JScrollPane scrollableTable = new JScrollPane(table);
//        Berfungsi untuk mengatur posisi dan ukuran pane bergulir
        scrollableTable.setBounds(15, 440, 350, 200);
        
//        Berfungsi untuk membuat tabel khusus
        MyTableModel tableModel = new MyTableModel();
//        Beerfungsi untuk mengatur model tabel
        table.setModel(tableModel);
        
//        Berfungsi untuk menambahkan lstener untuk event aksi pada button 
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
//                Mengisi string nama dengan apa yang diisikan pada textField
                String nama = textFieldNama.getText();
//                Mengisi string telepon dengan apa yang diisikan pada textField
                String telepon = textFieldTelepon.getText();
//                Berfungsi untuk mengisi jenis kelamin dengan pengkondisian
                String jenisKelamin="";      
//                Mengisi string telepon dengan apa yang diisikan pada textField
                String alamat = txtOutput.getText();
                
//                Jika memilih radioButton1, dapatkan text nya yaitu laki-laki
                if(radioButton1.isSelected()){
                    jenisKelamin = radioButton1.getText();
                }
//                Jika memilih radioButton2, dapatkan text nya yaitu perempuan
                if(radioButton2.isSelected()){
                    jenisKelamin = radioButton2.getText();
                }

//                Berfungsi untuk memunculkan pesan jika ada form yang tidak diisi
                if (nama.isEmpty() || telepon.isEmpty() || alamat.isEmpty()) {
                    JOptionPane.showMessageDialog(StudiKasus.this, "Data tidak boleh ada yang kosong!", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    int confirmation = JOptionPane.showConfirmDialog(StudiKasus.this,
                            "Masukan Data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                    if (confirmation == JOptionPane.YES_OPTION) {
                        tableModel.add(new ArrayList<>(Arrays.asList(nama, telepon, jenisKelamin, alamat)));
                        textFieldNama.setText("");
                        textFieldTelepon.setText("");
                        txtOutput.setText("");
                    } else {
                        JOptionPane.showMessageDialog(StudiKasus.this, "Anda tidak memasukan data");
                    }
                }                                             
            }
        });
        
                // Create the "Edit" button
        JButton editButton = new JButton("Edit");
        editButton.setBounds(135, 340, 110, 40);
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();

                if (selectedRow >= 0) {
                ArrayList<String> selectedData = data.get(selectedRow);
                String nama = selectedData.get(0);
                String telepon = selectedData.get(1);
                String jenisKelamin = selectedData.get(2);
                String alamat = selectedData.get(3);

                EditForm editForm = new EditForm(nama, telepon, jenisKelamin, alamat);
                int result = JOptionPane.showConfirmDialog(StudiKasus.this, editForm, "Edit Data", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    // Update the data with the edited values
                    selectedData.set(0, editForm.getEditedNama());
                    selectedData.set(1, editForm.getEditedTelepon());
                    selectedData.set(2, editForm.getEditedJenisKelamin());
                    selectedData.set(3, editForm.getEditedAlamat());

                    // Update the table model to reflect the changes
                }
                } else {
                    JOptionPane.showMessageDialog(StudiKasus.this, "Pilih baris untuk diedit", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Create the "Hapus" (Delete) button
        JButton hapusButton = new JButton("Hapus");
        hapusButton.setBounds(255, 340, 110, 40);
        hapusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();

                if (selectedRow >= 0) {
                    int confirmation = JOptionPane.showConfirmDialog(StudiKasus.this,
                            "Hapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

                    if (confirmation == JOptionPane.YES_OPTION) {
                        tableModel.removeRow(selectedRow);
                        data.remove(selectedRow);
                    }
                } else {
                    JOptionPane.showMessageDialog(StudiKasus.this, "Pilih baris untuk dihapus", "Warning", JOptionPane.WARNING_MESSAGE);
                }
                    }
                });

        // Create the "Simpan ke File" button
        JButton simpanFile = new JButton("Simpan ke File");
        simpanFile.setBounds(15, 390, 350, 40);
        simpanFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    ArrayList<ArrayList<String>> data = null;
                    saveDataToFile(data);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        this.add(headerLabel);
        this.add(labelNama); //Menambahkan labelNama pada JFrame
        this.add(textFieldNama); //Menambahkan texFieldNama pada JFrame
        this.add(labelTelepon); //Menambahkan labelTelepon pada JFrame
        this.add(textFieldTelepon); //Menambahkan textFieldTelepon pada JFrame
        this.add(labelRadio); //Menambahkan labelRadio pada JFrame
        this.add(radioButton1); //Menambahkan radioButton pada JFrame
        this.add(radioButton2); //Menambahkan radioButton2 pada JFrame
        this.add(labelAlamat);
        this.add(txtOutput);       
        this.add(button); //Menambahkan button pada JFrame
        this.add(scrollableTable); //Menambahkan pane dengan scrollabelTable
        this.add(editButton);
        this.add(hapusButton);
        this.add(simpanFile);

//        Berfungsi untuk membuat label untuk menampilkan suatu text 
        this.setSize(400,700);
        this.setLayout(null);       
    }
    
    private void saveDataToFile(ArrayList<ArrayList<String>> data) throws IOException {
        String filename = "output.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

        for (ArrayList<String> row : data) {
            String line = String.join("\t", row);
            writer.write(line);
            writer.newLine();
        }

        writer.close();
        JOptionPane.showMessageDialog(this, "Data saved to " + filename, "Info", JOptionPane.INFORMATION_MESSAGE);
    }
    
//        Berfungsi untuk menampilkan Frame dari GUI java yang telah dibuat
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                StudiKasus b = new StudiKasus();
                b.setVisible(true);
            }
        });
    }

    private static class EditForm {
        public EditForm(String nama, String telepon, String jenisKelamin, String alamat) {
            return;
        }
    }
}
