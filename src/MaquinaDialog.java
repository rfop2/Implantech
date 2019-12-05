import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MaquinaDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField manuttextField;
	private JTextField modelotextField_1;
	private JTextField tipotextField_2;
	private JTextField estadotextField_3;
	private JTextField tecnicotextField_4;
	private JTextField sistematextField_5;
	private JTextField mgpmtextField_6;
	
	private MaquinaDAO maquinaDAO;
	private Controle controle;
	
	private Maquina antMaquina = null;
	private boolean updateMode = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MaquinaDialog dialog = new MaquinaDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	MaquinaDialog(Controle theControle, MaquinaDAO theMaquinaDAO, Maquina theAntMaquina, boolean theUpdateMode){
		this.maquinaDAO = theMaquinaDAO;
		controle = theControle;
		antMaquina = theAntMaquina;
		updateMode = theUpdateMode;
		
		if(updateMode) {
			setTitle("Update Maquina");
			
			populateGui(antMaquina);
		}
	}
	MaquinaDialog(Controle controle2, MaquinaDAO maquinaDAO2){
		this.maquinaDAO = maquinaDAO2;
		this.controle = controle2;
	}

	/**
	 * Create the dialog.
	 */
	public MaquinaDialog() {
		setTitle("Adicionar Maquina");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manutencao");
		lblNewLabel.setBounds(24, 6, 101, 16);
		contentPanel.add(lblNewLabel);
		
		manuttextField = new JTextField();
		manuttextField.setBounds(206, 1, 130, 26);
		contentPanel.add(manuttextField);
		manuttextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Modelo");
		lblNewLabel_1.setBounds(24, 34, 61, 16);
		contentPanel.add(lblNewLabel_1);
		
		modelotextField_1 = new JTextField();
		modelotextField_1.setBounds(206, 29, 130, 26);
		contentPanel.add(modelotextField_1);
		modelotextField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tipo");
		lblNewLabel_2.setBounds(24, 62, 61, 16);
		contentPanel.add(lblNewLabel_2);
		
		tipotextField_2 = new JTextField();
		tipotextField_2.setBounds(206, 57, 130, 26);
		contentPanel.add(tipotextField_2);
		tipotextField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Estado");
		lblNewLabel_3.setBounds(24, 90, 61, 16);
		contentPanel.add(lblNewLabel_3);
		
		estadotextField_3 = new JTextField();
		estadotextField_3.setBounds(206, 85, 130, 26);
		contentPanel.add(estadotextField_3);
		estadotextField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Relatorio Tecnico");
		lblNewLabel_4.setBounds(24, 118, 122, 16);
		contentPanel.add(lblNewLabel_4);
		
		tecnicotextField_4 = new JTextField();
		tecnicotextField_4.setBounds(206, 113, 130, 26);
		contentPanel.add(tecnicotextField_4);
		tecnicotextField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Relatorio Sistema");
		lblNewLabel_5.setBounds(24, 146, 122, 16);
		contentPanel.add(lblNewLabel_5);
		
		sistematextField_5 = new JTextField();
		sistematextField_5.setBounds(206, 141, 130, 26);
		contentPanel.add(sistematextField_5);
		sistematextField_5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("MGPM");
		lblNewLabel_6.setBounds(24, 174, 61, 16);
		contentPanel.add(lblNewLabel_6);
		
		mgpmtextField_6 = new JTextField();
		mgpmtextField_6.setBounds(206, 171, 130, 26);
		contentPanel.add(mgpmtextField_6);
		mgpmtextField_6.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Salvar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							saveMaquina();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void populateGui(Maquina theMaquina) {

			
		
		manuttextField.setText(theMaquina.getManutencao());
		modelotextField_1.setText(theMaquina.getModelo());
		tipotextField_2.setText(theMaquina.getTipo());
		estadotextField_3.setText(theMaquina.getEstado());
		tecnicotextField_4.setText(theMaquina.getRelatorioTecnico());
		sistematextField_5.setText(theMaquina.getRelatorioSistema());
		mgpmtextField_6.setText(theMaquina.getMGPM());
		
	}

	
	
	protected void saveMaquina() throws Exception {
		// TODO Auto-generated method stub
		String manutencao = manuttextField.getText();
		String modelo = modelotextField_1.getText();
		String tipo = tipotextField_2.getText();
		String estado = estadotextField_3.getText();
		String tecnico = tecnicotextField_4.getText();
		String sistema = sistematextField_5.getText();
		String mgpm = mgpmtextField_6.getText();
		
		Maquina tempMaquina = null;
		
		if(updateMode) {
			tempMaquina = antMaquina;
			
			tempMaquina.setManutencao(manutencao);
			tempMaquina.setModelo(modelo);
			tempMaquina.setTipo(tipo);
			tempMaquina.setEstado(estado);
			tempMaquina.setRelatorioTecnico(tecnico);
			tempMaquina.setRelatorioSistema(sistema);
			tempMaquina.setMGPM(mgpm);
		} else {
			 tempMaquina = new Maquina(manutencao,modelo,tipo,estado,tecnico,sistema,mgpm);
			
		}
		
		if(updateMode) {
			maquinaDAO.updateMaquina(tempMaquina);
		} else {
			maquinaDAO.addMaquina(tempMaquina);
		}
		
		setVisible(false);
		dispose();
		
		controle.refreshControleView();
		
		JOptionPane.showMessageDialog(controle,
				"Maquina adicionada com sucesso.",
				"Maquina adicionada",
				JOptionPane.INFORMATION_MESSAGE);
		
		
		
	}
}
