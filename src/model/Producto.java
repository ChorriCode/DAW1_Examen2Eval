package model;

import java.io.Serializable;

// RESPUESTA A LA PREGUNTA (A) - Crear la clase producto sólamente

public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nombre;
	private Integer stock;
	private Double precio;
	private Integer idCategoria;
	private String idAlmacen;
	
	public Producto() {
		super();
	}
	
	public Producto(Integer id, String nombre, Integer stock, Double precio, Integer idCategoria, String idAlmacen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.stock = stock;
		this.precio = precio;
		this.idCategoria = idCategoria;
		this.idAlmacen = idAlmacen;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getIdAlmacen() {
		return idAlmacen;
	}

	public void setIdAlmacen(String idAlmacen) {
		this.idAlmacen = idAlmacen;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", stock=" + stock + ", precio=" + precio
				+ ", idCategoria=" + idCategoria + ", idAlmacen=" + idAlmacen + "]\n";
	}




	
}
