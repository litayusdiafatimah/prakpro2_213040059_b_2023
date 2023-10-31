/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan7; //Mendefinisikan paket (package)'pertemuan7' untuk kelas ini
import java.awt.event.*; // Import semua class dari java.awt.event
import javax.swing.*; // Import semua class dari javax.swing
import javax.swing.table.*; // Import semua class dari javax.swing.table
import java.util.*; // Import semua class dari java.util
import java.io.FileWriter; //import semua class dari java.io.FileWriter
import java.io.IOException;//import semua class dari java.io.IOException
import java.io.File;//import semua class dari java.io.File
import javax.swing.JOptionPane;//import semua Class dari javax.swing.JOptionPane

/**
 *
 * @author user
 */

public class Biodata extends JFrame { // Mendeklarasikan kelas 'Biodata' yang merupakan turunan dari kelas JFrame
    private boolean checkBoxSelected; // Mendeklarasikan variabel boolean 'checkBoxSelected'
    private static final long serialVersionUID = 1L; // Mendefinisikan serialVersionUID untuk kompatibilitas serialisasi
    
    // Memeriksa apakah suatu string hanya mengandung angka
    private boolean isNumeric(String str) {
        return str.matches("\\d+");
    }
    public Biodata() { // Konstruktor kelas 'Biodata'
        this.checkBoxSelected = false; // mengatur nilai awal checkBoxSelected menjadi False
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Method untuk menutup frame ketika tombol X ditekan
       
        JLabel labelNama = new JLabel("Nama: "); //membuat JLabel dengan nama labelInput yan gdiberikan "nama : "
        labelNama.setBounds(15, 40, 350, 10); // mengatur x,y panjang dan lebar

        JTextField textFieldNama = new JTextField(); // membuat JTextField dengan nama textField
        textFieldNama.setBounds(15, 60, 350, 30); // mengatur x,y panjang dan lebar

        JLabel labelTelepon = new JLabel("Nomor Telepon: ");//membuat JLabel dengan nama labelteleepon yan gdiberikan "telepon : "
        labelTelepon.setBounds(15, 100, 350, 15); // mengatur x,y panjang dan lebar

        JTextField textFieldTelepon = new JTextField(); // membuat JTextField dengan nama textFieldTelepon
        textFieldTelepon.setBounds(15, 120, 350, 30); // mengatur x,y panjang dan lebar

        // Instansiasi JLabel dengan nama labelInput yang diberikan nilai "Jenis Kelamin:"
        JLabel labelRadio = new JLabel("Jenis Kelamin:"); // membuat labelRadio dengan JLabel 
        labelRadio.setBounds(15, 160, 350, 10); // mengatur x,y panjang dan lebar

        JRadioButton radioButton1 = new JRadioButton("Laki-Laki", true); // membuat JRadioButton dengan nama button yang diberikan nilai "laki-laki"
        radioButton1.setBounds(15, 180, 350, 30);// mengatur x,y panjang dan lebar

        JRadioButton radioButton2 = new JRadioButton("Perempuan"); // membuat JRadioButton dengan nama button yang diberikan nilai "perempuan"
        radioButton2.setBounds(15, 205, 350, 30);// mengatur x,y panjang dan lebar
        
        ButtonGroup bg = new ButtonGroup();// Membuat grup tombol radio
        bg.add(radioButton1); // Menambahkan tombol radio 1 ke dalam grup
        bg.add(radioButton2);// Menambahkan tombol radio 2 ke dalam grup
        
        JLabel labelAlamat = new JLabel ("Alamat : ");// membuat labelAlamat dengan JLabel
        labelAlamat.setBounds(15, 230, 350, 30);
        
        JTextField textFieldAlamat = new JTextField(); // membuat JTextField dengan nama textFieldTelepon
        textFieldAlamat.setBounds(15, 260, 365, 70); // mengatur x,y panjang dan lebar
        

        // Instansiasi JButton dengan nama button yang diberikan nilai "Simpan"
        JButton button = new JButton("Simpan");
        button.setBounds(15, 340, 80, 40);// mengatur x,y panjang dan lebar
        // Instansiasi JButton dengan nama button yang diberikan nilai "ubah"
        JButton button1 = new JButton("Ubah");
        button1.setBounds(100, 340, 80, 40);
        // Instansiasi JButton dengan nama button yang diberikan nilai "Hapus"
        JButton button2 = new JButton("Hapus");
        button2.setBounds(185, 340, 80, 40);
        // Instansiasi JButton dengan nama button yang diberikan nilai "Simpan ke file"
        JButton button3 = new JButton("Simpan ke File");
        button3.setBounds(270, 340, 120, 40);
        
        
        // Instansiasi JTable dengan nama table
        JTable table = new JTable();
        // Instansiasi JScrollPane dengan nama scrollableTable yang diberikan ke objek table
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 390,365, 200);
        
        // Instansiasi LatihanMyTableModel dengan nama tableModel
        MyTableModelBiodata tableModel = new  MyTableModelBiodata();
        // Atur model dari table dengan objek tableModel
        table.setModel(tableModel);

        
        // Menambahkan action listener ke button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {    // Method untuk menerima event
                
                // Menampilkan dialog konfirmasi
                int confirmation = JOptionPane.showConfirmDialog(Biodata.this, 
                        "Apakah anda yakin ingin menyimpan data?", "konfirmasi", JOptionPane.YES_NO_OPTION);
                
                // Jika pengguna mengonfirmasi "YES"
                if (confirmation == JOptionPane.YES_OPTION){
                     String jenisKelamin = ""; // Inisialisasi variabel jenisKelamin

                if (radioButton1.isSelected()) { // Jika radioButton1 diklik
                    // Maka jenisKelamin akan bernilai Laki-Laki
                    jenisKelamin = radioButton1.getText();
                    // Kembalikan radio button ke kondisi semula
                    radioButton1.setSelected(false);
                }
               
                if (radioButton2.isSelected()) { // Jika radioButton2 diklik
                    // Maka jenisKelamin akan bernilai Perempuan
                    jenisKelamin = radioButton2.getText();
                    // Kembalikan radio button ke kondisi semula
                    radioButton2.setSelected(false);
                }

                // Variable nama untuk menyimpan nilai dari objek textFieldNama (nama)
                String nama = textFieldNama.getText();
                // Variable telepon untuk menyimpan nilai dari objek textFieldTelepon (telepon)
                String telepon = textFieldTelepon.getText();
                // Variable Alamat untuk menyimpan nilai dari objek textFieldAlamat (alamat)
                String alamat = textFieldAlamat.getText();
               
                
                 if(nama.isEmpty()){ // Jika input nama kosong, tampilkan pesan peringatan
                        JOptionPane.showMessageDialog(Biodata.this, "Nama tidak Boleh kosong", "Peringatan",JOptionPane.WARNING_MESSAGE);
                    } else if(telepon.isEmpty()){ // Jika input nomor hp kosong, tampilkan pesan peringatan
                        JOptionPane.showMessageDialog(Biodata.this, "Nomor hp tidak Boleh kosong", "Peringatan",JOptionPane.WARNING_MESSAGE);
                    } else if(alamat.isEmpty()){  // Jika input alamat kosong, tampilkan pesan peringatan
                        JOptionPane.showMessageDialog(Biodata.this, "Alamat tidak Boleh kosong", "Peringatan",JOptionPane.WARNING_MESSAGE);
                    }   else if (!isNumeric(telepon)) {  // Jika nomor hp tidak berisi angka, tampilkan pesan peringatan
                        JOptionPane.showMessageDialog(null, "Nomor HP harus berisi angka.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    }else {
                         // Jika semua input valid, tambahkan data ke model tabel
                        tableModel.add(new ArrayList<>(Arrays.asList(nama, telepon, jenisKelamin, alamat)));
                
                        textFieldNama.setText("");    // Kembalikan isi textFieldNama ke kondisi kosong
                        textFieldTelepon.setText(""); // Kembalikan isi textFieldTelepon ke kondisi kosong
                        textFieldAlamat.setText("");  // Kembalikan isi textFieldAlamat ke kondisi kosong
                        
                        // Tampilkan pesan bahwa data berhasil disimpan
                        JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Info", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
          // Menambahkan action listener ke button
       button1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {  
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            String nama = (String) tableModel.getValueAt(selectedRow, 0);         
            String nomorHp = (String) tableModel.getValueAt(selectedRow, 1);      
            String jenisKelamin = (String) tableModel.getValueAt(selectedRow, 2); 
            String alamat = (String) tableModel.getValueAt(selectedRow, 3);
            
            textFieldNama.setText(nama);       
            textFieldTelepon.setText(nomorHp); 
            if (jenisKelamin.equals("Laki-Laki")) {
                radioButton1.setSelected(true);
            } else {
                radioButton2.setSelected(true);
            }
            textFieldAlamat.setText(alamat); 
            tableModel.remove(selectedRow);
            JOptionPane.showMessageDialog(null, "Data berhasil disalin ke formulir. Klik Simpan jika sudah selesai mengedit.", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Pilih data yang ingin Anda edit terlebih dahulu.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }
});       
//       menambahkan button2 kedalam actionlistener
       button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    tableModel.remove(selectedRow); // Notifikasi setelah data dihapus
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus", "Info", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Notifikasi jika tidak ada data yang dipilih
                    JOptionPane.showMessageDialog(null, "Pilih data yang ingin Anda hapus terlebih dahulu.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
//       menambahkan button3 kedalam action listener
         button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String filePath = "C:\\Users\\user\\Documents\\NetBeansProjects\\HelloWorld\\src\\pertemuan7\\file.txt";
                    
                    File file = new File(filePath);

                    // membuat FileWriter untuk input data ke file
                    FileWriter writer = new FileWriter(file);

                    for (int i = 0; i < tableModel.getRowCount(); i++) {
                        for (int j = 0; j < tableModel.getColumnCount(); j++) {
                            writer.write(tableModel.getValueAt(i, j).toString());
                            writer.write("\t");
                        }
                        writer.write("\n"); 
                    }

                    writer.close();
                    JOptionPane.showMessageDialog(null, "Data berhasil disimpan ke file", "Info", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menyimpan ke file.", "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });
         
       this.addWindowListener(new WindowAdapter() { //Membuat objek WindowAdapter dan menambahkannya sebagai listener ke jendela.
            @Override
            public void windowClosing(WindowEvent e) { //Override metode windowClosing yang akan dipanggil saat jendela ditutup.
                //Menampilkan dialog konfirmasi saat menutup jendela.
                int confirm = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) { //Jika pengguna memilih "Ya" dalam dialog konfirmasi, maka program akan keluar.
                    System.exit(0); 
                }
            }
        });

        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Menonaktifkan penutup jendela
       
        this.add(labelNama);// Menambahkan objek labelNama ke frame
        this.add(textFieldNama); // Menambahkan objek textFieldNama ke frame
        this.add(labelTelepon);// Menambahkan objek labelTelepon ke frame
        this.add(textFieldTelepon);// Menambahkan objek textFieldTelepon ke frame
        this.add(labelRadio);// Menambahkan objek labelRadio ke frame
        this.add(radioButton1);// Menambahkan objek radioButton1 ke frame
        this.add(radioButton2);// Menambahkan objek radioButton2 ke frame
        this.add(labelAlamat);// Menambahkan objek labelAlamat ke frame
        this.add(textFieldAlamat);;// Menambahkan objek textFieldAlamat ke frame
        this.add(button);// untuk menambahkan button ke dalam frame
        this.add(button1);// untuk menambahkan button1 ke dalam frame
        this.add(button2);// untuk menambahkan button2 ke dalam frame
        this.add(button3);// untuk menambahkan button3 ke dalam frame
        this.add(scrollableTable);// Menambahkan objek scrollableTable ke frame
        
        this.setSize(500, 700);// Menetapkan ukuran jendela
        this.setLayout(null);// Menggunakan tata letak bebas
    }
    
    // Main program
    public static void main(String[] args) {
        // Method invokeLater dari SwingUtilities untuk menjalankan objek Runnable yang berguna menangani event dan update UI
        SwingUtilities.invokeLater(new Runnable() {
            // Override method run dari Runnable
            public void run() {
                // Instansiasi Latihan4 dengan nama h
                Biodata b = new Biodata();
                // Tampilkan objek h dengan method setVisible dan parameternya true
                b.setVisible(true);
            }
        });
    }
   }



