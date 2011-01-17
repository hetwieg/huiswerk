import java.awt.Dimension;
import java.awt.Toolkit;

public class Vraag extends javax.swing.JFrame {
    protected javax.swing.JPanel pnlAndwoorden;
    protected javax.swing.JLabel lblVraag;
    
    public Vraag()
    {
	lblVraag = new javax.swing.JLabel();
	pnlAndwoorden = new javax.swing.JPanel();
	
	// Scherm instellen
	//setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setAlwaysOnTop(true);
        this.setUndecorated(true);
	
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); // Scherm grote opvragen
	
        this.setLocation(0, 0);
        this.setSize(dim);
	
	// Pannel toevoegen
	pnlAndwoorden.setSize(dim.getSize().width, 300);
	pnlAndwoorden.setLocation(0, dim.getSize().height - 300);
	pnlAndwoorden.setBackground(new java.awt.Color(0, 128, 70));
	
	// Add gedoe
	this.add(pnlAndwoorden);
	this.add(lblVraag);
    }

    private void addAndwoord(String button, String Andwoord)
    {
	// Debug
	System.out.println("AA: " + button + " = " + Andwoord);
	
	// Elementen aanmaken
	javax.swing.JPanel pnl = new javax.swing.JPanel();
	javax.swing.JLabel lbl = new javax.swing.JLabel();
	javax.swing.JButton cmd = new javax.swing.JButton();
	
	// pnl gereet maken
	pnl.setBackground(new java.awt.Color(200, 200, 100, 70));
	pnl.setBorder(javax.swing.BorderFactory.createEtchedBorder());
	
	// Button gereet maken
	cmd.setFont(new java.awt.Font("DejaVu Sans", 1, 36));
	cmd.setText(button);
        cmd.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
	cmd.setSize(30, 30);
	cmd.setLocation(5, 5);
	
	// Label gereet maken
        lbl.setFont(new java.awt.Font("DejaVu Sans", 1, 12));
	lbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbl.setText(Andwoord);
        lbl.setBorder(null);
	lbl.setLocation(40, 5);
	lbl.setSize(100, 100);
	
	// Locaties permanent maken
	javax.swing.GroupLayout Layout = new javax.swing.GroupLayout(pnl);
	pnl.setLayout(Layout);
	
	Layout.setHorizontalGroup(
	       Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	       .addGroup(Layout.createSequentialGroup()
		 .addComponent(cmd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
		 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		 .addComponent(lbl, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
	);

	Layout.setVerticalGroup(
	       Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	       .addGroup(Layout.createSequentialGroup()
		  .addComponent(cmd,javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
		  .addContainerGap(10, Short.MAX_VALUE))
	       .addComponent(lbl, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
	
	// Gedoe met add
	pnl.add(cmd);
	pnl.add(lbl);
	pnlAndwoorden.add(pnl);
    }

    public static void Show(String value, String Andwoorden[], int Time)
    {
	// Vraag scherm aanmaken
	Vraag vraag = new Vraag();
	
	// Vraag invullen
	vraag.lblVraag.setText(value);
	
	for(int i=0;i<Andwoorden.length;i++) {
	    // Tekens voor de eerste | gebruiken als opschrift button
	    String[] tekens = Andwoorden[i].split("|",3); // Preg voor splitsen op |
	    vraag.addAndwoord(tekens[1], tekens[2]);
	}
	
	// Grote bepalen
	switch(Andwoorden.length) {
	case 1:
	case 2:
	    vraag.pnlAndwoorden.setLayout(new java.awt.GridLayout(2, 0, 5, 5));
	    break;
	case 3:
	    vraag.pnlAndwoorden.setLayout(new java.awt.GridLayout(3, 0, 5, 5));
	    break;
	case 4:
	    vraag.pnlAndwoorden.setLayout(new java.awt.GridLayout(2, 2, 5, 5));
	    break;
	case 5:
	case 6:
	    vraag.pnlAndwoorden.setLayout(new java.awt.GridLayout(3, 2, 5, 5));
	    break;
	}

	// Vraag scherm tonen
	vraag.setVisible(true);
    }
}