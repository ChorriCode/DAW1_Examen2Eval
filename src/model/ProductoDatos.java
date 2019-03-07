package model;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class ProductoDatos {
	
	private String ruta;
	
	
	public BufferedReader accesoCargarFicheroTXT() throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(this.ruta));
		System.out.println("Accediendo al fichero " + ruta);
		return br;
	}
	
	public void closeBufferedReader(BufferedReader br) {
		try {
			br.close();
			System.out.println("Fichero cerrado correctamente... ");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	// RESPUESTA A LA PREGUNTA (B) - metódos para leer los tres ficheros de texto
	
	
	
	public ArrayList<Producto> leerProductosTXT(String ruta) {
		ArrayList<Producto> resultado = new ArrayList<Producto>();
		this.ruta = ruta;
		BufferedReader br = null;
		try {
			br = accesoCargarFicheroTXT();
			String linea = null;
			while ((linea = br.readLine()) != null) {
				String[] datosProductos = linea.split("#");
				Integer id = Integer.parseInt(datosProductos[0]);
				String nombre = datosProductos[1];
				Integer stock = Integer.parseInt(datosProductos[2]);
				Double precio = Double.parseDouble(datosProductos[3]);
				Integer idCategoria = Integer.parseInt(datosProductos[4]);
				String idAlmacen = datosProductos[5];
				Producto unProducto = new Producto(id, nombre, stock, precio, idCategoria, idAlmacen);
				resultado.add(unProducto);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException: ");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException: ");
			e.printStackTrace();
		} finally {	
			closeBufferedReader(br);
		}		
		return resultado;		
	}
	
	public ArrayList<String> leerCategoriasTXT(String ruta) {
		ArrayList<String> resultado = new ArrayList<String>();
		this.ruta = ruta;
		BufferedReader br = null;
		try {
			br = accesoCargarFicheroTXT();
			String linea = null;
			while ((linea = br.readLine()) != null) {
				String[] datosCategorias = linea.split("#");
				String nombre = datosCategorias[1];
				resultado.add(nombre);
			}			
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException: ");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException: ");
			e.printStackTrace();
		} finally {	
			closeBufferedReader(br);
		}		
		return resultado;		
	}
	
	public HashMap<String,String> leerAlmacenesTXT(String ruta) {
		HashMap<String,String> resultado = new HashMap<String,String>();
		this.ruta = ruta;
		BufferedReader br = null;
		try {
			br = accesoCargarFicheroTXT();
			String linea = null;
			while ((linea = br.readLine()) != null) {
				String[] datosAlmacenes = linea.split("#");
				String id = datosAlmacenes[0];
				String nombre = datosAlmacenes[1];			
				resultado.put(id, nombre);
			}			
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException: ");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException: ");
			e.printStackTrace();
		} finally {	
			closeBufferedReader(br);
		}		
		return resultado;
		
	}
	
	
	// RESPUESTA A LA PREGUNTA (C) -  método para grabar en un fichero de tipo object todos los productos individualmente
	
	public void guardarProductosFicheroObjetos(ArrayList<Producto> listadoProductos, String ruta) {
		try {
			FileOutputStream fos = new FileOutputStream(ruta);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (int i = 0; i < listadoProductos.size(); i++) {
				Producto unProducto = listadoProductos.get(i);
				oos.writeObject(unProducto);		
			}	
			oos.close();
			fos.close();
			System.out.println("Productos guardados en fichero " + ruta);
			
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException: ");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException: ");
			e.printStackTrace();
		}				
	}
	
	
	// RESPUESTA A LA PREGUNTA (D) - método para leer el archivo objecto de productos.obj y lo almacene en un HashMap<Integer,Producto>
	
	
	public HashMap<Integer,Producto> leerProductosOBJ(String ruta) {
		HashMap<Integer,Producto> resultado = new HashMap<Integer,Producto> ();
		this.ruta = ruta;
		ObjectInputStream ois = null;
		try {			
			ois = new ObjectInputStream(new FileInputStream(ruta));
			Producto unProducto = null;
			while ((unProducto = (Producto)ois.readObject()) != null) {
				Integer id = unProducto.getId();
				resultado.put(id, unProducto);
			}
			System.out.println("Productos leidos correctamente...");
			
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException: ");
			e.printStackTrace();
		} catch (EOFException e) {
			System.out.println("EOFException: El fichero " + ruta + " no tiene más datos a leer");
		} catch (IOException e) {
			System.out.println("IOException: ");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {

			}

		}
		return resultado;		
	}
	

}
