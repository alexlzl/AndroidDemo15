import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

public class CustomTask extends DefaultTask {

    @TaskAction
    void output() {
        println "传递参数param1 is ${project.pluginExt.param1}"
        println "传递参数param2 is ${project.pluginExt.param2}"
        println "传递参数param3 is ${project.pluginExt.param3}"
        println "传递参数nestparam1 is ${project.pluginExt.nestExt.nestParam1}"
        println "传递参数nestparam2 is ${project.pluginExt.nestExt.nestParam2}"
        println "传递参数nestparam3 is ${project.pluginExt.nestExt.nestParam3}"
    }
}