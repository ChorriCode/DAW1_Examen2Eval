package view;

import java.util.ArrayList;
import java.util.HashMap;

import model.Producto;

// RESPUESTA A LA PREGUNTA (E)

public class ProductoView {

	private ArrayList<Producto> listadoProductos;
	private ArrayList<String> listadoCategorias;
	private HashMap<String,String> listadoAlmacenes;
	
	public ProductoView() {
		super();
	}

	
	

	public ProductoView(ArrayList<Producto> listadoProductos, ArrayList<String> listadoCategorias,
			HashMap<String, String> listadoAlmacenes) {
		super();
		this.listadoProductos = listadoProductos;
		this.listadoCategorias = listadoCategorias;
		this.listadoAlmacenes = listadoAlmacenes;
	}

	public String hyphenatedFill(int spaces, String filler) {
		String fill = "";
		
		for (int i = 0; i < spaces; i++) {
			fill += filler;
		}

		return fill;
	}


	// RESPUESTA A LA PREGUNTA (E.1) - mostrar listado de productos sin filtros (ID    NOMBRE PRODUCTO   PRECIO   STOCK   CATEGORIA  ALMACEN)
	
	public void mostrarListadoProductos() {		
		System.out.println("\nRESPUESTA A LA PREGUNTA (E.1)\n");
		System.out.println("ID   NOMBRE PRODUCTO     PRECIO   STOCK  CATEGORÍA      ALMACÉN");		
		System.out.println("==   ===============     ======   =====  =========      =======");		
		for (int i = 0; i < this.listadoProductos.size(); i++) {
			 Producto unProducto = this.listadoProductos.get(i);
			Integer id = unProducto.getId();
			String nombre = unProducto.getNombre();
			Double precio = unProducto.getPrecio();
			Integer stock = unProducto.getStock();
			Integer idCategoria = unProducto.getIdCategoria();
			String categoria = this.listadoCategorias.get(idCategoria - 1);
			String idAlmacen = unProducto.getIdAlmacen();
			String almacen = this.listadoAlmacenes.get(idAlmacen);	
			System.out.println(id + hyphenatedFill(5-(id.toString().length())," ") +  nombre  + hyphenatedFill(20-(nombre.length())," ") + precio + "€" + hyphenatedFill(8-(precio.toString().length())," ") + stock + hyphenatedFill(7-(stock.toString().length())," ") + categoria + hyphenatedFill(15-(categoria.length())," ") + almacen);	
		}
		System.out.println();
	}
	
	
	// RESPUESTA A LA PREGUNTA (E.2) - mostrar listado de productos filtrado por una categoria, igual que el de antes pero sólo sale una categoría concreta
	
	
	public void mostrarListadoProductosPorCategoria(Integer idCateg) {
		System.out.println("\nRESPUESTA A LA PREGUNTA (E.2)\n");
		String categoria = this.listadoCategorias.get(idCateg - 1);
		System.out.println("CATEGORÍA: " + categoria);
		System.out.println("ID   NOMBRE PRODUCTO     PRECIO   STOCK  ALMACÉN");		
		System.out.println("==   ===============     ======   =====  =======");		
		for (int i = 0; i < this.listadoProductos.size(); i++) {
			Producto unProducto = this.listadoProductos.get(i);
			if (unProducto.getIdCategoria() == idCateg) {
				Integer id = unProducto.getId();
				String nombre = unProducto.getNombre();
				Double precio = unProducto.getPrecio();
				Integer stock = unProducto.getStock();
				Integer idCategoria = unProducto.getIdCategoria();
				String idAlmacen = unProducto.getIdAlmacen();
				String almacen = this.listadoAlmacenes.get(idAlmacen);
				System.out.println(id + hyphenatedFill(5-(id.toString().length())," ") +  nombre  + hyphenatedFill(20-(nombre.length())," ") + precio + "€" + hyphenatedFill(8-(precio.toString().length())," ") + stock + hyphenatedFill(7-(stock.toString().length())," ") + almacen);	
			}
		}	
		System.out.println();
	}
	
	
	// RESPUESTA A LA PREGUNTA (E.3) - mostrar listado de productos ordenados por categorías
	
	
	public void mostrarListadoProductosPorCategorias() {
		System.out.println("\nRESPUESTA A LA PREGUNTA (E.3)\n");
		for (int i = 0; i < this.listadoCategorias.size(); i++) {
			String categoria = this.listadoCategorias.get(i);
			System.out.println("\nCATEGORÍA: " + categoria);
			System.out.println("ID   NOMBRE PRODUCTO     PRECIO   STOCK  ALMACÉN");		
			System.out.println("==   ===============     ======   =====  =======");		
			for (Integer j = 0; j < this.listadoProductos.size(); j++) {
				Producto unProducto = this.listadoProductos.get(j);
				if (unProducto.getIdCategoria() == (i+1)) { // se le suma uno al índice porque el listado empieza por uno aunque la celda es la cero
					Integer id = unProducto.getId();
					String nombre = unProducto.getNombre();
					Double precio = unProducto.getPrecio();
					Integer stock = unProducto.getStock();
					Integer idCategoria = unProducto.getIdCategoria();
					String idAlmacen = unProducto.getIdAlmacen();
					String almacen = this.listadoAlmacenes.get(idAlmacen);
					System.out.println(id + hyphenatedFill(5-(id.toString().length())," ") +  nombre  + hyphenatedFill(20-(nombre.length())," ") + precio + "€" + hyphenatedFill(8-(precio.toString().length())," ") + stock + hyphenatedFill(7-(stock.toString().length())," ") + almacen);		
				}
			}
			System.out.println();
		}
	}
	
	
	// RESPUESTA A LA PREGUNTA (E.4) - mostrar listado de productos ordenados por almacenes
	
	
	public void mostrarListadoProductosPorAlmacenes() {
		System.out.println("\nRESPUESTA A LA PREGUNTA (E.4)\n");
		for (String claveAlmacen : this.listadoAlmacenes.keySet()) {
			String almacen = listadoAlmacenes.get(claveAlmacen);			
			System.out.println("\nALMACÉN: " + almacen);
			System.out.println("ID   NOMBRE PRODUCTO     PRECIO   STOCK  CATEGORÍA");		
			System.out.println("==   ===============     ======   =====  =========");		
			for (Integer j = 0; j < this.listadoProductos.size(); j++) {
				Producto unProducto = this.listadoProductos.get(j);
				if (unProducto.getIdAlmacen().equals(claveAlmacen)) { 
					Integer id = unProducto.getId();
					String nombre = unProducto.getNombre();
					Double precio = unProducto.getPrecio();
					Integer stock = unProducto.getStock();
					Integer idCategoria = unProducto.getIdCategoria();
					String categoria = this.listadoCategorias.get(idCategoria - 1);
					System.out.println(id + hyphenatedFill(5-(id.toString().length())," ") +  nombre  + hyphenatedFill(20-(nombre.length())," ") + precio + "€" + hyphenatedFill(8-(precio.toString().length())," ") + stock + hyphenatedFill(7-(stock.toString().length())," ") + categoria);	
				}
			}		
		}
		System.out.println();
	}
	
	
	// RESPUESTA A LA PREGUNTA (E.5) - mostrar los productos que tiene un almacén concreto
	
	
	public void mostrarListadoProductosPorAlmacen(String idAlmac) {
		System.out.println("\nRESPUESTA A LA PREGUNTA (E.5)\n");
		String almacen = this.listadoAlmacenes.get(idAlmac);
		System.out.println("\nCATEGORÍA: " + almacen);
		System.out.println("ID   NOMBRE PRODUCTO     PRECIO   STOCK  CATEGORÍA");		
		System.out.println("==   ===============     ======   =====  =========");		
		for (int i = 0; i < this.listadoProductos.size(); i++) {
			Producto unProducto = this.listadoProductos.get(i);
			if (unProducto.getIdAlmacen().equals(idAlmac)) {
				Integer id = unProducto.getId();
				String nombre = unProducto.getNombre();
				Double precio = unProducto.getPrecio();
				Integer stock = unProducto.getStock();
				Integer idCategoria = unProducto.getIdCategoria();
				String categoria = this.listadoCategorias.get(idCategoria - 1);
				System.out.println(id + hyphenatedFill(5-(id.toString().length())," ") +  nombre  + hyphenatedFill(20-(nombre.length())," ") + precio + "€" + hyphenatedFill(8-(precio.toString().length())," ") + stock + hyphenatedFill(7-(stock.toString().length())," ") + categoria);	
			}
		}
		System.out.println();
	}
	
	
	// RESPUESTA A LA PREGUNTA (E.6) - mostrar el stock total de la empresa
	
	public void mostrarStockTotal(int stockTotal) {
		System.out.println("\nRESPUESTA A LA PREGUNTA (E.6)\n");
		System.out.println("------------------------------------------------------");		
		System.out.println("STOCK TOTAL DE PRODUCTOS: " + stockTotal + " unidades.");
		System.out.println("------------------------------------------------------\n");
	}
	
	
	// RESPUESTA A LA PREGUNTA (E.7) - mostrar el stock de productos que tiene cada almacen
	
	
	public void mostrarStockPorAlmacenes(HashMap<String,Integer> stockPorAlmacenes) {
		System.out.println("\nRESPUESTA A LA PREGUNTA (E.7)\n");
		System.out.println("------------------------------------------------------");		
		System.out.println("STOCK POR ALMACENES");
		System.out.println("------------------------------------------------------\n");
		for (String almacen : stockPorAlmacenes.keySet()) {
			System.out.println("STOCK " + almacen + hyphenatedFill(20-(almacen.toString().length())," ") + ": " + stockPorAlmacenes.get(almacen) + hyphenatedFill(4-(stockPorAlmacenes.get(almacen).toString().length())," ") + " unidades.");
		} 
		System.out.println();
	}
	
	
	// RESPUESTA A LA PREGUNTA (E.8) - mostrar el stock de productos que tiene cada categoría
	
	
	public void mostrarStockPorCategorias(HashMap<String,Integer> stockPorCategorias) {
		System.out.println("\nRESPUESTA A LA PREGUNTA (E.8)\n");
		System.out.println("------------------------------------------------------");		
		System.out.println("STOCK POR ALMACENES");
		System.out.println("------------------------------------------------------\n");
		for (String categoria : stockPorCategorias.keySet()) {
			System.out.println("STOCK CATEGORÍA " + categoria + hyphenatedFill(13-(categoria.toString().length())," ") + ": " + stockPorCategorias.get(categoria) + hyphenatedFill(4-(stockPorCategorias.get(categoria).toString().length())," ") + " unidades.");
		} 
		System.out.println();
	}
}
