/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.HangHoaDAO;
import DTO.HangHoa;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Admin
 */
public class HangHoaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form HangHoaJPanel
     */
    public HangHoaJPanel() {
        initComponents();
        LoadKHVaoTable();
    }

    void LoadKHVaoTable() {
        String[] header = {"Mã hàng hóa", "Mã nhóm hàng", "Mã nhà cung cấp", "Tên hàng hóa", "DVT", "Giá bán", "Hệ số", "Giá nhập", "Hình Ảnh", "Số lượng tồn", "Trạng thái"};
        DefaultTableModel modelTableDb = new DefaultTableModel(header, 0) {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 10 ? Boolean.class : String.class;
            }
        };

        ArrayList<HangHoa> listHH = HangHoaDAO.getInstance().getListHangHoa();

        for (HangHoa hh : listHH) {
            Object[] row = {hh.getMaHang(), hh.getMaNhomHang(), hh.getMaNCC(), hh.getTenHang(), hh.getdVT(), hh.getGiaBan(), hh.getHeSo(), hh.getGiaNhap(), hh.getHinhAnh(), hh.getSoLuongTon(), hh.getTrangThai()};
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnThem = new javax.swing.JButton();
        jtfSearch = new javax.swing.JTextField();
        jpnView = new javax.swing.JPanel();
        jspHangHoa = new javax.swing.JScrollPane();
        jtHangHoa = new javax.swing.JTable();

        btnThem.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon-plus.png"))); // NOI18N
        btnThem.setText("Thêm mới");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jtfSearch.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

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
            .addComponent(jspHangHoa)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jspHangHoa, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 388, Short.MAX_VALUE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    int flag = 0;
    HangHoaJFrame frame = null;
    private void jtHangHoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtHangHoaMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2 && jtHangHoa.getSelectedRow() != -1) {
            if (frame != null) {
                if (frame.isDisplayable()) {
                    flag = 1;
                } else {
                    flag = 0;
                }
            }
            if (flag == 0) {
                DefaultTableModel model = (DefaultTableModel) jtHangHoa.getModel();
                int selectedRowIndex = jtHangHoa.getSelectedRow();

                selectedRowIndex = jtHangHoa.convertRowIndexToModel(selectedRowIndex);

                HangHoa hangHoa = new HangHoa();
                hangHoa.setMaHang((int) model.getValueAt(selectedRowIndex, 0));
                hangHoa.setMaNhomHang((int) model.getValueAt(selectedRowIndex, 1));
                hangHoa.setMaNCC((int) model.getValueAt(selectedRowIndex, 2));
                hangHoa.setTenHang(model.getValueAt(selectedRowIndex, 3).toString());
                hangHoa.setdVT(model.getValueAt(selectedRowIndex, 4).toString());
                hangHoa.setGiaBan((double) model.getValueAt(selectedRowIndex, 5));
                hangHoa.setHeSo((double) model.getValueAt(selectedRowIndex, 6));
                hangHoa.setGiaNhap((double) model.getValueAt(selectedRowIndex, 7));
                hangHoa.setHinhAnh(model.getValueAt(selectedRowIndex, 8).toString());
                hangHoa.setSoLuongTon((int) model.getValueAt(selectedRowIndex, 9));
                hangHoa.setTrangThai((boolean) model.getValueAt(selectedRowIndex, 10));

                frame = new HangHoaJFrame(hangHoa, 0);

                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setTitle("Thông tin hàng hóa");
                frame.setVisible(true);
            }

        }
    }//GEN-LAST:event_jtHangHoaMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if (frame != null) {
            if (frame.isDisplayable()) {
                flag = 1;
                LoadKHVaoTable();
            } else {
                flag = 0;
            }
        }
        if (flag == 0) {
            frame = new HangHoaJFrame(null, 1);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setTitle("Thông tin hàng hóa");
            frame.setVisible(true);
        }
    }//GEN-LAST:event_btnThemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThem;
    private javax.swing.JPanel jpnView;
    private javax.swing.JScrollPane jspHangHoa;
    private javax.swing.JTable jtHangHoa;
    private javax.swing.JTextField jtfSearch;
    // End of variables declaration//GEN-END:variables
}
