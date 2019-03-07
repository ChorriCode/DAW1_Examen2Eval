package controller;

import java.util.ArrayList;
import java.util.HashMap;

import model.Producto;

public class ProductoController {
	
	private ArrayList<Producto> listadoProductos;
	private ArrayList<String> listadoCategorias;
	private HashMap<String,String> listadoAlmacenes;
	
	public ProductoController() {
		
	}

	public ProductoController(ArrayList<Producto> listadoProductos, ArrayList<String> listadoCategorias, HashMap<String, String> listadoAlmacenes) {
		this.listadoProductos = listadoProductos;
		this.listadoCategorias = listadoCategorias;
		this.listadoAlmacenes = listadoAlmacenes;
	}


	public int calcularStockTotal() {
		int stockTotal = 0;		
		for (int i = 0; i < listadoProductos.size(); i++) {
			Producto unProducto = listadoProductos.get(i);
			stockTotal += unProducto.getStock();
		}		
		return stockTotal;
	}
	
	
	// RESPUESTA A LA PREGUNTA (E.7) - este método es necesario para usarlo en la vista
	
	
	public HashMap<String,Integer> calcularStockPorAlmacenes() { // Clave = nombre del Almacén --- Valor = stock de dicho Almacén
		HashMap<String,Integer> stockPorAlmacenes = new HashMap<String,Integer>();
		for (String claveAlmacen : this.listadoAlmacenes.keySet()) {
			String almacen = listadoAlmacenes.get(claveAlmacen);
			stockPorAlmacenes.put(almacen, 0);
		}
			for (Integer i = 0; i < this.listadoProductos.size(); i++) {
				Producto unProducto = this.listadoProductos.get(i);
				String idAlmacenDeUnProducto = unProducto.getIdAlmacen();
				String nombreAlmacenUnProducto = listadoAlmacenes.get(idAlmacenDeUnProducto);
				Integer stockUnProducto = unProducto.getStock();
				Integer stockActualDelAlmacen = stockPorAlmacenes.get(nombreAlmacenUnProducto);
				Integer stockActualizado = stockActualDelAlmacen + stockUnProducto;
				stockPorAlmacenes.put(nombreAlmacenUnProducto, stockActualizado);			
			}		
		return stockPorAlmacenes;
	}
	
	
	// RESPUESTA A LA PREGUNTA (E.8) - este método es necesario para usarlo en la vista
	
	
	public HashMap<String,Integer> calcularStockPorCategorias() { // Clave = nombre del Almacén --- Valor = stock de dicho Almacén
		HashMap<String,Integer> stockPorCategorias = new HashMap<String,Integer>();
		for (int i = 0; i < this.listadoCategorias.size(); i++) {
			String categoria = listadoCategorias.get(i);	
			stockPorCategorias.put(categoria, 0);
		}
			for (Integer j = 0; j < this.listadoProductos.size(); j++) {
				Producto unProducto = this.listadoProductos.get(j);
				Integer stockUnProducto = unProducto.getStock();
				Integer idCategoriaUnProducto = unProducto.getIdCategoria();
				String nombreCategoriaUnProducto = listadoCategorias.get(idCategoriaUnProducto-1);
				Integer stockActualDeLaCategoria = stockPorCategorias.get(nombreCategoriaUnProducto);
				Integer stockActualizado = stockActualDeLaCategoria + stockUnProducto;
				stockPorCategorias.put(nombreCategoriaUnProducto, stockActualizado);			
			}
			System.out.println();
		return stockPorCategorias;
	}
	
}
