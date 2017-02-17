package stock.app

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration
import org.quartz.Scheduler

class Application extends GrailsAutoConfiguration {

    static void main(String[] args) {
        GrailsApp.run(Application, args)
    }

    void onStartup(Map<String, Object> event) {
        Scheduler scheduler = applicationContext.getBean('quartzScheduler')
        if(grailsApplication.config.grails.plugin.quartz.autoStartup){
            def builders = grailsApplication.config.grails.plugin.quartz.jobSetup
            if(builders?.keySet()){
                builders.each{key,clos->
                    clos(scheduler, applicationContext)
                }
            }
        }
    }
}