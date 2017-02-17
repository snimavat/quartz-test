import org.quartz.Scheduler
import org.quartz.impl.triggers.SimpleTriggerImpl
import stock.app.ClosureJob

environments {
	development {
		//println "Scheduling job "
		//ClosureJob.schedule(100, 10, [groovyClosure: {def ctx -> println "Closure called"}])
	}
}

grails.plugin.quartz.autoStartup = true
grails.plugin.quartz.jobSetup.test = { Scheduler scheduler, def ctx ->

	def trigger1 = new SimpleTriggerImpl(name:"trig1", startTime:new Date(),repeatInterval:1000, repeatCount:-1)
	ClosureJob.schedule(trigger1, [:]) {
		println "Closure job executed at : " + System.currentTimeMillis()
	}
}