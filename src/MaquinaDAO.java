import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.sql.*;

public class MaquinaDAO {
	private Connection myConn;
	
	MaquinaDAO() throws FileNotFoundException, IOException, SQLException {
		
		Properties props = new Properties();
		props.load(new FileInputStream("/Users/rodrigo/Desktop/Java/Tech/sql/bionic.properties"));
		
		String theUser = props.getProperty("user");
		String thePassword = props.getProperty("password");
		String theDburl = props.getProperty("dburl");
		
		System.out.println("url" + theDburl);
		
		myConn = DriverManager.getConnection(theDburl, theUser, thePassword);
	}
	
	public List<Maquina> getAllMaquinas() throws Exception {
		List<Maquina> list = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from maquinas");
			
			while (myRs.next()) {
				Maquina tempMaquina = convertRowToEmployee(myRs);
				list.add(tempMaquina);
			}

			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	public List<Maquina> searchMaquinas(String tipo) throws Exception {
		List<Maquina> list = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			tipo += "%";
			myStmt = myConn.prepareStatement("select * from maquinas where tipo like ?");
			
			myStmt.setString(1, tipo);
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				Maquina tempEmployee = convertRowToEmployee(myRs);
				list.add(tempEmployee);
			}
			
			return list;
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	public void addMaquina(Maquina theMaquina) throws Exception {
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("insert into maquinas"
					+ " (manutencao, modelo, tipo, estado, relatorio_do_tecnico, relatorio_do_sistema, mgpm)"
					+ " values (?, ?, ?, ?,?,?,?)");
			
			// set params
			myStmt.setString(1, theMaquina.getManutencao());
			myStmt.setString(2, theMaquina.getModelo());
			myStmt.setString(3, theMaquina.getTipo());
			myStmt.setString(4, theMaquina.getEstado());
			myStmt.setString(5, theMaquina.getRelatorioTecnico());
			myStmt.setString(6, theMaquina.getRelatorioSistema());
			myStmt.setString(7, theMaquina.getMGPM());
			
			// execute SQL
			myStmt.executeUpdate();			
		}
		finally {
			close(myStmt);
		}
		
	}
	
	private void close(Statement myStmt) throws SQLException {
		close(null, myStmt, null);		
	}
	
	private Maquina convertRowToEmployee(ResultSet myRs) throws SQLException {
		
		int id = myRs.getInt("id");
		String manutencao = myRs.getString("manutencao");
		String modelo = myRs.getString("modelo");
		String tipo = myRs.getString("tipo");
		String estado = myRs.getString("estado");
		String relatorioTecnico = myRs.getString("relatorio_do_tecnico");
		String relatorioSistema = myRs.getString("relatorio_do_sistema");
		String mgpm = myRs.getString("mgpm");
		
		Maquina tempMaquina = new Maquina(id, manutencao, modelo, tipo, estado, relatorioTecnico,relatorioSistema,mgpm);
		
		return tempMaquina;
	}
	
	private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
			throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			
		}
		
		if (myConn != null) {
			myConn.close();
		}
	}
	
	private void close(Statement myStmt, ResultSet myRs) throws SQLException {
		close(null, myStmt, myRs);		
	}
	
	public void updateMaquina(Maquina theMaquina) throws SQLException {
		PreparedStatement myStmt = null;
		
		myStmt = myConn.prepareStatement("update maquinas" + "set manutencao=? , modelo=?  , tipo=? , estado=? , relatorio_do_tecnico=? , relatorio_do_sistema=? "
				+ ", mgpm=?" + "where id=?");
		
		myStmt.setString(1, theMaquina.getManutencao());
		myStmt.setString(3, theMaquina.getModelo());
		myStmt.setString(2, theMaquina.getTipo());
		myStmt.setString(4, theMaquina.getEstado());
		myStmt.setString(5, theMaquina.getRelatorioTecnico());
		myStmt.setString(6, theMaquina.getRelatorioSistema());
		myStmt.setString(6, theMaquina.getMGPM());
		myStmt.setInt(7, theMaquina.getId());
		
		myStmt.executeUpdate();
		
		close(myStmt);
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		//System.out.println("pegou");
		MaquinaDAO dao = new MaquinaDAO();
		System.out.println(dao.searchMaquinas("C"));

		System.out.println(dao.getAllMaquinas());
		
		

	}

}
