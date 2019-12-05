//import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

public class Maquina {
	private int id;
	private String manutencao;
	private String modelo;
	private String tipo;
	private String estado;
	private String relatorioTecnico;
	private String relatorioSistema;   
	private String mgpm;
	
	   
	
	
	public Maquina(int id, String manutencao, String modelo, String tipo, String estado, String relatorioTecnico,
			String relatorioSistema, String mGPM) {
		super();
		this.id = id;
		this.manutencao = manutencao;
		this.modelo = modelo;
		this.tipo = tipo;
		this.estado = estado;
		this.relatorioTecnico = relatorioTecnico;
		this.relatorioSistema = relatorioSistema;
		this.mgpm = mGPM;
	}
	public Maquina(String manutencao, String modelo, String tipo, String estado, String relatorioTecnico,
			String relatorioSistema, String mGPM) {
		super();
		this.id = 0;
		this.manutencao = manutencao;
		this.modelo = modelo;
		this.tipo = tipo;
		this.estado = estado;
		this.relatorioTecnico = relatorioTecnico;
		this.relatorioSistema = relatorioSistema;
		this.mgpm = mGPM;
	}
	public String getManutencao() {
		return manutencao;
	}
	public void setManutencao(String manutencao) {
		this.manutencao = manutencao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		estado = estado;
	}
	public String getRelatorioTecnico() {
		return relatorioTecnico;
	}
	public void setRelatorioTecnico(String relatorioTecnico) {
		this.relatorioTecnico = relatorioTecnico;
	}
	public String getRelatorioSistema() {
		return relatorioSistema;
	}
	public void setRelatorioSistema(String relatorioSistema) {
		this.relatorioSistema = relatorioSistema;
	}
	public String getMGPM() {
		return mgpm;
	}
	public void setMGPM(String mGPM) {
		mgpm = mGPM;
	}
	@Override
	public java.lang.String toString() {
		return "Maquina [id=" + id + ", manutencao=" + manutencao + ", modelo=" + modelo + ", tipo=" + tipo
				+ ", estado=" + estado + ", relatorioTecnico=" + relatorioTecnico + ", relatorioSistema="
				+ relatorioSistema + ", mgpm=" + mgpm + "]";
	}
	
}
