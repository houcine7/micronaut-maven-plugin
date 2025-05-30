File log = new File(basedir, 'build.log')
assert log.exists()
assert log.text.contains("BUILD SUCCESS") : "Build did not succeed"
assert log.text.contains("Starting Micronaut Test Resources service") : "Test Resources service was not started"
assert log.text.contains("Container postgres:latest started") : "postgres container was not started"
assert log.text.contains("Startup completed in") : "Startup was not completed"

String port = new File(basedir, "target/test-resources-port.txt").text
try (ServerSocket s = new ServerSocket(port as int)) {
    assert s != null
} catch (IOException e) {
    assert false
}

assert !new File(basedir, ".micronaut/test-resources/test-resources.properties").exists()