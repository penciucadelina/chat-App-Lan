package chatapplication;
import java.awt.Color;

/**
 * @author Adelina
 */
public class ChatApp extends javax.swing.JFrame {
    static String name;

    public ChatApp() {
        this.setTitle("ChatApp");
        this.setUndecorated(true);
        initComponents();
        getContentPane().setBackground(Color.pink);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 160));
        setFont(new java.awt.Font("Cambria", 2, 12));
        setForeground(new java.awt.Color(208, 255, 0));

        jButton2.setFont(new java.awt.Font("Arial", 1, 24));
        jButton2.setText("Login to Chat Room");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial", 2, 24)); //
        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(382, Short.MAX_VALUE).addComponent(jButton3).addContainerGap(95, Short.MAX_VALUE)).addGroup(layout.createSequentialGroup().addGap(161, 161, 161).addComponent(jButton2).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(172, Short.MAX_VALUE).addComponent(jButton2).addGap(121, 121, 121).addComponent(jButton3).addGap(37, 37, 37)));

        pack();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        new MultiClient();
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        System.exit(1);
    }


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatApp().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
}