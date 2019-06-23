import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class MainFrame extends JFrame {
    private RightPanel rightPanel = new RightPanel();
    JLabel jLabel;
    Song song;
    int i = 0;
    Album album = new Album("myAlbume");
    private CenterPanel centerPanel = new CenterPanel();

    public MainFrame() {
        this.setTitle("Binarify");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1300, 700);
        LeftPanel leftPanel = new LeftPanel();
        this.add(leftPanel, BorderLayout.WEST);
        SouthPanel southPanel = new SouthPanel();
        this.add(southPanel, BorderLayout.PAGE_END);
        this.add(rightPanel, BorderLayout.EAST);
        this.getContentPane().add(centerPanel, BorderLayout.CENTER);
        this.setVisible(true);
        MyListener myListener = new MyListener();
        leftPanel.getAddToLibraryIcon().addActionListener(myListener);
        SongsButten songsButten = new SongsButten();
        leftPanel.songs.addActionListener(songsButten);
    }

    private class MyListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            String name = "", path = "";
            int returnValue = jfc.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jfc.getSelectedFile();
                path = selectedFile.getAbsolutePath();
                name = selectedFile.getName();
                song = new Song(path, name);
                System.out.println(song.getArtistName());
                album.setSong(song);

//                Image temp=new ImageIcon(song.getImageData()).getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
//                JButton jButton1=new JButton();
//                jButton1.setBorderPainted(false);
//                jButton1.setFocusPainted(false);
//                jButton1.setIcon(new ImageIcon(temp));
//                centerPanel.add(jButton1,FlowLayout.LEFT);
            }

        }
    }

    private class SongsButten implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            centerPanel.setVisible(false);
            centerPanel.jLabel.setText(" ");
            for (; i < album.getSongs().size(); i++) {
                Image temp = new ImageIcon(song.getImageData()).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
                JButton jButton1 = new JButton();
                jButton1.setBorderPainted(false);
                jButton1.setFocusPainted(false);
                jButton1.setIcon(new ImageIcon(temp));
                centerPanel.add(jButton1, FlowLayout.LEFT);
            }
            centerPanel.setVisible(true);
        }
    }
}
