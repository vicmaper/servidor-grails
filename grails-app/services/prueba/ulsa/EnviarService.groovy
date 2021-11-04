package prueba.ulsa

import grails.gorm.services.Service

@Service(Enviar)
interface EnviarService {

    Enviar get(Serializable id)

    List<Enviar> list(Map args)

    Long count()

    void delete(Serializable id)

    Enviar save(Enviar enviar)

}