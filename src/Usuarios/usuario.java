package Usuarios;

public abstract class usuario {

	private int idUsuario;
	private String username;
	private String password;
	
	public usuario(int idUsuario, String username, String password) {
		this.idUsuario = idUsuario;
		this.username = username;
		this.password = password;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
