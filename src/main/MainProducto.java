package main;

import java.util.ArrayList;
import java.util.HashMap;

import controller.ProductoController;
import model.Producto;
import model.ProductoDatos;
import view.ProductoView;

public class MainProducto {

	public static void main(String[] args) {

		// RESPUESTA A LA PREGUNTA (B) - metódos para leer los tres ficheros de texto
		
		ProductoDatos miProdDatos = new ProductoDatos();
		HashMap<String, String> listadoAlmacenes = miProdDatos.leerAlmacenesTXT("ficheros/almacenes.txt");
		ArrayList<String> listadoCategorias = miProdDatos.leerCategoriasTXT("ficheros/categorias.txt");
		ArrayList<Producto> listadoProductos = miProdDatos.leerProductosTXT("ficheros/productos.txt");
		
		
		// RESPUESTA A LA PREGUNTA (C) - método para grabar en un fichero de tipo object todos los productos individualmente
		System.out.println("------------------------------------------------------------");
		System.out.println("\nRESPUESTA A LA PREGUNTA (C)\n");
		miProdDatos.guardarProductosFicheroObjetos(listadoProductos, "ficheros/productos.obj");
		
		
		// RESPUESTA A LA PREGUNTA (D) - método para leer el archivo objecto de productos.obj y lo almacene en un HashMap<Integer,Producto>
		System.out.println("------------------------------------------------------------");
		System.out.println("\nRESPUESTA A LA PREGUNTA (D)\n");
		HashMap<Integer, Producto> listadoProductos2 = miProdDatos.leerProductosOBJ("ficheros/productos.obj");
		System.out.println(listadoProductos2);
		
		
		ProductoController miProdController = new ProductoController(listadoProductos, listadoCategorias, listadoAlmacenes);
		
		ProductoView miProdView = new ProductoView(listadoProductos, listadoCategorias, listadoAlmacenes);
		
		System.out.println("------------------------------------------------------------");
		// RESPUESTA A LA PREGUNTA (E.1) - mostrar listado de productos sin filtros (ID    NOMBRE PRODUCTO   PRECIO   STOCK   CATEGORIA  ALMACEN)
		miProdView.mostrarListadoProductos();
				
		System.out.println("------------------------------------------------------------");
		// RESPUESTA A LA PREGUNTA (E.2) - mostrar listado de productos filtrado por una categoria, igual que el de antes pero sólo sale una categoría concreta
		miProdView.mostrarListadoProductosPorCategoria(1);
		
		System.out.println("------------------------------------------------------------");
		// RESPUESTA A LA PREGUNTA (E.3) - mostrar listado de productos ordenados por categorías
		miProdView.mostrarListadoProductosPorCategorias();
		
		System.out.println("------------------------------------------------------------");
		// RESPUESTA A LA PREGUNTA (E.4) - mostrar listado de productos ordenados por almacenes
		miProdView.mostrarListadoProductosPorAlmacenes();
		
		System.out.println("------------------------------------------------------------");
		// RESPUESTA A LA PREGUNTA (E.5) - mostrar los productos que tiene un almacén concreto
		miProdView.mostrarListadoProductosPorAlmacen("11");
		
		System.out.println("------------------------------------------------------------");
		// RESPUESTA A LA PREGUNTA (E.6) - mostrar el stock total de la empresa
		int stockTotal = miProdController.calcularStockTotal();
		miProdView.mostrarStockTotal(stockTotal);
		
		System.out.println("------------------------------------------------------------");
		// RESPUESTA A LA PREGUNTA (E.7) - mostrar el stock de productos que tiene cada almacen
		HashMap<String, Integer> stockProductosPorAlmacenes = miProdController.calcularStockPorAlmacenes();
		miProdView.mostrarStockPorAlmacenes(stockProductosPorAlmacenes);
		
		System.out.println("------------------------------------------------------------");
		// RESPUESTA A LA PREGUNTA (E.8) - mostrar el stock de productos que tiene cada categoría
		HashMap<String, Integer> stockPorCategorias = miProdController.calcularStockPorCategorias();
		miProdView.mostrarStockPorCategorias(stockPorCategorias);
		
		
		
		System.exit(0);
	}

}
