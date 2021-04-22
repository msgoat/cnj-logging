FROM docker.cloudtrain.aws.msgoat.eu/cloudtrain/at41-docker-jre11:3.0.0

LABEL maintainer="michael.theis@msg.group" \
        ${project.groupId}.${project.artifactId}.project="CloudTrain" \
        ${project.groupId}.${project.artifactId}.version="${project.version}" \
        ${project.groupId}.${project.artifactId}.description="${project.description}"

ENV JAVA_OPTS="" \
    DOCKER_JAVA_OPTS="" \
    PAYARA_JAVA_OPTS="" \
    PAYARA_ARGUMENTS="--disablephonehome --enablehealthcheck true --nocluster --nohostaware" \
    PAYARA_LOGGING_FORMAT="JSON"

RUN echo "adding run user payara to system" \
    && addgroup -S payara -g 1000 \
    && adduser -S payara -u 1000 -G payara

# copy build artifact into payara deployment folder
COPY *.jar /home/payara/
COPY docker-entrypoint.sh /home/payara/
COPY logging.properties /home/payara/

RUN chown -R payara:payara /home/payara \
    && chmod u+x /home/payara/docker-entrypoint.sh

# use user ID instead of user name to allow kubernetes to check non-root users
USER 1000

ENTRYPOINT ["/home/payara/docker-entrypoint.sh"]
CMD ["start"]