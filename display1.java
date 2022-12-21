import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.FileWriter;

public class display1 extends JFrame implements ActionListener {

    JTextField t1, t_no, t_stockname, t_prize;
    JLabel l1, l_no, l_stockname, l_prize;
    JButton b_add, b_delete, b_update, b_addfile, back;
    JTable table = new JTable();
    JScrollPane pane;
    Object[][] rows = null;
    Object[] column = null;

    public display1() {

        new JFrame();
        setBounds(50,50, 500, 500);

        l1 = new JLabel(" Index                 : ");
        l1.setBounds(20, 20, 150, 20);

        t1 = new JTextField(20);
        t1.setBounds(130, 20, 150, 20);

        t_no = new JTextField(20);
        t_no.setBounds(130, 50, 150, 20);

        l_no = new JLabel("No. of item      : ");
        l_no.setBounds(20, 50, 100, 20);

        t_stockname = new JTextField(20);
        t_stockname.setBounds(130, 80, 150, 20);

        l_stockname = new JLabel("Name of item   : ");
        l_stockname.setBounds(20, 80, 100, 20);

        t_prize = new JTextField(20);
        t_prize.setBounds(130, 110, 150, 20);

        l_prize = new JLabel("Price of item   : ");
        l_prize.setBounds(20, 110, 100, 20);

        b_add = new JButton("ADD");
        b_add.setBounds(300, 30, 100, 20);

        b_update = new JButton("UPDATE");
        b_update.setBounds(300, 90, 100, 20);

        b_delete = new JButton("DELETE");
        b_delete.setBounds(300, 60, 100, 20);

        b_addfile = new JButton("ADD FILE");
        b_addfile.setBounds(300, 120, 100, 20);

        back = new JButton("<-Back");
        back.setBounds(2, 2, 75, 15);
        back.addActionListener(this);

        rows = new Object[][] { { 1, 5, "CPU", 100 }, { 2, 6, "Monitor", 120 }, { 3, 1, "Mouse", 270 } };
        column = new String[] { "No.#", "No. of item", "Name of item", "Price($)" };

        DefaultTableModel model = new DefaultTableModel(rows, column);
        table = new JTable(model);
        table.setAutoCreateRowSorter(true);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int rowindex = table.getSelectedRow();
                int t = (int) model.getValueAt(rowindex, 0);
                int tno = (int) model.getValueAt(rowindex, 1);
                String tstockname = (String) model.getValueAt(rowindex, 2);
                int tprize = (int) model.getValueAt(rowindex, 3);

                t1.setText(String.valueOf(t));
                t_no.setText(String.valueOf(tno));
                t_stockname.setText(tstockname);
                t_prize.setText(String.valueOf(tprize));

            }
        });

        b_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (t1.getText().isEmpty() || t_no.getText().isEmpty() || t_stockname.getText().isEmpty()
                        || t_prize.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, " Please Enter all the Fields Correctly", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    int o1 = Integer.parseInt(t1.getText().toString());
                    int o2 = Integer.parseInt(t_no.getText().toString());
                    String o3 = (t_stockname.getText().toString());
                    int o4 = Integer.parseInt(t_prize.getText().toString());

                    Object[] newRow = { o1, o2, o3, o4 };
                    model.addRow(newRow);

                    t1.setText(null);
                    t_no.setText(null);
                    t_stockname.setText(null);
                    t_prize.setText(null);

                }
            }
        });

        b_update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (t1.getText().isEmpty() || t_no.getText().isEmpty() || t_stockname.getText().isEmpty()
                        || t_prize.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, " Please Enter all the Fields Correctly", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    int o1 = Integer.parseInt(t1.getText().toString());
                    int o2 = Integer.parseInt(t_no.getText().toString());
                    String o3 = (t_stockname.getText().toString());
                    int o4 = Integer.parseInt(t_prize.getText().toString());

                    int new_row = table.getSelectedRow();

                    model.setValueAt(o1, new_row, 0);
                    model.setValueAt(o2, new_row, 1);
                    model.setValueAt(o3, new_row, 2);
                    model.setValueAt(o4, new_row, 3);

                    t1.setText(null);
                    t_no.setText(null);
                    t_stockname.setText(null);
                    t_prize.setText(null);
                }
            }

        });

        b_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] selectedRows = table.getSelectedRows();
                for (int i = selectedRows.length - 1; i >= 0; i--) {
                    model.removeRow(selectedRows[i]);
                }
                t1.setText(null);
                t_no.setText(null);
                t_stockname.setText(null);
                t_prize.setText(null);
            }
        });

        b_addfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (t1.getText().isEmpty() || t_no.getText().isEmpty() || t_stockname.getText().isEmpty()
                        || t_prize.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, " Please Enter all the Fields Correctly", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    int o1 = Integer.parseInt(t1.getText().toString());
                    int o2 = Integer.parseInt(t_no.getText().toString());
                    String o3 = (t_stockname.getText().toString());
                    int o4 = Integer.parseInt(t_prize.getText().toString());

                    Object[] newRow = { o1, o2, o3, o4 };
                    model.addRow(newRow);

                    t1.setText(null);
                    t_no.setText(null);
                    t_stockname.setText(null);
                    t_prize.setText(null);

                    try {
                        FileWriter Writer = new FileWriter("stock.txt",true);
                        Writer.write("" + o1 + " " + o2 + " " + o3 + " " + o4);
                        Writer.write(System.getProperty("line.separator"));
                        Writer.close();
                        JOptionPane.showMessageDialog(null, "Success");
                        setVisible(false);
                        new display1().setVisible(true);
                    } catch (Exception ae) {
                        JOptionPane.showMessageDialog(null, "Error");
                    }
                }
            }
        });

        pane = new JScrollPane(table);
        pane.setBounds(100, 150, 300, 300);

        setLayout(null);
        add(l1);
        add(t1);

        add(pane);
        add(t_no);
        add(t_stockname);
        add(t_prize);
        add(l_no);
        add(l_stockname);
        add(l_prize);
        add(b_add);
        add(b_delete);
        add(b_update);
        add(b_addfile);
        add(back);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);


    }

    public static void main(String[] args) {
        new display1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            new Loginpage();
        } else {
            l_no.setText("");

        }
    }
}