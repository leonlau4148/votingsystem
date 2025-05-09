/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsystem;

import java.awt.Color;
import java.awt.Image;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Raven
 */
public class adminDashboard extends javax.swing.JFrame {

    String xd, yd, xf, fullname2, fn2, ln2, image, images="src\\icons\\userr.png", image1, image2, image3;
    String dep2, pos2, pl2, gender = "", newfn, newln, oldfn, oldln;
    int xx, xy;
public ImageIcon back,homebg;
    public adminDashboard() {
        initComponents();
        sets();
        tableshow();
        populateitemss();
        back = new ImageIcon("src\\icons\\back.jpg");
        homebg= new ImageIcon("src\\icons\\HOME.jpg");
        backg1.setIcon(back);
        homebackg.setIcon(homebg);
    }

    public void sets() {
        edit1.setVisible(false);
        fullname.setVisible(false);
        confirmedit.setVisible(false);
        delete.setVisible(false);
        setLocationRelativeTo(null);
        tab1.setEnabled(false);
        tab2.setEnabled(false);
        tab3.setEnabled(false);
        tab4.setEnabled(false);
        tab5.setEnabled(false);
        tab6.setEnabled(false);
        tab7.setEnabled(false);
        tab8.setEnabled(false);
        delete1.setVisible(false);
        showres.setEnabled(false);
        //highlights home 
        setColor(btn_1);
        ind_1.setOpaque(true);
        resetColor(new JPanel[]{btn_3, btn_12, btn_8, btn_9, btn_4}, new JPanel[]{ind_3, ind_12, ind_8, ind_4});
    }

    public void toggleoption() {
        if (addedit.isSelected()) {
            delete.setVisible(true);
            edit1.setVisible(true);
            fullname.setVisible(true);
            confirmedit.setEnabled(false);
            confirmedit.setVisible(true);
            add.setVisible(false);
            jButton2.setVisible(false);
            delete1.setVisible(true);
            addedit.setText("Edit");

        } else {
            edit1.setVisible(false);
            fullname.setVisible(false);
            confirmedit.setVisible(false);
            add.setVisible(true);
            delete.setVisible(false);
            jButton2.setVisible(true);
            delete1.setVisible(false);
            FN.setText("");
            LN.setText("");
            female.setSelected(false);
            male.setSelected(false);
            department.setSelectedIndex(0);
            position.setSelectedIndex(0);
            partylist.setSelectedIndex(0);
            addedit.setText("Add");
        }
    }

    public void tableshow() {
        String a = tabp1.getTitleAt(0);
        JTable k = tab1;
        String a8 = tabp1.getTitleAt(1);
        JTable k8 = tab2;
        String a7 = tabp1.getTitleAt(2);
        JTable k7 = tab3;
        String a6 = tabp1.getTitleAt(3);
        JTable k6 = tab4;
        String a5 = tabp1.getTitleAt(4);
        JTable k5 = tab5;
        String a4 = tabp1.getTitleAt(5);
        JTable k4 = tab6;
        String a3 = tabp1.getTitleAt(6);
        JTable k3 = tab7;
        String a2 = tabp1.getTitleAt(7);
        JTable k2 = tab8;
        String a1 = tabp1.getTitleAt(8);
        JTable k1 = tab9;
        try {
            table(a, k);
            table(a1, k1);
            table(a2, k2);
            table(a3, k3);
            table(a4, k4);
            table(a5, k5);
            table(a6, k6);
            table(a7, k7);
            table(a8, k8);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(adminDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void res() {
        delete.setVisible(true);
        delete1.setVisible(true);
        edit1.setVisible(true);
        fullname.setVisible(true);
        confirmedit.setVisible(true);
        add.setVisible(false);
        jButton2.setVisible(false);
        addedit.setSelected(true);
        addedit.setText("Edit");
        change.setText("CANDIDATE PROFILE");
        adminDashboard.setColor(adminDashboard.btn_3);
        adminDashboard.ind_3.setOpaque(true);
        resetColor(new JPanel[]{adminDashboard.btn_1, adminDashboard.btn_8, adminDashboard.btn_12, adminDashboard.btn_9, adminDashboard.btn_4},
                new JPanel[]{adminDashboard.ind_1, adminDashboard.ind_12, adminDashboard.ind_8, adminDashboard.ind_12, adminDashboard.ind_9, adminDashboard.ind_4});
        cd2.setVisible(true);
        cd1.setVisible(false);
        cd3.setVisible(false);
        cd4.setVisible(false);
        cd5.setVisible(false);
        cd6.setVisible(false);
    }

    public void populateitemss() {

        try {
            showItem();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(adminDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            showItem2();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(adminDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            showItem3();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(adminDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void imagefilechoose() {
        JFileChooser fileChooser = new JFileChooser();

        //Limit type of file name extensions supported.
        FileNameExtensionFilter filter = new FileNameExtensionFilter("4 Extensions Supported", "jpg", "png", "jpeg", "gif");

        fileChooser.setFileFilter(filter);

        int selected = fileChooser.showOpenDialog(null);

        //check if open button has been clicked.
        if (selected == JFileChooser.APPROVE_OPTION) {

            File file = fileChooser.getSelectedFile();

            //Get Path of the selected image.
            String getselectedImage = file.getAbsolutePath();

            //Display image path on Message Dialog
            JOptionPane.showMessageDialog(null, getselectedImage);

            ImageIcon imIco = new ImageIcon(getselectedImage);

            //make image fit on jlabel.
            Image imFit = imIco.getImage();
            Image imgFit = imFit.getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH);
            label.setText("");
            label.setIcon(new ImageIcon(imgFit));
            images = getselectedImage;

        }
    }

    public void searchCandidate() {
        if (jTextField1.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter Search Field");
        } else {

            try {

                String line;
                String votefirstname = "";
                String votesecondname = "";
                String totalvotes = "";
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);
                String fn = "", ln = "", pos = "", pl = "", dep = "", viewgender = "";
                Scanner sc = new Scanner(new FileReader("src\\textFile\\candidates"));
                Scanner sd = new Scanner(new FileReader("src\\textFile\\votes"));
                while (sd.hasNextLine()) {
                    String voteline = sd.nextLine();
                    if (voteline.equals("")) {
                        continue;
                    } else {
                        Scanner asd = new Scanner(voteline);
                        votefirstname = asd.next();
                        votesecondname = asd.next();
                        totalvotes = asd.next();
                        while (sc.hasNextLine()) {
                            line = sc.nextLine();
                            if (line.equals("")) {
                                continue;
                            } else {
                                Scanner linesc = new Scanner(line);
                                fn = linesc.next();
                                ln = linesc.next();
                                viewgender = linesc.next();
                                dep = linesc.next();
                                pos = linesc.next();
                                pl = linesc.next();
                                if (fn.equals(votefirstname) && ln.equals(votesecondname)) {
                                    break;
                                } else {
                                    continue;
                                }
                            }
                        }

                        String query2 = jTextField1.getText().toUpperCase();
                        if (!query2.equals("")) {
                            if (fn.equals(votefirstname) && ln.equals(votesecondname)) {
                                String query = query2.substring(0, 1).toUpperCase() + query2.substring(1);
                                filter(query);
                                String[] rowData = {fn, ln, pos, pl, dep, totalvotes};
                                model.addRow(rowData);
                            } else {
                                continue;
                            }

                        } else {
                            if (fn.equals(votefirstname) && ln.equals(votesecondname)) {
                                filter(query2);
                                String[] rowData = {fn, ln, pos, pl, dep, totalvotes};
                                model.addRow(rowData);
                            } else {
                                continue;
                            }
                        }

                    }

                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(adminDashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void addcandidatee() {
        String firstname = FN.getText().toUpperCase();
        String lastname = LN.getText().toUpperCase();
        dep2 = (String) department.getSelectedItem();
        pos2 = (String) position.getSelectedItem();
        pl2 = (String) partylist.getSelectedItem();
        String candidateposition = "";
        String candidatepartylist = "";
        Scanner sd = null;
        String val = "0";
        if (male.isSelected()) {
            gender = "MALE";
        }
        if (female.isSelected()) {
            gender = "FEMALE";
        }
        if (!female.isSelected() && !male.isSelected()) {
            JOptionPane.showMessageDialog(null, "Please Select a Gender");
        }
        if (dep2.equals("Select Course")) {
            JOptionPane.showMessageDialog(null, "Please Select a Course");
        }
        if (pos2.equals("Select Position")) {
            JOptionPane.showMessageDialog(null, "Please Select a Position");
        }
        if (pl2.equals("Select a Partylist")) {
            JOptionPane.showMessageDialog(null, "Please Select a partylist");
        }
        try {
            sd = new Scanner(new FileReader("src\\textFile\\candidates"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(adminDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!dep2.equals("Select Course") && !pos2.equals("Select Position") && !pl2.equals("Select a Partylist") && male.isSelected() || female.isSelected()) {
            int checker = 0;
            while (sd.hasNextLine()) {
                String sf = sd.nextLine();
                if (sf.equals("")) {
                    continue;
                }
                checker = 0;
                Scanner sz = new Scanner(sf);
                String candidatefirstname = sz.next();
                String candidatesurname = sz.next();
                String candidategender = sz.next();
                String candidatedepartment = sz.next();
                candidateposition = sz.next();
                candidatepartylist = sz.next();

                if (candidatepartylist.equals(pl2) && candidateposition.equals(pos2)) {
                    JOptionPane.showMessageDialog(null, "Position already exist in the same partylist");
                    checker = 1;
                    break;
                }
            }
            String user5 = firstname;
            Scanner usasdasda = new Scanner(firstname);
            while (usasdasda.hasNext()) {
                String user3 = usasdasda.next();
                if (usasdasda.hasNext()) {
                    String user4 = usasdasda.next();
                    user5 = user3 + "_" + user4;
                    break;
                } else {
                    break;
                }
            }
            if (checker == 0) {
                try {
                    save3(user5, lastname, val);
                } catch (IOException ex) {
                    Logger.getLogger(adminDashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    save2(user5, lastname, gender, dep2, pos2, pl2);
                } catch (IOException ex) {
                    Logger.getLogger(adminDashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    save(images, user5, lastname);
                } catch (IOException ex) {
                    Logger.getLogger(adminDashboard.class.getName()).log(Level.SEVERE, null, ex);
                }

                JOptionPane.showMessageDialog(null, "Added Reloading..");
                dispose();
                adminDashboard x = new adminDashboard();
                x.setVisible(true);
                change.setText("CANDIDATE PROFILE");
                cd2.setVisible(true);
                cd1.setVisible(false);
                cd3.setVisible(false);
                cd4.setVisible(false);
                cd5.setVisible(false);
                cd6.setVisible(false);
                setColor(btn_3);
                ind_3.setOpaque(true);
                resetColor(new JPanel[]{btn_1, btn_8, btn_12, btn_9, btn_4}, new JPanel[]{ind_1, ind_12, ind_8, ind_12, ind_9, ind_4});
            }
        }
    }

    public void editcandidatee() {
        Scanner inp = null, imagepathss = null, votess = null;
        String efn = null, eln = "", egender = null, edep = null, epos = null, epl = null;
        String line = "", imageline = "", voteline = "";
        String fetchline = "", fetchimage = "", fetchvote = "";
        newfn = FN.getText().toUpperCase();;
        newln = LN.getText().toUpperCase();;
        fullname2 = (String) fullname.getSelectedItem();
        dep2 = (String) department.getSelectedItem();
        pos2 = (String) position.getSelectedItem();
        pl2 = (String) partylist.getSelectedItem();
        dep2 = (String) department.getSelectedItem();

        Scanner sc = new Scanner(fullname2);
        while (sc.hasNext()) {
            oldfn = sc.next();
            oldln = sc.next();
        }
        String user5 = newfn;
        Scanner usasdasda = new Scanner(user5);
        while (usasdasda.hasNext()) {
            String user3 = usasdasda.next();
            if (usasdasda.hasNext()) {
                String user4 = usasdasda.next();
                user5 = user3 + "_" + user4;
                break;
            } else {
                break;
            }
        }
        try {
            inp = new Scanner(new FileReader("src\\textFile\\candidates"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(adminDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            imagepathss = new Scanner(new FileReader("src\\textFile\\imagepaths"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(adminDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            votess = new Scanner(new FileReader("src\\textFile\\votes"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(adminDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (inp.hasNextLine()) {
            String fetched = inp.nextLine();
            if (fetched.equals("")) {
                continue;
            } else {
                try {
                    Scanner fetchedd = new Scanner(fetched);
                    efn = fetchedd.next();
                    eln = fetchedd.next();
                    egender = fetchedd.next();
                    edep = fetchedd.next();
                    epos = fetchedd.next();
                    epl = fetchedd.next();
                    if (male.isSelected()) {
                        gender = "MALE";
                    }
                    if (female.isSelected()) {
                        gender = "FEMALE";
                    }
                    while (imagepathss.hasNextLine()) {
                        try {
                            imageline = imagepathss.nextLine();
                            if (imageline.equals("")) {
                                continue;
                            }
                            Scanner imageline2 = new Scanner(imageline);
                            String imagefirstname = imageline2.next();
                            String imagesurname2 = imageline2.next();

                            if (imagefirstname.equals(oldfn) && imagesurname2.equals(oldln)) {
                                imageline = (user5 + " " + newln + " " + images);
                            }
                            fetchimage = fetchimage + imageline + "\n";

                            BufferedWriter sd;
                            sd = new BufferedWriter(new FileWriter("src\\textFile\\imagepaths"));
                            sd.append(fetchimage);
                            sd.close();
                            break;

                        } catch (IOException ex) {
                            Logger.getLogger(adminDashboard.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    while (votess.hasNextLine()) {
                        try {
                            voteline = votess.nextLine();
                            if (voteline.equals("")) {
                                continue;
                            }
                            Scanner vot = new Scanner(voteline);
                            String votfirstname = vot.next();
                            String votsurname2 = vot.next();
                            int votenos = vot.nextInt();
                            if (votfirstname.equals(oldfn) && votsurname2.equals(oldln)) {
                                voteline = (user5 + " " + newln + " " + votenos);
                            }
                            fetchvote = fetchvote + voteline + "\n";

                            BufferedWriter sd;
                            sd = new BufferedWriter(new FileWriter("src\\textFile\\votes"));
                            sd.append(fetchvote);
                            sd.close();
                            break;
                        } catch (IOException ex) {
                            Logger.getLogger(adminDashboard.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if (efn.equals(oldfn) && eln.equals(oldln)) {
                        fetched = (user5 + " " + newln + " " + gender + " " + dep2 + " " + pos2 + " " + pl2);

                    }
                    fetchline = fetchline + fetched + "\n";
                    BufferedWriter sf;
                    sf = new BufferedWriter(new FileWriter("src\\textFile\\candidates"));
                    sf.append(fetchline);
                    sf.close();
                } catch (IOException ex) {
                    Logger.getLogger(adminDashboard.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }

        JOptionPane.showMessageDialog(null, "Edited Reloading...");
        dispose();
        adminDashboard x = new adminDashboard();
        x.setVisible(true);
        res();
    }

    public void verifyy() {
        String uname, line = null, username, content = "";
        uname = partylist.getSelectedItem().toString();

        try {
            Scanner sc = new Scanner(new FileReader("src\\textFile\\partylist"));
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                if (line.equals("")) {
                    continue;
                }
                Scanner lineinput = new Scanner(line);
                username = lineinput.next();

                if (uname.equals(username)) {
                    continue;
                }
                content = content + line + "\n";
            }

            savez(content, "src\\textFile\\partylist");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(adminDashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(adminDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void checkcombobox() {
        fullname.removeItem("Select Candidate");
        Scanner inp = null;
        fullname2 = (String) fullname.getSelectedItem();
        Scanner sc = new Scanner(fullname2);
        Scanner sd = null;
        while (sc.hasNextLine()) {
            fn2 = sc.next();
            xf = sc.next();
            try {
                inp = new Scanner(new FileReader("src\\textFile\\imagepaths"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(adminDashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                sd = new Scanner(new FileReader("src\\textFile\\candidates"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(adminDashboard.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (inp.hasNextLine()) {
                String fetched = inp.nextLine();
                if (fetched.equals("")) {
                    continue;
                }
                Scanner fetchedd = new Scanner(fetched);
                xd = fetchedd.next();
                yd = fetchedd.next();

                if (xd.equals(fn2) && yd.equals(xf)) {
                    image = fetchedd.next();
                    while (fetchedd.hasNext()) {
                        image = image + " " + fetchedd.next();
                    }

                    FN.setText(xd);
                    LN.setText(yd);
                    ImageIcon imIco = new ImageIcon(image);
                    Image imFit = imIco.getImage();
                    Image imgFit = imFit.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);

                    label.setIcon(new ImageIcon(imgFit));
                    images = image;
                    while (sd.hasNextLine()) {
                        String cand = sd.nextLine();
                        if (cand.equals("")) {
                            continue;
                        }
                        Scanner cand2 = new Scanner(cand);
                        String oldfname = cand2.next();
                        String oldlname = cand2.next();
                        String oldgender = cand2.next();
                        String olddep = cand2.next();
                        String oldpos = cand2.next();
                        String oldpl = cand2.next();

                        if (oldfname.equals(fn2) && oldlname.equals(xf)) {
                            department.setSelectedItem(olddep);
                            position.setSelectedItem(oldpos);
                            partylist.setSelectedItem(oldpl);
                            if (oldgender.equals("MALE")) {
                                male.setSelected(true);
                                female.setSelected(false);
                            }
                            if (oldgender.equals("FEMALE")) {
                                female.setSelected(true);
                                male.setSelected(false);

                            }
                        }
                    }
                }
            }
        }
    }

    public void table(String a, JTable n) throws FileNotFoundException {
        try {
            String empty = "";
            if (a.equals("GOVERNOR")) {
                empty = "GOVERNOR";
            }
            if (a.equals("VG-INTERNAL")) {
                empty = "VG-INTERNAL";
            }
            if (a.equals("VG-EXTERNAL")) {
                empty = "VG-EXTERNAL";
            }
            if (a.equals("SECRETARY")) {
                empty = "SECRETARY";
            }
            if (a.equals("ASSISTANT-SECRETARY")) {
                empty = "ASSISTANT-SECRETARY";
            }
            if (a.equals("TREASURER")) {
                empty = "TREASURER";
            }
            if (a.equals("AUDITOR")) {
                empty = "AUDITOR";
            }
            if (a.equals("PIO")) {
                empty = "PIO";
            }
            if (a.equals("WINNER RESULT")) {
                //unsaon
            }
            DefaultTableModel model = (DefaultTableModel) n.getModel();
            n.setAutoCreateRowSorter(true);
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(n.getModel());
            n.setRowSorter(sorter);
            List<RowSorter.SortKey> sortKeys = new ArrayList<>();
            sortKeys.add(new RowSorter.SortKey(6, SortOrder.DESCENDING));
            sortKeys.add(new RowSorter.SortKey(3, SortOrder.DESCENDING));
            sorter.setSortKeys(sortKeys);
            sorter.sort();

            model.setRowCount(0);
            Scanner io = new Scanner(new FileReader("src\\textFile\\candidates"));

            while (io.hasNextLine()) {
                String line = io.nextLine();
                if (line.equals("")) {
                    continue;
                }
                Scanner linesc = new Scanner(line);
                String id = linesc.next();
                Scanner sc2 = new Scanner(new FileReader("src\\textFile\\votes"));
                while (sc2.hasNextLine()) {
                    String line2 = sc2.nextLine();
                    if (line2.equals("")) {
                        continue;
                    }
                    Scanner linesc2 = new Scanner(line2);
                    String id2 = linesc2.next();
                    String nofv = linesc2.next();
                    String nofv2 = linesc2.next();

                    if (id.equals(id2)) {
                        line = line + " " + nofv2;
                        break;
                    }
                }
                String data[] = line.split(" ");

                if (data[4].equals(empty)) {
                    model.addRow(data);
                }
                if (a.equals("SHOW ALL")) {
                    model.addRow(data);
                }

            }
            io.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(adminDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void tablePaneClicked() {
        try {
            if (tabp1.getSelectedIndex() == 0) { //GOVERNOR PANE
                String a = tabp1.getTitleAt(0);//GETTING PANE TITLE
                JTable k = tab1;
                table(a, k);
            }
            if (tabp1.getSelectedIndex() == 1) { //VG-INTERNAL PANE
                String a = tabp1.getTitleAt(1);//GETTING PANE TITLE
                JTable k = tab2;
                table(a, k);
            }
            if (tabp1.getSelectedIndex() == 2) { //VG-EXTERNAL PANE
                String a = tabp1.getTitleAt(2);//GETTING PANE TITLE
                JTable k = tab3;
                table(a, k);
            }
            if (tabp1.getSelectedIndex() == 3) { //SECRETARY PANE
                String a = tabp1.getTitleAt(3);//GETTING PANE TITLE
                JTable k = tab4;
                table(a, k);
            }
            if (tabp1.getSelectedIndex() == 4) { //ASSISTANT-SECRETARY PANE
                String a = tabp1.getTitleAt(4);//GETTING PANE TITLE
                JTable k = tab5;
                table(a, k);
            }
            if (tabp1.getSelectedIndex() == 5) { //TREASURER PANE
                String a = tabp1.getTitleAt(5);//GETTING PANE TITLE
                JTable k = tab6;
                table(a, k);
            }
            if (tabp1.getSelectedIndex() == 6) {//AUDITOR PANE
                String a = tabp1.getTitleAt(6);//GETTING PANE TITLE
                JTable k = tab7;
                table(a, k);
            }
            if (tabp1.getSelectedIndex() == 7) {//PIO PANE
                String a = tabp1.getTitleAt(7);//GETTING PANE TITLE
                JTable k = tab8;
                table(a, k);
            }
            if (tabp1.getSelectedIndex() == 8) {//WINNER RESULT PANE
                String a = tabp1.getTitleAt(8);//GETTING PANE TITLE
                JTable k = tab9;
                table(a, k);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(adminDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete() throws IOException {
        Scanner inp = null, imagepathss = null, votes = null;
        String name, name1, lastname, fline, contentss = "", box, last, imagecontent = "", fline2, fline3, voteee = "";

        box = fullname.getSelectedItem().toString();
        Scanner sc = new Scanner(box);
        while (sc.hasNext()) {
            oldfn = sc.next();
            oldln = sc.next();
        }
        try {
            inp = new Scanner(new FileReader("src\\textFile\\candidates"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(adminDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            imagepathss = new Scanner(new FileReader("src\\textFile\\imagepaths"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(adminDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            votes = new Scanner(new FileReader("src\\textFile\\votes"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(adminDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (inp.hasNextLine()) {
            fline = inp.nextLine();
            if (fline.equals("")) {
                continue;
            } else {
                Scanner sc1 = new Scanner(fline);
                name = sc1.next();
                last = sc1.next();
                if (name.equals(oldfn) && last.equals(oldln)) {

                    continue;
                }
                contentss = contentss + fline + "\n";
            }
        }
        BufferedWriter bwaa = new BufferedWriter(new FileWriter("src\\textFile\\candidates"));
        bwaa.append(contentss);
        bwaa.close();
        while (imagepathss.hasNextLine()) {
            fline2 = imagepathss.nextLine();
            if (fline2.equals("")) {
                continue;
            } else {
                Scanner sc1 = new Scanner(fline2);
                name1 = sc1.next();
                lastname = sc1.next();
                if (name1.equals(oldfn) && lastname.equals(oldln)) {
                    continue;
                }
                imagecontent = imagecontent + fline2 + "\n";
            }
        }
        BufferedWriter bws = new BufferedWriter(new FileWriter("src\\textFile\\imagepaths"));
        bws.append(imagecontent);
        bws.close();
        while (votes.hasNextLine()) {
            fline3 = votes.nextLine();
            if (fline3.equals("")) {
                continue;
            } else {
                Scanner sc1 = new Scanner(fline3);
                name1 = sc1.next();
                lastname = sc1.next();
                if (name1.equals(oldfn) && lastname.equals(oldln)) {
                    continue;
                }
                voteee = voteee + fline3 + "\n";
            }
        }
        BufferedWriter bwss = new BufferedWriter(new FileWriter("src\\textFile\\votes"));
        bwss.append(voteee);
        bwss.close();

    }

    private void filter(String query) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }

    public static void save3(String firstn, String lastn, String value) throws IOException {
        BufferedWriter sv;
        sv = new BufferedWriter(new FileWriter("src\\textFile\\votes", true));
        sv.append(firstn + " " + lastn + " " + value + "\n");
        sv.close();
    }

    public static void save2(String name, String lastname, String gender2, String depart, String Posit, String Partyl) throws IOException {
        BufferedWriter sv;
        sv = new BufferedWriter(new FileWriter("src\\textFile\\candidates", true));
        sv.append(name + " " + lastname + " " + gender2 + " " + depart + " " + Posit + " " + Partyl + "\n");
        sv.close();
    }

    public static void save(String image, String name, String lastname) throws IOException {
        BufferedWriter sv;
        sv = new BufferedWriter(new FileWriter("src\\textFile\\imagepaths", true));
        sv.append(name + " " + lastname + " " + image + "\n");
        sv.close();
    }

    public void savez(String a, String path) throws IOException {

        BufferedWriter br;
        br = new BufferedWriter(new FileWriter(path));
        br.append(a + "\n");
        br.close();

    }

    private void showItem() throws FileNotFoundException {
        Scanner inp = new Scanner(System.in);
        try {
            inp = new Scanner(new FileReader("src\\textFile\\imagepaths"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(adminDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (inp.hasNextLine()) {
            String fetched = inp.nextLine();
            if (fetched.equals("")) {
                continue;
            }
            Scanner fetchedd = new Scanner(fetched);
            xd = fetchedd.next();
            yd = fetchedd.next();
            fullname.addItem(xd + " " + yd);

        }

        inp.close();
    }

    private void showItem2() throws FileNotFoundException {
        Scanner inp = new Scanner(System.in);
        try {
            inp = new Scanner(new FileReader("src\\textFile\\positions"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(adminDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (inp.hasNextLine()) {
            String fetched = inp.nextLine();
            if (fetched.equals("")) {
                continue;
            }
            Scanner fetchedd = new Scanner(fetched);
            xd = fetchedd.next();
            position.addItem(xd);
        }
        inp.close();
    }

    private void showItem3() throws FileNotFoundException {
        Scanner inp = new Scanner(System.in);
        try {
            inp = new Scanner(new FileReader("src\\textFile\\partylist"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(adminDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (inp.hasNextLine()) {
            String fetched = inp.nextLine();
            if (fetched.equals("")) {
                continue;
            }
            Scanner fetchedd = new Scanner(fetched);
            xd = fetchedd.next();
            partylist.addItem(xd);
        }

        inp.close();
    }

    //panelcolor start   
    public static void setColor(JPanel pane) {
        pane.setBackground(new Color(41, 57, 80));
    }

    public static void resetColor(JPanel[] pane, JPanel[] indicators) {
        for (int i = 0; i < pane.length; i++) {
            pane[i].setBackground(new Color(23, 35, 51));

        }
        for (int i = 0; i < indicators.length; i++) {
            indicators[i].setOpaque(false);
        }

    }
    //panel color end
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel20 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        side_pane = new javax.swing.JPanel();
        btn_1 = new javax.swing.JPanel();
        ind_1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btn_3 = new javax.swing.JPanel();
        ind_3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btn_8 = new javax.swing.JPanel();
        ind_8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        btn_12 = new javax.swing.JPanel();
        ind_12 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        btn_9 = new javax.swing.JPanel();
        ind_9 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        btn_4 = new javax.swing.JPanel();
        ind_4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        cdlayout = new javax.swing.JPanel();
        cd1 = new javax.swing.JPanel();
        homebackg = new javax.swing.JLabel();
        cd2 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        FN = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        partylist = new javax.swing.JComboBox<>();
        confirmedit = new javax.swing.JButton();
        LN = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        jButton4 = new javax.swing.JButton();
        department = new javax.swing.JComboBox<>();
        position = new javax.swing.JComboBox<>();
        edit1 = new javax.swing.JLabel();
        fullname = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        addedit = new javax.swing.JToggleButton();
        add = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        delete1 = new javax.swing.JButton();
        label = new javax.swing.JLabel();
        delete = new javax.swing.JButton();
        backg1 = new javax.swing.JLabel();
        cd3 = new javax.swing.JPanel();
        cd4 = new javax.swing.JPanel();
        cd5 = new javax.swing.JPanel();
        tabp1 = new javax.swing.JTabbedPane();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tab1 = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tab2 = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tab3 = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tab4 = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tab5 = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tab6 = new javax.swing.JTable();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tab7 = new javax.swing.JTable();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        tab8 = new javax.swing.JTable();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        tab9 = new javax.swing.JTable();
        showres = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        cd6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        search2 = new javax.swing.JButton();
        homepanel1 = new javax.swing.JPanel();
        change = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 486, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(23, 35, 51));

        side_pane.setBackground(new java.awt.Color(23, 35, 51));
        side_pane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_1.setBackground(new java.awt.Color(23, 35, 51));
        btn_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_1MousePressed(evt);
            }
        });

        ind_1.setOpaque(false);
        ind_1.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_1Layout = new javax.swing.GroupLayout(ind_1);
        ind_1.setLayout(ind_1Layout);
        ind_1Layout.setHorizontalGroup(
            ind_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_1Layout.setVerticalGroup(
            ind_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Home");

        javax.swing.GroupLayout btn_1Layout = new javax.swing.GroupLayout(btn_1);
        btn_1.setLayout(btn_1Layout);
        btn_1Layout.setHorizontalGroup(
            btn_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_1Layout.createSequentialGroup()
                .addComponent(ind_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel8)
                .addGap(0, 150, Short.MAX_VALUE))
        );
        btn_1Layout.setVerticalGroup(
            btn_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_1Layout.createSequentialGroup()
                .addComponent(ind_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        side_pane.add(btn_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 230, -1));

        btn_3.setBackground(new java.awt.Color(23, 35, 51));
        btn_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_3MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_3MousePressed(evt);
            }
        });

        ind_3.setOpaque(false);
        ind_3.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_3Layout = new javax.swing.GroupLayout(ind_3);
        ind_3.setLayout(ind_3Layout);
        ind_3Layout.setHorizontalGroup(
            ind_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_3Layout.setVerticalGroup(
            ind_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Manage Credentials");

        javax.swing.GroupLayout btn_3Layout = new javax.swing.GroupLayout(btn_3);
        btn_3.setLayout(btn_3Layout);
        btn_3Layout.setHorizontalGroup(
            btn_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_3Layout.createSequentialGroup()
                .addComponent(ind_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel10)
                .addGap(0, 54, Short.MAX_VALUE))
        );
        btn_3Layout.setVerticalGroup(
            btn_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_3Layout.createSequentialGroup()
                .addComponent(ind_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        side_pane.add(btn_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 230, -1));

        btn_8.setBackground(new java.awt.Color(23, 35, 51));
        btn_8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_8MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_8MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_8MouseReleased(evt);
            }
        });

        ind_8.setOpaque(false);
        ind_8.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_8Layout = new javax.swing.GroupLayout(ind_8);
        ind_8.setLayout(ind_8Layout);
        ind_8Layout.setHorizontalGroup(
            ind_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_8Layout.setVerticalGroup(
            ind_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("View Votes");

        javax.swing.GroupLayout btn_8Layout = new javax.swing.GroupLayout(btn_8);
        btn_8.setLayout(btn_8Layout);
        btn_8Layout.setHorizontalGroup(
            btn_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_8Layout.createSequentialGroup()
                .addComponent(ind_8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel13)
                .addGap(0, 116, Short.MAX_VALUE))
        );
        btn_8Layout.setVerticalGroup(
            btn_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_8Layout.createSequentialGroup()
                .addComponent(ind_8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        side_pane.add(btn_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 230, -1));

        btn_12.setBackground(new java.awt.Color(23, 35, 51));
        btn_12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_12MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_12MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_12MouseReleased(evt);
            }
        });

        ind_12.setOpaque(false);
        ind_12.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_12Layout = new javax.swing.GroupLayout(ind_12);
        ind_12.setLayout(ind_12Layout);
        ind_12Layout.setHorizontalGroup(
            ind_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_12Layout.setVerticalGroup(
            ind_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Search Candidate");

        javax.swing.GroupLayout btn_12Layout = new javax.swing.GroupLayout(btn_12);
        btn_12.setLayout(btn_12Layout);
        btn_12Layout.setHorizontalGroup(
            btn_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_12Layout.createSequentialGroup()
                .addComponent(ind_12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel17)
                .addGap(0, 70, Short.MAX_VALUE))
        );
        btn_12Layout.setVerticalGroup(
            btn_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_12Layout.createSequentialGroup()
                .addComponent(ind_12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        side_pane.add(btn_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 230, -1));

        btn_9.setBackground(new java.awt.Color(23, 35, 51));
        btn_9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_9MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_9MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_9MouseReleased(evt);
            }
        });

        ind_9.setOpaque(false);
        ind_9.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_9Layout = new javax.swing.GroupLayout(ind_9);
        ind_9.setLayout(ind_9Layout);
        ind_9Layout.setHorizontalGroup(
            ind_9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_9Layout.setVerticalGroup(
            ind_9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Log Out");

        javax.swing.GroupLayout btn_9Layout = new javax.swing.GroupLayout(btn_9);
        btn_9.setLayout(btn_9Layout);
        btn_9Layout.setHorizontalGroup(
            btn_9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_9Layout.createSequentialGroup()
                .addComponent(ind_9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel15)
                .addGap(0, 140, Short.MAX_VALUE))
        );
        btn_9Layout.setVerticalGroup(
            btn_9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_9Layout.createSequentialGroup()
                .addComponent(ind_9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        side_pane.add(btn_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 230, -1));

        btn_4.setBackground(new java.awt.Color(23, 35, 51));
        btn_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_4MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_4MousePressed(evt);
            }
        });

        ind_4.setOpaque(false);
        ind_4.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_4Layout = new javax.swing.GroupLayout(ind_4);
        ind_4.setLayout(ind_4Layout);
        ind_4Layout.setHorizontalGroup(
            ind_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_4Layout.setVerticalGroup(
            ind_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Verify Votees");

        javax.swing.GroupLayout btn_4Layout = new javax.swing.GroupLayout(btn_4);
        btn_4.setLayout(btn_4Layout);
        btn_4Layout.setHorizontalGroup(
            btn_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_4Layout.createSequentialGroup()
                .addComponent(ind_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel12)
                .addGap(0, 103, Short.MAX_VALUE))
        );
        btn_4Layout.setVerticalGroup(
            btn_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_4Layout.createSequentialGroup()
                .addComponent(ind_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        side_pane.add(btn_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 230, -1));

        cdlayout.setLayout(new java.awt.CardLayout());

        cd1.setBackground(new java.awt.Color(255, 255, 255));
        cd1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        cd1.add(homebackg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 910, 630));

        cdlayout.add(cd1, "card3");

        cd2.setBackground(new java.awt.Color(153, 255, 153));
        cd2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("First Name:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, -1, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Position:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, -1, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Department:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, -1, -1));

        FN.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel2.add(FN, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, 232, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Partylist:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, -1, -1));

        partylist.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        partylist.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a Partylist" }));
        partylist.setBorder(null);
        partylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partylistActionPerformed(evt);
            }
        });
        jPanel2.add(partylist, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 450, 230, -1));

        confirmedit.setBackground(new java.awt.Color(36, 47, 65));
        confirmedit.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        confirmedit.setForeground(new java.awt.Color(255, 255, 255));
        confirmedit.setText("EDIT");
        confirmedit.setBorder(null);
        confirmedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmeditActionPerformed(evt);
            }
        });
        jPanel2.add(confirmedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 270, 90, 50));

        LN.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        LN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LNActionPerformed(evt);
            }
        });
        jPanel2.add(LN, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 232, -1));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Last Name:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, -1, -1));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Gender:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, -1, -1));

        male.setBackground(new java.awt.Color(36, 47, 65));
        male.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        male.setForeground(new java.awt.Color(255, 255, 255));
        male.setText("Male");
        male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleActionPerformed(evt);
            }
        });
        jPanel2.add(male, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, -1, -1));

        female.setBackground(new java.awt.Color(36, 47, 65));
        female.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        female.setForeground(new java.awt.Color(255, 255, 255));
        female.setText("Female");
        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });
        jPanel2.add(female, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, 87, -1));

        jButton4.setBackground(new java.awt.Color(36, 47, 65));
        jButton4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("CLEAR");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 340, 90, 50));

        department.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        department.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Course", "CABE", "CEA", "CTE", "CCS", "CAH", "CMBS", "MUSIC", "NURSING", "CHEFS", "CPC" }));
        department.setBorder(null);
        jPanel2.add(department, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 230, -1));

        position.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        position.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Position" }));
        position.setBorder(null);
        position.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positionActionPerformed(evt);
            }
        });
        jPanel2.add(position, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 400, 230, -1));

        edit1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        edit1.setForeground(new java.awt.Color(255, 255, 255));
        edit1.setText("Name:");
        jPanel2.add(edit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, -1, -1));

        fullname.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        fullname.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Candidate" }));
        fullname.setBorder(null);
        fullname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullnameActionPerformed(evt);
            }
        });
        jPanel2.add(fullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 232, -1));

        jButton1.setBackground(new java.awt.Color(36, 47, 65));
        jButton1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("UPLOAD");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 90, 30));

        addedit.setBackground(new java.awt.Color(36, 47, 65));
        addedit.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        addedit.setForeground(new java.awt.Color(255, 255, 255));
        addedit.setText("Add");
        addedit.setBorder(null);
        addedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addeditActionPerformed(evt);
            }
        });
        jPanel2.add(addedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 70, 30));

        add.setBackground(new java.awt.Color(36, 47, 65));
        add.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("ADD");
        add.setBorder(null);
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel2.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 270, 90, 50));

        jButton2.setBackground(new java.awt.Color(36, 47, 65));
        jButton2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Add");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 450, 70, 30));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Modes:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, -1, -1));

        delete1.setBackground(new java.awt.Color(36, 47, 65));
        delete1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        delete1.setForeground(new java.awt.Color(255, 255, 255));
        delete1.setText("Delete");
        delete1.setBorder(null);
        delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete1ActionPerformed(evt);
            }
        });
        jPanel2.add(delete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 450, 70, 30));

        label.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        label.setForeground(new java.awt.Color(255, 255, 255));
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("Photo");
        label.setAlignmentY(0.0F);
        label.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 144, 142));

        delete.setBackground(new java.awt.Color(36, 47, 65));
        delete.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("Delete");
        delete.setBorder(null);
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel2.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 150, 70, 30));
        jPanel2.add(backg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 920, 630));

        cd2.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 610));

        cdlayout.add(cd2, "card2");

        cd3.setBackground(new java.awt.Color(255, 153, 153));

        javax.swing.GroupLayout cd3Layout = new javax.swing.GroupLayout(cd3);
        cd3.setLayout(cd3Layout);
        cd3Layout.setHorizontalGroup(
            cd3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 903, Short.MAX_VALUE)
        );
        cd3Layout.setVerticalGroup(
            cd3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );

        cdlayout.add(cd3, "card3");

        cd4.setBackground(new java.awt.Color(153, 255, 153));

        javax.swing.GroupLayout cd4Layout = new javax.swing.GroupLayout(cd4);
        cd4.setLayout(cd4Layout);
        cd4Layout.setHorizontalGroup(
            cd4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 903, Short.MAX_VALUE)
        );
        cd4Layout.setVerticalGroup(
            cd4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );

        cdlayout.add(cd4, "card2");

        cd5.setBackground(new java.awt.Color(255, 255, 255));

        tabp1.setBackground(new java.awt.Color(23, 35, 51));
        tabp1.setForeground(new java.awt.Color(255, 255, 255));
        tabp1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        tabp1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabp1MouseClicked(evt);
            }
        });

        jPanel12.setBackground(new java.awt.Color(36, 47, 65));
        jPanel12.setForeground(new java.awt.Color(255, 255, 255));
        jPanel12.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jScrollPane2.setBackground(new java.awt.Color(36, 47, 65));
        jScrollPane2.setBorder(null);
        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        tab1.setBackground(new java.awt.Color(36, 47, 65));
        tab1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tab1.setForeground(new java.awt.Color(255, 255, 255));
        tab1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Surname", "Gender", "Department", "Position", "Partylist", "No. of Votes"
            }
        ));
        tab1.setEnabled(false);
        tab1.setFillsViewportHeight(true);
        tab1.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(tab1);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
        );

        tabp1.addTab("GOVERNOR", jPanel12);

        jPanel13.setForeground(new java.awt.Color(255, 255, 255));
        jPanel13.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jScrollPane10.setBackground(new java.awt.Color(36, 47, 65));
        jScrollPane10.setBorder(null);
        jScrollPane10.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane10.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        tab2.setBackground(new java.awt.Color(36, 47, 65));
        tab2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tab2.setForeground(new java.awt.Color(255, 255, 255));
        tab2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Surname", "Gender", "Department", "Position", "Partylist", "No. of Votes"
            }
        ));
        tab2.setFillsViewportHeight(true);
        tab2.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane10.setViewportView(tab2);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
        );

        tabp1.addTab("VG-INTERNAL", jPanel13);

        jPanel15.setForeground(new java.awt.Color(255, 255, 255));
        jPanel15.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jScrollPane11.setBackground(new java.awt.Color(36, 47, 65));
        jScrollPane11.setBorder(null);
        jScrollPane11.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane11.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        tab3.setBackground(new java.awt.Color(36, 47, 65));
        tab3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tab3.setForeground(new java.awt.Color(255, 255, 255));
        tab3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Surname", "Gender", "Department", "Position", "Partylist", "No. of Votes"
            }
        ));
        tab3.setFillsViewportHeight(true);
        tab3.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane11.setViewportView(tab3);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
        );

        tabp1.addTab("VG-EXTERNAL", jPanel15);

        jPanel16.setForeground(new java.awt.Color(255, 255, 255));
        jPanel16.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jScrollPane12.setBackground(new java.awt.Color(36, 47, 65));
        jScrollPane12.setBorder(null);
        jScrollPane12.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane12.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        tab4.setBackground(new java.awt.Color(36, 47, 65));
        tab4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tab4.setForeground(new java.awt.Color(255, 255, 255));
        tab4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Surname", "Gender", "Department", "Position", "Partylist", "No. of Votes"
            }
        ));
        tab4.setFillsViewportHeight(true);
        tab4.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane12.setViewportView(tab4);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
        );

        tabp1.addTab("SECRETARY", jPanel16);

        jPanel17.setForeground(new java.awt.Color(255, 255, 255));
        jPanel17.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jScrollPane13.setBackground(new java.awt.Color(36, 47, 65));
        jScrollPane13.setBorder(null);
        jScrollPane13.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane13.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        tab5.setBackground(new java.awt.Color(36, 47, 65));
        tab5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tab5.setForeground(new java.awt.Color(255, 255, 255));
        tab5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Surname", "Gender", "Department", "Position", "Partylist", "No. of Votes"
            }
        ));
        tab5.setFillsViewportHeight(true);
        tab5.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane13.setViewportView(tab5);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
        );

        tabp1.addTab("ASSISTANT-SECRETARY", jPanel17);

        jPanel18.setForeground(new java.awt.Color(255, 255, 255));
        jPanel18.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jScrollPane14.setBackground(new java.awt.Color(36, 47, 65));
        jScrollPane14.setBorder(null);
        jScrollPane14.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane14.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        tab6.setBackground(new java.awt.Color(36, 47, 65));
        tab6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tab6.setForeground(new java.awt.Color(255, 255, 255));
        tab6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Surname", "Gender", "Department", "Position", "Partylist", "No. of Votes"
            }
        ));
        tab6.setFillsViewportHeight(true);
        tab6.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane14.setViewportView(tab6);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
        );

        tabp1.addTab("TREASURER", jPanel18);

        jPanel19.setForeground(new java.awt.Color(255, 255, 255));
        jPanel19.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jScrollPane15.setBackground(new java.awt.Color(36, 47, 65));
        jScrollPane15.setBorder(null);
        jScrollPane15.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane15.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        tab7.setBackground(new java.awt.Color(36, 47, 65));
        tab7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tab7.setForeground(new java.awt.Color(255, 255, 255));
        tab7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Surname", "Gender", "Department", "Position", "Partylist", "No. of Votes"
            }
        ));
        tab7.setFillsViewportHeight(true);
        tab7.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane15.setViewportView(tab7);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
        );

        tabp1.addTab("PIO", jPanel19);

        jPanel21.setForeground(new java.awt.Color(255, 255, 255));
        jPanel21.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jScrollPane16.setBackground(new java.awt.Color(36, 47, 65));
        jScrollPane16.setBorder(null);
        jScrollPane16.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane16.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        tab8.setBackground(new java.awt.Color(36, 47, 65));
        tab8.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tab8.setForeground(new java.awt.Color(255, 255, 255));
        tab8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Surname", "Gender", "Department", "Position", "Partylist", "No. of Votes"
            }
        ));
        tab8.setEnabled(false);
        tab8.setFillsViewportHeight(true);
        tab8.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane16.setViewportView(tab8);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
        );

        tabp1.addTab("AUDITOR", jPanel21);

        jPanel22.setBackground(new java.awt.Color(36, 47, 65));
        jPanel22.setForeground(new java.awt.Color(255, 255, 255));
        jPanel22.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jScrollPane17.setBackground(new java.awt.Color(36, 47, 65));
        jScrollPane17.setBorder(null);
        jScrollPane17.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane17.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        tab9.setBackground(new java.awt.Color(36, 47, 65));
        tab9.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tab9.setForeground(new java.awt.Color(255, 255, 255));
        tab9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Surname", "Gender", "Department", "Position", "Partylist", "No. of Votes"
            }
        ));
        tab9.setEnabled(false);
        tab9.setFillsViewportHeight(true);
        tab9.setGridColor(new java.awt.Color(255, 255, 255));
        tab9.setInheritsPopupMenu(true);
        tab9.setSelectionForeground(new java.awt.Color(153, 153, 255));
        jScrollPane17.setViewportView(tab9);

        showres.setText("SHOW RESULTS");
        showres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showresActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Course", "CABE", "CEA", "CTE", "CCS", "CAH", "CMBS", "MUSIC", "NURSING", "CHEFS", "CPC" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(showres)
                .addGap(22, 22, 22))
            .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                .addGap(41, 41, 41)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showres))
                .addGap(42, 42, 42))
        );

        tabp1.addTab("SHOW ALL", jPanel22);

        javax.swing.GroupLayout cd5Layout = new javax.swing.GroupLayout(cd5);
        cd5.setLayout(cd5Layout);
        cd5Layout.setHorizontalGroup(
            cd5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cd5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(tabp1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        cd5Layout.setVerticalGroup(
            cd5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cd5Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(tabp1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        cdlayout.add(cd5, "card2");

        cd6.setBackground(new java.awt.Color(255, 153, 153));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel1.setText("Search Candidate:");

        jTextField1.setBackground(new java.awt.Color(36, 47, 65));
        jTextField1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));

        table.setBackground(new java.awt.Color(36, 47, 65));
        table.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        table.setForeground(new java.awt.Color(255, 255, 255));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First Name", "Lasts Name", "Position", "Partylist", "Department"
            }
        ));
        table.setToolTipText("");
        table.setEnabled(false);
        table.setFillsViewportHeight(true);
        table.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(table);

        search2.setBackground(new java.awt.Color(36, 47, 65));
        search2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        search2.setForeground(new java.awt.Color(255, 255, 255));
        search2.setText("Search");
        search2.setBorder(null);
        search2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(search2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 807, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cd6Layout = new javax.swing.GroupLayout(cd6);
        cd6.setLayout(cd6Layout);
        cd6Layout.setHorizontalGroup(
            cd6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cd6Layout.setVerticalGroup(
            cd6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        cdlayout.add(cd6, "card3");

        homepanel1.setBackground(new java.awt.Color(23, 35, 51));
        homepanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                homepanel1MouseDragged(evt);
            }
        });
        homepanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                homepanel1MousePressed(evt);
            }
        });

        change.setFont(new java.awt.Font("Century Gothic", 1, 30)); // NOI18N
        change.setForeground(new java.awt.Color(255, 255, 255));
        change.setText("ADMIN DASHBOARD");

        javax.swing.GroupLayout homepanel1Layout = new javax.swing.GroupLayout(homepanel1);
        homepanel1.setLayout(homepanel1Layout);
        homepanel1Layout.setHorizontalGroup(
            homepanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homepanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(change)
                .addContainerGap(640, Short.MAX_VALUE))
        );
        homepanel1Layout.setVerticalGroup(
            homepanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homepanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(change)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(side_pane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homepanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cdlayout, javax.swing.GroupLayout.PREFERRED_SIZE, 903, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(side_pane, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(homepanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(cdlayout, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1127, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setVisible(false);
        dispose();
        addPartylist x = new addPartylist();
        x.setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        addcandidatee();
    }//GEN-LAST:event_addActionPerformed

    private void addeditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addeditActionPerformed
        toggleoption();
    }//GEN-LAST:event_addeditActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        imagefilechoose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void fullnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullnameActionPerformed
        checkcombobox();
        label.setText("");
        String veri = fullname.getSelectedItem().toString();
        if (veri.equals("Select Candidate")) {
            confirmedit.setEnabled(false);
        } else {
            confirmedit.setEnabled(true);
        }
    }//GEN-LAST:event_fullnameActionPerformed

    private void femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleActionPerformed
        // TODO add your handling code here:
        male.setSelected(false);
    }//GEN-LAST:event_femaleActionPerformed

    private void maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleActionPerformed
        // TODO add your handling code here:
        female.setSelected(false);
    }//GEN-LAST:event_maleActionPerformed

    private void LNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LNActionPerformed

    private void confirmeditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmeditActionPerformed
        editcandidatee();
    }//GEN-LAST:event_confirmeditActionPerformed


    private void btn_12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_12MouseClicked
        change.setText("SEARCH PROFILE");
        cd6.setVisible(true);
        cd1.setVisible(false);
        cd3.setVisible(false);
        cd2.setVisible(false);
        cd4.setVisible(false);
        cd5.setVisible(false);
    }//GEN-LAST:event_btn_12MouseClicked

    private void btn_12MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_12MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_12MouseReleased

    private void btn_12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_12MousePressed
        setColor(btn_12);
        ind_12.setOpaque(true);
        resetColor(new JPanel[]{btn_3, btn_1, btn_8, btn_9, btn_4}, new JPanel[]{ind_3, ind_1, ind_8, ind_9, ind_4});
    }//GEN-LAST:event_btn_12MousePressed

    private void btn_8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_8MouseClicked
        change.setText("VIEW VOTES");
        cd5.setVisible(true);
        cd2.setVisible(false);
        cd3.setVisible(false);
        cd4.setVisible(false);
        cd1.setVisible(false);
        cd6.setVisible(false);
    }//GEN-LAST:event_btn_8MouseClicked

    private void btn_8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_8MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_8MouseReleased

    private void btn_8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_8MousePressed
        setColor(btn_8);
        ind_8.setOpaque(true);
        resetColor(new JPanel[]{btn_3, btn_1, btn_12, btn_9, btn_4}, new JPanel[]{ind_3, ind_1, ind_12, ind_9, ind_4});
    }//GEN-LAST:event_btn_8MousePressed

    private void btn_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_3MouseClicked
        change.setText("CANDIDATE PROFILE");
        cd2.setVisible(true);
        cd1.setVisible(false);
        cd3.setVisible(false);
        cd4.setVisible(false);
        cd5.setVisible(false);
        cd6.setVisible(false);
    }//GEN-LAST:event_btn_3MouseClicked

    private void btn_3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_3MousePressed
        // TODO add your handling code here:
        setColor(btn_3);
        ind_3.setOpaque(true);
        resetColor(new JPanel[]{btn_1, btn_8, btn_12, btn_9, btn_4}, new JPanel[]{ind_1, ind_12, ind_8, ind_12, ind_9, ind_4});
    }//GEN-LAST:event_btn_3MousePressed

    private void btn_1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_1MousePressed
        // TODO add your handling code here:
        setColor(btn_1);
        ind_1.setOpaque(true);
        resetColor(new JPanel[]{btn_3, btn_12, btn_8, btn_9, btn_4}, new JPanel[]{ind_3, ind_12, ind_8, ind_9, ind_4});
    }//GEN-LAST:event_btn_1MousePressed

    private void btn_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_1MouseClicked
        change.setText("ADMIN DASHBOARD");
        cd1.setVisible(true);
        cd2.setVisible(false);
        cd3.setVisible(false);
        cd4.setVisible(false);
        cd5.setVisible(false);
        cd6.setVisible(false);
    }//GEN-LAST:event_btn_1MouseClicked

    private void homepanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homepanel1MousePressed
        // TODO add your handling code here:
        //drag this pane
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_homepanel1MousePressed

    private void homepanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homepanel1MouseDragged
        // TODO add your handling code here:

        //source to drag
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_homepanel1MouseDragged

    private void partylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partylistActionPerformed

    }//GEN-LAST:event_partylistActionPerformed

    private void positionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positionActionPerformed

    }//GEN-LAST:event_positionActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        FN.setText("");
        LN.setText("");
        female.setSelected(false);
        male.setSelected(false);
        department.setSelectedIndex(0);
        position.setSelectedIndex(0);
        partylist.setSelectedIndex(0);
        label.setText("Picture");
        JOptionPane.showMessageDialog(null, "Cleared");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed

        try {
            delete();
            JOptionPane.showMessageDialog(null, "Deleted Reloading..");
            dispose();
            adminDashboard x = new adminDashboard();
            x.setVisible(true);
            res();

        } catch (IOException ex) {
            Logger.getLogger(adminDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void search2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search2ActionPerformed
        searchCandidate();
    }//GEN-LAST:event_search2ActionPerformed

    private void btn_9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_9MouseClicked
        ImageIcon icon = new ImageIcon("src\\icons\\exit.png");
        int yesorno = JOptionPane.showConfirmDialog(null, "Confirm Log Out", "Log Out", JOptionPane.YES_NO_OPTION, JOptionPane.NO_OPTION, icon);
        if (yesorno == 0) {
            dispose();
            new login().setVisible(true);
        } else {

        }
    }//GEN-LAST:event_btn_9MouseClicked

    private void btn_9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_9MousePressed
        setColor(btn_9);
        ind_9.setOpaque(true);
        resetColor(new JPanel[]{btn_3, btn_12, btn_8, btn_1, btn_4}, new JPanel[]{ind_3, ind_12, ind_8, ind_1, ind_4});
    }//GEN-LAST:event_btn_9MousePressed

    private void btn_9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_9MouseReleased

    }//GEN-LAST:event_btn_9MouseReleased

    private void tabp1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabp1MouseClicked
        tablePaneClicked();
    }//GEN-LAST:event_tabp1MouseClicked

    private void btn_4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_4MouseClicked
        change.setText("ADMIN DASHBOARD");
        dispose();
        new verifierDashboard().setVisible(true);
        adminDashboard x = new adminDashboard();
        x.setEnabled(false);
        cd4.setVisible(false);
        cd1.setVisible(false);
        cd2.setVisible(false);
        cd3.setVisible(false);
        cd5.setVisible(false);
        cd6.setVisible(false);
    }//GEN-LAST:event_btn_4MouseClicked

    private void btn_4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_4MousePressed
        setColor(btn_4);
        ind_4.setOpaque(true);
        resetColor(new JPanel[]{btn_3, btn_12, btn_8, btn_1, btn_9}, new JPanel[]{ind_3, ind_12, ind_8, ind_1, ind_9});
    }//GEN-LAST:event_btn_4MousePressed

    private void showresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showresActionPerformed
        dispose();
        new voteResult().setVisible(true);
        setVisible(false);
        String val = jComboBox1.getSelectedItem().toString();
        valuee(val);
        voteResult.departmentz.setText("Winner Results For " + val);
    }//GEN-LAST:event_showresActionPerformed

    public void valuee(String departss) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        ArrayList<Integer> list4 = new ArrayList<Integer>();
        ArrayList<Integer> list5 = new ArrayList<Integer>();
        ArrayList<Integer> list6 = new ArrayList<Integer>();
        ArrayList<Integer> list7 = new ArrayList<Integer>();
        ArrayList<Integer> list8 = new ArrayList<Integer>();
        int asdd = 0, asdf = 0;
        for (int i = 0; i < tab9.getRowCount(); i++) {
            int asd = 0;

            if ((tab9.getValueAt(i, 4).toString()).equals("GOVERNOR") && (tab9.getValueAt(i, 3).toString()).equals(departss)) {
                list.add(Integer.parseInt(tab9.getValueAt(i, 6).toString()));
                asd = Collections.max(list);

                if ((Integer.parseInt((String) tab9.getValueAt(i, 6))) == asd) {

                    String name = tab9.getValueAt(i, 0).toString();
                    String surname = tab9.getValueAt(i, 1).toString();
                    String linee1 = name + " " + surname;
                    voteResult.poss1.setText(linee1);
                    voteResult.v1.setText(Integer.toString(asd));
                }
            }
            if ((tab9.getValueAt(i, 4).toString()).equals("VG-INTERNAL") && (tab9.getValueAt(i, 3).toString()).equals(departss)) {
                list2.add(Integer.parseInt(tab9.getValueAt(i, 6).toString()));
                asd = Collections.max(list2);

                if ((Integer.parseInt((String) tab9.getValueAt(i, 6))) == asd) {

                    String name = tab9.getValueAt(i, 0).toString();
                    String surname = tab9.getValueAt(i, 1).toString();
                    String linee1 = name + " " + surname;
                    voteResult.poss2.setText(linee1);
                    voteResult.v2.setText(Integer.toString(asd));
                }
            }

            if ((tab9.getValueAt(i, 4).toString()).equals("VG-EXTERNAL") && (tab9.getValueAt(i, 3).toString()).equals(departss)) {
                list3.add(Integer.parseInt(tab9.getValueAt(i, 6).toString()));
                asd = Collections.max(list3);

                if ((Integer.parseInt((String) tab9.getValueAt(i, 6))) == asd) {
                    String name = tab9.getValueAt(i, 0).toString();
                    String surname = tab9.getValueAt(i, 1).toString();
                    String linee1 = name + " " + surname;
                    voteResult.poss3.setText(linee1);
                    voteResult.v3.setText(Integer.toString(asd));
                }
            }
            if ((tab9.getValueAt(i, 4).toString()).equals("SECRETARY") && (tab9.getValueAt(i, 3).toString()).equals(departss)) {
                list4.add(Integer.parseInt(tab9.getValueAt(i, 6).toString()));
                asd = Collections.max(list4);

                if ((Integer.parseInt((String) tab9.getValueAt(i, 6))) == asd) {
                    String name = tab9.getValueAt(i, 0).toString();
                    String surname = tab9.getValueAt(i, 1).toString();
                    String linee1 = name + " " + surname;
                    voteResult.poss4.setText(linee1);
                    voteResult.v4.setText(Integer.toString(asd));
                }
            }

            if ((tab9.getValueAt(i, 4).toString()).equals("ASSISTANT-SECRETARY") && (tab9.getValueAt(i, 3).toString()).equals(departss)) {
                list5.add(Integer.parseInt(tab9.getValueAt(i, 6).toString()));
                asd = Collections.max(list5);

                if ((Integer.parseInt((String) tab9.getValueAt(i, 6))) == asd) {
                    String name = tab9.getValueAt(i, 0).toString();
                    String surname = tab9.getValueAt(i, 1).toString();
                    String linee1 = name + " " + surname;
                    voteResult.poss5.setText(linee1);
                    voteResult.v5.setText(Integer.toString(asd));
                }
            }
            if ((tab9.getValueAt(i, 4).toString()).equals("TREASURER") && (tab9.getValueAt(i, 3).toString()).equals(departss)) {
                list6.add(Integer.parseInt(tab9.getValueAt(i, 6).toString()));
                asd = Collections.max(list6);

                if ((Integer.parseInt((String) tab9.getValueAt(i, 6))) == asd) {
                    String name = tab9.getValueAt(i, 0).toString();
                    String surname = tab9.getValueAt(i, 1).toString();
                    String linee1 = name + " " + surname;
                    voteResult.poss6.setText(linee1);
                    voteResult.v6.setText(Integer.toString(asd));
                }
            }

            if ((tab9.getValueAt(i, 4).toString()).equals("AUDITOR") && (tab9.getValueAt(i, 3).toString()).equals(departss)) {
                list7.add(Integer.parseInt(tab9.getValueAt(i, 6).toString()));
                asd = Collections.max(list7);

                if ((Integer.parseInt((String) tab9.getValueAt(i, 6))) == asd) {
                    String name = tab9.getValueAt(i, 0).toString();
                    String surname = tab9.getValueAt(i, 1).toString();
                    String linee1 = name + " " + surname;
                    voteResult.poss7.setText(linee1);
                    voteResult.v7.setText(Integer.toString(asd));
                }
            }
            if ((tab9.getValueAt(i, 4).toString()).equals("PIO") && (tab9.getValueAt(i, 3).toString()).equals(departss)) {
                list8.add(Integer.parseInt(tab9.getValueAt(i, 6).toString()));
                asd = Collections.max(list8);

                if ((Integer.parseInt((String) tab9.getValueAt(i, 6))) == asd) {
                    String name = tab9.getValueAt(i, 0).toString();
                    String surname = tab9.getValueAt(i, 1).toString();
                    String linee1 = name + " " + surname;
                    voteResult.poss8.setText(linee1);
                    voteResult.v8.setText(Integer.toString(asd));
                }
            }

        }
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        jComboBox1.removeItem("Select Course");
        showres.setEnabled(true);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete1ActionPerformed
        verifyy();
        JOptionPane.showMessageDialog(null, "Deleted Reloading..");
        dispose();
        adminDashboard x = new adminDashboard();
        x.setVisible(true);
        res();

    }//GEN-LAST:event_delete1ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(adminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField FN;
    public static javax.swing.JTextField LN;
    public static javax.swing.JButton add;
    public static javax.swing.JToggleButton addedit;
    private javax.swing.JLabel backg1;
    public static javax.swing.JPanel btn_1;
    public static javax.swing.JPanel btn_12;
    public static javax.swing.JPanel btn_3;
    public static javax.swing.JPanel btn_4;
    public static javax.swing.JPanel btn_8;
    public static javax.swing.JPanel btn_9;
    public static javax.swing.JPanel cd1;
    public static javax.swing.JPanel cd2;
    public static javax.swing.JPanel cd3;
    public static javax.swing.JPanel cd4;
    public static javax.swing.JPanel cd5;
    public static javax.swing.JPanel cd6;
    private javax.swing.JPanel cdlayout;
    public static javax.swing.JLabel change;
    public static javax.swing.JButton confirmedit;
    public static javax.swing.JButton delete;
    public static javax.swing.JButton delete1;
    public static javax.swing.JComboBox<String> department;
    public static javax.swing.JLabel edit1;
    public static javax.swing.JRadioButton female;
    public static javax.swing.JComboBox<String> fullname;
    private javax.swing.JLabel homebackg;
    private javax.swing.JPanel homepanel1;
    public static javax.swing.JPanel ind_1;
    public static javax.swing.JPanel ind_12;
    public static javax.swing.JPanel ind_3;
    public static javax.swing.JPanel ind_4;
    public static javax.swing.JPanel ind_8;
    public static javax.swing.JPanel ind_9;
    private javax.swing.JButton jButton1;
    public static javax.swing.JButton jButton2;
    public static javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel12;
    public static javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    public static javax.swing.JPanel jPanel15;
    public static javax.swing.JPanel jPanel16;
    public static javax.swing.JPanel jPanel17;
    public static javax.swing.JPanel jPanel18;
    public static javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanel20;
    public static javax.swing.JPanel jPanel21;
    public static javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    public static javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel label;
    public static javax.swing.JRadioButton male;
    public static javax.swing.JComboBox<String> partylist;
    public static javax.swing.JComboBox<String> position;
    private javax.swing.JButton search2;
    private javax.swing.JButton showres;
    private javax.swing.JPanel side_pane;
    private javax.swing.JTable tab1;
    private javax.swing.JTable tab2;
    private javax.swing.JTable tab3;
    private javax.swing.JTable tab4;
    private javax.swing.JTable tab5;
    private javax.swing.JTable tab6;
    private javax.swing.JTable tab7;
    private javax.swing.JTable tab8;
    public static javax.swing.JTable tab9;
    private javax.swing.JTable table;
    public static javax.swing.JTabbedPane tabp1;
    // End of variables declaration//GEN-END:variables
}
