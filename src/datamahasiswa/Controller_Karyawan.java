package datamahasiswa;
import java.sql.*;
import javax.swing.table.DefaultTableModel;




import java.util.List;
import javax.swing.JOptionPane;

public class Controller_Karyawan {
   ;
    private static Controller_Karyawan instance;
    private Connection Con;
    
      public static Controller_Karyawan getInstance() {
        if (instance == null) {
            instance = new Controller_Karyawan();
        }
        return instance;
    }
      
    public Controller_Karyawan(){
        koneksiDatabase();
    }
    
    Connection koneksiDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/db_karyawan_netbeans", "root", "");
            return Con;
        }catch (Exception e){
            System.out.println("koneksi gagal" + e.getMessage());
            return null; 
        }
    }
   
    
    public void InsertData(String nomor_karyawan, String nama, String jabatan, boolean status){
        String sql = "INSERT INTO tbl_karyawan (no_karyawan, nama, jabatan, status) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = Con.prepareStatement(sql);
            stmt.setString(1, nomor_karyawan);
            stmt.setString(2, nama);
            stmt.setString(3, jabatan);
            stmt.setBoolean(4, status);
            stmt.executeUpdate();  // Execute insert query
        } catch (SQLException e) {
            System.out.println("Insert Gagal: " + e.getMessage());
        }
    }
    
    public void UpdateData(String nomor_karyawan, String nama, String jabatan, boolean status) {
    try {
        String sql = "UPDATE tbl_karyawan SET nama = ?, jabatan = ?, status = ? WHERE no_karyawan = ?";
        PreparedStatement pst = Con.prepareStatement(sql);
        pst.setString(1, nama);
        pst.setString(2, jabatan);
        pst.setBoolean(3, status);
        pst.setString(4, nomor_karyawan);
        
        int rowsAffected = pst.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Data updated successfully.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error updating data: " + e.getMessage());
    }
}
    
    public void DeleteData(String nomor_karyawan) {
    try {
        String sql = "DELETE FROM tbl_karyawan WHERE no_karyawan = ?";
        PreparedStatement pst = Con.prepareStatement(sql);
        pst.setString(1, nomor_karyawan);
        
        int rowsAffected = pst.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Data deleted successfully.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error deleting data: " + e.getMessage());
    }
}
    
    public DefaultTableModel showData(){
        String[] kolom = {"Nomor Karyawan", "Nama", "Jabatan", "Status"};
        String sql = "SELECT * FROM tbl_karyawan"; // SQL query to select all rows from the karyawan table
        Object[][] objData = null;

        try {
            Statement stmt = Con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(sql);  // Execute the query

            // Get the number of rows in the result set
            rs.last(); // Move to the last row to get row count
            int rowCount = rs.getRow();
            rs.beforeFirst();  // Move back to the first row

            objData = new Object[rowCount][4];
            int i = 0;
            while (rs.next()) {
                objData[i][0] = rs.getString("no_karyawan");
                objData[i][1] = rs.getString("nama");
                objData[i][2] = rs.getString("jabatan");
                objData[i][3] = rs.getBoolean("status");
                i++;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Return data as DefaultTableModel for JTable
        return new DefaultTableModel(objData, kolom);
    }
}

//    private static Controller_Karyawan instance;
//    ArrayList<ModelMahasiswa> ArrayData;
//    private SessionFactory sessionFactory;
//
//    public static Controller_Karyawan getInstance() {
//        if (instance == null) {
//            instance = new Controller_Karyawan();
//        }
//        return instance;
//    }
//
//    public Controller_Karyawan() {
//        // Initialize Hibernate SessionFactory from HibernateUtil
//        sessionFactory = HibernateUtil.getSessionFactory();
//    }
//
//    // Method to insert data into the database using Hibernate (if needed)
//
//
//    // Method to retrieve data from the database and show it in a table
//    public DefaultTableModel showData() {
//        Session session = sessionFactory.openSession();
//        List<ModelMahasiswa> karyawanList = null;
//        try {
//            session.beginTransaction();
//            // Query to get all employees
//            Query<ModelMahasiswa> query = session.createQuery("FROM ModelMahasiswa", ModelMahasiswa.class);
//            karyawanList = query.getResultList();
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//
//        // Preparing data for table display
//        String[] columnNames = {"Nomor Karyawan", "Nama", "Jabatan", "Status"};
//        Object[][] rowData = new Object[karyawanList.size()][4];
//
//        int i = 0;
//        for (ModelMahasiswa karyawan : karyawanList) {
//            rowData[i][0] = karyawan.getNomor();
//            rowData[i][1] = karyawan.getNama();
//            rowData[i][2] = karyawan.getJabatan();
//            rowData[i][3] = karyawan.isStatus() ? "Aktif" : "Tidak Aktif";
//            i++;
//        }
//
//        DefaultTableModel tableModel = new DefaultTableModel(rowData, columnNames);
//        return tableModel;
//    }
//    
//}
