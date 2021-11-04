package env

class UrlMappings {

    static mappings = {
        get "/$controller(.$format)?"(action:"index")
        get "/$controller/$id(.$format)?"(action:"show")
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/"(controller: 'enviar', action:'index')
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
