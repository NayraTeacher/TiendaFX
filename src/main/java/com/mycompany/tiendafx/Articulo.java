/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tiendafx;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
/**
 * Clase general definicion de articulos para vender en la tienda
 * @author Nayra
 */
public class Articulo {
	
	private final StringProperty codigo;
	private final StringProperty nombre;
	private final FloatProperty precio;
	private final IntegerProperty stock;
        
	/**
         * Constructor vacio
         */
	public Articulo() {
            this.codigo = null;
            this.nombre = null;
            this.precio = null;
            this.stock = null;
        }
	
        /**
         * Constructor con todos los parametros
         * @param codigo de tipo String, nos sirve para identificar el articulo de forma univoca
         * @param nombre de tipo String, nos sirve para darle un nombre descriptivo al articulo
         * @param precio de tipo float, indica el precio unitario del artículo
         * @param stock de tipo entero, indica las unidades de las que se dispone el almacén de este artículo
         */
	public Articulo(String codigo, String nombre, float precio, int stock) {
            this.codigo = new SimpleStringProperty(codigo);
            this.nombre = new SimpleStringProperty(nombre);
            this.precio = new SimpleFloatProperty(precio);
            this.stock = new SimpleIntegerProperty(stock);
            
	}
        
        public Articulo(String[] valores) {
            this.codigo = new SimpleStringProperty(valores[0]);
            this.nombre = new SimpleStringProperty(valores[1]);
            this.precio = new SimpleFloatProperty(Float.parseFloat(valores[2]));
            this.stock = new SimpleIntegerProperty(Integer.parseInt(valores[3]));
            
	}
	
	public String getCodigo() {
		return codigo.get();
	}
	
	public String getNombre() {
		return nombre.get();
	}
	
	public float getPrecio() {
		return precio.get();
	}
	
	public int getStock() {
		return stock.get();
	}
	
	public void setCodigo(String codigo) {
		this.codigo.set(codigo);
	}
	
	public void setNombre(String nombre) {
		this.nombre.set(nombre);
	}
	
	public void setPrecio(float precio) {
		this.precio.set(precio);
	}
	
	public void setStock(int stock) {
		this.stock.set(stock);
	}
	
        public StringProperty codigoProperty() {
		return codigo;
	}
        public StringProperty nombreProperty() {
		return nombre;
	}
        public FloatProperty precioProperty() {
		return precio;
	}
        public IntegerProperty stockProperty() {
		return stock;
	}
        
        
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Codigo: ").append(this.codigo).append("\nNombre: ").append(this.nombre).append("\nPrecio: ").append(this.precio).append("€\nStock: ").append(this.stock).append("\n");
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		
		if (this.getClass() != o.getClass())
			return false;
		else
		{
			Articulo a = (Articulo) o;
			if (this.codigo.equals(a.getCodigo()))
					return true;
			else
				return false;
		}
	}
	
        /**
         * Metodo para saber si hay disponibilidad para comprar una cantidad del artículo.
         * @param cantidad Entero que indica la cantidad que se desea comprar
         * @return cierto si hay disponibilidad y falso si no. Este método no varía los valores de los atributos del articulo.
         */
	public boolean disponible(int cantidad) {
		return cantidad<=stock.get();
	}
	
        /**
         * Método que nos ajusta el stock del artículo sumandole la cantidad proporcionada como parámetro. Si el artículo es vendido,
         * hay que pasar la cantidad vendida con un signo negativo para que se reste del stock. Si por contra, se ha adquirido más stock 
         * del artículo al proveedor, habrá que ajustarlo pasando la cantidad adquirida en positivo.
         * @param cantidad Entero con la cantidad a ajustar.  
         */
	public void ajustarStock(int cantidad) {
		this.stock.set(this.stock.get() + cantidad);
	}
	
}

