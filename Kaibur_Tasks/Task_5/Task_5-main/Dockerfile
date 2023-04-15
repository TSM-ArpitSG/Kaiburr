# Use an OpenJDK 8 image as the base image
FROM openjdk:8

# Expose port 9090 to allow inbound traffic to the container
EXPOSE 9090

# Add the devops-integration.jar file from the target directory to the root directory of the container
ADD target/devops-integration.jar devops-integration.jar

# Define the entry point command that will be run when the container starts
ENTRYPOINT ["java","-jar","/devops-integration.jar"]

# Here as we set the final name as "devops-integration" this will be used to create our docker file.
# Code written by @Arpit Singh 19BCG10069