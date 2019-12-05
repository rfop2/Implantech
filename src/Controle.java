import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class Controle extends JFrame {

	private JPanel contentPane;
	private JTextField tipoTextField;
	private JTable table;
	private MaquinaDAO maquinaDAO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controle frame = new Controle();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public Controle() throws FileNotFoundException, IOException, SQLException {
		
		maquinaDAO = new MaquinaDAO();
		
		setTitle("Implantech");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Enter tipo");
		panel.add(lblNewLabel);
		
		tipoTextField = new JTextField();
		panel.add(tipoTextField);
		tipoTextField.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String tipo = tipoTextField.getText();

					List<Maquina> maquinas = null;

					if (tipo != null && tipo.trim().length() > 0) {
						maquinas = maquinaDAO.searchMaquinas(tipo);
					} else {
						maquinas = maquinaDAO.getAllMaquinas();
					}
					
					// create the model and update the "table"
					MaquinaTableModel model = new MaquinaTableModel(maquinas);
					
					table.setModel(model);
					
					/*
					for (Employee temp : employees) {
						System.out.println(temp);
					}
					*/
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(Controle.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
				}
			
			}
		});
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("Adicionar Maquina");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaquinaDialog dialog = new MaquinaDialog(Controle.this, maquinaDAO);
				
				dialog.setVisible(true);
			}
			
		});
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Atualizar Maquina");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				
				if(row < 0 ) {
					JOptionPane.showMessageDialog(Controle.this, "Você deve escolher uma maquina");
					return;
				}
				
				//Maquina tempMaquina = (Maquina) table.getValueAt(row,  );
				
				
			}
		});
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Remover ");
		panel_1.add(btnNewButton_3);
	}

	public  void refreshControleView() throws Exception {
		// TODO Auto-generated method stub
		List<Maquina> maquinas = maquinaDAO.getAllMaquinas();
		
		MaquinaTableModel model = new MaquinaTableModel(maquinas);
		
		table.setModel(model);
	}

	

}
