/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.HangHoaDAO;
import DAO.NhaCungCapDAO;
import DTO.ChiTietPhieuNhap;
import DTO.HangHoa;
import DTO.NhaCungCap;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Quang
 */
public class DanhSachNhapHangJFrame extends javax.swing.JFrame {
    ArrayList<HangHoa> listHH;
    NhapHangJPanel nhapHang;
    /**
     * Creates new form DanhSachNhapHangJFrame
     */
    public DanhSachNhapHangJFrame(NhapHangJPanel nhapHangJPanel) {
        initComponents();
        this.nhapHang = nhapHangJPanel;
        loadComboBoxNCC();   
        NhaCungCap ncc = (NhaCungCap) jcbNCC.getSelectedItem();
        loadHHTheoMaNCC(ncc.getMaNCC());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnView = new javax.swing.JPanel();
        jspHangHoa = new javax.swing.JScrollPane();
        jtHangHoa = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnNhap = new javax.swing.JButton();
        btnNhapAll = new javax.swing.JButton();
        jcbNCC = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtHangHoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtHangHoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtHangHoaMouseClicked(evt);
            }
        });
        jspHangHoa.setViewportView(jtHangHoa);

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnViewLayout.createSequentialGroup()
                .addComponent(jspHangHoa)
                .addGap(0, 0, 0))
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jspHangHoa, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DANH SÁCH HÀNG HÓA CẦN NHẬP");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnNhap.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnNhap.setText("Nhập");
        btnNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapActionPerformed(evt);
            }
        });

        btnNhapAll.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnNhapAll.setText("Nhập hết");
        btnNhapAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapAllActionPerformed(evt);
            }
        });

        jcbNCC.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbNCCItemStateChanged(evt);
            }
        });
        jcbNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbNCCActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nhà cung cấp");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(255, 255, 255)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jcbNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(btnNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(btnNhapAll)
                                .addGap(0, 51, Short.MAX_VALUE)))
                        .addGap(328, 328, 328))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNhapAll, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcbNCC))
                .addGap(35, 35, 35)
                .addComponent(jpnView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    void loadHHTheoMaNCC(String MaNCC) {
        listHH = HangHoaDAO.getInstance().getListHangHoaByNCC(MaNCC);
        String[] header = {"Mã hàng hóa", "Mã nhóm hàng", "Mã nhà cung cấp", "Tên hàng hóa", "DVT", "Giá bán", "Hệ số", "Giá nhập", "Hình Ảnh", "Số lượng tồn"};        
        
        listHH = HangHoaDAO.getInstance().getListHangHoaCanNhapByNCC(MaNCC);
        
        DefaultTableModel modelTableDb = new DefaultTableModel(header, 0) {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };

        for (HangHoa hh : listHH) {
            Object[] row = {hh.getMaHang(), hh.getMaNhomHang(), hh.getMaNCC(), hh.getTenHang(), hh.getdVT(), hh.getGiaBan(), hh.getHeSo(), hh.getGiaNhap(), hh.getHinhAnh(), hh.getSoLuongTon()};
            modelTableDb.addRow(row);
        }

        TableRowSorter<TableModel> rowSorter = null;

        jtHangHoa.setModel(modelTableDb);
        jtHangHoa.setRowSorter(rowSorter);

        jtHangHoa.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        jtHangHoa.setFont(new Font("Arial", Font.PLAIN, 14));
        jtHangHoa.getTableHeader().setPreferredSize(new Dimension(100, 50));
        jtHangHoa.setRowHeight(50);
        jtHangHoa.validate();
        jtHangHoa.repaint();

        jspHangHoa.setPreferredSize(new Dimension(1350, 400));

        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(jspHangHoa);
        jpnView.validate();
        jpnView.repaint();
    }
    private void loadComboBoxNCC() {
        DefaultComboBoxModel<NhaCungCap> model = new DefaultComboBoxModel<>();        
        List<NhaCungCap> listNCC = NhaCungCapDAO.getInstance().getListNhaCungCap(1);

        for (NhaCungCap ncc : listNCC) {
            model.addElement(ncc);
        }
        jcbNCC.setModel(model);
    }
    
    public ArrayList<ChiTietPhieuNhap> getAllDataFromJTable() {
        ArrayList<ChiTietPhieuNhap> data = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) jtHangHoa.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap();
            ctpn.setMaHang((String) model.getValueAt(i, 0));
            ctpn.setTenHang((String) model.getValueAt(i, 3));
            ctpn.setSoLuong(1);
            ctpn.setDVT((String) model.getValueAt(i, 4));
            ctpn.setGiaNhap((double) model.getValueAt(i, 7));
            ctpn.setThanhTien((double) model.getValueAt(i, 7));
            data.add(ctpn);
        }
        return data;
    }
    
    public ArrayList<ChiTietPhieuNhap> getDataFromSelectedRows() {
        ArrayList<ChiTietPhieuNhap> data = new ArrayList<>();
        int[] selectedRows = jtHangHoa.getSelectedRows();
        DefaultTableModel model = (DefaultTableModel) jtHangHoa.getModel();

        for (int row : selectedRows) {
            ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap();
            ctpn.setMaHang((String) model.getValueAt(row, 0));
            ctpn.setTenHang((String) model.getValueAt(row, 3));
            ctpn.setSoLuong(1);
            ctpn.setDVT((String) model.getValueAt(row, 4));
            ctpn.setGiaNhap((double) model.getValueAt(row, 7));
            ctpn.setThanhTien((double) model.getValueAt(row, 7));
            data.add(ctpn);
        }

        return data;
    }
    
    private void jtHangHoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtHangHoaMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jtHangHoaMouseClicked

    private void btnNhapAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapAllActionPerformed
        // TODO add your handling code here:
        ArrayList<ChiTietPhieuNhap> listCTPN = getAllDataFromJTable();  
        DefaultTableModel model = (DefaultTableModel) jtHangHoa.getModel();        
        String MaNCC = (String) model.getValueAt(0, 2);        
        nhapHang.receiveDataFromDanhSachNHJFrame(listCTPN, MaNCC);
    }//GEN-LAST:event_btnNhapAllActionPerformed

    private void jcbNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbNCCActionPerformed
        // TODO add your handling code here:
        NhaCungCap ncc = (NhaCungCap) jcbNCC.getSelectedItem();
        loadHHTheoMaNCC(ncc.getMaNCC());
        
        
    }//GEN-LAST:event_jcbNCCActionPerformed

    private void jcbNCCItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbNCCItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jcbNCCItemStateChanged

    private void btnNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapActionPerformed
        // TODO add your handling code here:
        ArrayList<ChiTietPhieuNhap> listCTPN = getDataFromSelectedRows();    
        DefaultTableModel model = (DefaultTableModel) jtHangHoa.getModel();        
        String MaNCC = (String) model.getValueAt(0, 2);
        nhapHang.receiveDataFromDanhSachNHJFrame(listCTPN, MaNCC);
    }//GEN-LAST:event_btnNhapActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNhap;
    private javax.swing.JButton btnNhapAll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox<NhaCungCap> jcbNCC;
    private javax.swing.JPanel jpnView;
    private javax.swing.JScrollPane jspHangHoa;
    private javax.swing.JTable jtHangHoa;
    // End of variables declaration//GEN-END:variables
}
