package prueba.ulsa

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class EnviarController {

    EnviarService enviarService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    static responseFormats =['json']
    def index(Integer max) {
       
        params.max = Math.min(max ?: 10, 100)
       
        respond enviarService.list(), model:[enviarCount: enviarService.count()]

    }

    def show(Long id) {
        respond enviarService.get(id)
    }

    def create() {
        respond new Enviar(requestData)
    }
    def send() {
    sendMail {
        to "manuelvictor95@gmail.com"
        subject "lo2 lograset"
        text "hola"
    }

    flash.message = "Message sent at "+new Date()
    redirect action:"index"
}

    def save(Enviar enviar) {
        if (enviar == null) {
            notFound()
            return
        }

        try {
            enviarService.save(enviar)
        } catch (ValidationException e) {
            respond enviar.errors
            return
        }
        sendMail {
        to enviar.correo
        subject "tu usuario es" 
        text "tu usuario es: " + enviar.matricula + "tu pasword es: 1234"
    }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'enviar.label', default: 'Enviar'), enviar.id])
                redirect enviar
            }
            '*' { respond enviar, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond enviarService.get(id)
    }

    def update(Enviar enviar) {
        if (enviar == null) {
            notFound()
            return
        }

        try {
            enviarService.save(enviar)
        } catch (ValidationException e) {
            respond enviar.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'enviar.label', default: 'Enviar'), enviar.id])
                redirect enviar
            }
            '*'{ respond enviar, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        enviarService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'enviar.label', default: 'Enviar'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'enviar.label', default: 'Enviar'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
