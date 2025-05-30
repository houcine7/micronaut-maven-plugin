File log = new File(basedir, 'build.log')
assert log.exists()
assert log.text.contains("BUILD SUCCESS") : "Build did not succeed"
assert log.text.contains("Test Resources is configured in shared mode with the namespace: my-namespace") : "Test Resources was not configured in shared mode"
assert log.text.contains("Starting Micronaut Test Resources service") : "Test Resources service was not started"

String port = new File(basedir, "target/test-resources-port.txt").text
try (ServerSocket s = new ServerSocket(port as int)) {
    assert s != null
} catch (IOException e) {
    assert false
}

assert !new File(basedir, ".micronaut/test-resources/test-resources.properties").exists()
assert !new File(System.getProperty("user.home"), ".micronaut/test-resources-my-namespace/test-resources.properties").exists()