package es.iesjandula.damfilms.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatesUtil
{
	/**
	 * https://www.javatpoint.com/java-simpledateformat
	 * 
	 * @param fechaString fecha como cadena de texto
	 * @return un Date
	 * @throws ProyectoFinalException con una excepcion
	 */
	public static Date crearFechaDesdeString(String fechaString) throws DamfilmsServerError
	{
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy") ;  
	    
	    try
	    {
			return formatter.parse(fechaString) ;
		}
	    catch (ParseException parseException)
	    {
			throw new DamfilmsServerError(404,"Fecha con formato incorrecto: " + fechaString, parseException) ;
		}  
	}
}