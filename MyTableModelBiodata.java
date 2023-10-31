/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan7;//Mendefinisikan paket (package)'pertemuan7' untuk kelas ini

/**
 *
 * @author user
 */
import javax.swing.table.*;// Import semua class dari javax.swing.table
import java.util.ArrayList;// Import class ArrayList dari java.util
import java.util.List;// Import class List dari java.util

public class MyTableModelBiodata extends AbstractTableModel {// Mendeklarasikan kelas 'MyTableModelBiodata' yang merupakan turunan dari kelas AbstractTableModel
    private String[] columnNames = {"Nama", "Nomor HP", "Jenis Kelamin","Alamat"};// Mendefinisikan nama kolom dalam tabel
    private ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();// Inisialisasi struktur data untuk menyimpan data tabel
    
     // Fungsi untuk tambah coloumn
    public int getColumnCount() {
        return columnNames.length;// mengembalikan ukuran array
    }
    // Fungsi untuk tambah jumlah baris
    public int getRowCount() {
        return data.size(); //mengembalikan data dari arraylist
    }
    
    // Fungsi untuk mendapatkan nama dari kolom yang dipilih dari parameter
    public String getColumnName(int col) {
        return columnNames[col]; // mengembalikan elemen coloum dnegan index
    }
    
    // Fungsi untuk mendapatkan nilai sari baris dan kolom tertentu
    public Object getValueAt(int row, int col) {
        List<String> rowItem = data.get(row); // mengambil sebuah List dari data pada indeks row dan menyimpannya dalam variabel rowItem
        return rowItem.get(col); // mengembalikan elemen rowItem dari index col
    }
    
    // Metode untuk menentukan apakah sel dalam tabel dapat diedit
    public boolean isCellEditable(int row, int col) { 
        return false;  // Kembalikan nilai false
    }
    
    // Method untuk menambah nilai ke table
    public void add(ArrayList<String> value) {
        data.add(value); // Menambahkan input user ke ArrayList data
        fireTableRowsInserted(data.size() - 1, data.size() - 1);// Menambahkan elemen-elemen ArrayList data ke table
    }
    
    // Metode untuk menghapus baris dari model tabel
    public void remove(int rowIndex) {
        data.remove(rowIndex); // Menghapus baris pada indeks tertentu dari model data
        fireTableRowsDeleted(rowIndex,rowIndex); // Memberi tahu model tabel bahwa baris telah dihapus
    }
    
    //method untuk mendapatkan data dari baris tertentu dalam tabel.
    public ArrayList<String> getDataAt (int rowIndex) {
        if(rowIndex >= 0 && rowIndex < data.size()) { // Memeriksa apakah indeks baris (rowIndex) valid
            return data.get(rowIndex); // Mengembalikan data dari baris yang sesuai dengan indeks
        }
        return null; // Jika indeks tidak valid, mengembalikan nilai null
    }
    
    //method untuk memperbarui data pada baris tertentu dalam tabel.
    public void update(int rowIndex, ArrayList <String> updatedData){
        if (rowIndex >= 0 && rowIndex < data.size()) { // Memeriksa apakah indeks baris (rowIndex) valid
            data.set(rowIndex,updatedData);// Mengganti data pada indeks baris yang diberikan dengan data yang diperbarui
            
            fireTableRowsUpdated(rowIndex ,rowIndex); // Memberi tahu model tabel bahwa baris tersebut telah diperbarui
        }
    }
    
    // method untuk menghapus semua data dari model tabel
     public void clearData() {
        int size = data.size(); // Mendapatkan jumlah baris saat ini
        data.clear();  // Menghapus semua data dari ArrayList
        fireTableRowsDeleted(0,size - 1); // Memberi tahu model tabel bahwa semua baris telah dihapus
     }
}

