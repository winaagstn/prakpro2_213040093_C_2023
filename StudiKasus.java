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
import java.util.List;

/**
 *
 * @author wina agustina
 */

// Berfungsi untuk membuat bingkai (frame) baru pada GUI Java
public class StudiKasus extends JFrame{
    public StudiKasus(){
//        Berfungsi menambahkan listener pada Windows atau jendela
        addWindowListener(new WindowAdapter() {
//            Berfungsi untuk menutup jendela saat mengklik tombol X pada jendela 
            public void windowClosing(WindowEvent e) {
//                Jika klik tombol exit (X) akan tampil pesan
                int exit = JOptionPane.showConfirmDialog(null,
                        "Apakah anda yakin ingin keluar?", "Keluar",
                        JOptionPane.YES_NO_OPTION);
//                Jika tekan Ya, maka kita akan keluar dari jendela
                if (exit == JOptionPane.YES_OPTION) {
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } else {
//                    Jika tekan tidak, maka kita akan tetap pada jendela
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

//        Berfungsi untuk membuat button atau tombol   
        JButton editButton = new JButton("Edit");
        editButton.setBounds(135, 340, 110, 40);
        
//        Berfungsi untuk membuat button atau tombol   
        JButton hapusButton = new JButton("Hapus");
        hapusButton.setBounds(255, 340, 110, 40);
        
//        Berfungsi untuk membuat button atau tombol   
        JButton simpanFile = new JButton("Simpan ke File");
        simpanFile.setBounds(15, 390, 350, 40);
        
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
        
//        Berfungsi untuk menambahkan listener untuk event aksi pada button 
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

//                Jika ada data yang kosong akan muncul pesan
                if (nama.isEmpty() || telepon.isEmpty() || alamat.isEmpty()) {
                    JOptionPane.showMessageDialog(StudiKasus.this, "Semua Data Harus Terisi!", "Warning",
                            JOptionPane.WARNING_MESSAGE);
//                    Jika semua data telah terisi,
                } else {
//                    Muncul pilihan 
                    int confirmation = JOptionPane.showConfirmDialog(StudiKasus.this,
                            "Masukan Data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
//                    Jika Ya, maka akan menampilkan data ke arrayList pada tabel
                    if (confirmation == JOptionPane.YES_OPTION) {
                        tableModel.add(new ArrayList<>(Arrays.asList(nama, telepon, jenisKelamin, alamat)));
                        textFieldNama.setText("");
                        textFieldTelepon.setText("");
                        txtOutput.setText("");
//                    Jika memilih Tidak pada confirm dialog akan muncul pesan
                    } else {
                        JOptionPane.showMessageDialog(StudiKasus.this, "Anda tidak memasukan data");
                    }
                }                                             
            }
        });
        
//        Berfungsi untuk menambahkan listener untuk event aksi pada button         
//        Button belum berfungsi dengan baik, belum menampilkan data yang telah diedit ke tabel         
//        Hanya memunculkan pesan konfirmasi jika kita klik tombol edit, tanpa ada perubahan pada data pada tabel        
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                Memilih baris yang akan diedit
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
//                    Memasukan data pada list
                    List<String> data = tableModel.getRowData(selectedRow);
                    int confirmation = JOptionPane.showConfirmDialog(StudiKasus.this,
                            "Edit data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
//                    Jika memilih Ya
                    if (confirmation == JOptionPane.YES_OPTION) {
//                        Menampilkan text yang telah diisikan dan diubah dengan data baru 
                        textFieldNama.setText(data.get(0));
                        textFieldTelepon.setText(data.get(1));
                        String jenisKelamin = data.get(2);
                        if (jenisKelamin.equals("Laki-laki")){
                            radioButton1.setSelected(true);
                        } else if (jenisKelamin.equals("Perempuan")){
                            radioButton2.setSelected(true);
                        }
                        txtOutput.setText(data.get(3)); 
                    }else{
//                       Jika memilih Tidak pada confirm dialog akan muncul pesan
                        JOptionPane.showMessageDialog(StudiKasus.this, "Anda tidak mengedit data apapun!");
                    }
//                    Jika belum memilih baris yang akan diedit akan muncul pesan  
                } else{
                    JOptionPane.showMessageDialog(StudiKasus.this, "Pilih baris untuk diedit!");
                }
            }
        });

//        Berfungsi untuk menambahkan action Listener pada tombol hapus
//        Fungsi ini telah berjalan dan bisa menghapus data yang diinginkan  
        hapusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                Memilih baris mana yang akan dihapus
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0){
                    int confirmation = JOptionPane.showConfirmDialog(StudiKasus.this,
                            "Hapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
//                    Jika memilih opsi YES atau Ya, maka data pada tabel yang dipilih terhapus
                    if (confirmation == JOptionPane.YES_OPTION) {
                        tableModel.removeRow(selectedRow);
                    } 
//                    Jika belum memilih baris yang akan dihapus maka akan muncul pesan 
                } else {
                    JOptionPane.showMessageDialog(StudiKasus.this, "Pilih baris untuk dihapus", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }  
        });

//        Berfungsi untuk membuat action Listener pada tompol Simpan File
//        Belum diisi apa-apa dan tombol belum berfungsi
        simpanFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        
        this.add(headerLabel); //Menambahkan headerLabel pada JFrame
        this.add(labelNama); //Menambahkan labelNama pada JFrame
        this.add(textFieldNama); //Menambahkan texFieldNama pada JFrame
        this.add(labelTelepon); //Menambahkan labelTelepon pada JFrame
        this.add(textFieldTelepon); //Menambahkan textFieldTelepon pada JFrame
        this.add(labelRadio); //Menambahkan labelRadio pada JFrame
        this.add(radioButton1); //Menambahkan radioButton pada JFrame
        this.add(radioButton2); //Menambahkan radioButton2 pada JFrame
        this.add(labelAlamat); //Menambahkan labelAlamat pada JFrame
        this.add(txtOutput); //Menambahkan txtOutput atau output untuk alamat pada JFrame
        this.add(button); //Menambahkan tombol Tambahkan pada JFrame
        this.add(scrollableTable); //Menambahkan pane dengan scrollabelTable
        this.add(editButton); //Menambahkan tombol Edit pada JFrame
        this.add(hapusButton); //Menambahkan tombol Hapus pada JFrame
        this.add(simpanFile); //Menambahkan tombol Simpan File pada JFrame

//        Berfungsi untuk membuat label untuk menampilkan suatu text 
        this.setSize(400,700);
        this.setLayout(null);       
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
}
