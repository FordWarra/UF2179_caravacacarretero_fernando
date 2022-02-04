import java.util.Objects;

/**
 * 
 */

/**
 * @author Fernando
 *
 */
public class Autocar {

	private String Matricula;
	private String Marca;
	private String Modelo;
	private int Kilometros;
	private int Num_plazas;
	
	
	
	//Constructor con parámetros
	public Autocar(String matricula, String marca, String modelo, int kilometros, int num_plazas) {
		super();
		Matricula = matricula;
		Marca = marca;
		Modelo = modelo;
		Kilometros = kilometros;
		Num_plazas = num_plazas;
	}
	
	//Constructor sin parámetros
	public Autocar() {
		Matricula = "";
		Marca = "";
		Modelo = "";
	}
	
	
	
	/**
	 * @return el matricula
	 */
	public String getMatricula() {
		return Matricula;
	}
	/**
	 * @param matricula el matricula a establecer
	 */
	public void setMatricula(String matricula) {
		Matricula = matricula;
	}
	/**
	 * @return el marca
	 */
	public String getMarca() {
		return Marca;
	}
	/**
	 * @param marca el marca a establecer
	 */
	public void setMarca(String marca) {
		Marca = marca;
	}
	/**
	 * @return el modelo
	 */
	public String getModelo() {
		return Modelo;
	}
	/**
	 * @param modelo el modelo a establecer
	 */
	public void setModelo(String modelo) {
		Modelo = modelo;
	}
	/**
	 * @return el kilometros
	 */
	public int getKilometros() {
		return Kilometros;
	}
	/**
	 * @param kilometros el kilometros a establecer
	 */
	public void setKilometros(int kilometros) {
		Kilometros = kilometros;
	}
	/**
	 * @return el num_plazas
	 */
	public int getNum_plazas() {
		return Num_plazas;
	}
	/**
	 * @param num_plazas el num_plazas a establecer
	 */
	public void setNum_plazas(int num_plazas) {
		Num_plazas = num_plazas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autocar other = (Autocar) obj;
		return Objects.equals(Matricula, other.Matricula);
	}

	@Override
	public String toString() {
		return "Autocar [Matricula=" + Matricula + ", Marca=" + Marca + ", Modelo=" + Modelo + ", Kilometros="
				+ Kilometros + ", Num_plazas=" + Num_plazas + "]";
	}
	
	
	
	
}
