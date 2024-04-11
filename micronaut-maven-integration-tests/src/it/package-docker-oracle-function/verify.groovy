File log = new File(basedir, 'build.log')
assert log.exists()
assert log.text.contains("fnproject/fn-java-fdk:jre17-latest")
assert log.text.contains("Successfully tagged alvarosanchez/dockerfile-docker-oracle-function:0.1")
assert log.text.contains("ENTRYPOINT [\"java\", \"-XX:-UsePerfData\", \"-XX:+UseSerialGC\", \"-Xshare:auto\", \"-Djava.awt.headless=true\", \"-Djava.library.path=/function/runtime/lib\", \"-cp\", \"/function/app/classes:/function/app/libs/*:/function/app/resources:/function/runtime/*\", \"com.fnproject.fn.runtime.EntryPoint\"]")
assert log.text.contains("CMD [\"io.micronaut.oraclecloud.function.http.HttpFunction::handleRequest\"]")