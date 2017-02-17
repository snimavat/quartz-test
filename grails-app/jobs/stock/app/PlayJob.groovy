package stock.app

class PlayJob {
    static triggers = {
      simple repeatInterval: 5000l // execute job once in 5 seconds
    }

    def execute() {
        println "Play Job executed at : " + System.currentTimeMillis()
    }
}
