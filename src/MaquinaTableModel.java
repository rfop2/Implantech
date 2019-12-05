import java.util.List;

import javax.swing.table.AbstractTableModel;



class MaquinaTableModel extends AbstractTableModel {

	private static final int MANUTENCAO_COL = 0;
	private static final int MODELO_COL = 1;
	private static final int TIPO_COL = 2;
	private static final int ESTADO_COL = 3;
	private static final int RELATORIO_DO_TECNICO_COL = 4;
	private static final int RELATORIO_DO_SISTEMA_COL = 5;
	private static final int MGPM_COL = 6;

	private String[] columnNames = { "Manutenção", "Modelo", "Tipo",
			"Estado", "Relatório do Tecnico" , "Relatório do Sistema" , "MGPM" };
	private List<Maquina> maquinas;

	MaquinaTableModel(List<Maquina> theMaquinas) {
		maquinas = theMaquinas;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return maquinas.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		Maquina tempMaquina = maquinas.get(row);

		switch (col) {
		case MANUTENCAO_COL:
			return tempMaquina.getManutencao();
		case MODELO_COL:
			return tempMaquina.getModelo();
		case TIPO_COL:
			return tempMaquina.getTipo();
		case ESTADO_COL:
			return tempMaquina.getEstado();
		case RELATORIO_DO_TECNICO_COL:
			return tempMaquina.getRelatorioTecnico();
		case RELATORIO_DO_SISTEMA_COL:
			return tempMaquina.getRelatorioSistema();
		case MGPM_COL:
			return tempMaquina.getMGPM();
		default:
			return tempMaquina.getTipo();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}
