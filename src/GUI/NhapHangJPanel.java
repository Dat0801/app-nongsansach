/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.HangHoaDAO;
import DAO.NhaCungCapDAO;
import DAO.NhomHangDAO;
import DAO.PhieuNhapDAO;
import DTO.ChiTietHoaDon;
import DTO.ChiTietPhieuNhap;
import DTO.ChiTietPhieuNhap;
import DTO.ChiTietPhieuNhap;
import DTO.HangHoa;
import DTO.NhaCungCap;
import DTO.NhomHang;
import DTO.PhieuNhap;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Admin
 */
public class NhapHangJPanel extends javax.swing.JPanel {

    /**
     * Creates new form NhapHangJPanel
     */
    public NhapHangJPanel() {
        initComponents();        
    }

    public ArrayList<ChiTietPhieuNhap> listCTPN = null;
    ArrayList<HangHoa> listHH;
    public JDialog dialog;
    
    private JPanel panel;
    private final Map<String, ImageIcon> loadedImages = new HashMap<>();
    
    void loadHHTheoMaNCC(String MaNCC) {
        listHH = HangHoaDAO.getInstance().getListHangHoaByNCC(MaNCC);
        if (panel == null) {
            panel = new JPanel();
            panel.setLayout(new GridLayout(0, 4, 10, 10));
        } else {
            panel.removeAll();
        }

        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (HangHoa hh : listHH) {
                    JButton btn = createButton(hh);
                    panel.add(btn);
                }
                return null;
            }

            @Override
            protected void done() {
                jpnHangHoa.removeAll();
                JScrollPane scrollPane = new JScrollPane(panel);
                scrollPane.setPreferredSize(new Dimension(700, 700));
                scrollPane.getVerticalScrollBar().setUnitIncrement(16);
                scrollPane.getHorizontalScrollBar().setUnitIncrement(16);
                jpnHangHoa.setLayout(new BorderLayout());
                jpnHangHoa.add(scrollPane, BorderLayout.CENTER);
                jpnHangHoa.revalidate();
                jpnHangHoa.repaint();
            }
        };

        worker.execute();
    }
    void loadHHTheoMaNhomHang(String MaNhomHang) {
        listHH = HangHoaDAO.getInstance().getListHangHoa(MaNhomHang);
        if (panel == null) {
            panel = new JPanel();
            panel.setLayout(new GridLayout(0, 4, 10, 10));
        } else {
            panel.removeAll();
        }

        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (HangHoa hh : listHH) {
                    JButton btn = createButton(hh);
                    panel.add(btn);
                }
                return null;
            }

            @Override
            protected void done() {
                jpnHangHoa.removeAll();
                JScrollPane scrollPane = new JScrollPane(panel);
                scrollPane.setPreferredSize(new Dimension(700, 700));
                scrollPane.getVerticalScrollBar().setUnitIncrement(16);
                scrollPane.getHorizontalScrollBar().setUnitIncrement(16);
                jpnHangHoa.setLayout(new BorderLayout());
                jpnHangHoa.add(scrollPane, BorderLayout.CENTER);
                jpnHangHoa.revalidate();
                jpnHangHoa.repaint();
            }
        };

        worker.execute();
    }
    void loadHHTheoMaNhomHangVaMaNCC(String MaNhomHang, String MaNCC) {
        listHH = HangHoaDAO.getInstance().getListHangHoaByMaNhomHangAndMaNCC(MaNhomHang, MaNCC);
        if (panel == null) {
            panel = new JPanel();
            panel.setLayout(new GridLayout(0, 4, 10, 10));
        } else {
            panel.removeAll();
        }

        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (HangHoa hh : listHH) {
                    JButton btn = createButton(hh);
                    panel.add(btn);
                }
                return null;
            }

            @Override
            protected void done() {
                jpnHangHoa.removeAll();
                JScrollPane scrollPane = new JScrollPane(panel);
                scrollPane.setPreferredSize(new Dimension(700, 700));
                scrollPane.getVerticalScrollBar().setUnitIncrement(16);
                scrollPane.getHorizontalScrollBar().setUnitIncrement(16);
                jpnHangHoa.setLayout(new BorderLayout());
                jpnHangHoa.add(scrollPane, BorderLayout.CENTER);
                jpnHangHoa.revalidate();
                jpnHangHoa.repaint();
            }
        };

        worker.execute();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtbQuanLyNhapHang = new javax.swing.JTabbedPane();
        jpnPhieuNhap = new javax.swing.JPanel();
        jpnView = new javax.swing.JPanel();
        jspCTPN = new javax.swing.JScrollPane();
        jtCTPN = new javax.swing.JTable();
        jpnHangHoa = new javax.swing.JPanel();
        btnThanhToan = new javax.swing.JButton();
        btnXoaHH = new javax.swing.JButton();
        jlbTongTien = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbNhomHang = new javax.swing.JComboBox<>();
        btnXoaTatCa = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jcbNCC = new javax.swing.JComboBox<>();
        jlbEmpName = new javax.swing.JLabel();

        jtbQuanLyNhapHang.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jtbQuanLyNhapHang.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jtbQuanLyNhapHangStateChanged(evt);
            }
        });

        jtCTPN.setModel(new javax.swing.table.DefaultTableModel(
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
        jtCTPN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCTPNMouseClicked(evt);
            }
        });
        jspCTPN.setViewportView(jtCTPN);

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jspCTPN, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jspCTPN, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jpnHangHoaLayout = new javax.swing.GroupLayout(jpnHangHoa);
        jpnHangHoa.setLayout(jpnHangHoaLayout);
        jpnHangHoaLayout.setHorizontalGroup(
            jpnHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpnHangHoaLayout.setVerticalGroup(
            jpnHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnThanhToan.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon-payments.png"))); // NOI18N
        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnXoaHH.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnXoaHH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon-delete.png"))); // NOI18N
        btnXoaHH.setPreferredSize(new java.awt.Dimension(171, 50));
        btnXoaHH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaHHActionPerformed(evt);
            }
        });

        jlbTongTien.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jlbTongTien.setText("Tổng Tiền:");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel1.setText("Nhóm Hàng");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel2.setText("Nhân viên");

        jcbNhomHang.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jcbNhomHang.setPreferredSize(new java.awt.Dimension(250, 50));
        jcbNhomHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbNhomHangActionPerformed(evt);
            }
        });

        btnXoaTatCa.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnXoaTatCa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon-delete-forever.png"))); // NOI18N
        btnXoaTatCa.setPreferredSize(new java.awt.Dimension(171, 50));
        btnXoaTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTatCaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel4.setText("Nhà cung cấp");

        jcbNCC.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jcbNCC.setPreferredSize(new java.awt.Dimension(250, 50));
        jcbNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbNCCActionPerformed(evt);
            }
        });

        jlbEmpName.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jlbEmpName.setEnabled(false);

        javax.swing.GroupLayout jpnPhieuNhapLayout = new javax.swing.GroupLayout(jpnPhieuNhap);
        jpnPhieuNhap.setLayout(jpnPhieuNhapLayout);
        jpnPhieuNhapLayout.setHorizontalGroup(
            jpnPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPhieuNhapLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnPhieuNhapLayout.createSequentialGroup()
                        .addGap(420, 420, 420)
                        .addComponent(jlbTongTien))
                    .addGroup(jpnPhieuNhapLayout.createSequentialGroup()
                        .addComponent(btnXoaHH, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoaTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlbEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jpnView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpnPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnPhieuNhapLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbNhomHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(jpnPhieuNhapLayout.createSequentialGroup()
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpnPhieuNhapLayout.createSequentialGroup()
                        .addComponent(jpnHangHoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(5, 5, 5))))
        );
        jpnPhieuNhapLayout.setVerticalGroup(
            jpnPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPhieuNhapLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpnPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcbNhomHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnXoaTatCa, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(btnXoaHH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlbEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(jpnPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnHangHoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jpnPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbTongTien))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtbQuanLyNhapHang.addTab("Phiếu nhập 1", jpnPhieuNhap);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jtbQuanLyNhapHang)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jtbQuanLyNhapHang)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents
    private JButton createButton(HangHoa hh) {
        ImageIcon icon = getImageIcon(hh.getHinhAnh(), 50, 50);
        JButton btn = new JButton(hh.getTenHang(), icon);
        btn.setPreferredSize(new Dimension(HangHoaDAO.HangHoaWidth, HangHoaDAO.HangHoaHeight));
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap(hh);
                if (listCTPN == null) {
                    listCTPN = new ArrayList<>();
                }
                int flag = 0;
                for (ChiTietPhieuNhap ctpnCu : listCTPN) {
                    if (ctpnCu.getMaHang().equals(ctpn.getMaHang())) {
                        double oldSoLuong = ctpnCu.getSoLuong() + ctpn.getSoLuong();
                        double ThanhTien = oldSoLuong * ctpnCu.getDonGia();
                        ctpnCu.setSoLuong(oldSoLuong);
                        ctpnCu.setThanhTien(ThanhTien);
                        flag = 1;
                    }
                }
                if (flag == 0) {
                    listCTPN.add(ctpn);
                }
                LoadCTPNVaoTable(jtCTPN, jpnView, jspCTPN);
            }
        });

        btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btn.setForeground(Color.BLACK);
        btn.setHorizontalAlignment(JButton.CENTER);
        btn.setVerticalTextPosition(JButton.BOTTOM);
        btn.setHorizontalTextPosition(JButton.CENTER);

        return btn;
    }
    private ImageIcon getImageIcon(String imageName, int width, int height) {
        if (!loadedImages.containsKey(imageName)) {
            URL imageUrl = getClass().getResource("/Images/" + imageName);
            if (imageUrl == null) {
                System.err.println("Could not find image: /Images/" + imageName);
                return null;
            }
            ImageIcon icon = new ImageIcon(new ImageIcon(imageUrl).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
            loadedImages.put(imageName, icon);
        }
        return loadedImages.get(imageName);
    }
    float tinhTongTien(List<ChiTietPhieuNhap> listCTPN) {
        float TongTien = 0;
        if (listCTPN != null) {
            for (ChiTietPhieuNhap ctpn : listCTPN) {
                TongTien += ctpn.getThanhTien();
            }
            jlbTongTien.setText("Tổng tiền: " + TongTien + "VNĐ");
        } else {
            jlbTongTien.setText("Tổng tiền: 0 VNĐ");
        }
        return TongTien;
    }
    void LoadCTPNVaoTable(JTable jt, JPanel jpn, JScrollPane jsp) {
        String[] header = {"Mã hàng hóa", "Tên hàng hóa", "Số lượng", "DVT", "Đơn giá", "Thành Tiền"};
        if (jt == null && jpn == null && jsp == null) {
            jt = jtCTPN;
            jpn = jpnView;
            jsp = jspCTPN;
        }

        DefaultTableModel modelTableDb = new DefaultTableModel(header, 0) {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return colIndex == 2;
            }
        };

        if (listCTPN != null) {
            for (ChiTietPhieuNhap ctpn : listCTPN) {
                Object[] row = {ctpn.getMaHang(), ctpn.getTenHang(), ctpn.getSoLuong(), ctpn.getDVT(), ctpn.getDonGia(), ctpn.getThanhTien()};
                modelTableDb.addRow(row);
            }
            tinhTongTien(listCTPN);
        }

        TableRowSorter<TableModel> rowSorter = null;

        jt.setModel(modelTableDb);
        jt.getModel().addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int row = e.getFirstRow();
                    int column = e.getColumn();
                    if (column == 2) { // If the second column is edited
                        TableModel model = (TableModel) e.getSource();
                        double soLuong = Double.parseDouble(model.getValueAt(row, column).toString());
                        double donGia = Double.parseDouble(model.getValueAt(row, 4).toString());
                        double thanhTien = soLuong * donGia;
                        ChiTietPhieuNhap ctpn = listCTPN.get(row);
                        if (soLuong > ctpn.getSoLuongTon()) {
                            JOptionPane.showMessageDialog(null, "Số lượng mua không thể lớn hơn số lượng tồn!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                            ctpn.setSoLuong(ctpn.getSoLuongTon());
                            model.setValueAt(ctpn.getSoLuongTon(), row, column);
                        } else {
                            ctpn.setSoLuong(soLuong);
                            ctpn.setThanhTien(thanhTien);
                            tinhTongTien(listCTPN);
                            model.setValueAt(thanhTien, row, 5);
                        }
                    }
                }
            }
        });
        jt.setRowSorter(rowSorter);

        jt.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        jt.setFont(new Font("Arial", Font.PLAIN, 14));
        jt.getTableHeader().setPreferredSize(new Dimension(100, 50));
        jt.setRowHeight(50);
        jt.validate();
        jt.repaint();

        jsp.setPreferredSize(new Dimension(700, 400));

        jpn.removeAll();
        jpn.setLayout(new CardLayout());
        jpn.add(jsp);
        jpn.validate();
        jpn.repaint();
    }
    private void loadComboBoxNhomHang() {
        DefaultComboBoxModel<NhomHang> model = new DefaultComboBoxModel<>();
        List<NhomHang> listNH = NhomHangDAO.getInstance().getListNhomHang();

        for (NhomHang nhomhang : listNH) {
            model.addElement(nhomhang);
        }
        jcbNhomHang.setModel(model);
    }
    private void loadComboBoxNCC() {
        DefaultComboBoxModel<NhaCungCap> model = new DefaultComboBoxModel<>();
        List<NhaCungCap> listNCC = NhaCungCapDAO.getInstance().getListNhaCungCap(1);

        for (NhaCungCap ncc : listNCC) {
            model.addElement(ncc);
        }
        jcbNCC.setModel(model);
    }
    private void TaoDialog(BanHangJFrame frame, String title) {
        frame.setResizable(false);

        dialog = new JDialog();
        dialog.setModal(true);
        dialog.getContentPane().add(frame.getContentPane());
        dialog.getRootPane().setDefaultButton(frame.getBtnLuu());
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setTitle(title);
        dialog.setVisible(true);
    }
    private void jtCTPNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCTPNMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2 && jtCTPN.getSelectedRow() != -1) {
            int index = jtCTPN.getSelectedRow();

//            ChiTietPhieuNhap ctpn = listCTPN.get(index);
//
//            NhapHangJFrame frame = new NhapHangJFrame(ctpn, this);
//
//            TaoDialog(frame, "Sửa hàng hóa");
        }
    }//GEN-LAST:event_jtCTPNMouseClicked

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
//        if (listCTPN != null) {
//            ThanhToanJFrame frame = new ThanhToanJFrame(tinhTongTien(listCTPN), this.khachhang, listCTPN);
//
//            frame.setResizable(false);
//
//            dialog = new JDialog();
//            dialog.setModal(true);
//            dialog.getContentPane().add(frame.getContentPane());
//            dialog.pack();
//            dialog.setLocationRelativeTo(null);
//            dialog.setTitle("Thông tin thanh toán");
//            dialog.setVisible(true);
//        } else {
//            JOptionPane.showMessageDialog(null, "Giỏ hàng đang trống! Vui lòng chọn sản phẩm để đưa vào giỏ!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
//        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnXoaHHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaHHActionPerformed
        // TODO add your handling code here:
        try {
            int index = jtCTPN.getSelectedRow();
            ChiTietPhieuNhap ctpn = listCTPN.get(index);
            int kq = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa hàng hóa tên là: " + ctpn.getTenHang() + " trong giỏ hàng?", "Câu hỏi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (kq == JOptionPane.YES_OPTION) {
                listCTPN.remove(index);
                LoadCTPNVaoTable(jtCTPN, jpnView, jspCTPN);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn hàng hóa muốn xóa!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnXoaHHActionPerformed

    private void jcbNhomHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbNhomHangActionPerformed
        // TODO add your handling code here:
        NhomHang nhomhang = (NhomHang) jcbNhomHang.getSelectedItem();
        loadHHTheoMaNhomHang(nhomhang.getMaNhomHang());
    }//GEN-LAST:event_jcbNhomHangActionPerformed

    private void btnXoaTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTatCaActionPerformed
        // TODO add your handling code here:
        try {
            if (listCTPN != null) {
                int kq = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa tất cả sản phẩm trong giỏ hàng?", "Câu hỏi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (kq == JOptionPane.YES_OPTION) {
                    listCTPN = null;
                    LoadCTHDVaoTable(jtCTPN, jpnView, jspCTPN);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn hàng hóa muốn xóa!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnXoaTatCaActionPerformed

    private void jtbQuanLyNhapHangStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jtbQuanLyNhapHangStateChanged
        // TODO add your handling code here:
        loadComboBoxNhomHang();
        int index = jtbQuanLyNhapHang.getSelectedIndex();
        if (index == 0) {            
            NhaCungCap ncc = (NhaCungCap) jcbNCC.getSelectedItem(); 
            NhomHang nhomhang = (NhomHang) jcbNhomHang.getSelectedItem();
            loadHHTheoMaNCC(ncc.getMaNCC());
            LoadCTPNVaoTable(jtCTPN, jpnView, jspCTPN);
        }
    }//GEN-LAST:event_jtbQuanLyNhapHangStateChanged

    private void jcbNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbNCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbNCCActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnXoaHH;
    private javax.swing.JButton btnXoaTatCa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox<NhomHang> jcbNCC;
    private javax.swing.JComboBox<NhomHang> jcbNhomHang;
    private javax.swing.JLabel jlbEmpName;
    private javax.swing.JLabel jlbTongTien;
    private javax.swing.JPanel jpnHangHoa;
    private javax.swing.JPanel jpnPhieuNhap;
    private javax.swing.JPanel jpnView;
    private javax.swing.JScrollPane jspCTPN;
    private javax.swing.JTable jtCTPN;
    private javax.swing.JTabbedPane jtbQuanLyNhapHang;
    // End of variables declaration//GEN-END:variables
}
