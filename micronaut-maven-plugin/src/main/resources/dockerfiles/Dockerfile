ARG BASE_JAVA_IMAGE
FROM ${BASE_JAVA_IMAGE}
WORKDIR /home/app
COPY classes /home/app/classes
COPY dependency/* /home/app/libs/
EXPOSE ${PORTS}
ENTRYPOINT ["java", "-cp", "/home/app/libs/*:/home/app/classes/", "${CLASS_NAME}"]
