import java.awt.*;
import java.awt.event.*;
import java.io.*;

class charuNotepad implements ActionListener {

    Frame f;
    MenuBar mb;
    Menu mf1, me1;
    MenuItem fm1, fm2, fm3, fm4;
    Button b1, b2;
    Dialog dg;

    PopupMenu pop1;

    TextArea tf1;
    charuNotepad() {
        b1 = new Button("no");
        b2 = new Button("yes");

        f = new Frame("Charu's NotePad");

        mb = new MenuBar();
        mf1 = new Menu("file");
        fm1 = new MenuItem("new");
        fm3 = new MenuItem("open");
        fm4 = new MenuItem("save");
        fm2 = new MenuItem("pdf");

        mf1.add(fm1);
        mf1.add(fm3);
        mf1.add(fm4);

        me1 = new Menu("edit");
        tf1 = new TextArea();

        pop1 = new PopupMenu("save as");
        mf1.addSeparator();
        mf1.add(pop1);
        pop1.add(fm2);

        f.setMenuBar(mb);

        mb.add(mf1);
        mb.add(me1);
        f.add(tf1);
        fm1.addActionListener(this);
        fm3.addActionListener(this);
        fm4.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);

        f.setSize(400, 400);
        f.setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        String act = ae.getActionCommand();
        System.out.println(" " + act);
        if (act == "new") {

            tf1.setText(" ");
        }
        //////////////////////////open file////////////////////
        if (act == "open") {
            FileDialog fd = new FileDialog(f, "openfile");
            fd.show();
            String n1 = fd.getFile();
            String n2 = fd.getDirectory();
            //System.out.println(fd.getDirectory()+" "+  n1);
            try {
                FileInputStream fis = new FileInputStream(n2 + n1);

                byte b[] = new byte[763];
                System.out.println(" file present :  " + fis.available());
                int cap = fis.available();


                if ((fis.read(b)) == -1) {}
                //System.out.println(new String(b,0,cap));
                tf1.setText(new String(b, 0, cap));
                f.setTitle(n2 + n1);



            } catch (Exception e) {}

        } //if close

        ///////////////////////save file//////////////////
        if (act == "no") {
            System.out.println("no");
            dg.dispose();
        }

        if (act == "save") {


            //tf1.setText(" save");
            dg = new Dialog(f, "Do you want to save this file");
            dg.setLayout(new FlowLayout());
            dg.add(b1);
            dg.add(b2);
            dg.show();


            FileDialog fd1 = new FileDialog(f, "save", FileDialog.SAVE);
            fd1.show();
            String n1 = fd1.getFile();
            String n2 = fd1.getDirectory();

            try {
                FileOutputStream fis = new FileOutputStream(n2 + n1);
                String sto = tf1.getText();
                byte b2[] = sto.getBytes();
                fis.write(b2);
                System.out.println("" + n2);
            } catch (Exception e) {}

        }



    } //method close

    public static void main(String args[]) {
        new charuNotepad();

    }

}