package Usuarios;

public class funcionario extends usuario implements venda{

	private String cargo;
	private String horario;
	private int totalVendas;
	private double totalValorVenda;
	
	public funcionario(int idUsuario, String username, String password, String cargo, String horario, int totalVendas, double totalValorVendas) {
		super(idUsuario, username, password);
		this.cargo = cargo;
		this.horario = horario;
		this.totalVendas = totalVendas;
		this.totalValorVenda = totalValorVendas;
	}
	
	public void realizarVenda(int novaVenda) {
		
		totalVendas += novaVenda;
		
	}
	
	public void adicionarTotalValorVenda(double valorNovaVenda) {
		totalValorVenda += valorNovaVenda;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public int getTotalVendas() {
		return totalVendas;
	}

	public void setTotalVendas(int totalVendas) {
		this.totalVendas = totalVendas;
	}

	public double getTotalValorVenda() {
		return totalValorVenda;
	}

	public void setTotalValorVenda(double totalValorVenda) {
		this.totalValorVenda = totalValorVenda;
	}
	
	
	
}
