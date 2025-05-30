File mvnw = new File(basedir, '../../../mvnw')
assert mvnw.exists()

String localRepo = (basedir as File).toPath().resolve("../../../target/local-repo").toFile().absolutePath

def processBuilder = new ProcessBuilder(mvnw.absolutePath, "-ntp", "-q", "-Dmaven.repo.local=${localRepo}", "-Psetup",  "mn:start-testresources-service")
        .directory(basedir as File)
        .inheritIO()

Process p = processBuilder.start()
p.waitFor()

assert p.exitValue() == 0

def testResourcesProcess = ProcessHandle.allProcesses()
        .filter(process -> process.info().commandLine().map(c -> c.contains("TestResourcesService")).orElse(false))
        .findFirst();

if (testResourcesProcess.isPresent()) {
    testResourcesProcess.get().destroyForcibly();
} else {
    assert false : "Test Resources Service process not found"
}