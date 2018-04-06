# slfTest

The classes Main and Main Test only log some simple output:

        Logger logger = LoggerFactory.getLogger(Main.class);
        logger.info("Hello World");

Now `gradle run` works as expected, but `gradle test` gives a ClassCastException.

        $ gradle run -q
        [main] INFO slfTest.Main - Hello World
        $ gradle test -q
        java.lang.ClassCastException: org.slf4j.simple/org.slf4j.simple.SimpleLoggerFactory cannot be cast to org.gradle.internal.logging.slf4j.OutputEventListenerBackedLoggerContext
                at org.gradle.internal.logging.slf4j.Slf4jLoggingConfigurer.configure(Slf4jLoggingConfigurer.java:42)
                at org.gradle.internal.logging.config.LoggingSystemAdapter.startCapture(LoggingSystemAdapter.java:54)
                at org.gradle.internal.logging.services.DefaultLoggingManager$StartableLoggingSystem.start(DefaultLoggingManager.java:297)
                at org.gradle.internal.logging.services.DefaultLoggingManager.start(DefaultLoggingManager.java:73)
                at org.gradle.internal.logging.services.DefaultLoggingManager.start(DefaultLoggingManager.java:37)
                at org.gradle.process.internal.worker.child.SystemApplicationClassLoaderWorker.call(SystemApplicationClassLoaderWorker.java:83)
                at org.gradle.process.internal.worker.child.SystemApplicationClassLoaderWorker.call(SystemApplicationClassLoaderWorker.java:64)
                at worker.org.gradle.process.internal.worker.GradleWorkerMain.run(GradleWorkerMain.java:62)
                at worker.org.gradle.process.internal.worker.GradleWorkerMain.main(GradleWorkerMain.java:67)

Removing the java 9 module makes things work again. Therfore I assume there is module access problem. - What is the right way to fix it?
