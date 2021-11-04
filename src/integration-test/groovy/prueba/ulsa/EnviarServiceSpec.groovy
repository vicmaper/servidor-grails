package prueba.ulsa

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EnviarServiceSpec extends Specification {

    EnviarService enviarService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Enviar(...).save(flush: true, failOnError: true)
        //new Enviar(...).save(flush: true, failOnError: true)
        //Enviar enviar = new Enviar(...).save(flush: true, failOnError: true)
        //new Enviar(...).save(flush: true, failOnError: true)
        //new Enviar(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //enviar.id
    }

    void "test get"() {
        setupData()

        expect:
        enviarService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Enviar> enviarList = enviarService.list(max: 2, offset: 2)

        then:
        enviarList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        enviarService.count() == 5
    }

    void "test delete"() {
        Long enviarId = setupData()

        expect:
        enviarService.count() == 5

        when:
        enviarService.delete(enviarId)
        sessionFactory.currentSession.flush()

        then:
        enviarService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Enviar enviar = new Enviar()
        enviarService.save(enviar)

        then:
        enviar.id != null
    }
}
