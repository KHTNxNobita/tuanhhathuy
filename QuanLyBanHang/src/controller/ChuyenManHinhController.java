/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.DanhMucBean;
import frm.HoaDonJPanel;
import frm.KhachHangJPanel;
import frm.NCCJPanel;
import frm.NhanVienJPanel;
import frm.SanPhamJPanel;
import frm.ThongKeJPanel;
import frm.TrangChuJPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author LENOVO
 */
public class ChuyenManHinhController {
    private JPanel root;
    private String kindSelected="";
    private List<DanhMucBean> listitem =null;
    
    public ChuyenManHinhController (JPanel JpnRoot)
    {
        this.root=JpnRoot;
    }
    public void SetView (JPanel jpnItem, JLabel lblItem)
    {
        kindSelected ="TrangChu";
        jpnItem.setBackground(new Color(96,100,191));
        lblItem.setBackground(new Color(96,100,191));
        
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new ThongKeJPanel());
        root.validate();
        root.repaint();
    }
    public void setEvent (List<DanhMucBean> listItem)
    {
        this.listitem =listItem;
        for(DanhMucBean item: listItem){
            item.getLbl().addMouseListener(new LabelEvent(item.getKind(),item.getJpn(),item.getLbl()));
        }
    }
    class LabelEvent implements MouseListener{
        private JPanel node;
        private String kind;
        
        
        private JPanel jpnItem;
        private JLabel lblItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel lblItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.lblItem = lblItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch(kind){
                case "ThongKe":
                    node=new ThongKeJPanel();
                    break;
                case "NhanVien":
                     node= new NhanVienJPanel();
                    break;
                case "KhachHang":
                     node=new KhachHangJPanel();
                    break;
                case "SanPham":
                     node=new SanPhamJPanel();
                    break; 
                case "HoaDon":
                     node=new HoaDonJPanel();
                    break;
                  case "NCC":
                     node=new NCCJPanel();
                    break;
                default:
                     node=new TrangChuJPanel();
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
             root.add(node);
            root.validate();
            root.repaint();
           setChangeBackground( kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected  = kind;
            jpnItem.setBackground(new Color(96,100,191));
            lblItem.setBackground(new Color(96,100,191));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
           
        }

        @Override
        public void mouseEntered(MouseEvent e) {
           jpnItem.setBackground(new Color(96,100,191));
           lblItem.setBackground(new Color(96,100,191));
        }

        @Override
        public void mouseExited(MouseEvent e) {
           if (!kindSelected.equalsIgnoreCase(kind)){
               jpnItem.setBackground(new Color(76,175,80));
        lblItem.setBackground(new Color(76,175,80));
           }
        }
        private void setChangeBackground(String kind)
        {
          for(DanhMucBean item : listitem )
          {
              if(item.getKind().equalsIgnoreCase(kind)) {
                  item.getLbl().setBackground(new Color(96,100,191));
                  item.getJpn().setBackground(new Color(96,100,191));
              }
              else {
                  item.getJpn().setBackground(new Color(76,175,80));
                  item.getLbl().setBackground(new Color(76,175,80));
              }
          }
        }
        
    }
}
