package prueba.ulsa
import grails.rest.*
@Resource(uri='/enviar', formats=['json'])
class Enviar {
	String correo
	String matricula
	String semestre
	String nivel
    String area
	static constraints = {
		correo blank:false
    	matricula blank:false , unique:true
    	semestre blank:false
    	nivel blank:false
    	area nullable:true, blank:true
    }
    String toString(){
    	matricula
    }
}
