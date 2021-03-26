package castelles.com.github.pokedex.util

import android.content.Context
import android.content.Intent
import android.os.Process
import java.io.PrintWriter
import java.io.StringWriter
import javax.inject.Inject
import kotlin.system.exitProcess

class ExceptionHandler(
    private val myContext: Context
) : Thread.UncaughtExceptionHandler {

    override fun uncaughtException(thread: Thread, exception: Throwable) {
        val stackTrace = StringWriter()
        exception.printStackTrace(PrintWriter(stackTrace))

//        if (BuildConfig.ANALYTICS) {
//            Crashes.trackError(exception)
//        }

        System.err.println(stackTrace)
//        val intent = Intent(myContext, myActivityClass)
//        val s = stackTrace.toString()
//        intent.putExtra("uncaughtException", "Exception is: $stackTrace")
//        intent.putExtra("stacktrace", s)
//        myContext.startActivity(intent)

        Process.killProcess(Process.myPid())
        exitProcess(0)
    }
}