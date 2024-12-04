/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package datamahasiswa;


/**
 *
 * @author Dell
 */
//@Entity
//@Table(name = "tbl_karyawan")
//public class ModelMahasiswa {
//    @Id
//    @Column(name = "no_karyawan")
//    private String nomor_karyawan;
//    
//    @Column(name = "nama")
//    private String nama;
//    
//    @Column(name = "jabatan")
//    private String jabatan;
//    
//    @Column(name = "status")
//    private boolean status;
//    
//    // Konstruktor tanpa parameter yang dibutuhkan oleh Hibernate
//    public ModelMahasiswa() {
//        
//    }
//
//    // Konstruktor dengan parameter untuk inisialisasi objek
//    public ModelMahasiswa(String nomor_karyawan, String nama, String jabatan, boolean status) {
//        this.nomor_karyawan = nomor_karyawan;
//        this.nama = nama;
//        this.jabatan = jabatan;
//        this.status = status;
//    }
//
//    // Getter dan setter
//    public String getNomor() {
//        return nomor_karyawan;
//    }
//
//    public String getNama() {
//        return nama;
//    }
//
//    public void setNama(String nama) {
//        this.nama = nama;
//    }
//
//    public String getJabatan() {
//        return jabatan;
//    }
//
//    public void setJabatan(String jabatan) {
//        this.jabatan = jabatan;
//    }
//
//    public Boolean isStatus() {
//        return status;
//    }
//
//    public void setStatus(boolean status) {
//        this.status = status;
//    }
//}



public class ModelMahasiswa {
   
    private String nomor_karyawan;
    
   
    private String nama;
    
   
    private String jabatan;
    
    
    private boolean status;
    
    // Konstruktor tanpa parameter yang dibutuhkan oleh Hibernate
    public ModelMahasiswa() {
        
    }

    // Konstruktor dengan parameter untuk inisialisasi objek
    public ModelMahasiswa(String nomor_karyawan, String nama, String jabatan, boolean status) {
        this.nomor_karyawan = nomor_karyawan;
        this.nama = nama;
        this.jabatan = jabatan;
        this.status = status;
    }

    // Getter dan setter
    public String getNomor() {
        return nomor_karyawan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public Boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
